package com.byazt.mr;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 25, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public abstract class zo implements Function<SparseArray<Object>, Object> {
    public abstract void hw(Double d);

    public abstract void pr(com.byazt.rkl.hw hwVar);

    public abstract void pr(Double d);

    public abstract void pr(Double d, String str, String str2);

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
                return new SparseArray();
            case 210101:
                pr(Double.valueOf(pluginValueSetHw.doubleValue(0)));
                return null;
            case 210102:
                pr(Double.valueOf(pluginValueSetHw.doubleValue(0)), (String) pluginValueSetHw.objectValue(1, String.class), (String) pluginValueSetHw.objectValue(2, String.class));
                return null;
            case 210103:
                hw(Double.valueOf(pluginValueSetHw.doubleValue(0)));
                return null;
            case 210104:
                pr(new com.byazt.rkl.hw((Function) pluginValueSetHw.objectValue(0, Function.class)));
                return null;
            default:
                return null;
        }
    }
}
