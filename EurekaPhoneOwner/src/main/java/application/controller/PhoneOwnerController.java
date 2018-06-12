package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import application.entity.PhoneOwner;
import application.service.PhoneOwnerService;

@RestController
public class PhoneOwnerController {
	
    @Autowired
    DiscoveryClient discoveryClient;
    
    @Autowired
    private PhoneOwnerService phoneOwnerService;
    
    @ResponseBody
    @GetMapping("/owner/{section}")
    public PhoneOwner query(@PathVariable String section) {
    	return phoneOwnerService.findPhoneOwner(section);
    }
	
	@GetMapping("/dc")
    public String dc() {
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }

}
