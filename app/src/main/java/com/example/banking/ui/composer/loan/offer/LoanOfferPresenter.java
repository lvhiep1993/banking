package com.example.banking.ui.composer.loan.offer;

import com.example.banking.data.LoanRepository;
import com.example.banking.data.model.Offer;
import com.example.banking.ui.base.BasePresenter;

class LoanOfferPresenter extends BasePresenter<LoanOfferView> {

    void getLoanOffer() {
        Offer offer = LoanRepository.getInstance().getOffer();
        if (view != null) {
            view.showOffer(offer);
        }
    }
}
