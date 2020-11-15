package com.nit.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.entity.Person;
import com.nit.utills.OracleHibernateUtil;

public class DataInsertion {
	
	public static void main(String[] args) {
		
		Session ses=OracleHibernateUtil.getSession();
		Transaction tx=null;
		Boolean flag=null;
		try {
			 
			if(!ses.getTransaction().isActive())
			       tx=ses.beginTransaction();
			
			Person per=new Person();
			per.setName("Sachin");
			per.setGender("Male");
			per.setAddress("BPL");
			
			//Collection
			List<String> friends=List.of("Kapil","Ajay","Shivam","Shubham");
		    Set<String> phones=Set.of("7697019105","7566581169","7354754534","8878354960");
			Map<String,String> family=Map.of("Father","Om Prakash","Mother","Urmila","Brother","Ashish","Sister","Shobha");
			
			per.setPhones(phones);
			per.setFriends(friends);
            per.setFamily(family);

            ses.save(per);
            flag=true;
		}
		catch(HibernateException he)
		{
			flag=false;
			he.printStackTrace();
		}
		catch(Exception e)
		{
			flag=false;
			e.printStackTrace();
		}
		finally
		{
			if(flag)
				{
				tx.commit();
				System.out.println("Objects Saved");
				}
			else
			{
				tx.rollback();
				System.out.println("Object not Saved");
			}
		}
		
	}

}
