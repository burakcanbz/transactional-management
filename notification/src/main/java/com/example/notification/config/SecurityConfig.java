package com.example.notification.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        System.out.println("SecurityConfig uygulanıyor...");
        http
                // 1. CSRF Korumasını devre dışı bırak
                .csrf(AbstractHttpConfigurer::disable)

                // 2. HTTP Basic Kimlik Doğrulamasını devre dışı bırak
                .httpBasic(AbstractHttpConfigurer::disable)

                // 3. Form Tabanlı Girişi (Yönlendirmeyi) devre dışı bırak
                .formLogin(AbstractHttpConfigurer::disable)

                // 4. Logout (Çıkış) özelliğini devre dışı bırak
                .logout(AbstractHttpConfigurer::disable)

                // 5. Yetkilendirme Kuralları: TÜM isteklere izin ver (Permit All)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // <<< Bütün yollara kimlik doğrulama gereksinimi olmadan erişim izni ver
                );

        return http.build();
    }
}