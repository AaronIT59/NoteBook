package mycontroller;


import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.DaoImpl;
import model.tbl_profile;

@Controller
@MultipartConfig(maxFileSize = 16000000)
public class MyController {
	
	
	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String a = request.getParameter("user");
		String b = request.getParameter("pass");
		HttpSession session = request.getSession();	
		tbl_profile pro = new DaoImpl().checklogin(a, b);
		if(pro!=null)
		{
			List<tbl_profile> list = new DaoImpl().getConnectFriend(pro.getId());
			List<tbl_profile> list1 = new DaoImpl().getFriend(pro.getId());
			int fr = new DaoImpl().CountFriend(pro.getId());
			session.setAttribute("fr", fr);
			session.setAttribute("list", list);
			session.setAttribute("list1", list1);
			session.setAttribute("user", pro);
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
		}else if (new DaoImpl().checkEmail(tpro.getEmail_mobile())) {
			mv.addObject("status", "Email/Phone already exists , Change Email/Phone");
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

	
	@RequestMapping(value = "/profile")
	public ModelAndView Profile(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv =new ModelAndView();
		HttpSession session = request.getSession();
		if(session.getAttribute("user")!=null)
		{
			mv.addObject("user");
			mv.setViewName("profile.jsp");
		}
		
		else {
			mv.addObject("status","ivalid login");
			mv.setViewName("news-feed.jsp");
		}
		
		return mv;
	}
	
	@RequestMapping (value = "/signOut")
	public ModelAndView SignOut(HttpServletRequest request,HttpServletResponse response)
	{
		ModelAndView mv =new ModelAndView();
		HttpSession session = request.getSession();
		if(session!=null)
		{
			session.invalidate();
			mv.setViewName("index.jsp");
		}
		
		
		return mv;
		
	}
	
	@RequestMapping (value = "/changeProfile")
	public ModelAndView ChangeProfile(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		tbl_profile user = (tbl_profile) session.getAttribute("user");		
		
		tbl_profile tpro = new tbl_profile();
		tpro.setFirst_name(request.getParameter("first-name"));
		tpro.setLast_name(request.getParameter("last-name"));
		tpro.setEmail_mobile(request.getParameter("mobile-or-email"));
		tpro.setPassword(request.getParameter("user-password"));
		tpro.setBirthday(request.getParameter("day")+"-"+request.getParameter("month")+"-"+request.getParameter("year"));
		tpro.setSex(request.getParameter("sex"));
		tpro.setAvatar(user.getAvatar());	
		if(new DaoImpl().UpdateProfile(tpro, user.getId()))
		{			
			mv.setViewName("profile.jsp");			
			mv.addObject("status1", "Succes Update !");
			session.setAttribute("user", tpro);
			
		}
		
		else
		{
			mv.setViewName("profile.jsp");
			mv.addObject("status2", "Error Update !");
		}
		
		return mv;
	}
	
	
	
	
}
