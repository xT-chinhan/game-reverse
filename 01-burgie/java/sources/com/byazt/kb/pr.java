package com.byazt.kb;

import android.util.SparseArray;
import com.byazt.ij.hn;
import com.byazt.xjg.aj;
import com.byazt.xjg.ho;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1621, 37})
public class pr implements Function<SparseArray<Object>, Object> {
    public final TTFeedAd.VideoAdListener hw;
    public ValueSet pr = hn.pr;

    public pr(TTFeedAd.VideoAdListener videoAdListener) {
        this.hw = videoAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.hw == null) {
            return null;
        }
        ValueSet valueSetHw = hn.pr(sparseArray).hw();
        switch (valueSetHw.intValue(-99999987)) {
            case 161101:
                this.hw.onVideoLoad(new aj(ho.pr(valueSetHw.objectValue(0, Object.class))));
                return null;
            case 161102:
                this.hw.onVideoError(valueSetHw.intValue(0), valueSetHw.intValue(1));
                return null;
            case 161103:
                this.hw.onVideoAdPaused(new aj(ho.pr(valueSetHw.objectValue(0, Object.class))));
                return null;
            case 161104:
                this.hw.onVideoAdStartPlay(new aj(ho.pr(valueSetHw.objectValue(0, Object.class))));
                return null;
            case 161105:
                this.hw.onVideoAdContinuePlay(new aj(ho.pr(valueSetHw.objectValue(0, Object.class))));
                return null;
            case 161106:
                this.hw.onProgressUpdate(valueSetHw.longValue(0), valueSetHw.longValue(1));
                return null;
            case 161107:
                this.hw.onVideoAdComplete(new aj(ho.pr(valueSetHw.objectValue(0, Object.class))));
                return null;
            default:
                return null;
        }
    }
}
