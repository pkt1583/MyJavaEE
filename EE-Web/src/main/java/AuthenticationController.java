import com.auth.model.UserInfo;
import com.myee.model.AuthenticationInformation;
import com.myee.service.AuthenticationBean;
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
    @EJB AuthenticationBean authenticationBean;
    public String authenticate(){
        logger.debug("Got request to Authenticate "+loginInfo);
        AuthenticationInformation authenticationInformation=new AuthenticationInformation();
        authenticationInformation.setUserName(loginInfo.getUserId());
        authenticationInformation.setPassword(loginInfo.getPassword());
        authenticationBean.authenticate(authenticationInformation);
        return authenticationInformation.getGetNextPage();
    }
}
