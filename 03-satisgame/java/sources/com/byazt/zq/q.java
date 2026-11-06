package com.byazt.zq;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY, 5})
public class q {
    public final PluginValueSet pluginValueSet;

    public q(SparseArray<Object> sparseArray) {
        this.pluginValueSet = com.byazt.qvu.n.n(sparseArray).qg();
    }

    public boolean n() {
        return this.pluginValueSet.booleanValue(262101);
    }

    public s qg() {
        SparseArray sparseArray = (SparseArray) this.pluginValueSet.objectValue(262102, SparseArray.class);
        if (sparseArray != null) {
            return new s(sparseArray);
        }
        return null;
    }

    public boolean s() {
        return this.pluginValueSet.booleanValue(262103);
    }

    public boolean q() {
        return this.pluginValueSet.booleanValue(262104);
    }

    public String l() {
        return (String) this.pluginValueSet.objectValue(262105, String.class);
    }

    public boolean w() {
        return this.pluginValueSet.booleanValue(262106);
    }

    public String x() {
        return (String) this.pluginValueSet.objectValue(262107, String.class);
    }

    public boolean fs() {
        return this.pluginValueSet.booleanValue(262108);
    }

    public String rv() {
        return (String) this.pluginValueSet.objectValue(262109, String.class);
    }

    public boolean tj() {
        return this.pluginValueSet.booleanValue(262110);
    }

    public com.byazt.xmw.qg cy() {
        SparseArray sparseArray = (SparseArray) this.pluginValueSet.objectValue(262113, SparseArray.class);
        if (sparseArray != null) {
            return new com.byazt.xmw.qg(sparseArray);
        }
        return null;
    }

    public String cp() {
        return (String) this.pluginValueSet.objectValue(262112, String.class);
    }

    public boolean sz() {
        return this.pluginValueSet.booleanValue(262111);
    }

    public Map<String, Object> d() {
        return (Map) this.pluginValueSet.objectValue(262119, Map.class);
    }

    public boolean oa() {
        return this.pluginValueSet.booleanValue(262120);
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    public static class n {
        public final com.byazt.qvu.n n = com.byazt.qvu.n.n();

        public n n(boolean z) {
            this.n.n(262101, z);
            return this;
        }

        public n n(s sVar) {
            this.n.n(262102, sVar);
            return this;
        }

        public n qg(boolean z) {
            this.n.n(262103, z);
            return this;
        }

        public n s(boolean z) {
            this.n.n(262104, z);
            return this;
        }

        public n n(String str) {
            this.n.n(262105, str);
            return this;
        }

        public n q(boolean z) {
            this.n.n(262106, z);
            return this;
        }

        public n qg(String str) {
            this.n.n(262107, str);
            return this;
        }

        public n l(boolean z) {
            this.n.n(262108, z);
            return this;
        }

        public n s(String str) {
            this.n.n(262109, str);
            return this;
        }

        public n w(boolean z) {
            this.n.n(262110, z);
            return this;
        }

        public n q(String str) {
            this.n.n(262112, str);
            return this;
        }

        public n x(boolean z) {
            this.n.n(262111, z);
            return this;
        }

        public q n() {
            return new q(this.n.qg().sparseArray());
        }
    }

    public boolean k() {
        return this.pluginValueSet.booleanValue(262121);
    }
}
