package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import database.UserDetailsDao;
import models.UserDetails;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		try {
			super.init();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		UserDetails ud = new UserDetailsDao().validate("", "");

		if (ud != null) {
			resp.addCookie(new Cookie("user", new Gson().toJson(ud)));
			resp.addHeader("name", ud.getName());
			resp.addHeader("surname", ud.getSurname());
			resp.addHeader("status", "ok");
		} else {
			resp.addHeader("status", "error");
		}
		super.doPost(req, resp);
	}
}
