package com.byazt.ay;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.byazt.dea.uc;
import com.bytedance.android.live.base.api.ILiveHostContextParam;
import com.bytedance.android.live.base.api.ILiveInitCallback;
import com.bytedance.android.live.base.api.IOuterLiveService;
import com.bytedance.android.openliveplugin.LivePluginHelper;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 786, 13})
public class hw {
    public static boolean pr(Context context, String str, ILiveHostContextParam.Builder builder, ILiveInitCallback iLiveInitCallback, boolean z) {
        try {
            LivePluginHelper.initLive((Application) context, str, builder, iLiveInitCallback, z);
            return true;
        } catch (Throwable th) {
            uc.pr(th);
            hn.pr("initLivePlugin", th);
            return false;
        }
    }

    public static boolean pr() {
        try {
            LivePluginHelper.initLiveCommerce();
            return true;
        } catch (Exception e) {
            uc.pr(e);
            hn.pr("initLiveCommerce", e);
            return false;
        }
    }

    public static boolean pr(Context context, Bundle bundle) {
        if (context == null || bundle == null || !bundle.containsKey("room_id")) {
            return false;
        }
        long j = bundle.getLong("room_id");
        try {
            IOuterLiveService liveRoomService = LivePluginHelper.getLiveRoomService();
            if (liveRoomService == null) {
                return false;
            }
            liveRoomService.enterLiveRoom(context, j, bundle);
            return true;
        } catch (Throwable th) {
            uc.pr(th);
            hn.pr("openLive", th);
            return false;
        }
    }

    public static boolean pr(Context context, Uri uri) {
        if (context == null || uri == null) {
            return false;
        }
        try {
            IOuterLiveService liveRoomService = LivePluginHelper.getLiveRoomService();
            if (liveRoomService == null) {
                return false;
            }
            return liveRoomService.handleSchema(context, uri);
        } catch (Throwable th) {
            uc.pr(th);
            hn.pr("handleScheme", th);
            return false;
        }
    }
}
