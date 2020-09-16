package technicalblog.model;

import java.util.Date;

public class Post {

  private String title;
  private String body;
  private Date date;

  public Post(String title, String body, Date date) {
    this.title = title;
    this.body = body;
    this.date = date;
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
