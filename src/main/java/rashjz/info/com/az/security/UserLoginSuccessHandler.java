/////*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package rashjz.info.com.az.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import rashjz.info.com.az.domain.AppUser;
import rashjz.info.com.az.entity.UserRoles;
import rashjz.info.com.az.entity.Users;

/**
 *
 * @author Rashad Javadov
 */
public class UserLoginSuccessHandler implements AuthenticationSuccessHandler {

    private static final Logger LOG = Logger.getLogger(UserLoginSuccessHandler.class.getName());

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        LOG.info("onAuthenticationSuccess : :");
        HttpSession session = httpServletRequest.getSession();
        
        //getting AppUser data from Principal
        AppUser authUser = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        LOG.info("successfull login " + authUser.getUsers().toString());
        //define some user details 
        if (authUser.getUsers().getNote().equals("") && authUser.getUsers().getNote() == null) {
            authUser.getUsers().setNote("https://x1.xingassets.com/assets/frontend_minified/img/users/nobody_m.original.jpg");
        }

        session.setAttribute("username", authUser.getUsername());
        session.setAttribute("authorities", authentication.getAuthorities());
        //set our response to OK status
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);

        Users user = authUser.getUsers();
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (UserRoles grantedAuthority : user.getUserRolesCollection()) {
            authorities.add(new SimpleGrantedAuthority(grantedAuthority.getRole()));
        }

        if (authorities.get(0).getAuthority().equals("ROLE_ADMIN")) {
            httpServletResponse.sendRedirect("admin/indexAdmin");
        } else if (authorities.get(0).getAuthority().equals("ROLE_USER")) {
            httpServletResponse.sendRedirect("checkout");
        }

    }

}
