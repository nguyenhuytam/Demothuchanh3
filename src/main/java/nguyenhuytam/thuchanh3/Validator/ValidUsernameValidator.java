package nguyenhuytam.thuchanh3.Validator;
import nguyenhuytam.thuchanh3.Validator.annotation.ValidUsername;
import nguyenhuytam.thuchanh3.entity.Category;
import  nguyenhuytam.thuchanh3.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidUsernameValidator implements ConstraintValidator<ValidUsername,String> {
    @Autowired
    private IUserRepository userRepository;


    @Override
    public boolean isValid(String username , ConstraintValidatorContext context){
        if(userRepository==null)
            return true;
        return userRepository.findByUsername(username) == null;
    }
}
