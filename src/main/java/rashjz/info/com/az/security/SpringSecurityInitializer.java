/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 *
 * @author Rashad Javadov
 */
public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer { 
    public SpringSecurityInitializer() {
        super(MVCSecurityConfig.class);
    }
}
