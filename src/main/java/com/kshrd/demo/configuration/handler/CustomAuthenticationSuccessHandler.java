package com.kshrd.demo.configuration.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(24 * 60 * 60);
		
		System.out.println("Login success");
		
		String redirectUrl = (String) request.getSession().getAttribute("REDIRECT_SUCCESS_URL");
		
		if (redirectUrl == null) {
			for(GrantedAuthority auth : authentication.getAuthorities()) {
				if (auth.getAuthority().equals("ROLE_ADMIN"))
					redirectUrl = "/admin";
				else if (auth.getAuthority().equals("ROLE_EDITOR"))
					redirectUrl = "/editor";
				else if (auth.getAuthority().equals("ROLE_USER"))
					redirectUrl = "/user";
				else
					redirectUrl = "/";
			}
		}
		
		response.sendRedirect(redirectUrl);
	}

	
	
	
}
