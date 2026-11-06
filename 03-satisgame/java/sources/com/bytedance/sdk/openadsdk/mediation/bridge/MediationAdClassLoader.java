package com.bytedance.sdk.openadsdk.mediation.bridge;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.cp.n;
import com.byazt.vx.w;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.init.AdnManagerConfig;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationLoaderConfig;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 55, 56, 57, 58, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FFMPEG_LOG_LEVEL, 1605})
public class MediationAdClassLoader extends com.byazt.ku.n {
    private static volatile MediationAdClassLoader n;

    @Override // com.byazt.ku.n
    public SparseArray<Object> get() {
        return null;
    }

    private MediationAdClassLoader() {
    }

    public static MediationAdClassLoader getInstance() {
        if (n == null) {
            synchronized (MediationAdClassLoader.class) {
                n = new MediationAdClassLoader();
            }
        }
        return n;
    }

    @Override // com.byazt.ku.n
    public <T> T applyFunction(int i, ValueSet valueSet, Class<T> cls) {
        return (T) n(i, valueSet, cls);
    }

    private <T> T n(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8106) {
            n(MediationLoaderConfig.create(valueSet), valueSet);
            return null;
        }
        if (i == 8229) {
            return (T) n(valueSet.stringValue(AVMDLDataLoader.KeyIsLiveMobileUploadAllow), valueSet.stringValue(8560));
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0021  */
    private Boolean n(String str, String str2) {
        try {
            Class.forName(str2);
            return Boolean.TRUE;
        } catch (Throwable th) {
            w.n(th);
            try {
                Class.forName(str);
                return Boolean.TRUE;
            } catch (ClassNotFoundException e) {
                e = e;
                w.n(e);
                if (n(str)) {
                    w.l(MediationConstant.TAG, "当前接入的ADN-Adapter版本可能不适配，7000版本起SDK和所有Adapter都需要升级，请检查接入的版本是否正确");
                }
                return Boolean.FALSE;
            } catch (NoClassDefFoundError e2) {
                e = e2;
                w.n(e);
                if (n(str)) {
                    w.l(MediationConstant.TAG, "当前接入的ADN-Adapter版本可能不适配，7000版本起SDK和所有Adapter都需要升级，请检查接入的版本是否正确");
                }
                return Boolean.FALSE;
            } catch (Throwable th2) {
                w.n(th2);
                return Boolean.FALSE;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x004a  */
    /* JADX WARN: Code duplicated, block: B:22:? A[RETURN, SYNTHETIC] */
    private void n(MediationLoaderConfig mediationLoaderConfig, ValueSet valueSet) {
        try {
            Function<SparseArray<Object>, Object> adapterManager = AdnManagerConfig.getAdapterManager(mediationLoaderConfig.getADNName());
            if (adapterManager != null) {
                SparseArray<Object> sparseArray = new SparseArray<>();
                sparseArray.put(-99999987, Integer.valueOf(mediationLoaderConfig.getManagerLoaderType()));
                sparseArray.put(-99999985, Object.class);
                n(adapterManager.apply(sparseArray), valueSet);
                return;
            }
            n(Class.forName(mediationLoaderConfig.getClassName()).newInstance(), valueSet);
        } catch (ClassNotFoundException e) {
            e = e;
            w.n(e);
            if (n(null)) {
                w.l(MediationConstant.TAG, "当前接入的ADN-Adapter版本可能不适配，7000版本起SDK和所有Adapter都需要升级，请检查接入的版本是否正确");
            }
        } catch (IllegalAccessException e2) {
            e = e2;
            e.printStackTrace();
        } catch (InstantiationException e3) {
            e = e3;
            e.printStackTrace();
        } catch (NoClassDefFoundError e4) {
            e = e4;
            w.n(e);
            if (n(null)) {
                w.l(MediationConstant.TAG, "当前接入的ADN-Adapter版本可能不适配，7000版本起SDK和所有Adapter都需要升级，请检查接入的版本是否正确");
            }
        }
    }

    private void n(Object obj, ValueSet valueSet) {
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

    private boolean n(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("com.bytedance.msdk.adapter.");
    }
}
