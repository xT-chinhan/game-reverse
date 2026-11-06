package com.byazt.to;

import android.content.Context;
import com.byazt.cr.c;
import com.byazt.vkw.lb;
import com.byazt.zs.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_TIMEOUT, 121})
public class x {

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_TIMEOUT, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
    public static class pr {
        public volatile boolean c;
        public volatile int hn;
        public volatile String hw;
        public volatile Context pr;
        public volatile int uc;
        public volatile boolean x;

        public pr pr(Context context) {
            if (context == null) {
                return this;
            }
            this.pr = context.getApplicationContext();
            hn.pr(this.pr);
            return this;
        }

        public pr pr(String str) {
            this.hw = str;
            return this;
        }

        public pr pr(int i) {
            this.hn = i;
            return this;
        }

        public pr pr(boolean z) {
            this.x = z;
            return this;
        }

        public pr hw(int i) {
            this.uc = i;
            return this;
        }

        public c pr() {
            switch (this.hn) {
                case 2:
                    return hn();
                default:
                    return hw();
            }
        }

        private c hw() {
            if (this.x) {
                return com.byazt.jc.pr.hw(this.hw);
            }
            return ((lb) uc.pr("kv_store_factory")).pr(this.hw);
        }

        private c hn() {
            c cVarPr = com.byazt.tr.pr.pr(this.pr, this.hw, this.x, this.uc);
            this.c = true;
            if (cVarPr == null) {
                this.c = false;
                return hw();
            }
            return cVarPr;
        }
    }
}
