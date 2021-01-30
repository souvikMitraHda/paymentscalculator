package com.lendico.paymentscalculator.service;


import com.lendico.paymentscalculator.pojo.BorrowerPayment;
import com.lendico.paymentscalculator.pojo.LoanData;
import com.lendico.paymentscalculator.utility.CalculatorUtility;
import com.lendico.paymentscalculator.utility.DateUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class LoanServiceImpl implements LoanService{

    @Autowired
    CalculatorUtility calculatorUtility;

    @Autowired
    DateUtility dateUtility;

    DecimalFormat df = new DecimalFormat("0.00");

    @Override
    public List<BorrowerPayment> getBorrowerPaymentList(LoanData loanData) {
        List<BorrowerPayment> borrowerPaymentList = new ArrayList<>();
        Integer numberOfMonths=0;
        Double annuityValue=calculatorUtility.calculateAnnuity(loanData);
        while(numberOfMonths!=loanData.getDuration()){
            BorrowerPayment borrowerPayment = new BorrowerPayment();
            if(!borrowerPaymentList.isEmpty()){
                borrowerPayment.setInitialOutstandingPrincipal(borrowerPaymentList.get(borrowerPaymentList.size()-1).
                        getRemainingOutstandingPrincipal());
                borrowerPayment.setDate(dateUtility.getNextMonthDate(borrowerPaymentList.get(borrowerPaymentList.size()-1).
                        getDate()));
            }else{
                borrowerPayment.setInitialOutstandingPrincipal(df.format(Double.valueOf(loanData.getLoanAmount())));
                borrowerPayment.setDate(loanData.getStartDate());
            }
            borrowerPayment.setInterest(String.valueOf(calculatorUtility.
                    calculateInterest((Double.parseDouble(loanData.getNominalRate())/100),
                            Double.valueOf(borrowerPayment.getInitialOutstandingPrincipal()))));
            borrowerPayment.setPrincipal(String.valueOf(calculatorUtility.calculatePrincipal(annuityValue,
                    Double.valueOf(borrowerPayment.getInterest()),
                    Double.parseDouble(borrowerPayment.getInitialOutstandingPrincipal()))));
            borrowerPayment.setBorrowerPaymentAmount(String.valueOf(calculatorUtility.
                    calculateBorrowerPaymentAmount(Double.parseDouble(borrowerPayment.getPrincipal()),
                            Double.parseDouble(borrowerPayment.getInterest()))));
            borrowerPayment.setRemainingOutstandingPrincipal(String.valueOf(calculatorUtility.
                    calculateRemainingOutstandingPrincipal(Double.parseDouble
                            (borrowerPayment.getInitialOutstandingPrincipal()),
                            Double.parseDouble(borrowerPayment.getPrincipal()))));

            borrowerPaymentList.add(borrowerPayment);
            numberOfMonths++;
        }
        return borrowerPaymentList;
    }
}
