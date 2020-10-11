package technicalblog.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "posts")
public class Post {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Integer id;

  @Column(name = "title")
  private String title;

  @Column(name = "body")
  private String body;

  @Column(name = "date")
  private Date date;

  public void setDate(Date date) {
    this.date = date;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public void setTitle(String title) {
    this.title = title;
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
