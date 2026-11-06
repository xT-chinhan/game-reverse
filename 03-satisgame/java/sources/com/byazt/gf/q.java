package com.byazt.gf;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_REAL_TIME, 5})
public abstract class q implements Function<SparseArray<Object>, Object> {
    public abstract <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls);

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        PluginValueSet pluginValueSetQg = com.byazt.qvu.n.n(sparseArray).qg();
        return applyFunction(pluginValueSetQg.intValue(-99999987, 0), pluginValueSetQg, (Class) pluginValueSetQg.objectValue(-99999985, Class.class));
    }
}
