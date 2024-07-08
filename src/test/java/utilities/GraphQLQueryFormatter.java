package utilities;

public class GraphQLQueryFormatter {

    /**
     * Formats a GraphQL query string into a JSON format suitable for HTTP POST requests.
     *
     * @param graphqlQuery The GraphQL query string to format.
     * @return The formatted JSON string representing the GraphQL query.
     */
    public static String formatGraphQLQuery(String graphqlQuery) {
        // Escape double quotes and format newlines and spaces
        String escapedQuery = graphqlQuery
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "")
                .replace("\t", "\\t");

        // Surround the query with quotes
        return "{\"query\":\"" + escapedQuery + "\"}\n";
    }

    public static void main(String[] args) {
        // Example usage:
        String graphqlQuery = "{ characters(page: 1, filter: {name: \"rick\"}) { info { count pages } results { name } } }";
        String formattedQuery = formatGraphQLQuery(graphqlQuery);

        // Print formatted GraphQL query
        System.out.println("Formatted GraphQL Query:");
        System.out.println(formattedQuery);
    }
}
