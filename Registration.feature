Feature: Pet Store Testing

  Background:
    Given User in login Page

  @Registration
  Scenario Outline: User registration
    Given I am on the registration page
    When I enter valid user Information '<userId>' '<New password>' '<Repeat password>'
    And I enter valid Account Information '<First name>' '<Last name>' '<Email>' '<Phone>' '<Address 1>' '<Address 2>' '<City>' '<Zip>' '<Country>' '<State>'
    And Profile Information
    Then I should be registered successfully

    Examples:
      | userId | New password | Repeat password | First name | Last name | Email          | Phone      | Address 1 | Address 2   | City | Zip   | Country | State |
      | test   | tata@12345   | tata@12345      | testing    | testing   | test@yahoo.com | 6553638898 | random123 | random12345 | New  | 45040 | US      | Mason |

  @Login
  Scenario: Valid login
    When I enter the following credentials:
      | Username | Password |
      | test   | tata@12345  |
    And I click the login button

