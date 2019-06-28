package com.example.banking.ui.composer.loan.offer;

import com.example.banking.data.model.Offer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LoanOfferPresenterTest {
    @Mock
    private LoanOfferView mView;

    private LoanOfferPresenter mLoanOfferPresenter;

    @Before
    public void setup() {
        mLoanOfferPresenter = new LoanOfferPresenter();
    }

    @Test
    public void getLoanOffer_ViewNotNull_Test() {
        mLoanOfferPresenter.start(mView);
        mLoanOfferPresenter.getLoanOffer();
        mLoanOfferPresenter.stop();
        Mockito.verify(mView, Mockito.times(1)).showOffer(Mockito.any(Offer.class));
    }

    @Test
    public void getLoanOffer_ViewNull_Test() {
        mLoanOfferPresenter.getLoanOffer();
        Mockito.verify(mView, Mockito.times(0)).showOffer(Mockito.any(Offer.class));
    }
}
