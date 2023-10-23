package com.br.boletogenerator.bopepo;

import com.github.braully.boleto.BoletoCobranca;
import org.jrimum.bopepo.view.BoletoViewer;

public class Bopepo {
    public static void main(String... args) {
        BoletoCobranca boleto = new BoletoCobranca();
        boleto.sacado("Sacado da Silva Sauro").sacadoCpf("1");
        boleto.banco("1").agencia("1").conta("1");
        boleto.cedente("Cedente da Silva Sauro").cedenteCnpj("1");
        boleto.carteira("1");
        boleto.numeroDocumento("1")
                .nossoNumero("1234567890")
                .valor(100.23).dataVencimento("01/01/2019");

        boleto.gerarLinhaDigitavel();
        BoletoViewer create = BoletoViewer.create(boleto);
        create.getPdfAsFile("./target/boleto.pdf");
    }
}
