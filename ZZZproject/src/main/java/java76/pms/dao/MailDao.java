package java76.pms.dao;

import java.util.List;
import java.util.Map;

import java76.pms.domain.Mail;

public interface MailDao {

  public List<Mail> selectList(Map<String,Object> paramMap);
  public int insert(Mail mail);
  public int delete(int no);
  public Mail selectOne(int no);
  public List<String> selectEmail();
  
}

