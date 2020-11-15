package com.nit.threads;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.model.Project;

public class MyThread implements Runnable {

	private Session ses = null;
	private Project proj = null;

	public MyThread(Session ses, Project proj) {
		super();
		this.ses = ses;
		this.proj = proj;
	}

	@Override
	public void run() {
		Transaction tx = null;
		Boolean status = null;
		Integer idVal = null;

		try {
			tx = ses.beginTransaction();
			idVal = (Integer) ses.save(proj);
			status = true;
			System.out.println(Thread.currentThread().getName());
			System.out.println("Generated Value :: " + idVal);

		} catch (HibernateException e) {
			status = false;
			e.printStackTrace();
		} finally {
			if (status)
				tx.commit();
			else
				tx.rollback();
		}

	}

}
