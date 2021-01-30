package com.lendico.paymentscalculator.pojo;

public class BorrowerPayment {

    String borrowerPaymentAmount;

    String date;

    String initialOutstandingPrincipal;

    String interest;

    String principal;

    String remainingOutstandingPrincipal;

    public String getBorrowerPaymentAmount() {
        return borrowerPaymentAmount;
    }

    public void setBorrowerPaymentAmount(String borrowerPaymentAmount) {
        this.borrowerPaymentAmount = borrowerPaymentAmount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInitialOutstandingPrincipal() {
        return initialOutstandingPrincipal;
    }

    public void setInitialOutstandingPrincipal(String initialOutstandingPrincipal) {
        this.initialOutstandingPrincipal = initialOutstandingPrincipal;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getRemainingOutstandingPrincipal() {
        return remainingOutstandingPrincipal;
    }

    public void setRemainingOutstandingPrincipal(String remainingOutstandingPrincipal) {
        this.remainingOutstandingPrincipal = remainingOutstandingPrincipal;
    }
}
