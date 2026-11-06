package com.byazt.gn;

import com.byazt.udb.oa;
import com.byazt.vh.ou;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_OPEN_RESULT, 8})
public class s extends oa {
    public boolean l;
    public JSONObject n;
    public float q;
    public ou qg;
    public float s;
    public int w;

    public s(n nVar) {
        super(nVar);
        this.w = 3;
        this.n = nVar.n;
        this.qg = nVar.qg;
        this.s = nVar.s;
        this.q = nVar.q;
        this.l = nVar.l;
        this.w = nVar.w;
    }

    public float ln() {
        return this.s;
    }

    public float lh() {
        return this.q;
    }

    public JSONObject v() {
        return this.n;
    }

    public ou j() {
        return this.qg;
    }

    public boolean an() {
        return this.l;
    }

    public int ae() {
        return this.w;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_OPEN_RESULT, 546})
    public static class n extends oa.n {
        public boolean l;
        public JSONObject n;
        public float q;
        public ou qg;
        public float s;
        public int w;

        public n l(JSONObject jSONObject) {
            this.n = jSONObject;
            return this;
        }

        public n n(ou ouVar) {
            this.qg = ouVar;
            return this;
        }

        public n n(float f) {
            this.s = f;
            return this;
        }

        public n qg(float f) {
            this.q = f;
            return this;
        }

        public n l(boolean z) {
            this.l = z;
            return this;
        }

        public n cp(int i) {
            this.w = i;
            return this;
        }

        @Override // com.byazt.udb.oa.n
        /* JADX INFO: renamed from: qg, reason: merged with bridge method [inline-methods] */
        public s n() {
            return new s(this);
        }
    }
}
