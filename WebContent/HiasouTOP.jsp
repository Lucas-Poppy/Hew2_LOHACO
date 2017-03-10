<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>配送管理画面TOP</title>

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
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.cyan-light_blue.min.css">
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="remodal.css">
<link rel="stylesheet" href="remodal-default-theme.css">
    <link href="css/mui.min.css" rel="stylesheet" type="text/css" />
    <script src="js/mui.min.js"></script>
    <script src="remodal.js"></script>
    <style>
    #view-source {
      position: fixed;
      display: block;
      right: 0;
      bottom: 0;
      margin-right: 40px;
      margin-bottom: 40px;
      z-index: 900;
    }
    </style>
</head>
  <body>
    <div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
      <header class="demo-header mdl-layout__header mdl-color--grey-100 mdl-color-text--grey-600">
        <div class="mdl-layout__header-row">
          <span class="mdl-layout-title">配送管理</span>
          <div class="mdl-layout-spacer"></div>
          <button class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon" id="hdrbtn">
            <i class="material-icons">more_vert</i>
          </button>
        </div>
      </header>
      <div class="demo-drawer mdl-layout__drawer mdl-color--blue-grey-900 mdl-color-text--blue-grey-50">
        <header class="demo-drawer-header" style="height: 64px">
        <a href="KanriTop.jsp">
         <span class="mdl-layout-title"> <i class="material-icons" style="vertical-align: middle">build</i><span style="vertical-align: middle"> 販売管理システム</span></span>
         </a>
        </header>
        <nav class="demo-navigation mdl-navigation mdl-color--blue-grey-800">
          <a class="mdl-navigation__link" href="ZyutyuTopServlet"><i class="material-icons mdl-badge mdl-badge--overlap" data-badge="100">shopping_cart</i>受注管理</a>
          <a class="mdl-navigation__link" href="OrderingKanriServlet"><i class="material-icons">send</i>発注管理</a>
          <a class="mdl-navigation__link" href=""><i class="material-icons">monetization_on</i>売上管理</a>
          <a class="mdl-navigation__link" href="HiasouTOP.jsp"><i class="material-icons">local_shipping</i>配送管理</a>
          <div class="mdl-layout-spacer"></div>
          <a class="mdl-navigation__link" href=""><i class="mdl-color-text--blue-grey-400 material-icons" role="presentation">help_outline</i><span class="visuallyhidden">Help</span></a>
        </nav>
      </div>
      <main class="mdl-layout__content mdl-color--grey-100">
        <div class="conteiner" style="padding: 20px 0">
          <div id="haisoulist" class="col-sm-11">
         <ul>
                  <a href ="HaisouHonbuServlet">
                  <li class="pull-left col-sm-5" style="background-color:#FD7E7E;"><span class="displaynone">
                  本部</span>
                    <div id="hai1_con" class="hai_con">
                      <p class="hai_num">本部</p>
                      <p class="hai_title">配送管理</p>
                    </div>
                      <p class="hai_footer">Headquarters</p>
                  </li>
                  </a>
				<a href ="HiasouSokoServlet?wareid=1">
                  <li class="pull-left col-sm-5" style="background-color:#7770FF;"><span class="displaynone">発注管理</span>
                    <div id="hai2_con" class="hai_con">
                      <p class="hai_num">宮城倉庫</p>
                      <p class="hai_title">配送報告</p>
                    </div>
                      <p class="hai_footer">Miyagi Delivery</p>
                  </li>
                  </a>
                  <a href ="HiasouSokoServlet?wareid=2">
                  <li class="pull-left col-sm-5" style="background-color:#57E361;"><span class="displaynone">売上管理</span>
                    <div id="hai3_con" class="hai_con">
                      <p class="hai_num">東京倉庫</p>
                      <p class="hai_title">配送報告</p>
                    </div>
                      <p class="hai_footer">Tokyo Delivery</p>
                  </li>
                  </a>
                  <a href ="HiasouSokoServlet?wareid=3">
                  <li class="pull-left col-sm-5" style="background-color:#EDCD6D;"><span class="displaynone">配送管理</span>
                    <div id="hai4_con" class="hai_con">
                      <p class="hai_num">岐阜倉庫</p>
                      <p class="hai_title">配送報告</p>
                    </div>
                      <p class="hai_footer">Gifu Delivery</p>
                  </li>
                  </a>
                  <a href ="HiasouSokoServlet?wareid=4">
                  <li class="pull-left col-sm-5" style="background-color:#65F2E3;"><span class="displaynone">配送管理</span>
                    <div id="hai5_con" class="hai_con">
                      <p class="hai_num">大阪倉庫</p>
                      <p class="hai_title">配送報告</p>
                    </div>
                      <p class="hai_footer">Osaka Delivery</p>
                  </li>
                  </a>
                  <a href ="HiasouSokoServlet?wareid=5">
                  <li class="pull-left col-sm-5" style="background-color:#E96CFC;"><span class="displaynone">配送管理</span>
                    <div id="hai6_con" class="hai_con">
                      <p class="hai_num">長崎倉庫</p>
                      <p class="hai_title">配送報告</p>
                    </div>
                      <p class="hai_footer">Nagasaki Delivery</p>
                  </li>
                  </a>
                </ul>
                </div>

        </div>

      </main>



    <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
    <script type="text/javascript" src="js/apptest.js"></script>
  </body>
</html>