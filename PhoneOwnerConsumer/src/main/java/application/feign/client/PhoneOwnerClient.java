package application.feign.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("eureka-client-phone-owner")
public interface PhoneOwnerClient {

	/**
	 * must explicit define the value for the @PathVariable
	 * 
	 * @param section
	 * @return
	 */
	@GetMapping("/owner/{section}")
	String consumer(@PathVariable(value = "section") String section);

}
