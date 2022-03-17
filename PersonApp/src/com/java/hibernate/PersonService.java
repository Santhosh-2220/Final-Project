package com.java.hibernate;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
public class PersonService {
Configuration cfg=null;
SessionFactory sf = null;
Session s = null;
Transaction t =null;
public String addNewPerson(Person ps) {
cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");
sf = cfg.buildSessionFactory();
s = sf.openSession();
t = s.beginTransaction();
s.save(ps);
t.commit();
s.close();
sf.close();
return "Person is Created....";
}

public List<Person> showAllPersons(){
cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");
sf = cfg.buildSessionFactory();
s = sf.openSession();
Query<Person> query=s.createQuery("from Person");
List<Person> plist = query.list();
sf.close();
s.close();
return plist;
}

public Person searchPerson(int pid) {
cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");
sf = cfg.buildSessionFactory();
s = sf.openSession();
t = s.beginTransaction();
Query<Person> query=s.createQuery("from Person where Personid=:pid");
query.setParameter("pid", pid);
Person p = query.getSingleResult();
s.close();
sf.close();
return p;
}

public String updatePhone(Person ps) {
cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");
sf = cfg.buildSessionFactory();
s = sf.openSession();
t = s.beginTransaction();
Query q = s.createQuery("update Person set PhoneNumber=:pno where Personid=:pid");
q.setParameter("pno", ps.getPhoneNumber());
q.setParameter("pid", ps.getPersonid());
int r = q.executeUpdate();
t.commit();
s.close();
sf.close();
if(r>=1)
{
return "Phone number Updated Successfully";
}
else
return "Error Occured in updating number";
}

public String updateEmail(Person ps) {
cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");
sf = cfg.buildSessionFactory();
s = sf.openSession();
t = s.beginTransaction();
Query q = s.createQuery("update Person set Email=:pmail where Personid=:pid");
q.setParameter("pmail", ps.getEmail());
q.setParameter("pid", ps.getPersonid());
int r = q.executeUpdate();
t.commit();
s.close();
sf.close();
if(r>=1)
{
return "Email id is Updated Successfully";
}
else
return "Error Occured in Updation";
}

public String deletePerson(int pid) {
cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");
sf = cfg.buildSessionFactory();
s = sf.openSession();
t = s.beginTransaction();
Query q = s.createQuery("delete from Person where Personid=:pid");
q.setParameter("pid", pid);
int r = q.executeUpdate();

if(r>=1)
{
t.commit();
s.close();
sf.close();
return "Person is Deleted Successfully";
}
else
s.close();
sf.close();
return "Error Occured in Deletion";
}

public void showOptions() {
System.out.println("Select The Option");
System.out.println("1.Add new Person");
System.out.println("2.Show All Persons");
System.out.println("3.Search a Person");
System.out.println("4.Update Phone Number");
System.out.println("5.Update Email ID");
System.out.println("6.Delete Person");
System.out.println("7.Exit");
}
}

