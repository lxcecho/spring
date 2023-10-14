package com.selfdev.service.impl;

import com.selfdev.entity.bo.HeadLine;
import com.selfdev.entity.dto.Result;
import com.selfdev.service.HeadLineService;
import org.springframework.stereotype.Service;

@Service
public class HeadLineServiceImpl implements HeadLineService {
	@Override
	public Result<Boolean> addHeadLine(HeadLine headLine) {
		System.out.printf("addHeadLine被执行啦, lineName[{%s}],lineLink[{%s}],lineImg[{%s}], priority[{%d}]",
				headLine.getLineName(), headLine.getLineLink(), headLine.getLineImg(), headLine.getPriority());
		Result<Boolean> result = new Result<Boolean>();
		result.setCode(200);
		result.setMsg("请求成功啦");
		result.setData(true);
		return result;
	}
}
