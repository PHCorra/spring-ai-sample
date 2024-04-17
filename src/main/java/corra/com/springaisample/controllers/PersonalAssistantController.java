package corra.com.springaisample.controllers;

import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.Generation;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import corra.com.springaisample.services.PersonalAssistantService;

@RestController
@RequestMapping("/assistant")
public class PersonalAssistantController {

    @Autowired
    private PersonalAssistantService personalAssistantService;

    @PostMapping()
    public ResponseEntity<String> personalAssistantChat(
            @RequestBody String message) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(personalAssistantService.sendMistralAiMessage(message));
    }

    @PostMapping("/embedding")
    public ResponseEntity<EmbeddingResponse> personalEmbeddedAssistantChat(
            @RequestBody String message) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(personalAssistantService.sendEmbeddedMistralAiMessage(message));
    }
}
