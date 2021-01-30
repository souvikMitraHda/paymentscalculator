package com.lendico.paymentscalculator.service;


import com.lendico.paymentscalculator.pojo.BorrowerPayment;
import com.lendico.paymentscalculator.pojo.LoanData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoanService {

    List<BorrowerPayment> getBorrowerPaymentList(LoanData loanData);
}
