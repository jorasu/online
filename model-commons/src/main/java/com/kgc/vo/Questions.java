package com.kgc.vo;

import java.io.Serializable;

public class Questions implements Serializable{
  private Integer id;
  private String title;
  private String detaildesc;
  private Integer answercount;
  private String lastmodified;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDetaildesc() {
    return detaildesc;
  }

  public void setDetaildesc(String detaildesc) {
    this.detaildesc = detaildesc;
  }

  public Integer getAnswercount() {
    return answercount;
  }

  public void setAnswercount(Integer answercount) {
    this.answercount = answercount;
  }

  public String getLastmodified() {
    return lastmodified;
  }

  public void setLastmodified(String lastmodified) {
    this.lastmodified = lastmodified;
  }

  @Override
  public String toString() {
    return "Questions{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", detaildesc='" + detaildesc + '\'' +
            ", answercount=" + answercount +
            ", lastmodified='" + lastmodified + '\'' +
            '}';
  }
}
