package com.smartdigimkt.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.b0.a;
import com.smartdigimkt.b3.q;
import com.smartdigimkt.q3.f;
import com.smartdigimkt.s3.m;
import com.smartdigimkt.sdk.api.format.IMyOfferAdManager;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.u3.b;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class SDMSDK {
    private static volatile SDMSDK instance;
    private static Object lockObject = new Object();
    private volatile boolean mHasInit = false;
    private volatile SDMSetting mSdmSetting = new SDMSetting();
    private volatile ISDMDirectlyOfferSetting mDirectlyOfferSetting = new a();

    public interface InitCallBack {
        void fail(String str);

        void success();
    }

    private SDMSDK() {
    }

    public static SDMSDK getInstance() {
        if (instance == null) {
            synchronized (lockObject) {
                if (instance == null) {
                    instance = new SDMSDK();
                }
            }
        }
        return instance;
    }

    public static void setBundleName(String str) {
        SDKContext.getInstance().h = str;
    }

    public static void setDeepRewardEnabled(boolean z) {
        q.a = z;
    }

    public ISDMDirectlyOfferSetting getDirectlyOfferSetting() {
        return this.mDirectlyOfferSetting;
    }

    public IMyOfferAdManager getMyOfferAdManager() {
        if (b.a == null) {
            synchronized (b.class) {
                if (b.a == null) {
                    b.a = new b();
                }
            }
        }
        return b.a;
    }

    public String getSDKVersion() {
        return "UA_6.5.90";
    }

    public ISDMAdManager getSDMAdManager() {
        return m.a();
    }

    public String getSdkBuildLabel() {
        return "6.5.90.0";
    }

    public SDMSetting getSetting() {
        return this.mSdmSetting;
    }

    public void init(Context context, SDMInitConfig sDMInitConfig) {
        try {
            if (this.mHasInit) {
                return;
            }
            this.mHasInit = true;
            SDKContext.getInstance().a(context, sDMInitConfig);
        } catch (Throwable unused) {
        }
    }

    public void integrationChecking(Context context, Map<String, Object> map, IntegrationCheckListener integrationCheckListener) {
        if (context == null) {
            if (integrationCheckListener != null) {
                integrationCheckListener.onValidationFail("context is null");
                return;
            }
            return;
        }
        com.smartdigimkt.x3.b bVar = SDKContext.getInstance().s;
        if (bVar.c == null) {
            f.a().c(new com.smartdigimkt.x3.a(bVar, integrationCheckListener, map, context));
        } else if (integrationCheckListener != null) {
            if (TextUtils.isEmpty(bVar.c)) {
                integrationCheckListener.onValidationSucceed();
            } else {
                integrationCheckListener.onValidationFail(bVar.c);
            }
        }
    }

    public boolean isNetworkLogDebug() {
        return SDKContext.getInstance().j();
    }

    public boolean isUseLocalLogo() {
        return false;
    }

    public void start(InitCallBack initCallBack) {
        SDKContext.getInstance().a(initCallBack);
    }
}
