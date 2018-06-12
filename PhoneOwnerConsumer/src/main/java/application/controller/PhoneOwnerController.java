package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import application.feign.client.PhoneOwnerClient;

@RestController
public class PhoneOwnerController {
	
	@Autowired
	LoadBalancerClient loadBalancerClient;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	PhoneOwnerClient phoneOwnerClient;
	
	@GetMapping("/consumer/owner/{section}")
	public String owner(@PathVariable String section) {
		ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client-phone-owner");
		String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/owner/" + section;
	    System.out.println(url);
		return restTemplate.getForObject(url, String.class);
	}
	
	/**
	 * Ribbon way to call server side
	 * @param section
	 * @return
	 */
	@GetMapping("/consumer/owner/v2/{section}")
	public String ownerv2(@PathVariable String section) {
		/**
		 * Ribbon filter will convert below service name to actual host and port</br>
		 * eureka-client-phone-owner
		 */
		return restTemplate.getForObject("http://eureka-client-phone-owner/owner/"+section, String.class);
	}
	
	/**
	 * Feign way to call server side
	 * @param section
	 * @return
	 */
	@GetMapping("/consumer/owner/v3/{section}")
	public String ownerv3(@PathVariable String section) {
		return phoneOwnerClient.consumer(section);
	}
}
