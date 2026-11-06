package com.ss.android.downloadlib.addownload.xr;

import com.ss.android.downloadlib.ab.zb;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ms {
    public String ab;
    public long ah;
    public String c;
    public String d;
    public String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public long f4455ms;
    public volatile long x;
    public long xr;

    public ms() {
    }

    public ms(long j, long j2, long j3, String str, String str2, String str3, String str4) {
        this.f4455ms = j;
        this.xr = j2;
        this.ah = j3;
        this.d = str;
        this.ka = str2;
        this.c = str3;
        this.ab = str4;
    }

    public JSONObject ms() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mDownloadId", this.f4455ms);
            jSONObject.put("mAdId", this.xr);
            jSONObject.put("mExtValue", this.ah);
            jSONObject.put("mPackageName", this.d);
            jSONObject.put("mAppName", this.ka);
            jSONObject.put("mLogExtra", this.c);
            jSONObject.put("mFileName", this.ab);
            jSONObject.put("mTimeStamp", this.x);
        } catch (JSONException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        return jSONObject;
    }

    public static ms ms(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ms msVar = new ms();
        try {
            msVar.f4455ms = zb.ms(jSONObject, "mDownloadId");
            msVar.xr = zb.ms(jSONObject, "mAdId");
            msVar.ah = zb.ms(jSONObject, "mExtValue");
            msVar.d = jSONObject.optString("mPackageName");
            msVar.ka = jSONObject.optString("mAppName");
            msVar.c = jSONObject.optString("mLogExtra");
            msVar.ab = jSONObject.optString("mFileName");
            msVar.x = zb.ms(jSONObject, "mTimeStamp");
            return msVar;
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return null;
        }
    }
}
