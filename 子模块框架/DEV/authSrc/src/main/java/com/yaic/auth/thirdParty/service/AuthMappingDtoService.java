package com.yaic.auth.thirdParty.service;

import java.util.List;

import com.yaic.auth.thirdParty.dto.AuthMappingDto;

public interface AuthMappingDtoService {

    int addInfo ( AuthMappingDto authMappingDto );

    List<AuthMappingDto> getList ( AuthMappingDto authMappingDto );

}
