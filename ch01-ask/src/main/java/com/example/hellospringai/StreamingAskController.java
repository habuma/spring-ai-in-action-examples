package com.example.hellospringai;

import org.springframework.ai.chat.StreamingChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class StreamingAskController {

  private final StreamingChatClient chatClient;

  public StreamingAskController(StreamingChatClient chatClient) {
    this.chatClient = chatClient;
  }

  @PostMapping(path = "/ask", produces = "application/stream+json")
  public Flux<Answer> ask(@RequestBody Question question) {
    Prompt prompt = new Prompt(question.question());
    return chatClient.stream(prompt)
        .map(response -> {
          String answerText = response.getResult().getOutput().getContent();
          return new Answer(answerText);
        });
  }

}
