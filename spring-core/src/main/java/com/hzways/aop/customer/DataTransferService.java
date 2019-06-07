package com.hzways.aop.customer;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("dataTransferService")
@Transactional
public class DataTransferService {

    @ApiMapping("DataTransferService.syncData")
    public String syncData(String msg) {
        return "Result: -> " + msg;
    }

}
