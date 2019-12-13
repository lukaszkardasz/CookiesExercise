package pl.n2god;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/**
 * @author n2god on 13/12/2019
 * @project CookiesExercise
 */
@WebServlet(name = "CookieServlet", urlPatterns = "/CookieServlet")
public class CookieServlet extends HttpServlet {

	private static final int COOKIE_LIVE_TIME_IN_HOURS = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = request.getParameter("cookie");
		if ("create".equals(option)){
			Cookie cookie = createCookie();
			response.addCookie(cookie);
			request.getRequestDispatcher("cookieInfo.jsp").forward(request, response);
		} else if ("print".equals(option)){
			request.getRequestDispatcher("cookieInfo.jsp").forward(request, response);
		} else if ("remove".equals(option)){
			removeCookies(request, response);
			request.getRequestDispatcher("noCookie.jsp").forward(request, response);
		}
	}

	private Cookie createCookie() {
		Random random = new Random();
		String cookieName = "cookie" + random.nextInt(100); //nazwa + randomowa liczba
		String cookieValue = "value" + random.nextInt(1000);
		Cookie cookie = new Cookie(cookieName, cookieValue);
		cookie.setMaxAge(COOKIE_LIVE_TIME_IN_HOURS *60*60); //1h * 60 min * 60 sec
		return cookie;
	}

	private void removeCookies(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {
			c.setMaxAge(0);
			response.addCookie(c);
		}
	}
}
