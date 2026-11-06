package com.bytedance.sdk.openadsdk.mediation.ad;

import android.util.SparseArray;
import com.byazt.vzx.pr;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 78, 79, 80, 81, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TOTAL_CACHED_LEN, 838})
public class MApiIMediationViewBinderReversal implements IMediationViewBinderReversal {
    private final Function<SparseArray<Object>, Object> pr;

    public MApiIMediationViewBinderReversal(Function<SparseArray<Object>, Object> function) {
        this.pr = function;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getLayoutId() {
        if (this.pr == null) {
            return 0;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 271021);
        sparseArray.put(-99999985, Integer.TYPE);
        Integer num = (Integer) this.pr.apply(sparseArray);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getTitleId() {
        if (this.pr == null) {
            return 0;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 271022);
        sparseArray.put(-99999985, Integer.TYPE);
        Integer num = (Integer) this.pr.apply(sparseArray);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getDecriptionTextId() {
        if (this.pr == null) {
            return 0;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 271023);
        sparseArray.put(-99999985, Integer.TYPE);
        Integer num = (Integer) this.pr.apply(sparseArray);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getCallToActionId() {
        if (this.pr == null) {
            return 0;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 271024);
        sparseArray.put(-99999985, Integer.TYPE);
        Integer num = (Integer) this.pr.apply(sparseArray);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getIconImageId() {
        if (this.pr == null) {
            return 0;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 271025);
        sparseArray.put(-99999985, Integer.TYPE);
        Integer num = (Integer) this.pr.apply(sparseArray);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getMainImageId() {
        if (this.pr == null) {
            return 0;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 271026);
        sparseArray.put(-99999985, Integer.TYPE);
        Integer num = (Integer) this.pr.apply(sparseArray);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getMediaViewId() {
        if (this.pr == null) {
            return 0;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 271027);
        sparseArray.put(-99999985, Integer.TYPE);
        Integer num = (Integer) this.pr.apply(sparseArray);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getSourceId() {
        if (this.pr == null) {
            return 0;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 271028);
        sparseArray.put(-99999985, Integer.TYPE);
        Integer num = (Integer) this.pr.apply(sparseArray);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getGroupImage1Id() {
        if (this.pr == null) {
            return 0;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 271029);
        sparseArray.put(-99999985, Integer.TYPE);
        Integer num = (Integer) this.pr.apply(sparseArray);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getGroupImage2Id() {
        if (this.pr == null) {
            return 0;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 271030);
        sparseArray.put(-99999985, Integer.TYPE);
        Integer num = (Integer) this.pr.apply(sparseArray);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getGroupImage3Id() {
        if (this.pr == null) {
            return 0;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 271031);
        sparseArray.put(-99999985, Integer.TYPE);
        Integer num = (Integer) this.pr.apply(sparseArray);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getLogoLayoutId() {
        if (this.pr == null) {
            return 0;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 271032);
        sparseArray.put(-99999985, Integer.TYPE);
        Integer num = (Integer) this.pr.apply(sparseArray);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getShakeViewContainerId() {
        if (this.pr == null) {
            return 0;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 271033);
        sparseArray.put(-99999985, Integer.TYPE);
        Integer num = (Integer) this.pr.apply(sparseArray);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public Map<String, Integer> getExtras() {
        if (this.pr != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 271034);
            sparseArray.put(-99999985, Map.class);
            return (Map) this.pr.apply(sparseArray);
        }
        return null;
    }
}
