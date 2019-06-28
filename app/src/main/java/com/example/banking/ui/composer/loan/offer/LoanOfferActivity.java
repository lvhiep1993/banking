package com.example.banking.ui.composer.loan.offer;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.banking.R;
import com.example.banking.data.model.Offer;
import com.example.banking.databinding.ActivityLoanOfferBinding;
import com.example.banking.ui.composer.loan.create.LoanCreateActivity;

public class LoanOfferActivity extends AppCompatActivity implements LoanOfferView, View.OnClickListener {

    private LoanOfferPresenter mPresenter;
    private ActivityLoanOfferBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_loan_offer);

        mBinding.btnLoan.setOnClickListener(this);

        mPresenter = new LoanOfferPresenter();
        mPresenter.start(this);

        mPresenter.getLoanOffer();
    }

    @Override
    public void showOffer(Offer offer) {
        if (mBinding != null && offer != null) {
            mBinding.setOffer(offer);
            if (offer.getBank() != null) {
                Glide.with(this).load(offer.getBank().getLogo()).into(mBinding.ivBankLogo);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLoan:
                Intent intent = new Intent(this, LoanCreateActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.stop();
    }
}
