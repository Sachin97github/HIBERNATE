package com.nit.dao;

import com.nit.entity.PhoneNumber;

public interface OneToManyDAO {

	public void getPerson(Integer id);
    public void addPhoneNumberToPerson(Integer id,PhoneNumber ph);
    public void fetchPhoneNumberByType(String numberType); 
    public void deletePerson(Integer id);	
    public void removePhoneNumberFromPerson(Integer id,PhoneNumber ph);
    
    public void removeAllPersonByHQL();
    public void removeAllPersonOneByOne();
    
    public void removeAllChildsToParent(Integer personId);
    
    public void removeAllPhoneNumberFromAPerson(Integer personId);
    
}
