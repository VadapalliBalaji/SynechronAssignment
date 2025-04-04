Feature: Amex UI checkpoints

Scenario: E2E vaidation
Given I navigate to amex home page
When I accept the cookie
Then I validate the title of "American Express FR : Cartes de Paiement & Services Privilégiés"
When I click on the Cartes Particuliers to get the card details
When I accept the cookie
Then I validate the title of "Particuliers: Toutes les Cartes American Express | Amex FR"
And I click on En Savior Plus under Cartes Gold American Express
And I click on Demandez Votre Carte
Then I validate the title of ""
When I fill the  Fill junk data
And I click on Sauvegarder et Continuer