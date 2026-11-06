package com.byazt.pg;

import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.taptap.sdk.login.internal.handlers.web.WebLoginFragment;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 694, 19})
public final class n {
    public static String n(String str) {
        if (str == null) {
            return null;
        }
        str.hashCode();
        switch (str) {
            case "invisible":
            case "adViewVisible":
            case "visible":
                return "pageVisibility";
            case "videoState":
            case "videoProgress":
                return MediaFormat.KEY_VIDEO;
            case "touchStart":
            case "touchEnd":
            case "tap":
            case "slide":
            case "longTap":
                return "gesture";
            case "background":
            case "appLifecycle":
            case "foreground":
                return "appLifecycle";
            case "Lottie://state":
            case "animateState":
                return "animation";
            case "webViewLifeCycle":
                return "webView";
            case "tick":
            case "timer":
            case "timerState":
                return "timer";
            case "shake":
            case "twist":
                return "sensor";
            case "downloadStatus":
                return "download";
            case "stateChange":
                return WebLoginFragment.QUERY_KEY_ID;
            default:
                return null;
        }
    }
}
