package com.byazt.wd;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AE_SRC_PEAK, 13})
public abstract class hw implements Function<SparseArray<Object>, Object> {
    public PluginValueSet pr;

    public abstract List<pr> c();

    public abstract List<pr> hn();

    public abstract List<Object> hw();

    public abstract boolean pr();

    public abstract pr uc();

    public abstract pr x();

    public PluginValueSet aj() {
        PluginValueSet pluginValueSet = this.pr;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetFw = fw();
        this.pr = pluginValueSetFw;
        return pluginValueSetFw;
    }

    private PluginValueSet fw() {
        return com.byazt.ij.pr.pr().hw();
    }

    @Override // java.util.function.Function
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
                return aj().sparseArray();
            case 270001:
                return Boolean.class.cast(Boolean.valueOf(pr()));
            case 270002:
                return hw();
            case 270003:
                return hn();
            case 270004:
                return x();
            case 270005:
                return c();
            case 270006:
                return uc();
            default:
                return null;
        }
    }
}
