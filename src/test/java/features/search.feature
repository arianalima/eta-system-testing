@eta
Feature: Search products

  Background: The user sees the search field

  Scenario Outline: Check that searched books shown are related to the term
    Given The "Livros" category is selected
    When  The user search for some "<term>"
    Then  The results shown are related to the "<term>"
    Examples:
      | term      |
      | família   |
      | Sheldon   |
      | Star Wars |
