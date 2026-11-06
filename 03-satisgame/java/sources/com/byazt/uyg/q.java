package com.byazt.uyg;

import android.content.Context;
import com.byazt.eau.l;
import com.byazt.vf.um;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME, 5})
public class q {

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    public static class n {
        public volatile boolean l;
        public volatile Context n;
        public volatile boolean q;
        public volatile String qg;
        public volatile int s;
        public volatile int w;

        public n n(Context context) {
            if (context == null) {
                return this;
            }
            this.n = context.getApplicationContext();
            s.n(this.n);
            return this;
        }

        public n n(String str) {
            this.qg = str;
            return this;
        }

        public n n(int i) {
            this.s = i;
            return this;
        }

        public n n(boolean z) {
            this.q = z;
            return this;
        }

        public n qg(int i) {
            this.w = i;
            return this;
        }

        public l n() {
            if (this.s == 2) {
                return s();
            }
            return qg();
        }

        private l qg() {
            if (this.q) {
                return com.byazt.jz.n.qg(this.qg);
            }
            return ((um) com.byazt.qp.q.n("kv_store_factory")).n(this.qg);
        }

        private l s() {
            l lVarN = com.byazt.bj.n.n(this.n, this.qg, this.q, this.w);
            this.l = true;
            if (lVarN != null) {
                return lVarN;
            }
            this.l = false;
            return qg();
        }
    }
}
