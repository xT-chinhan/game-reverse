package com.bytedance.sdk.component.adexpress.dynamic.ah;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.android.live.base.api.push.ILivePush;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ka {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final Map<String, Integer> f764ms;
    private String ab;
    private String ah;
    private c c;
    private String d;
    private c ka;
    private String xr;

    static {
        HashMap map = new HashMap();
        f764ms = map;
        map.put("root", 8);
        map.put("footer", 6);
        map.put("empty", 6);
        map.put("title", 0);
        map.put(MediaFormat.KEY_SUBTITLE, 0);
        map.put("source", 0);
        map.put("score-count", 0);
        map.put("text_star", 0);
        map.put("text", 0);
        map.put("tag-group", 17);
        map.put("app-version", 0);
        map.put("development-name", 0);
        map.put("privacy-detail", 23);
        map.put("image", 1);
        map.put("image-wide", 1);
        map.put("image-square", 1);
        map.put("image-long", 1);
        map.put("image-splash", 1);
        map.put("image-cover", 1);
        map.put("app-icon", 1);
        map.put("icon-download", 1);
        map.put("logoad", 4);
        map.put("logounion", 5);
        map.put("logo-union", 9);
        map.put("dislike", 3);
        map.put(ILivePush.ClickType.CLOSE, 3);
        map.put("close-fill", 3);
        map.put("webview-close", 22);
        map.put("feedback-dislike", 12);
        map.put("button", 2);
        map.put("downloadWithIcon", 2);
        map.put("downloadButton", 2);
        map.put("fillButton", 2);
        map.put("laceButton", 2);
        map.put("cardButton", 2);
        map.put("colourMixtureButton", 2);
        map.put("arrowButton", 1);
        map.put("download-progress-button", 2);
        map.put("vessel", 6);
        map.put("image-group", 6);
        map.put("custom-component-vessel", 6);
        map.put("carousel", 24);
        map.put("carousel-vessel", 26);
        map.put("leisure-interact", 25);
        map.put("video-hd", 7);
        map.put("video", 7);
        map.put("video-vd", 7);
        map.put("video-sq", 7);
        map.put("muted", 10);
        map.put("star", 11);
        map.put("skip-countdowns", 19);
        map.put("skip-with-countdowns-skip-btn", 21);
        map.put("skip-with-countdowns-video-countdown", 13);
        map.put("skip-with-countdowns-skip-countdown", 20);
        map.put("skip-with-time", 14);
        map.put("skip-with-time-countdown", 13);
        map.put("skip-with-time-skip-btn", 15);
        map.put("skip", 27);
        map.put("timedown", 13);
        map.put("icon", 16);
        map.put("scoreCountWithIcon", 6);
        map.put("split-line", 18);
        map.put("creative-playable-bait", 0);
        map.put("score-count-type-2", 0);
        map.put("lottie", 28);
        map.put("image-flip-slide", 29);
    }

    public int ms() {
        if (TextUtils.isEmpty(this.xr)) {
            return 0;
        }
        if (this.xr.equals("logo")) {
            String str = this.xr + this.ah;
            this.xr = str;
            if (str.contains("logoad")) {
                return 4;
            }
            if (this.xr.contains("logounion")) {
                return 5;
            }
        }
        Map<String, Integer> map = f764ms;
        if (map.get(this.xr) != null) {
            return map.get(this.xr).intValue();
        }
        return -1;
    }

    public String getType() {
        return this.xr;
    }

    public void ms(String str) {
        this.xr = str;
    }

    public String xr() {
        return this.ah;
    }

    public void xr(String str) {
        this.ah = str;
    }

    public String ah() {
        return this.d;
    }

    public void ah(String str) {
        this.d = str;
    }

    public void d(String str) {
        this.ab = str;
    }

    public String d() {
        return this.ab;
    }

    public c ka() {
        return this.ka;
    }

    public int c() {
        return this.ka.jy();
    }

    public void ms(c cVar) {
        this.ka = cVar;
    }

    public void xr(c cVar) {
        this.c = cVar;
    }

    public c ab() {
        return this.c;
    }

    public String toString() {
        return "DynamicLayoutBrick{type='" + this.xr + "', data='" + this.ah + "', value=" + this.ka + ", themeValue=" + this.c + ", dataExtraInfo='" + this.ab + "'}";
    }
}
