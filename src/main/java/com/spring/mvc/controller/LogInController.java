package com.spring.mvc.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.dto.LoginDTO;
import com.spring.mvc.entity.Book;
import com.spring.mvc.entity.User;
import com.spring.mvc.service.UserService;

@Controller
public class LogInController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String loginPage(HttpServletRequest request,
			Map<String, String> errormap,
			@RequestParam(required = false) String error)
	{
		// GET
		if(error != null)
			errormap.put("error", error);
		System.out.println("login request "+request.getMethod());
//		List<String> roles = Arrays.asList("ADMIN","USER","DEV");
//		map.put("roles", roles);
		return "login";
	}
	
	@PostMapping("/login")
	public String loginPOstPage(LoginDTO dto, HttpServletRequest request,
			HttpSession session, HttpServletResponse resp, Model model, Map<String, String> map)
	{//ModelAndView mav= new ModelAndView();
		// POST
//		System.out.println("login request "+request.getMethod());
//		System.out.println("email "+dto.getEmail());
//		System.out.println("pwd "+dto.getPassword());
//		if(dto.getEmail().equals("admin@admin.com") && dto.getPassword().equals(("admin")))
//		{
//				session.setAttribute("email", dto.getEmail());
//				return "redirect:admin";
//		}
		try {
			if(this.userService.validateUser(dto))
			{
				
				//mav.setViewName("redirect:books");
				//Cookie cookie = new Cookie("email", dto.getEmail());
				session.setAttribute("email", dto.getEmail());
				//resp.addCookie(cookie);
				model.addAttribute("mode","loggedin");
				User user=userService.getUserByEmail(dto.getEmail());
				model.addAttribute("user", user.getUserName());
				map.put("user", user.getUserName());
				session.setAttribute("userName", user.getUserName());
				model.addAttribute("userEmail", user.getEmail());
				System.out.println(request.getAttribute("userEmail"));
				System.out.println(session.getAttribute("userName"));
				//mav.addObject("user",user.getUserName());
				return "redirect:books";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return "redirect:login?error=Invalid credentials";
			//return mav;
		}
		// failure => redirect (GET)
		return "redirect:login?error=Invalid credentials";
		//return mav;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session,
			HttpServletResponse resp,
			HttpServletRequest request)
	{
//		Cookie cookies[] = request.getCookies();
//		System.out.println(cookies.length);
//		for(Cookie cookie : cookies)
//		{
//			System.out.println(cookie.getName());
//			if(cookie.getName().equals("email"))
//				cookie.setMaxAge(0);
//			else if(cookie.getName().equals("JSESSIONID"))
//				cookie.setMaxAge(0);
//			resp.addCookie(cookie);
//		}
		session.removeAttribute("email");
		session.invalidate();
		return "redirect:index.jsp";
	}

}
