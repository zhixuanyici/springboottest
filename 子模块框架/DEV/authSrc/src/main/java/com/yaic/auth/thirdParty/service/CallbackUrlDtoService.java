package com.yaic.auth.thirdParty.service;

import java.util.List;

import com.yaic.auth.thirdParty.dto.CallbackUrlDto;

public interface CallbackUrlDtoService {

    int addInfo ( CallbackUrlDto callbackUrlDto );

    List<CallbackUrlDto> getListByConditions ( CallbackUrlDto callbackUrlDto );

    int updateInfo ( CallbackUrlDto callbackUrlDto );

    int deleteInfo ( Integer callbackUrlId );

    CallbackUrlDto getOneByCallbackUrlId ( Integer callbackUrlId );

}
