package com.java.hibernate;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
public class PersonTest {
public static void main(String[] args) {
// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);
PersonService ob=new PersonService();

int opt=0;
while(opt<8) {
ob.showOptions();
do {
System.out.println("Enter a Option");
opt=sc.nextInt();
}

while(opt>7);
if(opt==1) {
Person ps=new Person();
System.out.println("Enter person's name");
ps.setPersonName(sc.next());
while(true) {
System.out.println("Enter the gender");
String g=sc.next();
if(g.equalsIgnoreCase("Male") || g.equalsIgnoreCase("Female")) {
ps.setGender(g);
break;
}
System.out.println("Enter Valid gender");
}
System.out.println("Enter person's location");
ps.setLocation(sc.next());
while(true) {
System.out.println("Enter Phone Number");
String ph=sc.next();
if(ph.matches("^[987]{1}[0-9]{9}")) {
ps.setPhoneNumber(ph);
break;
}
System.out.println("Enter Valid Number");
}
while(true) {
System.out.println("Enter Email ID");
String em=sc.next();
if(em.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")) {
ps.setEmail(em);
break;
}
System.out.println("Enter a Valid email");
}
System.out.println(ob.addNewPerson(ps));
}

else if(opt==2) {
List<Person> plist=ob.showAllPersons();
for(Person p: plist)
{
System.out.println(p.getPersonid() + "\t" + p.getPersonName() + "\t" + p.getGender() + "\t" + p.getLocation() + "\t" + p.getPhoneNumber()+"\t"+p.getEmail());
}
}


else if(opt==3) {
System.out.println("Enter person id to get details");
int pid = sc.nextInt();
try {
Person p=ob.searchPerson(pid);
System.out.println(p.getPersonid() + "\t" + p.getPersonName() + "\t" + p.getGender() + "\t" + p.getLocation() + "\t" + p.getPhoneNumber()+"\t"+p.getEmail());
}catch(Exception e) {
System.out.println("Person is not found");
}
}


else if(opt==4) {
Person ps=new Person();
while(true) {
System.out.println("Enter New Phone Number");
String ph=sc.next();
if(ph.matches("^[987]{1}[0-9]{9}")) {
ps.setPhoneNumber(ph);
break;
}
System.out.println("Enter Valid Number");
}
while(true) {
System.out.println("Person id to modify");
int pid=sc.nextInt();
try {
if(!(ob.searchPerson(pid)==null)) {
ps.setPersonid(pid);;
break;
}
}catch(Exception e) {
System.out.println("Enter Valid Person ID");
}
}
System.out.println(ob.updatePhone(ps));
}


else if(opt==5) {
Person ps=new Person();
while(true) {
System.out.println("Enter New Email ID of Person");
String em=sc.next();
if(em.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")) {
ps.setEmail(em);
break;
}
System.out.println("Enter a Valid email");
}
while(true) {
System.out.println("Person id to modify");
int pid=sc.nextInt();
try {
if(!(ob.searchPerson(pid)==null)) {
ps.setPersonid(pid);;
break;
}
}catch(Exception e) {
System.out.println("Enter Valid Person ID");
}
}
System.out.println(ob.updateEmail(ps));
}

else if(opt==6) {
System.out.println("Enter person id to Delete");
int pid = sc.nextInt();
System.out.println(ob.deletePerson(pid));
}

else if(opt==7) {
System.out.println("Thank You for using Application");
System.exit(0);
}
}
}
}

