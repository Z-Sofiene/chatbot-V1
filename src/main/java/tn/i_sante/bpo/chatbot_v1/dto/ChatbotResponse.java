package tn.i_sante.bpo.chatbot_v1.dto;

public class ChatbotResponse {
    private String response;

    public ChatbotResponse(String response) {
        this.response = response;
    }

    // Getters and Setters
    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
