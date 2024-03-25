package com.example.hellospringai;

import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.evaluation.BasicEvaluationTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AskTest extends BasicEvaluationTest {

  @Autowired
  ChatClient chatClient;

  @Test
  public void testAsk() {
    String question = "Why is the sky blue?";
    Prompt prompt = new Prompt(question);
    ChatResponse answer = chatClient.call(prompt);
    evaluateQuestionAndAnswer(question, answer, true);
  }

}
