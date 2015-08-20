<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
 <style>
 
  .other-color{
  background: lightskyblue
  }
  
  .jumbotron h1{
  color: slategray
  }
  
 </style>

 
 
<title>Grade Book</title>
</head>
<body>

<div class="container">
  
  <div class="container">
  <div class="jumbotron other-color">
    <h1>Grade Sheet</h1>        
  </div>     
</div>
  
  
  
  <form class="form-horizontal" role="form" action="gradebook" method = "post">
    <div class="form-group">
      <label class="control-label col-sm-2" for="assignment">Assignment:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="assignment" name = "assignment" placeholder="Enter assignment">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="grade">Grade:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="grade" name = "grade" placeholder="Enter grade">
      </div>
    </div>
    
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-primary btn-lg btn-block" value="gradebook">Submit</button>
      </div>
    </div>
     
  </form>
</div>


</body>
</html>