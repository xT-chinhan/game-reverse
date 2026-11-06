package com.byazt.vl;

import com.byazt.rz.oa;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME, 19})
public class n {
    public volatile long fs;
    public String l;
    public long n;
    public String q;
    public long qg;
    public long s;
    public String w;
    public String x;

    public n() {
    }

    public n(long j, long j2, long j3, String str, String str2, String str3, String str4) {
        this.n = j;
        this.qg = j2;
        this.s = j3;
        this.q = str;
        this.l = str2;
        this.w = str3;
        this.x = str4;
    }

    public JSONObject n() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mDownloadId", this.n);
            jSONObject.put("mAdId", this.qg);
            jSONObject.put("mExtValue", this.s);
            jSONObject.put("mPackageName", this.q);
            jSONObject.put("mAppName", this.l);
            jSONObject.put("mLogExtra", this.w);
            jSONObject.put("mFileName", this.x);
            jSONObject.put("mTimeStamp", this.fs);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static n n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        n nVar = new n();
        try {
            nVar.n = oa.n(jSONObject, "mDownloadId");
            nVar.qg = oa.n(jSONObject, "mAdId");
            nVar.s = oa.n(jSONObject, "mExtValue");
            nVar.q = jSONObject.optString("mPackageName");
            nVar.l = jSONObject.optString("mAppName");
            nVar.w = jSONObject.optString("mLogExtra");
            nVar.x = jSONObject.optString("mFileName");
            nVar.fs = oa.n(jSONObject, "mTimeStamp");
            return nVar;
        } catch (Exception unused) {
            return null;
        }
    }
}
