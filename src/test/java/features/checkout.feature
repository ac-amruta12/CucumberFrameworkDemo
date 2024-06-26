@Checkout
Feature: Place order for Product and verify details on checkout

  Scenario Outline: Place order for product and verify checkout details
    Given User is on Greencart landing page
    When User Searched product with shortform as <Name> and capture actual name of product
    And User provided product quantity 5 and Added product to cart
    And User proceed to checkout
    Then User verified product name and quantity on checkout
    And User verified that Apply and Place Order buttons are visible on checkout

    Examples: 
      | Name |
      | Tom  |