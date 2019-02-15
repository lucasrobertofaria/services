package br.gov.prodemge.service.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.prodemge.service.util.JWTUtil;

@WebFilter(urlPatterns = "/rest/api/*")
public class JWTFilter implements Filter {

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse res = (HttpServletResponse) arg1;

//				if (req.getRequestURI().startsWith("/api/login")) {
//					filterChain.doFilter(servletRequest, servletResponse);
//					return;
//				}

		String token = req.getHeader(JWTUtil.TOKEN_HEADER);

		if (token == null || token.trim().isEmpty()) {
			res.setStatus(401);
			return;
		}

		if (JWTUtil.validate(token)) {
			String id = JWTUtil.decode(token);
			System.out.println("User request: " + id);
			arg2.doFilter(arg0, arg1);
		}

	}

}
