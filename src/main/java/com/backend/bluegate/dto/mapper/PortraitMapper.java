package com.backend.bluegate.dto.mapper;

import com.backend.bluegate.dto.request.PortraitRequestDto;
import com.backend.bluegate.dto.response.PortraitResponseDto;
import com.backend.bluegate.model.Portrait;
import org.springframework.stereotype.Component;

@Component
public class PortraitMapper {
    public Portrait toModel(PortraitRequestDto portraitRequestDto) {
        Portrait portrait = new Portrait();
        portrait.setData(portraitRequestDto.getData());
        return portrait;
    }

    public PortraitResponseDto toDto(Portrait portrait) {
        PortraitResponseDto dto = new PortraitResponseDto();
        dto.setId(portrait.getId());
        dto.setData(portrait.getData());
        return dto;
    }
}
