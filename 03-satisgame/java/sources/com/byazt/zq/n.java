package com.byazt.zq;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY, 19})
public class n {
    public final PluginValueSet n;

    public n(SparseArray<Object> sparseArray) {
        this.n = com.byazt.qvu.n.n(sparseArray).qg();
    }

    public String n() {
        return (String) this.n.objectValue(261001, String.class);
    }

    public String qg() {
        return (String) this.n.objectValue(261002, String.class);
    }

    public boolean s() {
        return this.n.booleanValue(261003);
    }

    public String q() {
        return (String) this.n.objectValue(261004, String.class);
    }

    public String l() {
        return (String) this.n.objectValue(261005, String.class);
    }

    public int w() {
        return this.n.intValue(261006);
    }

    public boolean x() {
        return this.n.booleanValue(261007);
    }

    public boolean fs() {
        return this.n.booleanValue(261008);
    }

    public int[] rv() {
        return (int[]) this.n.objectValue(261009, int[].class);
    }

    public boolean tj() {
        return this.n.booleanValue(261011);
    }

    public q cp() {
        SparseArray sparseArray = (SparseArray) this.n.objectValue(261012, SparseArray.class);
        if (sparseArray != null) {
            return new q(sparseArray);
        }
        return null;
    }

    public int d() {
        return this.n.intValue(261013);
    }

    public int oa() {
        return this.n.intValue(261014);
    }

    public int sz() {
        return this.n.intValue(261015);
    }

    public com.byazt.xmw.n k() {
        SparseArray sparseArray = (SparseArray) this.n.objectValue(261016, SparseArray.class);
        if (sparseArray != null) {
            return new com.byazt.xmw.n(sparseArray);
        }
        return null;
    }

    public boolean cy() {
        return this.n.booleanValue(261017);
    }

    public Map<String, Object> hd() {
        return (Map) this.n.objectValue(261018, Map.class);
    }

    public Function<SparseArray<Object>, Object> cd() {
        Map<String, Object> mapHd = hd();
        if (mapHd != null && !mapHd.isEmpty()) {
            Object obj = mapHd.get("qa_common_tool");
            if (obj instanceof Function) {
                return (Function) obj;
            }
        }
        return null;
    }
}
