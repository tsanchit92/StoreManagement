package store.gateway.model;



import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class RouterValidator {

	public static final List<String> apiPoints =List.of("/api/login"
			,"api/refreshToken");
	
	  public Predicate<ServerHttpRequest> isSecured =
	            request -> apiPoints
	                    .stream()
	                    .noneMatch(uri -> request.getURI().getPath().contains(uri));

}
