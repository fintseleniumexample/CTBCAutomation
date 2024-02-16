package example.example.util;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Gpt3ApiRequest {

    public static String getOpenAIResp(String prompt) throws Exception {
        // Set your OpenAI API key
        String apiKey = "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";

        // Set the OpenAI API endpoint for GPT-3 Chat Completions
       String apiUrl = "https://api.openai.com/v1/chat/completions";
        //descending,ascending
       // final String prompt = "give me a names and values from the list of map salary descending order"+ExcelReader.readExcel("TestData.xlsx");

        // Set additional parameters if needed
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "gpt-3.5-turbo-0613");
        requestBody.put("messages", new Object[]{
                new HashMap<String, Object>() {{
                    put("role", "system");
                    put("content", "You are a helpful assistant.");
                }},
                new HashMap<String, Object>() {{
                    put("role", "user");
                    put("content", prompt);
                }}
        });
        requestBody.put("temperature", 0.1);
        requestBody.put("max_tokens", 1000);

        // Make the API request
        Response response = makeGpt3ApiRequest(apiUrl, apiKey, requestBody);


        JSONObject jsonObject = new JSONObject(response.getBody().asString());

        JSONArray conentMessage=jsonObject.getJSONArray("choices");
       String chatGPtreply= new JSONObject(new JSONObject(conentMessage.get(0).toString()).get("message").toString()).get("content").toString();
        System.out.println("Reply from OPENAI:\n" +chatGPtreply );
        return chatGPtreply;
    }

    private static Response makeGpt3ApiRequest(String apiUrl, String apiKey, Map<String, Object> requestBody) {
        return RestAssured.given()
                .baseUri(apiUrl)
                .header("Content-Type", ContentType.JSON.toString())
                .header("Authorization", "Bearer " + apiKey)
                .body(requestBody)
                .when()
                .post()
                .then()
                .extract()
                .response();
    }
}

