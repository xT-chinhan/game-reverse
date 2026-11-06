package com.byazt.ko;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2319, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj extends s {
    public final Context l;

    public tj(Context context) {
        super(true, false);
        this.l = context;
    }

    @Override // com.byazt.ko.s
    public boolean n(JSONObject jSONObject) throws JSONException {
        String str;
        int iX = com.byazt.km.n.x();
        switch (iX) {
            case 120:
                str = "ldpi";
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA /* 240 */:
                str = "hdpi";
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN /* 280 */:
            case TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX /* 300 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME /* 320 */:
                str = "xhdpi";
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_NEED_CHECK_DROP_AUDIO /* 340 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL /* 360 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_USE_CODEC_POOL /* 400 */:
            case 420:
            case 440:
            case 480:
                str = "xxhdpi";
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUX_NONBLOCK_READ /* 560 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK /* 640 */:
                str = "xxxhdpi";
                break;
            default:
                str = "mdpi";
                break;
        }
        jSONObject.put("density_dpi", iX);
        jSONObject.put("display_density", str);
        jSONObject.put("resolution", com.byazt.km.n.fs() + com.byazt.af.x.n + com.byazt.km.n.rv());
        return true;
    }
}
