package rashjz.info.com.az.util;
 
import rashjz.info.com.az.domain.AppUser;
import java.util.logging.Logger;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author Rashad Javadov
 */
public class SecurityUtil {

    private static final Logger LOGGER = Logger.getLogger(SecurityUtil.class.getName());

    public static void authenticateUser(AppUser userDetails) {
        LOGGER.info("Logging in principal: {}" + userDetails);
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication); 
    }
   
}
