package com.bytedance.sdk.openadsdk.mediation.bridge;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.ms.ms.ms.ms.xr;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.api.ab;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationLoaderConfig;
import com.bytedance.sdk.openadsdk.mediation.ms.ms;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class MediationAdClassLoader extends ms implements Bridge {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile MediationAdClassLoader f3968ms;

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    private MediationAdClassLoader() {
    }

    public static MediationAdClassLoader getInstance() {
        if (f3968ms == null) {
            synchronized (MediationAdClassLoader.class) {
                f3968ms = new MediationAdClassLoader();
            }
        }
        return f3968ms;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0035  */
    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        String className;
        if (i == 8106) {
            MediationLoaderConfig mediationLoaderConfigCreate = MediationLoaderConfig.create(valueSet);
            valueSet.objectValue(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, Context.class);
            try {
                try {
                    className = mediationLoaderConfigCreate.getClassName();
                    try {
                        ms(Class.forName(className).newInstance(), valueSet);
                    } catch (ClassNotFoundException e) {
                        e = e;
                        ab.ms(e);
                        if (ms(className)) {
                            ab.ka(MediationConstant.TAG, "当前接入的ADN-Adapter版本可能不适配，68版本起SDK和所有Adapter都需要升级，请检查接入的版本是否正确");
                        }
                    } catch (NoClassDefFoundError e2) {
                        e = e2;
                        ab.ms(e);
                        if (ms(className)) {
                            ab.ka(MediationConstant.TAG, "当前接入的ADN-Adapter版本可能不适配，68版本起SDK和所有Adapter都需要升级，请检查接入的版本是否正确");
                        }
                    }
                } catch (IllegalAccessException | InstantiationException e3) {
                    e3.printStackTrace();
                }
            } catch (ClassNotFoundException | NoClassDefFoundError e4) {
                e = e4;
                className = null;
            }
        } else if (i == 8229) {
            String strStringValue = valueSet.stringValue(AVMDLDataLoader.KeyIsLiveMobileUploadAllow);
            try {
                Class.forName(strStringValue);
                return (T) Boolean.TRUE;
            } catch (ClassNotFoundException | NoClassDefFoundError e5) {
                ab.ms(e5);
                if (ms(strStringValue)) {
                    ab.ka(MediationConstant.TAG, "当前接入的ADN-Adapter版本可能不适配，68版本起SDK和所有Adapter都需要升级，请检查接入的版本是否正确");
                }
                return (T) Boolean.FALSE;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003e  */
    @Override // com.bytedance.sdk.openadsdk.mediation.ms.ms
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        String className;
        if (i == 8106) {
            try {
                try {
                    className = MediationLoaderConfig.create(xr.ms(sparseArray).xr()).getClassName();
                    try {
                        ms(Class.forName(className).newInstance(), xr.ms(sparseArray).xr());
                    } catch (ClassNotFoundException e) {
                        e = e;
                        ab.ms(e);
                        if (ms(className)) {
                            ab.ka(MediationConstant.TAG, "当前接入的ADN-Adapter版本可能不适配，68版本起SDK和所有Adapter都需要升级，请检查接入的版本是否正确");
                        }
                    } catch (NoClassDefFoundError e2) {
                        e = e2;
                        ab.ms(e);
                        if (ms(className)) {
                            ab.ka(MediationConstant.TAG, "当前接入的ADN-Adapter版本可能不适配，68版本起SDK和所有Adapter都需要升级，请检查接入的版本是否正确");
                        }
                    }
                } catch (IllegalAccessException | InstantiationException e3) {
                    e3.printStackTrace();
                }
            } catch (ClassNotFoundException | NoClassDefFoundError e4) {
                e = e4;
                className = null;
            }
        } else if (i == 8229) {
            String str = (String) objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveMobileUploadAllow), String.class, null);
            try {
                Class.forName(str);
                return (T) Boolean.TRUE;
            } catch (ClassNotFoundException | NoClassDefFoundError e5) {
                ab.ms(e5);
                if (ms(str)) {
                    ab.ka(MediationConstant.TAG, "当前接入的ADN-Adapter版本可能不适配，68版本起SDK和所有Adapter都需要升级，请检查接入的版本是否正确");
                }
                return (T) Boolean.FALSE;
            }
        }
        return null;
    }

    private void ms(Object obj, ValueSet valueSet) {
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

    private boolean ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("com.bytedance.msdk.adapter.");
    }
}
