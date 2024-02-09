package sample;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;



public class Main {
	public static void main(String[] args) {
		int n=0;
		do {
		Scanner sn=new Scanner(System.in);
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("sample/hibernate.cfg.xml").build();
		Metadata md=new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf=md.getSessionFactoryBuilder().build();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		Student stud=new Student();
		
		System.out.println("1.insert");
		System.out.println("2.select");
		System.out.println("3.update");
		System.out.println("4.Maximum");
		System.out.println("5.Minimum");
		System.out.println("6.Sum");
		System.out.println("7.Average");
		System.out.println("8.Count");
		n=sn.nextInt();
		
		switch(n)
		{
		case 1:
			stud.setName("Reebu");
			stud.setBranch("IT");
			s.save(stud);
			t.commit();
			s.close();
			sf.close();
			break;
		case 2:
			Query q=s.createQuery("from Student");
			List<Student> li=q.list();
			for(Student st:li)
			{
				System.out.println(st.getId());
				System.out.println(st.getName());
				System.out.println(st.getBranch());
			}
			break;
		case 3:
			Query qs=s.createQuery("update Student set name=:n ,branch=:b where id=:i");
			qs.setParameter("i", 3);
			qs.setParameter("n", "Anuja");
			qs.setParameter("b", "CS");
			int status=qs.executeUpdate();
			System.out.println(status);
			t.commit();
			break;
		case 4:
			Query qmax=s.createQuery("select max(id) from Student");
			List<Integer> list=qmax.list();
			System.out.println(list.get(0));
			s.close();
			sf.close();
			break;
		case 5:
			Query qmin=s.createQuery("select min(id) from Student");
			List<Integer> lmin=qmin.list();
			System.out.println(lmin.get(0));
			s.close();
			sf.close();
			break;
		case 6:
			long qsum=(long) s.createQuery("select sum(id) from Student").getSingleResult();
			System.out.println(qsum);
			s.close();
			sf.close();
			break;
		case 7:
			double qavg=(double) s.createQuery("select avg(id) from Student").getSingleResult();
			System.out.println(qavg);
			s.close();
			sf.close();
			break;
		case 8:
			long qct=(long) s.createQuery("select count(id) from Student").getSingleResult();
			System.out.println(qct);
			s.close();
			sf.close();
			break;
		}
		}while(n<8);
	}

}
