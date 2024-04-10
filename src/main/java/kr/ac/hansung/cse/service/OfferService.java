package kr.ac.hansung.cse.service;

import kr.ac.hansung.cse.dao.OfferDao;
import kr.ac.hansung.cse.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {

    //service -> dao 호출
    @Autowired
    private OfferDao offerDao;

    //getAllOffers()메소드는 offerDao의 getOffers()를 호출
    public List<Offer> getAllOffers() { return offerDao.getOffers();}

    public void insert(Offer offer) {
        offerDao.insert(offer);
    }
}
