package com.byazt.ve;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM, 13})
public class hw implements Function<SparseArray<Object>, Object> {
    public final TTAdInteractionListener pr;

    public hw(TTAdInteractionListener tTAdInteractionListener) {
        this.pr = tTAdInteractionListener;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.pr == null) {
            return null;
        }
        ValueSet valueSetHw = com.byazt.ij.hn.pr(sparseArray).hw();
        switch (valueSetHw.intValue(-99999987)) {
            case -2147483647:
                return "TTAdInteractionListener";
            case 100101:
                this.pr.onAdEvent(valueSetHw.intValue(0), (Map) valueSetHw.objectValue(1, Map.class));
            default:
                return null;
        }
    }
}
