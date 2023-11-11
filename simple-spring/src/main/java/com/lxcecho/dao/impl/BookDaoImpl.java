package com.lxcecho.dao.impl;

import com.lxcecho.dao.BookDao;
import org.springframework.stereotype.Repository;

/**
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/11/11
 */
@Repository
public class BookDaoImpl implements BookDao {

	private String label = "1";

	public String getLabel() {
		return label;
	}

	@Override
	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "BookDao [label=" + label + "]";
	}

}
