package development.orgfounder.services;


import development.orgfounder.db.entities.Parametrizacao;
import development.orgfounder.db.repositories.ParametrizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.tags.Param;

import java.util.List;
import java.util.Optional;

@Service
public class ParametrizacaoService {

    @Autowired
    private ParametrizacaoRepository parametrizacaorepo;

    public Parametrizacao getById(Long id) {
        Optional<Parametrizacao> parametrizacaoOptional = parametrizacaorepo.findById(id);

        if(parametrizacaoOptional.isPresent())
            return parametrizacaoOptional.get();
        else
            return null;
    }

    public List<Parametrizacao> getAll(){return parametrizacaorepo.findAll();}
}
