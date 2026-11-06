package com.byazt.fvm;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 464, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public abstract class tj extends oa {
    public PluginValueSet n;

    public abstract double n();

    public abstract void n(com.byazt.wn.n nVar);

    public abstract void n(com.byazt.wn.qg qgVar);

    public abstract int q();

    public abstract com.byazt.slh.n qg();

    public abstract int s();

    @Override // com.byazt.fvm.oa
    public PluginValueSet p_() {
        PluginValueSet pluginValueSet = this.n;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetT = t();
        this.n = pluginValueSetT;
        return pluginValueSetT;
    }

    private PluginValueSet t() {
        com.byazt.qvu.n nVarN = com.byazt.qvu.n.n(super.p_());
        nVarN.n(160001, new Supplier<Double>() { // from class: com.byazt.fvm.tj.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Double get() {
                return Double.valueOf(tj.this.n());
            }
        });
        nVarN.n(160002, new Supplier<com.byazt.slh.n>() { // from class: com.byazt.fvm.tj.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public com.byazt.slh.n get() {
                return tj.this.qg();
            }
        });
        nVarN.n(160003, new Supplier<Integer>() { // from class: com.byazt.fvm.tj.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(tj.this.s());
            }
        });
        nVarN.n(160004, new Supplier<Integer>() { // from class: com.byazt.fvm.tj.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(tj.this.q());
            }
        });
        return nVarN.qg();
    }

    @Override // com.byazt.fvm.oa, com.byazt.fvm.fs, java.util.function.Function
    /* JADX INFO: renamed from: n */
    public Object apply(SparseArray<Object> sparseArray) {
        com.byazt.dc.s sVar;
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetQg = com.byazt.qvu.n.n(sparseArray).qg();
        switch (pluginValueSetQg.intValue(-99999987)) {
            case -99999986:
                return p_().sparseArray();
            case 140111:
                Function function = (Function) pluginValueSetQg.objectValue(0, Function.class);
                if (pluginValueSetQg.intValue(1) == 1) {
                    sVar = new com.byazt.he.l(function);
                } else {
                    sVar = new com.byazt.dc.s(function);
                }
                n(sVar);
                return null;
            case 160101:
                n(new com.byazt.wn.n((Function) pluginValueSetQg.objectValue(0, Function.class)));
                return null;
            case 160102:
                n(new com.byazt.wn.qg((Function) pluginValueSetQg.objectValue(0, Function.class)));
                return null;
            default:
                return super.apply(sparseArray);
        }
    }
}
