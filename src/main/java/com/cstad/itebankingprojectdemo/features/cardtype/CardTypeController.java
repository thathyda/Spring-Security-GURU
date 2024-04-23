package com.cstad.itebankingprojectdemo.features.cardtype;

import com.cstad.itebankingprojectdemo.features.cardtype.dto.CardTypeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class CardTypeController {
    private final CardTypeService cardTypeService;
    @GetMapping("/cardTypes")
    List<CardTypeResponse> findAllCardType (){
        return cardTypeService.findAllCardType();
    }
    @GetMapping("/cardTypes/{name}")
    CardTypeResponse findCardTypeByName (@PathVariable String name){
        return cardTypeService.findCardTypeByName(name);
    }
}