package com.byazt.ko;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2319, 21})
public class x extends s {
    public final Context l;
    public final fs w;

    public x(Context context, fs fsVar) {
        super(false, false);
        this.l = context;
        this.w = fsVar;
    }

    @Override // com.byazt.ko.s
    public boolean n(JSONObject jSONObject) throws JSONException {
        jSONObject.put("sdk_version", 7814);
        jSONObject.put("sdk_version_name", "7.8.1.4");
        jSONObject.put("channel", this.w.cp());
        rv.n(jSONObject, "aid", this.w.tj());
        rv.n(jSONObject, "release_build", this.w.h());
        rv.n(jSONObject, "app_region", this.w.oa());
        rv.n(jSONObject, "app_language", this.w.d());
        rv.n(jSONObject, "user_agent", this.w.t());
        rv.n(jSONObject, "ab_sdk_version", this.w.k());
        rv.n(jSONObject, "ab_version", this.w.um());
        rv.n(jSONObject, "aliyun_uuid", this.w.qg());
        String strHu = this.w.hu();
        if (!TextUtils.isEmpty(strHu)) {
            try {
                jSONObject.put("app_track", new JSONObject(strHu));
            } catch (Throwable th) {
                com.byazt.km.cp.qg(th);
            }
        }
        String strSz = this.w.sz();
        if (strSz != null && strSz.length() > 0) {
            jSONObject.put("custom", new JSONObject(strSz));
        }
        rv.n(jSONObject, "user_unique_id", this.w.cy());
        return true;
    }
}
