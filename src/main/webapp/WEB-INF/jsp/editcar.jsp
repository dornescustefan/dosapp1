<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<title>Edit car</title>
<style>
    .error {
        color: red; font-weight: bold;
    }
 </style>
 <script>
 function upperCase(a){
	    setTimeout(function(){
	        a.value = a.value.toUpperCase();
	    }, 1);
	}
 </script>
 
</head>
<body style="background-color: #E6E6FA; font-family: 'Open Sans', sans-serif;">
<div class="container">
<div class="col-sm-4"></div>
<div class="col-sm-4">
 <h1>Edit car data</h1>  
     <form:form action ="savechanges" modelAttribute="editcarform" method="POST" >
     <form:input path="Id"  id="Id"  type="hidden"/>
       
       <div class="form-group"> 
         	<label  for="numbePlate">Number plate :</label>
          	<form:input path="numberPlate"  id="numberPlate"  type="text" class="form-control" onkeydown="upperCase(this)"/>
          	<form:errors path="numberPlate"  cssClass="error"/> 
       </div>
		
		 <div class="form-group"> 
        	<label  for="fuel">Fuel:</label>
        	<!--<form:input path="fuel"  id="fuel" type="text" class="form-control"/>-->
        	<form:select path="fuel"  id="fuel" class="form-control"  type="text">
        	 <option selected disabled >--Please select fuel--</option>
         	<option>Diesel</option>
         	<option>Petrol</option>
         	</form:select>
         	<form:errors path="fuel"  cssClass="error"/>
        </div>
        
        <div class="form-group"> 
        	<label  for="mot">MOT valid till:</label>
        	<form:input path="mot"  id="mot"  type="Date"  class="form-control"/>
        	<form:errors path="mot"  cssClass="error"/>
       </div>
                  
       <div class="form-group"> 
        	<label  for="email">Owner email address:</label>
        	<form:input path="email"  id="mot" type="text" class="form-control"/>
        	 <form:errors path="email"  cssClass="error"/>
       </div>
        <button type="submit" class="btn btn-warning">Save changes</button>
       </form:form>
       <div class="col-sm-4"></div>
</div>
</div>
</body>
</html>