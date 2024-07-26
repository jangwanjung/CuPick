package com.example.cupick.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// 빈 등록 : 스프링 컨테이너에서 객체를 관리할 수 있게 하는 것

@Configuration //빈등록 (IoC관리)
@EnableWebSecurity //security 필터 등록
@EnableGlobalMethodSecurity(prePostEnabled = true) //특정 주소를 접근을 하면 권한 및 인증을 미리 체크하겠다는 뜻
public class SecurityConfigure {

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration
    ) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean // IoC가 됨
    public BCryptPasswordEncoder encodePWD() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf().disable() // csrf 토큰 비활성 (테스트시 걸어두는게 좋음)
                .authorizeRequests()
                    .antMatchers("/**"/*,"/login","/join","/board","/post/**"*/)
                    .permitAll()
                    .anyRequest()
                    .authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .usernameParameter("email")
                    .loginProcessingUrl("/loginProc")
                    .defaultSuccessUrl("/",true) // 스프링 시큐리티R가 해당 주소로 요청오는 로그인을 가로채서 대신 로그인 해준다.
                .and() // 체인 메서드를 사용하여 로그아웃 설정을 추가
                    .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/"); // 로그아웃 성공 후 리디렉션할 URL 설정
        return http.build();
    }
}