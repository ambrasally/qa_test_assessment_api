package stepDefinitions.GraphQL;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.empty;
import static utilities.GraphQLQueryFormatter.formatGraphQLQuery;

public class CharacterStep {

    private Response response;
    private RequestSpecification request;
    private static final String graphqlEndpoint = "https://rickandmortyapi.com/graphql";
    private final String queryDataPath = "src/test/resources/data/GraphQL/characterQuery.graphql";
    String query = new String(Files.readAllBytes(Paths.get(queryDataPath)));
    String formattedQuery = formatGraphQLQuery(query);

    public CharacterStep() throws IOException {
    }

    @Given("I have a GraphQL query for characters")
    public void setGraphQLQuery() {
        RestAssured.baseURI = graphqlEndpoint;
        request = RestAssured.given();
        request.log().all();
        request.header("Content-Type", "application/json");
        request.body(formattedQuery);
    }

    @When("I send the query to the Rick and Morty GraphQL API")
    public void sendQueryToAPI() {
        response = request.post();
    }

    @Then("I receive a response containing character details")
    public void verifyResponse() {
        response.then().log().all();
        response.then().statusCode(200);
        response.then().time(lessThan(1000L));
        response.then().body("data.characters.results", not(empty()));
        response.then().body("data.characters.results[0].name", containsString("Rick"));
    }
}
