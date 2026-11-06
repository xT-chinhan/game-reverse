package com.anythink.odopt.api;

import android.content.Context;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;

/* JADX INFO: loaded from: classes.dex */
public class ATOaidHandler {
    private static boolean allowUserOaidSDK = false;

    public static void handleInitOaidSDK(Context context, final OaidSDKCallbackListener oaidSDKCallbackListener) {
        try {
            if (allowUserOaidSDK) {
                MdidSdkHelper.InitSdk(context.getApplicationContext(), true, new IIdentifierListener() { // from class: com.anythink.odopt.api.ATOaidHandler.1
                    public void OnSupport(boolean z, IdSupplier idSupplier) {
                        OaidSDKCallbackListener oaidSDKCallbackListener2 = oaidSDKCallbackListener;
                        if (oaidSDKCallbackListener2 != null) {
                            oaidSDKCallbackListener2.OnSupport(z, idSupplier);
                        }
                    }

                    public void onSupport(IdSupplier idSupplier) {
                        OaidSDKCallbackListener oaidSDKCallbackListener2 = oaidSDKCallbackListener;
                        if (oaidSDKCallbackListener2 != null) {
                            oaidSDKCallbackListener2.onSupport(idSupplier);
                        }
                    }
                });
            } else if (oaidSDKCallbackListener != null) {
                oaidSDKCallbackListener.OnSupport(false, null);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setAllowUseMdidSDK(boolean z) {
        allowUserOaidSDK = z;
    }
}
