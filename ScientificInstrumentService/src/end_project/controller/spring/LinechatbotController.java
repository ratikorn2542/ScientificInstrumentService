package end_project.controller.spring;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Class_End_Project.*;
import Manager.DormManager;
import line.LineConvertCode;

@Controller
public class LinechatbotController {

	@RequestMapping(value = "/lineRegister", method = RequestMethod.GET)
	public ModelAndView gotoRegister(HttpServletRequest request, HttpSession session) throws SQLException, IOException {
		ModelAndView mav = new ModelAndView("");
		
		//Student stu = (Student) session.getAttribute("stuProfile");
		Personnel personnel = (Personnel)session.getAttribute("personnel");
		if(personnel!=null) {
			
			DormManager dmg = new DormManager();
			LineConvertCode lcc = new LineConvertCode();
			String id = request.getParameter("code");
			System.out.println(id);
			Boxtoken bt = lcc.setAuthorizationCode(id);
			System.out.println(bt.getAccess_token());
	
			int x = dmg.addLineTokenSP(personnel.getPersonnel_ID(), bt.getAccess_token());
			if (x == 0) {
				System.out.println("ERROR TOKEN" + x);
			} else {
				System.out.println("INSERT TOKEN" + x);
			}
			mav = new ModelAndView("index");
		}else {
			mav = new ModelAndView("LoginPage");
		}
		return mav;

	}
	
}
