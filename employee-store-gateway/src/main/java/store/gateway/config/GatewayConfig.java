package store.gateway.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.reactive.function.client.WebClient;

import store.gateway.filters.AuthorizationFilter;

@CrossOrigin
@Configuration
public class GatewayConfig {

	@Autowired
	AuthorizationFilter filter;

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes()

				.route("Admin",
						r -> r.path("/store/admin/**").filters(f -> f.filter(filter)).uri("https://localhost:11000"))

				.route("Employee",
						r -> r.path("/store/employee/**").filters(f -> f.filter(filter)).uri("https://localhost:15000"))

				.route("Login",
						r -> r.path("/api/login/**", "/api/refreshToken/**").filters(f -> f.filter(filter))
								.uri("https://localhost:12000"))

				.route("Inventory",
						r -> r.path("/store/inventory/**").filters(f -> f.filter(filter))
								.uri("https://localhost:13000"))

				.build();

	}

	@Bean
	CorsWebFilter corsWebFilter() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token"));
		configuration.setAllowedMethods(Arrays.asList("*"));
		configuration.setExposedHeaders(Arrays.asList("x-auth-token"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return new CorsWebFilter(source);
	}

	@Bean
	@LoadBalanced
	public WebClient.Builder loadBalancedWebClientBuilder() {
		return WebClient.builder();
	}
}
