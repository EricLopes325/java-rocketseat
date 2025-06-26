package br.com.ericlopes.todolist.user;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
     public ResponseEntity create (@RequestBody UserModel userModel) {
         var user = this.userRepository.findByUsername(userModel.getUsername());
         
         if(user != null) {
            // Mensagem de erro
            // Status Code
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário ja existe em nosso banco de dados!");
         }

         var passwordHashred = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());
         userModel.setPassword(passwordHashred);


         var userCreated = this.userRepository.save(userModel);
         return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
     }
}
