@ProductSearch
Feature: Search product and place order for product

  Scenario Outline: Search for product on both home and offer page for Tomato
    Given User is on Greencart landing page
    When User Searched product with shortform as <Name> and capture actual name of product
    Then User searched product with shortform as <Name> on offer page to check existance of product

    Examples: 
      | Name |
      | Tom  |

  Scenario Outline: Search for product on both home and offer page for Brocoli
    Given User is on Greencart landing page
    When User Searched product with shortform as <Name> and capture actual name of product
    Then User searched product with shortform as <Name> on offer page to check existance of product

    Examples: 
      | Name |
      | Broc |

  Scenario Outline: Search for product on both home and offer page for Beetroot
    Given User is on Greencart landing page
    When User Searched product with shortform as <Name> and capture actual name of product
    Then User searched product with shortform as <Name> on offer page to check existance of product

    Examples: 
      | Name |
      | Beet |
