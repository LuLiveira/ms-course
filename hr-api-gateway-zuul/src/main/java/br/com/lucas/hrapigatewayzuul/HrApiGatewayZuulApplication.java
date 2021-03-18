package br.com.lucas.hrapigatewayzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class HrApiGatewayZuulApplication {
//    @Bean
//    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(r -> r.path("/workers/**")
//                        .uri("lb://HR-WORKER")
//                        .id("ww"))
//
//                .build();
//    }
//    
//	@Bean
//	public ServerCodecConfigurer serverCodecConfigurer() {
//	   return ServerCodecConfigurer.create();
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(HrApiGatewayZuulApplication.class, args);
	}

}
