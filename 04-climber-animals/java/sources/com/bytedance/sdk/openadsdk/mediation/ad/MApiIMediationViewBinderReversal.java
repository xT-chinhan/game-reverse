package com.bytedance.sdk.openadsdk.mediation.ad;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.ms.xr;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class MApiIMediationViewBinderReversal implements IMediationViewBinderReversal {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f3950ms;

    public MApiIMediationViewBinderReversal(Function<SparseArray<Object>, Object> function) {
        this.f3950ms = function;
    }

    public MApiIMediationViewBinderReversal(Bridge bridge) {
        this.f3950ms = xr.ms(bridge);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getLayoutId() {
        if (this.f3950ms != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 271021);
            sparseArray.put(-99999985, Integer.TYPE);
            Integer num = (Integer) this.f3950ms.apply(sparseArray);
            if (num != null) {
                return num.intValue();
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getTitleId() {
        if (this.f3950ms != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 271022);
            sparseArray.put(-99999985, Integer.TYPE);
            Integer num = (Integer) this.f3950ms.apply(sparseArray);
            if (num != null) {
                return num.intValue();
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getDecriptionTextId() {
        if (this.f3950ms != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 271023);
            sparseArray.put(-99999985, Integer.TYPE);
            Integer num = (Integer) this.f3950ms.apply(sparseArray);
            if (num != null) {
                return num.intValue();
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getCallToActionId() {
        if (this.f3950ms != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 271024);
            sparseArray.put(-99999985, Integer.TYPE);
            Integer num = (Integer) this.f3950ms.apply(sparseArray);
            if (num != null) {
                return num.intValue();
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getIconImageId() {
        if (this.f3950ms != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 271025);
            sparseArray.put(-99999985, Integer.TYPE);
            Integer num = (Integer) this.f3950ms.apply(sparseArray);
            if (num != null) {
                return num.intValue();
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getMainImageId() {
        if (this.f3950ms != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 271026);
            sparseArray.put(-99999985, Integer.TYPE);
            Integer num = (Integer) this.f3950ms.apply(sparseArray);
            if (num != null) {
                return num.intValue();
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getMediaViewId() {
        if (this.f3950ms != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 271027);
            sparseArray.put(-99999985, Integer.TYPE);
            Integer num = (Integer) this.f3950ms.apply(sparseArray);
            if (num != null) {
                return num.intValue();
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getSourceId() {
        if (this.f3950ms != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 271028);
            sparseArray.put(-99999985, Integer.TYPE);
            Integer num = (Integer) this.f3950ms.apply(sparseArray);
            if (num != null) {
                return num.intValue();
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getGroupImage1Id() {
        if (this.f3950ms != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 271029);
            sparseArray.put(-99999985, Integer.TYPE);
            Integer num = (Integer) this.f3950ms.apply(sparseArray);
            if (num != null) {
                return num.intValue();
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getGroupImage2Id() {
        if (this.f3950ms != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 271030);
            sparseArray.put(-99999985, Integer.TYPE);
            Integer num = (Integer) this.f3950ms.apply(sparseArray);
            if (num != null) {
                return num.intValue();
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getGroupImage3Id() {
        if (this.f3950ms != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 271031);
            sparseArray.put(-99999985, Integer.TYPE);
            Integer num = (Integer) this.f3950ms.apply(sparseArray);
            if (num != null) {
                return num.intValue();
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getLogoLayoutId() {
        if (this.f3950ms != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 271032);
            sparseArray.put(-99999985, Integer.TYPE);
            Integer num = (Integer) this.f3950ms.apply(sparseArray);
            if (num != null) {
                return num.intValue();
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getShakeViewContainerId() {
        if (this.f3950ms != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 271033);
            sparseArray.put(-99999985, Integer.TYPE);
            Integer num = (Integer) this.f3950ms.apply(sparseArray);
            if (num != null) {
                return num.intValue();
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public Map<String, Integer> getExtras() {
        if (this.f3950ms == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 271034);
        sparseArray.put(-99999985, Map.class);
        return (Map) this.f3950ms.apply(sparseArray);
    }
}
