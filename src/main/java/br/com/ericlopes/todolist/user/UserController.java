package br.com.ericlopes.todolist.user;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * Modificador:
 * public
 * private
 * protected
 */
@RestController
@RequestMapping("/users")
public class UserController {
    

    /**
     * String (texto)
     * Integer (int) - Números inteiros
     * Double (double) Números com casas decimais - 0.000
     * Float (float) Números com casas decimais - 0.000
     * char (A C)
     * Date (data)
     */

     @Autowired
     private IUserRepository userRepository;
    

     @PostMapping("/")
     public UserModel create (@RequestBody UserModel userModel) {
        var userCreated = this.userRepository.save(userModel);
        return userCreated;
     }
}
