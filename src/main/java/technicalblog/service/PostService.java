package technicalblog.service;

import org.springframework.stereotype.Service;
import technicalblog.model.Post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {
  public List<Post> getAllPosts() {
    Post post1 = new Post("post 1", "Post body 1", new Date());
    Post post2 = new Post("post 2", "Post body 2", new Date());
    Post post3 = new Post("post 3", "Post body 3", new Date());

    List<Post> postCollection = new ArrayList<>();
    postCollection.add(post1);
    postCollection.add(post2);
    postCollection.add(post3);

    return postCollection;
  }

  public List<Post> getOnePost(){

    Post post1 = new Post("This is your post", "This is your post. It has some wild content", new Date());

    List<Post> postCollection = new ArrayList<>();
    postCollection.add(post1);

    return postCollection;

  }

  public void createPost(Post newPost) {
    //TODO
  }
}
