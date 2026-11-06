package com.anythink.china.api;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.anythink.china.activity.TransparentActivity;
import com.anythink.china.b.c;
import com.anythink.odopt.api.ATOaidHandler;
import com.anythink.odopt.api.OaidSDKCallbackListener;
import com.bykv.vk.component.ttvideo.player.C;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class ATChinaSDKHandler {
    public static void requestPermissionIfNecessary(Context context) {
        String[] strArr = {c.a, c.b};
        if (context != null) {
            int iNextInt = new Random().nextInt(1000000000);
            Intent intent = new Intent(context, (Class<?>) TransparentActivity.class);
            intent.putExtra("type", 1000);
            intent.putExtra(TransparentActivity.b, iNextInt);
            intent.putExtra(TransparentActivity.d, strArr);
            intent.setFlags(C.ENCODING_PCM_MU_LAW);
            context.startActivity(intent);
            return;
        }
        Log.i("PermissionManager", "Build.VERSION.SDK_INT below 23 does not require permission");
    }

    public static void handleInitOaidSDK(Context context, OaidSDKCallbackListener oaidSDKCallbackListener) {
        try {
            ATOaidHandler.handleInitOaidSDK(context, oaidSDKCallbackListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setAllowUseMdidSDK(boolean z) {
        try {
            ATOaidHandler.setAllowUseMdidSDK(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
