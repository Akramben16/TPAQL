# Incohérence dans les tests de la classe Palindrome

## Problème
Il existe une incohérence dans les tests de la classe `Palindrome` concernant le traitement des espaces, de la ponctuation et de la casse. Les tests attendent des comportements contradictoires :

1. Dans `BranchCoverageTest` :
   - `testPalindromeWithSpaces` attend `true` pour "Esope reste ici et se repose"
   - `testPalindromeWithPunctuation` attend `true` pour "A man, a plan, a canal: Panama"

2. Dans `LineCoverageTest` :
   - `testPalindromeWithSpaces` attend `false` pour "Was it a car or a cat I saw"
   - `testPalindromeWithPunctuation` attend `false` pour "A man, a plan, a canal: Panama"

3. Dans `ConditionCoverageTest` :
   - `testValidPalindromeWithSpaces` attend `true` pour "race car"
   - `testLongInvalidPalindrome` attend `false` pour "A man, a plan, a canal: Panama"

## Solutions proposées

### Option 1 : Version stricte
- Rejette les espaces et la ponctuation
- Respecte la casse
- Avantages :
  - Comportement plus prévisible
  - Plus facile à tester
  - Plus proche de la définition mathématique d'un palindrome
- Inconvénients :
  - Moins pratique pour les cas d'usage réels
  - Ne reconnaît pas les palindromes classiques comme "A man, a plan, a canal: Panama"

### Option 2 : Version souple (CHOISIE)
- Accepte les espaces et la ponctuation
- Ignore la casse
- Avantages :
  - Plus pratique pour les cas d'usage réels
  - Reconnaît les palindromes classiques
  - Plus proche de l'usage courant du terme "palindrome"
- Inconvénients :
  - Comportement moins prévisible
  - Plus difficile à tester
  - Moins proche de la définition mathématique

## Action requise
1. [x] Décider quelle version est la plus appropriée pour le projet
2. [x] Mettre à jour tous les tests pour qu'ils soient cohérents avec la version choisie
3. [x] Documenter clairement le comportement attendu dans la Javadoc de la classe

## Impact
- [x] Modification de la classe `Palindrome`
- [x] Mise à jour des tests dans :
  - [x] `BranchCoverageTest`
  - [x] `LineCoverageTest`
  - [x] `ConditionCoverageTest`
- [x] Mise à jour de la documentation

## Décision prise
[x] Version souple
[ ] Version stricte

## Résolution
La version souple a été choisie car elle est plus pratique pour les cas d'usage réels et reconnaît les palindromes classiques. Tous les tests ont été mis à jour pour être cohérents avec cette version, et la documentation a été ajoutée à la classe `Palindrome`. 