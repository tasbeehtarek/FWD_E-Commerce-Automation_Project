@smoke
  Feature: F01_Register | users could register


    Scenario: Register with valid data
      Given user navigate to home page
      When user clicks register
      And user selects "female" "bebo" as firstname and "tester" as lastname
      And user fills gender"female" fname"Bebo" lname"Tarek" day"1" month"6" year"1999" email"test1999@gmail.com" valid data
      And user fills valid password "p@ssw0rd" confirm "p@ssw0rd"
      And  user clicks register button
      Then success message is displayed

