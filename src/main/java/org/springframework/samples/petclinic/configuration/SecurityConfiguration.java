package org.springframework.samples.petclinic.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author japarejo
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	
	@Autowired
	DataSource dataSource;

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/resources/**", "/webjars/**", "/h2-console/**").permitAll()
				.antMatchers(HttpMethod.GET, "/", "/oups").permitAll()
				.antMatchers("/numFichas/{diskId}/**").hasAnyAuthority("player", "admin")
				.antMatchers("/users/new").anonymous()
				.antMatchers("/save").permitAll()
				.antMatchers("/welcome").permitAll()
				.antMatchers("/player/create").anonymous()
				.antMatchers("/admin/create").hasAnyAuthority("admin")
				.antMatchers("/tablero").hasAnyAuthority("player", "admin")
				.antMatchers("/discos").hasAnyAuthority("player", "admin")
				.antMatchers("/player/details").hasAnyAuthority("player", "admin")
				.antMatchers("/match/matchesRecord").hasAnyAuthority("player", "admin")
				.antMatchers("/match/matchRecordEmpty").hasAnyAuthority("player", "admin")
				.antMatchers("/player/edit").hasAnyAuthority("player", "admin")
                .antMatchers("/player/{playerId}/edit").hasAnyAuthority("admin")
				.antMatchers("/finishturn").hasAnyAuthority("player", "admin")
				.antMatchers("/admin/**").hasAnyAuthority("admin")
				.antMatchers("/matchList").hasAnyAuthority("admin")
				.antMatchers("/allMatches").hasAnyAuthority("admin")
				.antMatchers("/match/matchesInCourse").hasAnyAuthority("admin")
				.antMatchers("/playAgain").hasAnyAuthority("player")
				.antMatchers("/win").hasAnyAuthority("player")
				.antMatchers("/lose").hasAnyAuthority("player")
				.antMatchers("/salir").hasAnyAuthority("player")
				.antMatchers("/verLogros").hasAnyAuthority("player")
				.antMatchers("/rankingJugadores").permitAll()
				.antMatchers("/estadisticasGlobales").permitAll()
				.antMatchers("/verTusEstadisticas").hasAnyAuthority("player")
				.antMatchers("/xdxd").permitAll()
				.antMatchers("/numFichas/{diskId}/{diskDest}").hasAnyAuthority("player", "admin")
//				.anyRequest().denyAll() //lo comento para que salgan las vistas de excepciones personalizadas de un error 404, sino saldría siempre un error 403
				.and().formLogin()
				/* .loginPage("/login") */
				.failureUrl("/login-error").and().logout().logoutSuccessUrl("/");
		// Configuración para que funcione la consola de administración
		// de la BD H2 (deshabilitar las cabeceras de protección contra
		// ataques de tipo csrf y habilitar los framesets si su contenido
		// se sirve desde esta misma página.
		http.csrf().ignoringAntMatchers("/h2-console/**");
		http.headers().frameOptions().sameOrigin();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username,password,enabled " + "from users " + "where username = ?")
				.authoritiesByUsernameQuery("select username, authority " + "from authorities " + "where username = ?")
				.passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {	    
		PasswordEncoder encoder =  new BCryptPasswordEncoder();
	    return encoder;

	    
	}
	@Bean
    public PasswordEncoder passwordEncoder2() {        
        PasswordEncoder encoder =  NoOpPasswordEncoder.getInstance();
        return encoder;
    }
	
//	 @Bean
//	    public UserDetailsService userDetailsService(){
//	        User playerBlue = new User();
//	        User playerRed = new User();
//	        playerBlue.setUsername("playerBlue");
//	        playerBlue.setPassword("XDXDXD234,,..aaa");
//	        playerBlue.setEnabled(true);
//	        
//	        Authorities play = new Authorities();
//	        play.setUser(playerBlue);
//	        play.setAuthority("player");
//	        Set<Authorities> XD2 = new HashSet<Authorities>();
//	        XD2.add(play);
//	        playerBlue.setAuthorities(XD2);
//	        Player playerRed1 = new Player();
//	        Player playerBlue1 = new Player();
//	        playerBlue1.setUser(playerBlue);
//	        playerBlue1.setId(10);
//	        playerBlue1.setEmail("olaaaa@XD.es");
//	        playerRed1.setUser(playerRed);
//	        playerRed1.setId(11);
//	        playerRed1.setEmail("ola2@XD.es");
//
//
//	        UserDetails userblue=(UserDetails) playerBlue;
//	        UserDetails userred=(UserDetails) playerRed;
//	        
//	        UserDetails userblue1=(UserDetails) playerBlue1;
//
//
//	       return new InMemoryUserDetailsManager(Arrays.asList(userblue, userred, userblue1));
//	    }
 
 

}
