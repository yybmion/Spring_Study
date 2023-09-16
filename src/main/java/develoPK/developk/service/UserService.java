package develoPK.developk.service;

import develoPK.developk.domain.User;
import develoPK.developk.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long join(User user){
        userRepository.save(user);
        return user.getId();
    }
}
