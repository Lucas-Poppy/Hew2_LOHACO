<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>管理画面</title>

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
    <div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
      <header class="demo-header mdl-layout__header mdl-color--grey-100 mdl-color-text--grey-600">
        <div class="mdl-layout__header-row">
          <span class="mdl-layout-title">受注管理</span>
          <div class="mdl-layout-spacer"></div>
          <button class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon" id="hdrbtn">
            <i class="material-icons">more_vert</i>
          </button>
        </div>
      </header>
      <div class="demo-drawer mdl-layout__drawer mdl-color--blue-grey-900 mdl-color-text--blue-grey-50">
        <header class="demo-drawer-header" style="height: 64px">
         <span class="mdl-layout-title"> <i class="material-icons" style="vertical-align: middle">build</i><span style="vertical-align: middle"> 販売管理システム</span></span>
        </header>
        <nav class="demo-navigation mdl-navigation mdl-color--blue-grey-800">
          <a class="mdl-navigation__link" href=""><i class="material-icons mdl-badge mdl-badge--overlap" data-badge="100">shopping_cart</i>受注管理</a>
          <a class="mdl-navigation__link" href=""><i class="material-icons">send</i>発注管理</a>
          <a class="mdl-navigation__link" href=""><i class="material-icons">monetization_on</i>売上管理</a>
          <a class="mdl-navigation__link" href=""><i class="material-icons">local_shipping</i>配送管理</a>
          <div class="mdl-layout-spacer"></div>
          <a class="mdl-navigation__link" href=""><i class="mdl-color-text--blue-grey-400 material-icons" role="presentation">help_outline</i><span class="visuallyhidden">Help</span></a>
        </nav>
      </div>
      <main class="mdl-layout__content mdl-color--grey-100">
        <div class="col-sm-12">
          <ul class="mui-tabs__bar">
            <li class="mui--is-active"><a data-mui-toggle="tab" data-mui-controls="pane-default-1">未受注リスト</a></li>
            <li><a data-mui-toggle="tab" data-mui-controls="pane-default-2">受注済みリスト</a></li>
          </ul>
          <div class="mui-tabs__pane mui--is-active" id="pane-default-1">
          <div class="cnter-block">
            <div class="table-responsive col-sm-6 col-sm-offset-1">
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
                   <section>
                      <div class="panel-group" id="accordion">
                        <div class="panel panel-default">
                          <div class="panel-heading">
                            <h4 class="panel-title accordion-toggle">
                              <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">セクション1 </a>
                            </h4>
                          </div>
                          <div id="collapseOne" class="panel-collapse collapse in">
                            <div class="panel-body">
                              <h3>アコーディオンの中身1</h3>
                              <p>コメントコメントコメントコメントコメントコメントコメント </p>
                            </div>
                          </div>
                        </div>
                        <div class="panel panel-default">
                          <div class="panel-heading">
                            <h4 class="panel-title accordion-toggle">
                              <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" class="collapsed">セクション2 </a>
                            </h4>
                          </div>
                          <div id="collapseTwo" class="panel-collapse collapse">
                            <div class="panel-body">
                              <h3>アコーディオンの中身2</h3>
                              <p>コメントコメントコメントコメントコメントコメントコメント </p>
                            </div>
                          </div>
                        </div>
                        <div class="panel panel-default">
                          <div class="panel-heading">
                            <h4 class="panel-title accordion-toggle">
                              <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree" class="collapsed">セクション3 </a>
                            </h4>
                          </div>
                          <div id="collapseThree" class="panel-collapse collapse">
                            <div class="panel-body">
                              <h3>アコーディオンの中身3</h3>
                              <p>コメントコメントコメントコメントコメントコメントコメント </p>
                            </div>
                          </div>
                        </div>
                      </div>
                    </section>
                 </li>
                 <li class="tb_page">

                 </li>
                 <li class="tb_page">
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
          <div class="mui-tabs__pane" id="pane-default-2">Pane-2</div>
        </div>


      </main>
    </div>

    <div class="remodal" data-remodal-id="modal" data-remodal-options="hashTracking:false">
  <button data-remodal-action="close" class="remodal-close"></button>
  <table class="table table-bordered">
  <thead>
    <tr>
      <th>商品名</th>
      <th>個数</th>
      <th>配送処理</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>1</th>
      <td>ブルーＳＣ</td>
      <td><button id="aaa" class="btn btn-primary" value="配送"><font size="1">配送処理</font></button></td>
    </tr>
    <tr>
      <th>2</th>
      <td>ＦＣウェヌス</td>
      <td>金星</td>
    </tr>
    <tr>
      <th>3</th>
      <td>ジュピターＦＣ</td>
      <td>木星</td>
    </tr>
    <tr>
      <th>4</th>
      <td>ＳＣマーキュリー</td>
      <td>水星</td>
    </tr>
    <tr>
      <th>5</th>
      <td>ＦＣマルス</td>
      <td>火星</td>
    </tr>
  </tbody>
</table>
<!--   <button data-remodal-action="cancel" class="remodal-cancel">Cancel</button>
  <button data-remodal-action="confirm" class="remodal-confirm">OK</button> -->
</div>






    <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
    <script type="text/javascript" src="js/app.js"></script>
  </body>
</html>