package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.entity.ProgrammerProjectMgmtId;
import com.nit.entity.ProgrammerProjectMgmtInfo;
import com.nit.utils.HibernateUtill;

public class CompositeIDTest {

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
			id.setpId(102);
			id.setProjId(5004);
			
			//Prepare Entity CLass object
			proInfo=new ProgrammerProjectMgmtInfo();
			proInfo.setId(id);
			proInfo.setpName("SACHIN");
			proInfo.setProjName("STUDENT MGMT SYSTEM");
		    proInfo.setDeptName("DEVLOPMENT");
			
			session.save(proInfo);	
			flag=true;
			System.out.println("Object Saved");
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
       			System.out.println("Object not Saved");
			}
				
		}
		
		}
}
