package com.selfdev.entity.bo;

/**
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/10/15
 */
public class HeadLine {

	private String lineName;

	private String lineLink;

	private String lineImg;

	private Integer priority;

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public String getLineLink() {
		return lineLink;
	}

	public void setLineLink(String lineLink) {
		this.lineLink = lineLink;
	}

	public String getLineImg() {
		return lineImg;
	}

	public void setLineImg(String lineImg) {
		this.lineImg = lineImg;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}
}
