
/* 画面のローディングが完了したら実行する */
$(window).on('load', function () {



$("#test").on('click','.ZyutyuStock', function(){
            var sum1 = parseInt($(this).parent().find("#sum").text());
            var kosu1=$(this).parent().find("tr").eq(1).find("#kosu").val();
            var kosu2=$(this).parent().find("tr").eq(2).find("#kosu").val();
            var kosu3=$(this).parent().find("tr").eq(3).find("#kosu").val();
            var kosu4=$(this).parent().find("tr").eq(4).find("#kosu").val();
            var kosu5=$(this).parent().find("tr").eq(5).find("#kosu").val();
            var flag = 0;

            var proid=$(":hidden[name='proid']").val();
            var orderno=$(":hidden[name='orderno']").val();

            console.log("proid="+proid);
            console.log("orderno="+orderno);


            var sum2=int(kosu1)+int(kosu2)+int(kosu3)+int(kosu4)+int(kosu5);
            console.log("sum2="+sum2);
            console.log("sum1="+sum1);
            if(sum1==sum2){
                    console.log("配送処理");
                    $.ajax({
			    	url: 'ReceiveKanriServlet',
			    	type: 'POST',
			    	dataType: 'json',
			    	data: {
			    			kosu1:int(kosu1),
			    			kosu2:int(kosu2),
			    			kosu3:int(kosu3),
			    			kosu4:int(kosu4),
			    			kosu5:int(kosu5),
			    			proid:proid,
			    			orderno:orderno
			    		},
			    })
			    .done(function() {
			    	console.log("success");
			    })
			    .fail(function() {
			    	console.log("error");
			    })
			    .always(function() {
			    	console.log("complete");
			    });

                    window.setTimeout(reroad,1000);

            }else if(sum1<sum2){
              var q = sum2-sum1;
              console.log("エラー処理");
              window.alert("配送する個数が"+q+"個多いです");
            }else{
              var q = sum1-sum2;
              console.log("エラー処理");
              window.alert("配送する個数が"+q+"個少ないです");
            }
            
      });

  function int(i){
    var test=parseInt(i);
    if(test<0){
      test=0;
    }
    if(!test){
      return 0;
    }else{
      return test;
    }
  }

  function reroad(){
    $.ajax({
    	url: 'ZyutyuTopServlet',
    	type: 'POST',
    	dataType: 'json',
    	data: {
			    flag:"OK",
			    		},
    })
    .done(function(result) {
    	console.log("配送処理の後の画面リロードOK");
      var a = result + "";
      var hairetu=a.split(",");
    	document.getElementById("page1").innerHTML=hairetu[0];
      document.getElementById("pane2-page1").innerHTML=hairetu[1];
      document.getElementById("pane3-page1").innerHTML=hairetu[2];



    })
    .fail(function() {
    	console.log("配送処理の後の画面リロード失敗");
    })
    .always(function() {
    	console.log("complete");
    });
  }

   

              




  //テーブルの切り替え
  $(".tb_index").click(function(event) {
    $('.tb_active').removeClass('tb_active');
    $('.tb_back').removeClass('disabled');
    $('.tb_prev').removeClass('disabled');
    $(".tb_index").removeClass('active');
    var clickedIndex = $(".tb_index").index($(this));
    $(this).addClass("active");
    if(clickedIndex<5){
      $(".tb_index").eq(clickedIndex+5).addClass("active");
      $(".tb_page").eq(clickedIndex).addClass('tb_active');
       $(".tb_index").eq(clickedIndex).addClass("active");
       if(clickedIndex==0){
          $('.tb_back').addClass('disabled');
        }else if(clickedIndex==4){
          $('.tb_prev').addClass('disabled');
        }
    }else{
      $(".tb_index").eq(clickedIndex-5).addClass("active");
      $(".tb_page").eq(clickedIndex-5).addClass('tb_active');
       $(".tb_index").eq(clickedIndex-5).addClass("active");
       if(clickedIndex==5){
          $('.tb_back').addClass('disabled');
        }else if(clickedIndex==9){
          $('.tb_prev').addClass('disabled');
        }
    }
  });


    $(".tb_index2").click(function(event) {
    $('.tb_active2').removeClass('tb_active2');
    $('.tb_back2').removeClass('disabled');
    $('.tb_prev2').removeClass('disabled');
    $(".tb_index2").removeClass('active');
    var clickedIndex = $(".tb_index2").index($(this));
    $(this).addClass("active");
    if(clickedIndex<5){
      $(".tb_index2").eq(clickedIndex+5).addClass("active");
      $(".tb_page2").eq(clickedIndex).addClass('tb_active2');
       $(".tb_index2").eq(clickedIndex).addClass("active");
       if(clickedIndex==0){
          $('.tb_back2').addClass('disabled');
        }else if(clickedIndex==4){
          $('.tb_prev2').addClass('disabled');
        }
    }else{
      $(".tb_index2").eq(clickedIndex-5).addClass("active");
      $(".tb_page2").eq(clickedIndex-5).addClass('tb_active2');
       $(".tb_index2").eq(clickedIndex-5).addClass("active");
       if(clickedIndex==5){
          $('.tb_back2').addClass('disabled');
        }else if(clickedIndex==9){
          $('.tb_prev2').addClass('disabled');
        }
    }
  });



    $(".tb_index3").click(function(event) {
    $('.tb_active3').removeClass('tb_active3');
    $('.tb_back3').removeClass('disabled');
    $('.tb_prev3').removeClass('disabled');
    $(".tb_index3").removeClass('active');
    var clickedIndex = $(".tb_index3").index($(this));
    $(this).addClass("active");
    if(clickedIndex<5){
      $(".tb_index3").eq(clickedIndex+5).addClass("active");
      $(".tb_page3").eq(clickedIndex).addClass('tb_active3');
       $(".tb_index3").eq(clickedIndex).addClass("active");
       if(clickedIndex==0){
          $('.tb_back3').addClass('disabled');
        }else if(clickedIndex==4){
          $('.tb_prev3').addClass('disabled');
        }
    }else{
      $(".tb_index3").eq(clickedIndex-5).addClass("active");
      $(".tb_page3").eq(clickedIndex-5).addClass('tb_active3');
       $(".tb_index3").eq(clickedIndex-5).addClass("active");
       if(clickedIndex==5){
          $('.tb_back3').addClass('disabled');
        }else if(clickedIndex==9){
          $('.tb_prev3').addClass('disabled');
        }
    }
  });


      // $("#tr1").click(function(e) {
      //   $('[data-remodal-id=modal]').remodal().open();
      // });
      // $("#aaa").click(function(e) {
      //   $('[data-remodal-id=aaa]').remodal().open();
      // });


      $("#page1").on('click',".haisou",function () {

    	  var productid = $(this).parent().parent().find(".proid").eq(0).text();
        console.log($(this));
        console.log(productid);
        var quantity =$(this).parent().parent().find(".quan").eq(0).text();
        console.log(quantity);
        //var memid = $(':hidden[name="memid"]').val();
        //        button   td      tr         tbody  table    .panel-body #collapse1
        var test =$(this).parent().parent().parent().parent().parent().parent().parent().find("tr").eq(0);
        console.log(7);
        console.log(test);
        var orderno =test.find("th").eq(0).text();
        var memno = test.find(".memid").val();

        

        console.log("orderno"+orderno);
        console.log("memno"+memno);
    	  // var cnt = document.getElementById("count").innerHTML;
    	    // 

			    $.ajax({
			    	url: 'ZyutyuStockServlet',
			    	type: 'POST',
			    	dataType: 'json',
			    	data: {proid:productid,
			    			memid:memno,
			    			orderno:orderno,
			    			quantity:quantity},
			    })
			    .done(function(result) {
			    	console.log("success");
			    	document.getElementById("test").innerHTML=result;
			    })
			    .fail(function() {
			    	console.log("error");
			    })
			    .always(function() {
			    	console.log("complete");
			    });
			

        $('[data-remodal-id=modal]').remodal().open();
        // $(".remodal-confirm").click(function(){
        //   window.alert("aaa");
        // });

    	  });


 var wareid_1;
 var orderno_1;
 var proid_1;



 $("#Sokopage1").on('click',".deliOK",function (){
 	wareid_1 = $(':hidden[name="wareid"]').val();
 	orderno_1=$(this).parent().parent().find("td").eq(0).text();
 	proid_1=$(this).parent().parent().find("td").eq(1).text();
 	console.log("倉庫番号"+wareid_1);
 	console.log("注文番号"+orderno_1);
 	console.log("商品番号"+proid_1);

 	$('[data-remodal-id=modal]').remodal().open();

 });

 $("#Sokopage1").on('click',".deliStart",function (){
  wareid_1 = $(':hidden[name="wareid"]').val();
  orderno_1=$(this).parent().parent().find("td").eq(0).text();
  proid_1=$(this).parent().parent().find("td").eq(1).text();
  console.log("倉庫番号"+wareid_1);
  console.log("注文番号"+orderno_1);
  console.log("商品番号"+proid_1);

  $('[data-remodal-id=modal2]').remodal().open();

 });

//在庫のモーダル処理
 $("#test2").on('click','.complete', function(){
 	console.log("在庫のモーダル処理");
 	console.log("倉庫番号"+wareid_1);
 	console.log("注文番号"+orderno_1);
 	console.log("商品番号"+proid_1);
 	$.ajax({
			    	url: 'HaisouOKServlet',
			    	type: 'POST',
			    	dataType: 'json',
			    	data: {wareid:wareid_1,
			    			proid:proid_1,
			    			orderno:orderno_1,
                deliflag:1,
			    			},
			    })
			    .done(function() {

			    })
			    .fail(function() {
			    	console.log("error");
			    })
			    .always(function() {
			    	console.log("complete");
			    });
			   // reroad2(wareid_1);
         window.setTimeout(reroad2(wareid_1),2000);

 });

 $("#android2").on('click','.android2', function(){
  console.log("在庫のモーダル処理");
  console.log("倉庫番号"+wareid_1);
  console.log("注文番号"+orderno_1);
  console.log("商品番号"+proid_1);
  $.ajax({
            url: 'HaisouOKServlet',
            type: 'POST',
            dataType: 'json',
            data: {wareid:wareid_1,
                proid:proid_1,
                orderno:orderno_1,
                deliflag:1,
                },
          })
          .done(function() {

          })
          .fail(function() {
            console.log("error");
          })
          .always(function() {
            console.log("complete");
          });
         // reroad2(wareid_1);
         window.setTimeout(reroad5(wareid_1,orderno_1),3000);
         window.setTimeout(reroad5(wareid_1,orderno_1),5000);
         window.setTimeout(reroad5(wareid_1,orderno_1),8000);


 });

 //在庫のモーダル処理
 $("#android1").on('click','.android1', function(){
  console.log("在庫のモーダル処理");
  console.log("倉庫番号"+wareid_1);
  console.log("注文番号"+orderno_1);
  console.log("商品番号"+proid_1);
  $.ajax({
            url: 'HaisouOKServlet',
            type: 'POST',
            dataType: 'json',
            data: {wareid:wareid_1,
                proid:proid_1,
                orderno:orderno_1,
                deliflag:2,
                },
          })
          .done(function() {

          })
          .fail(function() {
            console.log("android1 error");
          })
          .always(function() {
            console.log("android1 complete");
          });
         // reroad2(wareid_1);
         window.setTimeout(reroad5(wareid_1,orderno_1),3000);
         window.setTimeout(reroad5(wareid_1,orderno_1),5000);
         window.setTimeout(reroad5(wareid_1,orderno_1),8000);

 });

  $("#haitatuStart").on('click','.delistart', function(){
  console.log("在庫のモーダル処理");
  console.log("倉庫番号"+wareid_1);
  console.log("注文番号"+orderno_1);
  console.log("商品番号"+proid_1);
  $.ajax({
            url: 'HaisouOKServlet',
            type: 'POST',
            dataType: 'json',
            data: {wareid:wareid_1,
                proid:proid_1,
                orderno:orderno_1,
                deliflag:2,
                },
          })
          .done(function() {

          })
          .fail(function() {
            console.log("error");
          })
          .always(function() {
            console.log("complete");
          });
         // reroad2(wareid_1);
         window.setTimeout(reroad2(wareid_1),2000);

 });


function reroad5(Wareid,orderno){
    $.ajax({
      url: 'AndroidSokoServlet',
      type: 'POST',
      dataType: 'json',
      data: {
          flag:"OK",
          wareid:Wareid,
          orderno:orderno
              },
    })
    .done(function(result) {
      console.log("配送OKの画面リロード");
      var a = result + "";
      var hairetu=a.split(",");
      document.getElementById("Sokopage1").innerHTML=hairetu[0];
      $(':hidden[name="wareid"]').val(hairetu[1]);

    })
    .fail(function() {
      console.log("配送OKの後の画面リロード失敗");
    })
    .always(function() {
      console.log("complete");
    });
  }




 	










  function reroad2(Wareid){
    $.ajax({
    	url: 'HiasouSokoServlet',
    	type: 'POST',
    	dataType: 'json',
    	data: {
			    flag:"OK",
			    wareid:Wareid
			    		},
    })
    .done(function(result) {
    	console.log("配送OKの画面リロード");
      var a = result + "";
      var hairetu=a.split(",");
    	document.getElementById("Sokopage1").innerHTML=hairetu[0];
      document.getElementById("Sokopage2").innerHTML=hairetu[1];

    })
    .fail(function() {
    	console.log("配送OKの後の画面リロード失敗");
    })
    .always(function() {
    	console.log("complete");
    });
  }


    function reroad3(Wareid){
    $.ajax({
      url: 'OrderingKanriServlet',
      type: 'POST',
      dataType: 'json',
      data: {
          flag:"OK",
              },
    })
    .done(function(result) {
      console.log("配送OKの画面リロード");
      var a = result + "";
      var hairetu=a.split(",");
      document.getElementById("Hatyupage1").innerHTML=hairetu[0];
      document.getElementById("Hatyupage1-nohin").innerHTML=hairetu[1];
    })
    .fail(function() {
      console.log("配送OKの後の画面リロード失敗");
    })
    .always(function() {
      console.log("complete");
    });
  }










//発注処理
 $("#Hatyupage1").on('click',".ordering",function () {

        var proid = $(this).parent().parent().find("td").eq(0).text();
        console.log("proid="+proid);
        var proname =$(this).parent().parent().find("td").eq(1).text();
        var quantity =$(this).parent().parent().find("td").eq(4).text();
        console.log("hatyu_kosu="+quantity);

          $.ajax({
            url: 'OrderingModalServlet',
            type: 'POST',
            dataType: 'json',
            data: {
                proid:proid,
                proname:proname,
                quantity:quantity},
          })
          .done(function(result) {
            console.log("success");
            document.getElementById("test3").innerHTML=result;
          })
          .fail(function() {
            console.log("error");
          })
          .always(function() {
            console.log("complete");
          });
      

        $('[data-remodal-id=modal]').remodal().open();
        // $(".remodal-confirm").click(function(){
        //   window.alert("aaa");
        // });

        });




 $("#test,#test3").on("keyup","",function(){
  var sum1 = parseInt($(this).parent().parent().find("#sum").text());
  var kosu1=$(this).parent().find("tr").eq(1).find("#kosu").val();
  var kosu2=$(this).parent().find("tr").eq(2).find("#kosu").val();
  var kosu3=$(this).parent().find("tr").eq(3).find("#kosu").val();
  var kosu4=$(this).parent().find("tr").eq(4).find("#kosu").val();
  var kosu5=$(this).parent().find("tr").eq(5).find("#kosu").val();
  var sum2=int(kosu1)+int(kosu2)+int(kosu3)+int(kosu4)+int(kosu5);
  console.log(kosu1);
  var sa = sum1-sum2;
  $("#sa").text("誤差"+sa+"個");


 })
  $("#test,#test3").on("change","",function(){
  var sum1 = parseInt($(this).parent().parent().find("#sum").text());
  var kosu1=$(this).parent().find("tr").eq(1).find("#kosu").val();
  var kosu2=$(this).parent().find("tr").eq(2).find("#kosu").val();
  var kosu3=$(this).parent().find("tr").eq(3).find("#kosu").val();
  var kosu4=$(this).parent().find("tr").eq(4).find("#kosu").val();
  var kosu5=$(this).parent().find("tr").eq(5).find("#kosu").val();
  var sum2=int(kosu1)+int(kosu2)+int(kosu3)+int(kosu4)+int(kosu5);
  console.log(kosu1);
  var sa = sum1-sum2;
  $("#sa").text("誤差"+sa+"個");


 })


$("#test3").on('click','.Hatyu', function(){
            var sum1 = parseInt($(this).parent().find("#sum").text());
            var kosu1=$(this).parent().find("tr").eq(1).find("#kosu").val();
            var kosu2=$(this).parent().find("tr").eq(2).find("#kosu").val();
            var kosu3=$(this).parent().find("tr").eq(3).find("#kosu").val();
            var kosu4=$(this).parent().find("tr").eq(4).find("#kosu").val();
            var kosu5=$(this).parent().find("tr").eq(5).find("#kosu").val();
            var flag = 0;

            var proid=$(":hidden[name='proid']").val();

            console.log("proid="+proid);


            var sum2=int(kosu1)+int(kosu2)+int(kosu3)+int(kosu4)+int(kosu5);
            console.log("sum2="+sum2);
            console.log("sum1="+sum1);
            if(sum1==sum2){
                    console.log("配送処理");
          $.ajax({
            url: 'OrderingHaisoCompleteServlet',
            type: 'POST',
            dataType: 'json',
            data: {
                kosu1:int(kosu1),
                kosu2:int(kosu2),
                kosu3:int(kosu3),
                kosu4:int(kosu4),
                kosu5:int(kosu5),
                proid:proid
                },
          })
          .done(function() {
            console.log("success");
          })
          .fail(function() {
            console.log("error");
          })
          .always(function() {
            console.log("complete");
          });

                    window.setTimeout(reroad3,1000);

            }else if(sum1<sum2){
              var q = sum2-sum1;
              console.log("エラー処理");
              window.alert("配送する個数が"+q+"個多いです");
            }else{
              var q = sum1-sum2;
              console.log("エラー処理");
              window.alert("配送する個数が"+q+"個少ないです");
            }
            
      });
















      



});




