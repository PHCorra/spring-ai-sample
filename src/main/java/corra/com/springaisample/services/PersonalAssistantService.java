package corra.com.springaisample.services;

import org.springframework.ai.azure.openai.AzureOpenAiChatClient;

import reactor.core.publisher.Flux;

public class PersonalAssistantService {

    private final AzureOpenAiChatClient azureOpenAiChatClient;

    public PersonalAssistantService(AzureOpenAiChatClient azureOpenAiChatClient) {
        this.azureOpenAiChatClient = azureOpenAiChatClient;
    }

    public Flux<String> sendAzureMessage(String message) {
        return azureOpenAiChatClient.stream(message);
    
}
