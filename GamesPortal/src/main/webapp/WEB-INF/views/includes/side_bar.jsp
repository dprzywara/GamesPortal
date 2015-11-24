<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>				
<c:url value="" var="currentUrl"></c:url>
				
				<sec:authorize access="hasRole('ROLE_USER')">
				<div class="col-sm-3 col-md-2 sidebar">
					<h3>User Panel</h3>
					<ul class="nav nav-sidebar">
						<li><a href="${contextPath}/user/selectUser/all"><spring:message code="sidebar.playQuiz" /></a></li>
						<li><a href="${contextPath}/messages"><spring:message code="sidebar.messages" /></a></li>
						<li><a href="${contextPath}/editaccount"><spring:message code="sidebar.editAccount" /></a></li>
						<li><a href="${contextPath}/editpassword"><spring:message code="sidebar.changePassword" /></a></li>
					</ul>
				</div>
				</sec:authorize>
				
<%-- 				<sec:authorize access="hasRole('ROLE_ADMIN')"> --%>
				<div class="col-xs-3 col-md-2 sidebar">
						<h3><spring:message code="admin.title" /></h3>
						<ul class="nav nav-sidebar">
						<li><a href="${contextPath}/admin/users"><spring:message code="sidebar.users" /></a></li>
						<li><a href="${contextPath}/admin/categories"><spring:message code="sidebar.categories" /></a></li>
						<li><a href="${contextPath}/admin/questions"><spring:message code="sidebar.questions" /></a></li>
						<li><a href="${contextPath}/admin/quizes"><spring:message code="sidebar.quizes" /></a></li>
						<li><a href="${contextPath}/admin/games"><spring:message code="sidebar.games" /></a></li>
						</ul>
						
					</div>
<%-- 				</sec:authorize> --%>
				
				