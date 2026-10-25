package com.alizadeh.javacorelab.identity;

import java.util.Objects;

public class PaymentWithEqualsAndHashCode {

    long amount;

    public PaymentWithEqualsAndHashCode(long amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        PaymentWithEqualsAndHashCode other =
                (PaymentWithEqualsAndHashCode) obj;

        return amount == other.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}