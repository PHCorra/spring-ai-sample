package corra.com.springaisample.controllers;

import org.springframework.ai.azure.openai.AzureOpenAiChatClient;
import org.springframework.ai.mistralai.MistralAiChatClient;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import corra.com.springaisample.services.PersonalAssistantService;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/assistant")
public class PersonalAssistantController {

    private final PersonalAssistantService personalAssistantService;

    public PersonalAssistantController(PersonalAssistantService personalAssistantService) {
        this.personalAssistantService = personalAssistantService;
    }
    

    @GetMapping("/stream")
    public Flux<String> personalAssistantChat(@RequestParam(value = "message",
        defaultValue = "teste") String message)  {
            return personalAssistantService.sendAzureMessage(message);
    }
}
