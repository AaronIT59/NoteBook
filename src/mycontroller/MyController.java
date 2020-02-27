package mycontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.DaoImpl;
import entity.tbl_profile;

@Controller
public class MyController {
	
	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String a = request.getParameter("user");
		String b = request.getParameter("pass");
		if(new DaoImpl().checkLogin(a, b)) {
			mv.setViewName("news-feed.jsp");
		}
		else 
		{
			mv.setViewName("index.jsp");
			mv.addObject("status", "Try Again !");
		}
		
		return mv;
	}
	
	@RequestMapping(value = "/signIn")
	public ModelAndView SignIn(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		tbl_profile tpro = new tbl_profile();
		tpro.setFirst_name(request.getParameter("first-name"));
		tpro.setLast_name(request.getParameter("last-name"));
		tpro.setEmail_mobile(request.getParameter("mobile-or-email"));
		tpro.setPassword(request.getParameter("user-password"));
		tpro.setBirthday(request.getParameter("dd")+"-"+request.getParameter("mm")+"-"+request.getParameter("yy"));
		tpro.setSex(request.getParameter("sex"));
		
		if(!new util.Validate().checkFirstName(tpro.getFirst_name())) {
			mv.addObject("status", "First Name invalid");
			mv.setViewName("register.jsp");
		}else if(!new util.Validate().checkLastName(tpro.getLast_name())) {
			mv.addObject("status", "Last Name invalid");
			mv.setViewName("register.jsp");
		}else if(!new util.Validate().checkEmailOrPhone(tpro.getEmail_mobile())) {
			mv.addObject("status", "Email/Phone invalid");
			mv.setViewName("register.jsp");
		}else if(!new util.Validate().checkPass(tpro.getPassword())) {
			mv.addObject("status", "Password invalid");
			mv.setViewName("register.jsp");
		}
		
		else {
			if(new DaoImpl().SignIn(tpro))
			{
				mv.setViewName("index.jsp");
			}
		}
		
		
		return mv;
		
	}
	
}
