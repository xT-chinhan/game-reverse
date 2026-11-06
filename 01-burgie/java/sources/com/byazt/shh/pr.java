package com.byazt.shh;

import com.byazt.uk.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DOWNLOAD_BYTES, 37})
public class pr {
    public String c;
    public String fw;
    public long hn;
    public long hw;
    public long pr;
    public String uc;
    public String x;
    public volatile long zo;

    public pr() {
    }

    public pr(long j, long j2, long j3, String str, String str2, String str3, String str4) {
        this.pr = j;
        this.hw = j2;
        this.hn = j3;
        this.x = str;
        this.c = str2;
        this.uc = str3;
        this.fw = str4;
    }

    public JSONObject pr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mDownloadId", this.pr);
            jSONObject.put("mAdId", this.hw);
            jSONObject.put("mExtValue", this.hn);
            jSONObject.put("mPackageName", this.x);
            jSONObject.put("mAppName", this.c);
            jSONObject.put("mLogExtra", this.uc);
            jSONObject.put("mFileName", this.fw);
            jSONObject.put("mTimeStamp", this.zo);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public static pr pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        pr prVar = new pr();
        try {
            prVar.pr = m.pr(jSONObject, "mDownloadId");
            prVar.hw = m.pr(jSONObject, "mAdId");
            prVar.hn = m.pr(jSONObject, "mExtValue");
            prVar.x = jSONObject.optString("mPackageName");
            prVar.c = jSONObject.optString("mAppName");
            prVar.uc = jSONObject.optString("mLogExtra");
            prVar.fw = jSONObject.optString("mFileName");
            prVar.zo = m.pr(jSONObject, "mTimeStamp");
            return prVar;
        } catch (Exception e) {
            return null;
        }
    }
}
