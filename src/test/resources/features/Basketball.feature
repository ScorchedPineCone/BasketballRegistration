Feature: Account registration on "https://www.basketballengland.co.uk/"

  Scenario: Successful registration on "https://membership.basketballengland.co.uk/NewSupporterAccount"
    Given I am on the registration page
    When I fill in the registration form with valid details
    And I agree to the terms and conditions
    And I submit the registration form
    Then I should see a success message

  Scenario: Registration without lastname on "https://membership.basketballengland.co.uk/NewSupporterAccount"
    Given I am on the registration page
    When I fill in the registration form without a last name
    And I agree to the terms and conditions
    And I submit the registration form
    Then I should see a error message for missing last name

  Scenario: Registration without crossing all necessary checkboxes on "https://membership.basketballengland.co.uk/NewSupporterAccount"
    Given I am on the registration page
    When I fill in the registration form with valid details
    And I agree to most terms and conditions but leave one box unchecked
    And I submit the registration form
    Then I should see a error message for missing terms and conditions

  Scenario: Registration without matching password on "https://membership.basketballengland.co.uk/NewSupporterAccount"
    Given I am on the registration page
    When I fill in the registration form but my password is mismatched
    And I agree to the terms and conditions
    And I submit the registration form
    Then I should see a error message about mismatched password

