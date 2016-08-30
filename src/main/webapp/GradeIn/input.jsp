<%@page import="java.util.ArrayList"%>
<%@page import="com.server.model.Student"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="../Css/style.css" />
    <script type="text/javascript" src="../Js/jquery.js"></script>
    <!-- <script type="text/javascript" src="../Js/jquery.sorted.js"></script> -->
    <script type="text/javascript" src="../Js/bootstrap.js"></script>
    <script type="text/javascript" src="../Js/ckform.js"></script>
    <script type="text/javascript" src="../Js/common.js"></script>

 
<script type="text/javascript">
	function updateGrade() {
				var table = document.getElementById("gradeTable")
				var dataNum = table.rows.length;
				var gradeList = [];
				for(var i = 1 ; i < dataNum ; i++){
					
					var courseId = table.rows[i].cells[5].textContent;
					var studentNum = table.rows[i].cells[2].textContent;
					var grade = table.rows[i].cells[4].getElementsByTagName("input")[0].value;
					var grades = {
						"courseId":courseId,
						"studentNum":studentNum,							
						"grade":grade
					};
					gradeList.push(grades)
				}
				
				  $.ajax({
					url : "gradeIn",
					data : {
						"gradeList" : JSON.stringify(gradeList)
					},
					dataType : "json",
					/* contentType : "application/json", */
					type : 'post',
					success : function() { 
						 window.location.href = 'index';
					},
					error:function(XMLHttpRequest, textStatus, errorThrown) {
						 alert(XMLHttpRequest.status);
						 alert(XMLHttpRequest.readyState);
						 alert(textStatus);
					}
				})  
	}
	
</script>

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
</head>
<body>
<table class="form-inline definewidth m20" >    
    &nbsp;&nbsp; <button class="btn btn-primary" onclick="updateGrade()">提交</button>
</table>
<table id="gradeTable" class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>序号</th>
        <th>课程名称</th>
        <th>学号</th>
        <th>姓名</th>
        <th>成绩</th>
        <th style="display:none"></th>
    </tr>
    </thead>
        
        <c:forEach var="course" items="${requestScope.courseList}" varStatus="foo">
        <tr>
        <td>${foo.index+1 }</td>
        <td>${course.courseName }</td>
        <td>${course.studentNum }</td>
        <td>${course.studentName }</td>
        <td><input value="${course.grade }"/></td>
        <td style="display:none">${course.courseId }</td>
        
        </tr>
        </c:forEach>
</table>
</body>
</html>
