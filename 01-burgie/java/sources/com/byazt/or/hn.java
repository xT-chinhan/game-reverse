package com.byazt.or;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1644, 20})
public class hn {
    public final PluginValueSet pr;

    public hn(SparseArray<Object> sparseArray) {
        this.pr = com.byazt.ij.pr.pr(sparseArray).hw();
    }

    public Map<String, String> pr() {
        return (Map) this.pr.objectValue(265007, Map.class);
    }

    public String hw() {
        return (String) this.pr.objectValue(265001, String.class);
    }

    public String hn() {
        return (String) this.pr.objectValue(265002, String.class);
    }

    public String x() {
        return (String) this.pr.objectValue(265003, String.class);
    }

    public int c() {
        return this.pr.intValue(265004);
    }

    public String uc() {
        return (String) this.pr.objectValue(265005, String.class);
    }

    public String fw() {
        return (String) this.pr.objectValue(265006, String.class);
    }
}
