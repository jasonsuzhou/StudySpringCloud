package application.feign.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;

@FeignClient(value = "eureka-client-phone-owner", configuration = FileUploadClient.MultipartSupportConfig.class)
public interface FileUploadClient {

	@PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	String handleFileUpload(@RequestPart(value = "file") MultipartFile file);

	@Configuration
	class MultipartSupportConfig {
		@Bean
		public Encoder feignFormEncoder() {
			return new SpringFormEncoder();
		}
	}
}
