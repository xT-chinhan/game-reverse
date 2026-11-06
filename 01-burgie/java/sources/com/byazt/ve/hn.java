package com.byazt.ve;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM, 20})
public class hn implements Function<SparseArray<Object>, Object> {
    public final TTAppDownloadListener pr;

    public hn(TTAppDownloadListener tTAppDownloadListener) {
        this.pr = tTAppDownloadListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.pr == null) {
            return null;
        }
        ValueSet valueSetHw = com.byazt.ij.hn.pr(sparseArray).hw();
        switch (valueSetHw.intValue(-99999987)) {
            case 221101:
                this.pr.onIdle();
                return null;
            case 221102:
                this.pr.onDownloadActive(valueSetHw.longValue(0), valueSetHw.longValue(1), valueSetHw.stringValue(2), valueSetHw.stringValue(3));
                return null;
            case 221103:
                this.pr.onDownloadPaused(valueSetHw.longValue(0), valueSetHw.longValue(1), valueSetHw.stringValue(2), valueSetHw.stringValue(3));
                return null;
            case 221104:
                this.pr.onDownloadFailed(valueSetHw.longValue(0), valueSetHw.longValue(1), valueSetHw.stringValue(2), valueSetHw.stringValue(3));
                return null;
            case 221105:
                this.pr.onDownloadFinished(valueSetHw.longValue(0), valueSetHw.stringValue(1), valueSetHw.stringValue(2));
                return null;
            case 221106:
                this.pr.onInstalled(valueSetHw.stringValue(0), valueSetHw.stringValue(1));
                return null;
            default:
                return null;
        }
    }
}
