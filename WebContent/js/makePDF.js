$(function () {
  
        html2canvas(document.getElementById("wrapper"), {
            onrendered: function (canvas) {
                var dataURI = canvas.toDataURL("image/jpeg");
                var pdf = new jsPDF();
                pdf.addImage(dataURI, 'JPEG', 0, 0);
                var renderString = pdf.output("datauristring");
                $("iframe").attr("src", renderString);
            }
        });        
});