package com.byazt.oc;

import android.util.SparseArray;
import com.byazt.mo.k;
import com.byazt.mo.rv;
import com.byazt.qvu.s;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 891, 19})
public class n implements Function<SparseArray<Object>, Object> {
    public ValueSet n = s.n;
    public final TTFeedAd.VideoAdListener qg;

    public n(TTFeedAd.VideoAdListener videoAdListener) {
        this.qg = videoAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.qg == null) {
            return null;
        }
        ValueSet valueSetQg = s.n(sparseArray).qg();
        switch (valueSetQg.intValue(-99999987)) {
            case 161101:
                this.qg.onVideoLoad(new rv(k.n(valueSetQg.objectValue(0, Object.class))));
                return null;
            case 161102:
                this.qg.onVideoError(valueSetQg.intValue(0), valueSetQg.intValue(1));
                return null;
            case 161103:
                this.qg.onVideoAdPaused(new rv(k.n(valueSetQg.objectValue(0, Object.class))));
                return null;
            case 161104:
                this.qg.onVideoAdStartPlay(new rv(k.n(valueSetQg.objectValue(0, Object.class))));
                return null;
            case 161105:
                this.qg.onVideoAdContinuePlay(new rv(k.n(valueSetQg.objectValue(0, Object.class))));
                return null;
            case 161106:
                this.qg.onProgressUpdate(valueSetQg.longValue(0), valueSetQg.longValue(1));
                return null;
            case 161107:
                this.qg.onVideoAdComplete(new rv(k.n(valueSetQg.objectValue(0, Object.class))));
                return null;
            default:
                return null;
        }
    }
}
