<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link href="css/dropdown.css" rel="stylesheet" type="text/css">

<div id="nav">
	

	<div class="navbar">
	    <div class="navbar_left">
	    	<div class="logo">
	        	<a href="index.do">Social Activity</a>
	    	</div>
	    	<div class="createGathering">
	        	<a href="g_searchList.do">모임 생성</a>
	    	</div>
	    	<div class="gatheringSearch">
	        	<a href="g_searchList.do">모임 검색</a>
	    	</div>
	    	<div class="activitySearch">
	        	<a href="a_searchList.do">액티비티 검색</a>
	    	</div>
	    </div>
	
	    <div class="navbar_right">
	  		<div class="login">
				<c:choose>
					<c:when test="${signedid == null}">
						<a href="login.do">로그인</a>
						<a href="signup.do">회원가입</a>
					</c:when>
					<c:otherwise>
						${signedid} 님 환영합니다
						<a href="pw_check.do" class="nav_menu">마이페이지</a>
						<a href="logout.do" class="nav_menu">로그아웃</a>
					</c:otherwise>
				</c:choose>
			</div>
			
			<div class="notifications">
	    		<div class="icon_wrap"><i class="far fa-bell"></i></div>
	        		<div class="notification_dd">
	        			<ul class="notification_ul">
	                		<li class="noti">
		                    	<div class="notify_data">
		                    		루피 액티비티 가입이 완료되었습니다
		                    	</div>
		                    	<div class="notify_date">
		                    		<p>2분 전</p>
		                    	</div>
		                    	<div class="notify_status">
		                        	<p>안 읽음</p>  
		                    	</div>
	                		</li>  
	                		<li class="noti">
	                    		<div class="notify_data">
	                    			관광 모임 가입이 완료되었습니다
	                    		</div>
		                    	<div class="notify_date">
		                    		<p>4분 전</p>
		                    	</div>
	                    		<div class="notify_status">
	                        		<p>안 읽음</p>  
	                    		</div>
	                		</li> 
	                		<li class="noti">
	                    		<div class="notify_data">
	                    			오징어게임 모임에서 탈퇴되었습니다
	                    		</div>
		                    	<div class="notify_date">
		                    		<p>5분 전</p>
		                    	</div>
	                    		<div class="notify_status">
	                        		<p>읽음</p>  
	                    		</div>
	                		</li>  
	            	</ul>
	       		</div>
	        </div>
	</div>
</div>
  
  

</div>