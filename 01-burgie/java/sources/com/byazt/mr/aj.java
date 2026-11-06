package com.byazt.mr;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 25, 61})
public abstract class aj extends vk {
    public PluginValueSet pr;

    public abstract void pr(Bitmap bitmap, int i);

    public abstract void pr(com.byazt.ng.pr prVar);

    public abstract void pr(boolean z);

    @Override // com.byazt.mr.vk, com.byazt.mr.m
    public PluginValueSet s_() {
        PluginValueSet pluginValueSet = this.pr;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetC = c();
        this.pr = pluginValueSetC;
        return pluginValueSetC;
    }

    private PluginValueSet c() {
        return super.s_();
    }

    @Override // com.byazt.mr.vk, com.byazt.mr.m, com.byazt.mr.zo, java.util.function.Function
    /* JADX INFO: renamed from: pr */
    public Object apply(SparseArray<Object> sparseArray) {
        com.byazt.ti.hn hnVar;
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetHw = com.byazt.ij.pr.pr(sparseArray).hw();
        int iIntValue = pluginValueSetHw.intValue(-99999987);
        pluginValueSetHw.objectValue(-99999985, Class.class);
        switch (iIntValue) {
            case -99999986:
                return s_().sparseArray();
            case 140111:
                Function function = (Function) pluginValueSetHw.objectValue(0, Function.class);
                if (pluginValueSetHw.intValue(1) == 1) {
                    hnVar = new com.byazt.mt.hw(function);
                } else {
                    hnVar = new com.byazt.ti.hn(function);
                }
                pr(hnVar);
                return null;
            case 170101:
                pr(pluginValueSetHw.booleanValue(0));
                return null;
            case 170102:
                pr((Bitmap) pluginValueSetHw.objectValue(0, Bitmap.class), pluginValueSetHw.intValue(1));
                return null;
            case 170103:
                pr(new com.byazt.ng.pr((Function) pluginValueSetHw.objectValue(0, Function.class)));
                return null;
            default:
                return super.apply(sparseArray);
        }
    }
}
