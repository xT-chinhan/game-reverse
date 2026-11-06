package com.byazt.xq;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_OPENED_TIME, 19})
public class n extends com.byazt.fz.n {
    public n(Function<SparseArray<Object>, Object> function) {
        PluginValueSet pluginValueSetQg;
        if (function == null || (pluginValueSetQg = com.byazt.of.n.qg(function)) == null) {
            return;
        }
        q(pluginValueSetQg.stringValue(8505));
        l(pluginValueSetQg.stringValue(8506));
        n(pluginValueSetQg.longValue(8507));
        w(pluginValueSetQg.stringValue(8508));
        n((Map<String, String>) pluginValueSetQg.objectValue(8509, Map.class));
        x(pluginValueSetQg.stringValue(8510));
        fs(pluginValueSetQg.stringValue(8511));
        qg((Map<String, Object>) pluginValueSetQg.objectValue(8512, Map.class));
        s(pluginValueSetQg.stringValue(8551));
        n(pluginValueSetQg.stringValue(8559));
    }
}
