package com.byazt.gct;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, MediaPlayer.MEDIA_PLAYER_OPTION_NO_AV_SYNC})
public class wm implements com.byazt.twc.s {
    public JSONObject a;
    public String cd;
    public final String cp;
    public final byte cy;
    public final String d;
    public final int fs;
    public SparseArray<com.byazt.ys.l.n> hd;
    public final boolean k;
    public final long l;
    public final float n;
    public final String oa;
    public final float q;
    public final float qg;
    public final int rv;
    public final float s;
    public final String sz;
    public final int tj;
    public int um;
    public final long w;
    public final int x;

    private wm(n nVar) {
        this.um = -1;
        this.n = nVar.x;
        this.qg = nVar.w;
        this.s = nVar.l;
        this.q = nVar.q;
        this.l = nVar.s;
        this.w = nVar.qg;
        this.x = nVar.fs;
        this.fs = nVar.rv;
        this.rv = nVar.tj;
        this.tj = nVar.cp;
        this.cp = nVar.d;
        this.hd = nVar.n;
        this.k = nVar.cy;
        this.a = nVar.hd;
        this.d = nVar.oa;
        this.oa = nVar.sz;
        this.sz = nVar.k;
        this.cd = nVar.cd;
        this.um = nVar.um;
        this.cy = nVar.a;
    }

    public JSONObject n() {
        if (this.a == null) {
            this.a = new JSONObject();
        }
        return this.a;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 1174})
    public static class n {
        public String cd;
        public int cp;
        public boolean cy;
        public String d;
        public int fs;
        public JSONObject hd;
        public String k;
        public float l;
        public String oa;
        public float q;
        public long qg;
        public int rv;
        public long s;
        public String sz;
        public int tj;
        public float w;
        public float x;
        public SparseArray<com.byazt.ys.l.n> n = new SparseArray<>();
        public int um = -1;
        public byte a = 0;

        public n n(byte b) {
            this.a = b;
            return this;
        }

        public n n(boolean z) {
            this.cy = z;
            return this;
        }

        public n n(long j) {
            this.qg = j;
            return this;
        }

        public n qg(long j) {
            this.s = j;
            return this;
        }

        public n n(float f) {
            this.q = f;
            return this;
        }

        public n qg(float f) {
            this.l = f;
            return this;
        }

        public n s(float f) {
            this.w = f;
            return this;
        }

        public n q(float f) {
            this.x = f;
            return this;
        }

        public n n(int i) {
            this.fs = i;
            return this;
        }

        public n qg(int i) {
            this.rv = i;
            return this;
        }

        public n s(int i) {
            this.tj = i;
            return this;
        }

        public n q(int i) {
            this.cp = i;
            return this;
        }

        public n n(String str) {
            this.d = str;
            return this;
        }

        public n n(SparseArray<com.byazt.ys.l.n> sparseArray) {
            this.n = sparseArray;
            return this;
        }

        public n n(JSONObject jSONObject) {
            this.hd = jSONObject;
            return this;
        }

        public n qg(String str) {
            this.oa = str;
            return this;
        }

        public n s(String str) {
            this.sz = str;
            return this;
        }

        public n q(String str) {
            this.k = str;
            return this;
        }

        public n l(String str) {
            this.cd = str;
            return this;
        }

        public n l(int i) {
            this.um = i;
            return this;
        }

        public wm n() {
            return new wm(this);
        }
    }
}
