package com.vh.cognitive.processor.controllers;

import com.vh.cognitive.processor.model.Request;
import com.vh.cognitive.processor.model.Response;
import com.vh.cognitive.processor.services.ChatService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/ask")
    public Response ask(@RequestBody Request request) {

        long start = System.currentTimeMillis();

        String answer = chatService.ask(request.getConversationId(), request.getMessage());

        long end = System.currentTimeMillis();

        return new Response(
                answer,
                end - start,
                end
        );
    }

    @PostMapping("/echo")
    public String echo(@RequestBody Request request){
        System.out.println(request.getMessage());
        return request.getMessage();
    }
}
