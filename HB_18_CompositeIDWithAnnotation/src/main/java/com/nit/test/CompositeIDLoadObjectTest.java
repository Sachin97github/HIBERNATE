package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.entity.ProgrammerProjectMgmtId;
import com.nit.entity.ProgrammerProjectMgmtInfo;
import com.nit.utils.HibernateUtill;

public class CompositeIDLoadObjectTest {

	public static void main(String[] args) {
	
		Session session=null;
		Transaction tx=null;
		ProgrammerProjectMgmtInfo proInfo=null;
		Boolean flag=false;
		
		session=HibernateUtill.openSession();
			tx=session.beginTransaction();
			
		try
		{
			//Prepare Object having Ids
			ProgrammerProjectMgmtId id=new ProgrammerProjectMgmtId();
			id.setpId(106);
			id.setProjId(5004);
			
			proInfo=session.get(ProgrammerProjectMgmtInfo.class, id);
			System.out.println(proInfo);
			flag=true;
			System.out.println("Object Fetched");
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(flag)
				tx.commit();
			else
			{
       			tx.rollback();
       			System.out.println("Object not Fetched");
			}
				
		}
		
		}
}
