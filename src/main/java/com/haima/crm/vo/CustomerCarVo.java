package com.haima.crm.vo;

import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.haima.crm.entity.Car;
import com.haima.crm.entity.CarColor;
import com.haima.crm.entity.CarModel;
import com.haima.crm.entity.CarSeries;
import com.haima.crm.entity.Customer;

/**
 * 客户信息
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-23 19:55:46
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class CustomerCarVo extends PageVo implements Serializable {
	private static final long serialVersionUID = 3039098009796294741L;
	private Customer customer;
	private Car car;
	private CarColor carColor;
	private CarModel carModel;
	private CarSeries carSeries;

	public Customer getCustomer() {
		return customer;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CarColor getCarColor() {
		return carColor;
	}

	public void setCarColor(CarColor carColor) {
		this.carColor = carColor;
	}

	public CarModel getCarModel() {
		return carModel;
	}

	public void setCarModel(CarModel carModel) {
		this.carModel = carModel;
	}

	public CarSeries getCarSeries() {
		return carSeries;
	}

	public void setCarSeries(CarSeries carSeries) {
		this.carSeries = carSeries;
	}

}
