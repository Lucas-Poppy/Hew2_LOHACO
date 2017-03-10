
/* 画面のローディングが完了したら実行する */
$(window).on('load', function () {


$("#test").on('click','.remodal-confirm', function(){
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
                    var ajax = new XMLHttpRequest();
                    var url = "ReceiveKanriServlet";
                    url += "?kosu1="+int(kosu1)+"&kosu2="+int(kosu2)+"&kosu3="+int(kosu3)+"&kosu4="+int(kosu4)+"&kosu5="+int(kosu5);
                    url +="&proid="+proid+"&orderno="+orderno;
                    ajax.open("POST",url);
                    //     コールバック関数を登録する
                    ajax.onload = function (e) {
                      if (ajax.readyState === 4) {
                        if (ajax.status === 200) {
                          // 正常に接続できた
                          // カウントを取得して再表示する
                        } else {
                          window.alert("error:"+ajax.statusText);
                        }
                      }
                    };
                    // 送信実行、GETなので送信データなし
                    ajax.send(null);
                    window.setTimeout(reroad,1000);

            }else{
              console.log("エラー処理");
              window.alert("配送する個数が足りません");
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
    var ajax = new XMLHttpRequest();
                    var url = "ZyutyuTopServlet";
                    url += "?flag="+"OK";
                    ajax.open("POST",url);
                    //     コールバック関数を登録する
                    ajax.onload = function (e) {
                      if (ajax.readyState === 4) {
                        if (ajax.status === 200) {
                          // 正常に接続できた
                          // カウントを取得して再表示する
                          document.getElementById("page1").innerHTML=ajax.responseText;
                          console.log("reroad");
                        } else {
                          window.alert("error:"+ajax.statusText);
                        }
                      }
                    };
                    // 送信実行、GETなので送信データなし
                    ajax.send(null);
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


      // $("#tr1").click(function(e) {
      //   $('[data-remodal-id=modal]').remodal().open();
      // });
      // $("#aaa").click(function(e) {
      //   $('[data-remodal-id=aaa]').remodal().open();
      // });


      $("#page1").on('click',".haisou",function aaa() {

    	  var productid = $(this).parent().parent().find(".proid").eq(0).text();
        console.log($(this));
        console.log(productid)
        var quantity =$(this).parent().parent().find(".quan").eq(0).text();
        console.log(quantity);
        //var memid = $(':hidden[name="memid"]').val();
        //        button   td      tr         tbody  table     .table  .panel-body #collapse1
        var test =$(this).parent().parent().parent().parent().parent().parent().parent().parent().parent().find("tr").eq(1);
        console.log(test);
        var orderno =test.find("th").eq(0).text();
        var memno = test.find(".memid").val();

        

        console.log("orderno"+orderno);
        console.log("memno"+memno);
    	  // var cnt = document.getElementById("count").innerHTML;
    	    // GETで送信する
    	    var ajax = new XMLHttpRequest();
    	    var url = "ZyutyuStockServlet";
    	    url += "?proid="+productid+"&memid="+memno+"&orderno="+orderno+"&quantity="+quantity;
    	    ajax.open("POST",url);
    	    //     コールバック関数を登録する
    	    ajax.onload = function (e) {
    	      if (ajax.readyState === 4) {
    	        if (ajax.status === 200) {
    	          // 正常に接続できた
    	          // カウントを取得して再表示する
    	          document.getElementById("test").innerHTML=ajax.responseText;
    	        } else {
    	          window.alert("error:"+ajax.statusText);
    	        }
    	      }
    	    };
    	    // 送信実行、GETなので送信データなし
    	    ajax.send(null);

    	    // 当関数を一秒後に再起動する
    	    // window.setTimeout(aaa,1000);

        $('[data-remodal-id=modal]').remodal().open();
        // $(".remodal-confirm").click(function(){
        //   window.alert("aaa");
        // });

    	  });

      



});




