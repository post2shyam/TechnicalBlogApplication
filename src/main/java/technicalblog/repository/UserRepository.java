package technicalblog.repository;

import org.springframework.stereotype.Repository;
import technicalblog.model.User;

import javax.persistence.*;

@Repository
public class UserRepository {

  @PersistenceUnit(unitName = "techblog")
  private EntityManagerFactory emf;

  public void registerUser(User newUser) {
    EntityManager entityManager = getEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();

    try {
      transaction.begin();
      entityManager.persist(newUser);
      transaction.commit();
    } catch (Exception exception) {
      transaction.rollback();
    }
  }

  public User checkUser(String username, String password) {
    User loggedInUser = null;
    EntityManager entityManager = getEntityManager();
    TypedQuery<User> typedQuery =
        entityManager.createQuery(
            "SELECT u FROM User u WHERE u.username = :username AND u.password = :password",
            User.class);
    typedQuery.setParameter("username", username);
    typedQuery.setParameter("password", password);

    try {
      loggedInUser = typedQuery.getSingleResult();
    } catch (NoResultException noResultException) {
      // Do nothing
    }
    return loggedInUser;
  }

  private EntityManager getEntityManager() {
    return emf.createEntityManager();
  }
}
