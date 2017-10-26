
var exec = require('cordova/exec');

var PLUGIN_NAME = 'MockPlugin';

var MockPlugin = {
  isMockSettingsOn: function(cb) {
    exec(cb, null, PLUGIN_NAME, 'isMockSettingsOn', []);
  }
};

module.exports = MockPlugin;
