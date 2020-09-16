package technicalblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import technicalblog.model.Post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {
  @RequestMapping("/")
  public String getAllPosts(Model model) {
    Post post1 = new Post("post 1", "Post body 1", new Date());
    Post post2 = new Post("post 2", "Post body 2", new Date());
    Post post3 = new Post("post 3", "Post body 3", new Date());

    List<Post> postCollection = new ArrayList<>();
    postCollection.add(post1);
    postCollection.add(post2);
    postCollection.add(post3);

    model.addAttribute("posts", postCollection);

    return "index";
  }
}
