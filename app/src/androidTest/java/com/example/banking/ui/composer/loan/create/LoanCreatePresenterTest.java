package com.example.banking.ui.composer.loan.create;

import com.example.banking.R;
import com.example.banking.data.model.Loan;
import com.example.banking.util.Constants;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LoanCreatePresenterTest {
    @Mock
    private LoanCreateView mView;

    private LoanCreatePresenter mLoanCreatePresenter;

    private static Loan sPhoneNumberInvalidLoan = new Loan("", "", "", "", Constants.MONTHLY_INCOME_1);
    private static Loan sFullNameInvalidLoan = new Loan("0987000001", "", "", "", Constants.MONTHLY_INCOME_1);
    private static Loan sNationalIdNumberInvalidLoan = new Loan("0987000001", "Nguyễn Văn Tuấn", "1", "", Constants.MONTHLY_INCOME_1);
    private static Loan sProvinceInvalidLoan = new Loan("0987000001", "Nguyễn Văn Tuấn", "111111111", "", Constants.MONTHLY_INCOME_1);
    private static Loan sMonthlyIncomeInvalidLoan = new Loan("0987000001", "Nguyễn Văn Tuấn", "111111111", "An Giang", Constants.MONTHLY_INCOME_1);
    private static Loan sValidLoan = new Loan("0987000001", "Nguyễn Văn Tuấn", "111111111", "An Giang", Constants.MONTHLY_INCOME_3000001);

    @Before
    public void setup() {
        mLoanCreatePresenter = new LoanCreatePresenter();
    }

    @Test
    public void getProvinces_ViewNotNull_Test() {
        mLoanCreatePresenter.start(mView);
        mLoanCreatePresenter.getProvinces();
        mLoanCreatePresenter.stop();
        Mockito.verify(mView, Mockito.times(1)).showProvinces(Mockito.<String>anyList());
    }

    @Test
    public void getProvinces_ViewNull_Test() {
        mLoanCreatePresenter.getProvinces();
        Mockito.verify(mView, Mockito.times(0)).showProvinces(Mockito.<String>anyList());
    }

    @Test
    public void isValid_PhoneNumberInvalid_ViewNotNull_Test() {
        mLoanCreatePresenter.start(mView);
        boolean result = mLoanCreatePresenter.isValid(sPhoneNumberInvalidLoan);
        mLoanCreatePresenter.stop();
        Mockito.verify(mView, Mockito.times(1)).onError(R.string.phone_number_invalid);
        Assert.assertFalse(result);
    }

    @Test
    public void isValid_PhoneNumberInvalid_ViewNull_Test() {
        boolean result = mLoanCreatePresenter.isValid(sPhoneNumberInvalidLoan);
        Mockito.verify(mView, Mockito.times(0)).onError(R.string.phone_number_invalid);
        Assert.assertFalse(result);
    }

    @Test
    public void isValid_FullNameInvalid_ViewNotNull_Test() {
        mLoanCreatePresenter.start(mView);
        boolean result = mLoanCreatePresenter.isValid(sFullNameInvalidLoan);
        mLoanCreatePresenter.stop();
        Mockito.verify(mView, Mockito.times(1)).onError(R.string.full_name_invalid);
        Assert.assertFalse(result);
    }

    @Test
    public void isValid_FullNameInvalid_ViewNull_Test() {
        boolean result = mLoanCreatePresenter.isValid(sFullNameInvalidLoan);
        Mockito.verify(mView, Mockito.times(0)).onError(R.string.full_name_invalid);
        Assert.assertFalse(result);
    }

    @Test
    public void isValid_NationalIdNumberInvalid_ViewNotNull_Test() {
        mLoanCreatePresenter.start(mView);
        boolean result = mLoanCreatePresenter.isValid(sNationalIdNumberInvalidLoan);
        mLoanCreatePresenter.stop();
        Mockito.verify(mView, Mockito.times(1)).onError(R.string.national_id_number_invalid);
        Assert.assertFalse(result);
    }

    @Test
    public void isValid_NationalIdNumberInvalid_ViewNull_Test() {
        boolean result = mLoanCreatePresenter.isValid(sNationalIdNumberInvalidLoan);
        Mockito.verify(mView, Mockito.times(0)).onError(R.string.national_id_number_invalid);
        Assert.assertFalse(result);
    }

    @Test
    public void isValid_ProvinceInvalid_ViewNotNull_Test() {
        mLoanCreatePresenter.start(mView);
        boolean result = mLoanCreatePresenter.isValid(sProvinceInvalidLoan);
        mLoanCreatePresenter.stop();
        Mockito.verify(mView, Mockito.times(1)).onError(R.string.province_invalid);
        Assert.assertFalse(result);
    }

    @Test
    public void isValid_ProvinceInvalid_ViewNull_Test() {
        boolean result = mLoanCreatePresenter.isValid(sProvinceInvalidLoan);
        Mockito.verify(mView, Mockito.times(0)).onError(R.string.province_invalid);
        Assert.assertFalse(result);
    }

    @Test
    public void isValid_MonthlyIncomeInvalid_ViewNotNull_Test() {
        mLoanCreatePresenter.start(mView);
        boolean result = mLoanCreatePresenter.isValid(sMonthlyIncomeInvalidLoan);
        mLoanCreatePresenter.stop();
        Mockito.verify(mView, Mockito.times(1)).onError(R.string.monthly_income_invalid);
        Assert.assertFalse(result);
    }

    @Test
    public void isValid_MonthlyIncomeInvalid_ViewNull_Test() {
        boolean result = mLoanCreatePresenter.isValid(sMonthlyIncomeInvalidLoan);
        Mockito.verify(mView, Mockito.times(0)).onError(R.string.monthly_income_invalid);
        Assert.assertFalse(result);
    }

    @Test
    public void isValid_Valid_Test() {
        boolean result = mLoanCreatePresenter.isValid(sValidLoan);
        Mockito.verify(mView, Mockito.times(0)).onError(Mockito.anyInt());
        Assert.assertTrue(result);
    }

    @Test
    public void createLoan_MonthlyIncomePos1_Test() {
        mLoanCreatePresenter.start(mView);
        mLoanCreatePresenter.createLoan(sValidLoan.getPhoneNumber(), sValidLoan.getFullName(), sValidLoan.getNationalIdNumber(), sValidLoan.getProvince(), 1);
        mLoanCreatePresenter.stop();
        Mockito.verify(mView, Mockito.times(1)).onSuccess();
    }

    @Test
    public void createLoan_MonthlyIncomePos2_Test() {
        mLoanCreatePresenter.start(mView);
        mLoanCreatePresenter.createLoan(sValidLoan.getPhoneNumber(), sValidLoan.getFullName(), sValidLoan.getNationalIdNumber(), sValidLoan.getProvince(), 1);
        mLoanCreatePresenter.stop();
        Mockito.verify(mView, Mockito.times(1)).onSuccess();
    }

    @Test
    public void createLoan_MonthlyIncomePos3_Test() {
        mLoanCreatePresenter.start(mView);
        mLoanCreatePresenter.createLoan(sValidLoan.getPhoneNumber(), sValidLoan.getFullName(), sValidLoan.getNationalIdNumber(), sValidLoan.getProvince(), 1);
        mLoanCreatePresenter.stop();
        Mockito.verify(mView, Mockito.times(1)).onSuccess();
    }

    @Test
    public void createLoan_Valid_ViewNotNull_Test() {
        mLoanCreatePresenter.start(mView);
        mLoanCreatePresenter.createLoan(sValidLoan.getPhoneNumber(), sValidLoan.getFullName(), sValidLoan.getNationalIdNumber(), sValidLoan.getProvince(), 2);
        mLoanCreatePresenter.stop();
        Mockito.verify(mView, Mockito.times(1)).onSuccess();
    }

    @Test
    public void createLoan_Valid_ViewNull_Test() {
        mLoanCreatePresenter.createLoan(sValidLoan.getPhoneNumber(), sValidLoan.getFullName(), sValidLoan.getNationalIdNumber(), sValidLoan.getProvince(), 2);
        Mockito.verify(mView, Mockito.times(0)).onSuccess();
    }

    @Test
    public void createLoan_Invalid_Test() {
        mLoanCreatePresenter.start(mView);
        mLoanCreatePresenter.createLoan(sPhoneNumberInvalidLoan.getPhoneNumber(), sPhoneNumberInvalidLoan.getFullName(), sPhoneNumberInvalidLoan.getNationalIdNumber(), sPhoneNumberInvalidLoan.getProvince(), 0);
        mLoanCreatePresenter.stop();
        Mockito.verify(mView, Mockito.times(0)).onSuccess();
    }
}
