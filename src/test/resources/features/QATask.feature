Feature: QA Task Feature
#  This feature deals with the assigned QA Task on the Caspar application

  Scenario: Perform QA Task as instructed
    Given Launch browser and navigate to Homepage
    And navigate to Sun Vertical page
    And set "destination" as "Spanje"
    And set "travelDate" as "05/02/2019"
    And set "duration" as "11-16 dagen"
    And set "adultTravelers" as "2"
#    And set "childerenTravelers" as "1"
    And Search Holiday
  And Filter search result
  And Select package available at index 1
  And Navigate to Check Price page
  And Enter Traveler Details
  And Confirm application details
  And Move to Step 3
#    And verify visibility of terms and conditions page and close it

