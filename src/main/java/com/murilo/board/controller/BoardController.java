package com.murilo.board.controller;


import com.murilo.board.model.Board;
import com.murilo.board.repository.BoardRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {

    private final BoardRepository repository;

    public BoardController(BoardRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Board> getAll(){
        return repository.findAll();
    }

    @PostMapping
    public Board create(@RequestBody Board board){
        return repository.save(board);
    }
}
