package com.byazt.qe;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1180, 121})
public class x {
    public final PluginValueSet pluginValueSet;

    public x(SparseArray<Object> sparseArray) {
        this.pluginValueSet = com.byazt.ij.pr.pr(sparseArray).hw();
    }

    public boolean pr() {
        return this.pluginValueSet.booleanValue(262101);
    }

    public hn aj() {
        SparseArray sparseArray = (SparseArray) this.pluginValueSet.objectValue(262102, SparseArray.class);
        if (sparseArray != null) {
            return new hn(sparseArray);
        }
        return null;
    }

    public boolean hw() {
        return this.pluginValueSet.booleanValue(262103);
    }

    public boolean hn() {
        return this.pluginValueSet.booleanValue(262104);
    }

    public String vk() {
        return (String) this.pluginValueSet.objectValue(262105, String.class);
    }

    public boolean x() {
        return this.pluginValueSet.booleanValue(262106);
    }

    public String w() {
        return (String) this.pluginValueSet.objectValue(262107, String.class);
    }

    public boolean c() {
        return this.pluginValueSet.booleanValue(262108);
    }

    public String k() {
        return (String) this.pluginValueSet.objectValue(262109, String.class);
    }

    public boolean uc() {
        return this.pluginValueSet.booleanValue(262110);
    }

    public com.byazt.or.hw yb() {
        SparseArray sparseArray = (SparseArray) this.pluginValueSet.objectValue(262113, SparseArray.class);
        if (sparseArray != null) {
            return new com.byazt.or.hw(sparseArray);
        }
        return null;
    }

    public String ho() {
        return (String) this.pluginValueSet.objectValue(262112, String.class);
    }

    public boolean fw() {
        return this.pluginValueSet.booleanValue(262111);
    }

    public Map<String, Object> nt() {
        return (Map) this.pluginValueSet.objectValue(262119, Map.class);
    }

    public boolean zo() {
        return this.pluginValueSet.booleanValue(262120);
    }

    @com.byazt.vzx.pr(pr = {0, 1, 1180, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
    public static class pr {
        public final com.byazt.ij.pr pr = com.byazt.ij.pr.pr();

        public pr pr(boolean z) {
            this.pr.pr(262101, z);
            return this;
        }

        public pr pr(hn hnVar) {
            this.pr.pr(262102, hnVar);
            return this;
        }

        public pr hw(boolean z) {
            this.pr.pr(262103, z);
            return this;
        }

        public pr hn(boolean z) {
            this.pr.pr(262104, z);
            return this;
        }

        public pr pr(String str) {
            this.pr.pr(262105, str);
            return this;
        }

        public pr x(boolean z) {
            this.pr.pr(262106, z);
            return this;
        }

        public pr hw(String str) {
            this.pr.pr(262107, str);
            return this;
        }

        public pr c(boolean z) {
            this.pr.pr(262108, z);
            return this;
        }

        public pr hn(String str) {
            this.pr.pr(262109, str);
            return this;
        }

        public pr uc(boolean z) {
            this.pr.pr(262110, z);
            return this;
        }

        public pr x(String str) {
            this.pr.pr(262112, str);
            return this;
        }

        public pr fw(boolean z) {
            this.pr.pr(262111, z);
            return this;
        }

        public x pr() {
            return new x(this.pr.hw().sparseArray());
        }
    }

    public boolean m() {
        return this.pluginValueSet.booleanValue(262121);
    }
}
