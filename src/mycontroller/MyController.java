package mycontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.DaoImpl;

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
}
