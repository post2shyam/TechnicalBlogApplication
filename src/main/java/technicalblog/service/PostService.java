package technicalblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technicalblog.model.Post;
import technicalblog.repository.PostRepository;

import java.util.List;

@Service
public class PostService {

  @Autowired
  private PostRepository postRepository;

  public List<Post> getAllPosts() {
    return postRepository.getAllPosts();
  }

  public Post getOnePost() {
    return postRepository.getLatestPost();
  }

  public void createPost(Post newPost) {
    // TODO
  }
}
