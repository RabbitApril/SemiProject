<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<%
    String memId = "";
    String memPwd = request.getParameter("memPwd");
    String saveId = request.getParameter("saveId");
 
    if (saveId != null && saveId.equals("true")) {
        Cookie cookie = new Cookie("memId", memId);
        cookie.setMaxAge(60 * 60 * 24 * 7);
        response.addCookie(cookie);
    }
%>

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

<!-- 	login check -->

String check = request.getParameter("check");
String id = request.getParameter("id");
String pw = request.getParameter("pw");

if(id.equals("test")&&pw.equals("1234")){
	if(check !=null && check.equals("remember")){
		Cookie remember = new Cookie("printId","test");
		response.addCookie(remember);
	}else{
		Cookie remember = new Cookie("printId","test");
		remember.setMaxAge(0);
		response.addCookie(remember);
	}
}
response.sendRedirect("exam3_login.jsp");
</script>