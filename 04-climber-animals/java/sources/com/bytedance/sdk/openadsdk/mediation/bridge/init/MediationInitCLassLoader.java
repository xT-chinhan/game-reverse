package com.bytedance.sdk.openadsdk.mediation.bridge.init;

import android.util.SparseArray;
import com.bykv.ms.ms.ms.ms.xr;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.api.ab;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationInitConfig;
import com.bytedance.sdk.openadsdk.mediation.ms.ms;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class MediationInitCLassLoader extends ms implements Bridge {
    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i != 8100) {
            return null;
        }
        ms(valueSet != null ? valueSet.sparseArray() : new SparseArray<>());
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ms.ms
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        if (i != 8100) {
            return null;
        }
        ms(sparseArray);
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0077  */
    /* JADX WARN: Code duplicated, block: B:29:? A[RETURN, SYNTHETIC] */
    private <T> void ms(SparseArray<Object> sparseArray) {
        Class<?> cls;
        MediationInitConfig mediationInitConfigCreate = MediationInitConfig.create(xr.ms(sparseArray).xr());
        boolean z = false;
        try {
            if (mediationInitConfigCreate.isCustom() && mediationInitConfigCreate.getCustomInitConfigValueSet() != null) {
                z = true;
                cls = Class.forName(mediationInitConfigCreate.getCustomInitConfigValueSet().stringValue(8536));
            } else {
                cls = Class.forName(mediationInitConfigCreate.getClassName());
            }
            Object objNewInstance = cls.newInstance();
            if (objNewInstance instanceof Function) {
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, TTAppContextHolder.getContext());
                sparseArray2.put(8424, sparseArray);
                sparseArray2.put(-99999987, 8240);
                sparseArray2.put(-99999985, null);
                ((Function) objNewInstance).apply(sparseArray2);
            }
        } catch (ClassNotFoundException e) {
            e = e;
            ab.ms(e);
            if (z) {
            }
            ab.ka(MediationConstant.TAG, "当前接入的ADN-Adapter版本可能不适配，68版本起SDK和所有Adapter都需要升级，请检查接入的版本是否正确");
        } catch (IllegalAccessException e2) {
            ab.ms(e2);
        } catch (InstantiationException e3) {
            ab.ms(e3);
        } catch (NoClassDefFoundError e4) {
            e = e4;
            ab.ms(e);
            if (z) {
                ab.ka(MediationConstant.TAG, "当前接入的ADN-Adapter版本可能不适配，68版本起SDK和所有Adapter都需要升级，请检查接入的版本是否正确");
            }
        }
    }
}
