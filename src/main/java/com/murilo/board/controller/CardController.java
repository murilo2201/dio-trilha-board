package com.murilo.board.controller;


import com.murilo.board.model.Card;
import com.murilo.board.repository.BoardRepository;
import com.murilo.board.repository.CardRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {

    private final CardRepository cardRepository;
    private final BoardRepository boardRepository;

    public CardController(CardRepository cardRepository, BoardRepository boardRepository) {
        this.cardRepository = cardRepository;
        this.boardRepository = boardRepository;
    }

    @GetMapping
    public List<Card> getAll(){
        return cardRepository.findAll();
    }

    @PostMapping("/{boardId}")
    public Card create(@PathVariable Long boardId, @RequestBody Card card){
        var board = boardRepository.findById(boardId).orElseThrow();
        card.setBoard(board);

        return cardRepository.save(card);
    }
}
