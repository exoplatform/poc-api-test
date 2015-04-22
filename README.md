A simple JAX-RS (Jersey) project that exposes REST API.

### Unit Tests
UT use Retrofit as REST Client library
```maven
mvn test
```

### API documentation
The documentation of the REST API is generated with swagger.io.

```maven
mvn jetty:run
```

Then open in browser:
[http://localhost:8080/swagger-ui](http://localhost:8080/swagger-ui/#!/activity/createActivity)

The JSON swagger file can be found here:
[http://localhost:8080/swagger.json](http://localhost:8080/swagger.json)