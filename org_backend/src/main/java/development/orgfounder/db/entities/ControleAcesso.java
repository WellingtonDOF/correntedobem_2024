package development.orgfounder.db.entities;

import jakarta.persistence.*;

@Entity
@Table(name="controle_acesso")
public class ControleAcesso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_controle_acesso")
    private Long id;

    @Column(name="login")
    private String login;

    @Column(name="senha")
    private String senha;

    @Column(name="nivel")
    private String nivel;//pode ser que seja char, se não der mudar para integer no banco

    @Column(name="status")
    private String status;

    public ControleAcesso() {this(0L, "", "", "","");}

    public ControleAcesso(Long id, String login, String senha, String nivel, String status) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.nivel = nivel;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
