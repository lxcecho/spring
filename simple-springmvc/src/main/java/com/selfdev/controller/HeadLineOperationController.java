package com.selfdev.controller;

import com.selfdev.entity.bo.HeadLine;
import com.selfdev.entity.dto.Result;
import com.selfdev.service.HeadLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/10/15
 */
@Controller
@RequestMapping(value = "/headline")
public class HeadLineOperationController {
	@Autowired
	private HeadLineService headLineService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addHeadLine(@RequestParam("lineName") String lineName,
									@RequestParam("lineLink") String lineLink,
									@RequestParam("lineImg") String lineImg,
									@RequestParam("priority") Integer priority) {
		HeadLine headLine = new HeadLine();
		headLine.setLineName(lineName);
		headLine.setLineLink(lineLink);
		headLine.setLineImg(lineImg);
		headLine.setPriority(priority);
		Result<Boolean> result = headLineService.addHeadLine(headLine);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("addheadline");
		modelAndView.addObject("result", result);
		return modelAndView;
	}

	@RequestMapping(value = "/open", method = RequestMethod.GET)
	public String openPage() {
		return "addheadline";
	}
}
