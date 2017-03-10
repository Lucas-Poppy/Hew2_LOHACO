<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="benefit.SessionRemoveClass"%>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>管理画面TOPページ</title>

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

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.cyan-light_blue.min.css">
    <link rel="stylesheet" href="styles.css">
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
<%

  SessionRemoveClass SR = new SessionRemoveClass();
  SR.SessionRemove(request);
%>
</head>
  <body>
    <div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
      <header class="demo-header mdl-layout__header mdl-color--grey-100 mdl-color-text--grey-600">
        <div class="mdl-layout__header-row">
          <span class="mdl-layout-title">Home</span>
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
           <div id="main" class="container" style="padding: 20px 0">
            <div class="row">
              <div id="new-info" class="col-sm-3">
             <div class="panel panel-primary" style="height: 458px;">

                <div class="panel-heading">
                     新着情報
                </div>
                <div class="panel-body">
                  <dl>
                    <dt class="text-primary">発注管理</dt>
                      <dd>在庫不足の発注が49件できていません。</dd>
                    <dt class="text-primary">発注管理</dt>
                      <dd>発注していた商品が38件届きました。</dd>
                    <dt class="text-primary">配送管理</dt>
                      <dd>配送報告が280件来ています。</dd>
                    <dt class="text-primary">受注管理</dt>
                      <dd>受注処理をしていないデータが280件あります。</dd>
                    <dt class="text-primary">売上管理</dt>
                      <dd>今月の売り上げが確定しました。</dd>
                </div>
              </div>
           </div>
            <div id="kanrilist" class="col-sm-8.5">
                <ul>
                <a href="ZyutyuTopServlet">
                  <li class="pull-left col-sm-4" style="background-color:#FD7E7E;"><span class="displaynone">受注管理</span>
                    <div id="kl1_con" class="kl_con">
                      <p class="kl_num">73件</p>
                      <p class="kl_title">受注管理</p>
                    </div>
                      <p class="kl_footer">Order management</p>
                  </li>
                 </a>
                 <a href="OrderingKanriServlet">
                  <li class="pull-left col-sm-4" style="background-color:#7770FF;"><span class="displaynone">発注管理</span>
                    <div id="kl2_con" class="kl_con">
                      <p class="kl_num">65件</p>
                      <p class="kl_title">発注管理</p>
                    </div>
                      <p class="kl_footer">Ordering management</p>
                  </li>
                  </a>
                  <li class="pull-left col-sm-4" style="background-color:#57E361;"><span class="displaynone">売上管理</span>
                    <div id="kl3_con" class="kl_con">
                      <p class="kl_num">1件</p>
                      <p class="kl_title">売上管理</p>
                    </div>
                      <p class="kl_footer">Sales management</p>
                  </li>
                  <a href="HiasouTOP.jsp">
                  <li class="pull-left col-sm-4" style="background-color:#EDCD6D;"><span class="displaynone">配送管理</span>
                    <div id="kl4_con" class="kl_con">
                      <p class="kl_num">28件</p>
                      <p class="kl_title">配送管理</p>
                    </div>
                      <p class="kl_footer">Delivery management</p>
                  </li>
                  </a>
                </ul>
            </div>
            </div>

          </div>

      </main>
    </div>


    <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
  </body>
</html>