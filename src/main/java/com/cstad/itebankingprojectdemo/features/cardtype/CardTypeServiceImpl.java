package com.cstad.itebankingprojectdemo.features.cardtype;

import com.cstad.itebankingprojectdemo.domain.CardType;
import com.cstad.itebankingprojectdemo.features.cardtype.dto.CardTypeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CardTypeServiceImpl implements CardTypeService{
    private final CardTypeRepository cardTypeRepository;
    @Override
    public List<CardTypeResponse> findAllCardType() {
        List<CardType> cardType = cardTypeRepository.findAll();
        return cardType.stream().map(
                ct->new CardTypeResponse(
                        ct.getName(), ct.getIsDeleted())).toList();
    }
    @Override
    public CardTypeResponse findCardTypeByName(String name) {
        CardType cardType = cardTypeRepository.findByNameIgnoreCase(name);
        if (cardType==null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,"Don't Found"
            );
        }
        return new CardTypeResponse(cardType.getName(),cardType.getIsDeleted());
    }
}
