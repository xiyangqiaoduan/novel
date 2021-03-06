<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Style-type" content="text/css" />
<title>淘TO淘小说管理后台</title>
<meta name="keywords" content="淘TO淘小说管理后台" />
<meta name="description" content="淘TO淘小说管理后台" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/yidu.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/pagination.js"></script>
</head>
<body>
<div id="wrapper">
  <div class="shadow" style="height:1px;" ></div>
  <header id="global-head" style="height:45px;">
    <div>
      <nav class="site-navigation cf">
      <a class="home" href="/">网站首页</a>
      <a href="${pageContext.request.contextPath}/admin/index">管理首页</a>
      </nav>
      <div class="hd-follow" style="width:300px;align:right" >
      <span id="checklogin">
        欢迎您回来管理员同志，辛苦啦！
        <a href="${pageContext.request.contextPath}/logout" style="color: rgb(240, 240, 240);" class="out">退出</a>
      </span>
    </div>
  </header>
    <div id="channel-header" class="clearfix">
      <div class="channel-header-wrapper">
        <nav class="channel-nav">
          <ul class="channel-nav-list">
            <li><a href="${pageContext.request.contextPath}/admin/configEdit" title="系统参数设置">系统参数设置</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/languageEdit" title="语言包设置">语言包设置</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/systemblock/blockList" title="区块管理>">区块管理</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/article/list" title="小说管理">小说管理</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/user/list" title="用户管理">用户管理</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/message/list" title="消息管理">消息管理</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/review/list" title="评论管理">评论管理</a></li>
        </ul>
      </nav>
    </div>
  </div>

<script type="text/javascript">
<!--
	$(document).ready(function() {
		clearErrorMessages = function(form) {
			clearErrorMessagesCSS(form);
			clearServerErrorMessages();
		};
	});

	function clearServerErrorMessages() {
		$("#ErrorList").text("");
	}
//-->
</script>
