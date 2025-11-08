package com.example.auth.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurity {

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

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public AuthenticationManager authenticationManager() {
//        return authenticationManager();
//    }

//    @Bean
//    public TokenService tokenService() {
//        return new TokenService();
//    }

}
