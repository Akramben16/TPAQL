import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

import com.example.UserService;
import com.example.Utilisateur;
import com.example.UtilisateurApi;
import com.example.ServiceException;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceScenarioTest {

    @Mock
    private UtilisateurApi utilisateurApiMock;

    @Test(expected = ServiceException.class)
    public void testCreateUserWithApiException() throws ServiceException {
        // Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");

        // Configuration du mock pour lever une exception
        when(utilisateurApiMock.creerUtilisateur(utilisateur))
            .thenThrow(new ServiceException("Echec de la création de l'utilisateur"));

        // Création du service avec le mock
        UserService userService = new UserService(utilisateurApiMock);

        // Appel de la méthode à tester - devrait lever une exception
        userService.creerUtilisateur(utilisateur);
    }

    @Test
    public void testCreateUserWithValidationError() throws ServiceException {
        // Création d'un utilisateur avec des données invalides (on passe un null)
        Utilisateur utilisateur = new Utilisateur(null, "Dupont", "jeandupont@email.com");

        // Création du service avec le mock
        UserService userService = new UserService(utilisateurApiMock);

        try {
            // Appel de la méthode à tester
            userService.creerUtilisateur(utilisateur);
            fail("Une exception ServiceException aurait dû être levée");
        } catch (ServiceException e) {
            // Vérification que l'API n'a jamais été appelée
            verify(utilisateurApiMock, never()).creerUtilisateur(any(Utilisateur.class));
        }
    }

    @Test
    public void testUserIdAfterCreation() throws ServiceException {
        // Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");

        // Définition d'un ID fictif
        int idUtilisateur = 123;
        
        // Configuration du mock pour renvoyer l'ID
        when(utilisateurApiMock.creerUtilisateur(utilisateur)).thenReturn(idUtilisateur);

        // Création du service avec le mock
        UserService userService = new UserService(utilisateurApiMock);
        
        // Appel de la méthode à tester
        userService.creerUtilisateur(utilisateur);
        
        // Vérification de l'ID de l'utilisateur
        assertEquals(idUtilisateur, utilisateur.getId());
    }

    @Test
    public void testArgumentCapture() throws ServiceException {
        // Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");

        // Création du captureur d'arguments
        ArgumentCaptor<Utilisateur> argumentCaptor = ArgumentCaptor.forClass(Utilisateur.class);
        
        // Configuration du mock
        when(utilisateurApiMock.creerUtilisateur(any(Utilisateur.class))).thenReturn(123);

        // Création du service avec le mock
        UserService userService = new UserService(utilisateurApiMock);
        
        // Appel de la méthode à tester
        userService.creerUtilisateur(utilisateur);
        
        // Capture et vérification des arguments
        verify(utilisateurApiMock).creerUtilisateur(argumentCaptor.capture());
        Utilisateur utilisateurCapture = argumentCaptor.getValue();
        
        // Vérification des arguments capturés
        assertEquals("Jean", utilisateurCapture.getPrenom());
        assertEquals("Dupont", utilisateurCapture.getNom());
        assertEquals("jeandupont@email.com", utilisateurCapture.getEmail());
    }
} 