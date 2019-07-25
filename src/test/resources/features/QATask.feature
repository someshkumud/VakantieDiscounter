Feature: QA Task Feature
#  This feature deals with the assigned QA Task on the VakantieDiscounter application

  Scenario: Perform QA Task as instructed
    Given Launch browser and navigate to Homepage
    And Navigate to Sun Vertical page
    And Search Holiday
    And Filter search result
    And Select package available at index 1
    And Navigate to Check Price page
    And Enter Traveler Details
    And Confirm application details
    And Move to Step 3
    Then Final price matches with price on checkout screen