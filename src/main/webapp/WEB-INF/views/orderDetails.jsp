<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <div class="row">
    <div class="col-md-4 col-md-offset-4">
      <form class="form-horizontal" role="form">
        <fieldset>

          <!-- Form Name -->
          <legend>Enter Shipping Details</legend>

          <!-- Text input-->
          <div class="form-group">
            <label class="col-sm-2 control-label" for="textinput">Full Name</label>
            <div class="col-sm-10">
              <input type="text" placeholder="Name" name="name" class="form-control">
            </div>
          </div>

          <!-- Text input-->
          <div class="form-group">
            <label class="col-sm-2 control-label" for="textinput">Mobile Number</label>
            <div class="col-sm-10">
              <input type="text" placeholder="contact" name="contact" class="form-control">
            </div>
          </div>

 		  <div class="form-group">
            <label class="col-sm-2 control-label" for="textinput">House No.</label>
            <div class="col-sm-10">
              <input type="text" placeholder="HouseNumber" name="hnum" class="form-control">
            </div>
          </div>

		  <div class="form-group">
            <label class="col-sm-2 control-label" for="textinput">Locality:  </label>
            <div class="col-sm-10">
              <input type="text" placeholder="Locality" name="locality" class="form-control">
            </div>
          </div>

          <!-- Text input-->
          <div class="form-group">
            <label class="col-sm-2 control-label" for="textinput">City</label>
            <div class="col-sm-10">
              <input type="text" placeholder="City" name="city" class="form-control">
            </div>
          </div>

          <!-- Text input-->
          <div class="form-group">
            <label class="col-sm-2 control-label" for="textinput">State</label>
            <div class="col-sm-4">
              <input type="text" placeholder="State" name="state" class="form-control">
            </div>

            <label class="col-sm-2 control-label" for="textinput">Pincode</label>
            <div class="col-sm-4">
              <input type="text" placeholder="Post Code" name="pincode" class="form-control">
            </div>
          </div>



          

          <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
              <div class="pull-right">
                <button type="submit" class="btn btn-default">Cancel</button>
                <button type="submit" class="btn btn-primary">Save</button>
              </div>
            </div>
          </div>

        </fieldset>
      </form>
    </div><!-- /.col-lg-12 -->
</div><!-- /.row -->
</body>
</html>