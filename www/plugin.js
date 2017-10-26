
var exec = require('cordova/exec');

var PLUGIN_NAME = 'MockPLugin';

var MockPLugin = {
  isMockSettingsOn: function(cb) {
    exec(cb, null, PLUGIN_NAME, 'isMockSettingsOn', []);
  }
};

module.exports = MockPLugin;
