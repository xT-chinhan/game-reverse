package com.byazt.zq;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY, 8})
public class s {
    public PluginValueSet n;

    public s(SparseArray<Object> sparseArray) {
        this.n = com.byazt.qvu.n.n(sparseArray).qg();
    }

    public double n() {
        return this.n.doubleValue(262001);
    }

    public double qg() {
        return this.n.doubleValue(262002);
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY, 546})
    public static class n {
        public final com.byazt.of.qg n = com.byazt.of.qg.n();

        public n n(double d) {
            this.n.n(262001, Double.valueOf(d));
            return this;
        }

        public n qg(double d) {
            this.n.n(262002, Double.valueOf(d));
            return this;
        }

        public s n() {
            return new s(this.n.qg());
        }
    }
}
