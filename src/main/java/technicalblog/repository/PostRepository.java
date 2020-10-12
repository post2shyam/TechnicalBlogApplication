package technicalblog.repository;

import org.springframework.stereotype.Repository;
import technicalblog.model.Post;

import javax.persistence.*;
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

  // Special case: To acheive the Atomicity and consistency
  public Post createPost(Post newPost) {
    EntityManager entityManager = getEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();

    // We actually dont have to catch the RuntimeException (its unchecked exception and JPA handles
    // it and rollsback if needed
    // the following I am doing for the purpose of understanding.
    try {
      transaction.begin();
      entityManager.persist(newPost);
      transaction.commit();
    } catch (Exception exception) {
      transaction.rollback();
    }
    return newPost;
  }

  public Post getLatestPost() {
    return getEntityManager().find(Post.class, 3);
  }

  public Post getPost(Integer postId) {
    EntityManager entityManager = getEntityManager();
    return entityManager.find(Post.class, postId);
  }

  public void updatePost(Post updatedPost) {
    EntityManager entityManager = getEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();

    // We actually dont have to catch the RuntimeException (its unchecked exception and JPA handles
    // it and rollsback if needed
    // the following I am doing for the purpose of understanding.
    try {
      transaction.begin();
      entityManager.merge(updatedPost);
      transaction.commit();
    } catch (Exception exception) {
      transaction.rollback();
    }
  }

  public void deletePost(Integer postId) {
    EntityManager entityManager = getEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();

    // We actually dont have to catch the RuntimeException (its unchecked exception and JPA handles
    // it and rollsback if needed
    // the following I am doing for the purpose of understanding.
    try {
      transaction.begin();
      Post postTobeRemoved = entityManager.find(Post.class, postId);
      entityManager.remove(postTobeRemoved);
      transaction.commit();
    } catch (Exception exception) {
      transaction.rollback();
    }
  }

  private EntityManager getEntityManager() {
    return emf.createEntityManager();
  }
}
