package com.mysite.sbb.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mysite.sbb.question.DataNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passEncoder; // 시큐리티 설정에 BCrypt패스워드엔코더 주입됨
	
	// 새 유저 생성
	public SiteUser create(String username, String email, String password) {
		SiteUser user = new SiteUser();
		user.setUsername(username);
		user.setEmail(email);
		// 패스워드 암호화하기!(암호화 객체필요)
		user.setPassword(passEncoder.encode(password));
		/*
		 * // 비밀번호 암호화 객체 (빈으로 등록하여 주입받자) BCryptPasswordEncoder passwordEncoder = new
		 * BCryptPasswordEncoder(); user.setPassword(passwordEncoder.encode(password));
		 */
		this.userRepo.save(user); // 유저객체를 저장 
		return user;
		
	}
	
	public SiteUser getUser(String username) {
        Optional<SiteUser> siteUser = this.userRepo.findByusername(username);
        if (siteUser.isPresent()) {
            return siteUser.get();
        } else {
            throw new DataNotFoundException("siteuser not found");
        }
    }
}
