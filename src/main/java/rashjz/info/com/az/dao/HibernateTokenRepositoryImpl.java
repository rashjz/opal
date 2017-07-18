package rashjz.info.com.az.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
//import org.apache.log4j.Logger; 
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rashjz.info.com.az.entity.PersistentLogins;

/**
 *
 * @author Rashad Javadov
 */
@Repository("tokenRepositoryDao")
@Transactional
public class HibernateTokenRepositoryImpl extends AbstractDao<String, PersistentLogins> implements PersistentTokenRepository {

//    static final Logger logger = Logger.getLogger(HibernateTokenRepositoryImpl.class);

    @Override
    public void createNewToken(PersistentRememberMeToken token) {
//        logger.info("Creating Token for user : {}"+ token.getUsername());
        PersistentLogins persistentLogin = new PersistentLogins();
        persistentLogin.setEmail(token.getUsername());
        persistentLogin.setSeries(token.getSeries());
        persistentLogin.setToken(token.getTokenValue());
        persistentLogin.setLastUsed(token.getDate());
        persist(persistentLogin);

    }

    @Override
    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
//        logger.info("Fetch Token if any for seriesId : {}"+ seriesId);
        try {
            Criteria crit = createEntityCriteria();
            crit.add(Restrictions.eq("series", seriesId));
            PersistentLogins persistentLogin = (PersistentLogins) crit.uniqueResult();

            return new PersistentRememberMeToken(persistentLogin.getEmail(), persistentLogin.getSeries(),
                    persistentLogin.getToken(), persistentLogin.getLastUsed());
        } catch (Exception e) {
//            logger.info("Token not found...");
            return null;
        }
    }

    @Override
    public void removeUserTokens(String username) {
//        logger.info("Removing Token if any for user : {}"+ username);
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("email", username));
        List<PersistentLogins> persistentLogin = (List<PersistentLogins>) crit.list();
        if (persistentLogin != null) {
            for (PersistentLogins persistentLogins : persistentLogin) {
//                logger.info("rememberMe was selected");
                delete(persistentLogins);
            }
        }

    }

    @Override
    public void updateToken(String seriesId, String tokenValue, Date lastUsed) {
//        logger.info("Updating Token for seriesId : {}"+ seriesId);
        PersistentLogins persistentLogin = getByKey(seriesId);
        persistentLogin.setToken(tokenValue);
        persistentLogin.setLastUsed(lastUsed);
        update(persistentLogin);
    }

}
