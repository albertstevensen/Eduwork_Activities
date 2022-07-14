Feature: Search Feature

    As a guest
    I want to search article with search box

    Scenario: Search article use search box
    Given I should open zero bank homepage
    When I input data and submit in searchbox
    Then I should have a result search