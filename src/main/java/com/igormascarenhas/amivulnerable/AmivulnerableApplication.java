package com.igormascarenhas.amivulnerable;

import com.igormascarenhas.amivulnerable.device.Device;
import com.igormascarenhas.amivulnerable.device.DeviceRepository;
import com.igormascarenhas.amivulnerable.user.User;
import com.igormascarenhas.amivulnerable.user.UserRepository;
import com.igormascarenhas.amivulnerable.vulnerability.Vulnerability;
import com.igormascarenhas.amivulnerable.vulnerability.VulnerabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AmivulnerableApplication implements CommandLineRunner {

	private final VulnerabilityRepository vulnerabilityRepository;
	private final UserRepository userRepository;
	private final DeviceRepository deviceRepository;

	@Autowired
	public AmivulnerableApplication(VulnerabilityRepository vulnerabilityRepository, UserRepository userRepository, DeviceRepository deviceRepository) {
		this.vulnerabilityRepository = vulnerabilityRepository;
		this.userRepository = userRepository;
		this.deviceRepository = deviceRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AmivulnerableApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Vulnerability v1 = new Vulnerability("test vul 1", 1);
		Vulnerability v2 = new Vulnerability("test vul 2", 3);
		Vulnerability v3 = new Vulnerability("test vul 3", 5);

		User igor = new User("1", "igor@mail.com", "Igor");
		User amanda = new User("2", "amanda@mail.com", "Amanda");

		Device d1 = new Device(1, "android", "10", "s10");
		Device d2 = new Device(2, "iphone", "10", "lite");
//
//		d1.getAllVulnerabilities().addAll(List.of(v1, v2));
//		d2.getAllVulnerabilities().addAll(List.of(v3));

//		igor.getAllDevices().addAll(List.of(d1));
//		amanda.getAllDevices().addAll(List.of(d2));

		vulnerabilityRepository.saveAll(List.of(v1, v2, v3));
		userRepository.saveAll(List.of(igor, amanda));
		deviceRepository.saveAll(List.of(d1, d2));
	}
}
