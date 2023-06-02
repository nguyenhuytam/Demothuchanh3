package nguyenhuytam.thuchanh3.services;
import nguyenhuytam.thuchanh3.entity.CustomUserDetail;
import nguyenhuytam.thuchanh3.entity.User;
import nguyenhuytam.thuchanh3.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String usernam) throws UsernameNotFoundException{
        User user = userRepository.findByUsername(usernam);
        if (user==null)
            throw  new UsernameNotFoundException("User not found");
        return new CustomUserDetail(user,userRepository);
    }
}
