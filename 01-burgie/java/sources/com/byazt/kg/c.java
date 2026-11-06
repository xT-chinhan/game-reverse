package com.byazt.kg;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.db.constant.Common;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 421, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends pr {
    public boolean g;
    public String k;
    public String m;

    public c(String str, boolean z, String str2) {
        this.m = str;
        this.g = z;
        this.k = str2;
        this.vk = 0;
    }

    public c(String str, boolean z, String str2, int i) {
        this.m = str;
        this.g = z;
        this.k = str2;
        this.vk = i;
    }

    @Override // com.byazt.kg.pr
    public List<String> pr() {
        List<String> listPr = super.pr();
        ArrayList arrayList = new ArrayList(listPr.size());
        arrayList.addAll(listPr);
        arrayList.addAll(Arrays.asList(NotificationCompat.CATEGORY_EVENT, "varchar", "params", "varchar", "is_bav", "integer"));
        return arrayList;
    }

    @Override // com.byazt.kg.pr
    public int pr(Cursor cursor) {
        int iPr = super.pr(cursor);
        int i = iPr + 1;
        this.m = cursor.getString(iPr);
        int i2 = i + 1;
        this.k = cursor.getString(i);
        int i3 = i2 + 1;
        this.g = cursor.getInt(i2) == 1;
        return i3;
    }

    @Override // com.byazt.kg.pr
    public void pr(ContentValues contentValues) {
        super.pr(contentValues);
        contentValues.put(NotificationCompat.CATEGORY_EVENT, this.m);
        contentValues.put("params", this.k);
        contentValues.put("is_bav", Integer.valueOf(this.g ? 1 : 0));
    }

    @Override // com.byazt.kg.pr
    public void pr(JSONObject jSONObject) throws JSONException {
        super.pr(jSONObject);
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.m);
        jSONObject.put("params", this.k);
        jSONObject.put("is_bav", this.g);
    }

    @Override // com.byazt.kg.pr
    public JSONObject hw() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.hw);
        jSONObject.put("tea_event_index", this.hn);
        jSONObject.put("session_id", this.x);
        if (this.c > 0) {
            jSONObject.put(Common.System.USER_ID, this.c);
        }
        jSONObject.put("user_unique_id", TextUtils.isEmpty(this.uc) ? JSONObject.NULL : this.uc);
        if (!TextUtils.isEmpty(this.fw)) {
            jSONObject.put("ssid", this.fw);
        }
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.m);
        if (this.g) {
            jSONObject.put("is_bav", 1);
        }
        if (!TextUtils.isEmpty(this.k)) {
            jSONObject.put("params", new JSONObject(this.k));
        }
        jSONObject.put("datetime", this.w);
        if (!TextUtils.isEmpty(this.zo)) {
            jSONObject.put("ab_sdk_version", this.zo);
        }
        return jSONObject;
    }

    @Override // com.byazt.kg.pr
    public pr hw(JSONObject jSONObject) {
        super.hw(jSONObject);
        this.m = jSONObject.optString(NotificationCompat.CATEGORY_EVENT, null);
        this.k = jSONObject.optString("params", null);
        this.g = jSONObject.optBoolean("is_bav", false);
        return this;
    }

    @Override // com.byazt.kg.pr
    public String x() {
        return "eventv3";
    }

    @Override // com.byazt.kg.pr
    public String zo() {
        return this.m;
    }

    @Override // com.byazt.kg.pr
    public String aj() {
        return this.k;
    }
}
