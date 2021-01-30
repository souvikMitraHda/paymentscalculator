package com.lendico.paymentscalculator;

import com.lendico.paymentscalculator.pojo.BorrowerPayment;
import com.lendico.paymentscalculator.pojo.LoanData;
import com.lendico.paymentscalculator.service.LoanService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PaymentscalculatorApplicationTests {

	@Autowired
	LoanService loanService;

	@Test
	void contextLoads() {
	}

	@Test
	void testGetBorrowerPaymentListSize(){
		LoanData loanData = new LoanData("5000","5.0",24,"2018-01-01T00:00:01Z");
		List<BorrowerPayment> borrowerPaymentList= loanService.getBorrowerPaymentList(loanData);
		assertThat(borrowerPaymentList.size()==24);
	}

	@Test
	void testGetBorrowerPaymentListFirstObject(){
		LoanData loanData = new LoanData("5000","5.0",24,"2018-01-01T00:00:01Z");
		List<BorrowerPayment> borrowerPaymentList= loanService.getBorrowerPaymentList(loanData);
		assertThat(
				borrowerPaymentList.get(0).getInterest().equals("20.83"));
		assertThat(borrowerPaymentList.get(0).getDate().equals("2018-01-01T00:00:01Z"));
		assertThat(borrowerPaymentList.get(0).getPrincipal().equals("198.53"));
		assertThat(borrowerPaymentList.get(0).getRemainingOutstandingPrincipal().equals("4801.47"));
		assertThat(borrowerPaymentList.get(0).getInitialOutstandingPrincipal().equals("5000.00"));
		assertThat(borrowerPaymentList.get(0).getBorrowerPaymentAmount().equals("219.36"));
	}

	@Test
	void testAnnuity(){
		LoanData loanData = new LoanData("5000","5.0",24,"2018-01-01T00:00:01Z");
		List<BorrowerPayment> borrowerPaymentList= loanService.getBorrowerPaymentList(loanData);
		assertThat(borrowerPaymentList.get(0).getBorrowerPaymentAmount().equals("219.36"));
	}


}
