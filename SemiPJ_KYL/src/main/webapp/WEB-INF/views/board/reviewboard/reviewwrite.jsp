<jsp:include page="/WEB-INF/views/common/common_css_firstline.jsp"/> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기::리뷰</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<jsp:include page="/WEB-INF/views/common/common_function.jsp" />

<jsp:include page="/WEB-INF/views/common/common_css1.jsp" />
<!-- reviewboardwrite section 영역 style -->
<link href="<%=request.getContextPath()%>/resource/css/boardwrite.css"
	rel="stylesheet">

<!-- CKEditor5 스크립트  -->
<script
	src="https://cdn.ckeditor.com/ckeditor5/41.3.1/classic/ckeditor.js"></script>
</head>
<body>
	<div class="wrap">
		<div class="wrap-header">
			<%@include file="/WEB-INF/views/common/header.jsp"%>
		</div>
		<div class="wrap-main">
			<section>
				<div class="title1">리뷰 작성</div>
				<hr class="line1">
				<hr class="gap1">
				<form id="frm-reviewwrite">
					<div class="titlewrite">
						<input type="text" name="subject" placeholder="제목을 입력해 주세요."
							required>
					</div>
					<div id="editor" style="display: none;"></div>
					<input type="hidden" name="editor">
					<div class="btnfilearea">
						<button type="button" class="btn file">파일추가</button>
					</div>
					<div class="submit area">
						<button type="button" class="btn write">글쓰기</button>
					</div>
				</form>
			</section>
			<%@include file="/WEB-INF/views/common/aside.jsp"%>
		</div>
	</div>
	<script>
$(loadedHandler);
function loadedHandler() {
	$(".btn.file").on("click", btnFileClickHandler);
	$(".btn.write").on("click", btnWriteClickHandler);
}

let newEditor;

// CKEditor5 코드
ClassicEditor
  .create( document.querySelector( '#editor' ) , {
	  ckfinder: {
// 			uploadUrl: 'http://localhost:8080/admin/test/imageUpload'
		}
  })
	.then( editor => {
	newEditor = editor;
	} )
  .catch( error => {
      console.error( error );
  } );
  
function btnFileClickHandler() {
	var htmlVal = `<div class="after button"><input type="file" class="btn select-file" name="uploadfile" required><button type="button" class="btn file-cancle">취소</button></div>`;
	$(this).parent().after(htmlVal);
	
	// 중복 등록 방지
	$(".btn.select-file").off("click");
	$(".btn.file-cancle").on("click", btnFileCancleClickHandler);
}

function btnFileCancleClickHandler() {
	$(this).parent().remove();
}

function btnWriteClickHandler() {
	// Login페이지로 이동
	if(checkLogin("로그인 이후 글쓰기가 가능합니다. \n로그인페이지로 이동하시겠습니까?", "write")) {
		return;
	}
	
	if($("[name=subject]").val().trim().length == 0){
		   alert("제목을 작성해주세요.");
		   return;
	    }
	console.log("입력한내용: ");
	console.log(newEditor.getData());
	$("[name=editor]").val(newEditor.getData());
	
	var frm = document.getElementById("frm-reviewwrite");
	frm.method="post";  
	frm.action = "${pageContext.request.contextPath}/review/write";
	frm.enctype="multipart/form-data"; //form 태그 내부에 input type="file" 이 있다면
	frm.submit();	
}
</script>
</body>
</html>