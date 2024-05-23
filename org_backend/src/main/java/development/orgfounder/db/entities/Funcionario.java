package development.orgfounder.db.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionario")
    private Long idFuncionario;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "email")
    private String email;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "estado")
    private String estado;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "cep")
    private String cep;
    @Column(name = "dta_nascimento")
    private LocalDate dtaNascimento;
    @Column(name = "dta_admissao")
    private LocalDate dtaAdmissao;
    @Column(name = "dta_demissao")
    private LocalDate dtaDemissao;

    // Getters and Setters

    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public LocalDate getDtaNascimento() {
        return dtaNascimento;
    }

    public void setDtaNascimento(LocalDate dtaNascimento) {
        this.dtaNascimento = dtaNascimento;
    }

    public LocalDate getDtaAdmissao() {
        return dtaAdmissao;
    }

    public void setDtaAdmissao(LocalDate dtaAdmissao) {
        this.dtaAdmissao = dtaAdmissao;
    }

    public LocalDate getDtaDemissao() {
        return dtaDemissao;
    }

    public void setDtaDemissao(LocalDate dtaDemissao) {
        this.dtaDemissao = dtaDemissao;
    }

    public Funcionario(Long idFuncionario, String nome, String cpf, String telefone, String endereco, String email, String sexo, String estado, String cidade, String bairro, String cep, LocalDate dtaNascimento, LocalDate dtaAdmissao, LocalDate dtaDemissao) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.sexo = sexo;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.cep = cep;
        this.dtaNascimento = dtaNascimento;
        this.dtaAdmissao = dtaAdmissao;
        this.dtaDemissao = dtaDemissao;
    }

    public Funcionario() {this(0L, "", "", "","","","","","","","",null,null,null);}
}

