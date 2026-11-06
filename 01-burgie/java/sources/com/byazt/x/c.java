package com.byazt.x;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 121, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c implements Function<SparseArray<Object>, Object> {
    private final IMediationViewBinder pr;

    public c(IMediationViewBinder iMediationViewBinder) {
        this.pr = iMediationViewBinder;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.pr == null) {
            return null;
        }
        switch (com.byazt.ij.hn.pr(sparseArray).hw().intValue(-99999987)) {
            case 271021:
                return Integer.class.cast(Integer.valueOf(this.pr.getLayoutId()));
            case 271022:
                return Integer.class.cast(Integer.valueOf(this.pr.getTitleId()));
            case 271023:
                return Integer.class.cast(Integer.valueOf(this.pr.getDecriptionTextId()));
            case 271024:
                return Integer.class.cast(Integer.valueOf(this.pr.getCallToActionId()));
            case 271025:
                return Integer.class.cast(Integer.valueOf(this.pr.getIconImageId()));
            case 271026:
                return Integer.class.cast(Integer.valueOf(this.pr.getMainImageId()));
            case 271027:
                return Integer.class.cast(Integer.valueOf(this.pr.getMediaViewId()));
            case 271028:
                return Integer.class.cast(Integer.valueOf(this.pr.getSourceId()));
            case 271029:
                return Integer.class.cast(Integer.valueOf(this.pr.getGroupImage1Id()));
            case 271030:
                return Integer.class.cast(Integer.valueOf(this.pr.getGroupImage2Id()));
            case 271031:
                return Integer.class.cast(Integer.valueOf(this.pr.getGroupImage3Id()));
            case 271032:
                return Integer.class.cast(Integer.valueOf(this.pr.getLogoLayoutId()));
            case 271033:
                return Integer.class.cast(Integer.valueOf(this.pr.getShakeViewContainerId()));
            case 271034:
                return this.pr.getExtras();
            default:
                return com.byazt.ij.hn.hw.apply(sparseArray);
        }
    }
}
