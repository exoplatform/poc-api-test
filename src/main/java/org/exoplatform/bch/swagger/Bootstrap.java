package org.exoplatform.bch.swagger;

import com.wordnik.swagger.models.*;
import com.wordnik.swagger.models.auth.ApiKeyAuthDefinition;
import com.wordnik.swagger.models.auth.In;
import com.wordnik.swagger.models.auth.OAuth2Definition;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Created by bdechateauvieux on 4/21/15.
 */

public class Bootstrap extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        Info info = new Info()
                .title("BCH User service")
                .description("This is a sample server for BCH User services")
                .termsOfService("http://localhost:8080/terms/")
                .contact(new Contact()
                        .email("bdechateauvieux@exoplatform.org"))
                .license(new License()
                        .name("Apache 2.0")
                        .url("http://www.apache.org/licenses/LICENSE-2.0.html"));

        ServletContext context = config.getServletContext();
        Swagger swagger = new Swagger().info(info);
        swagger.securityDefinition("api_key", new ApiKeyAuthDefinition("api_key", In.HEADER));
        swagger.securityDefinition("bch_auth",
                new OAuth2Definition()
                        .implicit("http://localhost/api/oauth/dialog")
                        .scope("read:users", "read your users")
                        .scope("write:users", "modify users in your account"));
        swagger.tag(new Tag()
                .name("user")
                .description("Operations about user")
                .externalDocs(new ExternalDocs("Find out more about the service", "http://exoplatform.org")));

        context.setAttribute("swagger", swagger);
    }
}