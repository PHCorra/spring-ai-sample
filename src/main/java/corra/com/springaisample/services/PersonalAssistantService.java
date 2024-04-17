package corra.com.springaisample.services;

import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.mistralai.MistralAiChatClient;
import org.springframework.ai.mistralai.MistralAiChatOptions;
import org.springframework.ai.mistralai.api.MistralAiApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalAssistantService {

    @Autowired
    private MistralAiChatClient mistralAiChatClient;

    public String sendMistralAiMessage(String message) {
        return mistralAiChatClient.call(new Prompt(
                message,
                MistralAiChatOptions.builder()
                        .withModel(MistralAiApi.ChatModel.LARGE.getValue())
                        .withTemperature(0.5f)
                        .build()))
                .getResult()
                .getOutput()
                .getContent();

        // return mistralAiChatClient.call(message);
    }

}
