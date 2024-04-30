<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<script>
function checkLogin(msg, prePage) {
	//Login 페이지로 이동
	var accLogin = "${aceptLogin }";
	return false;
}

function ajaxErrorHandler (request, status, error){
	alert("code: " + request.status + "\n" + "message: "
			+ request.responseText + "\n"
			+ "error: " + error);
}
</script>