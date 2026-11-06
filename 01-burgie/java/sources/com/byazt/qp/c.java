package com.byazt.qp;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1370, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c implements Function<SparseArray<Object>, Object> {
    public final TTAdInteractionListener tTAdInteractionListener;

    public c(TTAdInteractionListener tTAdInteractionListener) {
        this.tTAdInteractionListener = tTAdInteractionListener;
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.tTAdInteractionListener == null) {
            return null;
        }
        PluginValueSet pluginValueSetHw = com.byazt.ij.pr.pr(sparseArray).hw();
        switch (pluginValueSetHw.intValue(-99999987)) {
            case 100101:
                this.tTAdInteractionListener.onAdEvent(pluginValueSetHw.intValue(0), (Map) pluginValueSetHw.objectValue(1, Map.class));
            default:
                return null;
        }
    }
}
