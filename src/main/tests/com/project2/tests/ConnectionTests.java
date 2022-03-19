package com.project2.tests;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import com.project2.models.Car;
import com.project2.repository.ICarDao;

public class ConnectionTests {
	ICarDao carDao = mock(ICarDao.class);
	//CarDAO carDao = mock(CarDAO.class);
	private Car car = new Car();
	 
	 String numberPlate = "TestNumberPlate" ;
	 String make = "TestMake";
	 String fuel = "TestFuel";
	 String email = "test@foo.com";
	 String mot = "2019-12-12";
		 	 	
	@Test (timeout=3000)
	public void testCarGetSet() {
		 this.car.setNumberPlate(numberPlate);
		 this.car.setMake(make);
		 this.car.setFuel(fuel);
		 this.car.setEmail(email);
		 this.car.setMot(mot);
		 
		 assertTrue(numberPlate.equals(car.getNumberPlate()));
		 assertTrue(make.equals(car.getMake()));
		 assertTrue(fuel.equals(car.getFuel()));
		 assertTrue(email.equals(car.getEmail()));
		 assertTrue(mot.equals(car.getMot()));
	}
	
    @Test (timeout=3000)
	public void testSaveCar() {
    	 this.car.setNumberPlate(numberPlate);
		 this.car.setMake(make);
		 this.car.setFuel(fuel);
		 this.car.setEmail(email);
		 this.car.setMot(mot);
		 carDao.saveCar(car);
		}
    
    @Test (timeout=3000)
   	public void testDeleteCar() {
       	 this.car.setNumberPlate(numberPlate);
   		 this.car.setMake(make);
   		 this.car.setFuel(fuel);
   		 this.car.setEmail(email);
   		 this.car.setMot(mot);
   		 carDao.deletecar(car.getId());
   		}
    
    @Test (timeout=3000)
   	public void tesFindCarMake() {
       	 this.car.setNumberPlate(numberPlate);
   		 this.car.setMake(make);
   		 this.car.setFuel(fuel);
   		 this.car.setEmail(email);
   		 this.car.setMot(mot);
   		 carDao.findMake(car.getMake());
   		}
    
    @Test (timeout=3000)
   	public void tesGetAllCars() {
       	 this.car.setNumberPlate(numberPlate);
   		 this.car.setMake(make);
   		 this.car.setFuel(fuel);
   		 this.car.setEmail(email);
   		 this.car.setMot(mot);
   		 carDao.getAllCarsRowMapper();
   		}

}

