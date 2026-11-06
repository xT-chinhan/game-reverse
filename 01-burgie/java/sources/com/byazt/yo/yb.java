package com.byazt.yo;

import com.byazt.hg.of;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1051, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE})
public class yb {
    public of c;
    public int hn;
    public String hw;
    public long pr;
    public com.byazt.n.uc x;

    public yb(long j, String str, int i, com.byazt.n.uc ucVar, of ofVar) {
        this.pr = j;
        this.hw = str;
        this.hn = i;
        this.x = ucVar;
        this.c = ofVar;
    }

    public long pr() {
        return this.pr;
    }

    public String hw() {
        return this.hw;
    }

    public int hn() {
        return this.hn;
    }

    public com.byazt.n.uc x() {
        return this.x;
    }

    public of c() {
        return this.c;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 1051, 1606})
    public static class pr {
        public int aj;
        public JSONArray g;
        public Map<String, Object> ho;
        public int k;
        public int vk;
        public int w;
        public int zo;
        public long pr = 0;
        public long hw = 0;
        public long hn = 0;
        public boolean x = false;
        public boolean c = false;
        public int uc = 0;
        public int fw = 0;
        public boolean m = false;

        public void pr(JSONArray jSONArray) {
            this.g = jSONArray;
        }

        public JSONArray pr() {
            return this.g;
        }

        public long hw() {
            return this.pr;
        }

        public void pr(long j) {
            this.pr = j;
        }

        public long hn() {
            return this.hw;
        }

        public void hw(long j) {
            this.hw = j;
        }

        public long x() {
            return this.hn;
        }

        public void hn(long j) {
            this.hn = j;
        }

        public int c() {
            return this.uc;
        }

        public void pr(int i) {
            this.uc = i;
        }

        public int uc() {
            return this.fw;
        }

        public void hw(int i) {
            this.fw = i;
        }

        public int fw() {
            return this.zo;
        }

        public void hn(int i) {
            this.zo = i;
        }

        public int zo() {
            return this.aj;
        }

        public void x(int i) {
            this.aj = i;
        }

        public int aj() {
            long j = this.hn;
            if (j <= 0) {
                return 0;
            }
            return Math.min((int) ((this.pr * 100) / j), 100);
        }

        public int vk() {
            return this.vk;
        }

        public void c(int i) {
            this.vk = i;
        }

        public int w() {
            return this.w;
        }

        public int k() {
            return this.k;
        }

        public void uc(int i) {
            this.k = i;
        }

        public boolean m() {
            return this.m;
        }

        public void pr(boolean z) {
            this.m = z;
        }

        public boolean g() {
            return this.x;
        }

        public void hw(boolean z) {
            this.x = z;
        }

        public void hn(boolean z) {
            this.c = z;
        }

        public boolean ho() {
            return this.c;
        }

        public void pr(Map<String, Object> map) {
            this.ho = map;
        }

        public Map<String, Object> nt() {
            return this.ho;
        }
    }
}
