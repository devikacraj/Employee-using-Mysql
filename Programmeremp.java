package empsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

final class Programmeremp extends Employee {
	Statement st = null;
	ResultSet rs = null;
	Connection con = null;

	public void Cre() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "tiger");
			st = con.createStatement();
			Create();
			st.executeUpdate("insert into employee(name,age,salary,desig)values(" + "'" + super.name + "'" + ","
					+ super.age + "," + "30000,'Programmer');");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void SalaryRise() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "tiger");
			st = con.createStatement();
			st.executeUpdate("update employee set salary=35000 where desig='Programmer';");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
