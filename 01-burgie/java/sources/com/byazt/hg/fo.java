package com.byazt.hg;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS})
public class fo implements com.byazt.dj.hn {
    public JSONObject a;
    public final int aj;
    public final long c;
    public final int fw;
    public final String g;
    public final float hn;
    public final boolean ho;
    public final float hw;
    public final String k;
    public String lb;
    public final String m;
    public final byte nt;
    public final float pr;
    public int qa;
    public final long uc;
    public final int vk;
    public final String w;
    public final float x;
    public SparseArray<com.byazt.az.x.pr> yb;
    public final int zo;

    private fo(pr prVar) {
        this.qa = -1;
        this.pr = prVar.fw;
        this.hw = prVar.uc;
        this.hn = prVar.c;
        this.x = prVar.x;
        this.c = prVar.hn;
        this.uc = prVar.hw;
        this.fw = prVar.zo;
        this.zo = prVar.aj;
        this.aj = prVar.vk;
        this.vk = prVar.w;
        this.w = prVar.k;
        this.yb = prVar.pr;
        this.ho = prVar.nt;
        this.a = prVar.yb;
        this.k = prVar.m;
        this.m = prVar.g;
        this.g = prVar.ho;
        this.lb = prVar.lb;
        this.qa = prVar.qa;
        this.nt = prVar.a;
    }

    public JSONObject pr() {
        if (this.a == null) {
            this.a = new JSONObject();
        }
        return this.a;
    }

    @com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
    public static class pr {
        public int aj;
        public float c;
        public float fw;
        public String g;
        public long hn;
        public String ho;
        public long hw;
        public String k;
        public String lb;
        public String m;
        public boolean nt;
        public float uc;
        public int vk;
        public int w;
        public float x;
        public JSONObject yb;
        public int zo;
        public SparseArray<com.byazt.az.x.pr> pr = new SparseArray<>();
        public int qa = -1;
        public byte a = 0;

        public pr pr(byte b) {
            this.a = b;
            return this;
        }

        public pr pr(boolean z) {
            this.nt = z;
            return this;
        }

        public pr pr(long j) {
            this.hw = j;
            return this;
        }

        public pr hw(long j) {
            this.hn = j;
            return this;
        }

        public pr pr(float f) {
            this.x = f;
            return this;
        }

        public pr hw(float f) {
            this.c = f;
            return this;
        }

        public pr hn(float f) {
            this.uc = f;
            return this;
        }

        public pr x(float f) {
            this.fw = f;
            return this;
        }

        public pr pr(int i) {
            this.zo = i;
            return this;
        }

        public pr hw(int i) {
            this.aj = i;
            return this;
        }

        public pr hn(int i) {
            this.vk = i;
            return this;
        }

        public pr x(int i) {
            this.w = i;
            return this;
        }

        public pr pr(String str) {
            this.k = str;
            return this;
        }

        public pr pr(SparseArray<com.byazt.az.x.pr> sparseArray) {
            this.pr = sparseArray;
            return this;
        }

        public pr pr(JSONObject jSONObject) {
            this.yb = jSONObject;
            return this;
        }

        public pr hw(String str) {
            this.m = str;
            return this;
        }

        public pr hn(String str) {
            this.g = str;
            return this;
        }

        public pr x(String str) {
            this.ho = str;
            return this;
        }

        public pr c(String str) {
            this.lb = str;
            return this;
        }

        public pr c(int i) {
            this.qa = i;
            return this;
        }

        public fo pr() {
            return new fo(this);
        }
    }
}
