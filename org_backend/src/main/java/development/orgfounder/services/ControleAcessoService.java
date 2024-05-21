package development.orgfounder.services;

import development.orgfounder.db.entities.ControleAcesso;
import development.orgfounder.db.repositories.ControleAcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ControleAcessoService {


    @Autowired
    private ControleAcessoRepository controlerepo;

    public ControleAcesso save(ControleAcesso controle){
        return controlerepo.save(controle);
    }

    public ControleAcesso getById(Long id)
    {
        return controlerepo.findById(id).get();
    }


}
