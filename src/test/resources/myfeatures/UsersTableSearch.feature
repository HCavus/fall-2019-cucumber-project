@show_records @smoke @regression @lib-7031
Feature: User table search and sort

  Background:
    Given  I am on the login page
    And I login as a librarian
    And I click on "Users" link


  Scenario: Search by valid email
    When I search for any valid email
    Then the users table must display 1 records

#  Scenario: Search by invalid email
#    When I search for any invalid email
#    Then the users table must display message "No data available in table"

#  Scenario: default sort User Management
#    Then users table should be sorted by "User ID" in "descending" order
#    When I click on the "User ID" column
#    Then users table should be sorted by "User ID" in "ascending" order
#    When I click on the "Email" column
#    Then users table should be sorted by "User ID" in "descending" order
#    When I click on the "Email" column
#    Then users table should be sorted by "User ID" in "descending" order
  @hi
  Scenario: Duplicate email test
    When I click on Add User
    And I save new user information with random email
    And I click on Add User
    When I try to add new with the same email
    Then Add User dialog should still be open
    And error message "Please enter a valid email address." should display