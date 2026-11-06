package com.byazt.gu;

import com.byazt.ch.ny;
import com.byazt.mq.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 665, 13})
public class hw extends m {
    public boolean c;
    public float hn;
    public ny hw;
    public JSONObject pr;
    public int uc;
    public float x;

    public hw(pr prVar) {
        super(prVar);
        this.uc = 3;
        this.pr = prVar.pr;
        this.hw = prVar.hw;
        this.hn = prVar.hn;
        this.x = prVar.x;
        this.c = prVar.c;
        this.uc = prVar.uc;
    }

    public float nl() {
        return this.hn;
    }

    public float y() {
        return this.x;
    }

    public JSONObject ww() {
        return this.pr;
    }

    public ny n() {
        return this.hw;
    }

    public boolean e() {
        return this.c;
    }

    public int s() {
        return this.uc;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 665, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    public static class pr extends m.pr {
        public boolean c;
        public float hn;
        public ny hw;
        public JSONObject pr;
        public int uc;
        public float x;

        public pr c(JSONObject jSONObject) {
            this.pr = jSONObject;
            return this;
        }

        public pr pr(ny nyVar) {
            this.hw = nyVar;
            return this;
        }

        public pr pr(float f) {
            this.hn = f;
            return this;
        }

        public pr hw(float f) {
            this.x = f;
            return this;
        }

        public pr c(boolean z) {
            this.c = z;
            return this;
        }

        public pr w(int i) {
            this.uc = i;
            return this;
        }

        @Override // com.byazt.mq.m.pr
        /* JADX INFO: renamed from: hw, reason: merged with bridge method [inline-methods] */
        public hw pr() {
            return new hw(this);
        }
    }
}
