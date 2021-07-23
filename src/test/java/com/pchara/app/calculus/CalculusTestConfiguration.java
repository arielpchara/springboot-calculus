package com.pchara.app.calculus;

import com.pchara.app.calculus.reporitories.CalculusRepository;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class CalculusTestConfiguration {
    @Bean
    @Primary
    public CalculusRepository calculusRepository() {
        return Mockito.mock(CalculusRepository.class);
    }
}
