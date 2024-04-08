package com.von.api.board.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.von.api.article.model.Article;
import com.von.api.article.model.ArticleDTO;
import com.von.api.board.model.Board;
import com.von.api.board.model.BoardDTO;
import com.von.api.common.service.CommandService;
import com.von.api.common.service.QueryService;

public interface BoardService extends CommandService<BoardDTO>, QueryService<BoardDTO> {

    default Board dtoToEntity(BoardDTO dto){    //dto 를 entity로 바꾸는 것
        return Board.builder().build();
    }

    default BoardDTO entityToDto(Optional<Board> optional){ //entity 를 dto로 바꾸는 것
        return BoardDTO.builder().build();
    }

}
