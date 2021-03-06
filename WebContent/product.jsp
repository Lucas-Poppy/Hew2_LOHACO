<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="login.CookieMemidGet"%>



<%
 request.setCharacterEncoding("UTF-8");

String quantity = new String();
for(int cnt = 1 ; cnt <= 99; cnt++){
		quantity +="<option value='"+cnt+"'>"+cnt+"</option>";
}

String period = new String();

for (int cnt2 =1; cnt2 <=6; cnt2++){
	   period += "<option value='"+cnt2+"'>"+cnt2+"ヶ月</option>";
}

String[] tbl = (String[])session.getAttribute("selecttbl");
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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title><%= tbl[1] %></title>
<link href='css/bootstrap.min.css' rel='stylesheet'>
<link rel='stylesheet' href='css/material.min.css'>
<link rel='stylesheet' href='css/tuiki.css'>
<script src='js/material.min.js'></script>
<link rel='stylesheet' href='https://fonts.googleapis.com/icon?family=Material+Icons'>
    <!--[if lt IE 9]>
      <script src='https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js'></script>
      <script src='https://oss.maxcdn.com/respond/1.4.2/respond.min.js'></script>
    <![endif]-->
</head>
<body>

<script src='https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js'></script>
<script src='js/bootstrap.min.js'></script>
<link rel="stylesheet" href="css/mui.min.css" type="text/css" />
<script src="js/mui.min.js"></script>



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

<div id="content">
<div class='container-fluid'>
  <div class='row'>
    <div class='col-md-3 col-md-offset-1'>
      <ol class='breadcrumb'>
        <li class='active'><%= tbl[3] %></li>
      </ol>
    </div>
  </div>
</div>


<div class='container-fluid'>
  <div class='row'>
    <div class='col-md-4 col-md-offset-1'>
    <img src='<%= tbl[0] %>' height='300' width='300' alt="商品画像">
    </div>
    <div class='col-md-6'>

          <p class="productnamesize"><%= tbl[1] %></p>
          <p class="pricenamesize">￥<%= tbl[2] %></p>
          <p><%= tbl[5] %></p>
          <p>詳細</p>

      <div class='container-fluid'>
        <div class='row'>

          <div id='sellblock' class='col-md-8'>
          <ul class="mui-tabs__bar mui-tabs__bar--justified">
              <li class="mui--is-active" style="border-bottom: solid 1px green;"><a data-mui-toggle="tab" data-mui-controls="pane-justified-1" style="cursor:hand; cursor:pointer; color: green;">通常購入</a></li>
              <li style="border-bottom: solid 1px orange;"><a data-mui-toggle="tab" data-mui-controls="pane-justified-2" style="cursor:hand; cursor:pointer; color: orange;">定期購入</a></li>
          </ul>

              <div class="mui-tabs__pane mui--is-active" id="pane-justified-1">
                <div class="container contab">

                  <form action='CartKanriServlet' method='post'>
          			<input type='hidden' name='hantei' value='0'>
          			<input type='hidden' name='proid' value='<%= tbl[4] %>'>
                     <div class='col-md-2'>


                          <div class='form-group'>
                             <label for='InputSelect'>個数</label>
                             <select class='form-control' id='InputSelect' name='quantity'>
                               <%=quantity %>
                             </select>
                           </div>

                     </div>
                    <button type='submit' class='btn btn-success col-md-offset-1' id='cartbtn' style="margin-top: 20px"><i class='material-icons'>add_shopping_cart</i>カートに入れる</button>
                   </form>

                </div>
              </div>

              <div class="mui-tabs__pane" id="pane-justified-2">
              <div class="container contab">

               <form action='TekiSyoriServlet' method='POST'>
				<input type='hidden' name='proid' value='<%= tbl[4] %>'>
				<input type='hidden' name='tekihantei' value='0'>



                    <div class='col-md-2'>

                          <div class='form-group'>
                            <label for='InputSelect'>個数</label>
                             <select class='form-control' id='InputSelect2' name='quantity2'>
                               <%=quantity%>
                             </select>
                           </div>
                           <div class='form-group'>
                            <label for='InputSelect'>購入間隔</label>
                             <select class='form-control' id='InputSelect3' name='tekikikan'>
                               <%=period %>
                             </select>
                           </div>

                    </div>
                  <button type='submit' class='btn btn-warning col-md-offset-1 btn-warning' id="tekibtn" style="margin-top: 20px"><i class="material-icons">event_note</i>定期購入申し込み</button>
                 </form>

                </div>
              </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<hr>
<div class="container-fluid">
  <div class="row">
    <div class="col-md-10 col-md-offset-1"><span class="label label-info">商品詳細</span>
    <p>アスクル（LOHACO）では、サイト上に最新の商品情報を表示するよう努めておりますが、メーカーの都合等により、商品規格・仕様（容量、パッケージ、原材料、原産国など）が変更される場合がございます。このため、実際にお届けする商品とサイト上の商品情報の表記が異なる場合がございますので、ご使用前には必ずお届けした商品の商品ラベルや注意書きをご確認ください。さらに詳細な商品情報が必要な場合は、メーカー等にお問い合わせください。
</p>  </div>
  </div>
</div>
<hr>
<div class="container-fluid">
  <div class="row">
    <div class="col-md-10 col-md-offset-1 "><span class="label label-info">最近確認した商品</span><p>
    <a href="#"><img src='images/9.jpg' height='150' width='150' class='rankimg'></a>
    <a href="#"><img src='images/211.jpg' height='150' width='150' class='rankimg'></a>
    <a href="#"><img src='images/57.jpg' height='150' width='150' class='rankimg'></a>
    <a href="#"><img src='images/21.jpg' height='150' width='150' class='rankimg'></a>
    <a href="#"><img src='images/190.jpg' height='150' width='150' class='rankimg'></a>
    <a href="#"><img src='images/167.jpg' height='150' width='150' class='rankimg'></a>
    <a href="#"><img src='images/131.jpg' height='150' width='150' class='rankimg'></a>
    </p></div>
  </div>
</div>
<hr>
<div class="container-fluid">
  <div class="row">
    <div class="col-md-10 col-md-offset-1"><span class="label label-info">関連情報</span>
    <p>カテゴリー：<a href="#">ジャンル名</a> 　セール中：<a href="#">日替わりセール</a></p>
    </div>
  </div>
</div>
</div>

<div class='container-fluid'>
  <div class='row'>
    <div class='col-md-12'>
      <div id='tophe'>
    <a href='#' class='btn btn-default btn-block'><i class='material-icons'>eject</i></a>
      </div>
</div>
  </div>
</div>



<div id='footer'>
    <!-- /sns-icon -->
    <div class='copy'>
        <span>Copyright &#169; 2013 example.com All Rights Reserved.</span>
    </div>
    <!-- /copy -->
</div>
<!-- /footer -->


  </body>
  <script language="javascript">
  var a = '<%=tbl[5]%>';
  if(a=="在庫なし"){
    // 無効化
    document.getElementById("cartbtn").disabled = "true";
    document.getElementById("tekibtn").disabled = "true";
    console.log("ボタン無効");
  }else{
    console.log("ボタン有効");
  }






</script>
</html>