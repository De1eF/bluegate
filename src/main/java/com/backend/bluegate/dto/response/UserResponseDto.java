package com.backend.bluegate.dto.response;

import java.util.List;
import lombok.Data;

@Data
public class UserResponseDto {
    private Long id;
    private String email;
    private String username;
    private Long portraitId;
    private List<RoleResponseDto> roles;
}
