package com.bytedance.sdk.openadsdk.mediation.bridge.init;

import android.util.SparseArray;
import com.byazt.cp.n;
import com.byazt.vx.w;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationInitConfig;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 55, 56, 57, 58, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FFMPEG_LOG_LEVEL, 59, TTAdConstant.VALUE_CLICK_AREA_SAAS_NORMAL})
public class MediationInitCLassLoader extends com.byazt.ku.n {
    @Override // com.byazt.ku.n
    public SparseArray<Object> get() {
        return null;
    }

    @Override // com.byazt.ku.n
    public <T> T applyFunction(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8100) {
            return (T) Boolean.valueOf(n(valueSet));
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0087  */
    private <T> boolean n(ValueSet valueSet) {
        boolean z;
        Class<?> cls;
        boolean z2;
        MediationInitConfig mediationInitConfigCreate = MediationInitConfig.create(valueSet);
        try {
            try {
                z = true;
                if (mediationInitConfigCreate.isCustom() && mediationInitConfigCreate.getCustomInitConfigValueSet() != null) {
                    try {
                        cls = Class.forName(mediationInitConfigCreate.getCustomInitConfigValueSet().stringValue(8536));
                        z2 = true;
                    } catch (ClassNotFoundException e) {
                        e = e;
                        w.n(e);
                        if (!z) {
                            w.l(MediationConstant.TAG, "当前接入的ADN-Adapter版本可能不适配，7000版本起SDK和所有Adapter都需要升级，请检查接入的版本是否正确");
                        }
                        return false;
                    } catch (NoClassDefFoundError e2) {
                        e = e2;
                        w.n(e);
                        if (!z) {
                            w.l(MediationConstant.TAG, "当前接入的ADN-Adapter版本可能不适配，7000版本起SDK和所有Adapter都需要升级，请检查接入的版本是否正确");
                        }
                        return false;
                    }
                } else {
                    String adapterManagerClassName = mediationInitConfigCreate.getAdapterManagerClassName();
                    String aDNName = mediationInitConfigCreate.getADNName();
                    Function<SparseArray<Object>, Object> adapterManager = (adapterManagerClassName == null || aDNName == null) ? false : AdnManagerConfig.initAdnManager(adapterManagerClassName, aDNName) ? AdnManagerConfig.getAdapterManager(aDNName) : null;
                    if (adapterManager != null) {
                        SparseArray<Object> sparseArray = new SparseArray<>();
                        sparseArray.put(-99999987, 10000);
                        sparseArray.put(-99999985, Object.class);
                        n(adapterManager.apply(sparseArray), valueSet);
                        return true;
                    }
                    cls = Class.forName(mediationInitConfigCreate.getClassName());
                    z2 = false;
                }
                try {
                    n(cls.newInstance(), valueSet);
                    return true;
                } catch (ClassNotFoundException | NoClassDefFoundError e3) {
                    e = e3;
                    z = z2;
                    w.n(e);
                    if (!z) {
                        w.l(MediationConstant.TAG, "当前接入的ADN-Adapter版本可能不适配，7000版本起SDK和所有Adapter都需要升级，请检查接入的版本是否正确");
                    }
                    return false;
                }
            } catch (Throwable th) {
                w.n(th);
                return false;
            }
        } catch (ClassNotFoundException | NoClassDefFoundError e4) {
            e = e4;
            z = false;
        }
    }

    private void n(Object obj, ValueSet valueSet) {
        if (obj instanceof Function) {
            Function function = (Function) obj;
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, TTAppContextHolder.getContext());
            sparseArray.put(8424, valueSet == null ? null : valueSet.sparseArray());
            sparseArray.put(-99999987, 8240);
            sparseArray.put(-99999985, Void.class);
            function.apply(sparseArray);
        }
    }
}
