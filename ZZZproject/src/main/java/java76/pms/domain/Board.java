package java76.pms.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author BitCamp
 *
 */
public class Board implements Serializable {
  private static final long serialVersionUID = 1L;
  
  protected int       no;
  protected String    title;
  protected String    content;
  protected int       views;
  protected Date      createdDate;
  protected String    password;
  protected String    a_file;
  
  public Board() {}
  
  
  

  @Override
  public String toString() {
    return "Board [no=" + no + ", title=" + title + ", content=" + content + ", views=" + views + ", createdDate="
        + createdDate + ", password=" + password + ", a_file=" + a_file + "]";
  }

  public String getA_file() {
    return a_file;
  }



  public void setA_file(String a_file) {
    this.a_file = a_file;
  }



  public int getNo() {
    return no;
  }



  public void setNo(int no) {
    this.no = no;
  }



  public String getTitle() {
    return title;
  }



  public void setTitle(String title) {
    this.title = title;
  }



  public String getContent() {
    return content;
  }



  public void setContent(String content) {
    this.content = content;
  }



  public int getViews() {
    return views;
  }



  public void setViews(int views) {
    this.views = views;
  }




  public Date getCreatedDate() {
    return createdDate;
  }



  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }



  public String getPassword() {
    return password;
  }



  public void setPassword(String password) {
    this.password = password;
  }

  

}
