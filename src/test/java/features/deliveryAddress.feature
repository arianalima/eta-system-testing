@eta
Feature: Delivery Address

  Scenario Outline: Check that invalid codes are not accepted
    Given The popup to choose the address is open
    And   The user inserts some "<zipCode part 1>" "<zipCode part 2>"
    When  The user sends the information
    Then  An error is shown
    Examples:
      | zipCode part 1 | zipCode part 2 |
      |     00000      |      000       |
      |     abcde      |      fgh       |
      |     *&#()      |      +=e       |
      |     00000      |                |
      |                |      000       |
      |                |                |
