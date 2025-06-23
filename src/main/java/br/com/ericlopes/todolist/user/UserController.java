package br.com.ericlopes.todolist.user;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    

     @PostMapping("/")
     public void create (@RequestBody UserModel userModel) {
        System.out.println(userModel.getUsername());
     }
}
