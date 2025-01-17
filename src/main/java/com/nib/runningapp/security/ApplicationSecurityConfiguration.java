//package com.nib.runningapp.security;
//
//import com.nib.runningapp.repositories.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
////@EnableWebSecurity
//@RequiredArgsConstructor
//public class ApplicationSecurityConfiguration{
//
//    private final UserRepository repo;
//
//    @Bean
////    public PasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
//
////    @Bean
////    public UserDetailsService userDetailsService() {
////        return username -> (UserDetails) repo.findByUsernameAndStatus(username, true)
////                .orElseThrow(() -> new EntityNotFoundException("User not found!"));
////    }
//
////    @Bean
////    public AuthenticationProvider authenticationProvider() {
////        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
////        authProvider.setUserDetailsService(userDetailsService());
////        authProvider.setPasswordEncoder(passwordEncoder());
////        return authProvider;
////    }
//
////    @Bean
////    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
////        return config.getAuthenticationManager();
////    }
//}