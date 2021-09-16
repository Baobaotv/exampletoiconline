<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="ADMIN PAGE" /></title>

<!-- bootstrap & fontawesome -->

<link rel="stylesheet"
	href="<c:url value='/template/admin/assets/css/bootstrap.min.css'/>" />
<link rel="stylesheet"
	href="<c:url value='/template/admin/assets/font-awesome/4.2.0/css/font-awesome.min.css'/>" />
<!-- text fonts -->
<link rel="stylesheet"
	href="<c:url value='/template/admin/assets/fonts/fonts.googleapis.com.css'/>" />

<!-- ace styles -->
<link rel="stylesheet"
	href="<c:url value='/template/admin/assets/css/ace.min.css'/>"
	class="ace-main-stylesheet" id="main-ace-style" />

<!-- ace settings handler -->
<script
	src="<c:url value='/template/admin/assets/js/ace-extra.min.js'/>"></script>
<dec:head></dec:head>
</head>
<body class="no-skin">

	<%@include file="/common/admin/header.jsp"%>

	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>
		<%@include file="/common/admin/menu.jsp"%>
		<div class="main-content">
			<div class="main-content-inner">
				<dec:body></dec:body>
			</div>
		</div>
		<%@include file="/common/admin/footer.jsp"%>

		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>



	<!-- /.main-container -->

	<script src="<c:url value='/template/admin/assets/js/jquery.2.1.1.min.js'/>"></script>

	<script type="text/javascript">
		window.jQuery
				|| document.write("<script src='<c:url value='/template/admin/assets/js/jquery.min.js'/>'>"
						+ "<"+"/script>");
	</script>


	<script type="text/javascript">
		if ('ontouchstart' in document.documentElement)
			document
					.write("<script src='<c:url value='/template/admin/assets/js/jquery.mobile.custom.min.js'/>'>"
							+ "<"+"/script>");
	</script>
	<script
		src="<c:url value='/template/admin/assets/js/bootstrap.min.js'/>"></script>

	<script
		src="<c:url value='/template/admin/assets/js/jquery-ui.custom.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.ui.touch-punch.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.easypiechart.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.sparkline.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.flot.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.flot.pie.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.flot.resize.min.js'/>"></script>

	<!-- ace scripts -->
	<script
		src="<c:url value='/template/admin/assets/js/ace-elements.min.js'/>"></script>
	<script src="<c:url value='/template/admin/assets/js/ace.min.js'/>"></script>
	
</body>
</html>