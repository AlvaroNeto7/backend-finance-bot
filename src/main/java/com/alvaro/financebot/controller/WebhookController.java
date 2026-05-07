package com.alvaro.financebot.controller;

import java.text.NumberFormat;
import java.util.Locale;
import com.alvaro.financebot.entity.Transaction;
import com.alvaro.financebot.service.MessageParserService;
import com.alvaro.financebot.service.TransactionService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/webhook")
public class WebhookController {

    private final MessageParserService parser;
    private final TransactionService service;

    public WebhookController(MessageParserService parser, TransactionService service) {
        this.parser = parser;
        this.service = service;
    }

    @PostMapping
    public String receiveMessage(@RequestBody String message) {

        Transaction transaction = parser.parse(message);
        service.save(transaction);

        Double total = service.getTotalByCategoryThisMonth(transaction.getCategory());

        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));

        String valor = nf.format(transaction.getAmount()).replace("\u00A0", " ");
        String totalFormatado = nf.format(total).replace("\u00A0", " ");

        return "Anotei aqui 👍\n" +
               "💸 Gasto: " + valor +
               " (" + transaction.getCategory() + ")\n" +
               "📊 Total no mês: " + totalFormatado;
    }
    }
