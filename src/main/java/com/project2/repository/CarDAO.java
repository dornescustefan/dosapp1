package com.project2.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.project2.models.Car;

public class CarDAO implements ICarDao {
	
	JdbcTemplate jdbcTemplate;
	/* (non-Javadoc)
	 * @see com.project2.repository.ICarDao#setJdbcTemplate(org.springframework.jdbc.core.JdbcTemplate)
	 */
public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
 	this.jdbcTemplate = jdbcTemplate;
	}

	    
   /* (non-Javadoc)
 * @see com.project2.repository.ICarDao#getAllCarsRowMapper()
 */
	//Generate table items with RowMapper
public java.util.List<Car> getAllCarsRowMapper(){
	      String sql ="select * from car_list;";
		 return jdbcTemplate.query(sql,new RowMapper<Car>(){  
			 public Car mapRow(ResultSet resultset, int rownumber) throws SQLException { 
				Car cars=new Car();  
		        cars.setId(resultset.getInt("id"));
		        cars.setNumberPlate(resultset.getString("number_plate"));
		        cars.setMake(resultset.getString("make"));
		        cars.setFuel(resultset.getString("fuel"));
		        cars.setMot(resultset.getString("mot"));
		        cars.setEmail(resultset.getString("email"));
		        return cars;  
		     
			 }});
		  }
   
   /* (non-Javadoc)
 * @see com.project2.repository.ICarDao#deletecar(int)
 */
//Delete car after Id
public int deletecar(int id){  
	    String sql="delete from car_list where ID="+id+"";  
	    return jdbcTemplate.update(sql);  
	} 
   
   /* (non-Javadoc)
 * @see com.project2.repository.ICarDao#getCarById(int)
 */
//Find a car after ID
public Car getCarById(int id){  
	    String sql="select * from car_list where ID=?";  
	    Car aCar = (Car)jdbcTemplate.queryForObject(
	    		sql, new Object[]{id},
	    		new BeanPropertyRowMapper<Car>(Car.class));
	    return aCar; 
   }
   
   /* (non-Javadoc)
 * @see com.project2.repository.ICarDao#updateCar(com.project2.models.Car)
 */
//Update Car details
public int updateCar(Car car){  
		
	    return jdbcTemplate.update("update car_list set number_plate = ?, fuel = ?, mot=?, email=? where ID=?",
	    car.getNumberPlate(), car.getFuel(), car.getMot(), car.getEmail(), car.getId());
	}  
   
   /* (non-Javadoc)
 * @see com.project2.repository.ICarDao#saveCar(com.project2.models.Car)
 */
//Save a new car
public int saveCar(Car car){ 
	   String sql = "insert into car_list(number_plate,make,fuel,mot,email) values('"
			   		+car.getNumberPlate()+"','"
			   		+car.getMake()+"','"
			   		+car.getFuel()+"','"
			   		+car.getMot()+"','"
			   		+car.getEmail()+"')";
	   return jdbcTemplate.update(sql);
		 
	} 
//Search a car make
public List<Car> findMake(String make){
		String sql = "SELECT * FROM car_list where make='" +make+"'";
		List<Car> carMake =
		jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(Car.class));
	return carMake;
	}

//Search all diesel Cars
public List<Car> findDieselCars(){
		String sql = "SELECT * FROM car_list where fuel='Diesel'";
		List<Car> dieselCars =
		jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(Car.class));
	return dieselCars;
	}

//Search all Petrol Cars
public List<Car> findPetrolCars(){
		String sql = "SELECT * FROM car_list where fuel='Petrol'";
		List<Car> petrolCars =
		jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(Car.class));
	return petrolCars;
	}

//Car Make list for REST services
public List<Car> getAllCarMakesRowMapper() {
	String sql ="select * from carmakes;";
	 return jdbcTemplate.query(sql,new RowMapper<Car>(){  
		 public Car mapRow(ResultSet resultset, int rownumber) throws SQLException { 
			Car carMakes=new Car();  
	        carMakes.setId(resultset.getInt("idcarmakes"));
	        carMakes.setMake(resultset.getString("carmake"));
	        return carMakes;  
	     }});
	}

//Car By Number Plate 
public List<Car> getAllCarByNumberPlate(String numberPlate) {
	String sql = "SELECT * FROM car_list where number_plate='" +numberPlate+"'";
	List<Car> cars = jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(Car.class));
		return cars;
	}
}

