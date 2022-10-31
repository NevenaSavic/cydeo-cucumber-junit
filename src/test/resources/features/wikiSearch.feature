Feature: Wikipedia search functionality and verification

  Scenario: Wikipedia Search Functionality Title Verification
  Given User is on Wikipedia home page
  When User types "Steve Jobs" in the wiki search box
  And User clicks wiki search button
  Then User sees "Steve Jobs" is in the wiki title


  Scenario: Wikipedia Search Functionality Header Verification
  Given User is on Wikipedia home page
  Then User types "Steve Jobs" in the wiki search box
  And User clicks wiki search button
  Then User sees "Steve Jobs" is in the main header

  Scenario Outline: Wikipedia Search Functionality Title Verification
    Given User is on Wikipedia home page
    When User types "<searchValue>" in the wiki search box
    And User clicks wiki search button
    Then User sees "<expectedTitle>" is in the wiki title
    Then User sees "<expectedMainHeader>" is in the main header


    #mora da se doda ovo examples za scenario outline
  Examples: search a value we will be using in this scenario is as below
    |searchValue|expectedTitle|expectedMainHeader|
    |Nena       |Nena         |Nena              |
    |Nemanja    |Nemanja      |Nemanja           |
    |Sofija     |Sofija       |Sofija            |
    |Nebojsa    |Nebojsa      |Nebojsa           |


