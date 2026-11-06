package com.byazt.mr;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 25, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public abstract class c implements Function<SparseArray<Object>, Object> {
    public PluginValueSet pr;

    public abstract void hw();

    public abstract void pr();

    public PluginValueSet hn() {
        PluginValueSet pluginValueSet = this.pr;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetX = x();
        this.pr = pluginValueSetX;
        return pluginValueSetX;
    }

    private PluginValueSet x() {
        return com.byazt.ij.pr.pr().hw();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetHw = com.byazt.ij.pr.pr(sparseArray).hw();
        int iIntValue = pluginValueSetHw.intValue(-99999987);
        pluginValueSetHw.objectValue(-99999985, Class.class);
        switch (iIntValue) {
            case -99999986:
                return hn().sparseArray();
            case 222101:
                pr();
                return null;
            case 222102:
                hw();
                return null;
            default:
                return null;
        }
    }
}
