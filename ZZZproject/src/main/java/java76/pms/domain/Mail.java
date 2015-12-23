package java76.pms.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author BitCamp
 *
 */
public class Mail implements Serializable {
  private static final long serialVersionUID = 1L;
  
  protected int       no;
  protected String    sender;
  protected String    title;
  protected String    receiver;
  protected String    attachFile;
  protected String    content;
  protected Date      sendDate;
  protected boolean   notRead;
  
  public Mail() {}

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getSender() {
    return sender;
  }

  public void setSender(String sender) {
    this.sender = sender;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getReceiver() {
    return receiver;
  }

  public void setReceiver(String receiver) {
    this.receiver = receiver;
  }

  public String getAttachFile() {
    return attachFile;
  }

  public void setAttachFile(String attachFile) {
    this.attachFile = attachFile;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getSendDate() {
    return sendDate;
  }

  public void setSendDate(Date sendDate) {
    this.sendDate = sendDate;
  }

  public boolean isNotRead() {
    return notRead;
  }

  public void setNotRead(boolean notRead) {
    this.notRead = notRead;
  }

  @Override
  public String toString() {
    return "Mail [no=" + no + ", sender=" + sender + ", title=" + title + ", receiver=" + receiver + ", attachFile="
        + attachFile + ", content=" + content + ", sendDate=" + sendDate + ", notRead=" + notRead + "]";
  }
  
  

}