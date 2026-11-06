package com.byazt.lq;

import android.util.SparseArray;
import com.byazt.nf.rv;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 751, 5})
public class q implements Function<SparseArray<Object>, Object> {
    public static volatile q n;

    private q() {
    }

    public static q n() {
        if (n == null) {
            n = new q();
        }
        return n;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        PluginValueSet pluginValueSetQg = com.byazt.qvu.n.n(sparseArray).qg();
        int iIntValue = pluginValueSetQg.intValue(-99999987);
        if (iIntValue == 10001) {
            com.byazt.vyf.s.cy().cp(pluginValueSetQg.booleanValue(1));
        } else {
            if (iIntValue == 10002) {
                return Boolean.valueOf(com.byazt.vyf.s.cy().lq());
            }
            if (iIntValue == 10003) {
                rv.n().n((Function<SparseArray<Object>, Object>) pluginValueSetQg.objectValue(0, Function.class));
            } else if (iIntValue == 10004) {
                Function<SparseArray<Object>, Object> function = (Function) pluginValueSetQg.objectValue(0, Function.class);
                String str = (String) pluginValueSetQg.objectValue(1, String.class);
                String str2 = (String) pluginValueSetQg.objectValue(2, String.class);
                String str3 = (String) pluginValueSetQg.objectValue(3, String.class);
                String str4 = (String) pluginValueSetQg.objectValue(4, String.class);
                HashMap map = new HashMap();
                map.put("adtype", str2);
                map.put("rit", str);
                map.put("image_mode", str3);
                map.put("preview_extra", str4);
                rv.n().n(map, function);
            } else {
                if (iIntValue == 10005) {
                    com.byazt.qvu.n nVarN = com.byazt.qvu.n.n();
                    nVarN.n(0, com.byazt.vyf.s.cy().ci());
                    nVarN.n(1, com.byazt.vyf.s.cy().hf());
                    nVarN.n(2, com.byazt.vyf.s.cy().kc());
                    nVarN.n(3, com.byazt.vyf.s.cy().z());
                    nVarN.n(4, com.byazt.vyf.s.cy().dn());
                    return nVarN.qg().sparseArray();
                }
                if (iIntValue == 10006) {
                    rv.n().n((Map<String, Object>) pluginValueSetQg.objectValue(0, Map.class), (Function<SparseArray<Object>, Object>) pluginValueSetQg.objectValue(1, Function.class));
                } else if (iIntValue == 10007) {
                    com.byazt.vyf.s.cy().n((com.byazt.vyf.s.C0380s) null);
                } else if (iIntValue == 10008) {
                    return Boolean.valueOf(com.byazt.vyf.s.cy().oj());
                }
            }
        }
        return null;
    }
}
