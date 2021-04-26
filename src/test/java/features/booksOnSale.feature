@eta
Feature: Books on sale

  Scenario Outline: Check that departments inside "Livros em oferta" have a reduced price for the books
    Given The user access the "Livros" submenu "Livros em oferta"
    When  "<name>" department is chosen
    Then  The books shown have a reduced price
    Examples:
    | name     |
    | Ciências |
    | Romance  |
