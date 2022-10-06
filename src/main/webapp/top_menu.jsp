<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
$(document).ready(function(){
	$(".notifications .icon_wrap").click(function(){
	  $(this).parent().toggleClass("active");
	});
});
</script>
<link href="css/navigation.css" rel="stylesheet" type="text/css">

<div id="nav">
	

	<div class="navbar">
	    <div class="navbar_left">
	    	<div class="logo">
	        	<a href="index.do" style="text-decoration:none">Social Activity</a>
	    	</div>
	    	<div class="createGathering">
	        	<a href="create_gathering.do" style="text-decoration:none">모임 생성</a>
	    	</div>
	    	<div class="gatheringSearch">
	        	<a href="g_searchList.do" style="text-decoration:none">모임 검색</a>
	    	</div>
	    	<div class="activitySearch">
	        	<a href="a_searchList.do" style="text-decoration:none">액티비티 검색</a>
	    	</div>
	    </div>
	
	    <div class="navbar_right">
	  		<div class="login">
				<c:choose>
					<c:when test="${signedid == null}">
						<a href="login.do" style="text-decoration:none">로그인</a>
						<a href="signup.do" style="text-decoration:none">회원가입</a>
					</c:when>
					<c:otherwise>
						${signedid} 님 환영합니다
						<a href="pw_check.do" class="nav_menu" style="text-decoration:none">마이페이지</a>
						<a href="logout.do" class="nav_menu" style="text-decoration:none">로그아웃</a>
					</c:otherwise>
				</c:choose>
			</div>
			
			<c:if test="${signedid != null }">
				<div class="notifications">
	    		<div class="icon_wrap"><i class="far fa-bell"></i></div>
	        		<div class="notification_dd">
	        			<ul class="notification_ul">
	        				<c:forEach var="notificationVo" items="${notificationVos }">
		                		<li class="noti">
			                    	<div class="notify_data">
			                    		${notificationVo.content }
			                    	</div>
			                    	<div class="notify_date">
			                    		<p>${notificationVo.when }</p>
			                    	</div>
		                		</li>
	        				</c:forEach>
	            	</ul>
	       		</div>
	        </div>
			</c:if>
			
	</div>
</div>
  
  

</div>