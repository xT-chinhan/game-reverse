package com.byazt.n;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import com.umeng.analytics.pro.an;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 121})
public class x implements com.byazt.ihe.c {
    public String aj;
    public String c;
    public String fw;
    public long hn;
    public int hw;
    public int k;
    public int m;
    public int pr;
    public String uc;
    public String vk;
    public double w;
    public double x;
    public String zo;
    public float g = -1.0f;
    public int ho = 0;
    public int nt = 0;
    public int yb = 0;
    public int lb = 0;
    public int qa = 307200;
    public int a = 1;

    @Override // com.byazt.ihe.c
    public int pr() {
        return this.k;
    }

    @Override // com.byazt.ihe.c
    public void pr(int i) {
        this.k = i;
    }

    @Override // com.byazt.ihe.c
    public int hw() {
        return this.pr;
    }

    @Override // com.byazt.ihe.c
    public void hw(int i) {
        this.pr = i;
    }

    @Override // com.byazt.ihe.c
    public int hn() {
        return this.hw;
    }

    @Override // com.byazt.ihe.c
    public void hn(int i) {
        this.hw = i;
    }

    @Override // com.byazt.ihe.c
    public int x() {
        return this.m;
    }

    @Override // com.byazt.ihe.c
    public void x(int i) {
        this.m = i;
    }

    @Override // com.byazt.ihe.c
    public long c() {
        return this.hn;
    }

    @Override // com.byazt.ihe.c
    public void pr(long j) {
        this.hn = j;
    }

    @Override // com.byazt.ihe.c
    public double uc() {
        return this.x;
    }

    @Override // com.byazt.ihe.c
    public void pr(double d) {
        this.x = d;
    }

    @Override // com.byazt.ihe.c
    public double fw() {
        return this.w;
    }

    @Override // com.byazt.ihe.c
    public void hw(double d) {
        this.w = d;
    }

    @Override // com.byazt.ihe.c
    public float zo() {
        return this.g;
    }

    @Override // com.byazt.ihe.c
    public void pr(float f) {
        this.g = f;
    }

    @Override // com.byazt.ihe.c
    public String aj() {
        return this.c;
    }

    @Override // com.byazt.ihe.c
    public void pr(String str) {
        this.c = str;
    }

    @Override // com.byazt.ihe.c
    public int[] vk() {
        try {
            int iIndexOf = this.c.indexOf("x");
            return new int[]{Integer.parseInt(this.c.substring(0, iIndexOf).trim()), Integer.parseInt(this.c.substring(iIndexOf + 1).trim())};
        } catch (Throwable th) {
            com.byazt.o.hw.pr("VideoInfo", "getWidthAndHeight error", th);
            return null;
        }
    }

    @Override // com.byazt.ihe.c
    public String w() {
        return this.uc;
    }

    @Override // com.byazt.ihe.c
    public void hw(String str) {
        this.uc = str;
    }

    @Override // com.byazt.ihe.c
    public String k() {
        return this.fw;
    }

    @Override // com.byazt.ihe.c
    public void hn(String str) {
        this.fw = str;
    }

    @Override // com.byazt.ihe.c
    public String m() {
        return this.zo;
    }

    @Override // com.byazt.ihe.c
    public void x(String str) {
        this.zo = str;
    }

    @Override // com.byazt.ihe.c
    public String g() {
        return this.aj;
    }

    @Override // com.byazt.ihe.c
    public void c(String str) {
        this.aj = str;
    }

    @Override // com.byazt.ihe.c
    public String ho() {
        if (TextUtils.isEmpty(this.vk)) {
            this.vk = com.byazt.o.pr.pr(this.fw);
        }
        return this.vk;
    }

    @Override // com.byazt.ihe.c
    public void uc(String str) {
        this.vk = str;
    }

    @Override // com.byazt.ihe.c
    public int nt() {
        if (this.qa < 0) {
            this.qa = 307200;
        }
        long j = this.qa;
        long j2 = this.hn;
        if (j > j2) {
            this.qa = (int) j2;
        }
        return this.qa;
    }

    @Override // com.byazt.ihe.c
    public void c(int i) {
        this.qa = i;
    }

    @Override // com.byazt.ihe.c
    public int yb() {
        return this.yb;
    }

    @Override // com.byazt.ihe.c
    public void uc(int i) {
        this.yb = i;
    }

    @Override // com.byazt.ihe.c
    public int lb() {
        return this.lb;
    }

    @Override // com.byazt.ihe.c
    public void fw(int i) {
        this.lb = i;
    }

    @Override // com.byazt.ihe.c
    public JSONObject qa() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cover_height", hw());
            jSONObject.put("cover_url", w());
            jSONObject.put("cover_width", hn());
            jSONObject.put("endcard", m());
            jSONObject.put("file_hash", ho());
            jSONObject.put(an.z, aj());
            jSONObject.put("size", c());
            jSONObject.put(Constants.VIDEO_DURATION_FIELD, uc());
            jSONObject.put("video_url", k());
            jSONObject.put("playable_download_url", g());
            jSONObject.put("if_playable_loading_show", a());
            jSONObject.put("remove_loading_page_type", cz());
            jSONObject.put("fallback_endcard_judge", pr());
            jSONObject.put("video_preload_size", nt());
            jSONObject.put("reward_video_cached_type", yb());
            jSONObject.put("execute_cached_type", lb());
            jSONObject.put("endcard_render", x());
            jSONObject.put("replay_time", rc());
            jSONObject.put("play_speed_ratio", zo());
            if (fw() > 0.0d) {
                jSONObject.put(TrackAction.START, fw());
            }
        } catch (Exception e) {
        }
        return jSONObject;
    }

    @Override // com.byazt.ihe.c
    public int a() {
        return this.ho;
    }

    @Override // com.byazt.ihe.c
    public void zo(int i) {
        this.ho = i;
    }

    @Override // com.byazt.ihe.c
    public int cz() {
        return this.nt;
    }

    @Override // com.byazt.ihe.c
    public void aj(int i) {
        this.nt = i;
    }

    @Override // com.byazt.ihe.c
    public boolean ny() {
        return this.lb == 1;
    }

    @Override // com.byazt.ihe.c
    public boolean fo() {
        return this.yb == 0;
    }

    @Override // com.byazt.ihe.c
    public void vk(int i) {
        this.a = Math.min(4, Math.max(1, i));
    }

    @Override // com.byazt.ihe.c
    public int rc() {
        return this.a;
    }
}
