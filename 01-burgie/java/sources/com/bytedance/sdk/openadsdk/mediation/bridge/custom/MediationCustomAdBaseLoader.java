package com.bytedance.sdk.openadsdk.mediation.bridge.custom;

import android.content.Context;
import android.util.SparseArray;
import com.byazt.bm.hw;
import com.byazt.dea.uc;
import com.byazt.ij.hn;
import com.byazt.vzx.pr;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationLoaderConfig;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 78, 79, 80, 81, 232, 233, 1691})
public abstract class MediationCustomAdBaseLoader extends com.byazt.f.pr {
    public Function<SparseArray<Object>, Object> mGmAdLoader;

    public abstract <T> T callMethod(int i, ValueSet valueSet, Class<T> cls);

    public abstract void load(Context context, AdSlot adSlot, com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig mediationCustomServiceConfig);

    public final void loadInner(Context context, AdSlot adSlot, com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig mediationCustomServiceConfig, Function<SparseArray<Object>, Object> function) {
        this.mGmAdLoader = function;
        pr();
        if (adSlot == null) {
            try {
                adSlot = new AdSlot.Builder().build();
            } catch (Exception e) {
                uc.pr(e);
                return;
            }
        }
        load(context, adSlot, mediationCustomServiceConfig);
    }

    private void pr() {
        if (this.mGmAdLoader != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(8405, this);
            sparseArray.put(-99999987, 8221);
            sparseArray.put(-99999985, String.class);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    public final void callLoadFail(int i, String str) {
        if (this.mGmAdLoader != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(8014, Integer.valueOf(i));
            sparseArray.put(8015, str);
            sparseArray.put(-99999987, 8123);
            sparseArray.put(-99999985, String.class);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    public final String getAdm() {
        if (this.mGmAdLoader != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8137);
            sparseArray.put(-99999985, String.class);
            return (String) this.mGmAdLoader.apply(sparseArray);
        }
        return "";
    }

    public final Object getExtraDataNoParse() {
        if (this.mGmAdLoader != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8224);
            sparseArray.put(-99999985, Object.class);
            return this.mGmAdLoader.apply(sparseArray);
        }
        return null;
    }

    public final int getBiddingType() {
        if (this.mGmAdLoader == null) {
            return 0;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 8226);
        sparseArray.put(-99999985, Integer.class);
        Integer num = (Integer) this.mGmAdLoader.apply(sparseArray);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public final void setMediaExtraInfo(Map<String, Object> map) {
        if (this.mGmAdLoader != null && map != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(8075, map);
            sparseArray.put(-99999987, 8227);
            sparseArray.put(-99999985, Void.class);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    public void receiveBidResult(boolean z, double d, int i, Map<String, Object> map) {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onDestroy() {
    }

    public final void load(Context context, ValueSet valueSet) {
        MediationLoaderConfig mediationLoaderConfigCreate = MediationLoaderConfig.create(valueSet);
        ValueSet adSlotValueSet = mediationLoaderConfigCreate.getAdSlotValueSet();
        loadInner(context, hw.pr(adSlotValueSet != null ? adSlotValueSet.sparseArray() : new SparseArray<>()), new com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig(mediationLoaderConfigCreate.getMediationCustomServiceConfigValue()), mediationLoaderConfigCreate.getGMCustomAdLoader());
    }

    @Override // com.byazt.f.pr
    public <T> T applyFunction(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8241) {
            load((Context) valueSet.objectValue(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, Context.class), hn.pr((SparseArray<Object>) valueSet.objectValue(8424, SparseArray.class)).hw());
        } else if (i == 8225) {
            uc.hn(MediationConstant.TAG, "MediationCustomBaseLoader receiveBidResult");
            receiveBidResult(valueSet.booleanValue(8406), valueSet.doubleValue(8407), valueSet.intValue(8408), (Map) valueSet.objectValue(8075, Map.class));
        } else if (i == 8149) {
            uc.hn(MediationConstant.TAG, "MediationCustomBaseLoader onPause");
            onPause();
        } else if (i == 8148) {
            uc.hn(MediationConstant.TAG, "MediationCustomBaseLoader onPause");
            onResume();
        } else if (i == 8109) {
            uc.hn(MediationConstant.TAG, "MediationCustomBaseLoader onDestroy");
            onDestroy();
        }
        return (T) callMethod(i, valueSet, cls);
    }

    @Override // com.byazt.f.pr
    public SparseArray<Object> get() {
        return null;
    }

    protected Integer pr(MediationConstant.AdIsReadyStatus adIsReadyStatus) {
        if (adIsReadyStatus == MediationConstant.AdIsReadyStatus.ADN_NO_READY_API) {
            return 1;
        }
        if (adIsReadyStatus == MediationConstant.AdIsReadyStatus.AD_IS_READY) {
            return 2;
        }
        if (adIsReadyStatus == MediationConstant.AdIsReadyStatus.AD_IS_EXPIRED) {
            return 3;
        }
        if (adIsReadyStatus != MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY) {
            return 1;
        }
        return 4;
    }
}
