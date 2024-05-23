package development.orgfounder.restcontrollers;

import development.orgfounder.db.entities.Funcionario;
import development.orgfounder.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/apis/funcionarios")
public class FuncionarioRestController {

    @Autowired
    private FuncionarioService service;

    @GetMapping
    public List<Funcionario> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Funcionario getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Funcionario create(@RequestBody Funcionario funcionario) {
        return service.save(funcionario);
    }

    @PutMapping("/{id}")
    public Funcionario update(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        funcionario.setIdFuncionario(id);
        return service.save(funcionario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

    @Configuration
    public class WebConfig implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/api/**")
                    .allowedOrigins("http://localhost:8080")
                    .allowedMethods("GET", "POST", "PUT", "DELETE");
        }
    }
}

