package books.vediclibrary;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class VedicLibraryApplication {

	@Value("${server.port}")
	private static int port;

	@Value("${service.instance.name}")
	private static String serviceInstanceName;

	public static void main(String[] args) {
		SpringApplication.run(VedicLibraryApplication.class, args);
		
		System.out.println("Service Instance " + serviceInstanceName + " on Port " + port);
	}

}
