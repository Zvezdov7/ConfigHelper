$(".file").click(function(){
    $(".active").removeClass('active');
    $(this).addClass('active');
    var path = "http://localhost:8080/ConfigHelper/file?filepath="
    var file = $(this).text();
    var uri = path + file;
    $.get(uri, function (data) {
        $("#filetext").val(data);
    });
});

$("#saveButton").click(function(){
    var data = $("#filetext").val();
    var path = "http://localhost:8080/ConfigHelper/file?filepath=";
    var file = $(".active").text();
    var uri = path + file;
    $.ajax({
        type: "POST",
        url: uri,
        data: data,
        contentType: "text/plain;charset=UTF-8"
    });
});