package com.von.api.board.service;

import com.von.api.board.model.Board;
import com.von.api.board.model.BoardDTO;
import com.von.api.common.service.CommandService;
import com.von.api.common.service.QueryService;

public interface BoardService extends CommandService<BoardDTO>, QueryService<BoardDTO> {

    default Board dtoToEntity(BoardDTO dto){    //dto 를 entity로 바꾸는 것
        return Board.builder()
        .id(dto.getId())
        .title(dto.getTitle())
        .description(dto.getDescription())
        .build();
    }

    default BoardDTO entityToDto(Board ent){ //entity 를 dto로 바꾸는 것
        return BoardDTO.builder()
        .id(ent.getId())
        .title(ent.getTitle())
        .description(ent.getDescription())
        .build();
    }

}
