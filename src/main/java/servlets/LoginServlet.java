package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import database.UserDetailsDao;
import models.UserDetails;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		super.init();
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// System.out.println(req.);

		System.out.println(req.getAttribute("email"));

		UserDetails ud = new UserDetailsDao().validate("zoki.zver@gmail.com",
				"zokizver");
		if (ud != null) {
			resp.addCookie(new Cookie("user", new Gson().toJson(ud)));
			resp.setContentType("application/json");
			resp.setCharacterEncoding("utf-8");
			resp.getWriter().write(new Gson().toJson(ud));
		} else {
			System.out.println("ne");
		}

	}
}
