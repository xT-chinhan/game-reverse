package com.bytedance.sdk.openadsdk.mediation.bridge;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.dea.uc;
import com.byazt.vzx.pr;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.init.AdnManagerConfig;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationLoaderConfig;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 78, 79, 80, 81, 232, 1480})
public class MediationAdClassLoader extends com.byazt.f.pr {
    private static volatile MediationAdClassLoader pr;

    private MediationAdClassLoader() {
    }

    public static MediationAdClassLoader getInstance() {
        if (pr == null) {
            synchronized (MediationAdClassLoader.class) {
                pr = new MediationAdClassLoader();
            }
        }
        return pr;
    }

    @Override // com.byazt.f.pr
    public <T> T applyFunction(int i, ValueSet valueSet, Class<T> cls) {
        return (T) pr(i, valueSet, cls);
    }

    private <T> T pr(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8106) {
            pr(MediationLoaderConfig.create(valueSet), valueSet);
            return null;
        }
        if (i == 8229) {
            return (T) pr(valueSet.stringValue(AVMDLDataLoader.KeyIsLiveMobileUploadAllow), valueSet.stringValue(8560));
        }
        return null;
    }

    @Override // com.byazt.f.pr
    public SparseArray<Object> get() {
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0021  */
    private Boolean pr(String str, String str2) {
        try {
            Class.forName(str2);
            return Boolean.TRUE;
        } catch (Throwable th) {
            uc.pr(th);
            try {
                Class.forName(str);
                return Boolean.TRUE;
            } catch (ClassNotFoundException e) {
                e = e;
                uc.pr(e);
                if (pr(str)) {
                    uc.c(MediationConstant.TAG, "当前接入的ADN-Adapter版本可能不适配，7000版本起SDK和所有Adapter都需要升级，请检查接入的版本是否正确");
                }
                return Boolean.FALSE;
            } catch (NoClassDefFoundError e2) {
                e = e2;
                uc.pr(e);
                if (pr(str)) {
                    uc.c(MediationConstant.TAG, "当前接入的ADN-Adapter版本可能不适配，7000版本起SDK和所有Adapter都需要升级，请检查接入的版本是否正确");
                }
                return Boolean.FALSE;
            } catch (Throwable th2) {
                uc.pr(th2);
                return Boolean.FALSE;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x004b  */
    /* JADX WARN: Code duplicated, block: B:22:? A[RETURN, SYNTHETIC] */
    private void pr(MediationLoaderConfig mediationLoaderConfig, ValueSet valueSet) {
        try {
            Function<SparseArray<Object>, Object> adapterManager = AdnManagerConfig.getAdapterManager(mediationLoaderConfig.getADNName());
            if (adapterManager != null) {
                SparseArray<Object> sparseArray = new SparseArray<>();
                sparseArray.put(-99999987, Integer.valueOf(mediationLoaderConfig.getManagerLoaderType()));
                sparseArray.put(-99999985, Object.class);
                pr(adapterManager.apply(sparseArray), valueSet);
                return;
            }
            pr(Class.forName(mediationLoaderConfig.getClassName()).newInstance(), valueSet);
        } catch (ClassNotFoundException e) {
            e = e;
            uc.pr(e);
            if (pr(null)) {
                uc.c(MediationConstant.TAG, "当前接入的ADN-Adapter版本可能不适配，7000版本起SDK和所有Adapter都需要升级，请检查接入的版本是否正确");
            }
        } catch (IllegalAccessException e2) {
            e = e2;
            e.printStackTrace();
        } catch (InstantiationException e3) {
            e = e3;
            e.printStackTrace();
        } catch (NoClassDefFoundError e4) {
            e = e4;
            uc.pr(e);
            if (pr(null)) {
                uc.c(MediationConstant.TAG, "当前接入的ADN-Adapter版本可能不适配，7000版本起SDK和所有Adapter都需要升级，请检查接入的版本是否正确");
            }
        }
    }

    private void pr(Object obj, ValueSet valueSet) {
        SparseArray<Object> sparseArray = valueSet.sparseArray();
        if (obj instanceof Function) {
            Function function = (Function) obj;
            SparseArray sparseArray2 = new SparseArray();
            SparseArray<Object> sparseArray3 = null;
            sparseArray2.put(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, (Context) objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold), Context.class, null));
            Object objObjectValue = objectValue(sparseArray.get(8424), Object.class, null);
            if (objObjectValue instanceof ValueSet) {
                sparseArray3 = ((ValueSet) objObjectValue).sparseArray();
            } else if (objObjectValue instanceof SparseArray) {
                sparseArray3 = (SparseArray) objObjectValue;
            }
            if (sparseArray3 != null) {
                sparseArray2.put(8424, sparseArray3);
            } else {
                sparseArray2.put(8424, sparseArray);
            }
            sparseArray2.put(-99999987, 8241);
            sparseArray2.put(-99999985, Void.class);
            function.apply(sparseArray2);
        }
    }

    private boolean pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("com.bytedance.msdk.adapter.");
    }
}
