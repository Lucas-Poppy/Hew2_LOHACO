<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="benefit.SessionRemoveClass"%>

<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>発注管理画面</title>

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
  <%
  request.setCharacterEncoding("UTF-8");
  String list[] = (String[])session.getAttribute("haisolist");
  String tbl = new String();
  String tbl2= new String();
  if(list!=null){
	  tbl=list[0];
	  tbl2=list[1];
  }

  //String tbl2=(String)session.getAttribute("list2");

  if(tbl==null){tbl="";}
  if(tbl2==null){tbl2="";}
  SessionRemoveClass SR = new SessionRemoveClass();
  SR.SessionRemove(request);
  %>
    <div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
      <header class="demo-header mdl-layout__header mdl-color--grey-100 mdl-color-text--grey-600">
        <div class="mdl-layout__header-row">
          <span class="mdl-layout-title">発注管理</span>
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
        <div class="col-sm-12">
		    	<ul class="mui-tabs__bar">
            <li class="mui--is-active"><a data-mui-toggle="tab" data-mui-controls="pane-default-1">未発注リスト</a></li>
            <li><a data-mui-toggle="tab" data-mui-controls="pane-default-2">納品済みリスト</a></li>
          </ul>
          <div class="mui-tabs__pane mui--is-active" id="pane-default-1">
           <div class="cnter-block">
            <div class="table-responsive col-sm-9 col-sm-offset-0.5">
                  <nav>
                    <ul class="pagination">
                      <li class="disabled tb_back">
                        <a href="#" aria-label="前のページへ">
                          <span aria-hidden="true">«</span>
                        </a>
                      </li>
                      <li class="active tb_index"><a href="#">1</a></li>
                      <li class="tb_index"><a href="#">2</a></li>
                      <li class="tb_index"><a href="#">3</a></li>
                      <li class="tb_index"><a href="#">4</a></li>
                      <li class="tb_index"><a href="#">5</a></li>
                      <li class="tb_prev">
                        <a href="#" aria-label="次のページへ">
                          <span aria-hidden="true">»</span>
                        </a>
                      </li>
                    </ul>
                   </nav>
               <ul>
                 <li class="tb_page tb_active">
                   <section id="Hatyupage1">
                      <%=tbl %>
                    </section>
                 </li>
                 <li class="tb_page">

                   <section>
                      2ページ目
                    </section>
                 </li>
                 <li class="tb_page">

                   <section>
                      3ページ目
                    </section>
                  </li>
               </ul>



                  <nav>
                    <ul class="pagination">
                      <li class="disabled tb_back">
                        <a href="#" aria-label="前のページへ">
                          <span aria-hidden="true">«</span>
                        </a>
                      </li>
                      <li class="active tb_index"><a href="#">1</a></li>
                      <li class="tb_index"><a href="#">2</a></li>
                      <li class="tb_index"><a href="#">3</a></li>
                      <li class="tb_index"><a href="#">4</a></li>
                      <li class="tb_index"><a href="#">5</a></li>
                      <li class="tb_prev">
                        <a href="#" aria-label="次のページへ">
                          <span aria-hidden="true">»</span>
                        </a>
                      </li>
                    </ul>
                   </nav>
            </div>
          </div>
          </div>
          <div class="mui-tabs__pane" id="pane-default-2">
         	           <div class="cnter-block">
            <div class="table-responsive col-sm-9 col-sm-offset-0.5">
                  <nav>
                    <ul class="pagination">
                      <li class="disabled tb_back2">
                        <a href="#" aria-label="前のページへ">
                          <span aria-hidden="true">«</span>
                        </a>
                      </li>
                      <li class="active tb_index2"><a href="#">1</a></li>
                      <li class="tb_index2"><a href="#">2</a></li>
                      <li class="tb_index2"><a href="#">3</a></li>
                      <li class="tb_index2"><a href="#">4</a></li>
                      <li class="tb_index2"><a href="#">5</a></li>
                      <li class="tb_prev2">
                        <a href="#" aria-label="次のページへ">
                          <span aria-hidden="true">»</span>
                        </a>
                      </li>
                    </ul>
                   </nav>
               <ul>
                 <li class="tb_page tb_active">
                   <section id="Hatyupage1-nohin">
                      <%=tbl2 %>
                    </section>
                 </li>
                 <li class="tb_page">

                   <section>
                      2ページ目
                    </section>
                 </li>
                 <li class="tb_page">

                   <section>
                      3ページ目
                    </section>
                  </li>
               </ul>



                  <nav>
                    <ul class="pagination">
                      <li class="disabled tb_back2">
                        <a href="#" aria-label="前のページへ">
                          <span aria-hidden="true">«</span>
                        </a>
                      </li>
                      <li class="active tb_index2"><a href="#">1</a></li>
                      <li class="tb_index2"><a href="#">2</a></li>
                      <li class="tb_index2"><a href="#">3</a></li>
                      <li class="tb_index2"><a href="#">4</a></li>
                      <li class="tb_index2"><a href="#">5</a></li>
                      <li class="tb_prev2">
                        <a href="#" aria-label="次のページへ">
                          <span aria-hidden="true">»</span>
                        </a>
                      </li>
                    </ul>
                   </nav>
            </div>
          </div>


          </div>

          </div>



      </main>
    </div>

    <div id="test3" class='remodal' data-remodal-id='modal' data-remodal-options='hashTracking:false'>



	  </div>


    <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
    <script type="text/javascript" src="js/apptest.js"></script>
  </body>
</html>