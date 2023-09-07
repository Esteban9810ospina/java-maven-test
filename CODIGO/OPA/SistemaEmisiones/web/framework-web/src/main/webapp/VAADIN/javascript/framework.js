var framework = framework || {};
framework.util = framework.util || {};

framework.util.SessionTimer = function (options){
  this.opts = options;
  this.opts.refreshInterval = 1000;
  this.opts.maxCounter = this.opts.timeOut / this.opts.refreshInterval;
}

framework.util.SessionTimer.prototype.start = function() {

  var that = this;

  window.clearInterval(that.id);
  that.reset();

  jQuery(document).on("mouseover", function() {
    that.reset();
  });
  
  that.id = window.setInterval(function(){
    that.counter++;
    if (that.counter > that.opts.maxCounter) {
      window.clearInterval(that.id);
      window.location.href = window.location.pathname + that.opts.destinationUrl;
    }
  }, that.opts.refreshInterval);
};

framework.util.SessionTimer.prototype.reset = function() {
  this.counter = 0;
};

$(function(){
    $("#txtNID").bind("cut copy paste",function(e) {
        e.preventDefault();
    });
});