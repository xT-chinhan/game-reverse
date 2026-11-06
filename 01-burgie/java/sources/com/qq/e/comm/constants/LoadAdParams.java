package com.qq.e.comm.constants;

import com.qq.e.comm.util.GDTLogger;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class LoadAdParams {
    private LoginType a;
    private String b;
    private String c;
    private String d;
    private Map<String, String> e;
    private JSONObject f;
    private final JSONObject g = new JSONObject();

    public Map getDevExtra() {
        return this.e;
    }

    public String getDevExtraJsonString() {
        try {
            Map<String, String> map = this.e;
            return (map == null || map.size() <= 0) ? "" : new JSONObject(this.e).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public JSONObject getExtraInfo() {
        return this.f;
    }

    @Deprecated
    public String getLoginAppId() {
        return this.b;
    }

    @Deprecated
    public String getLoginOpenid() {
        return this.c;
    }

    @Deprecated
    public LoginType getLoginType() {
        return this.a;
    }

    public JSONObject getParams() {
        return this.g;
    }

    @Deprecated
    public String getUin() {
        return this.d;
    }

    public void setDevExtra(Map<String, String> map) {
        this.e = map;
    }

    public void setExtraInfo(JSONObject jSONObject) {
        this.f = jSONObject;
    }

    @Deprecated
    public void setLoginAppId(String str) {
        this.b = str;
        GDTLogger.e("注意！LoadAdParams#setLoginAppId 已废弃");
    }

    @Deprecated
    public void setLoginOpenid(String str) {
        this.c = str;
        GDTLogger.e("注意！LoadAdParams#setLoginOpenid 已废弃");
    }

    @Deprecated
    public void setLoginType(LoginType loginType) {
        this.a = loginType;
        GDTLogger.e("注意！LoadAdParams#setLoginType 已废弃");
    }

    @Deprecated
    public void setUin(String str) {
        this.d = str;
        GDTLogger.e("注意！LoadAdParams#setUin 已废弃");
    }

    public String toString() {
        return "LoadAdParams{, loginType=" + this.a + ", loginAppId=" + this.b + ", loginOpenid=" + this.c + ", uin=" + this.d + ", passThroughInfo=" + this.e + ", extraInfo=" + this.f + AbstractJsonLexerKt.END_OBJ;
    }
}
