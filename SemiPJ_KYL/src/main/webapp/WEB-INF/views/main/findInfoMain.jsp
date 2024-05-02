<jsp:include page="/WEB-INF/views/common/common_css_firstline.jsp"/> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디/비밀번호 찾기</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>

<jsp:include page="/WEB-INF/views/common/common_css2.jsp"/>
<!-- findInfo 영역 style -->
<link href="<%=request.getContextPath()%>/resource/css/findinfoMain.css" rel="stylesheet">
</head>
<body>
	<div class="findinfoWrap">
        <div class="findinfo-inner">
            <div class="content">
                <div class="pagename">
                    아이디/비밀번호 찾기
                </div>
                <div class="sitemove">
                    <div class="decobtn">
                        <div role=”button” class="btn findid">
                            <img src="${pageContext.request.contextPath}/resource/img/아이디 찾기.png" alt="아이디찾기" class="findidImg" width="90px" height="90px">
                            <br>아이디찾기
                        </div>
                    </div>
                    <div class="decobtn">
                        <div role=”button” class="btn findpassword" >
                            <img src="${pageContext.request.contextPath}/resource/img/비밀번호 찾기.png" alt="비밀번호 찾기" class="findpasswordImg" width="90px" height="90px">
                            <br>비밀번호 찾기
                        </div>
                    </div>
                </div>    
                <div class="mainbtn">
                    <button type="button" class="backtomain" style="cursor: pointer;"> 
                        <img src="/IMG/뒤로가기아이콘.png" alt="화살표" class="back" width="30px" height="30px">메인으로 돌아가기 
                    </button>
                </div>
            </div>
        </div>
    </div>
</body>

<script>
$(loadedHandler)
function loadedHandler() {
	$(".btn.findid").on("click", btnfindidClickHandler);
	$(".btn.findpassword").on("click", btnfindpasswordClickHandler);
}

function btnfindidClickHandler() {
	location.href="${pageContext.request.contextPath}/findid";
}

function btnfindpasswordClickHandler() {
	location.href="${pageContext.request.contextPath}/findpassword";
}
</script>
</html>