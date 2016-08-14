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
<form class="form-inline definewidth m20" action="searchUser" method="get">    
    用户名称：
    <input type="text" name="str" id="str"class="abc input-default" placeholder="模糊搜索" value="">&nbsp;&nbsp;
    <input type="radio" name="status" value="0" checked/> 学生
        <input type="radio" name="status" value="1"/> 教师
        <input type="radio" name="status" value="2"/> 管理员  
        <input type="radio" name="status" value="3"/> 所有  
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; <button type="button" class="btn btn-success" id="addnew">新增用户</button>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>用户id</th>
        <th>用户名称</th>
        <th>真实姓名</th>
        <th>最后登录时间</th>
        <th>操作</th>
    </tr>
    </thead>
    
	     <tr>
            <td>2</td>
            <td>admin</td>
            <td>管理员</td>
            <td></td>
            <td>
                <a href="edit.jsp">编辑</a>                
            </td>
        </tr>	
        
        <c:forEach var="user" items="${requestScope.userList}" varStatus="foo">
        <tr>
        <td>${foo.index }</td>
        <td>${user.userName }</td>
        <td>${user.sex }</td>
        <td>${user.major }</td>
        <td><a href="edit.jsp">编辑</a></td>
        </tr>
        </c:forEach>
        <%-- <%
        ArrayList<Student> list = (ArrayList<Student>)request.getAttribute("userList");
        if(list!=null){
        for(Student student:list){
        	%>
        	<tr>
        	<td>1</td>
        	<td>2</td>
        	<td>3</td>
        	<td>4</td>
        	</tr>
        	<% 
        }
        }
        %> --%>
</table>
</body>
</html>
<script>
    $(function () {
        

		$('#addnew').click(function(){

				window.location.href="add.jsp";
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