package models;

import java.time.LocalDate;

public class Fornecedor {
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String email;
    private String telefone;
    private String cidade;
    private String estado;
    private String pais;
    private String endereco;
    private String numero;
    private LocalDate dataCadastro;
    private String senha;


    public Fornecedor(String nomeFantasia, String razaoSocial, String cnpj, String email, String telefone, String cidade, String estado, String pais, String endereco, String numero, LocalDate dataCadastro, String senha) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.endereco = endereco;
        this.numero = numero;
        this.dataCadastro = dataCadastro;
        this.senha = senha;
    }

    public Fornecedor(String nomeFantasia, String razaoSocial, String cnpj, String email, String telefone, String cpf, String cidade, String estado, String pais, String endereco, int numero, LocalDate dataCadastro, String senha) {
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
/*
public class Fornecedor {
    private int id;
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String email;
    private String telefone;
    private String cidade;
    private String estado;
    private String pais;
    private String endereco;
    private String numero;
    private String dataCadastro;
    private String senha;

    // Construtor, getters e setters
    public Fornecedor(String nomeFantasia, String razaoSocial, String cnpj, String email, String telefone, String cidade, String estado, String pais, String endereco, String numero, String dataCadastro, String senha) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.endereco = endereco;
        this.numero = numero;
        this.dataCadastro = dataCadastro;
        this.senha = senha;
    }

    // getters e setters omitidos por brevidade
}

 */