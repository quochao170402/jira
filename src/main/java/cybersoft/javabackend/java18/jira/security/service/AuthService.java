package cybersoft.javabackend.java18.jira.security.service;

import cybersoft.javabackend.java18.jira.common.exception.JiraBusinessException;
import cybersoft.javabackend.java18.jira.security.dto.LoginDTO;
import cybersoft.javabackend.java18.jira.security.jwt.JwtUtils;
import cybersoft.javabackend.java18.jira.user.model.User;
import cybersoft.javabackend.java18.jira.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

public interface AuthService {
    String login(LoginDTO loginDTO);
}

@Service
@Transactional
class AuthServiceImpl implements AuthService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    AuthServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder, JwtUtils jwtUtils) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public String login(LoginDTO loginDTO) {
        User user = repository.findByUsername(loginDTO.getUsername())
                .orElseThrow(
                        () -> new JiraBusinessException("Not found user")
                );
        if (passwordEncoder.matches(loginDTO.getPassword(), user.getPassword() )) {
            // return jwt
            return jwtUtils.generateJWT(user.getUsername());
        }
        throw new JiraBusinessException("Password is not correct");
    }
}
