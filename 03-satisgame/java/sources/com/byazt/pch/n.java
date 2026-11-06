package com.byazt.pch;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, AVMDLDataLoader.KeyIsMarkedFileIOSpeed, 19})
public class n extends com.byazt.zq.qg {
    public final PluginValueSet qg;

    public n(SparseArray<Object> sparseArray, String str) {
        super(sparseArray, str);
        this.qg = com.byazt.qvu.n.n(sparseArray).qg();
    }

    public boolean t() {
        PluginValueSet pluginValueSet = this.qg;
        if (pluginValueSet == null) {
            return false;
        }
        return pluginValueSet.booleanValue(8260030);
    }

    private static Function<SparseArray<Object>, Object> n(PluginValueSet pluginValueSet) {
        Object objObjectValue;
        if (pluginValueSet != null) {
            objObjectValue = pluginValueSet.objectValue(8260028, Object.class);
            if (objObjectValue == null) {
                try {
                    objObjectValue = pluginValueSet.objectValue(260026, Function.class);
                } catch (Throwable unused) {
                }
            }
        } else {
            objObjectValue = null;
        }
        return com.byazt.mp.s.n(objObjectValue);
    }

    public qg ur() {
        Function<SparseArray<Object>, Object> functionN = n(this.qg);
        if (functionN != null) {
            return new qg(functionN);
        }
        return null;
    }

    public String bb() {
        PluginValueSet pluginValueSet = this.qg;
        if (pluginValueSet == null) {
            return null;
        }
        return (String) pluginValueSet.objectValue(8260029, String.class);
    }

    public Map ln() {
        PluginValueSet pluginValueSet = this.qg;
        if (pluginValueSet == null) {
            return null;
        }
        return (Map) pluginValueSet.objectValue(8260032, Map.class);
    }

    public static final PluginValueSet n(com.byazt.zq.qg qgVar) {
        return n(qgVar, null, false);
    }

    public static final PluginValueSet n(com.byazt.zq.qg qgVar, String str, boolean z) {
        com.byazt.qvu.n nVarN = com.byazt.qvu.n.n();
        if (qgVar == null) {
            return nVarN.qg();
        }
        nVarN.n(260001, qgVar.n());
        nVarN.n(260002, qgVar.qg());
        nVarN.n(260003, qgVar.s());
        nVarN.n(260004, qgVar.q());
        nVarN.n(260005, qgVar.l());
        nVarN.n(260006, qgVar.w());
        nVarN.n(260007, qgVar.x());
        nVarN.n(7, qgVar.w());
        nVarN.n(8, qgVar.x());
        nVarN.n(260008, qgVar.fs());
        nVarN.n(260009, qgVar.rv());
        nVarN.n(10, qgVar.fs());
        nVarN.n(9, qgVar.rv());
        nVarN.n(260010, qgVar.tj());
        nVarN.n(260011, qgVar.cp());
        nVarN.n(2600012, qgVar.d());
        nVarN.n(260013, qgVar.oa());
        nVarN.n(260014, qgVar.sz());
        nVarN.n(260015, qgVar.k());
        nVarN.n(260016, qgVar.cy());
        nVarN.n(260017, qgVar.hd());
        nVarN.n(260018, qgVar.cd());
        nVarN.n(260019, qgVar.um());
        nVarN.n(260020, qgVar.a());
        nVarN.n(260021, qgVar.py());
        nVarN.n(260022, qgVar.ou());
        nVarN.n(260023, qgVar.wm());
        nVarN.n(8260032, qgVar.v());
        PluginValueSet pluginValueSet = null;
        try {
            for (Field field : qgVar.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if (field.get(qgVar) instanceof PluginValueSet) {
                    pluginValueSet = (PluginValueSet) field.get(qgVar);
                }
                field.setAccessible(false);
            }
        } catch (Exception unused) {
        }
        if (pluginValueSet != null) {
            nVarN.n(8260028, n(pluginValueSet));
            if (com.byazt.mlu.n.n().qg() < 7400) {
                nVarN.n(260027, pluginValueSet.objectValue(260027, IMediationAdSlot.class));
            }
        }
        nVarN.n(260024, qgVar.m());
        nVarN.n(260025, qgVar.hu());
        nVarN.n(260008, qgVar.fs());
        if (!TextUtils.isEmpty(str)) {
            nVarN.n(8260029, str);
            nVarN.n(8260030, z);
        }
        return nVarN.qg();
    }

    public PluginValueSet lh() {
        return this.qg;
    }

    public static PluginValueSet n(PluginValueSet pluginValueSet, String str) {
        com.byazt.qvu.n nVarN = com.byazt.qvu.n.n(pluginValueSet);
        nVarN.n(260022, str);
        return nVarN.qg();
    }
}
