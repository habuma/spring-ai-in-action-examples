// tag::stringBasedAsk[]
// tag::promptBasedAsk[]
package com.example.hellospringai;

import org.springframework.ai.chat.ChatClient;
// end::stringBasedAsk[]
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
// tag::stringBasedAsk[]
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AskController {

  private final ChatClient chatClient;

  public AskController(ChatClient chatClient) { // <1>
    this.chatClient = chatClient;
  }

  // end::stringBasedAsk[]
  // end::promptBasedAsk[]
    /*
    // tag::stringBasedAsk[]
    @PostMapping(path="/ask", produces="application/json")
    public Answer ask(@RequestBody Question question) {
        String answerText = chatClient.call(question.question()); // <2>
        return new Answer(answerText);
    }
    // end::stringBasedAsk[]
     */

  // tag::promptBasedAsk[]
  @PostMapping(path = "/ask", produces = "application/json")
  public Answer ask(@RequestBody Question question) {
    Prompt prompt = new Prompt(question.question());
    ChatResponse response = chatClient.call(prompt);
    response.getMetadata().getUsage().getTotalTokens();
    return new Answer(response.getResult().getOutput().getContent());
  }
  // tag::stringBasedAsk[]

}
// end::stringBasedAsk[]
// end::promptBasedAsk[]
