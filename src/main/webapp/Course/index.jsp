<%@page import="java.util.ArrayList"%>
<%@page import="com.server.model.Student"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="../Css/style.css" />
    <script type="text/javascript" src="../Js/jquery.js"></script>
    <script type="text/javascript" src="../Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="../Js/bootstrap.js"></script>
    <script type="text/javascript" src="../Js/ckform.js"></script>
    <script type="text/javascript" src="../Js/common.js"></script>

 

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
<form class="form-inline definewidth m20" action="searchCourse" method="get">    
    课程名称：
    <input type="text" name="str" id="str"class="abc input-default" placeholder="模糊搜索" value="${str }"/>&nbsp;&nbsp;
    
    
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; <button type="button" class="btn btn-success" id="addnew">新增课程</button>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>序号</th>
        <th>课程名称</th>
        <th>教师ＩＤ</th>
        <th>教师姓名</th>
        <th>操作</th>
    </tr>
    </thead>
        
        <c:forEach var="course" items="${requestScope.courseList}" varStatus="foo">
        <tr>
        <td>${foo.index+1 }</td>
        <td>${course.courseName }</td>
        <td>${course.userName }</td>
        <td>${course.nickName }</td>
        <td><a href="delete?str=${str }&courseId=${course.courseId }">删除</a></td>
        </tr>
        </c:forEach>
</table>
</body>
</html>
<script>
    $(function () {
		$('#addnew').click(function(){
				window.location.href="add";
		 });
    });
	function del(id)
	{
		if(confirm("确定要删除吗？"))
		{
			var url = "index.jsp";
			window.location.href=url;		
		}
	
	}
</script>