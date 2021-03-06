var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var endpoint = '/gs-guide-websocket';
    var socket = new SockJS(endpoint);
    stompClient = Stomp.over(socket);
    // setConnected(true);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/stockinfos', function (data) {
            var parsed = JSON.parse(data.body);
            console.log(">>>>>> parsed: " + parsed)
            showStockInfo(parsed.symbol, parsed.price, parsed.trend);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/stockinfo.start", {});
}

function showStockInfo(symbol, price, arrow) {
    var imgSrc = 'img/arrow_' + arrow + '.png';
    $("#greetings").append("<tr><td>" + symbol + "</td><td>" + price + "</td><td><img src=" + imgSrc + "></td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});

