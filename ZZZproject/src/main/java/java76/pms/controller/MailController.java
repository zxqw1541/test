package java76.pms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java76.pms.dao.MailDao;
import java76.pms.domain.Mail;
import java76.pms.domain.Student;

@Controller
@RequestMapping("/mail/*")
public class MailController {
  public static final String SAVED_DIR = "/file";
  @Autowired MailDao mailDao;
  @Autowired ServletContext servletContext;

  @RequestMapping("/box.do")
  public String box(
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="10") int pageSize,
      @RequestParam(defaultValue="no") String keyword,
      @RequestParam(defaultValue="desc") String align,
      HttpSession session,
      Model model) {

    
    Student student = (Student)session.getAttribute("loginUser");
    
    if (student == null)
      return "/auth/LoginFail.jsp"; //로그인 시키기
    
    // 파라미터 값이 넘오지 않으면 기본 값으로 설정한다.
    if (pageNo < 0) pageNo = 1;
    if (pageSize < 0) pageSize = 10;
    if (keyword != null) keyword = "no";
    if (align != null) align = "desc";
    
    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    paramMap.put("length", pageSize);
    paramMap.put("keyboard", keyword);
    paramMap.put("align", align);
    paramMap.put("sender", student.getEmail());
    
    List<Mail> mails = mailDao.selectList(paramMap);
    model.addAttribute("mails", mails);
    model.addAttribute("action", "maillist");
    
    return "board/BoardWrapper";
  }
  
  @RequestMapping(value="add", method=RequestMethod.GET)
  public String form() {
    return "mail/MailForm";
  }
  
  @RequestMapping(value="add", method=RequestMethod.POST)
  public String add(Mail mail, HttpSession session) throws Exception {
    
    List<String> names = (List<String>)mailDao.selectEmail();
    
    Random r = new Random();
    if (names.size()< 2)
      return "";
    String me = ((Student)session.getAttribute("loginUser")).getEmail();
    String tem = null;
    while (true) {
      tem = names.get(r.nextInt(names.size()));
      if(!me.equals(tem))
        break;
    }
    
    mail.setSender(me);
    mail.setReceiver(tem);
    
    mailDao.insert(mail);


    return "redirect:list.do";
  }
}