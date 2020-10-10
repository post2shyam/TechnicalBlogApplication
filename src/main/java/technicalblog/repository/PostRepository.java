package technicalblog.repository;

import org.springframework.stereotype.Repository;
import technicalblog.model.Post;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PostRepository {

  @PersistenceUnit(unitName = "techblog")
  private EntityManagerFactory emf;

  public List<Post> getAllPosts() {
    // JPQL query
    TypedQuery<Post> query = getEntityManager().createQuery("SELECT p from Post p", Post.class);
    List<Post> posts = query.getResultList();
    return posts;
  }

  public Post getLatestPost() {
    return getEntityManager().find(Post.class, 3);
  }

  private EntityManager getEntityManager() {
    return emf.createEntityManager();
  }
}
