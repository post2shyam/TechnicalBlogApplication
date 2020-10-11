package technicalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import technicalblog.model.Post;
import technicalblog.service.PostService;

import java.util.List;

@Controller
public class PostController {

  @Autowired private PostService postService;

  @RequestMapping("posts")
  public String getUserPosts(Model model) {
    List<Post> posts = postService.getAllPosts();
    model.addAttribute("posts", posts);
    return "posts";
  }

  @RequestMapping("/posts/create")
  public String newPost() {
    return "/posts/create";
  }

  @RequestMapping(value = "/posts/create", method = RequestMethod.POST)
  public String createPost(Post newPost) {
    postService.createPost(newPost);
    return "redirect:/posts";
  }

  @RequestMapping("/editPost")
  public String editPost(@RequestParam(name = "postId") Integer postId, Model model) {
    Post post = postService.getPost(postId);
    model.addAttribute("post", post);
    return "/posts/edit";
  }

  @RequestMapping(value = "/editPost", method = RequestMethod.POST)
  public String editPostSubmit(@RequestParam(name = "postId") Integer postId, Post updatedPost) {
    return "redirect:/posts";
  }
}
