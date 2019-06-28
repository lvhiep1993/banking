package com.example.banking.data;

import com.example.banking.data.model.Loan;
import com.example.banking.data.model.LoanResponse;
import com.example.banking.data.model.Offer;
import com.example.banking.util.Constants;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LoanRepositoryTest {

    private static Loan sValidLoan = new Loan("0987000001", "Nguyễn Văn Tuấn", "111111111", "An Giang", Constants.MONTHLY_INCOME_3000001);

    private LoanRepository mLoanRepository;

    @Before
    public void setup() {
        mLoanRepository = LoanRepository.getInstance();
    }

    @Test
    public void getOfferTest() {
        Offer result = mLoanRepository.getOffer();
        Assert.assertNotNull(result);
    }

    @Test
    public void getProvincesTest() {
        List<String> result = mLoanRepository.getProvinces();
        Assert.assertNotNull(result);
    }

    @Test
    public void createLoanTest() {
        LoanResponse result = mLoanRepository.createLoan(sValidLoan);
        Assert.assertNotNull(result);
    }
}
