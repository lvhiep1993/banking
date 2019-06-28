package com.example.banking.ui.composer.loan.create;

import com.example.banking.R;
import com.example.banking.data.LoanRepository;
import com.example.banking.data.model.Loan;
import com.example.banking.data.model.LoanResponse;
import com.example.banking.ui.base.BasePresenter;
import com.example.banking.util.Constants;
import com.example.banking.util.Utils;

import java.util.List;

class LoanCreatePresenter extends BasePresenter<LoanCreateView> {

    void getProvinces() {
        List<String> provinces = LoanRepository.getInstance().getProvinces();
        if (view != null) {
            view.showProvinces(provinces);
        }
    }

    void createLoan(String phoneNumber, String name, String nationalIdNumber, String province, int monthlyIncomePos) {
        int monthlyIncome;
        switch (monthlyIncomePos) {
            case 0:
                monthlyIncome = Constants.MONTHLY_INCOME_1;
                break;
            case 1:
                monthlyIncome = Constants.MONTHLY_INCOME_3000001;
                break;
            default:
                monthlyIncome = Constants.MONTHLY_INCOME_1000001;
                break;
        }
        Loan loan = new Loan(phoneNumber, name, nationalIdNumber, province, monthlyIncome);
        if (isValid(loan)) {
            LoanResponse loanResponse = LoanRepository.getInstance().createLoan(loan);
            if (view != null && loanResponse != null) {
                view.onSuccess();
            }
        }
    }

    boolean isValid(Loan loan) {
        if (!Utils.isPhoneNumberValid(loan.getPhoneNumber())) {
            if (view != null) {
                view.onError(R.string.phone_number_invalid);
            }
            return false;
        }
        if (!Utils.isFullNameValid(loan.getFullName())) {
            if (view != null) {
                view.onError(R.string.full_name_invalid);
            }
            return false;
        }
        if (!Utils.isNationalIdNumberValid(loan.getNationalIdNumber())) {
            if (view != null) {
                view.onError(R.string.national_id_number_invalid);
            }
            return false;
        }
        if (!Utils.isProvinceValid(loan.getProvince())) {
            if (view != null) {
                view.onError(R.string.province_invalid);
            }
            return false;
        }
        if (!Utils.isMonthlyIncomeValid(loan.getMonthlyIncome())) {
            if (view != null) {
                view.onError(R.string.monthly_income_invalid);
            }
            return false;
        }

        return true;
    }
}
