// Empty constructor
function SimplePlugin() {}

// The function that passes work along to native shells
// Message is a string, duration may be 'long' or 'short'
SimplePlugin.prototype.show = function(successCallback, errorCallback) {
  var options = {};
  cordova.exec(successCallback, errorCallback, 'SimplePlugin', 'show', [options]);
}

// Installation constructor that binds ToastyPlugin to window
SimplePlugin.install = function() {
  if (!window.plugins) {
    window.plugins = {};
  }
  window.plugins.simplePlugin = new SimplePlugin();
  return window.plugins.simplePlugin;
};
cordova.addConstructor(SimplePlugin.install);