package namedQuery;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {

	public static void main(String[] args) {
		Scanner sn=new Scanner(System.in);
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("namedQuery/hibernate.cfg.xml").build();
		Metadata md=new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf=md.getSessionFactoryBuilder().build();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		Employee e=new Employee();
		System.out.println("1.insert");
		System.out.println("2.named query");
		int n=sn.nextInt();
		switch(n) {
		case 1:
			e.setId(2);
			e.setName("Arun");
			e.setJob("software engineer");
			e.setSalary(40000);
			s.save(e);
			t.commit();
			s.close();
			sf.close();
			break;
		case 2:
			TypedQuery query=s.getNamedQuery("findEmployeeByName");
			query.setParameter("name", "Amalendu");
			List<Employee> li=query.getResultList();
			Iterator<Employee> itr=li.iterator();    
		     while(itr.hasNext()){    
		    Employee emp=itr.next();    
		    System.out.println(emp);    
		     }    
		    s.close();     
			break;
			
		}
	}
}
