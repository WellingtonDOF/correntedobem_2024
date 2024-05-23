package development.orgfounder.restcontrollers;


import development.orgfounder.db.entities.Parametrizacao;
import development.orgfounder.services.ControleAcessoService;
import development.orgfounder.services.ParametrizacaoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.html.HTMLTableCaptionElement;

@CrossOrigin
@RestController
@RequestMapping("apis/adm/")
public class AdminRestControllers {

    @Autowired
    ParametrizacaoService parametrizacaoService;

    @Autowired
    ControleAcessoService controleAcessoService;
    @GetMapping("teste-conexao")
    public String testeConexao() {
        return "conectado";
    }

    @GetMapping("get-parametrizacao")
    public ResponseEntity<Object> getParametrizacao()
    {
        Parametrizacao parametrizacao = parametrizacaoService.getById(1L);

        if(parametrizacao==null)
            parametrizacao=new Parametrizacao();
        return new ResponseEntity<>(parametrizacao, HttpStatus.OK);
    }

    @GetMapping("get-email")
    public ResponseEntity<Object> getLoginEmail(@RequestParam(value="email") String email,
                                                @RequestParam(value = "pass") String senha)
    {
        return new ResponseEntity<>(controleAcessoService.getByEmail(email), HttpStatus.OK);
    }

    /*
    @GetMapping("get-parametrizacao")
    public String getParametrizacao(@RequestParam(value="id") Long id)
    {
        System.out.println(id);

        Parametrizacao parametrizacao = parametrizacaoService.getById(id);

        if(parametrizacao==null)
            parametrizacao=new Parametrizacao();

        return "passsou"+id;
    }*/
}
