package com.byazt.yi;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.anythink.core.common.l.f;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 200, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv extends n {
    public String a;
    public String cd;
    public String cy;
    public long d;
    public String hd;
    public String k;
    public String oa;
    public String sz;
    public int um;

    @Override // com.byazt.yi.n
    public String q() {
        return "page";
    }

    @Override // com.byazt.yi.n
    public List<String> n() {
        List<String> listN = super.n();
        ArrayList arrayList = new ArrayList(listN.size());
        arrayList.addAll(listN);
        arrayList.addAll(Arrays.asList("page_key", "varchar", "refer_page_key", "varchar", MediationConstant.EXTRA_DURATION, "integer", "is_back", "integer", "last_session", "varchar", "page_title", "varchar", "refer_page_title", "varchar", "page_path", "varchar", "referrer_page_path", "varchar"));
        return arrayList;
    }

    @Override // com.byazt.yi.n
    public int n(Cursor cursor) {
        int iN = super.n(cursor);
        int i = iN + 1;
        this.sz = cursor.getString(iN);
        int i2 = i + 1;
        this.oa = cursor.getString(i);
        int i3 = i2 + 1;
        this.d = cursor.getLong(i2);
        int i4 = i3 + 1;
        this.um = cursor.getInt(i3);
        int i5 = i4 + 1;
        this.a = cursor.getString(i4);
        int i6 = i5 + 1;
        this.k = cursor.getString(i5);
        int i7 = i6 + 1;
        this.cy = cursor.getString(i6);
        int i8 = i7 + 1;
        this.hd = cursor.getString(i7);
        int i9 = i8 + 1;
        this.cd = cursor.getString(i8);
        return i9;
    }

    @Override // com.byazt.yi.n
    public void n(ContentValues contentValues) {
        super.n(contentValues);
        contentValues.put("page_key", this.sz);
        contentValues.put("refer_page_key", this.oa);
        contentValues.put(MediationConstant.EXTRA_DURATION, Long.valueOf(this.d));
        contentValues.put("is_back", Integer.valueOf(this.um));
        contentValues.put("last_session", this.a);
        contentValues.put("page_title", this.k);
        contentValues.put("refer_page_title", this.cy);
        contentValues.put("page_path", this.hd);
        contentValues.put("referrer_page_path", this.cd);
    }

    @Override // com.byazt.yi.n
    public void n(JSONObject jSONObject) throws JSONException {
        super.n(jSONObject);
        jSONObject.put("page_key", this.sz);
        jSONObject.put("refer_page_key", this.oa);
        jSONObject.put(MediationConstant.EXTRA_DURATION, this.d);
        jSONObject.put("is_back", this.um);
        jSONObject.put("page_title", this.k);
        jSONObject.put("refer_page_title", this.cy);
        jSONObject.put("page_path", this.hd);
        jSONObject.put("referrer_page_path", this.cd);
    }

    @Override // com.byazt.yi.n
    public n qg(JSONObject jSONObject) {
        super.qg(jSONObject);
        this.sz = jSONObject.optString("page_key", null);
        this.oa = jSONObject.optString("refer_page_key", null);
        this.d = jSONObject.optLong(MediationConstant.EXTRA_DURATION, 0L);
        this.um = jSONObject.optInt("is_back", 0);
        this.k = jSONObject.optString("page_title", null);
        this.cy = jSONObject.optString("refer_page_title", null);
        this.hd = jSONObject.optString("page_path", null);
        this.cd = jSONObject.optString("referrer_page_path", null);
        return this;
    }

    @Override // com.byazt.yi.n
    public JSONObject qg() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.qg);
        jSONObject.put("tea_event_index", this.s);
        jSONObject.put(f.bo, this.q);
        if (this.l > 0) {
            jSONObject.put("user_id", this.l);
        }
        jSONObject.put("user_unique_id", TextUtils.isEmpty(this.w) ? JSONObject.NULL : this.w);
        if (!TextUtils.isEmpty(this.x)) {
            jSONObject.put("ssid", this.x);
        }
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, "bav2b_page");
        jSONObject.put("is_bav", 1);
        jSONObject.put("params", d());
        jSONObject.put("datetime", this.cp);
        return jSONObject;
    }

    private JSONObject d() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("page_key", this.sz);
        jSONObject.put("refer_page_key", this.oa);
        jSONObject.put("is_back", this.um);
        jSONObject.put(MediationConstant.EXTRA_DURATION, this.d);
        jSONObject.put("page_title", this.k);
        jSONObject.put("refer_page_title", this.cy);
        jSONObject.put("page_path", this.hd);
        jSONObject.put("referrer_page_path", this.cd);
        return jSONObject;
    }

    public boolean tj() {
        return this.d == -1;
    }

    public boolean cp() {
        return this.sz.contains(":");
    }

    @Override // com.byazt.yi.n
    public String fs() {
        return this.sz + ", " + this.d;
    }
}
