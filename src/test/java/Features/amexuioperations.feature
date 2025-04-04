Feature: Amex UI checkpoints

Scenario: E2E vaidation
Given I navigate to amex home page
When I accept the cookie
Then I validate the title of "American Express FR : Cartes de Paiement & Services Privilégiés"
And I click on the "Cartes Particuliers"
When I accept the cookie
Then I validate the title of "Particuliers: Toutes les Cartes American Express | Amex FR"
When I click on the "En Savior Plus"
When I accept the cookie
Then I validate the title of "Gold American Express: La Carte à la Hauteur de Votre Quotidien"
When I click on the "Demandez votre Carte"
When I accept the cookie
Then I validate the title of "American Express - CARTE GOLD AMERICAN EXPRESS"
When I fill the form with valid values:
      | Field    | Value         |
      | Civilite | MR            |
      | Prenom   | John          |
      | Nom      | 123           |
      | Date     | 11/09/1990    |
      |Telephone |  0619862981   |
 When I click on the "Sauvegarder et Continuer"
 Then I validate the errors messages in UI
       | Field    | ErrorMessage         |
       | NomError | Nom obligatoire.     |
       |Adresse   |Merci de vérifier le format de votre adresse email (exemple : nom@domaine.fr). Les caractères autorisés sont : lettres, chiffres, tirets (_-), arobase (@), et point (.). |
       |overall   |Veuillez corriger les erreurs ci-dessus pour continuer. |
 