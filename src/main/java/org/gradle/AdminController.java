package org.gradle;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.serveplus.data.dao.UserDao;
import com.serveplus.data.entity.Customer;
import com.serveplus.data.entity.User;

@Controller
public class AdminController {
	
	@Autowired
	UserDao userDao;

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
		
		List<User> custoemrs = userDao.getAllUsers();
		person.setAge(232);
	return person;	
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	@ResponseBody
	public Person getAllDeptType2(){

		
		User  user1 = new User();
		user1.setId(2L);
		user1.setFirstName("new firstname");
		userDao.save(user1);
	return null;
	}
}
