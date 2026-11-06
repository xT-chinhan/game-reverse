package com.bytedance.sdk.component.widget.web;

import android.webkit.JavascriptInterface;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.zb.ah;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class xr extends ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final com.bytedance.sdk.component.zb.ms f1540ms;
    private final WebViewImpl xr;

    public xr(Object obj, String str, com.bytedance.sdk.component.zb.ms msVar, WebViewImpl webViewImpl) {
        super(obj, str);
        this.f1540ms = msVar;
        this.xr = webViewImpl;
    }

    private boolean ms(JSONObject jSONObject) {
        JSONObject jSONObjectXr = xr(jSONObject, "addWebviewListener");
        if (jSONObjectXr == null) {
            return false;
        }
        String strOptString = jSONObjectXr.optString(NotificationCompat.CATEGORY_EVENT);
        if (strOptString == null || strOptString.length() <= 0) {
            return true;
        }
        this.f1540ms.ms(this.xr, strOptString);
        return true;
    }

    private boolean xr(JSONObject jSONObject) {
        JSONObject jSONObjectXr = xr(jSONObject, "removeWebviewListener");
        if (jSONObjectXr == null) {
            return false;
        }
        String strOptString = jSONObjectXr.optString(NotificationCompat.CATEGORY_EVENT);
        if (strOptString == null || strOptString.length() <= 0) {
            return true;
        }
        this.f1540ms.xr(this.xr, strOptString);
        return true;
    }

    private boolean ah(JSONObject jSONObject) {
        JSONObject jSONObjectXr = xr(jSONObject, "sendWebviewEvent");
        if (jSONObjectXr == null) {
            return false;
        }
        String strOptString = jSONObjectXr.optString(NotificationCompat.CATEGORY_EVENT);
        if (strOptString == null) {
            return true;
        }
        this.f1540ms.ms(this.xr, xr(), strOptString, jSONObjectXr.opt("param"));
        return true;
    }

    @Override // com.bytedance.sdk.component.widget.web.ms
    @JavascriptInterface
    public Object invokeMethod(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            if (str.contains("popWebview")) {
                if (ka(new JSONObject(str))) {
                    return null;
                }
            } else if (str.contains("pushWebview")) {
                if (d(new JSONObject(str))) {
                    return null;
                }
            } else if (str.contains("addWebviewListener")) {
                if (ms(new JSONObject(str))) {
                    return null;
                }
            } else if (str.contains("removeWebviewListener")) {
                if (xr(new JSONObject(str))) {
                    return null;
                }
            } else {
                if (str.contains("sendWebviewEvent")) {
                    if (ah(new JSONObject(str))) {
                        return null;
                    }
                }
                return super.invokeMethod(str);
            }
        } catch (JSONException unused) {
        }
        return super.invokeMethod(str);
    }

    private boolean d(JSONObject jSONObject) {
        JSONObject jSONObjectXr = xr(jSONObject, "pushWebview");
        if (jSONObjectXr == null) {
            return false;
        }
        int iMs = this.f1540ms.ms(jSONObjectXr.optString("url"));
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("error_code", Integer.valueOf(iMs));
            jSONObject2.putOpt("result", Boolean.valueOf(iMs == 0));
        } catch (Exception unused) {
        }
        this.xr.ms(xr(), jSONObject.optString("__callback_id"), jSONObject2);
        return true;
    }

    private boolean ka(JSONObject jSONObject) {
        if (!ms(jSONObject, "popWebview")) {
            return false;
        }
        ah ahVarMs = this.f1540ms.ms();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("error_code", Integer.valueOf(ahVarMs == null ? 1 : 0));
            jSONObject2.putOpt("result", Boolean.valueOf(ahVarMs != null));
        } catch (Exception unused) {
        }
        this.xr.ms(xr(), jSONObject.optString("__callback_id"), jSONObject2);
        return true;
    }

    private boolean ms(JSONObject jSONObject, String str) {
        return jSONObject.optString("func").equals(str);
    }

    private JSONObject xr(JSONObject jSONObject, String str) {
        if (ms(jSONObject, str)) {
            return jSONObject.optJSONObject("params");
        }
        return null;
    }
}
