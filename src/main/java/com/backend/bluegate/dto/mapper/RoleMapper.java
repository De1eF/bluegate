package com.backend.bluegate.dto.mapper;

import com.backend.bluegate.dto.response.RoleResponseDto;
import com.backend.bluegate.model.UserRole;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    public RoleResponseDto mapToDto(UserRole role) {
        RoleResponseDto responseDto = new RoleResponseDto();
        responseDto.setId(role.getId());
        responseDto.setName(role.getRoleName().name());
        return responseDto;
    }
}
