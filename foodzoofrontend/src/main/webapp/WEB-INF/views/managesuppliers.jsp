<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet"
		href="http://cdn.bootcss.com/animate.css/3.5.1/animate.min.css">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	<c:url var="css" value="/resources/css"></c:url>
	<c:url var="js" value="/resources/js"></c:url>
	<c:url var="images" value="/resources/images"></c:url>
<style type="text/css">
.err {
	color: red;
}
  #piechart1,#piechart2
    {
      padding-top:50px;
      padding-left:50px;
      padding-right:50px;
       padding-bottom:50px; 
    }
   
</style>
<script type="text/javascript">
	// Load google charts
	google.charts.load('current', {
		'packages' : [ 'corechart' ]
	});
	google.charts.setOnLoadCallback(drawChart);

	// Draw the chart and set the chart values
	function drawChart() {
		var data1 = google.visualization.arrayToDataTable([
				[ 'SUPPLIERS', 'NUMBER' ], [ 'southindian', 8 ],
				[ 'northindian', 2 ], [ 'chinese', 4 ], [ 'thai', 2 ],
				[ 'dessert', 8 ] ]);

		var data2 = google.visualization.arrayToDataTable([
				[ 'CATEGORIES', 'NUMBER' ], [ 'southindian', 8 ],
				[ 'northindian', 2 ], [ 'chinese', 4 ], [ 'thai', 2 ],
				[ 'dessert', 8 ] ]);
		// Optional; add a title and set the width and height of the chart
		var options1 = {
			'title' : 'Suppliers Names',
			'width' : 550,
			'height' : 400
		};
		var options2 = {
			'title' : 'Suppliers Categories',
			'width' : 550,
			'height' : 400
		};
		// Display the chart inside the <div> element with id="piechart"
		var chart1 = new google.visualization.PieChart(document
				.getElementById('piechart1'));
		var chart2 = new google.visualization.PieChart(document
				.getElementById('piechart2'));
		chart1.draw(data1, options1);
		chart2.draw(data2, options2);
	}
</script>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
    <div class="container-fluid">
	<div class="row" style="background-color:#DCDCDC">
		<div class="col-sm-6" id="piechart1"></div>
		<div class="col-sm-6" id="piechart2"></div>
	</div>
	</div>
	<div class="container-fluid">
	<button type="submit" class="btn btn-success" value="AddSupplier" data-toggle="modal" data-target="#supplierModal" style="margin-top:20px; margin-bottom:20px;">Add Supplier</button>
	
	
	
	<div class="modal fade" id="supplierModal" role="dialog">
					<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
								     <h4 class="modal-title">Supplier Details</h4>
								  </div>  
								  <div class="modal-body">
								  <form id="supplier_form" class="form-group" action="savesupplier" method="post">
								      <input class="form-control" type="text" name="supplier_id" placeholder="Enter Supplier ID" id="supplier_id" required/><br>
								  	  <input class="form-control" type="text" name="supplier_name" placeholder="Enter Supplier Name" id="supplier_name" required/><br>
								      <input class="form-control" type="text" name="supplier_description" placeholder="Enter Supplier Description" id="supplier_description" required/><br>
								      <input type="submit" class="btn btn-success" id="supplier_button" value="Save Supplier"/>
								     
								  </form>
								  </div>
								<div class="modal-footer">
       							 </div>
								</div>
							</div>
					</div>	
	
	</div>
	<div class="container-fluid">
		<table class="table table-striped">
			<thead>
				<tr>
					<td>Supplier Id</td>
					<td>Supplier Name</td>
					<td>Supplier Description</td>
					<td></td>
					<td></td>
				</tr>
			</thead>
			<c:forEach var="x" items="${list}">
				<tr>
					<td id="01"><c:out value="${x.supplier_id}"></c:out></td>
					<td id="02"><c:out value="${x.supplier_name}"></c:out></td>
					<td id="03"><c:out value="${x.supplier_description}"></c:out></td>
					<td><a href="#supplierModal" data-toggle="modal"><i
							class="fa fa-pencil" aria-hidden="true"
							onClick="editFunction('${x.supplier_id}','${x.supplier_name}','${x.supplier_description}')"></i></a></td>
					<td><a href="supplierdelete/${x.supplier_id}"><i
							class="fa fa-trash-o" aria-hidden="true" id=""></i></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
<jsp:include page="footer.jsp"></jsp:include>
</body>
<script>
	$(document).ready(function() {

		/* /
		 $("#category_button").click(function()
		 {
		 $("#one").show();
		 $("#two").show();
		 $("#three").show();
		 //$("#category_button1").toggle();
		
		 }); */

	});
	/* $('a[href="#categoryedit"]').click(function() {
		$("#category_button").attr("value", "update");
		$("#category_form").attr("action", "categoryupdate");
		

	}); */
	var editFunction = function(id, name, supplier){
		
		document.getElementById('supplier_button').setAttribute("value","update");
		document.getElementById('supplier_form').setAttribute("action","supplierupdate");
		document.getElementById('supplier_id').setAttribute('value',id);
		document.getElementById('supplier_id').setAttribute("disabled","true");
		document.getElementById('supplier_name').setAttribute('value',name);
		document.getElementById('supplier_description').setAttribute('value',supplier);
		
	}
</script>
</html>