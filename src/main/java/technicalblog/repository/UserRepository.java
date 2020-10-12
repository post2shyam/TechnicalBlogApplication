package technicalblog.repository;

import org.springframework.stereotype.Repository;
import technicalblog.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

@Repository
public class UserRepository {

  @PersistenceUnit(unitName = "techblog")
  private EntityManagerFactory emf;

  public void registerUser(User newUser) {
    EntityManager entityManager = getEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();

    // We actually dont have to catch the RuntimeException (its unchecked exception and JPA handles
    // it and rollsback if needed
    // the following I am doing for the purpose of understanding.
    try {
      transaction.begin();
      entityManager.persist(newUser);
      transaction.commit();
    } catch (Exception exception) {
      transaction.rollback();
    }
  }

  private EntityManager getEntityManager() {
    return emf.createEntityManager();
  }
}
