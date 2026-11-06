package com.byazt.qza;

import android.webkit.JavascriptInterface;
import androidx.core.app.NotificationCompat;
import com.anythink.core.common.l.f;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.gms.common.internal.ImagesContract;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_TIME_BAR_PERCENTAGE, 26})
public final class qg extends n {
    public final com.byazt.uad.qg n;
    public final WebViewImpl qg;

    public qg(Object obj, String str, com.byazt.uad.qg qgVar, WebViewImpl webViewImpl) {
        super(obj, str);
        this.n = qgVar;
        this.qg = webViewImpl;
    }

    private boolean n(JSONObject jSONObject) {
        JSONObject jSONObjectQg = qg(jSONObject, "addWebviewListener");
        if (jSONObjectQg == null) {
            return false;
        }
        String strOptString = jSONObjectQg.optString(NotificationCompat.CATEGORY_EVENT);
        if (strOptString == null || strOptString.length() <= 0) {
            return true;
        }
        this.n.n(this.qg, strOptString);
        com.byazt.uad.n.n(this.qg, strOptString);
        return true;
    }

    private boolean qg(JSONObject jSONObject) {
        JSONObject jSONObjectQg = qg(jSONObject, "removeWebviewListener");
        if (jSONObjectQg == null) {
            return false;
        }
        String strOptString = jSONObjectQg.optString(NotificationCompat.CATEGORY_EVENT);
        if (strOptString == null || strOptString.length() <= 0) {
            return true;
        }
        this.n.qg(this.qg, strOptString);
        com.byazt.uad.n.qg(this.qg, strOptString);
        return true;
    }

    private boolean s(JSONObject jSONObject) {
        JSONObject jSONObjectQg = qg(jSONObject, "sendWebviewEvent");
        if (jSONObjectQg == null) {
            return false;
        }
        String strOptString = jSONObjectQg.optString(NotificationCompat.CATEGORY_EVENT);
        if (strOptString == null) {
            return true;
        }
        Object objOpt = jSONObjectQg.opt("param");
        this.n.n(this.qg, qg(), strOptString, objOpt);
        com.byazt.uad.n.n(this.qg, qg(), strOptString, objOpt);
        return true;
    }

    @Override // com.byazt.qza.n
    @JavascriptInterface
    public Object invokeMethod(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            if (str.contains("popWebview")) {
                if (l(new JSONObject(str))) {
                    return null;
                }
            } else if (str.contains("pushWebview")) {
                if (q(new JSONObject(str))) {
                    return null;
                }
            } else if (str.contains("showBackButton")) {
                if (w(new JSONObject(str))) {
                    return null;
                }
            } else if (str.contains("addWebviewListener")) {
                if (n(new JSONObject(str))) {
                    return null;
                }
            } else if (str.contains("removeWebviewListener")) {
                if (qg(new JSONObject(str))) {
                    return null;
                }
            } else {
                if (str.contains("sendWebviewEvent")) {
                    if (s(new JSONObject(str))) {
                        return null;
                    }
                }
                return super.invokeMethod(str);
            }
        } catch (JSONException unused) {
        }
        return super.invokeMethod(str);
    }

    private boolean q(JSONObject jSONObject) {
        JSONObject jSONObjectQg = qg(jSONObject, "pushWebview");
        if (jSONObjectQg == null) {
            return false;
        }
        int iN = this.n.n(jSONObjectQg.optString(ImagesContract.URL));
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("error_code", Integer.valueOf(iN));
            jSONObject2.putOpt("result", Boolean.valueOf(iN == 0));
        } catch (Exception unused) {
        }
        this.qg.n(qg(), jSONObject.optString("__callback_id"), jSONObject2);
        return true;
    }

    private boolean l(JSONObject jSONObject) {
        if (!n(jSONObject, "popWebview")) {
            return false;
        }
        com.byazt.uad.q qVarN = this.n.n();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("error_code", Integer.valueOf(qVarN == null ? 1 : 0));
            jSONObject2.putOpt("result", Boolean.valueOf(qVarN != null));
        } catch (Exception unused) {
        }
        this.qg.n(qg(), jSONObject.optString("__callback_id"), jSONObject2);
        return true;
    }

    private boolean n(JSONObject jSONObject, String str) {
        return jSONObject.optString("func").equals(str);
    }

    private JSONObject qg(JSONObject jSONObject, String str) {
        if (n(jSONObject, str)) {
            return jSONObject.optJSONObject("params");
        }
        return null;
    }

    private boolean w(JSONObject jSONObject) {
        JSONObject jSONObjectQg = qg(jSONObject, "showBackButton");
        if (jSONObjectQg == null) {
            return false;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (this.n.n(jSONObjectQg.optInt("show", 0) == 1)) {
                jSONObject2.putOpt("code", 0);
                jSONObject2.putOpt(f.R, new JSONObject());
            } else {
                jSONObject2.putOpt("code", 1);
                jSONObject2.putOpt(NotificationCompat.CATEGORY_MESSAGE, "back button overlay not found");
            }
        } catch (Exception unused) {
        }
        this.qg.n(qg(), jSONObject.optString("__callback_id"), jSONObject2);
        return true;
    }
}
