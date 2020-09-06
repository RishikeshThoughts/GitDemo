Feature: Contact Us using submit form

Scenario: To contact using submit form

      Given  I access contact page url
      And    I enter first name
      And    I enter last name
      And    I enter valid email
      And    I enter comments 
      When   I click on Submit
      Then   Form should be submitted successfully