package com.bykv.vk.openvk.component.video.api.ah;

import android.text.TextUtils;
import com.umeng.analytics.pro.bv;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ah {
    private String ab;
    private long ah;
    private String c;
    private String ch;
    private double d;
    private double hi;
    private String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f15ms;
    private String ny;
    private int sl;
    private String x;
    private int xr;
    private int zb;
    private float u = -1.0f;
    private int ub = 0;
    private int ao = 0;
    private int h = 0;
    private int qv = 0;
    private int y = 307200;
    private int t = 1;

    public int ms() {
        return this.sl;
    }

    public void ms(int i) {
        this.sl = i;
    }

    public int xr() {
        return this.f15ms;
    }

    public void xr(int i) {
        this.f15ms = i;
    }

    public int ah() {
        return this.xr;
    }

    public void ah(int i) {
        this.xr = i;
    }

    public int d() {
        return this.zb;
    }

    public long ka() {
        return this.ah;
    }

    public void ms(long j) {
        this.ah = j;
    }

    public double c() {
        return this.d;
    }

    public void ms(double d) {
        this.d = d;
    }

    public double ab() {
        return this.hi;
    }

    public void xr(double d) {
        this.hi = d;
    }

    public float x() {
        return this.u;
    }

    public void ms(float f) {
        this.u = f;
    }

    public String ny() {
        return this.ka;
    }

    public void ms(String str) {
        this.ka = str;
    }

    public int[] ch() {
        try {
            int iIndexOf = this.ka.indexOf("x");
            return new int[]{Integer.parseInt(this.ka.substring(0, iIndexOf).trim()), Integer.parseInt(this.ka.substring(iIndexOf + 1).trim())};
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.c.ah.ah("VideoInfo", "getWidthAndHeight error", th);
            return null;
        }
    }

    public String hi() {
        return this.c;
    }

    public void xr(String str) {
        this.c = str;
    }

    public String sl() {
        return this.ab;
    }

    public void ah(String str) {
        this.ab = str;
    }

    public String zb() {
        return this.x;
    }

    public void d(String str) {
        this.x = str;
    }

    public String u() {
        return this.ny;
    }

    public String ub() {
        if (TextUtils.isEmpty(this.ch)) {
            this.ch = com.bykv.vk.openvk.component.video.api.c.xr.ms(this.ab);
        }
        return this.ch;
    }

    public void ka(String str) {
        this.ch = str;
    }

    public int ao() {
        if (this.y < 0) {
            this.y = 307200;
        }
        long j = this.y;
        long j2 = this.ah;
        if (j > j2) {
            this.y = (int) j2;
        }
        return this.y;
    }

    public void d(int i) {
        this.y = i;
    }

    public int h() {
        return this.h;
    }

    public void ka(int i) {
        this.h = i;
    }

    public int qv() {
        return this.qv;
    }

    public void c(int i) {
        this.qv = i;
    }

    public JSONObject y() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cover_height", xr());
            jSONObject.put("cover_url", hi());
            jSONObject.put("cover_width", ah());
            jSONObject.put("endcard", zb());
            jSONObject.put("file_hash", ub());
            jSONObject.put(bv.z, ny());
            jSONObject.put("size", ka());
            jSONObject.put("video_duration", c());
            jSONObject.put("video_url", sl());
            jSONObject.put("playable_download_url", u());
            jSONObject.put("if_playable_loading_show", t());
            jSONObject.put("remove_loading_page_type", nw());
            jSONObject.put("fallback_endcard_judge", ms());
            jSONObject.put("video_preload_size", ao());
            jSONObject.put("reward_video_cached_type", h());
            jSONObject.put("execute_cached_type", qv());
            jSONObject.put("endcard_render", d());
            jSONObject.put("replay_time", i());
            jSONObject.put("play_speed_ratio", x());
            if (ab() > 0.0d) {
                jSONObject.put("start", ab());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public int t() {
        return this.ub;
    }

    public int nw() {
        return this.ao;
    }

    public boolean b() {
        return this.qv == 1;
    }

    public boolean re() {
        return this.h == 0;
    }

    public int i() {
        return this.t;
    }
}
