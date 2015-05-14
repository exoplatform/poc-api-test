package org.exoplatform.client.retrofit;

/**
 * Created by bdechateauvieux on 5/5/15.
 */
import org.apache.commons.lang3.StringUtils;
import retrofit.RequestInterceptor;

import java.util.Base64;

/**
 * Interceptor used to authorize requests.
 */
public class ApiRequestInterceptor implements RequestInterceptor {

    private final String username;
    private final String password;

    public ApiRequestInterceptor(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void intercept(RequestFacade requestFacade) {
        if (StringUtils.isNotBlank(username)) {
            final String authorizationValue = encodeCredentialsForBasicAuthorization();
            requestFacade.addHeader("Authorization", authorizationValue);
        }
    }

    private String encodeCredentialsForBasicAuthorization() {
        final String userAndPassword = username + ":" + password;
        return "Basic " + Base64.getEncoder().encodeToString(userAndPassword.getBytes());
    }
}
