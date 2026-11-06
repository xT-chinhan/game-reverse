package com.byazt.wd;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AE_SRC_PEAK, 5})
public abstract class uc extends hw {
    public PluginValueSet pr;

    @Override // com.byazt.wd.hw
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
        return com.byazt.ij.pr.pr(super.aj()).hw();
    }

    @Override // com.byazt.wd.hw, java.util.function.Function
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
                return aj().sparseArray();
            case 270007:
                return null;
            default:
                return super.apply(sparseArray);
        }
    }
}
