package com.byazt.suf;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 797, 26})
public abstract class qg implements Function<SparseArray<Object>, Object> {
    public PluginValueSet n;

    public abstract int cp();

    public abstract int d();

    public abstract int fs();

    public abstract int l();

    public abstract int n();

    public abstract int oa();

    public abstract int q();

    public abstract int qg();

    public abstract int rv();

    public abstract int s();

    public abstract Map<String, Integer> sz();

    public abstract int tj();

    public abstract int w();

    public abstract int x();

    private PluginValueSet k() {
        return com.byazt.qvu.n.n().qg();
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetQg = com.byazt.qvu.n.n(sparseArray).qg();
        int iIntValue = pluginValueSetQg.intValue(-99999987);
        pluginValueSetQg.objectValue(-99999985, Class.class);
        if (iIntValue != -99999986) {
            switch (iIntValue) {
                case 271021:
                    return Integer.class.cast(Integer.valueOf(n()));
                case 271022:
                    return Integer.class.cast(Integer.valueOf(qg()));
                case 271023:
                    return Integer.class.cast(Integer.valueOf(s()));
                case 271024:
                    return Integer.class.cast(Integer.valueOf(q()));
                case 271025:
                    return Integer.class.cast(Integer.valueOf(l()));
                case 271026:
                    return Integer.class.cast(Integer.valueOf(w()));
                case 271027:
                    return Integer.class.cast(Integer.valueOf(x()));
                case 271028:
                    return Integer.class.cast(Integer.valueOf(fs()));
                case 271029:
                    return Integer.class.cast(Integer.valueOf(rv()));
                case 271030:
                    return Integer.class.cast(Integer.valueOf(tj()));
                case 271031:
                    return Integer.class.cast(Integer.valueOf(cp()));
                case 271032:
                    return Integer.class.cast(Integer.valueOf(d()));
                case 271033:
                    return Integer.class.cast(Integer.valueOf(oa()));
                case 271034:
                    return sz();
                default:
                    return null;
            }
        }
        PluginValueSet pluginValueSet = this.n;
        if (pluginValueSet != null) {
            return pluginValueSet.sparseArray();
        }
        PluginValueSet pluginValueSetK = k();
        this.n = pluginValueSetK;
        return pluginValueSetK.sparseArray();
    }
}
