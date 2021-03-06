package technicalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import technicalblog.model.Post;
import technicalblog.service.PostService;

import java.util.List;

@Controller
public class HomeController {

  @Autowired
  private PostService postService;

  @RequestMapping("/")
  public String getAllPosts(Model model) {
    List<Post> postCollection  = postService.getAllPosts();
    model.addAttribute("posts", postCollection);

    return "index";
  }
}
