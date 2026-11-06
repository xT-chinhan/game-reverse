package com.byazt.am;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SESSION_RECEIVED_WINDOW, 19})
public abstract class n implements Function<SparseArray<Object>, Object> {
    public PluginValueSet n;

    public abstract void n(String str, com.byazt.ap.qg qgVar);

    public PluginValueSet n() {
        PluginValueSet pluginValueSet = this.n;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetQg = qg();
        this.n = pluginValueSetQg;
        return pluginValueSetQg;
    }

    private PluginValueSet qg() {
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
        if (iIntValue == -99999986) {
            return n().sparseArray();
        }
        if (iIntValue == 270031) {
            n((String) pluginValueSetQg.objectValue(0, String.class), new com.byazt.ap.qg((Function) pluginValueSetQg.objectValue(1, Function.class)));
        }
        return null;
    }
}
