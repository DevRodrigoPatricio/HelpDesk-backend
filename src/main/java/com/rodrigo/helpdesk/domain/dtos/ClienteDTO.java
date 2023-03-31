package com.rodrigo.helpdesk.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rodrigo.helpdesk.domain.Cliente;
import com.rodrigo.helpdesk.domain.enums.Perfil;

public class ClienteDTO   implements Serializable {

    private static final long serialVersionUID = 1L;

    protected Integer id;
    @NotNull(message  = "O campo NOME é requirido")
    protected String nome;
    @NotNull(message  = "O campo CPF é requirido")
    protected String cpf;
    @NotNull(message  = "O campo EMAIL é requirido")
    protected String email;
    @NotNull(message  = "O campo SENHA é requirido")
    protected String senha;
    protected Set<Integer> perfils = new HashSet();

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCriacao = LocalDate.now();

    public ClienteDTO() {
        super();
        addPerfils(Perfil.CLIENTE);
    }
    

    public ClienteDTO(Cliente obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.perfils = obj.getPerfils().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
        this.dataCriacao = obj.getDataCriacao();
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Perfil> getPerfis() {
        return perfils.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPerfils(Perfil perfils) {
        this.perfils.add(perfils.getCodigo());
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    
}
    
    
    

