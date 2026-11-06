package com.byazt.su;

import android.support.v4.app.NotificationCompat;
import android.webkit.JavascriptInterface;
import com.byazt.mg.PluginConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE, 13})
public final class hw extends pr {
    public final WebViewImpl hw;
    public final com.byazt.son.hw pr;

    public hw(Object obj, String str, com.byazt.son.hw hwVar, WebViewImpl webViewImpl) {
        super(obj, str);
        this.pr = hwVar;
        this.hw = webViewImpl;
    }

    private boolean pr(JSONObject jSONObject) {
        JSONObject jSONObjectHw = hw(jSONObject, "addWebviewListener");
        if (jSONObjectHw != null) {
            String strOptString = jSONObjectHw.optString(NotificationCompat.CATEGORY_EVENT);
            if (strOptString != null && strOptString.length() > 0) {
                this.pr.pr(this.hw, strOptString);
                com.byazt.son.pr.pr(this.hw, strOptString);
                return true;
            }
            return true;
        }
        return false;
    }

    private boolean hw(JSONObject jSONObject) {
        JSONObject jSONObjectHw = hw(jSONObject, "removeWebviewListener");
        if (jSONObjectHw != null) {
            String strOptString = jSONObjectHw.optString(NotificationCompat.CATEGORY_EVENT);
            if (strOptString != null && strOptString.length() > 0) {
                this.pr.hw(this.hw, strOptString);
                com.byazt.son.pr.hw(this.hw, strOptString);
                return true;
            }
            return true;
        }
        return false;
    }

    private boolean hn(JSONObject jSONObject) {
        JSONObject jSONObjectHw = hw(jSONObject, "sendWebviewEvent");
        if (jSONObjectHw != null) {
            String strOptString = jSONObjectHw.optString(NotificationCompat.CATEGORY_EVENT);
            if (strOptString != null) {
                Object objOpt = jSONObjectHw.opt("param");
                this.pr.pr(this.hw, hw(), strOptString, objOpt);
                com.byazt.son.pr.pr(this.hw, hw(), strOptString, objOpt);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.byazt.su.pr
    @JavascriptInterface
    public Object invokeMethod(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.contains("popWebview")) {
            try {
                if (c(new JSONObject(str))) {
                    return null;
                }
            } catch (JSONException e) {
            }
        } else if (str.contains("pushWebview")) {
            try {
                if (x(new JSONObject(str))) {
                    return null;
                }
            } catch (JSONException e2) {
            }
        } else if (str.contains("showBackButton")) {
            try {
                if (uc(new JSONObject(str))) {
                    return null;
                }
            } catch (JSONException e3) {
            }
        } else if (str.contains("addWebviewListener")) {
            try {
                if (pr(new JSONObject(str))) {
                    return null;
                }
            } catch (JSONException e4) {
            }
        } else if (str.contains("removeWebviewListener")) {
            try {
                if (hw(new JSONObject(str))) {
                    return null;
                }
            } catch (JSONException e5) {
            }
        } else if (str.contains("sendWebviewEvent")) {
            try {
                if (hn(new JSONObject(str))) {
                    return null;
                }
            } catch (JSONException e6) {
            }
        }
        return super.invokeMethod(str);
    }

    private boolean x(JSONObject jSONObject) {
        JSONObject jSONObjectHw = hw(jSONObject, "pushWebview");
        boolean z = false;
        if (jSONObjectHw == null) {
            return false;
        }
        int iPr = this.pr.pr(jSONObjectHw.optString(BreakpointSQLiteKey.URL));
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt(Constants.ERROR_CODE_FIELD, Integer.valueOf(iPr));
            if (iPr == 0) {
                z = true;
            }
            jSONObject2.putOpt("result", Boolean.valueOf(z));
        } catch (Exception e) {
        }
        this.hw.pr(hw(), jSONObject.optString("__callback_id"), jSONObject2);
        return true;
    }

    private boolean c(JSONObject jSONObject) {
        if (!pr(jSONObject, "popWebview")) {
            return false;
        }
        com.byazt.son.x xVarPr = this.pr.pr();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt(Constants.ERROR_CODE_FIELD, Integer.valueOf(xVarPr == null ? 1 : 0));
            jSONObject2.putOpt("result", Boolean.valueOf(xVarPr != null));
        } catch (Exception e) {
        }
        this.hw.pr(hw(), jSONObject.optString("__callback_id"), jSONObject2);
        return true;
    }

    private boolean pr(JSONObject jSONObject, String str) {
        return jSONObject.optString("func").equals(str);
    }

    private JSONObject hw(JSONObject jSONObject, String str) {
        if (pr(jSONObject, str)) {
            return jSONObject.optJSONObject("params");
        }
        return null;
    }

    private boolean uc(JSONObject jSONObject) {
        boolean z;
        JSONObject jSONObjectHw = hw(jSONObject, "showBackButton");
        if (jSONObjectHw == null) {
            return false;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (jSONObjectHw.optInt("show", 0) != 1) {
                z = false;
            } else {
                z = true;
            }
            if (this.pr.pr(z)) {
                jSONObject2.putOpt(PluginConstants.KEY_ERROR_CODE, 0);
                jSONObject2.putOpt("data", new JSONObject());
            } else {
                jSONObject2.putOpt(PluginConstants.KEY_ERROR_CODE, 1);
                jSONObject2.putOpt(NotificationCompat.CATEGORY_MESSAGE, "back button overlay not found");
            }
        } catch (Exception e) {
        }
        this.hw.pr(hw(), jSONObject.optString("__callback_id"), jSONObject2);
        return true;
    }
}
