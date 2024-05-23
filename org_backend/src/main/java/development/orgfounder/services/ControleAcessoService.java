package development.orgfounder.services;

import development.orgfounder.db.entities.ControleAcesso;
import development.orgfounder.db.repositories.ControleAcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ControleAcessoService {

    @Autowired
    private ControleAcessoRepository repo;

    public ControleAcesso save(ControleAcesso controle){
        return repo.save(controle);
    }

    public ControleAcesso getById(Long id)
    {
        return repo.findById(id).get();
    }

    public ControleAcesso getByEmail(String email)
    {
        return repo.findByEmail(email);
    }


}
