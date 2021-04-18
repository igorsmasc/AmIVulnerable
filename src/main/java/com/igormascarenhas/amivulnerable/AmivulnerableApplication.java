package com.igormascarenhas.amivulnerable;

import com.igormascarenhas.amivulnerable.device.Device;
import com.igormascarenhas.amivulnerable.device.DeviceRepository;
import com.igormascarenhas.amivulnerable.rule.Rule;
import com.igormascarenhas.amivulnerable.rule.RuleRepository;
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
	private final RuleRepository ruleRepository;

	@Autowired
	public AmivulnerableApplication(VulnerabilityRepository vulnerabilityRepository, UserRepository userRepository, DeviceRepository deviceRepository, RuleRepository ruleRepository) {
		this.vulnerabilityRepository = vulnerabilityRepository;
		this.userRepository = userRepository;
		this.deviceRepository = deviceRepository;
		this.ruleRepository = ruleRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AmivulnerableApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Vulnerability v1 = new Vulnerability(1L, "utiliza estações de carregamento", 1);
		Vulnerability v2 = new Vulnerability(2L,"possibilidade ataque via estação de carregamento", 3);
		Vulnerability v3 = new Vulnerability(3L,"utiliza computadores para carregamento", 3);
		Vulnerability v4 = new Vulnerability(4L,"possibilidade de ataque via conexão usb no PC", 3);
		Vulnerability v5 = new Vulnerability(5L,"sistema operacional= IOs", 3);
		Vulnerability v6 = new Vulnerability(6L,"versão do S.O = 6.0 ou inferior", 3);
		Vulnerability v7 = new Vulnerability(7L,"dispositivo vulnerável a ataques via usb", 3);
		Vulnerability v8 = new Vulnerability(8L,"costuma manter o dispositivo atualizado", 3);
		Vulnerability v9 = new Vulnerability(9L,"vulnerabilidades no s.o do dispositivo", 3);
		Vulnerability v10 = new Vulnerability(10L,"dispositivo = nexus 6", 3);
		Vulnerability v11 = new Vulnerability(11L, "dispositivo com vulnerabilidades a ataques via usb registradas", 1);
		Vulnerability v13 = new Vulnerability(13L,"dipositivo = g_pixel_2", 3);
		Vulnerability v21 = new Vulnerability(21L,"sistema operacional= android", 3);
		Vulnerability v22 = new Vulnerability(22L,"dispositivo permite instalação via fontes desconhecidas", 3);
		Vulnerability v23 = new Vulnerability(23L,"dispositivo permite aplicativos não oficiais", 3);
		Vulnerability v24 = new Vulnerability(24L,"dispositivo permite aplicativos por não oficiais", 3);

		Vulnerability v10001 = new Vulnerability(10001L,"Exploração via estação de carregamento", 3);
		Vulnerability v10002 = new Vulnerability(10002L,"Exploração via conexão usb PC", 3);
		Vulnerability v10003 = new Vulnerability(10003L,"Aplicativo malicioso por outros meios", 3);
		Vulnerability v10004 = new Vulnerability(10004L,"Aplicativo malicioso por meio de loja oficial", 3);
		Vulnerability v10005 = new Vulnerability(10005L,"Fraude de SMS", 3);
		Vulnerability v10006 = new Vulnerability(10006L,"Anexo de Spearphishing", 3);
		Vulnerability v10007 = new Vulnerability(10007L,"Acesso a dados confidenciais em registros do dispositivo", 3);
		Vulnerability v10008 = new Vulnerability(10008L,"Lockscreen Bypass", 3);

		User igor = new User(
				"Igor",
				"Mascarenhas",
				"igor2@mail.com",
				"123",
				UserRole.USER
		);

		Device d1 = new Device("android", "10", "s10");

		vulnerabilityRepository.saveAll(List.of(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v13, v21, v22, v23, v24, v10001, v10002, v10003, v10004, v10005, v10006, v10007, v10008));
		userRepository.saveAll(List.of(igor));
		deviceRepository.saveAll(List.of(d1));

		igor.setDevices(List.of(d1));
		userRepository.saveAll(List.of(igor));

		Rule r1 = new Rule(1L, "SE utiliza estações de carregamento -> ENTÃO possibilidade ataque via estação de carregamento", "https://attack.mitre.org/techniques/T1458/");
		Rule r2 = new Rule(2L, "SE utiliza estações de carregamento -> ENTÃO possibilidade ataque via estação de carregamento", "https://attack.mitre.org/techniques/T1458/");
		Rule r3 = new Rule(3L, "SE sistema operacional = iOS -> E versão do S.O <= 6 -> ENTÃO dispositivo vulnerável a ataques via usb ", "https://media.blackhat.com/us-13/US-13-Lau-Mactans-Injecting-Malware-into-iOS-Devic es-via-Malicious-Chargers-WP.pdf ");
		Rule r4 = new Rule(4L, "SE NÃO costuma manter o dispositivo atualizado -> ENTÃO possível vulnerabilidades no s.o do dispositivo", "https://www.bbc.com/news/technology-51751950 ");
		Rule r5 = new Rule(5L, "SE dispositivo = nexus 6 -> OU dispositivo com vulnerabilidades a ataques via usb registradas -> ENTÃO dispositivo vulnerável a ataques via usb", "https://securityintelligence.com/android-vulnerabilities-attacking-nexus-6-and-6p-custom -boot-modes/");
		Rule r6 = new Rule(6L, "SE dipositivo = google pixel 2 -> OU dispositivo com vulnerabilidades a ataques via usb registradas -> ENTÃO dispositivo vulnerável a ataques via usb", "https://googleprojectzero.blogspot.com/2018/09/oatmeal-on-universal-cereal-bus.html");
		Rule r7 = new Rule(7L, "SE dispositivo vulnerável a ataques via usb -> E possivel vulnerabilidades no s.o do dispositivo -> E possibilidade ataque via estação de carregamento -> ENTÃO vulnerabilidade = Exploração via estação de carregamento", "https://attack.mitre.org/techniques/T1458/");
		Rule r8 = new Rule(8L, "SE dispositivo vulnerável a ataques via usb -> E vulnerabilidades no s.o do dispositivo -> E possibilidade de ataque via conexão usb no PC -> ENTÃO vulnerabilidade = exploração via conexão usb PC", "https://attack.mitre.org/techniques/T1458/");
		Rule r9 = new Rule(9L, "SE sistema operacional = android -> E dispositivo permite instalação via fontes desconhecidas -> ENTÃO = dispositivo permite aplicativos não oficiais", "https://us.norton.com/internetsecurity-emerging-threats-hundreds-of-android-apps-conta ining-dresscode-malware-hiding-in-google-play-store.html ");
		Rule r10 = new Rule(10L, "SE dispositivo permite aplicativos por não oficiais -> ENTÃO possibilidade de aplicativo malicioso por outros meios", "https://attack.mitre.org/techniques/T1476/ ");

		ruleRepository.saveAll(List.of(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10));

	}
}
