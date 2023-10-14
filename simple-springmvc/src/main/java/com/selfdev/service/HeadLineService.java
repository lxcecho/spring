package com.selfdev.service;

import com.selfdev.entity.bo.HeadLine;
import com.selfdev.entity.dto.Result;

/**
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/10/15
 */
public interface HeadLineService {

	Result<Boolean> addHeadLine(HeadLine headLine);

}
