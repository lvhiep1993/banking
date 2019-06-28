package com.example.banking.ui.composer.loan.create;

import android.support.annotation.StringRes;

import java.util.List;

interface LoanCreateView {

    void showProvinces(List<String> provinces);

    void onSuccess();

    void onError(@StringRes int res);
}
