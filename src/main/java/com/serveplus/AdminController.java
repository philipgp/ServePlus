package com.serveplus;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.serveplus.data.dao.CompanyDao;
import com.serveplus.data.dao.UserDao;
import com.serveplus.data.entity.Address;
import com.serveplus.data.entity.Category;
import com.serveplus.data.entity.Company;
import com.serveplus.data.entity.CompanyAddress;
import com.serveplus.data.entity.CompanyService;
import com.serveplus.data.entity.Customer;
import com.serveplus.data.entity.Service;
import com.serveplus.data.entity.User;
import com.serveplus.data.entity.UserAddress;

@Controller
public class AdminController {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	CompanyDao companyDao;

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
		Set<UserAddress> address = custoemrs.get(0).getUserAddresses();
		for(UserAddress add:address){
			Address addre = add.getUserAddressId().getAddress();
			System.out.println(addre);
		}
		person.setAge(232);
	return person;	
	}
	@RequestMapping(value = "/getAllCompanies", method = RequestMethod.GET)
	@ResponseBody
	public Person getAllCompanies(HttpServletResponse response){
		/*try {
			response.getWriter().println("ok");
			response.setStatus(200);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		List<Company> custoemrs = companyDao.getAllCompanies();
		Set<CompanyService> services = custoemrs.get(0).getCompanyServices();
		
		for(CompanyService service:services){
			Service cat = service.getCompanyServiceId().getService();
			System.out.println(cat);
		}
		
		Set<CompanyAddress> compadd = custoemrs.get(0).getCompanyAddresses();
				
				for(CompanyAddress service:compadd){
					Address cat = service.getCompanyAddressId().getAddress();
					System.out.println(cat);
				}
		
	return null;	
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
