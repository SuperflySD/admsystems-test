
$('#datetimepicker1, #datetimepicker2').datetimepicker({
    format: "yyyy-MM-dd HH:mm:ss",
    language: 'pt-BR'
});


sync = function () {
        var time1 = $('#time1').val();
        var time2 = $('#time2').val();
        var url = '/sync/'+ time1 + '/' + time2;
        window.location = url;

};

pickName = function (name) {
    $('#dropButton').text(name);

};