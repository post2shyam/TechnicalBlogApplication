package technicalblog.service;

import org.springframework.stereotype.Service;
import technicalblog.model.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

  private static String dpPassword = "1234";

  public List<Post> getAllPosts() {
    List<Post> posts = new ArrayList<>();
    Connection connection = null;
    try {
      connection = getDbConnection();
      Statement statement = connection.createStatement();
      ResultSet rs = statement.executeQuery("SELECT * FROM posts");

      // Iterate through the posts of the db
      while (rs.next()) {
        String title = rs.getString("title");
        String body = rs.getString("body");
        posts.add(new Post(title, body, null));
      }
    } catch (ClassNotFoundException | SQLException exception) {
      exception.printStackTrace();
    } finally{
      try {
        connection.close();
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }
    return posts;
  }

  public List<Post> getOnePost() {
    List<Post> posts = new ArrayList<>();
    Connection connection = null;
    try {
      connection = getDbConnection();
      Statement statement = connection.createStatement();
      ResultSet rs = statement.executeQuery("SELECT * FROM posts WHERE id = 4");
      while (rs.next()) {
        String title = rs.getString("title");
        String body = rs.getString("body");
        posts.add(new Post(title, body, null));
      }
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        connection.close();
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }
    return posts;
  }

  public void createPost(Post newPost) {
    // TODO
  }

  private Connection getDbConnection() throws ClassNotFoundException, SQLException {
    Class.forName("org.postgresql.Driver");
    return DriverManager.getConnection(
        "jdbc:postgresql://localhost:5432/technicalblog", "postgres", dpPassword);
  }
}
