package com.alizadeh.javacorelab.identity;

public class PaymentWithEquals {

    long amount;

    public PaymentWithEquals(long amount) {
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

        PaymentWithEquals other = (PaymentWithEquals) obj;

        return amount == other.amount;
    }
}