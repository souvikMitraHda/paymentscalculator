package com.lendico.paymentscalculator.pojo;

import java.util.List;

public class BorrowerPaymentResponse {
    List<BorrowerPayment> borrowerPayments;

    public List<BorrowerPayment> getBorrowerPayments() {
        return borrowerPayments;
    }

    public void setBorrowerPayments(List<BorrowerPayment> borrowerPayments) {
        this.borrowerPayments = borrowerPayments;
    }
}
