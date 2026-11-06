package com.byazt.yi;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.anythink.core.common.l.f;
import com.byazt.km.cp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 200, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj extends n {
    public long d;
    public int k = 0;
    public long oa;
    public String sz;

    @Override // com.byazt.yi.n
    public List<String> n() {
        return null;
    }

    @Override // com.byazt.yi.n
    public String q() {
        return "terminate";
    }

    @Override // com.byazt.yi.n
    public int n(Cursor cursor) {
        cp.qg((Throwable) null);
        return 0;
    }

    @Override // com.byazt.yi.n
    public void n(ContentValues contentValues) {
        cp.qg((Throwable) null);
    }

    @Override // com.byazt.yi.n
    public void n(JSONObject jSONObject) {
        cp.qg((Throwable) null);
    }

    @Override // com.byazt.yi.n
    public JSONObject qg() throws JSONException {
        w wVar;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.qg);
        jSONObject.put("tea_event_index", this.s);
        jSONObject.put(f.bo, this.q);
        jSONObject.put("stop_timestamp", this.oa / 1000);
        jSONObject.put(MediationConstant.EXTRA_DURATION, this.d / 1000);
        jSONObject.put("datetime", this.cp);
        if (this.l > 0) {
            jSONObject.put("user_id", this.l);
        }
        jSONObject.put("user_unique_id", TextUtils.isEmpty(this.w) ? JSONObject.NULL : this.w);
        if (!TextUtils.isEmpty(this.x)) {
            jSONObject.put("ssid", this.x);
        }
        if (!TextUtils.isEmpty(this.fs)) {
            jSONObject.put("ab_sdk_version", this.fs);
        }
        if (!TextUtils.isEmpty(this.sz)) {
            jSONObject.put("uuid_changed", true);
            if (!TextUtils.equals(this.sz, this.q)) {
                jSONObject.put("original_session_id", this.sz);
            }
        }
        if (this.k == 0 && (wVar = (w) qg.qg.get("launch")) != null && !wVar.a) {
            this.k = 6;
        }
        jSONObject.put("launch_from", this.k);
        return jSONObject;
    }

    @Override // com.byazt.yi.n
    public n qg(JSONObject jSONObject) {
        cp.qg((Throwable) null);
        return this;
    }

    @Override // com.byazt.yi.n
    public String fs() {
        return String.valueOf(this.d);
    }
}
