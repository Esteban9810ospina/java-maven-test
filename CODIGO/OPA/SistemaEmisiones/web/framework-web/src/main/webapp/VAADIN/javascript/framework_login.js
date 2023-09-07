var framework = framework || {};
framework.login = framework.login || {};

framework.login.init = function (){
  jQuery('#username').focus();
};

jQuery(function() {
  framework.login.init();
});

$(document).ready(function(){
    $("#username, #password").bind("cut copy paste",function(e) {
        e.preventDefault();
    });
});