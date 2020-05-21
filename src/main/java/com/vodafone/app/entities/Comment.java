package com.vodafone.app.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Comment extends BaseEntity {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;
  private String msg;
  @ManyToOne
  private User user;

  @OneToMany(cascade = {
      CascadeType.ALL}, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "comment")
  private List<Tag> tags = new ArrayList<>();


  public Comment(String msg, User user) {
    this.msg = msg;
    this.user = user;
  }

  public Comment(String msg, Date createdOn, Date updatedOn) {
    super.setCreatedOn(createdOn);
    super.setUpdatedOn(updatedOn);
    this.msg = msg;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Comment comment = (Comment) o;
    return id.equals(comment.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

}
