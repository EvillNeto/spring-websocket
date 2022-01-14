package br.com.evilnetodev.websocket.dtos;

public class MessageWSDTO {

    private String responseMessage;

    public MessageWSDTO(String message) {
        this.responseMessage = message;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

}
