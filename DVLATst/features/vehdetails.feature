Feature: Test DVLA vehicle information 
   Scenario: check information of registered vehicles
     Given Open FireFox and open the DVLA get vehicle information page
     When I enter valid vehicle registration number
     Then user should be able to vehicle details
     Then user should be able to validate the color of the vehicle