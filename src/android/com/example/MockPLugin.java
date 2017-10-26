/**
 */
package com.example;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;

import java.util.Date;

public class MockPlugin extends CordovaPlugin {
  private static final String TAG = "MockPlugin";

  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);

    Log.d(TAG, "Initializing MockPlugin");
  }

  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    //Get Context
    Context context = this.cordova.getActivity().getApplicationContext();

    this.cordova.getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

    if(action.equals("isMockSettingsOn")) {
      boolean isMock;
//      if(Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN_MR2) { // Si > Android 4.3 // Api 18
//        Location location = new Location("");
//        isMock = location.isFromMockProvider();
//      } else {
        if (Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ALLOW_MOCK_LOCATION).equals("0")) { // Always return false after API 23+ // >= Marshmallow
          isMock = false;
        } else {
          isMock = true;
        }
      //}
      // returns true if mock location enabled, false if not enabled.
      callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, isMock));
    }
    return true;
  }

}
