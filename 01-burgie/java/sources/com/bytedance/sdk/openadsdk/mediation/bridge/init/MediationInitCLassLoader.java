package com.bytedance.sdk.openadsdk.mediation.bridge.init;

import android.util.SparseArray;
import com.byazt.dea.uc;
import com.byazt.vzx.pr;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationInitConfig;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 78, 79, 80, 81, 232, 82, 1036})
public class MediationInitCLassLoader extends com.byazt.f.pr {
    @Override // com.byazt.f.pr
    public <T> T applyFunction(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8100) {
            return (T) Boolean.valueOf(pr(valueSet));
        }
        return null;
    }

    @Override // com.byazt.f.pr
    public SparseArray<Object> get() {
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x008a  */
    private <T> boolean pr(ValueSet valueSet) {
        boolean zInitAdnManager;
        Class<?> cls;
        boolean z;
        MediationInitConfig mediationInitConfigCreate = MediationInitConfig.create(valueSet);
        boolean z2 = true;
        try {
            try {
                if (mediationInitConfigCreate.isCustom() && mediationInitConfigCreate.getCustomInitConfigValueSet() != null) {
                    try {
                        cls = Class.forName(mediationInitConfigCreate.getCustomInitConfigValueSet().stringValue(8536));
                        z = true;
                    } catch (ClassNotFoundException e) {
                        e = e;
                        uc.pr(e);
                        if (!z2) {
                            uc.c(MediationConstant.TAG, "当前接入的ADN-Adapter版本可能不适配，7000版本起SDK和所有Adapter都需要升级，请检查接入的版本是否正确");
                        }
                        return false;
                    } catch (NoClassDefFoundError e2) {
                        e = e2;
                        uc.pr(e);
                        if (!z2) {
                            uc.c(MediationConstant.TAG, "当前接入的ADN-Adapter版本可能不适配，7000版本起SDK和所有Adapter都需要升级，请检查接入的版本是否正确");
                        }
                        return false;
                    }
                } else {
                    String adapterManagerClassName = mediationInitConfigCreate.getAdapterManagerClassName();
                    String aDNName = mediationInitConfigCreate.getADNName();
                    if (adapterManagerClassName != null && aDNName != null) {
                        zInitAdnManager = AdnManagerConfig.initAdnManager(adapterManagerClassName, aDNName);
                    } else {
                        zInitAdnManager = false;
                    }
                    Function<SparseArray<Object>, Object> adapterManager = zInitAdnManager ? AdnManagerConfig.getAdapterManager(aDNName) : null;
                    if (adapterManager != null) {
                        SparseArray<Object> sparseArray = new SparseArray<>();
                        sparseArray.put(-99999987, 10000);
                        sparseArray.put(-99999985, Object.class);
                        pr(adapterManager.apply(sparseArray), valueSet);
                        return true;
                    }
                    cls = Class.forName(mediationInitConfigCreate.getClassName());
                    z = false;
                }
                try {
                    pr(cls.newInstance(), valueSet);
                    return true;
                } catch (ClassNotFoundException | NoClassDefFoundError e3) {
                    e = e3;
                    z2 = z;
                    uc.pr(e);
                    if (!z2) {
                        uc.c(MediationConstant.TAG, "当前接入的ADN-Adapter版本可能不适配，7000版本起SDK和所有Adapter都需要升级，请检查接入的版本是否正确");
                    }
                    return false;
                }
            } catch (Throwable th) {
                uc.pr(th);
                return false;
            }
        } catch (ClassNotFoundException | NoClassDefFoundError e4) {
            e = e4;
            z2 = false;
        }
    }

    private void pr(Object obj, ValueSet valueSet) {
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
