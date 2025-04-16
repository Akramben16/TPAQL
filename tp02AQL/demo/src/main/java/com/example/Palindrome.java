package com.example;

/**
 * Classe utilitaire pour vérifier si une chaîne est un palindrome.
 * Un palindrome est une chaîne qui se lit de la même manière de gauche à droite et de droite à gauche,
 * en ignorant la casse, les espaces et la ponctuation.
 * 
 * Exemples de palindromes valides :
 * - "kayak"
 * - "Racecar"
 * - "A man, a plan, a canal: Panama"
 * - "Esope reste ici et se repose"
 */
public class Palindrome {
    /**
     * Vérifie si la chaîne donnée est un palindrome.
     * La vérification ignore la casse, les espaces et la ponctuation.
     * 
     * @param s La chaîne à vérifier
     * @return true si la chaîne est un palindrome, false sinon
     * @throws NullPointerException si la chaîne est null
     */
    public static boolean isPalindrome(String s) {
        if (s == null) {
            throw new NullPointerException("String must not be null");
        }
        
        // Convertir en minuscules et ne garder que les caractères alphanumériques
        String cleaned = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        
        int i = 0;
        int j = cleaned.length() - 1;
        while (i < j) {
            if (cleaned.charAt(i) != cleaned.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
