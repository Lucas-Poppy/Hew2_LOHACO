<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.util.Calendar"%>
   <%@page import="benefit.SessionRemoveClass"%>
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>LOHACO　伝票</title>
    <script src="http://maps.google.com/maps/api/js?language=ja&key=AIzaSyCdIuTi4OmNvrmtlEGSRPCZmE7IvbefciM"></script>
    <style>
        #map {
            width: 300px;
            height: 300px;
        }
        </style>
    <link href="css/bootstrap.min.css" rel="stylesheet">
<!--     <link rel="stylesheet" href="css/material.min.css">
 -->    <link rel="stylesheet" href="css/denpyo.css">
<!-- <script src="js/material.min.js"></script>
 -->
 <!-- <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons"> -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>

    <script src="js/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

<!--         <link rel="stylesheet" href="css/fix.css">
 -->

<%
request.setCharacterEncoding("UTF-8");
String tbl = (String)session.getAttribute("prolist");
String hairetu[] = (String[])session.getAttribute("denpyolist");

Calendar cal = Calendar.getInstance();	//[1]



%>
<div class='wrapper'>
<div class="container-fluid">
  <div class="row">
    <div class="col-lg-3 col-lg-offset-3 pull-left">
    <h1 class="center-block">     配達伝票
    </h1>
    </div>
 <div class="col-lg-2 col-lg-offset-2  col-xs-2 col-xs-offset-7 pull-left">
    <div id="dayandno">
<p><%=cal.get(Calendar.YEAR) %>/<%=cal.get(Calendar.MONTH)+1 %>/<%=cal.get(Calendar.DATE)%></p>
<p>注文No：<%=hairetu[2] %></p>
    </div>
 </div>
  </div>
</div>

<div class="container-fluid">
  <div class="row">
    <div class="col-lg-6 col-lg-offset-3">
<table class="table table-bordered">
  <thead>
    <tr>
      <th>商品ID</th>
      <th>商品名</th>
      <th>個数</th>
    </tr>
  </thead>
  <tbody>
    <%=tbl %>
  </tbody>
</table>


<hr>
<table class="table table-bordered">
  <tbody>
    <tr>
      <th>顧客名</th>
      <td id="Kname"><%=hairetu[3] %></td>
    </tr>
    <tr>
      <th>顧客郵便番号</th>
      <td><%=hairetu[4] %></td>
    </tr>
    <tr>
      <th>顧客住所</th>
      <td id="address"><%=hairetu[1] %></td>
    </tr>
    <tr>
      <th>倉庫名</th>
      <td id="soko"><%=hairetu[0] %></td>
    </tr>
  </tbody>
</table>
</div>
  </div>
</div>

<div class="container-fluid">
  <div class="row">
    <div class="col-lg-3 col-lg-offset-3 pull-left">
      <div id="map"></div>
    </div>

    <div class="col-lg-3 pull-left">
          <h2>アスクル株式会社</h2>
         　<p>
         〒:135-0061<br>
         住所:東京都江東区豊洲三丁目2番3号<br>
         TEL:03-4330-5001<br>
         FAX:03-4330-4100<br>
         </p>
    </div>
    <div class="col-lg-3 clear-left" style='height: 120px;top:200px;right:250px;'>
              <div id="coffee"></div>
    </div>
  </div>
</div>




</div>
    <script type="text/javascript" src="js/apptest2.js"></script>
        <script src="js/jquery.qrcode.min.js"></script>

<script>
    // geocoding
    //住所→緯度経度算出
    var add = $("#address").text();
    console.log(add);

        var geocoder = new google.maps.Geocoder();
        geocoder.geocode({
            "address":add
        },function(result,status){
            if(status==google.maps.GeocoderStatus.OK){
                    var latlng = result[0].geometry.location;//new google.maps.LatLng(35.66, 139.69);//緯度経度
                    var options = {
                        zoom: 14,
                        center: latlng,
                        mapTypeId: google.maps.MapTypeId.ROADMAP
                    };
                    var map = new google.maps.Map(document.getElementById('map'), options);
                    var marker = new google.maps.Marker({
                            position: map.getCenter(),
                            map: map
                        });
            }else{
                alert("エラーです！！");
            }
        });

        $("#coffee").html("");
      $("#coffee").qrcode({
          width:100,                               //QRコードの幅
         height:100, 
        text:"http://192.168.43.76:8080/HEW2_01/AndroidSokoServlet?wareid="+<%=hairetu[5] %>+"&orderno="+<%=hairetu[2] %>
      }); 
    



        // var infoWindow = new google.maps.InfoWindow({
        //     content:"<strong>渋谷のあたり</strong>だよ！",
        //     position:map.getCenter()
        // });
  //----------------------------------------------------------------
        // var marker = new google.maps.Marker({
        //     position:map.getCenter(),
        //     map:map
        // });
        // google.maps.event.addListener(marker,"click",function(){
        //     infoWindow.open(map);//そこに情報ウィンドウを表示させる分
        // })

//-------------------------------------------------------------------------
//クリックされたところにマーカーを置く方法↓
        // google.maps.event.addListener(map,"click",function(event){
        //     var marker = new google.maps.Marker({
        //         position:event.latLng,
        //         draggable:true,
        //         icon:new google.maps.MarkerImage("unnamed.png"),//アイコンを変えれる
        //         title:"マーカーですよ！！",
        //         map:map
        //        });
        // });

    </script>
  </body>
</html>
