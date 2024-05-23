package development.orgfounder.services;

import development.orgfounder.db.entities.Funcionario;
import development.orgfounder.db.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.*;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repo;

    public Funcionario save(Funcionario funcionario) {
        if (funcionario == null) {
            throw new IllegalArgumentException("Funcionario não pode ser nulo");
        }
        return repo.save(funcionario);
    }

    public Funcionario getById(Long idFuncionario) {
        return repo.findById(idFuncionario)
                .orElseThrow(() -> new EntityNotFoundException("Funcionario não encontrado para o ID: " + idFuncionario));
    }

    public Funcionario getByEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email não pode ser nulo ou vazio");
        }
        return repo.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Funcionario não encontrado para o email: " + email));
    }

    public Funcionario getByCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("CPF não pode ser nulo ou vazio");
        }
        return repo.findByCpf(cpf)
                .orElseThrow(() -> new EntityNotFoundException("Funcionario não encontrado para o CPF: " + cpf));
    }

    public List<Funcionario> getAll() {
        return repo.findAll();
    }

    public void deleteById(Long idFuncionario) {
        if (!repo.existsById(idFuncionario)) {
            throw new EntityNotFoundException("Funcionario não encontrado para o ID: " + idFuncionario);
        }
        repo.deleteById(idFuncionario);
    }
}

