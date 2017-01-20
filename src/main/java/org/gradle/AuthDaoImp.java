package org.gradle;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthDaoImp implements AuthDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Test authenticate(String userName, String password) {
		
		String hql = " FROM Test ";
		Session session = sessionFactory.openSession();
		List results = session
				.createQuery(hql).getResultList();
		return null;
				
	}
/*
	@Override
	public Object[] getUserDetails(String userName) {
		
		String hql = "SELECT fullName,address,email,phoneNo,role,U.suspendFlag "
					+"FROM User U WHERE userName = :userName";
		return (Object[]) sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter("userName", userName)
				.uniqueResult();
	}

	@Override
	public String checkToken(String token) {
		
		String hql = "SELECT token FROM UserSession WHERE token=:token";
		return  (String) sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter("token", token)
				.setMaxResults(1)
				.uniqueResult();
	}
	
	@Override
	public long getActiveLogins(String userName) {
		
		String hql = "SELECT COUNT(*) FROM UserSession WHERE user=(FROM User WHERE userName=:userName)";
		return  (long) sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter("userName", userName)
				.uniqueResult();
	}
	
	@Override
	public int removeActiveLogins(String userName) {
		
		String hql = "DELETE FROM UserSession WHERE user=(FROM User WHERE userName=:userName)";
		return  sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter("userName", userName)
				.executeUpdate();
	}

	@Override
	public String checkToken(String token, String userName) {
		
		String hql = "SELECT R.roleName FROM User U,UserSession S, Role R"
				+ " WHERE S.token = :token AND S.user = U AND U.userName = :userName"
				+ " AND U.role = R";
		return  (String) sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter("token", token)
				.setParameter("userName", userName)
				.setMaxResults(1)
				.uniqueResult();
	}
	
	@Override
	public String insertSession(UserSession sessionObj) {
		
		return (String) sessionFactory.getCurrentSession().save(sessionObj);
	}

	@Override
	public WorkerType getWorkerType(String userName) {
		return (WorkerType) sessionFactory.getCurrentSession().get(WorkerType.class, userName);
	}

	@Override
	public void deleteSession(UserSession sessionObj) {
		
		sessionFactory.getCurrentSession().delete(sessionObj);
	}

	@Override
	public Object getFullName(String userName) {
		
		String hql = "SELECT fullName FROM User WHERE userName=:userName";
		return sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter("userName", userName)
				.uniqueResult();
	}
	
	@Override
	public Object getRoleName(String userName) {
		
		String hql = "SELECT R.roleName FROM User U,Role R WHERE U.userName=:userName"
				+ " AND U.role=R";
		return sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter("userName", userName)
				.uniqueResult();
	}
	
	@Override
	public String getEmailId(String userName) {
		
		String hql = "SELECT email FROM User WHERE userName=:userName";
		return (String) sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter("userName", userName)
				.uniqueResult();
	}

	@Override
	public int updatePassword(String userName, String password,String newPassword) {
		
		String hql = "UPDATE User SET password=:newPassword WHERE userName=:userName AND"
				+ " password=:password";

		return sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter("userName", userName)
				.setParameter("password", password)
				.setParameter("newPassword", newPassword)
				.executeUpdate();
	}
	
	@Override
	public int updatePassword(String userName, String newPassword) {
		
		String hql = "UPDATE User SET password=:newPassword WHERE userName=:userName";

		return sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter("userName", userName)
				.setParameter("newPassword", newPassword)
				.executeUpdate();
	}

	@Override
	public String checkUserAccountFromEmail(String emailId) {
		
		String hql = "SELECT userName FROM User WHERE email=:emailId";
		return (String) sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter("emailId", emailId)
				.uniqueResult();
	}
	
	@Override
	public String checkUserAccountFromPhone(String phoneNo) {
		
		String hql = "SELECT userName FROM User WHERE phoneNo=:phoneNo";
		return (String) sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter("phoneNo", phoneNo)
				.uniqueResult();
	}
	
	@Override
	public int updatePassword(String userName, String newPassword, String token,
			String code, Timestamp date) {
		
		String hql = "UPDATE User U SET password=:newPassword WHERE U=(SELECT F.user"
				+ " FROM ForgotUser F, User U WHERE U.userName=:userName AND F.user=U AND"
				+ " F.token=:token AND F.code=:code"
				+ " AND F.expiryDate>:date)";
		return sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter("userName", userName)
				.setParameter("token", token)
				.setParameter("code", code)
				.setParameter("date", date)
				.executeUpdate();		
	}

	@Override
	public int deleteExpiredForgot(Timestamp currentTimestamp) {
		
		String hql = "DELETE FROM ForgotUser WHERE expiryDate<:current";
		return sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter("current", currentTimestamp)
				.executeUpdate();
	}

	@Override
	public String insertForgot(ForgotUser obj) {
		
		return (String) sessionFactory.getCurrentSession().save(obj);
	}

	@Override
	public int deleteForgot(String token) {
		
		String hql = "DELETE FROM ForgotUser WHERE token=:token";
		return sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter("token", token)
				.executeUpdate();
	}

	@Override
	public long checkForgotCode(String userName, String token, String code, Timestamp date) {
		
		String hql = "SELECT COUNT(*) FROM ForgotUser WHERE token=:token AND code=:code"
				+ " AND expiryDate>:date AND user=(FROM User WHERE userName=:userName)";
		return (long) sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter("token", token)
				.setParameter("code", code)
				.setParameter("date", date)
				.setParameter("userName", userName)
				.uniqueResult();				
	}

	@Override
	public int updateUserProfile(String userName, String fullName, String address, String email,
			String phoneNo) {
		
		String hql = "UPDATE User SET fullName=:fullName,address=:address,email=:email,"
				+ "phoneNo=:phoneNo WHERE userName=:userName";
		return sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter("fullName", fullName)
				.setParameter("address", address)
				.setParameter("email", email)
				.setParameter("phoneNo", phoneNo)
				.setParameter("userName", userName)
				.executeUpdate();
	}

	@Override
	public int suspendUser(String userName, boolean flag) {
		
		String hql = "UPDATE User SET suspendFlag=:flag WHERE userName=:userName";
		return sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter("userName", userName)
				.setParameter("flag", flag)
				.executeUpdate();
	}

	@Override
	public String getHostProp(String key) {
		
		String hql = "SELECT value FROM HostProp WHERE key=:key";
		return (String) sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter("key", key)
				.uniqueResult();
	}

	@Override
	public String checkForgotToken(String token) {
		
		String hql = "SELECT token FROM ForgotUser WHERE token=:token";
		return  (String) sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter("token", token)
				.setMaxResults(1)
				.uniqueResult();
	}*/
}
