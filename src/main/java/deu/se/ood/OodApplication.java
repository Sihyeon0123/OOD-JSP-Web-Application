package deu.se.ood;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
@Slf4j
public class OodApplication {

	public static void main(String[] args) {
		SpringApplication.run(OodApplication.class, args);
	}


	/** config 프로퍼티 파일에 저장된 값을 읽어옴 */
	@Bean
	public PropertiesFactoryBean configProperties(){
		log.debug("configProperties() called...");
		PropertiesFactoryBean bean = new PropertiesFactoryBean();
		bean.setLocation(new ClassPathResource("config.properties"));
		return bean;
	}
}
