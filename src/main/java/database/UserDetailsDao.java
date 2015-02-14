package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import models.UserDetails;

public class UserDetailsDao {
	private static final String statement = "select * from users where email=?";

	public UserDetails validate(String email, String pass) {
		try {
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/cisco?user=root&password=TENEKE");
			PreparedStatement ps = conn.prepareStatement(statement);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				UserDetails user = new UserDetails();
				user.setEmail(rs.getString("email"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setSurname(rs.getString("surname"));
				if (!user.getPassword().equals(pass))
					return null;
				return user;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
