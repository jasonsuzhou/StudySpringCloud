package application.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import application.entity.PhoneOwner;
import application.repository.PhoneOwnerRepository;

@Service
public class PhoneOwnerService {

	@Autowired
	private PhoneOwnerRepository phoneOwnerRepository;

	@Cacheable(cacheNames = "PhoneOwner")
	public PhoneOwner findPhoneOwner(String section) {
		if (StringUtils.isBlank(section)) {
			return null;
		}
		if (section.trim().length() < 7) {
			return null;
		}
		if (section.trim().length() > 7) {
			section = section.substring(0, 7);
		}
		return this.phoneOwnerRepository.findBySection(section);
	}

	@CacheEvict(cacheNames = "PhoneOwner", key = "#section")
	public void updatePhoneOwner(String section, PhoneOwner phoneOwner) {
		phoneOwner.setSection(section);
		this.phoneOwnerRepository.save(phoneOwner);
	}

	@CacheEvict(cacheNames = "PhoneOwner")
	public void deletePhoneOwner(String section) {
		this.phoneOwnerRepository.delete(section);
	}

}
