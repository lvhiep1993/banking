package com.example.banking.ui.composer.loan.create;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.example.banking.R;
import com.example.banking.data.model.ProvinceResponse;
import com.example.banking.databinding.ActivityLoanCreateBinding;

import java.util.List;

public class LoanCreateActivity extends AppCompatActivity implements LoanCreateView, View.OnClickListener {

    private ActivityLoanCreateBinding mBinding;
    private LoanCreatePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_loan_create);

        mBinding.btnDone.setOnClickListener(this);

        mPresenter = new LoanCreatePresenter();
        mPresenter.start(this);

        mPresenter.getProvinces();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDone:
                if (mBinding != null) {
                    String phoneNumber = mBinding.etPhoneNumber.getText()!= null ? mBinding.etPhoneNumber.getText().toString() : "";
                    String name = mBinding.etName.getText()!= null ? mBinding.etName.getText().toString() : "";
                    String nationalIdNumber = mBinding.etNationalIdNumber.getText()!= null ? mBinding.etNationalIdNumber.getText().toString() : "";
                    String province = (String) mBinding.spProvinces.getSelectedItem();
                    int monthlyIncomePos = mBinding.spMonthlyIncome.getSelectedItemPosition();
                    mPresenter.createLoan(phoneNumber, name, nationalIdNumber, province, monthlyIncomePos);
                }
                break;
        }
    }

    @Override
    public void
    showProvinces(List<String> provinces) {
        if (mBinding != null) {
            ArrayAdapter adapter = new ArrayAdapter<>(LoanCreateActivity.this, android.R.layout.simple_spinner_item, provinces);
            mBinding.spProvinces.setAdapter(adapter);
        }
    }

    @Override
    public void onSuccess() {
        Toast.makeText(this, R.string.create_loan_successful, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(int res) {
        Toast.makeText(this, res, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.stop();
    }
}
