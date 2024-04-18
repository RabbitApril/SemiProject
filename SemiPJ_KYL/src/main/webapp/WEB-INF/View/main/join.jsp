<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
<div class="joinbox">
        <div class="joinImg">
            어쨌든 이미지 들어갈 곳 
        </div>
        <div>
            <form class="memberjoin">
                <div>
                    <label>아이디</label>
                    <input type="text" name="id">
                    <button type="button" class="btn checkid">중복확인</button>
                </div>
                <div>
                    <label>닉네임</label>
                    <input type="text" name="nickname">
                    <button type="button" class="btn checknickname">중복확인</button>
                </div>
                <div>
                    <label>비밀번호</label>
                    <input type="password" name="pwd">
                </div>
                <div>
                    <label>비밀번호 확인</label>
                    <input type="password" name="pwdcheck">
                </div>
                <div>
                    <label>이메일</label>
                    <input type="email" name="email">
                    <button type="button" class="btn checkemail">중복확인</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>