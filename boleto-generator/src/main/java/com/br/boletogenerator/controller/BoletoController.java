package com.br.boletogenerator.controller;

import com.br.boletogenerator.boleto.dto.BoletoDTO;
import com.github.braully.boleto.BoletoCobranca;
import org.jetbrains.annotations.NotNull;
import org.jrimum.bopepo.view.BoletoViewer;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController
@RequestMapping("/boleto")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET,
        RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class BoletoController {

    @PostMapping("/gerar")
    public ResponseEntity<String> gerarBoleto(@RequestBody @NotNull BoletoDTO boletoDTO) {

       String secado = boletoDTO.getSacado();
       String sacadoCpf = boletoDTO.getSacadoCpf();
       String banco = boletoDTO.getBanco();
       String agencia = boletoDTO.getAgencia();
       String conta = boletoDTO.getConta();
       String cedente = boletoDTO.getCedente();
       String cedenteCnpj = boletoDTO.getCedenteCnpj();
       String carteira = boletoDTO.getCarteira();
       String numeroDocumento = boletoDTO.getNumeroDocumento();
       String nossoNumero = boletoDTO.getNossoNumero();
       double valor = boletoDTO.getValor();
       String dataVencimento = boletoDTO.getDataVencimento();

        BoletoCobranca boleto = new BoletoCobranca();
        boleto.sacado(secado).sacadoCpf(sacadoCpf);
        boleto.banco(banco).agencia(agencia).conta(conta);
        boleto.cedente(cedente).cedenteCnpj(cedenteCnpj);
        boleto.carteira(carteira);
        boleto.numeroDocumento(numeroDocumento)
                .nossoNumero(nossoNumero)
                .valor(valor).dataVencimento(dataVencimento);

        System.out.println(boletoDTO.toString());

        boleto.gerarLinhaDigitavel();
        BoletoViewer create = BoletoViewer.create(boleto);
        System.out.println(create);
        create.getPdfAsFile("./target/boleto.pdf");


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "boleto.pdf");

        return new ResponseEntity(create.getPdfAsByteArray(), headers, HttpStatus.OK);
    }

    @GetMapping("/mostrar")
    public ResponseEntity<byte[]> getBoleto() throws IOException {
        File file = new File("./target/boleto.pdf");
        byte[] pdf = Files.readAllBytes(file.toPath());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.builder("inline").filename("boleto.pdf").build());
        headers.setContentLength(pdf.length);
        return new ResponseEntity<>(pdf, headers, HttpStatus.OK);
    }
}
