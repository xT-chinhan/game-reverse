package com.byazt.ts;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1844, 19})
public class n {
    public int l;
    public String n;
    public int q;
    public String qg;
    public String s;
    public long w;
    public JSONObject x;

    public String n() {
        return this.n;
    }

    public String qg() {
        return this.qg;
    }

    public String s() {
        return this.s;
    }

    public int q() {
        return this.q;
    }

    public int l() {
        return this.l;
    }

    public long w() {
        return this.w;
    }

    public JSONObject x() {
        return this.x;
    }

    /* JADX INFO: renamed from: com.byazt.ts.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 1844, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public static class C0356n {
        public int l;
        public String n;
        public int q;
        public String qg;
        public String s;
        public long w;
        public JSONObject x;

        public C0356n n(String str) {
            this.n = str;
            return this;
        }

        public C0356n qg(String str) {
            this.qg = str;
            return this;
        }

        public C0356n s(String str) {
            this.s = str;
            return this;
        }

        public C0356n n(int i) {
            this.q = i;
            return this;
        }

        public C0356n qg(int i) {
            this.l = i;
            return this;
        }

        public C0356n n(long j) {
            this.w = j;
            return this;
        }

        public C0356n n(JSONObject jSONObject) {
            this.x = jSONObject;
            return this;
        }

        public n n() {
            n nVar = new n();
            nVar.n = this.n;
            nVar.qg = this.qg;
            nVar.s = this.s;
            nVar.q = this.q;
            nVar.l = this.l;
            nVar.w = this.w;
            nVar.x = this.x;
            return nVar;
        }
    }
}
