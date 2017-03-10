<%@page import="benefit.SessionRemoveClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="ja">
<head>
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximum-scale=1">
    <link href="css/bootstrap.min.css" rel="stylesheet">
      <!-- Add to homescreen for Chrome on Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="images/android-desktop.png">

    <!-- Add to homescreen for Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-title" content="Material Design Lite">
    <link rel="apple-touch-icon-precomposed" href="images/ios-desktop.png">

    <!-- Tile icon for Win8 (144x144 + tile color) -->
    <meta name="msapplication-TileImage" content="images/touch/ms-touch-icon-144x144-precomposed.png">
    <meta name="msapplication-TileColor" content="#3372DF">

    <link rel="shortcut icon" href="images/favicon.png">

    <!-- SEO: If your mobile URL is different from the desktop URL, add a canonical link to the desktop page https://developers.google.com/webmasters/smartphone-sites/feature-phones -->
    <!--
    <link rel="canonical" href="http://www.example.com/">
    -->
    <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
       <script type="text/javascript" src="js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
<!-- 
    <link rel="stylesheet" type="text/css" href="css/material.min.css">
    <script type="text/javascript" src="js/material.min.js"></script> -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.cyan-light_blue.min.css">
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="remodal.css">
    <link rel="stylesheet" href="remodal-default-theme.css">
    <link href="css/mui.min.css" rel="stylesheet" type="text/css" />
    <script src="js/mui.min.js"></script>
    <script src="remodal.js"></script>
    <link rel="stylesheet" type="text/css" href="css/">

</head>
  <body>
  <%
  request.setCharacterEncoding("UTF-8");
  String hairetu = (String)request.getAttribute("android");
  String ware =(String)request.getAttribute("wareid");
  if(hairetu==null){hairetu="";}

  SessionRemoveClass SR = new SessionRemoveClass();
  SR.SessionRemove(request);
  %>

  <style type="text/css" media="screen">


  </style>
  <main class="mdl-layout__content mdl-color--grey-100" style='min-height: 600px;'>
<div class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header" style="background-color: #445DF7">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse" style="background-color:#CBC5C5 ">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="javascript:void(0)" style="color:white">配達処理画面</a>
    </div>
    <div class="navbar-collapse collapse navbar-responsive-collapse">
      <ul class="nav navbar-nav">
        <li class="active"><a href="javascript:void(0)">Active</a></li>
        <li><a href="javascript:void(0)">Link</a></li>
        <li class="dropdown">
          <a href="http://fezvrasta.github.io/bootstrap-material-design/bootstrap-elements.html" data-target="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown
            <b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href="javascript:void(0)">Action</a></li>
            <li><a href="javascript:void(0)">Another action</a></li>
            <li><a href="javascript:void(0)">Something else here</a></li>
            <li class="divider"></li>
            <li class="dropdown-header">Dropdown header</li>
            <li><a href="javascript:void(0)">Separated link</a></li>
            <li><a href="javascript:void(0)">One more separated link</a></li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control col-sm-8" placeholder="Search">
        </div>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="javascript:void(0)">Link</a></li>
        <li class="dropdown">
          <a href="http://fezvrasta.github.io/bootstrap-material-design/bootstrap-elements.html" data-target="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown
            <b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href="javascript:void(0)">Action</a></li>
            <li><a href="javascript:void(0)">Another action</a></li>
            <li><a href="javascript:void(0)">Something else here</a></li>
            <li class="divider"></li>
            <li><a href="javascript:void(0)">Separated link</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</div>

      <div class='container'>
        <div class="col-xs-12" style='padding-top: 150px;' >

          <div class="cnter-block" >
            <div id="android" class="table-responsive col-xs-9 col-xs-offset-0.5" style="background-color: white">


                   <table class='mui-table mui-table--bordered'>
                   		<thead>
                   			<tr>
          					<input type='hidden' name='wareid' value='<%=ware%>'>
          					<th>注文番号</th><th>商品ID</th>
          					<th>数量</th>
          					<th>配達処理</th>
          					</tr>
          				</thead>
          				<tbody id="Sokopage1">
		                   <%=hairetu %>

                     	</tbody>
                      </table>





            </div>
          </div>
          </div>
          </div>





      </main>

    <div id="android2" class='remodal' data-remodal-id='modal' data-remodal-options='hashTracking:false'>
		<div class="h2">
			配送完了してもよろしいですか？
		</div>
		<button data-remodal-action='cancel' class='remodal-cancel'>Cancel</button>
		<button data-remodal-action='confirm' class='remodal-confirm android2'>OK</button>


	  </div>
	  <div id="android1" class='remodal' data-remodal-id='modal2' data-remodal-options='hashTracking:false'>
		<div class="h2">
			配送開始してもよろしいですか？
		</div>
		<button data-remodal-action='cancel' class='remodal-cancel'>Cancel</button>
		<button data-remodal-action='confirm' class='remodal-confirm android1'>OK</button>


	  </div>


    <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
    <script type="text/javascript" src="js/apptest.js"></script>
    <script type="text/javascript" src="js/apptest2.js"></script>

  </body>
</html>