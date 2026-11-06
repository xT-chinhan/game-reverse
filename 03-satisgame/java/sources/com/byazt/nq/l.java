package com.byazt.nq;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1068, 18})
public abstract class l extends s {
    public PluginValueSet n;

    public abstract void n(com.byazt.he.w wVar);

    public abstract void n(boolean z);

    public abstract boolean n();

    public abstract boolean q();

    public abstract void qg();

    public abstract void s();

    private PluginValueSet d() {
        com.byazt.qvu.n nVarN = com.byazt.qvu.n.n(super.cp());
        nVarN.n(270008, new Supplier<Boolean>() { // from class: com.byazt.nq.l.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(l.this.n());
            }
        });
        nVarN.n(270011, new Supplier<Boolean>() { // from class: com.byazt.nq.l.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(l.this.q());
            }
        });
        return nVarN.qg();
    }

    @Override // com.byazt.nq.s, java.util.function.Function
    /* JADX INFO: renamed from: n */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetQg = com.byazt.qvu.n.n(sparseArray).qg();
        int iIntValue = pluginValueSetQg.intValue(-99999987);
        pluginValueSetQg.objectValue(-99999985, Class.class);
        switch (iIntValue) {
            case -99999986:
                PluginValueSet pluginValueSet = this.n;
                if (pluginValueSet != null) {
                    return pluginValueSet.sparseArray();
                }
                PluginValueSet pluginValueSetD = d();
                this.n = pluginValueSetD;
                return pluginValueSetD.sparseArray();
            case 270009:
                n(pluginValueSetQg.booleanValue(0));
                return null;
            case 270010:
                n(new com.byazt.he.w((Function) pluginValueSetQg.objectValue(0, Function.class)));
                return null;
            case 271048:
                qg();
                return null;
            case 271049:
                s();
                return null;
            default:
                return super.apply(sparseArray);
        }
    }
}
