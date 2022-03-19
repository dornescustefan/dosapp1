package com.project2.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project2.models.Car;
import com.project2.repository.ICarDao;

@Controller
public class ViewCarsController {
   @Autowired
   ICarDao cardao;
	
	//view all cars
   @RequestMapping(value="/viewcars" )
	public ModelAndView viewcars(){  
        List<Car> carslist=cardao.getAllCarsRowMapper();  
        return new ModelAndView("viewcars","carslist",carslist); 
    }
	
	//add a new car page
	@RequestMapping(value="/addcar")
	public ModelAndView addcar(@ModelAttribute("savecarform") Car car) {
		return new ModelAndView("addcar", "savecarform", car);
	}
	
	//save new car form	
	@RequestMapping(value="/savecar", method = RequestMethod.POST)
	public  ModelAndView saveCars(@Valid @ModelAttribute("savecarform") Car car, BindingResult result) {
		 if (result.hasErrors()) {
	            return new ModelAndView("/addcar"); 
	        }
		cardao.saveCar(car);
		return new ModelAndView("redirect:/viewcars.html"); 
	}
	
	//delete a car after id
	@RequestMapping(value="delete{id}", method = RequestMethod.GET) 
    public ModelAndView deletecar(@PathVariable int id){
	   cardao.deletecar(id);
	   return new ModelAndView("redirect:/viewcars.html"); 
	    }
	
	//edit existing car after id
	@RequestMapping(value= "/edit{id}", method = RequestMethod.GET)
	public ModelAndView editcar(@PathVariable int id) {
		Car aCar = cardao.getCarById(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("editcar");
		mv.addObject("editcarform", aCar);
		return mv;
	}
	
	//save changes made on existing car
	@RequestMapping(value= "/savechanges", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("editcarform") Car car, BindingResult result){  
		if (result.hasErrors()) {
				return "editcar"; 
        }
	   cardao.updateCar(car);  
       return "redirect:/viewcars"; 
       }  
	
	//search car after make
	@RequestMapping(value="/searchmake" )
	public ModelAndView searchcar(HttpServletRequest request, HttpServletResponse response){
		String searchedMake = request.getParameter("searchedValue");
		List<Car> carMakeList=cardao.findMake(searchedMake);  
	    return new ModelAndView("viewcars","carslist", carMakeList);
	    }
	   
	 //find Diesel cars
	@RequestMapping(value="/searchDieselCars" )
	public ModelAndView searchDieselCars(){  
	    List<Car> dieselCarList=cardao.findDieselCars();  
	    return new ModelAndView("viewcars","carslist", dieselCarList); 
	    }
	   
	   //find Petrol cars
	@RequestMapping(value="/searchPetrolCars" )
	public ModelAndView searchPetrolCars(){  
	    List<Car> petrolCarList=cardao.findPetrolCars();  
	   	return new ModelAndView("viewcars","carslist", petrolCarList); 
	    }
	//Search cars by number plate
	@RequestMapping(value="searchnumberplate", method = RequestMethod.GET)
	public ModelAndView getCarByNumberPlate(HttpServletRequest request, HttpServletResponse response){
		String searchedNumberPlate = request.getParameter("searchedValue");
		List<Car>  carByNumberPlate= cardao.getAllCarByNumberPlate(searchedNumberPlate); ;
		return  new ModelAndView("viewcars", "carslist", carByNumberPlate);
		}
}
