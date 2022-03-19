package com.project2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project2.models.Car;
import com.project2.repository.ICarDao;

@RestController
public class CarMakesController {
	 @Autowired
	 ICarDao cardao;
	
	@RequestMapping(value="carmakeslist", method = RequestMethod.GET)
	public List<Car> getCarMakes(){
		List<Car>  carMakes= cardao.getAllCarMakesRowMapper(); ;
		return carMakes;
		}
	
}
