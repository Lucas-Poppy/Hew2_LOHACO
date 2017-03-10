$(function(){
	$.ajax({
		url: 'test1',
		type: 'POST',
		dataType: 'json',
		data: {param1: 'value1'}
	})
	.done(function(result) {
		console.log(result);
		var a = result + "";
		console.log(a);
		var b = a.split(",");
		document.getElementById("aaa").innerHTML=b[0];
		document.getElementById("bbb").innerHTML=b[1];
	})
	.fail(function() {
		console.log("error");
	})
	.always(function() {
		console.log("complete");
	});
	
})