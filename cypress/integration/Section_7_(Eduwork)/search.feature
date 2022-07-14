Feature: Search Feature

    As a guest 
    I want search using Searchbox

    Scenario: search with searchbox
    Given I open homepage
    When I submit keyword from searchbox
    Then I should have search result

