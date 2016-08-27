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
String loginUser = (String)request.getSession().getAttribute("loginUser");
 if(loginUser==null)loginUser="车健"; 
if(loginUser==null){
	request.setAttribute("message","请先登录");
	request.getRequestDispatcher("/Public/login.jsp").forward(request,response);
}
%>
    <div class="dl-log">欢迎您，<span class="dl-log-user"><%=loginUser %></span><a href="signout" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
</div>
<div class="content">
    <div class="dl-main-nav">
    
        <div class="dl-inform"><div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div></div>
        
        <ul id="J_Nav"  class="nav-list ks-clear">
            <li class="nav-item dl-selected">
            	<div class="nav-item-inner nav-home">系统管理</div>
            </li>		
            <li class="nav-item dl-selected">
            	<div class="nav-item-inner nav-order">业务管理</div>
            </li>
            <li class="nav-item dl-selected">
            	<div class="nav-item-inner nav-home">学生业务</div>
            </li>
            <li class="nav-item dl-selected">
            	<div class="nav-item-inner nav-order">系统业务</div>
            </li>

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
        var config = [
                        { 
                        	id :'1',
                           menu:[
                       	          {
                       	        	  text:'系统管理',
                       	        	  items:[
                       	        	          {id:'1',text:'机构管理',href:'Node/index.jsp'},
                       	        	          {id:'2',text:'角色管理',href:'Role/index.jsp'},
                       	        	          {id:'3',text:'用户管理',href:'User/index.jsp'},
                       	        	          {id:'4',text:'菜单管理',href:'Menu/index.jsp'}
                       	        	        ]
                       	          }
                       	        ]
                        },
                        {
                        	id:'2',
                        	homePage : '1',
                        	menu:[
                        	       {
                        	    	  text:'业务管理',
                        	    	  items:[
                        	    	         {id:'1',text:'查询业务',href:'Node/index.jsp'}
                        	    	        ]
                        	       }
                        	     ]
                        },
                        {
                        	id:'3',
                        	homePage : '1',
                        	menu:[
                        	       {
                        	    	  text:'学生业务',
                        	    	  items:[
                        	    	         {id:'1',text:'查询业务',href:'Node/index.jsp'}
                        	    	        ]
                        	       }
                        	     ]
                        },
                        {
                        	id:'4',
                        	homePage : '1',
                        	menu:[
                        	       {
                        	    	  text:'系统业务',
                        	    	  items:[
                        	    	         {id:'1',text:'人员管理',href:'User/index.jsp'},
                        	    	         {id:'2',text:'课程管理',href:'Course/index.jsp'}
                        	    	        ]
                        	       }
                        	     ]
                        }
                     ];
        new PageUtil.MainPage({
            modulesConfig : config
        });
    });
</script>
</body>
</html>