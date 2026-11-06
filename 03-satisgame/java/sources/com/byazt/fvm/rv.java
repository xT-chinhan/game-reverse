package com.byazt.fvm;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 464, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public abstract class rv extends tj {
    public PluginValueSet n;

    public abstract void n(Bitmap bitmap, int i);

    public abstract void n(com.byazt.vd.n nVar);

    public abstract void n(boolean z);

    @Override // com.byazt.fvm.tj, com.byazt.fvm.oa
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
        return super.p_();
    }

    @Override // com.byazt.fvm.tj, com.byazt.fvm.oa, com.byazt.fvm.fs, java.util.function.Function
    /* JADX INFO: renamed from: n */
    public Object apply(SparseArray<Object> sparseArray) {
        com.byazt.dc.s sVar;
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetQg = com.byazt.qvu.n.n(sparseArray).qg();
        int iIntValue = pluginValueSetQg.intValue(-99999987);
        pluginValueSetQg.objectValue(-99999985, Class.class);
        if (iIntValue == -99999986) {
            return p_().sparseArray();
        }
        if (iIntValue != 140111) {
            switch (iIntValue) {
                case 170101:
                    n(pluginValueSetQg.booleanValue(0));
                    break;
                case 170102:
                    n((Bitmap) pluginValueSetQg.objectValue(0, Bitmap.class), pluginValueSetQg.intValue(1));
                    break;
                case 170103:
                    n(new com.byazt.vd.n((Function) pluginValueSetQg.objectValue(0, Function.class)));
                    break;
                default:
                    return super.apply(sparseArray);
            }
        } else {
            Function function = (Function) pluginValueSetQg.objectValue(0, Function.class);
            if (pluginValueSetQg.intValue(1) == 1) {
                sVar = new com.byazt.he.l(function);
            } else {
                sVar = new com.byazt.dc.s(function);
            }
            n(sVar);
        }
        return null;
    }
}
