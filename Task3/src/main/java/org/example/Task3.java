package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class Task3 {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {


//        String valuesPath = "/Users/eugenekartashov/IdeaProjects/Tasks/Task3/src/main/java/org/example/values.json";
//        String testsPath = "/Users/eugenekartashov/IdeaProjects/Tasks/Task3/src/main/java/org/example/tests.json";
//       String reportPath = "/Users/eugenekartashov/IdeaProjects/Tasks/Task3/src/main/java/org/example/report.json";
        String valuesPath = args[0];  // Путь к файлу values.json
        String testsPath = args[1];   // Путь к файлу tests.json
        String reportPath = args[2];

        try {
            JsonNode valuesNode = mapper.readTree(new File(valuesPath)).get("values");
            JsonNode testsNode = mapper.readTree(new File(testsPath)).get("tests");

            fillValues(testsNode, valuesNode);

            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(reportPath), testsNode);

            System.out.println("Report generated successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fillValues(JsonNode testNode, JsonNode valuesNode) {
        if (testNode.isArray()) {
            for (JsonNode test : testNode) {
                if (test.has("id")) {
                    int testId = test.get("id").asInt();
                    for (JsonNode value : valuesNode) {
                        if (value.get("id").asInt() == testId) {
                            ((ObjectNode) test).put("value", value.get("value").asText());
                            break;
                        }
                    }
                }
                if (test.has("values")) {
                    fillValues(test.get("values"), valuesNode);
                }
            }
        }
    }
}
