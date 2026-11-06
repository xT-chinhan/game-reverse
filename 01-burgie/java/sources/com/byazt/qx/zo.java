package com.byazt.qx;

import com.byazt.sd.nl;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 49, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo {
    public static void pr(NativeExpressView nativeExpressView) {
        if (nativeExpressView == null) {
            return;
        }
        nl jsObject = nativeExpressView.getJsObject();
        if (jsObject != null) {
            jsObject.hw("notifyAdClicked", (JSONObject) null);
        }
        com.byazt.gu.fw uGenV3Render = nativeExpressView.getUGenV3Render();
        if (uGenV3Render != null) {
            uGenV3Render.pr("notifyAdClicked", (Map<String, String>) null);
        }
    }

    public static void hw(NativeExpressView nativeExpressView) {
        if (nativeExpressView == null) {
            return;
        }
        nl jsObject = nativeExpressView.getJsObject();
        if (jsObject != null) {
            jsObject.hw("changeTemplateStyle", (JSONObject) null);
        }
        com.byazt.gu.fw uGenV3Render = nativeExpressView.getUGenV3Render();
        if (uGenV3Render != null) {
            uGenV3Render.pr("changeTemplateStyle", (Map<String, String>) null);
        }
    }
}
