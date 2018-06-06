package com.yaic.auth.thirdParty.service;

import java.util.List;

import com.yaic.auth.thirdParty.dto.AuthTokenDto;

public interface AuthTokenDtoService {
    int addInfo ( AuthTokenDto authTokenDto );

    List<AuthTokenDto> getListByConditions ( AuthTokenDto authTokenDto );

    int updateInfo ( AuthTokenDto authTokenDto );

    int deleteInfo ( String appId );

}
