<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>       
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a new car</title>
<style>
    .error {
        color: red; font-weight: bold;
    }
 </style>
 
<script type="text/javascript">
		$(document).ready(
			function() {
				$.getJSON('<spring:url value="carmakeslist.json"/>', {
					ajax : 'true'
				}, function(data){
					var html = '<option selected disabled >--Please select a car make--</option>';
					var len = data.length;
					for (var i = 0; i < len; i++) {
						html += '<option value="' + data[i].make + '">'
								+ data[i].make + '</option>';
					}
					html += '</option>';
					
					$('#make').html(html);
				});
				
			});
		
		function upperCase(a){
		    setTimeout(function(){
		        a.value = a.value.toUpperCase();
		    }, 1);
		}	
</script>

</head>
<body style="background-color: #E6E6FA; font-family: 'Open Sans', sans-serif;">
  
<div class="container" >
<div class="col-sm-4"></div>
<div class="col-sm-4">
<h2>Add your car details</h2><br>
<form:form action="savecar"  modelAttribute="savecarform" method="POST">

	<div class="form-group"> 
       		<label  for="numberPlate" >Number plate :</label>
         	<form:input path="numberPlate"   id="numberPlate" class="form-control" type="text" placeholder="Number Plate" onkeydown="upperCase(this)" />
			<form:errors path="numberPlate"  cssClass="error"/>
	</div>

	<div class="form-group"> 
        <label  for="make">Make :</label>
        <form:select path="make" id="make" class="form-control"  type="text"/>
		<form:errors path="make"  cssClass="error"/>
	</div>
  	
	<div class="form-group"> 
        <label  for="fuel">Fuel :</label>
         <!--<form:input  path="fuel"  id="fuel" class="form-control"  type="text" placeholder="Fuel"/>-->
         <form:select path="fuel"  id="fuel" class="form-control"  type="text">
         <option selected disabled >--Please select fuel--</option>
         <option>Diesel</option>
         <option>Petrol</option>
         </form:select>
         <form:errors path="fuel"  cssClass="error"/>
	</div>
  	
  	<div class="form-group"> 
        <label  for="mot"> MOT valid till :</label>
         <form:input  path="mot"  id="mot" class="form-control"  type="Date" min="2018-01-01"  placeholder="yyyy-mm-dd"/>
  		<form:errors path="mot"  cssClass="error"/>
  	</div>
  	
  	<div class="form-group"> 
        <label  for="email">Owners email address :</label>
        <form:input path="email"  id="email" class="form-control"  type="text" placeholder="address@email.com"/>
  		<form:errors path="email"  cssClass="error"/>
  	</div>
	<button type="submit" class="btn btn-primary">Save car</button>
</form:form>
</div> 
<div class="col-sm-4"></div>
 </div>
</body>
</html>