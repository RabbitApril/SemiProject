<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
	<div class="findIdbox">
        <form id="frm-findId">
            <div>
                <label>닉네임</label>
                <input type="text" name="nick">
            </div>
            <div>
                <label>이메일</label>
                <input type="email" name="email">
            </div>
            <div>
                <input type = "button" value = "아이디 찾기" class = "btn submit">
            </div>
        </form>
    </div>
</body>
</html>