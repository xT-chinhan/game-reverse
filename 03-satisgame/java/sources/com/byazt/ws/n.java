package com.byazt.ws;

import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 890, 19})
public class n {
    public String n;
    public com.byazt.or.qg q;
    public String qg;
    public String s;

    public n(String str, String str2, String str3) {
        this.n = str;
        this.qg = str2;
        this.s = str3;
        this.q = new com.byazt.or.qg();
    }

    public n(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        this.n = str;
        this.qg = str2;
        this.s = str3;
        this.q = new com.byazt.or.qg(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12);
    }

    public String n() {
        return this.n;
    }

    public String qg() {
        return this.qg;
    }

    public String s() {
        return this.s;
    }

    public com.byazt.or.qg q() {
        return this.q;
    }

    public boolean l() {
        com.byazt.or.qg qgVar = this.q;
        return qgVar != null && qgVar.q();
    }

    public String w() {
        com.byazt.or.qg qgVar = this.q;
        if (qgVar != null) {
            return qgVar.qg();
        }
        return null;
    }

    public static n n(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("app_id");
        String strOptString2 = jSONObject.optString(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.APP_KEY);
        String strOptString3 = jSONObject.optString("custom_type");
        if (!TextUtils.equals(strOptString3, "1")) {
            return new n(str, strOptString, strOptString2);
        }
        return new n(str, strOptString, strOptString2, jSONObject.optString("init_class_name"), jSONObject.optString("banner_class_name"), jSONObject.optString("interstitial_class_name"), jSONObject.optString("reward_class_name"), jSONObject.optString("full_video_class_name"), jSONObject.optString("splash_class_name"), jSONObject.optString("feed_class_name"), jSONObject.optString("draw_class_name"), strOptString3);
    }

    public String toString() {
        return "AdNetworkConfValue{mAdnName='" + this.n + "'mAppId='" + this.qg + "', mAppKey='" + this.s + "', mGMCustomConfig=" + this.q + AbstractJsonLexerKt.END_OBJ;
    }
}
