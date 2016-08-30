<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>后台管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="assets/css/main-min.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div class="header">

    <div class="dl-title">
        <!--<img src="/chinapost/Public/assets/img/top.png">-->
    </div>
<%
Object object = request.getSession().getAttribute("loginUser");
if(object==null){
	request.setAttribute("message","请先登录");
	request.getRequestDispatcher("/Public/login.jsp").forward(request,response);
	return;
}
java.util.HashMap<String, String> loginUser = (java.util.HashMap<String, String>)object;
%>
    <div class="dl-log">欢迎您，<span class="dl-log-user"><%=loginUser.get("nickName") %></span><a href="signout" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
</div>
<div class="content">
    <div class="dl-main-nav">
    
        <div class="dl-inform"><div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div></div>
        
        <ul id="J_Nav"  class="nav-list ks-clear">
        <%
        if(loginUser.get("status").toString().equals("0") || loginUser.get("status").toString().equals("1")){
        %>
            <li class="nav-item dl-selected">
            	<div class="nav-item-inner nav-home">学生业务</div>
            </li>
        <%
        }else if(loginUser.get("status").toString().equals("2")){
        %>
            <li class="nav-item dl-selected">
            	<div class="nav-item-inner nav-order">系统业务</div>
            </li>
        <%
        }
        %>

        </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
</div>
<script type="text/javascript" src="assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="assets/js/bui-min.js"></script>
<script type="text/javascript" src="assets/js/common/main-min.js"></script>
<script type="text/javascript" src="assets/js/config-min.js"></script>
<script>
    BUI.use('common/main',function(){
        var adminConf = [
	                        { 
	                        	id :'1',
	                        	homePage :'1',
	                           menu:[
	                       	          {
	                        	    	  text:'学生业务',
	                        	    	  items:[
	                        	    	         {id:'1',text:'人员管理',href:'User/index.jsp'},
		                       	    	         {id:'2',text:'课程管理',href:'Course/index.jsp'}
	                        	    	        ]
	                        	       }
	                       	        ]
	                        }
                     	];
        var studentConf = [
                        { 
                        	id :'1',
                        	homePage :'1',
                           menu:[
                       	          {
                        	    	  text:'学生业务',
                        	    	  items:[
                        	    	         {id:'1',text:'学生选课',href:'CCourse/index'},
                        	    	         {id:'2',text:'成绩查询',href:'Grade/index'}
                        	    	        ]
                        	       }
                       	        ]
                        }
                     ];
        var teacherConf = [
                        { 
                        	id :'1',
                        	homePage :'1',
                           menu:[
                       	          {
                        	    	  text:'学生业务',
                        	    	  items:[
                        	    	         {id:'1',text:'成绩录入',href:'GradeIn/index'}
                        	    	        ]
                        	       }
                       	        ]
                        }
                     ];
        var config;
        <%
        if(loginUser.get("status").toString().equals("0")){
        %>
        	config = studentConf;
        <%
        }else if(loginUser.get("status").toString().equals("1")){
        %>
        	config = teacherConf;
        <%
        }else if(loginUser.get("status").toString().equals("2")){
        %>
        	config = adminConf;
        <%
        }
        %>
        new PageUtil.MainPage({
            modulesConfig : config
        });
    });
</script>
</body>
</html>