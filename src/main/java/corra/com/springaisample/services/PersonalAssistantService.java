package corra.com.springaisample.services;

import java.util.List;

import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.Generation;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.embedding.EmbeddingClient;
import org.springframework.ai.embedding.EmbeddingRequest;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.ai.mistralai.MistralAiChatClient;
import org.springframework.ai.mistralai.MistralAiChatOptions;
import org.springframework.ai.mistralai.MistralAiEmbeddingClient;
import org.springframework.ai.mistralai.MistralAiEmbeddingOptions;
import org.springframework.ai.mistralai.api.MistralAiApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalAssistantService {

    @Autowired
    private MistralAiChatClient mistralAiChatClient;

    @Autowired
    private EmbeddingClient embeddingClient;

    public String sendMistralAiMessage(String message) {
        return mistralAiChatClient.call(new Prompt(
                message,
                MistralAiChatOptions.builder()
                        .withModel(MistralAiApi.ChatModel.TINY.getValue())
                        .withTemperature(0.5f)
                        .build()))
                .getResult()
                .getOutput()
                .getContent();
        // return mistralAiChatClient.call(message);
    }

    public EmbeddingResponse sendEmbeddedMistralAiMessage(String message) {
        return embeddingClient
                .call(new EmbeddingRequest(List.of(message), MistralAiEmbeddingOptions.builder().build()));
    }

}
