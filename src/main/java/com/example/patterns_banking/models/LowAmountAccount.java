package com.example.patterns_banking.models;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
public class LowAmountAccount extends Account {
  private static final double DEPOSIT_FEE_RATE = 0.01;
  private static final double FREE_TRANSACTION_THRESHOLD = 100.0;
  @Override
  public Double calculateDepositFee(Double amount) {
    if (amount > FREE_TRANSACTION_THRESHOLD) {
          return amount * DEPOSIT_FEE_RATE;
        }
        return 0.0;
  }
}
