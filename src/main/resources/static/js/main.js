$(document).ready(function(){
    $('#primaryImage').change(function(event){
        var filePath = URL.createObjectURL(event.target.files[0]);
        $('#mainThumbnail').attr("src", filePath);
    });

    $("input[name='extraImage']").each(function(index) {
        $(this).change(function(event){
            var filePath = URL.createObjectURL(event.target.files[0]);
            $('#thumbnail' + index).attr("src", filePath);
        });
    });
});