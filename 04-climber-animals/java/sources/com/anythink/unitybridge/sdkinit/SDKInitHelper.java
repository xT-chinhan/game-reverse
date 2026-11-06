package com.anythink.unitybridge.sdkinit;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAreaCallback;
import com.anythink.core.api.ATGDPRConsentDismissListener;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.NetTrafficeCallback;
import com.anythink.unitybridge.MsgTools;
import com.anythink.unitybridge.UnityPluginUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SDKInitHelper {
    private static final String SP_KEY_FIRST_RUN = "SP_KEY_FIRST_RUN";
    public static final String TAG = "AT_android_unity3d";
    Activity mActivity;
    SDKInitListener mSDKInitListener;

    @Deprecated
    public void addNetworkGDPRInfo(int i, String str) {
    }

    public SDKInitHelper(SDKInitListener sDKInitListener) {
        if (sDKInitListener == null) {
            MsgTools.printMsg("pSDKInitListener == null ..");
        }
        this.mSDKInitListener = sDKInitListener;
        this.mActivity = UnityPluginUtils.getActivity("SDKInitHelper");
    }

    public void initAppliction(String str, String str2) {
        if (this.mActivity == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            MsgTools.printMsg("initAppliction--> sActivity == null || appid == null || appkey == null");
            SDKInitListener sDKInitListener = this.mSDKInitListener;
            if (sDKInitListener != null) {
                sDKInitListener.initSDKError(str, "activity can not be null ");
                return;
            }
            return;
        }
        MsgTools.printMsg("initAppliction--> appid:" + str);
        ATSDK.setSystemDevFragmentType("2");
        ATSDK.init(this.mActivity, str, str2);
        SDKInitListener sDKInitListener2 = this.mSDKInitListener;
        if (sDKInitListener2 != null) {
            sDKInitListener2.initSDKSuccess(str);
        }
    }

    public void showDebuggerUI() {
        showDebuggerUI("");
    }

    public void showDebuggerUI(String str) {
        try {
            Class.forName("com.anythink.debug.api.ATDebuggerUITest").getMethod("showDebuggerUI", Context.class, String.class).invoke(null, this.mActivity, str);
        } catch (Throwable th) {
            Log.e("AT_android_unity3d", "showDebuggerUI() >>> failed: " + th.getMessage());
        }
    }

    public void setDebugLogOpen(boolean z) {
        MsgTools.printMsg("setDebugLogOpen--> :" + z);
        ATSDK.setNetworkLogDebug(z);
        MsgTools.isDebug = z;
    }

    public void setChannel(String str) {
        MsgTools.printMsg("setChannel--> :" + str);
        ATSDK.setChannel(str);
    }

    public void setSubChannel(String str) {
        MsgTools.printMsg("setSubChannel--> :" + str);
        ATSDK.setSubChannel(str);
    }

    public void initCustomMap(String str) {
        MsgTools.printMsg(new StringBuilder("initCustomMap--> :").append(str).toString() != null ? str : "");
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject.opt(next));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ATSDK.initCustomMap(map);
    }

    public void initPlacementCustomMap(String str, String str2) {
        MsgTools.printMsg(new StringBuilder("initPlacementCustomMap-->").append(str).append(":").append(str2).toString() != null ? str2 : "");
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject.opt(next));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ATSDK.initPlacementCustomMap(str, map);
    }

    public int getGDPRLevel() {
        MsgTools.printMsg("getGDPRLevel");
        return ATSDK.getGDPRDataLevel(this.mActivity);
    }

    public boolean isEUTraffic() {
        MsgTools.printMsg("isEUTraffic");
        return ATSDK.isEUTraffic(this.mActivity);
    }

    public void setGDPRLevel(int i) {
        MsgTools.printMsg("setGDPRLevel--> level:" + i);
        ATSDK.setGDPRUploadDataLevel(this.mActivity, i);
    }

    public void checkIsEuTraffic(final SDKEUCallbackListener sDKEUCallbackListener) {
        MsgTools.printMsg("checkIsEuTraffic");
        ATSDK.checkIsEuTraffic(this.mActivity, new NetTrafficeCallback() { // from class: com.anythink.unitybridge.sdkinit.SDKInitHelper.1
            @Override // com.anythink.core.api.NetTrafficeCallback
            public void onResultCallback(boolean z) {
                MsgTools.printMsg("check EU:" + z);
                SDKEUCallbackListener sDKEUCallbackListener2 = sDKEUCallbackListener;
                if (sDKEUCallbackListener2 != null) {
                    sDKEUCallbackListener2.onResultCallback(z);
                }
            }

            @Override // com.anythink.core.api.NetTrafficeCallback
            public void onErrorCallback(String str) {
                MsgTools.printMsg("check EU error:" + str);
                SDKEUCallbackListener sDKEUCallbackListener2 = sDKEUCallbackListener;
                if (sDKEUCallbackListener2 != null) {
                    sDKEUCallbackListener2.onErrorCallback(str);
                }
            }
        });
    }

    public void showGDPRAuth() {
        MsgTools.printMsg("showGDPRAuth ");
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.anythink.unitybridge.sdkinit.SDKInitHelper.2
            @Override // java.lang.Runnable
            public void run() {
                ATSDK.showGdprAuth(SDKInitHelper.this.mActivity);
            }
        });
    }

    public void showGDPRConsentDialog(final SDKConsentDismissListener sDKConsentDismissListener) {
        MsgTools.printMsg("showGDPRConsentDialog ");
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.anythink.unitybridge.sdkinit.SDKInitHelper.3
            @Override // java.lang.Runnable
            public void run() {
                ATSDK.showGDPRConsentDialog(SDKInitHelper.this.mActivity, new ATGDPRConsentDismissListener() { // from class: com.anythink.unitybridge.sdkinit.SDKInitHelper.3.1
                    @Override // com.anythink.core.api.ATGDPRConsentDismissListener
                    public void onDismiss(ATGDPRConsentDismissListener.ConsentDismissInfo consentDismissInfo) {
                        MsgTools.printMsg("showGDPRConsentDialog onDismiss: " + consentDismissInfo);
                        if (sDKConsentDismissListener != null) {
                            sDKConsentDismissListener.onConsentDismiss();
                        }
                    }
                });
            }
        });
    }

    public void deniedUploadDeviceInfo(String str) {
        MsgTools.printMsg("deniedUploadDeviceInfo: " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            if (length > 0) {
                String[] strArr = new String[length];
                for (int i = 0; i < length; i++) {
                    strArr[i] = jSONArray.getString(i);
                }
                ATSDK.deniedUploadDeviceInfo(strArr);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setExcludeBundleIdArray(String str) {
        MsgTools.printMsg("setExcludeBundleIdArray: " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            if (length > 0) {
                ArrayList arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                ATSDK.setExcludePackageList(arrayList);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setExcludeAdSourceIdArrayForPlacementID(String str, String str2) {
        MsgTools.printMsg("setExcludeAdSourceIdArrayForPlacementID: " + str + ", " + str2);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str2);
            int length = jSONArray.length();
            if (length > 0) {
                ArrayList arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                ATSDK.setFilterAdSourceIdList(str, arrayList);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Deprecated
    public void setSDKArea(int i) {
        MsgTools.printMsg("（Deprecated）setSDKArea: " + i);
    }

    public void getArea(final AreaCallbackListener areaCallbackListener) {
        MsgTools.printMsg("getArea");
        ATSDK.getArea(new ATAreaCallback() { // from class: com.anythink.unitybridge.sdkinit.SDKInitHelper.4
            @Override // com.anythink.core.api.ATAreaCallback
            public void onResultCallback(String str) {
                MsgTools.printMsg("getArea:" + str);
                AreaCallbackListener areaCallbackListener2 = areaCallbackListener;
                if (areaCallbackListener2 != null) {
                    areaCallbackListener2.onResultCallback(str);
                }
            }

            @Override // com.anythink.core.api.ATAreaCallback
            public void onErrorCallback(String str) {
                MsgTools.printMsg("getArea:" + str);
                AreaCallbackListener areaCallbackListener2 = areaCallbackListener;
                if (areaCallbackListener2 != null) {
                    areaCallbackListener2.onErrorCallback(str);
                }
            }
        });
    }

    public void setWXStatus(boolean z) {
        MsgTools.printMsg("setWXStatus: " + z);
        ATSDK.setWXStatus(z);
    }

    public void setLocation(double d, double d2) {
        MsgTools.printMsg("setLocation: " + d + ", " + d2);
        Location location = new Location("");
        location.setLatitude(d2);
        location.setLongitude(d);
        ATSDK.setLocation(location);
    }
}
