<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="/WEB-INF/views/common/include.jsp"%>
<!DOCTYPE html >
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Amaze UI Admin index Examples</title>
    
    
   <meta name="description" content="这是一个 index 页面">
  <meta name="keywords" content="index">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp">
  <link rel="icon" type="image/png" href="http://amazeui.org/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="http://amazeui.org/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI">
  <link rel="stylesheet" href="${ctx }/static/amazeUI/css/amazeui.min.css" />
  <link rel="stylesheet" href="${ctx }/static/amazeUI/css/admin.css">
</head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

<header class="am-topbar am-topbar-inverse admin-header">
  <div class="am-topbar-brand">
    <strong>Amaze UI</strong> <small>后台管理模板</small>
  </div>

  <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: &#39;#topbar-collapse&#39;}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

  <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

    <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
      <li><a href="javascript:;"><span class="am-icon-envelope-o"></span> 收件箱 <span class="am-badge am-badge-warning">5</span></a></li>
      <li class="am-dropdown" data-am-dropdown="">
        <a class="am-dropdown-toggle" data-am-dropdown-toggle="" href="javascript:;">
          <span class="am-icon-users"></span> 管理员 <span class="am-icon-caret-down"></span>
        </a>
        <ul class="am-dropdown-content">
          <li><a href="http://amazeui.org/examples/admin-index.html#"><span class="am-icon-user"></span> 资料</a></li>
          <li><a href="http://amazeui.org/examples/admin-index.html#"><span class="am-icon-cog"></span> 设置</a></li>
          <li><a href="http://amazeui.org/examples/admin-index.html#"><span class="am-icon-power-off"></span> 退出</a></li>
        </ul>
      </li>
      <li class="am-hide-sm-only"><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>
    </ul>
  </div>
</header>

<div class="am-cf admin-main">
  <!-- sidebar start -->
  <div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
    <div class="am-offcanvas-bar admin-offcanvas-bar">
      <ul class="am-list admin-sidebar-list">
        <li><a href="http://amazeui.org/examples/admin-index.html"><span class="am-icon-home"></span> 首页</a></li>
        <li class="admin-parent">
          <a class="am-cf" data-am-collapse="{target: &#39;#collapse-nav&#39;}"><span class="am-icon-file"></span> 页面模块 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
          <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
            <li><a href="http://amazeui.org/examples/admin-user.html" class="am-cf"><span class="am-icon-check"></span> 个人资料<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
            <li><a href="http://amazeui.org/examples/admin-help.html"><span class="am-icon-puzzle-piece"></span> 帮助页</a></li>
            <li><a href="http://amazeui.org/examples/admin-gallery.html"><span class="am-icon-th"></span> 相册页面<span class="am-badge am-badge-secondary am-margin-right am-fr">24</span></a></li>
            <li><a href="http://amazeui.org/examples/admin-log.html"><span class="am-icon-calendar"></span> 系统日志</a></li>
            <li><a href="http://amazeui.org/examples/admin-404.html"><span class="am-icon-bug"></span> 404</a></li>
          </ul>
        </li>
        <li><a href="http://amazeui.org/examples/admin-table.html"><span class="am-icon-table"></span> 表格</a></li>
        <li><a href="http://amazeui.org/examples/admin-form.html"><span class="am-icon-pencil-square-o"></span> 表单</a></li>
        <li><a href="http://amazeui.org/examples/admin-index.html#"><span class="am-icon-sign-out"></span> 注销</a></li>
      </ul>

      <div class="am-panel am-panel-default admin-sidebar-panel">
        <div class="am-panel-bd">
          <p><span class="am-icon-bookmark"></span> 公告</p>
          <p>时光静好，与君语；细水流年，与君同。—— Amaze UI</p>
        </div>
      </div>

      <div class="am-panel am-panel-default admin-sidebar-panel">
        <div class="am-panel-bd">
          <p><span class="am-icon-tag"></span> wiki</p>
          <p>Welcome to the Amaze UI wiki!</p>
        </div>
      </div>
    </div>
  </div>
  <!-- sidebar end -->

  <!-- content start -->
  <div class="admin-content">
    <div class="admin-content-body">
      <div class="am-cf am-padding">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">首页</strong> / <small>一些常用模块</small></div>
      </div>

      <ul class="am-avg-sm-1 am-avg-md-4 am-margin am-padding am-text-center admin-content-list ">
        <li><a href="http://amazeui.org/examples/admin-index.html#" class="am-text-success"><span class="am-icon-btn am-icon-file-text"></span><br>新增页面<br>2300</a></li>
        <li><a href="http://amazeui.org/examples/admin-index.html#" class="am-text-warning"><span class="am-icon-btn am-icon-briefcase"></span><br>成交订单<br>308</a></li>
        <li><a href="http://amazeui.org/examples/admin-index.html#" class="am-text-danger"><span class="am-icon-btn am-icon-recycle"></span><br>昨日访问<br>80082</a></li>
        <li><a href="http://amazeui.org/examples/admin-index.html#" class="am-text-secondary"><span class="am-icon-btn am-icon-user-md"></span><br>在线用户<br>3000</a></li>
      </ul>
       <ul >
       <c:forEach items="${menus}" var="item">
       	<li ><a href="${ctx}/${item.url }">${item.url }</a></li>
       
       </c:forEach>
       
       </ul>
    </div>

    <footer class="admin-content-footer">
      <hr>
      <p class="am-padding-left">© 2014 AllMobilize, Inc. Licensed under MIT license.</p>
    </footer>
  </div>
  <!-- content end -->

</div>

<a href="http://amazeui.org/examples/admin-index.html#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: &#39;#admin-offcanvas&#39;}"></a>
<script src="static/amazeUI/js/jquery.min.js"></script>
<script src="static/amazeUI/js/amazeui.min.js"></script>
<script src="static/amazeUI/js/app.js"></script>
<script type="text/javascript">
</script>
</body>


</html>