<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>       
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<script src="https://use.fontawesome.com/37d60b494a.js"></script>
		<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Fleet manager</title>
	<script type="text/javascript">
	function upperCase(a){
	    setTimeout(function(){
	        a.value = a.value.toUpperCase();
	    }, 1);
	}	
	</script>
	</head>
<body style="background-color: #E6E6FA; font-family: 'Open Sans', sans-serif;">

<div class="container" style="margin-top:50px" >
<nav  class="navbar navbar-dark navbar-fixed-top "  >
  <div class="container-fluid">
    	<div class="navbar-header" >
      			<a class="navbar-brand" href="viewcars"><i class="fa fa-car" aria-hidden="true" style="font-size: 150%; color: #337ab7;"></i>
      			</a>
    	</div>
    	<a href="viewcars" class="navbar-left">	
      	     <button class="btn btn-primary navbar-btn" style="margin-right: 5px" >			
      	     View all cars
    		</button>
       </a>
      <a href="addcar" style=" font-weight: bold;" class="navbar-left">
       		<button  class="btn btn-primary navbar-btn" style="margin-right: 5px"  >
       			Add new car
       		</button>
       	</a>
       	<a href="searchPetrolCars" class="navbar-left">
       		<button  class="btn btn-primary navbar-btn"  style="margin-right: 5px">
       			Petrol cars
       		</button>
       	</a>
       	<a href="searchDieselCars" class="navbar-left">
       		<button  class="btn btn-primary navbar-btn" style="margin-right: 5px"  >
       			Diesel cars
       		</button>
       	</a>
       <form action="searchnumberplate" class="navbar-form navbar-left">
      		<div class="form-group">
        		<input name="searchedValue"  type="text"  class="form-control" placeholder="Search number plate" onkeydown="upperCase(this)">
               	<button type="submit" class="btn btn-primary " >Search</button>
            </div>	
    	</form>
   </div>
  </nav>
   
<table  class="table table-bordered table-hover">  
		<tr >
			<th>ID</th>
			<th>NUMBER PLATE</th>
			<th>MAKE</th>
			<th>FUEL</th>
			<th>MOT </th>
			<th>OWNERS EMAIL ADDRESS</th>
			<th>EDIT</th>
			<th>DELETE</th>
		</tr>  
   <c:forEach var="cars"	 items="${carslist}"> 
   <tr  style="position: fixed; top:100px; "></tr>  
   <tr>  
   		<td>${cars.id}</td>  
   		<td>${cars.numberPlate}</td>
   		  <td>${cars.make}</td>
   		<td>${cars.fuel}</td>  
   		<td>${cars.mot}</td> 
   		<td >${cars.email}</td>  
   		<td><a href="edit${cars.id}"><input type="button" value = "Edit Car" class="btn btn-warning" /></a></td>  
   		<td><a href="delete${cars.id}"><input type="button" value = "Delete Car" class="btn btn-danger" /></a></td>  
   </tr>  
   </c:forEach>  
   </table> 

 </div>
  </body>
</html>