package com.bytedance.sdk.openadsdk.mediation.bridge.custom;

import android.content.Context;
import android.util.SparseArray;
import com.byazt.cp.n;
import com.byazt.jd.qg;
import com.byazt.qvu.s;
import com.byazt.vx.w;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationLoaderConfig;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 55, 56, 57, 58, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FFMPEG_LOG_LEVEL, MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, 1847})
public abstract class MediationCustomAdBaseLoader extends com.byazt.ku.n {
    public Function<SparseArray<Object>, Object> mGmAdLoader;

    public abstract <T> T callMethod(int i, ValueSet valueSet, Class<T> cls);

    @Override // com.byazt.ku.n
    public SparseArray<Object> get() {
        return null;
    }

    public abstract void load(Context context, AdSlot adSlot, com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig mediationCustomServiceConfig);

    public void onDestroy() {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void receiveBidResult(boolean z, double d, int i, Map<String, Object> map) {
    }

    public final void loadInner(Context context, AdSlot adSlot, com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig mediationCustomServiceConfig, Function<SparseArray<Object>, Object> function) {
        this.mGmAdLoader = function;
        n();
        if (adSlot == null) {
            try {
                adSlot = new AdSlot.Builder().build();
            } catch (Exception e) {
                w.n(e);
                return;
            }
        }
        load(context, adSlot, mediationCustomServiceConfig);
    }

    private void n() {
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

    public final void load(Context context, ValueSet valueSet) {
        MediationLoaderConfig mediationLoaderConfigCreate = MediationLoaderConfig.create(valueSet);
        ValueSet adSlotValueSet = mediationLoaderConfigCreate.getAdSlotValueSet();
        loadInner(context, qg.n(adSlotValueSet != null ? adSlotValueSet.sparseArray() : new SparseArray<>()), new com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig(mediationLoaderConfigCreate.getMediationCustomServiceConfigValue()), mediationLoaderConfigCreate.getGMCustomAdLoader());
    }

    @Override // com.byazt.ku.n
    public <T> T applyFunction(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8241) {
            load((Context) valueSet.objectValue(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, Context.class), s.n((SparseArray<Object>) valueSet.objectValue(8424, SparseArray.class)).qg());
        } else if (i == 8225) {
            w.s(MediationConstant.TAG, "MediationCustomBaseLoader receiveBidResult");
            receiveBidResult(valueSet.booleanValue(8406), valueSet.doubleValue(8407), valueSet.intValue(8408), (Map) valueSet.objectValue(8075, Map.class));
        } else if (i == 8149) {
            w.s(MediationConstant.TAG, "MediationCustomBaseLoader onPause");
            onPause();
        } else if (i == 8148) {
            w.s(MediationConstant.TAG, "MediationCustomBaseLoader onPause");
            onResume();
        } else if (i == 8109) {
            w.s(MediationConstant.TAG, "MediationCustomBaseLoader onDestroy");
            onDestroy();
        }
        return (T) callMethod(i, valueSet, cls);
    }

    protected Integer n(MediationConstant.AdIsReadyStatus adIsReadyStatus) {
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
