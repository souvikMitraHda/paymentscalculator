package com.lendico.paymentscalculator.controller;


import com.lendico.paymentscalculator.pojo.BorrowerPayment;
import com.lendico.paymentscalculator.pojo.BorrowerPaymentResponse;
import com.lendico.paymentscalculator.pojo.LoanData;
import com.lendico.paymentscalculator.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LoanPaymentController {


    @Autowired
    LoanService loanService;

    @PostMapping("/generate-plan")
    BorrowerPaymentResponse saveApplicant(@RequestBody LoanData loanData){
        BorrowerPaymentResponse borrowerPaymentResponse=new BorrowerPaymentResponse();
        borrowerPaymentResponse.setBorrowerPayments(loanService.getBorrowerPaymentList(loanData));
        return borrowerPaymentResponse;
    }
}
