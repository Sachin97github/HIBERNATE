package com.nit.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nit.entity.Student;
import com.nit.utills.OracleHibernateUtil;

public class StudentDAOImpl implements IStudentDAO {

	private Session ses;
	private Transaction tx;

	public StudentDAOImpl() {
		ses = OracleHibernateUtil.getSession();
	}

	@Override

	public void addStudent(Student std) {
		Session ses=OracleHibernateUtil.getSession();
		Transaction tx=null;
		boolean flag = false;
		try {
			if (!ses.getTransaction().isActive())
				tx = ses.beginTransaction();
			ses.save(std);
			flag = true;
		} catch (HibernateException ex) {
			ex.printStackTrace();
			flag = false;
		} finally {
			if (flag) {
				tx.commit();
				System.out.println("Object Saved");
			} else {
				tx.rollback();
				System.out.println("Object not Saved");
			}
		}
	}

	@Override
	public void getAllStudent() {

		if (!ses.getTransaction().isActive())
			tx = ses.beginTransaction();
		Query<Student> qry = ses.createQuery("from com.nit.entity.Student");
		List<Student> list = qry.getResultList();
		list.forEach(std -> {
			System.out.println("Proxy/Non Proxy :: " + std.getClass().getName());
			System.out.println("Id - " + std.getId());
			System.out.println("Name - " + std.getName());
			System.out.println("Contact - " + std.getContact());
			System.out.println("Email - " + std.getEmail());
			System.out.println("Address - " + std.getAddress());

			System.out.println("Course");
			System.out.println(std.getCourse());

		});

	}

	@Override
	public void deleteStudent(Integer id) {

		boolean flag = false;
		try {
			if (!ses.getTransaction().isActive())
				tx = ses.beginTransaction();
			Student std = new Student();
			std.setId(id);
			ses.delete(std);
			flag = true;
		} catch (HibernateException ex) {
			ex.printStackTrace();
			flag = false;
		} finally {
			if (flag) {
				tx.commit();
				System.out.println("Object Deleted");
			} else {
				tx.rollback();
				System.out.println("Object not Deleted");
			}
		}
	}

	@Override
	public void deleteStudentAfterLoading(Integer id) {
		boolean flag = false;
		try {
			if (!ses.getTransaction().isActive())
				tx = ses.beginTransaction();
			Student std = ses.load(Student.class, id);
			ses.delete(std);
			flag = true;
		} catch (HibernateException ex) {
			ex.printStackTrace();
			flag = false;
		} finally {
			if (flag) {
				tx.commit();
				System.out.println("Object Deleted");
			} else {
				tx.rollback();
				System.out.println("Object not Deleted");
			}
		} // TODO Auto-generated method stub

	}

	@Override
	public void deleteAllStudentHQL() {

		int count=0;
		if (!ses.getTransaction().isActive())
			tx = ses.beginTransaction();
		try {

			Query qry = ses.createQuery("delete from com.nit.entity.Student");
			count = qry.executeUpdate();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			if (count!=0) {
				tx.commit();
				System.out.println(count+" Objects  Deleted");
			} else {
				tx.rollback();
				System.out.println("Object not Deleted");
			}
		} //

	}
 @Override
	public void deleteAllStudentAfterLoading() {
	 boolean flag=false;
		if (!ses.getTransaction().isActive())
			tx = ses.beginTransaction();
		try {
			Query<Student> qry = ses.createQuery(" from com.nit.entity.Student");
		     List<Student> list=qry.getResultList();
		     list.forEach(std->{
		    	 ses.delete(std);
		    });
					flag=true;
			} catch (HibernateException ex) {
			ex.printStackTrace();
			flag=false;
		} finally {
			if (flag) {
				tx.commit();
				System.out.println(" Objects  Deleted");
			} else {
				tx.rollback();
				System.out.println("Object not Deleted");
			}
		} //
	 
	 
	 
	 
	}
}
