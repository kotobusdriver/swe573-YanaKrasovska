package swe.rest.controllers;

import static swe.rest.controllers.PostsController.BASE_PATH;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import swe.domain.entities.PostEntity;
import swe.rest.models.*;
import swe.services.PostService;
import swe.workflows.CreatePostWorkflow;

@CrossOrigin
@RequestMapping(BASE_PATH)
@RestController
@AllArgsConstructor
public class PostsController {
  public static final String BASE_PATH = "/api/posts";

  private final CreatePostWorkflow createPostWorkflow;
  private final PostService postService;

  @PostMapping
  ResponseEntity<PostResource> createPost(@RequestBody CreatePostRequest createPostRequest) {
    PostEntity postEntity = createPostWorkflow.execute(createPostRequest);
    return ResponseEntity.ok(PostResource.convert(postEntity));
  }

  @DeleteMapping("/{id}")
  ResponseEntity<Void> deletePost(
      @PathVariable("id") String postId, @RequestParam("memberId") String memberId) {
    postService.deletePost(postId, memberId);
    return ResponseEntity.noContent().build();
  }
}
