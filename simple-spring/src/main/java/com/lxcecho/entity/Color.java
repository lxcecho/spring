package com.lxcecho.entity;

/**
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/11/11
 */
public class Color {

	private Car car;

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Color [car=" + car + "]";
	}

}
