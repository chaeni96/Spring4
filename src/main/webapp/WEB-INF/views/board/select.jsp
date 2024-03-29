
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="../temp/boot_head.jsp"></c:import>
<style type="text/css">
	.more {
		cursor: pointer;
	}
</style>
<title>Insert title here</title>
</head>
<body>
<c:import url="../temp/boot_nav.jsp"></c:import>
	
	<div>
	<div class="container-fluid col-md-8">
	<h1>${board} Select Homepage</h1>
		<h3>NUM : ${dto.num}</h3>
		<h3>Title : ${dto.title}</h3>
		<div> ${dto.contents}</div>
		<h3>WRITE : ${dto.writer}</h3>
		<h3>REGDATE : ${dto.regDate}</h3>
		<h3>HITS : ${dto.hits}</h3>
		
		<c:forEach items="${dto.files}" var="f">
			<div>
				<a href="./down?fileName=${f.fileName}">${f.oriName}</a>		
			</div>
		</c:forEach>
		
		
		<hr>
		
		<!-- comment list -->
		<div id="commentList" data-board-num="${dto.num}">
		
		
		</div>
		
		
			<div>
				<div class="mb-3">
				<label for="writer" class="form-label">Writer</label> 
				<input type="text" class="form-control" name="writer" id="writer" value="${member.id}" placeholder="Enter Writer" readonly="readonly">
			</div>
		
			<div class="mb-3">
				<label for="contents" class="form-label">Contents</label>
				<textarea class="form-control" id="contents" name="contents"  cols="" rows="6" placeholder="Input some text."></textarea>
			</div>
		
			<div align="left" class="mt-3">
				<button type="button" id="comment" class="btn btn-primary">Write</button>
			</div>
			
			</div>
		
		<hr>
		
		
		<!-- 게시글 삭제 page 이동 -->
		<c:if test="${not empty member and member.id eq dto.writer}">
		<a href="./update?num=${dto.num}" class="btn btn-primary">Update</a>
		<a href="./delete?num=${dto.num}" class="btn btn-danger">Delete</a>
		</c:if>
		
		<c:if test="${board ne 'notice'}">
		<a href="./reply?num=${dto.num}" class="btn btn-warning">Reply</a>
		</c:if>
	
	</div>
	
	</div>
	<script type="text/javascript">
	
		getCommentList(1);
		let content = '';
		//update
		$("#commentList").on("click", ".commentUpdate", function() {
			console.log('update');
			let num = $(this).attr("data-comment-update");
			content= $("#content"+num).text().trim();
			$("#content"+num).children().css('display','none');
			let ta = '<textarea class="form-control" cols=""  name="contents" id="contents" rows="6">';
			ta = ta+content.trim() +'</textarea>';
			ta = ta + '<button type="button" id="" class="btn btn-primary update">update</button>';
			ta = ta + '<button type="button" id="" class="btn btn-danger cancel">Cancel</button>';
			 $("#content"+num).append(ta);
			
		});
		
		//update
		$("#commentList").on('click', '.update', function() {
			let contents = $(this).prev().val();
			let cn = $(this).parent().prev().text().trim();
			let selector=$(this);
			$.ajax({
				type : "POST",
				url : "./commentUpdate",
				data : {
					commentNum:cn,
					contents:contents
				},
				success : function(result) {
					if(result.trim()>0){
						alert('수정 성공');
						selector.parent().children('div').text(contents);
						selector.parent().children('div').css('display', 'block');
						selector.parent().children('textarea').remove();
						selector.parent().children('button').remove();
					}else{
						alert('수정 실패');
					}
				},
				error: function() {
					alert('수정 실패');
				}
			});
		})
		
		//cancel
		$("#commentList").on('click', ".cancel", function() {
			console.log(content);
			$(this).parent().children('div').css('display', 'block');
			$(this).parent().children('textarea').remove();
			$(this).parent().children('button').remove();
		})
		
		
		//Del click event
		$("#commentList").on("click", ".commentDel", function() {
			let commentNum = $(this).attr("data-comment-del");
			console.log(commentNum);
			$.ajax({
				type: "POST",
				url : "./commentDel",
				data : {
					commentNum:commentNum
				},
				success: function(result) {
					result = result.trim();
					
					if(result>0){
						alert("삭제 성공");
						getCommentList(1);
					}else{
						alert("삭제 실패");
					}
					
				},
				error: function() {
					alert('삭제 실패');
				}
				
			});
		});
		
		$("#commentList").on("click", ".more", function() {
			//data-comment-pn 값을 출력
			
			let pn = $(this).attr("data-comment-pn")
			getCommentList(pn);
		});
		
		function getCommentList(pageNumber) {
			let num = $("#commentList").attr("data-board-num");
			
			$.ajax({
				type : "GET",
				url : "./getCommentList",
				data : {
					num:num, 
					pn : pageNumber
					}, //parameter명:변수명
				success : function(result) {
					result = result.trim();
					$("#commentList").html(result);
				},
				error : function(xhr, status, error) {
					console.log(error);
				}
			})
		}
	
	
		$('#comment').click(function () {
			//작성자, 내용 콘솔 출력	
			let writer =$("#writer").val();
			let contents = $("#contents").val();
			
			$.post('./comment', {num: '${dto.num}', writer:writer, contents:contents}, function(result) {
				console.log(result.trim());
				
				$("#contents").val('');
				getCommentList();
			} );
		});
		
	</script>

</body>
</html>