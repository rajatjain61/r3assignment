package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class USDPriceSteps {

    private Response response;

    @Given("API is available")
    public void apiIsAvailable() {
        RestAssured.baseURI = "https://open.er-api.com";
    }

    @When("I make a GET request to the USD rates API")
    public void makeGETRequestToUSDRatesAPI() {
        RequestSpecification request = RestAssured.given();
        response = request.get("/v6/latest/USD");
    }

    @Then("the status code should be {int}")
    public void verifyStatusCode(int expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
    }

    @Then("the API response should contain valid prices")
    public void verifyValidPrices() {
        // Implement validation logic for valid prices
    }

    @Then("the price against AED should be within {double} and {double}")
    public void verifyPriceAgainstAED(double lowerBound, double upperBound) {
        // Implement validation logic for price against AED
    }

    @Then("the response time should be greater than or equal to {int} seconds")
    public void verifyResponseTime(int expectedResponseTime) {
        response.then().time(lessThanOrEqualTo(expectedResponseTime * 1000L));
    }

    @Then("the API response should contain {int} currency pairs")
    public void verifyCurrencyPairsCount(int expectedPairsCount) {
        // Implement validation logic for currency pairs count
    }

    @Then("the API response should match the JSON schema")
    public void verifyJSONSchema() {
        // Implement JSON schema validation logic
    }
}
