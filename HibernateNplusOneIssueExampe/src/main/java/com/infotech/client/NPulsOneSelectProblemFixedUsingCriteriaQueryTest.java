package com.infotech.client;

import java.util.List;

import org.hibernate.Session;

import com.infotech.entities.Department;
import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;

public class NPulsOneSelectProblemFixedUsingCriteriaQueryTest {

	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			//List<Department> departments = session.createQuery("From Department", Department.class).getResultList();
			List<Department> departments = session.createQuery("From Department d JOIN fetch d.employees", Department.class).getResultList();

			for (Department department : departments) {
				System.out.println("Department details:::::");
				
				System.out.println(department.getId()+"\t"+department.getDeptName());
				List<Employee> employees = department.getEmployees();
				System.out.println("Employees details::::::");
				for (Employee employee : employees) {
					
					System.out.println(employee.getId() + "\t" + employee.getEmployeeName() + "\t" + employee.getUsername()
							+ "\t" + employee.getPassword() + "\t" + employee.getAccessLevel());
				}
				
			}
		}
	}
}
