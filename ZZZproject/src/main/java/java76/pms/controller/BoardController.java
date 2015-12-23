package java76.pms.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java76.pms.dao.BoardDao;
import java76.pms.domain.Board;
import java76.pms.util.MultipartHelper;

@Controller
@RequestMapping("/board/*")
public class BoardController{
  public static final String SAVED_DIR = "/attachfile";
  @Autowired BoardDao boardDao;
  @Autowired ServletContext servletContext;
  
  @RequestMapping("home")
  public String home() {
    return "board/BoardWrapper";
  }
  
  @RequestMapping("list")
  public String list(
      String action,
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="10") int pageSize,
      @RequestParam(defaultValue="no") String keyword,
      @RequestParam(defaultValue="desc") String align,
      Model model) 
          throws Exception {

    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    paramMap.put("length", pageSize);
    paramMap.put("keyboard", keyword);
    paramMap.put("align", align);
    
    List<Board> boards = boardDao.selectList(paramMap);
    model.addAttribute("boards", boards);
    model.addAttribute("action", action);
    
    return "board/BoardWrapper";
  }
  
  
  @RequestMapping(value="add", method=RequestMethod.GET)
  public String form() {
    return "board/BoardForm";
  }
  
  @RequestMapping(value="add", method=RequestMethod.POST)
  public String add(
      Board board,
      MultipartFile file) throws Exception {
    
    System.out.println(file.getSize());
    String newFileName = null;
    if (file.getSize() > 0) {
      newFileName = MultipartHelper.generateFilename(file.getOriginalFilename());
      File attachFile = new File(
          servletContext.getRealPath(SAVED_DIR)
          + "/" + newFileName);
      file.transferTo(attachFile);
    }
    board.setA_file(newFileName);

    boardDao.insert(board);

    return "redirect:list.do";
  }
  
  @RequestMapping("detail")
    public String detail(int no, Model model) throws Exception {

    Board board = boardDao.selectOne(no);
    model.addAttribute("board", board);
    return "board/BoardDetail";
  }

  @RequestMapping(value="update", method=RequestMethod.POST)
  public String update(
      Board board,
      MultipartFile file, 
      Model model) throws Exception {
    
    String newFileName = null;
    System.out.println("a_file : " + board.getA_file());
    System.out.println("file : " + file.getName());
    System.out.println(file.getOriginalFilename().length());
    if (file.getOriginalFilename().length() > 0) {
      newFileName = MultipartHelper.generateFilename(file.getOriginalFilename());
      File attachFile = new File(servletContext.getRealPath(SAVED_DIR)
          + "/" + newFileName);
      file.transferTo(attachFile);
      board.setA_file(newFileName);
    }
    

    if (boardDao.update(board) <= 0) {
      model.addAttribute("errorCode", "401");
      return "board/BoardAuthError";
    }
    return "redirect:list.do";
  }
  
  @RequestMapping("delete")
  public String delete(
      int no,
      String password,
      Model model) throws Exception {


    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("no", no);
    paramMap.put("password", password);

    if (boardDao.delete(paramMap) <= 0) {
      model.addAttribute("erroerMessage", "401");
      return "board/BoardAuthError";
    } 
    
    return "redirect:list.do";
  }
}
