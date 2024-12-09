package site.mplace.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import site.mplace.demo.service.MemberService;
import site.mplace.demo.vo.Member;

@Controller
@RequestMapping("member")
public class MemberController {
  @Autowired
  private MemberService service;

  @RequestMapping("")
  public String index(Model model, HttpServletRequest req, String str, Member member, HttpSession session ){
    model.addAttribute("now",service.selectNow());
    req.setAttribute("name", "kil dong");
    model.addAttribute("member",member);
    model.addAttribute("str",str);

    return "hello";
  }
}
