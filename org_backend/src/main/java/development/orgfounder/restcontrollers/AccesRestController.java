package development.orgfounder.restcontrollers;

import development.orgfounder.services.ControleAcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="apis/security/")
public class AccesRestController {

    @Autowired
    ControleAcessoService controleacessoService;

    /*
    @PostMapping("logar/")
    public ResponseEntity<Object> logar(@RequestParam(value="email") String email,
                                        @RequestParam(value="pass") String senha)
    {
        String token ="não autenticado";

        //acesso ao banco de dados para verificar a existencia do usuario

        controleacessoService.
        //comparar a senha


        if(usuario.getSenha()==123)
        {
            // Pode mandar quantas informações quiser, porém, tem que mudar la na classe JWTTokenProvider, pode mandar ID, email...
            token= JWTTokenProvider.getToken(usuario.getEmail(), ""+usuario.getNivel());

            return ResponseEntity.ok(token);
        }
        return ResponseEntity.badRequest().body(token); // caso de errado retorna a informação não autenticada.
    }*/
}
