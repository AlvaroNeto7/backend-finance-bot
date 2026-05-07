package com.alvaro.financebot.service;

import com.alvaro.financebot.entity.Transaction;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class MessageParserService {

    public Transaction parse(String message) {

        message = message.toLowerCase();

        Transaction t = new Transaction();

  
        Pattern pattern = Pattern.compile("(\\d+[.,]?\\d*)");
        Matcher matcher = pattern.matcher(message);

        if (matcher.find()) {
            String value = matcher.group().replace(",", ".");
            t.setAmount(Double.parseDouble(value));
        }

     
        if (message.contains("gastei")) {
            t.setType("EXPENSE");
        } else if (message.contains("recebi")) {
            t.setType("INCOME");
        }

       
        if (message.contains("uber")) {
            t.setDescription("uber");
            t.setCategory("transporte");
        } else if (message.contains("ifood")) {
            t.setDescription("ifood");
            t.setCategory("alimentacao");
        } else if (message.contains("mercado")) {
            t.setDescription("mercado");
            t.setCategory("alimentacao");
        } else {
            t.setDescription("outros");
            t.setCategory("outros");
        }if (message.contains("gasolina")) {
            t.setCategory("transporte");
        } else if (message.contains("pizza")) {
            t.setCategory("alimentacao");
        } else if (message.contains("salario")) {
            t.setCategory("renda");
        }

        return t;
    }
}