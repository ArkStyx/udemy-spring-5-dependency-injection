package guru.springframework.sfgdependencyinjection.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties("guru")
@Configuration
public class SfgConfiguration {

	private String userName;
	private String password;
	private String jdbcUrl;
}
