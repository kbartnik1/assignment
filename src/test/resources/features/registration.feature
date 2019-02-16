Feature: Gabi registration

  Background:
    Given User entered application URL

  @d
  Scenario: Registration on Gabi.com while having concurrent auto insurance policy
    And He selected his current insurer as Progressive
    And He "read" Terms of Service and Privacy Policy
    When He finishes inputting his personal information
      | Name | Last Name | Birthday   | Home Address                          | Apartment Number | Email Address        | Phone Number |
      | John | Doe       | 02.29.2000 | Drive Thru Tree Rd, Leggett, CA 95585 | 11               | rugu@netmail-pro.com | 5555555555   |
    Then He is asked to provide verification code

  Scenario: Registration on Gabi.com without any current auto insurance policy
    And He selected that he does not have current auto insurance policy
    And He "read" Terms of Service and Privacy Policy
    When He finishes inputting his personal information
      | Name | Last Name | Birthday   | Home Address                          | Apartment Number | Email Address        | Phone Number |
      | John | Doe       | 02.29.2000 | Drive Thru Tree Rd, Leggett, CA 95585 | 11               | rugu@netmail-pro.com | 5555555555   |
    Then He is asked to provide verification code

  Scenario: Registration on Gabi.com for user with spaces in the Name and Last Name
    And He selected his current insurer as Progressive
    And He "read" Terms of Service and Privacy Policy
    When He inputs his Name and Last Name with spaces
      | Name     | Last Name |
      | spa ce y | k3 vin    |
    Then His Name should not contain any spaces, but his last name should remain the same
    When He finishes inputting his personal information
      | Birthday   | Home Address                          | Apartment Number | Email Address        | Phone Number |
      | 02.29.2000 | Drive Thru Tree Rd, Leggett, CA 95585 | 11               | rugu@netmail-pro.com | 5555555555   |
    Then He is asked to provide verification code