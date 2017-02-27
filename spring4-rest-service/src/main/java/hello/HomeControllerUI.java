package hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeControllerUI {

	@RequestMapping("/login")
	public ModelAndView login() {
		System.out.println("HomeControllerUI-login");
		return new ModelAndView("login");
	}

}
