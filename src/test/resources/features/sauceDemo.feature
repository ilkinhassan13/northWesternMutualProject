@sauceDemo
Feature: Saucedemo NM Regression test

  @login
  Scenario: Login Validation
    Given User is on Saucedemo LoginPage
    When User types "Username" in the username field
    And User types "Password" on the password field
    And User click the Login button
    Then User should be able to see Products on main page of SauceDemo


  @sortItems
   Scenario: Sorting items on the Saucedemo MainPage
    Given User is on Saucedemo Mainpage
    When User sort the item from low to high price
    Then User should be able to see Products in the sorted order

    @addItemsToShoppingCart
   Scenario: Adding items To the Cart and Assertion of the list of Items
    Given User is on Saucedemo Mainpage
    When User adds the items to the cart
    Then User should be able to see all the added items on the cart

  @shoppingCartRemove

   Scenario: Removing items from Cart and continue to shopping
     Given User on cart page
     When User removes all items from the cart
     And User clicks on continue shopping
     Then User should appear on a main page

   @addingItemAndCheckout
   Scenario: Adding an item to the cart and checking out
     Given User on a main page
     When User adds an item and  clicks on add to cart
     And User clicks on cart and User appears on cart page
     Then User click on checkout button

   @payment
   Scenario: Filling out customers info and payment
     Given User on Your Information page
     When User filles up all info and clicks on continue button
     Then Item name and total price should match with chosen item
     Then User should be navigated to the new page with confirmation






