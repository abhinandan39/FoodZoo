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
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="http://cdn.bootcss.com/animate.css/3.5.1/animate.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<c:url var="css" value="/resources/css"></c:url>
<c:url var="js" value="/resources/js"></c:url>
<c:url var="images" value="/resources/images"></c:url>
<style type="text/css">
.err {
	color: red;
}

.backgroundimage {
	background-image: url('${images}/food1.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	opacity: 2.0;
}

#displaymessage {
	text-align: center;
	padding: 10px;
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
				[ 'CATEGORIES', 'NUMBER' ], [ 'southindian', 8 ],
				[ 'northindian', 2 ], [ 'chinese', 4 ], [ 'thai', 2 ],
				[ 'dessert', 8 ] ]);

		var data2 = google.visualization.arrayToDataTable([
				[ 'CATEGORIES USER', 'NUMBER' ], [ 'southindian', 8 ],
				[ 'northindian', 2 ], [ 'chinese', 4 ], [ 'thai', 2 ],
				[ 'dessert', 8 ] ]);
		// Optional; add a title and set the width and height of the chart
		var options1 = {
			'title' : 'Categories Names',
			'width' : 550,
			'height' : 400
		};
		var options2 = {
			'title' : 'Categories Users',
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
	<br>

	<div class="row">
		<div class="col-sm-6" id="piechart1"></div>
		<div class="col-sm-6" id="piechart2"></div>
	</div>
	<center>
		<table class="table" style="width: 90%">
			<thead style="background-color: #d0e1e1">
				<tr>
					<td>Category Id</td>
					<td>Category Name</td>
					<td>Category Description</td>
					<td></td>
					<td></td>
				</tr>
			</thead>
			<c:forEach var="x" items="${list}">
				<tr>
					<td id="01"><c:out value="${x.category_id}"></c:out></td>
					<td id="02"><c:out value="${x.category_name}"></c:out></td>
					<td id="03"><c:out value="${x.category_description}"></c:out></td>
					<td><a href="#categoryedit" class=""><i
							class="fa fa-pencil" aria-hidden="true"
							onClick="editFunction('${x.category_id}','${x.category_name}','${x.category_description}')"></i></a></td>
					<td><a href="categorydelete/${x.category_id}"><i
							class="fa fa-trash-o" aria-hidden="true" id=""></i></a></td>
				</tr>
			</c:forEach>
		</table>
	</center>
	<div class="container">
		<form:form id="category_form" action="savecategory">


			<div class="row">
				<div class="col-sm-4">
					<form:input id="one" path="category_id" class="form-control"></form:input>
				</div>
				<div class="col-sm-4">
					<form:input id="two" path="category_name" class="form-control"></form:input>
				</div>
				<div class="col-sm-4">
					
					<form:input id="three" path="category_description"
						class="form-control"></form:input>
				</div>

			</div>

			<div class="row">
				<div class="col-sm-4"></div>
				<div class="col-sm-4">
					<center>
						<input type="submit" class="btn btn-success" value="save"
							id="category_button"
							style="margin-top: 10px; margin-bottom: 10px;"></input>
					</center>

				</div>
				<div class="col-sm-4"></div>
			</div>
		</form:form>

	</div>
	<%-- <div class="container">
<div class="row">
<div class="col-sm-4"></div>
<div class="col-sm-4">
<center>
<input type="submit" class="btn btn-success" value="save" id="category_button1" style="margin-top:10px;margin-bottom:10px;"/></div>
</center>
</div>
<div class="col-sm-4">
</div> --%>

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
	var editFunction = function(id, name, category){
		
		document.getElementById('category_button').setAttribute("value","update");
		document.getElementById('category_form').setAttribute("action","categoryupdate");
		document.getElementById('one').setAttribute('value',id);
		document.getElementById('two').setAttribute('value',name);
		document.getElementById('three').setAttribute('value',category);
		
	}
</script>
</html>