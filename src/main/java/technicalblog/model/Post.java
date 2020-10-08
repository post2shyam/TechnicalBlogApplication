package technicalblog.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "posts")
public class Post {

  @Id
  @Column(name = "id")
  private Integer id;

  @Column(name = "title")
  private String title;

  @Column(name = "body")
  private String body;

  @Transient
  private Date date;

  public Post(String title, String body, Date date) {
    this.title = title;
    this.body = body;
    this.date = date;
  }

  public Post() {
    
  }

  public String getTitle() {
    return title;
  }

  public String getBody() {
    return body;
  }

  public Date getDate() {
    return date;
  }
}
