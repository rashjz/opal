package rashjz.info.com.az.security;

import java.util.ArrayList;
import java.util.List; 
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rashjz.info.com.az.entity.UserRoles;
import rashjz.info.com.az.entity.Users;
import rashjz.info.com.az.service.UserService;

/**
 *
 * @author Rashad Javadov
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

//    private static final Logger logger = Logger.getLogger(CustomUserDetailsService.class.getName());

    @Autowired
    private UserService userService;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String ssoId) throws UsernameNotFoundException {
        Users user = userService.findByUsername(ssoId);
//        logger.info("User : {}"+ user.toString() + " " + user.getUserRolesCollection());
        if (user == null) {
//            logger.info("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new rashjz.info.com.az.domain.AppUser(user, user.getUsername(), user.getPassword(), true, true, true, true, getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(Users user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//        logger.info("authorities : {}"+ user.getUserRolesCollection().size());
        for (UserRoles grantedAuthority : user.getUserRolesCollection()) {
//            logger.info("grantedAuthority : {}"+ grantedAuthority);
            authorities.add(new SimpleGrantedAuthority(grantedAuthority.getRole()));
        }
        return authorities;
    }

}
