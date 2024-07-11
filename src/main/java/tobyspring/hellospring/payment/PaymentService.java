package tobyspring.hellospring.payment;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
 public class PaymentService {
     private final ExRateProvider exRateProvider;

     public PaymentService(ExRateProvider exRateProvider) {
         this.exRateProvider = exRateProvider;
     }

     public Payment prepare(Long orederId, String currency, BigDecimal foreignCurrencyAmount) throws IOException {
        BigDecimal exRate = exRateProvider.getExRate(currency);
        BigDecimal convertedAmount = foreignCurrencyAmount.multiply(exRate);
        LocalDateTime validUntil = LocalDateTime.now().plusMinutes(30);

        return new Payment(orederId, currency, foreignCurrencyAmount, exRate, convertedAmount, validUntil);
    }


}
