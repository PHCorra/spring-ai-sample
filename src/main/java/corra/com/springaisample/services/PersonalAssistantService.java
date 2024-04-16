package corra.com.springaisample.services;

import org.springframework.ai.mistralai.MistralAiChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalAssistantService {

    @Autowired
    private MistralAiChatClient mistralAiChatClient;

    public String sendMistralAiMessage(String message) {
        return mistralAiChatClient.call(message);
    }

}
