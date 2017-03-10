<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="login.CookieMemidGet"%>

<!DOCTYPE html>
<html lang='ja'>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <title>LOHACO　定期購入確認</title>
    <link href='css/bootstrap.min.css' rel='stylesheet'>
    <link rel='stylesheet' href='css/material.min.css'>
<script src='js/material.min.js'></script>
<link rel='stylesheet' href='https://fonts.googleapis.com/icon?family=Material+Icons'>
   <link rel='stylesheet' href='css/tuiki.css'>

    <!--[if lt IE 9]>
      <script src='https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js'></script>
      <script src='https://oss.maxcdn.com/respond/1.4.2/respond.min.js'></script>
    <![endif]-->
  </head>
  <body>

    <script src='https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js'></script>
    <script src='js/bootstrap.min.js'></script>


<%
 request.setCharacterEncoding("UTF-8");
String tbl[] = (String[])session.getAttribute("tekicheck");
String name = (String)request.getAttribute("memname");
  if(name==null){
    name =CookieMemidGet.getCookie(request, "memname");
  }

  String login = "";
  if(name==null || name.equals("")){
	  name="ようこそゲストさん";
	  login="<p class='navbar-text navbar-right'><a href='login.jsp' class='navbar-link'>ログイン</a></p>";
	  }else{
	  name=name+"さんログイン中";
	  login="<p class='navbar-text navbar-right'><a href='MemberLogout' class='navbar-link'>ログアウト</a></p>";

	}


%>


<!--navバー開始-->
<nav class='navbar navbar-default '>
  <div class='container-fluid'>
    <div class='navbar-header'>
      <button type='button' class='navbar-toggle collapsed' data-toggle='collapse' data-target='#navbarEexample'>
        <span class='sr-only'>Toggle navigation</span>
        <span class='icon-bar'></span>
        <span class='icon-bar'></span>
        <span class='icon-bar'></span>
      </button>
<a class='navbar-brand' href='index.jsp'>
        <img alt='Brand' src='images/img_sitelogo-02.png' style='height: 20px;'>
      </a>



    </div>

    <div class='collapse navbar-collapse' id='navbarEexample'>
      <ul class='nav navbar-nav'>
        <li class='dropdown'>
          <a href='Productlist.html' class='dropdown-toggle' data-toggle='dropdown' role='button'>カテゴリー一覧<span class='caret'></span></a>
          <ul class='dropdown-menu' role='menu'>
            <li><a href='ProductsSearch?cateid=1'>洗剤</a></li>
            <li><a href='ProductsSearch?cateid=2'>掃除用具</a></li>
            <li><a href='ProductsSearch?cateid=3'>ゴミ袋</a></li>
            <li><a href='ProductsSearch?cateid=4'>洗濯用品</a></li>
            <li><a href='ProductsSearch?cateid=5'>消臭・芳香剤</a></li>
            <li><a href='ProductsSearch?cateid=6'>ファッション</a></li>
            <li><a href='ProductsSearch?cateid=7'>ティッシュ・トイレットペーパ類</a></li>
            <li><a href='ProductsSearch?cateid=8'>虫よけ・殺虫剤</a></li>
            <li><a href='ProductsSearch?cateid=9'>タオル・バス・トイレ用品</a></li>
            <li><a href='ProductsSearch?cateid=10'>キッチン雑貨</a></li>
            <li><a href='ProductsSearch?cateid=11'>キッチン消耗品・簡易食器</a></li>
            <li><a href='ProductsSearch?cateid=12'>ペット用品</a></li>
            <li><a href='ProductsSearch?cateid=13'>調理器具・鍋・包丁</a></li>
            <li><a href='ProductsSearch?cateid=14'>食器</a></li>
            <li><a href='ProductsSearch?cateid=15'>弁当箱・水筒</a></li>
            <li><a href='ProductsSearch?cateid=16'>消毒・除菌・ハンドソープ</a></li>
            <li><a href='ProductsSearch?cateid=17'>冷却・カイロ</a></li>
            <li><a href='ProductsSearch?cateid=18'>ベビー・キッズ・介護用品</a></li>
            <li><a href='ProductsSearch?cateid=19'>防災・防犯グッズ</a></li>
            <li><a href='ProductsSearch?cateid=20'>アウトドア・イベント用品・冠婚葬祭</a></li>
            <li><a href='ProductsSearch?cateid=21'>スナック・お菓子</a></li>
            <li><a href='ProductsSearch?cateid=22'>水・コーヒー・お茶</a></li>
            <li><a href='ProductsSearch?cateid=23'>文房具・オフィス用品</a></li>
            <li><a href='ProductsSearch?cateid=24'>食品・調味料</a></li>
          </ul>
        </li>
        <li class='dropdown'>
          <a href='#' class='dropdown-toggle' data-toggle='dropdown' role='button'>セール一覧<span class='caret'></span></a>
          <ul class='dropdown-menu' role='menu'>
            <li><a href='#'>タイムセール</a></li>
            <li><a href='#'>期間限定セール</a></li>
            <li><a href='#'>日替わりセール</a></li>
          </ul>
        </li>
        <li><a href='#'>ランキング</a></li>
        <li><a href='#'>クーポン</a></li>
        <li class='dropdown'>
          <a href='#' class='dropdown-toggle' data-toggle='dropdown' role='button'>お問い合わせ<span class='caret'></span></a>
          <ul class='dropdown-menu' role='menu'>
            <li><a href='#'>プライバシーポリシー</a></li>
            <li><a href='#'>ヘルプ</a></li>
            <li><a href='#'>運営問い合わせ</a></li>
          </ul>
        </li>
      </ul>
     <form class='navbar-form navbar-left' role='search' action='ProductsSearch' method='POST'>
        <div class='form-group'>
          <input type='hidden' name='hantei' value='1'>
          <input type='text' class='form-control' placeholder='商品検索' name='search'>
        </div>
        <button type='submit' class='btn btn-default'>検索</button>
      </form>





      <p class='navbar-text navbar-right'><a href='HistoryKanriServlet' class='navbar-link'><i class='material-icons'>history</i>購入履歴</a></p>

      <p class='navbar-text navbar-right'><a href='CartKanriServlet?hantei=2' class='navbar-link'><i class='material-icons'>shopping_cart</i>カート</a></p>

      <p class='navbar-text navbar-right'><a href='mypage.jsp' class='navbar-link'><i class='material-icons'>account_circle</i>マイページ</a></p>

      <%= login %>
       <p class="navbar-text navbar-right"><%= name %></p>
    </div>
  </div>
</nav>
<!--navバー終了-->

<div id='content'>


<div class='col-md-11 col-md-offset-1'>
<h1>定期購入確認</h1>
  </div>

<!--購入リストのdiv-->
<div class='table-responsive col-md-8 col-md-offset-2'>

    <form action='TekiSyoriServlet' method='post'>
    <input type='hidden' name='tekihantei' value='1'>



  <table class='table table-bodered'>
    <tbody>
      <tr>
        <th class='active col-md-3 col-xs-3'>商品名</th>
        <td class='col-md-9 col-xs-9 text-right'><%=tbl[0] %></td>
      </tr>
      <tr>
        <th class='active col-md-3 col-xs-3'>値段</th>
        <td class='col-md-9 col-xs-9 text-right'><%=tbl[1] %>円</td>
      </tr>
      <tr>
        <th class='active col-md-3 col-xs-3'>個数</th>
        <td class='col-md-9 col-xs-9 text-right'><%=tbl[2] %>個</td>
      </tr>
      <tr>
        <th class='active col-md-3 col-xs-3'>購入期間</th>
        <td class='col-md-9 col-xs-9 text-right'><%=tbl[3] %>ヶ月</td>
      </tr>
    </tbody>
  </table>

  <input class='btn btn-pad btn-warning center-block' type='submit' value='定期購入リストに追加'>
      </form>


</div>
<!--リストの終了-->

  </div>
  <!---contents-->


<!--上に戻るボタン開始-->
<div class='container-fluid'>
  <div class='row'>
    <div class='col-md-12'><a href='#' class='btn btn-default btn-block'><i class='material-icons'>eject</i></a>
</div>
  </div>
</div>
<!--上に戻るボタン終了-->

<!--footerの開始-->
<div id='footer'>
    <!-- /sns-icon -->
    <div class='copy'>
        <span>Copyright &#169; 2013 example.com All Rights Reserved.</span>
    </div>
    <!-- /copy -->
</div>
<!-- /footer -->
  </body>
</html>
