package stepDefinitions.REST;

import com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.io.IOException;

import static org.hamcrest.Matchers.*;
import static utilities.JsonFileReader.getJsonData;

public class CharacterStep {

    private Response response;
    private RequestSpecification request;
    private static final String BASE_URI = "https://rickandmortyapi.com/";
    private static final String BASE_PATH = "api/character/";
    private final String jsonDataPath = "src/test/resources/data/REST/Character.json";
    JsonNode expectedInfo = getJsonData(jsonDataPath).get("info");

    public CharacterStep() throws IOException {
    }

    @Given("I set a basic request to character")
    public void setCharacterRequest() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = BASE_PATH;
        request = RestAssured.given();
        request.log().all();
        request.header("Content-Type", "application/json");
    }

    @Given("^I filter with (.+) and (.+)$")
    public void filterCharacterRequest(String param, String value) {
        request.queryParam(param, value);
    }

    @When("I get the results")
    public void sendGetRequest() {
        response = request.get();
    }

    @Then("I should receive a json response with first page characters")
    public void receiveValidResponse(){
        response.then().log().all();
        response.then().statusCode(200);
        response.then().time(lessThan(1000L));
        response.then().body("info.count", equalTo(expectedInfo.get("count").asInt()));
        response.then().body("info.pages", equalTo(expectedInfo.get("pages").asInt()));
        response.then().body("info.next", equalTo(expectedInfo.get("next").asText()));
        response.then().body("info.prev", nullValue());
    }

    @Then("^I should receive a json response with (.+) and (.+) characters$")
    public void receiveFilteredResponse(String param, String value){
        response.then().log().all();
        response.then().statusCode(200);
        response.then().time(lessThan(1000L));
        response.then().body("results[0]."+param, equalTo(value));
    }

    @Then("I should receive a 404 Not Found error")
    public void receive404Response(){
        response.then().log().all();
        response.then().statusCode(404);
        response.then().time(lessThan(1000L));
        response.then().body("error", equalTo("There is nothing here"));
    }
}
