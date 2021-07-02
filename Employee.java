package empsql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public abstract class Employee {
	protected String name, desig;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesig() {
		return desig;
	}

	public void setDesig(String desig) {
		this.desig = desig;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	protected int age, salary;
	
	Scanner sc = new Scanner(System.in);
	Statement st = null;
	ResultSet rs = null;
	Connection con = null;

	public void Create() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "tiger");
			st = con.createStatement();
			System.out.println("Enter name:");
			this.name = sc.next();
			System.out.println("Enter age:");
			this.age = sc.nextInt();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Display() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "tiger");
			st = con.createStatement();
			rs = st.executeQuery("select * from employee;");
			while (rs.next()) {
				System.out.print("Name: " + rs.getString("name") + "  ");
				System.out.print("Age: " + rs.getInt("age") + "  ");
				System.out.print("Salary: " + rs.getInt("salary") + "  ");
				System.out.print("Designation: " + rs.getString("desig") + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public abstract void SalaryRise();

	public abstract void Cre();

}



