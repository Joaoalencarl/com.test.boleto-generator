package com.br.boletogenerator.boleto.dto;

public class BoletoDTO {
    private String sacado;
    private String sacadoCpf;
    private String banco;
    private String agencia;
    private String conta;
    private String cedente;
    private String cedenteCnpj;
    private String carteira;
    private String numeroDocumento;
    private String nossoNumero;
    private double valor;
    private String dataVencimento;


    public String getSacado() {
        return sacado;
    }

    public void setSacado(String sacado) {
        this.sacado = sacado;
    }

    public String getSacadoCpf() {
        return sacadoCpf;
    }

    public void setSacadoCpf(String sacadoCpf) {
        this.sacadoCpf = sacadoCpf;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getCedente() {
        return cedente;
    }

    public void setCedente(String cedente) {
        this.cedente = cedente;
    }

    public String getCedenteCnpj() {
        return cedenteCnpj;
    }

    public void setCedenteCnpj(String cedenteCnpj) {
        this.cedenteCnpj = cedenteCnpj;
    }

    public String getCarteira() {
        return carteira;
    }

    public void setCarteira(String carteira) {
        this.carteira = carteira;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNossoNumero() {
        return nossoNumero;
    }

    public void setNossoNumero(String nossoNumero) {
        this.nossoNumero = nossoNumero;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    @Override
    public String toString() {
        return "BoletoDTO{" +
                "sacado='" + sacado + '\'' +
                ", sacadoCpf='" + sacadoCpf + '\'' +
                ", banco='" + banco + '\'' +
                ", agencia='" + agencia + '\'' +
                ", conta='" + conta + '\'' +
                ", cedente='" + cedente + '\'' +
                ", cedenteCnpj='" + cedenteCnpj + '\'' +
                ", carteira='" + carteira + '\'' +
                ", numeroDocumento='" + numeroDocumento + '\'' +
                ", nossoNumero='" + nossoNumero + '\'' +
                ", valor=" + valor +
                ", dataVencimento='" + dataVencimento + '\'' +
                '}';
    }
}
