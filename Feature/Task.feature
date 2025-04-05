Feature: Add Product To The Cart
  User Should Be Able To Add Product To The Cart

  Scenario: User Should Be Able To Add Product To The Cart
    Given Choose devices from top
    And Click smartfons from no subscription label
    And Click second element from list
    When Add product to the cart
    Then Back to home page
