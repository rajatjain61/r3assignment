Feature: Fetch USD rates against multiple currencies

  Scenario: Verify successful API call and valid price
    Given API is available
    When I make a GET request to the USD rates API
    Then the status code should be 200
    And the API response should contain valid prices

  Scenario: Verify USD price against AED is within range
    Given API is available
    When I make a GET request to the USD rates API
    Then the price against AED should be within 3.6 and 3.7

  Scenario: Verify API response time
    Given API is available
    When I make a GET request to the USD rates API
    Then the response time should be greater than or equal to 3 seconds

  Scenario: Verify 162 currency pairs are returned
    Given API is available
    When I make a GET request to the USD rates API
    Then the API response should contain 162 currency pairs

  Scenario: Verify API response matches JSON schema
    Given API is available
    When I make a GET request to the USD rates API
    Then the API response should match the JSON schema
