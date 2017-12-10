
$('#datetimepicker1, #datetimepicker2').datetimepicker({
    format: "yyyy-MM-dd HH:mm:ss",
    language: 'pt-BR'
});


var pickName = function (name) {
    $('#dropButton').text(name);
};

var pickDirection = function (direction) {
    $('#directionButton').text(direction);
};


$('#SendButton').click(function () {
    var time1 = $('#time1').val();
    var time2 = $('#time2').val();
    var name = $('#dropButton').text();
    var direction = $('#directionButton').text();
    var url = '/calc/'+ time1 + '/' + time2+'/'+ name+'/'+direction;

    $.get(url, function(data) {
        $( "#row" ).show();
        $("#td1" ).text(data.trafficOctets);
        $("#td2" ).text(data.trafficCapacity);

    });
});

