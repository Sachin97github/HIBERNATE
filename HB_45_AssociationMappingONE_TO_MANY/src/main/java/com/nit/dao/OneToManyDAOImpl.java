package com.nit.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.nit.entity.Person;
import com.nit.entity.PhoneNumber;

public class OneToManyDAOImpl implements OneToManyDAO {

	private Session ses = null;

	public OneToManyDAOImpl(Session ses) {
		this.ses = ses;
	}

	@Override
	public void getPerson(Integer id) {
		Person person = ses.get(Person.class, 1);
		System.out.println(person);
	}

	@Override
	public void deletePerson(Integer id) {
		Person per = new Person();
		per.setId(id);
		ses.delete(per);
		System.out.println("Object Deleted");
	}

	@Override
	public void addPhoneNumberToPerson(Integer id, PhoneNumber ph) {
		Person per = new Person();
		per = ses.load(Person.class, id);
		Set<PhoneNumber> set = per.getPhones();
		set.add(ph);
		// ses.saveOrUpdate(per);
		// Objects and Tables Are Synchornized Together without Save Or Upadate It Will
		// Reflect
	}

	@Override
	public void removePhoneNumberFromPerson(Integer id, PhoneNumber ph) {
		Person per = ses.get(Person.class, id);
		Set<PhoneNumber> setPh = per.getPhones();
		setPh.remove(ph);
	}

	@Override
	public void fetchPhoneNumberByType(String numberType) {

		Query<PhoneNumber> query = ses.createQuery("from com.nit.entity.PhoneNumber where numberType = ?1");
		// query.setString(1,"HOME"); depricated
		query.setParameter(1, numberType);
		List<PhoneNumber> list = query.getResultList();
		list.forEach(System.out::println);
	}

	@Override
	public void removeAllPhoneNumberFromAPerson(Integer id) {

		Person per = ses.get(Person.class, id);

	}

	@Override
	public void removeAllPersonByHQL() {
		Query qry = ses.createQuery("delete from com.nit.entity.Person ");
		int count = qry.executeUpdate();
		System.out.println(count + "  Rows deleted");
	}

	@Override
	public void removeAllPersonOneByOne() {
		Query<Person> qry = ses.createQuery("from com.nit.entity.Person");
		List<Person> list = qry.getResultList();
                  
		if(!list.isEmpty())
		{
			// delete ONE by ONE
	     	list.forEach(person -> {
	     		ses.delete(person);
	     		System.out.println("DELETED [ "+person+" ]");
				
			});
		}
		else
		{
			System.out.println("No Record Found to delete");
		}
	}

	@Override
	public void removeAllChildsToParent(Integer personId) {
	     Person per=ses.get(Person.class,personId);
	    Set<PhoneNumber> ph=per.getPhones();
	     ph.removeAll(ph);
	     System.out.println(per.getName()+"'s ALL NUMBERS ARE DELETED");    
	}


}
