package com.byazt.vh;

/* JADX INFO: loaded from: classes2.dex */
public enum hd {
    UNKNOWN_EVENT("UNKNOWN_EVENT", 0),
    TAP_EVENT("onTap", 1),
    LONG_TAP_EVENT("onLongTap", 2),
    SHAKE_EVENT("onShake", 3),
    TWIST_EVENT("onTwist", 18),
    SLIDE_EVENT("onSlide", 4),
    EXPOSURE_EVENT("onExposure", 5),
    SCROLL_EVENT("onScroll", 6),
    PULL_TO_REFRESH_EVENT("onPullToRefresh", 7),
    LOAD_MORE_EVENT("onLoadMore", 8),
    TIMER("onTimer", 9),
    DELAY("onDelay", 10),
    ANIMATION("onAnimation", 11),
    VIDEO_PROGRESS("onVideoProgress", 12),
    VIDEO_PAUSE("onVideoPause", 13),
    VIDEO_RESUME("onVideoResume", 14),
    VIDEO_FINISH("onVideoFinish", 15),
    VIDEO_PLAY("onVideoPlay", 16),
    DOWN_EVENT("onDown", 17),
    RENDER_SUCCESS("onRenderSuccess", 22);

    public int ou;
    public String py;

    hd(String str, int i) {
        this.py = str;
        this.ou = i;
    }

    public int getType() {
        return this.ou;
    }

    public static hd n(String str) {
        for (hd hdVar : values()) {
            if (hdVar.py.equals(str)) {
                return hdVar;
            }
        }
        return UNKNOWN_EVENT;
    }
}
