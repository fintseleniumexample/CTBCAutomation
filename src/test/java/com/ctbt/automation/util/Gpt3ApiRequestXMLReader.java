//package com.ctbt.automation.util;
//
//import com.lilittlecat.chatgpt.offical.ChatGPT;
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class Gpt3ApiRequestXMLReader {
//
//
//  //  public static void main(String[] args) {
//       public static String getOpenAIOpnion(String prompt) {
//            String replyMSG = "";
//           String hello="";
//           int retries = 0;
//             final int MAX_RETRIES = 3;
//           boolean success = false;
//           while (!success && retries < MAX_RETRIES) {
//               try {
//                   String xmlDATA = XMLToStringConverter.getXMLString();
//                   String prompt2 = prompt + " " + xmlDATA;
//                   ChatGPT chatGPT = new ChatGPT("");
//                   hello = chatGPT.ask(prompt2).trim();
//                   System.out.println(hello);
//                   success=true;
//               } catch (Exception e) {
//                   e.printStackTrace();
//                   hello = e.getMessage();
//                   retries++;
//               }
//           }
//           replyMSG=  "<style>\n"+"table {\n" +
//                   "        width: 100%; /* Set table width to 100% */\n" +
//                   "        border-collapse: collapse; /* Collapse borders between cells */\n" +
//                   "    }\n" +
//                   "    th, td {\n" +
//                   "        border: 1px solid black; /* Add borders to cells */\n" +
//                   "        padding: 8px; /* Add padding to cells */\n" +
//                   "        text-align: left; /* Align text to the left */\n" +
//                   "    }"+
//                   "pre {\n" +
//                   "  color: #046595;\n" +
//                   "  font-family: Tahoma;\n" +
//                   "  font-size: 100%;\n" +
//                   "  overflow-x: auto;\n" +
//                   "  white-space: pre-wrap;\n" +
//                   "  white-space: -moz-pre-wrap;\n" +
//                   "  white-space: -pre-wrap;\n" +
//                   "  white-space: -o-pre-wrap;\n" +
//                   "  word-wrap: break-word;\n background-color: #FFFFCC;\n" +
//                   "  border: 2px dashed #FF6666;\n" +
//                   "  padding-top: 7px;\n" +
//                   "  padding-bottom: 8px;\n" +
//                   "  padding-left: 10px;\n" +
//                   "  float: none;\n" +
//                   "  padding-right: 10px;\n" +
//                   "  margin: 10px;" +
//                   "}" +
//                   "</style><div id='openAI'><pre> OpenAI Response:\n"+hello+"</pre></div>"+"<script>\n" +
//                   "    // Select the parent div\n" +
//                   "    var parentDiv = document.getElementById(\"dashboard-view\");\n" +
//                   "\n" +
//                   "     var childDiv = document.getElementById(\"openAI\");\n" +
//                   "\n" +
//                   "    // Append the new div to the parent div\n" +
//                   "    parentDiv.appendChild(childDiv);\n" +
//                   "</script>";
//            return replyMSG;
//        }
//
//
//    public static String getOpnAIResp(String prompt) {
//       String replyMSG="";
//                // Set your OpenAI API key
//        String apiKey = "";
//
//        // Set the OpenAI API endpoint for GPT-3 Chat Completions
//        String apiUrl = "https://api.openai.com/v1/chat/completions";
//
//
//        // Set the prompt for the model
//        String xmlDATA=XMLToStringConverter.getXMLString();
//        String prompt2=prompt+" "+xmlDATA;
//        // Set additional parameters if needed
//        Map<String, Object> requestBody = new HashMap<>();
//        requestBody.put("model", "gpt-3.5-turbo-0613");
//        requestBody.put("messages", new Object[]{
//                new HashMap<String, Object>() {{
//                    put("role", "system");
//                    put("content", "You are a helpful assistant.");
//                }},
//                new HashMap<String, Object>() {{
//                    put("role", "user");
//                    put("content", prompt2);
//                }}
//        });
//        requestBody.put("temperature", 0.1);
//        requestBody.put("max_tokens", 1000);
//
//        // Make the API request
//        Response response = makeGpt3ApiRequest(apiUrl, apiKey, requestBody);
//
//        // Print the response body
//        System.out.println("API Response:\n" + response.getBody().asString());
//        JSONObject jsonObject = new JSONObject(response.getBody().asString());
//
//        JSONArray conentMessage=jsonObject.getJSONArray("choices");
//       String aiResp=   new JSONObject(new JSONObject(conentMessage.get(0).toString()).get("message").toString()).get("content").toString();
//        System.out.println("Reply from OPENAI:\n" +aiResp );
//
//        replyMSG=  "<style>\n"+"table {\n" +
//                "        width: 100%; /* Set table width to 100% */\n" +
//                "        border-collapse: collapse; /* Collapse borders between cells */\n" +
//                "    }\n" +
//                "    th, td {\n" +
//                "        border: 1px solid black; /* Add borders to cells */\n" +
//                "        padding: 8px; /* Add padding to cells */\n" +
//                "        text-align: left; /* Align text to the left */\n" +
//                "    }"+
//                "pre{\n" +
//                "  color: #046595;\n" +
//                "  font-family: Tahoma;\n" +
//                "  font-size: 100%;\n" +
//                "  overflow-x: auto;\n" +
//                "  white-space: pre-wrap;\n" +
//                "  white-space: -moz-pre-wrap;\n" +
//                "  white-space: -pre-wrap;\n" +
//                "  white-space: -o-pre-wrap;\n" +
//                "  word-wrap: break-word;\n background-color: #FFFFCC;\n" +
//                "  border: 2px dashed #FF6666;\n" +
//                "  padding-top: 7px;\n" +
//                "  padding-bottom: 8px;\n" +
//                "  padding-left: 10px;\n" +
//                "  float: none;\n" +
//                "  padding-right: 10px;\n" +
//                "  margin: 10px;" +
//                "}" +
//                "</style><div id='openAI'><pre> OpenAI Response:\n"+aiResp+"</pre></div>"+"<script>\n" +
//                "    // Select the parent div\n" +
//                "    var parentDiv = document.getElementById(\"dashboard-view\");\n" +
//                "\n" +
//                "     var childDiv = document.getElementById(\"openAI\");\n" +
//                "\n" +
//                "    // Append the new div to the parent div\n" +
//                "    parentDiv.appendChild(childDiv);\n" +
//                "</script>";
//        return replyMSG;
//    }
//
//    private static Response makeGpt3ApiRequest(String apiUrl, String apiKey, Map<String, Object> requestBody) {
//        return RestAssured.given()
//                .baseUri(apiUrl)
//                .header("Content-Type", ContentType.JSON.toString())
//                .header("Authorization", "Bearer " + apiKey)
//                .body(requestBody)
//                .when()
//                .post()
//                .then()
//                .extract()
//                .response();
//    }
//}
//
