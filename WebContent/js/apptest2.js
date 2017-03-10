/* 画面のローディングが完了したら実行する */
$(window).on('load', function () {
	var memno = "";
	$("#pane3-page1").on('click',".tyumon",function(){
		$('[data-remodal-id=modal2]').remodal().open();
		memno=$(this).parent().parent().find("th").eq(0).text();
		console.log("memno"+memno);
	});

	$("#test2").on('click','.tekityumon',function(){

				$.ajax({
		    	url: 'TekiTyumonServlet',
		    	type: 'POST',
		    	dataType: 'json',
		    	data: {
					    memno:memno,
					    		},
		    })
		    .done(function() {
		    })
		    .fail(function() {
		    	console.log("失敗でOK");
		    })
		    .always(function() {
		    	console.log("complete");
		    });
		    window.setTimeout(reroad,2000);


	});




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





  $("#Sokopage2").on('click','.print',function(){
  	var address = $(this).parent().parent().parent().find("th").eq(4).text();
  	var Kname = $(this).parent().parent().parent().find("th").eq(2).text();
  	var orderno = $(this).parent().parent().parent().find("th").eq(0).text();
	var wareid = $(':hidden[name="wareid"]').val();
	var Knumber = $(this).parent().parent().parent().find("th").eq(3).text();

	var parentid = $(this).parent().attr('id');
  	console.log(address);


  	$('<input>').attr({
    type: 'hidden',
    id: 'address',
    name:'address',
    value: address
	}).appendTo('#'+parentid);

	$('<input>').attr({
    type: 'hidden',
    id: 'Kname',
    name:'Kname',
    value: Kname
	}).appendTo('#'+parentid);

	$('<input>').attr({
    type: 'hidden',
    id: 'orderno',
    name:'orderno',
    value: orderno
	}).appendTo('#'+parentid);

	$('<input>').attr({
    type: 'hidden',
    id: 'wareid',
    name:'wareid',
    value: wareid
	}).appendTo('#'+parentid);

	$('<input>').attr({
    type: 'hidden',
    id: 'Knumber',
    name:'Knumber',
    value: Knumber
	}).appendTo('#'+parentid);

  	// $.ajax({
   //  	url: 'DenpyoServlet',
   //  	type: 'POST',
   //  	dataType: 'json',
   //  	data: {
			//     address:address,
			//     Kname:Kname,
			//     orderno:orderno,
			//     wareid:wareid,
			//     Knumber:Knumber,
			//     		},
   //  })
   //  .done(function() {

   //  })
   //  .fail(function() {
   //  	console.log("失敗でOK");
   //  })
   //  .always(function() {
   //  	console.log("complete");

   //  });




	// window_obj = window.open( "denpyo.html","_blank");
  });

	



});