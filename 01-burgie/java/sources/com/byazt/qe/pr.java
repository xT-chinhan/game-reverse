package com.byazt.qe;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1180, 37})
public class pr {
    public final PluginValueSet pr;

    public pr(SparseArray<Object> sparseArray) {
        this.pr = com.byazt.ij.pr.pr(sparseArray).hw();
    }

    public String pr() {
        return (String) this.pr.objectValue(261001, String.class);
    }

    public String hw() {
        return (String) this.pr.objectValue(261002, String.class);
    }

    public boolean hn() {
        return this.pr.booleanValue(261003);
    }

    public String x() {
        return (String) this.pr.objectValue(261004, String.class);
    }

    public String c() {
        return (String) this.pr.objectValue(261005, String.class);
    }

    public int uc() {
        return this.pr.intValue(261006);
    }

    public boolean fw() {
        return this.pr.booleanValue(261007);
    }

    public boolean zo() {
        return this.pr.booleanValue(261008);
    }

    public int[] aj() {
        return (int[]) this.pr.objectValue(261009, int[].class);
    }

    public boolean vk() {
        return this.pr.booleanValue(261011);
    }

    public x w() {
        SparseArray sparseArray = (SparseArray) this.pr.objectValue(261012, SparseArray.class);
        if (sparseArray != null) {
            return new x(sparseArray);
        }
        return null;
    }

    public int k() {
        return this.pr.intValue(261013);
    }

    public int m() {
        return this.pr.intValue(261014);
    }

    public int g() {
        return this.pr.intValue(261015);
    }

    public com.byazt.or.pr ho() {
        SparseArray sparseArray = (SparseArray) this.pr.objectValue(261016, SparseArray.class);
        if (sparseArray != null) {
            return new com.byazt.or.pr(sparseArray);
        }
        return null;
    }

    public boolean nt() {
        return this.pr.booleanValue(261017);
    }

    public Map<String, Object> yb() {
        return (Map) this.pr.objectValue(261018, Map.class);
    }

    public Function<SparseArray<Object>, Object> lb() {
        Map<String, Object> mapYb = yb();
        if (mapYb == null || mapYb.isEmpty()) {
            return null;
        }
        Object obj = mapYb.get("qa_common_tool");
        if (!(obj instanceof Function)) {
            return null;
        }
        return (Function) obj;
    }
}
