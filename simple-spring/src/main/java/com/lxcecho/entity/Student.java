package com.lxcecho.entity;

/**
 * @author lxcecho 909231497@qq.com
 * @since 07.04.2022
 */
//@Component
public class Student {

	private String username;

//	@Autowired
	private Cat cat;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

//	@Lookup
	public Cat getCat() {
		return cat;
	}

	public void setCat(Cat cat) {
		this.cat = cat;
	}
}
