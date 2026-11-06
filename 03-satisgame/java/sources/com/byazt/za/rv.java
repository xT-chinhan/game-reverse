package com.byazt.za;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv {
    public static void n(NativeExpressView nativeExpressView) {
        if (nativeExpressView == null) {
            return;
        }
        com.byazt.gcl.s jsObject = nativeExpressView.getJsObject();
        if (jsObject != null) {
            jsObject.qg("notifyAdClicked", (JSONObject) null);
        }
        com.byazt.gn.fs uGenV3Render = nativeExpressView.getUGenV3Render();
        if (uGenV3Render != null) {
            uGenV3Render.n("notifyAdClicked", (Map<String, String>) null);
        }
    }

    public static void qg(NativeExpressView nativeExpressView) {
        if (nativeExpressView == null) {
            return;
        }
        com.byazt.gcl.s jsObject = nativeExpressView.getJsObject();
        if (jsObject != null) {
            jsObject.qg("changeTemplateStyle", (JSONObject) null);
        }
        com.byazt.gn.fs uGenV3Render = nativeExpressView.getUGenV3Render();
        if (uGenV3Render != null) {
            uGenV3Render.n("changeTemplateStyle", (Map<String, String>) null);
        }
    }
}
