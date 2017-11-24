package com.viscount.freedom.auth;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

@Component
public class AuthenticationTokenProcessingFilter extends GenericFilterBean {

	@Autowired
	UserDetailsService userService;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = this.getAsHttpRequest(request);

		String authToken = this.extractAuthTokenFromRequest(httpRequest);

		if (authToken != null) {
			String userName = TokenUtils.getUserNameFromToken(authToken);

			HttpSession session = httpRequest.getSession(false);
			if(session != null){
				UserDetails userDetails = this.userService
						.loadUserByUsername(userName);
				if (userDetails != null
						&& TokenUtils.validateToken(authToken, userDetails)) {
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
					authentication
							.setDetails(new WebAuthenticationDetailsSource()
									.buildDetails(httpRequest));
					SecurityContextHolder.getContext().setAuthentication(
							authentication);
			}

			}
		}

		chain.doFilter(request, response);
	}

	/**
	 * This method is used to convert request object from ServletRequest to HttpServletRequest
	 * @param request
	 * @return
	 */
	private HttpServletRequest getAsHttpRequest(ServletRequest request) {
		if (!(request instanceof HttpServletRequest)) {
			throw new RuntimeException("Expecting an HTTP request");
		}

		return (HttpServletRequest) request;
	}

	/**
	 * This method is used to extract token from HttpServletRequest header
	 * @param httpRequest
	 * @return
	 */
	private String extractAuthTokenFromRequest(HttpServletRequest httpRequest) {
		/* Get token from header */
		String authToken = httpRequest.getHeader("X-Auth-Token");

		/* If token not found get it from request parameter */
		if (authToken == null) {
			authToken = httpRequest.getParameter("token");
		}

		return authToken;
	}
}