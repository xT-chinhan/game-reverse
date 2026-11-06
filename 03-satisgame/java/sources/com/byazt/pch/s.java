package com.byazt.pch;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, AVMDLDataLoader.KeyIsMarkedFileIOSpeed, 8})
public abstract class s implements Function<SparseArray<Object>, Object> {
    public PluginValueSet n;

    public abstract void n();

    public abstract void n(int i, String str);

    public abstract void qg();

    public PluginValueSet s() {
        PluginValueSet pluginValueSet = this.n;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetQ = q();
        this.n = pluginValueSetQ;
        return pluginValueSetQ;
    }

    private PluginValueSet q() {
        return com.byazt.qvu.n.n().qg();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
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
                case 268013:
                    n(pluginValueSetQg.intValue(0), (String) pluginValueSetQg.objectValue(1, String.class));
                    return null;
                case 268014:
                    n();
                    return null;
                case 268015:
                    qg();
                    return null;
                default:
                    return null;
            }
        }
        return s().sparseArray();
    }
}
