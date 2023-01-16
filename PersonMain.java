package one_to_one_uni1.controller;

import java.util.Scanner;


import one_to_one_uni1.dao.PersonDao;
import one_to_one_uni1.dto.Pancard;
import one_to_one_uni1.dto.Person;

public class PersonMain {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		boolean flag=true;
		do {
			System.out.println("Enter your choice \n 1.save person \n 2.update person \n 3.delete person \n 4.getby id \n 5.getall persons \n 6.exit");
			int ch=sc.nextInt();
			switch (ch) {
			case 1:{
				System.out.println("Enter pan id");
				String panid=sc.next();
				System.out.println("Enter name ");
				String name=sc.next();
				System.out.println("Enter your address");
				String address=sc.next();
				
				Pancard pancard=new Pancard();
				pancard.setPanid(panid);
				pancard.setName(name);
		
				pancard.setAddress(address);
				
				
				
				System.out.println("Enter your id");
				int id=sc.nextInt();
				System.out.println("Enter your name");
				String namep=sc.next();
				System.out.println("Enter your phone");
				long phone=sc.nextLong();
				System.out.println("Enter your address");
				String addressp=sc.next();
				System.out.println("Enter your mail id");
				String email=sc.next();
				
				Person person=new Person();
				
				person.setId(id);
				person.setName(namep);
				person.setPhone(phone);
				person.setAddress(addressp);
				person.setEmail(email);
				person.setPancard(pancard);
				
				PersonDao dao=new PersonDao();
				dao.savePerson(person);
			}break;
			
			case 2:{
				
				System.out.println("Enter person id");
				int id=sc.nextInt();
				System.out.println("Enter name ");
				String name=sc.next();
				Pancard pancard=new Pancard();
				Person person=new Person();
				
				person.setName(name);
				PersonDao dao=new PersonDao();
				dao.updatePerson(id,name);
				
				
			}break;
			
			
			case 3:{
				System.out.println("Enter person id");
				int id=sc.nextInt();
				PersonDao dao=new PersonDao();
				dao.deletePerson(id);
				
				
			}break;
				
			case 4: {
				System.out.println("Enter person id");
				int id=sc.nextInt();
				PersonDao dao=new PersonDao();
				dao.getPersonById(id);
				
			}break;
			
			case 5:{
				PersonDao dao=new PersonDao();
				Pancard pancard=new Pancard();
				Person person=new Person();
				dao.getAllPersons();
			}break;
			
			case 6:{
				flag=false;
			}
			

			default:
			
			}
			
		}while(flag);

	}

}
