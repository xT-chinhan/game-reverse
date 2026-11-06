package com.byazt.hr;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1840, 18})
public class l implements Function<SparseArray<Object>, Object> {
    private final IMediationViewBinder n;

    public l(IMediationViewBinder iMediationViewBinder) {
        this.n = iMediationViewBinder;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.n == null) {
            return null;
        }
        switch (com.byazt.qvu.s.n(sparseArray).qg().intValue(-99999987)) {
            case 271021:
                return Integer.class.cast(Integer.valueOf(this.n.getLayoutId()));
            case 271022:
                return Integer.class.cast(Integer.valueOf(this.n.getTitleId()));
            case 271023:
                return Integer.class.cast(Integer.valueOf(this.n.getDecriptionTextId()));
            case 271024:
                return Integer.class.cast(Integer.valueOf(this.n.getCallToActionId()));
            case 271025:
                return Integer.class.cast(Integer.valueOf(this.n.getIconImageId()));
            case 271026:
                return Integer.class.cast(Integer.valueOf(this.n.getMainImageId()));
            case 271027:
                return Integer.class.cast(Integer.valueOf(this.n.getMediaViewId()));
            case 271028:
                return Integer.class.cast(Integer.valueOf(this.n.getSourceId()));
            case 271029:
                return Integer.class.cast(Integer.valueOf(this.n.getGroupImage1Id()));
            case 271030:
                return Integer.class.cast(Integer.valueOf(this.n.getGroupImage2Id()));
            case 271031:
                return Integer.class.cast(Integer.valueOf(this.n.getGroupImage3Id()));
            case 271032:
                return Integer.class.cast(Integer.valueOf(this.n.getLogoLayoutId()));
            case 271033:
                return Integer.class.cast(Integer.valueOf(this.n.getShakeViewContainerId()));
            case 271034:
                return this.n.getExtras();
            default:
                return com.byazt.qvu.s.qg.apply(sparseArray);
        }
    }
}
