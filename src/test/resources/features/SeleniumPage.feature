@Navigation
Feature: Testing Selenium Website

    Practicing some functionalities in Selenium Website

    Scenario Outline: I can access the subpages through the navigation bar
        Given I go to selenium Website
        And I click on <section>
        Then link of <section> shall be correct
        Examples:
            | section       | 
            | downloads     |
            | documentation |

    
    Scenario Outline: I can access in options from About menu
        Given I go to selenium Website
        And I click on about <about>
        Then I see the correct <url>
        Examples:
            |about                      |   url         |
            |"About Selenium"           |   about       |
            |"Structure and Governance" |   project     |
            |"Events"                   |   events      |
            |"Ecosystem"                |   ecosystem   |
            |"History"                  |   history     |
            |"Get Involved"             |   getinvolved |
            |"Sponsors"                 |   sponsors    |
            |"Sponsor Us"               |   sponsor     |


    Scenario: I can see LinkedIn page from Join us link
        Given I go to selenium Website
        And I click Join us link
        Then I can see linked logo 


    Scenario: I can see Webdriver page when I click in link
        Given I go to selenium Website
        And I click in read me link
        Then I can see Webdriver page
