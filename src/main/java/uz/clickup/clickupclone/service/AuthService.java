package uz.clickup.clickupclone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.clickup.clickupclone.entity.AuthUser;
import uz.clickup.clickupclone.entity.enums.SystemRoleName;
import uz.clickup.clickupclone.payload.ApiResponse;
import uz.clickup.clickupclone.payload.RegisterDto;
import uz.clickup.clickupclone.repository.UserRepository;

import java.util.Random;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public ApiResponse registerUser(RegisterDto registerDto) {
        if (userRepository.existsByEmail(registerDto.getEmail())) {
            return new ApiResponse("Bunday user mavjud", false);
        }
        AuthUser user = new AuthUser(
                registerDto.getFullName(),
                registerDto.getEmail(),
                passwordEncoder.encode(registerDto.getPassword()),
                SystemRoleName.SYSTEM_USER);
        int code = new Random().nextInt(999999);
        user.setEmailCode(String.valueOf(code).substring(0, 4));
        userRepository.save(user);
        sendEmail(user.getEmail(), user.getEmailCode());
        return new ApiResponse("User saqlandi ", true);
    }

    public boolean sendEmail(String sendingEmail, String emailCode) {
        try {

            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("axmatov0113@gmail.com");
            message.setTo(sendingEmail);
            message.setSubject("ClickUp tasdiqlash kodi ");
            message.setText(emailCode);
            javaMailSender.send(message);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
