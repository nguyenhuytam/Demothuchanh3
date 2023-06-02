package nguyenhuytam.thuchanh3.services;

import nguyenhuytam.thuchanh3.entity.User;
import nguyenhuytam.thuchanh3.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;
    public void  save (User user){
        userRepository.save(user);
    }
}
