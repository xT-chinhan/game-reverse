package com.bytedance.sdk.openadsdk.mediation.bridge.custom;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.ms.ms.ms.ms.xr;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.ab;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationLoaderConfig;
import com.bytedance.sdk.openadsdk.mediation.ms.ms;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MediationCustomAdBaseLoader extends ms implements Bridge {
    public Function<SparseArray<Object>, Object> mGmAdLoader;

    public abstract <T> T callMethod(int i, ValueSet valueSet, Class<T> cls);

    public abstract void load(Context context, AdSlot adSlot, com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig mediationCustomServiceConfig);

    public void onDestroy() {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void receiveBidResult(boolean z, double d, int i, Map<String, Object> map) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    public final void loadInner(Context context, AdSlot adSlot, com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig mediationCustomServiceConfig, Function<SparseArray<Object>, Object> function) {
        this.mGmAdLoader = function;
        ms();
        if (adSlot == null) {
            try {
                adSlot = new AdSlot.Builder().build();
            } catch (Exception e) {
                ab.ms(e);
                return;
            }
        }
        load(context, adSlot, mediationCustomServiceConfig);
    }

    private void ms() {
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
        if (this.mGmAdLoader == null) {
            return "";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 8137);
        sparseArray.put(-99999985, String.class);
        return (String) this.mGmAdLoader.apply(sparseArray);
    }

    public final Object getExtraDataNoParse() {
        if (this.mGmAdLoader == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 8224);
        sparseArray.put(-99999985, Object.class);
        return this.mGmAdLoader.apply(sparseArray);
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
        if (this.mGmAdLoader == null || map == null) {
            return;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(8075, map);
        sparseArray.put(-99999987, 8227);
        sparseArray.put(-99999985, Void.class);
        this.mGmAdLoader.apply(sparseArray);
    }

    public final Bridge getGMBridge() {
        if (this.mGmAdLoader == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 8127);
        sparseArray.put(-99999985, Bridge.class);
        return (Bridge) this.mGmAdLoader.apply(sparseArray);
    }

    public final void load(Context context, ValueSet valueSet) {
        MediationLoaderConfig mediationLoaderConfigCreate = MediationLoaderConfig.create(valueSet);
        ValueSet adSlotValueSet = mediationLoaderConfigCreate.getAdSlotValueSet();
        loadInner(context, com.bytedance.sdk.openadsdk.mediation.xr.ms.ms.ms(adSlotValueSet != null ? adSlotValueSet.sparseArray() : new SparseArray<>()), new com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig(mediationLoaderConfigCreate.getMediationCustomServiceConfigValue()), mediationLoaderConfigCreate.getGMCustomAdLoader());
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8241) {
            load((Context) valueSet.objectValue(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, Context.class), (ValueSet) valueSet.objectValue(8424, ValueSet.class));
        } else if (i == 8225) {
            MediationApiLog.i(MediationConstant.TAG, "MediationCustomBaseLoader receiveBidResult");
            receiveBidResult(valueSet.booleanValue(8406), valueSet.doubleValue(8407), valueSet.intValue(8408), (Map) valueSet.objectValue(8075, Map.class));
        } else if (i == 8149) {
            MediationApiLog.i(MediationConstant.TAG, "MediationCustomBaseLoader onPause");
            onPause();
        } else if (i == 8148) {
            MediationApiLog.i(MediationConstant.TAG, "MediationCustomBaseLoader onPause");
            onResume();
        } else if (i == 8109) {
            MediationApiLog.i(MediationConstant.TAG, "MediationCustomBaseLoader onDestroy");
            onDestroy();
        }
        return (T) callMethod(i, valueSet, cls);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ms.ms
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        if (i == 8241) {
            load((Context) objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold), Context.class, null), xr.ms((SparseArray<Object>) objectValue(sparseArray.get(8424), SparseArray.class, null)).xr());
        } else if (i == 8225) {
            MediationApiLog.i(MediationConstant.TAG, "MediationCustomBaseLoader receiveBidResult");
            receiveBidResult(((Boolean) objectValue(sparseArray.get(8406), Boolean.class, Boolean.FALSE)).booleanValue(), ((Double) objectValue(sparseArray.get(8407), Double.class, Double.valueOf(0.0d))).doubleValue(), ((Integer) objectValue(sparseArray.get(8408), Integer.class, 0)).intValue(), (Map) objectValue(sparseArray.get(8075), Map.class, null));
        } else if (i == 8149) {
            MediationApiLog.i(MediationConstant.TAG, "MediationCustomBaseLoader onPause");
            onPause();
        } else if (i == 8148) {
            MediationApiLog.i(MediationConstant.TAG, "MediationCustomBaseLoader onPause");
            onResume();
        } else if (i == 8109) {
            MediationApiLog.i(MediationConstant.TAG, "MediationCustomBaseLoader onDestroy");
            onDestroy();
        }
        return (T) callMethod(i, xr.ms(sparseArray).xr(), cls);
    }
}
