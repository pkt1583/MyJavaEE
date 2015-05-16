import com.auth.model.UserInfo;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by pankaj on 16-05-2015.
 */
@Named("authenticationController")
@SessionScoped
public class AuthenticationController implements Serializable {
    protected final Logger logger=Logger.getLogger(getClass());

    @Inject  UserInfo loginInfo;
    public String authenticate(){
    logger.debug("Called from Authenticatino Controller");
       // logger.debug("Called with loginInfo "+loginInfo);
        return null;
    }
}
