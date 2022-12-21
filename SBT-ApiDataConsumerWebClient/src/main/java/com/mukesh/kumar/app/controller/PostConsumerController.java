package com.mukesh.kumar.app.controller;

import com.mukesh.kumar.app.entity.Posts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/posts/api/v1")
@Slf4j
public class PostConsumerController {

    @Autowired
    private WebClient webClient;

    @GetMapping("/findAll")
    public Flux<Posts> findAll() {
        log.info("PostConsumerController : calling findAll Api..");
        Flux<Posts> postsFlux = webClient.get().uri("/posts").retrieve().bodyToFlux(Posts.class);
        return postsFlux;
    }

    @PostMapping("/add")
    public Mono<String> newPosts(@RequestBody Posts postBody) {
        log.info("PostConsumerController : calling New Posts Api..");
        Mono<String> stringMono = webClient.post().uri("/posts").syncBody(postBody).retrieve().bodyToMono(String.class);
        return stringMono;
    }

    @PutMapping("/update")
    public Mono<Posts> updatePosts(@RequestBody Posts postBody) {
        log.info("PostConsumerController : calling Update Posts Api..");
        Mono<Posts> stringMono = webClient.put().uri("/posts/"+postBody.getId()).bodyValue(postBody).retrieve().bodyToMono(Posts.class);
        return stringMono;
    }

    @DeleteMapping("/delete/{id}")
    public Mono<String> deletePosts(@PathVariable int id) {
        log.info("PostConsumerController : calling Delete Posts Api..");
        Mono<String> stringMono = webClient.get().uri("/posts/" + id).retrieve().bodyToMono(String.class);
        return stringMono;
    }

    @GetMapping("/find/{id}")
    public Mono<Posts> findPostsById(@PathVariable int id) {
        log.info("PostConsumerController : calling Find Posts By Id Api..");
        Mono<Posts> postsMono = webClient.get().uri("/posts/" + id).retrieve().bodyToMono(Posts.class);
        return postsMono;
    }

}
