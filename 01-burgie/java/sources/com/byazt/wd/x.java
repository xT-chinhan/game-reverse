package com.byazt.wd;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AE_SRC_PEAK, 121})
public abstract class x extends hw {
    public PluginValueSet pr;

    public abstract boolean fw();

    public abstract boolean zo();

    private PluginValueSet vk() {
        com.byazt.ij.pr prVarPr = com.byazt.ij.pr.pr(super.aj());
        prVarPr.pr(270008, new Supplier<Boolean>() { // from class: com.byazt.wd.x.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(x.this.fw());
            }
        });
        prVarPr.pr(270011, new Supplier<Boolean>() { // from class: com.byazt.wd.x.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(x.this.zo());
            }
        });
        return prVarPr.hw();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.byazt.wd.hw, java.util.function.Function
    /* JADX INFO: renamed from: pr */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetHw = com.byazt.ij.pr.pr(sparseArray).hw();
        int iIntValue = pluginValueSetHw.intValue(-99999987);
        pluginValueSetHw.objectValue(-99999985, Class.class);
        switch (iIntValue) {
            case -99999986:
                PluginValueSet pluginValueSet = this.pr;
                if (pluginValueSet != null) {
                    return pluginValueSet.sparseArray();
                }
                PluginValueSet pluginValueSetVk = vk();
                this.pr = pluginValueSetVk;
                return pluginValueSetVk.sparseArray();
            case 270009:
                pluginValueSetHw.booleanValue(0);
                return null;
            case 270010:
                new com.byazt.mt.hn((Function) pluginValueSetHw.objectValue(0, Function.class));
                return null;
            case 271048:
            case 271049:
                return null;
            default:
                return super.apply(sparseArray);
        }
    }
}
