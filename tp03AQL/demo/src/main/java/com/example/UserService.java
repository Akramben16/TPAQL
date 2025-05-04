package com.example;

public class UserService {
    private final UtilisateurApi utilisateurApi;
    
    public UserService(UtilisateurApi utilisateurApi) {
        this.utilisateurApi = utilisateurApi;
    }
    
    public void creerUtilisateur(Utilisateur utilisateur) throws ServiceException {
        if (isValidUtilisateur(utilisateur)) {
            int id = utilisateurApi.creerUtilisateur(utilisateur);
            utilisateur.setId(id);
        } else {
            throw new ServiceException("Données utilisateur invalides");
        }
    }
    
    private boolean isValidUtilisateur(Utilisateur utilisateur) {
        return utilisateur != null && 
               utilisateur.getNom() != null && !utilisateur.getNom().isEmpty() &&
               utilisateur.getPrenom() != null && !utilisateur.getPrenom().isEmpty() &&
               utilisateur.getEmail() != null && !utilisateur.getEmail().isEmpty();
    }
}