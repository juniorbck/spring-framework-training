<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Gradle + Spring MVC</title>

<!-- Latest compiled and minified CSS -->
<spring:url value="/static/css/app.css"                                             var="coreCss" />
<spring:url value="/webjars/bootstrap/3.3.6/css/bootstrap.min.css"                  var="bootstrapCss" />
<spring:url value="/webjars/jquery-ui-themes/1.11.4/south-street/jquery-ui.min.css" var="jqueryCssTheme" />
<spring:url value="/webjars/toastr/2.1.2/build/toastr.min.css"                      var="toastrCss" />


<link href="${coreCss}" rel="stylesheet" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${jqueryCssTheme}" rel="stylesheet" />
<link href="${toastrCss}" rel="stylesheet" />

</head>

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Project Name</a>
		</div>
	</div>
</nav>

<div class="jumbotron">
	<div class="container">
		<h1><spring:message code="msg.header.title"></spring:message></h1>
		<p>
			<c:if test="${not empty newMsg}">
				Hello ${newMsg}
			</c:if>

			<c:if test="${empty newMsg}">
				Welcome Welcome!
			</c:if>			
		</p>
		<p>
			<a id="btn1" class="btn btn-primary btn-lg" href="#" role="button">JQuery is working</a>
		</p>
	</div>
</div>

<div class="container">

	<div class="row">
		<div class="col-md-4">
			<h2>Heading</h2>
			<p><input id="text1" type="text" /></p>
			<p>
				<a id="btn2" class="btn btn-default" href="#" role="button">Spring By Path Variable</a>
			</p>
		</div>
		<div class="col-md-4">
			<h2>Heading</h2>
			<p><input id="text2" type="text" /></p>
			<p>
				<a id="btn3" class="btn btn-default" href="#" role="button">Spring By Request Variable</a>
			</p>
		</div>
		<div class="col-md-4">
			<h2>Heading</h2>
			<p>ABC</p>
			<p>
				<a id="btn4" class="btn btn-default" href="#" role="button">Toastr and moment libraries</a>
			</p>
		</div>
	</div>


	<hr>
	<footer>
		<p>&copy; <spring:message code="msg.loging.footer.company"/> 2016</p>
	</footer>
</div>

<spring:url value="/static/js/common/application.js"             var="core_JS" />
<spring:url value="/webjars/jquery/2.2.4/dist/jquery.min.js"     var="jquery_JS" />
<spring:url value="/webjars/jquery-ui/1.11.4/jquery-ui.min.js"   var="jqueryUI_JS" />
<spring:url value="/webjars/bootstrap/3.3.6/js/bootstrap.min.js" var="bootstrap_JS" />
<spring:url value="/webjars/moment/2.14.1/min/moment.min.js"     var="moment_JS" />
<spring:url value="/webjars/toastr/2.1.2/build/toastr.min.js"    var="toastr_JS" />

<script src="${core_JS}"></script>
<script src="${jquery_JS}"></script>
<script src="${jqueryUI_JS}"></script>
<script src="${bootstrap_JS}"></script>
<script src="${moment_JS}"></script>
<script src="${toastr_JS}"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#btn1").click(function(){
			alert( "JQuery is working." );			
		});
		
		$("#btn2").click(function(){
			var text = $("#text1").val();			
			window.location.href = "${pageContext.request.contextPath}/showMessage/"+text;
		});
		
		$("#btn3").click(function(){
			var text = $("#text2").val();
			window.location.href = "${pageContext.request.contextPath}/showMessage?msg="+text;
		});
		
		$("#btn4").click(function(){
			var testDate = '02/12/2016';
			var formatString = moment(testDate).format('MM/DD/YYYY');
			toastr.success('Success messages: '+formatString);
			
			testDate = new Date();
			var formatString = moment(testDate).format('MM/DD/YYYY');
			toastr.info('Success messages: '+formatString);
		});
		
	});


</script>


</body>
</html>