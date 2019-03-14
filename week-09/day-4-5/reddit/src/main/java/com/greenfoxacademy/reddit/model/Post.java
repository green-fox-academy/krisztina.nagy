package com.greenfoxacademy.reddit.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import sun.util.calendar.BaseCalendar;

import javax.persistence.*;
import javax.print.attribute.standard.DateTimeAtCreation;
import java.util.Date;

@Entity
public class Post {

  @Id
  @GeneratedValue
  private long id;

  private String title;
  private String url;
  private long rating;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user")
  private User user;

  @CreationTimestamp
  @Temporal(TemporalType.DATE)
  @Column(name = "date_created")
  private Date dateCreated;

  @UpdateTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "date_modified")
  private Date dateModified;

  public Post() {

  }

  public Post(String title, String url, User user) {
    this.title = title;
    this.url = url;
    this.rating = 0;
    this.dateCreated = new Date();
    this.user = user;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Date getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }

  public Date getDateModified() {
    return dateModified;
  }

  public void setDateModified(Date dateModified) {
    this.dateModified = dateModified;
  }

  public long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getUrl() {
    return url;
  }

  public long getRating() {
    return rating;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public void setRating(long rating) {
    this.rating = rating;
  }

    /*public void upVote(long id) {
        this.rating
    }*/
}
