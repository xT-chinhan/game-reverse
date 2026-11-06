package com.byazt.ea;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.byazt.vx.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.android.live.base.api.ILiveHostContextParam;
import com.bytedance.android.live.base.api.ILiveInitCallback;
import com.bytedance.android.live.base.api.IOuterLiveService;
import com.bytedance.android.openliveplugin.LivePluginHelper;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, 26})
public class qg {
    public static boolean n(Context context, String str, ILiveHostContextParam.Builder builder, ILiveInitCallback iLiveInitCallback, boolean z) {
        try {
            LivePluginHelper.initLive((Application) context, str, builder, iLiveInitCallback, z);
            return true;
        } catch (Throwable th) {
            w.n(th);
            s.n("initLivePlugin", th);
            return false;
        }
    }

    public static boolean n() {
        try {
            LivePluginHelper.initLiveCommerce();
            return true;
        } catch (Exception e) {
            w.n(e);
            s.n("initLiveCommerce", e);
            return false;
        }
    }

    public static boolean n(Context context, Bundle bundle) {
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
                w.n(th);
                s.n("openLive", th);
            }
        }
        return false;
    }

    public static boolean n(Context context, Uri uri) {
        if (context != null && uri != null) {
            try {
                IOuterLiveService liveRoomService = LivePluginHelper.getLiveRoomService();
                if (liveRoomService != null) {
                    return liveRoomService.handleSchema(context, uri);
                }
                return false;
            } catch (Throwable th) {
                w.n(th);
                s.n("handleScheme", th);
            }
        }
        return false;
    }
}
