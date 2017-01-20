package org.gradle;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminController {
	
	@Autowired
	AuthDao authDao;

	@RequestMapping(value = "/getAllDeptType", method = RequestMethod.GET)
	@ResponseBody
	public Person getAllDeptType(HttpServletResponse response){
		/*try {
			response.getWriter().println("ok");
			response.setStatus(200);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		Person person = new Person("new person");
		Test result = authDao.authenticate("", "");
		person.setAge(232);
	return person;	
	}
	
	@RequestMapping(value = "/getAllDeptType2", method = RequestMethod.POST)
	@ResponseBody
	public Person getAllDeptType2(@RequestBody Person person){

		
		person.setAge(232);
	return person;	
	}
}
