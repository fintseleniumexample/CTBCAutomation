package com.ctbt.automation.util;

import com.lilittlecat.chatgpt.offical.ChatGPT;

public class Gpt3ApiRequestXMLReader {


  //  public static void main(String[] args) {
       public static String getOpenAIOpnion(String prompt) {
            String replyMSG = null;
        try {
            String xmlDATA=XMLToStringConverter.getXMLString();
            String prompt2=prompt+" "+xmlDATA;
            ChatGPT chatGPT = new ChatGPT("");
            String hello = chatGPT.ask(prompt2);
            System.out.println(hello);
             replyMSG=  "<style>\n"+"table {\n" +
                    "        width: 100%; /* Set table width to 100% */\n" +
                    "        border-collapse: collapse; /* Collapse borders between cells */\n" +
                    "    }\n" +
                    "    th, td {\n" +
                    "        border: 1px solid black; /* Add borders to cells */\n" +
                    "        padding: 8px; /* Add padding to cells */\n" +
                    "        text-align: left; /* Align text to the left */\n" +
                    "    }"+
                    "pre {\n" +
                    "  color: #046595;\n" +
                    "  font-family: Tahoma;\n" +
                    "  font-size: 100%;\n" +
                    "  overflow-x: auto;\n" +
                    "  white-space: pre-wrap;\n" +
                    "  white-space: -moz-pre-wrap;\n" +
                    "  white-space: -pre-wrap;\n" +
                    "  white-space: -o-pre-wrap;\n" +
                    "  word-wrap: break-word;\n background-color: #FFFFCC;\n" +
                    "  border: 2px dashed #FF6666;\n" +
                    "  padding-top: 7px;\n" +
                    "  padding-bottom: 8px;\n" +
                    "  padding-left: 10px;\n" +
                    "  float: none;\n" +
                    "  padding-right: 10px;\n" +
                    "  margin: 10px;" +
                    "}" +
                    "</style><div id='openAI'><pre > OpenAI Response:\n"+hello+"</pre></div>"+"<script>\n" +
                    "    // Select the parent div\n" +
                    "    var parentDiv = document.getElementById(\"dashboard-view\");\n" +
                    "\n" +
                    "     var childDiv = document.getElementById(\"openAI\");\n" +
                    "\n" +
                    "    // Append the new div to the parent div\n" +
                    "    parentDiv.appendChild(childDiv);\n" +
                    "</script>";
        }catch (Exception e){
            e.printStackTrace();
        }
            return replyMSG;
        }
}

