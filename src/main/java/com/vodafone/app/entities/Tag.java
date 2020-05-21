package com.vodafone.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Tag {

  @Id
  @GeneratedValue
  private Long id;

  private Long userId;

  private String displayName;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "commentId")
  @JsonIgnore
  private Comment comment;

  public Tag(String displayName, Long userId, Comment comment) {
    this.displayName = displayName;
    this.userId = userId;
    this.comment = comment;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Tag tag = (Tag) o;
    return userId.equals(tag.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId);
  }
}
