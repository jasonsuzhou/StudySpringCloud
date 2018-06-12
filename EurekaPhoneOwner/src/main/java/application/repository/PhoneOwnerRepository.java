package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import application.entity.PhoneOwner;

public interface PhoneOwnerRepository extends JpaRepository<PhoneOwner, String> {

	PhoneOwner findBySection(String section);
	
}
