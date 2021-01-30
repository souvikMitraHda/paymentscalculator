package com.lendico.paymentscalculator.utility;


import com.lendico.paymentscalculator.pojo.LoanData;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;

@Component
public class CalculatorUtility {

    DecimalFormat df = new DecimalFormat("0.00");

    public Double calculateAnnuity(LoanData loanData){
        Double monthlyRateOfInterest=Double.parseDouble(loanData.getNominalRate())/(100*12);
        return (Double.parseDouble(df.format((Double.parseDouble(loanData.getLoanAmount())*monthlyRateOfInterest) /
                (1-Math.pow(1+monthlyRateOfInterest, -loanData.getDuration())))));

    }

    public Double calculateInterest(Double rateOfInterest,Double initialOutstandingPrincipal){
        return (Double.parseDouble
                (df.format((rateOfInterest*30*initialOutstandingPrincipal)/360)));
    }

    public Double calculatePrincipal(Double annuity, Double interest,
                                     Double initialOutstandingPrincipalAmount){
        Double principal=Double.parseDouble(df.format(annuity-interest));
        if(principal>initialOutstandingPrincipalAmount){
            return initialOutstandingPrincipalAmount;
        }else{
            return principal;
        }
    }

    public Double calculateBorrowerPaymentAmount(Double principal, Double interest){
        return (Double.parseDouble(df.format(principal+interest)));
    }

    public Double calculateRemainingOutstandingPrincipal(Double initialOutstandingPrincipal,
                                                         Double principal){
        return(Double.parseDouble(df.format(initialOutstandingPrincipal-principal)));
    }



}
