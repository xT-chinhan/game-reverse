package com.bytedance.sdk.openadsdk.live;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.android.live.base.api.ILiveHostContextParam;
import com.bytedance.android.live.base.api.ILiveInitCallback;
import com.bytedance.android.live.base.api.IOuterLiveService;
import com.bytedance.android.openliveplugin.LivePluginHelper;
import com.bytedance.sdk.openadsdk.api.ab;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    public static boolean ms(Context context, String str, ILiveHostContextParam.Builder builder, ILiveInitCallback iLiveInitCallback, boolean z) {
        try {
            LivePluginHelper.initLive((Application) context, str, builder, iLiveInitCallback, z);
            return true;
        } catch (Throwable th) {
            ab.ms(th);
            ah.ms("initLivePlugin", th);
            return false;
        }
    }

    public static boolean ms() {
        try {
            LivePluginHelper.initLiveCommerce();
            return true;
        } catch (Exception e) {
            ab.ms(e);
            ah.ms("initLiveCommerce", e);
            return false;
        }
    }

    public static boolean ms(Context context, Bundle bundle) {
        if (context != null && bundle != null && bundle.containsKey("room_id")) {
            long j = bundle.getLong("room_id");
            try {
                IOuterLiveService liveRoomService = LivePluginHelper.getLiveRoomService();
                if (liveRoomService == null) {
                    return false;
                }
                liveRoomService.enterLiveRoom(context, j, bundle);
                return true;
            } catch (Throwable th) {
                ab.ms(th);
                ah.ms("openLive", th);
            }
        }
        return false;
    }

    public static boolean ms(Context context, Uri uri) {
        if (context != null && uri != null) {
            try {
                IOuterLiveService liveRoomService = LivePluginHelper.getLiveRoomService();
                if (liveRoomService != null) {
                    return liveRoomService.handleSchema(context, uri);
                }
                return false;
            } catch (Throwable th) {
                ab.ms(th);
                ah.ms("handleScheme", th);
            }
        }
        return false;
    }
}
