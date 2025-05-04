import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import com.example.Banque;
import com.example.De;
import com.example.DebitImpossibleException;
import com.example.Jeu;
import com.example.JeuFermeException;
import com.example.Joueur;

@RunWith(MockitoJUnitRunner.class)
public class JeuTest {

    @Mock
    private Banque banqueMock;
    
    @Mock
    private Joueur joueurMock;
    
    @Mock
    private De de1Mock;
    
    @Mock
    private De de2Mock;
    
    @Test(expected = JeuFermeException.class)
    public void testJouerQuandJeuFerme() throws JeuFermeException {
        // Test du cas où le jeu est fermé
        Jeu jeu = new Jeu(banqueMock);
        jeu.fermer();
        
        // Jouer devrait lever une exception JeuFermeException
        jeu.jouer(joueurMock, de1Mock, de2Mock);
    }
    
    @Test
    public void testJouerQuandJoueurInsolvable() throws JeuFermeException, DebitImpossibleException {
        // Test du cas où le joueur est insolvable
        Jeu jeu = new Jeu(banqueMock);
        
        // Configuration du joueur pour qu'il lève une exception lors du débit
        when(joueurMock.mise()).thenReturn(100);
        doThrow(new DebitImpossibleException("Insolvable")).when(joueurMock).debiter(100);
        
        // Jouer ne devrait pas lever d'exception et ne pas utiliser les dés
        jeu.jouer(joueurMock, de1Mock, de2Mock);
        
        // Vérification que les dés n'ont pas été lancés
        verify(de1Mock, never()).lancer();
        verify(de2Mock, never()).lancer();
    }
    
    @Test
    public void testJouerQuandJoueurPerd() throws JeuFermeException, DebitImpossibleException {
        // Test du cas où le joueur perd (somme != 7)
        Jeu jeu = new Jeu(banqueMock);
        
        // Configuration du joueur
        when(joueurMock.mise()).thenReturn(100);
        doNothing().when(joueurMock).debiter(100);
        
        // Configuration des dés pour obtenir une somme différente de 7
        when(de1Mock.lancer()).thenReturn(2);
        when(de2Mock.lancer()).thenReturn(2); // somme = 4
        
        // Jouer
        jeu.jouer(joueurMock, de1Mock, de2Mock);
        
        // Vérification des interactions
        verify(joueurMock).mise();
        verify(joueurMock).debiter(100);
        verify(banqueMock).crediter(100);
        verify(de1Mock).lancer();
        verify(de2Mock).lancer();
        
        // Vérification qu'aucune autre interaction n'a eu lieu
        verify(joueurMock, never()).crediter(anyInt());
        verify(banqueMock, never()).debiter(anyInt());
        verify(banqueMock, never()).est_solvable();
    }
    
    @Test
    public void testJouerQuandJoueurGagne() throws JeuFermeException, DebitImpossibleException {
        // Test du cas où le joueur gagne (somme = 7) et banque reste solvable
        Jeu jeu = new Jeu(banqueMock);
        
        // Configuration du joueur
        when(joueurMock.mise()).thenReturn(100);
        doNothing().when(joueurMock).debiter(100);
        
        // Configuration des dés pour obtenir une somme de 7
        when(de1Mock.lancer()).thenReturn(3);
        when(de2Mock.lancer()).thenReturn(4); // somme = 7
        
        // Configuration de la banque
        when(banqueMock.est_solvable()).thenReturn(true);
        
        // Jouer
        jeu.jouer(joueurMock, de1Mock, de2Mock);
        
        // Vérification des interactions
        verify(joueurMock).mise();
        verify(joueurMock).debiter(100);
        verify(banqueMock).crediter(100);
        verify(de1Mock).lancer();
        verify(de2Mock).lancer();
        verify(joueurMock).crediter(200); // 2 fois la mise
        verify(banqueMock).debiter(200);
        verify(banqueMock).est_solvable();
    }
    
    @Test
    public void testJouerQuandJoueurGagneEtBanqueDevientInsolvable() throws JeuFermeException, DebitImpossibleException {
        // Test du cas où le joueur gagne et la banque devient insolvable
        Jeu jeu = new Jeu(banqueMock);
        
        // Configuration du joueur
        when(joueurMock.mise()).thenReturn(100);
        doNothing().when(joueurMock).debiter(100);
        
        // Configuration des dés pour obtenir une somme de 7
        when(de1Mock.lancer()).thenReturn(3);
        when(de2Mock.lancer()).thenReturn(4); // somme = 7
        
        // Configuration de la banque pour qu'elle ne soit plus solvable après le paiement
        when(banqueMock.est_solvable()).thenReturn(false);
        
        // Jouer
        jeu.jouer(joueurMock, de1Mock, de2Mock);
        
        // Vérification des interactions
        verify(joueurMock).mise();
        verify(joueurMock).debiter(100);
        verify(banqueMock).crediter(100);
        verify(de1Mock).lancer();
        verify(de2Mock).lancer();
        verify(joueurMock).crediter(200);
        verify(banqueMock).debiter(200);
        verify(banqueMock).est_solvable();
        
        // Vérifier que le jeu est maintenant fermé
        assertFalse(jeu.estOuvert());
    }
} 