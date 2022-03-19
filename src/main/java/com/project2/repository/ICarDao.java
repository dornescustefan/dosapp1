package com.project2.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.project2.models.Car;

public interface ICarDao {

	void setJdbcTemplate(JdbcTemplate jdbcTemplate);

	java.util.List<Car> getAllCarsRowMapper();

	int deletecar(int id);

	Car getCarById(int id);

	int updateCar(Car car);

	int saveCar(Car car);
	
	List<Car> findMake(String make);
	
	List<Car> findDieselCars();
	
	List<Car> findPetrolCars();

	List<Car> getAllCarMakesRowMapper();

	List<Car> getAllCarByNumberPlate(String numberPlate);

}