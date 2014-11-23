/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.project1.jsf;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 *
 * @author maskimko
 */
@WebFilter(filterName = "logoutFilter", urlPatterns = "/faces/logout.xhtml")
public class LogoutFilter implements Filter  {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Logger.getLogger(this.getClass()).debug("LogoutFilter calls init method");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        String url = ((HttpServletRequest)request).getRequestURL().toString();
        String baseUrl  = url.substring(0, url.length() - ((HttpServletRequest)request).getRequestURI().length()) + ((HttpServletRequest)request).getContextPath() + "/";
        logout(session);
        Logger.getLogger(this.getClass()).debug("redirecting to " + baseUrl);
        ((HttpServletResponse)response).sendRedirect(baseUrl);
    }

    @Override
    public void destroy() {
        Logger.getLogger(this.getClass()).debug("LogoutFilter calls destroy method");
    }
    
    public void logout(HttpSession session){
        session.invalidate();
        Logger.getLogger(this.getClass()).info("Session has been invalidated");
    }
    
}
