package com.igormascarenhas.amivulnerable;

import com.igormascarenhas.amivulnerable.device.Device;
import com.igormascarenhas.amivulnerable.device.DeviceRepository;
import com.igormascarenhas.amivulnerable.user.User;
import com.igormascarenhas.amivulnerable.user.UserRepository;
import com.igormascarenhas.amivulnerable.user.UserRole;
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

		Vulnerability v1 = new Vulnerability(1L, "utiliza estações de carregamento", 1);
		Vulnerability v2 = new Vulnerability(2L,"possibilidade ataque via estação de carregamento", 3);

		User igor = new User(
				"Igor",
				"Mascarenhas",
				"igor2@mail.com",
				"123",
				UserRole.USER
		);

		Device d1 = new Device("android", "10", "s10");

//


		vulnerabilityRepository.saveAll(List.of(v1, v2));
		userRepository.saveAll(List.of(igor));
		deviceRepository.saveAll(List.of(d1));

		igor.setDevices(List.of(d1));
		userRepository.saveAll(List.of(igor));

	}
}
