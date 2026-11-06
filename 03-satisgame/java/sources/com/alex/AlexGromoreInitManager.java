package com.alex;

import android.content.Context;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.MediationInitCallback;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfig;
import java.lang.reflect.Constructor;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AlexGromoreInitManager extends ATInitMediation {
    private static final String f = "AlexGromoreInitManager";
    private static volatile AlexGromoreInitManager g;
    MediationConfig.Builder a;
    TTCustomController b;
    private final String d = "com.anythink.network.toutiao.TTATInitManager";
    private boolean e = false;
    private boolean c = true;

    private AlexGromoreInitManager() {
        b();
    }

    private Object a() {
        try {
            Constructor declaredConstructor = Class.forName("com.anythink.network.toutiao.TTATInitManager").asSubclass(ATInitMediation.class).getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            ATInitMediation aTInitMediation = (ATInitMediation) declaredConstructor.newInstance(new Object[0]);
            return aTInitMediation.getClass().getMethod("getInstance", new Class[0]).invoke(aTInitMediation, new Object[0]);
        } catch (Throwable th) {
            if (ATSDK.isNetworkLogDebug()) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private void b() {
        try {
            Object objA = a();
            Object objInvoke = objA.getClass().getMethod("isMediationCSJ", new Class[0]).invoke(objA, new Object[0]);
            if (objInvoke instanceof Boolean) {
                this.e = ((Boolean) objInvoke).booleanValue();
            }
        } catch (Throwable th) {
            if (ATSDK.isNetworkLogDebug()) {
                th.printStackTrace();
            }
        }
    }

    public static AlexGromoreInitManager getInstance() {
        if (g == null) {
            synchronized (AlexGromoreInitManager.class) {
                if (g == null) {
                    g = new AlexGromoreInitManager();
                }
            }
        }
        return g;
    }

    @Override // com.anythink.core.api.ATInitMediation
    public int getAdapterBridgeVersion() {
        return 1;
    }

    public MediationConfig.Builder getMediationConfigBuilder() {
        return this.a;
    }

    public TTCustomController getTtCustomController() {
        return this.b;
    }

    @Override // com.anythink.core.api.ATInitMediation
    public void initSDK(Context context, Map<String, Object> map, MediationInitCallback mediationInitCallback) {
    }

    public boolean isOpenDirectDownload() {
        return this.c;
    }

    public void setIsOpenDirectDownload(boolean z) {
        this.c = z;
        if (this.e) {
            try {
                Object objA = a();
                objA.getClass().getMethod("setIsOpenDirectDownload", Boolean.TYPE).invoke(objA, Boolean.valueOf(z));
            } catch (Throwable unused) {
            }
        }
    }

    public void setMediationConfigBuilder(MediationConfig.Builder builder) {
        this.a = builder;
        if (this.e) {
            try {
                Object objA = a();
                objA.getClass().getMethod("setMediationConfigBuilder", MediationConfig.Builder.class).invoke(objA, builder);
            } catch (Throwable unused) {
            }
        }
    }

    public void setTtCustomController(TTCustomController tTCustomController) {
        this.b = tTCustomController;
        if (this.e) {
            try {
                Object objA = a();
                objA.getClass().getMethod("setTtCustomController", TTCustomController.class).invoke(objA, tTCustomController);
            } catch (Throwable unused) {
            }
        }
    }
}
