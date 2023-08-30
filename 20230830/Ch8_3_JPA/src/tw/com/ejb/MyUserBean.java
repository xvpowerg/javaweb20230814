package tw.com.ejb;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import tw.com.jpa.MyUser;

@Stateless
public class MyUserBean implements MyUserBeanLocal{
		@Inject
		private EntityManager em;

		@Override
		public boolean login(MyUser myUser) {
			// TODO Auto-generated method stub
		   MyUser tmpUser = findUserByAccount(myUser.getAccount());
			if (tmpUser == null ) return false;
			return myUser.equals(tmpUser);
		}

		@Override
		public boolean register(MyUser myUser) {
			// TODO Auto-generated method stub
			try {
				em.persist(myUser);
				return true;				
			}catch(Exception ex) {
				System.out.println(ex);
			}
			
			return false;
		}

		@Override
		public MyUser findUserByAccount(String account) {
			// TODO Auto-generated method stub
			MyUser myUser = null;
			 TypedQuery<MyUser> query= em.createNamedQuery("findMyUser",MyUser.class);
			 query.setParameter("account", account);
			 try {
				 myUser = query.getSingleResult();
				 return myUser;
			 }catch(Exception ex) {
				 System.out.println(ex);
			 }
			 
			return null;
		}

		@Override
		public boolean deleteUser(MyUser myUser) {
			// TODO Auto-generated method stub
			try {
				myUser = em.merge(myUser);
				em.remove(myUser);
				return true;
			}catch(Exception ex) {
				System.out.println(ex);
			}
			return false;
		}

		
}
