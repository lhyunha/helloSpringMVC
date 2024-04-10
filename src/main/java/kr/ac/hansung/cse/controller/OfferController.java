package kr.ac.hansung.cse.controller;

import kr.ac.hansung.cse.model.Offer;
import kr.ac.hansung.cse.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class OfferController {

    //Controller -> Service -> Dao
    //의존성 주입

    //자동 연결
    @Autowired
    private OfferService offerService;

    @GetMapping("/offers") //"offers"라는 URL로 들어오면 아래의 메소드 호출
    public String showOffers(Model model) {
        List<Offer> offers = offerService.getAllOffers(); //모든 offers를 가져와서
        model.addAttribute("id_offers", offers); //model에 저장(이때 id는 id_offers) id_offers--> offers.jsp

        return "offers"; //offers ==> view 이름
    }

    @GetMapping("/createoffer")
    public String createoffer(Model model) {

        model.addAttribute("offer", new Offer());
        return "createoffer"; //view로 넘김
    }

    @PostMapping("/docreate")
    public String doCreate(Model model, @Valid Offer offer, BindingResult result) {

        // System.out.println(offer);
        if(result.hasErrors()) {
            System.out.println("== Form data does not validated ==");

            List<ObjectError> errors = result.getAllErrors();

            for(ObjectError error:errors) {
                System.out.println(error.getDefaultMessage());
            }

            return "createoffer";
        }

        // Controller -> Service -> Dao
        //Controlle -> Service -> Dao
        //에러가 없을 경우
        offerService.insert(offer); //DB에 저장
        return "offercreated";
    }
}
