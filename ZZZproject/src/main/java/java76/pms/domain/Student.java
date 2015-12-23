package java76.pms.domain;

import java.io.Serializable;

public class Student implements Serializable {
  private static final long serialVersionUID = 1L;
  protected String name;
  protected String email;
  protected String gender;
  protected String pwd;
  protected String image;
  
  public Student() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  @Override
  public String toString() {
    return "Student [name=" + name + ", email=" + email + ", gender=" + gender + ", pwd=" + pwd + ", image=" + image
        + "]";
  }
  
  
  
}









