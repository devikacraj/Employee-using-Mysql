package empsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Statement st = null;
		ResultSet rs = null;
		Connection con = null;
		Employee clerk = new Clerkemp();
		Employee programmer = new Programmeremp();
		Employee manager = new Manageremp();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "tiger");
			st = con.createStatement();
			Scanner sc = new Scanner(System.in);
			int ch = 0, choice = 0, i = 0;
			do {
				System.out.println("1.Create\n2.Display\n3.Salary Rise\n4.Exit");
				ch = sc.nextInt();
				if (ch == 4)
					break;
				switch (ch) {
				case 1:
					do {
						System.out.println("1.Clerk \n2.Programmer \n3.Manager \n4.Exit");
						choice = sc.nextInt();
						if (choice == 4)
							break;
						switch (choice) {
						case 1:
							clerk.Cre();
							break;
						case 2:
							programmer.Cre();
							break;
						case 3:
							manager.Cre();
							break;
						case 4:
							break;
						default :
								System.out.println("Invalid choice!!");
						}
					} while (choice != 4);
					break;
				case 2:
					clerk.Display();
					break;
				case 3:
					clerk.SalaryRise();
					programmer.SalaryRise();
					manager.SalaryRise();
					System.out.println("Salary Rised!!");
					break;
				case 4:
					break;
				default:
					System.out.println("Invalid Choice.");
					break;
				}
			} while (ch != 4);

		} catch (Exception e) {
			System.out.println("Exception caught" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}