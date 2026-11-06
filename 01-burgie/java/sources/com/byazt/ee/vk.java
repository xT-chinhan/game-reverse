package com.byazt.ee;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF, 50})
public class vk {
    public m aj;
    public Context c;
    public boolean fw;
    public boolean g;
    public boolean ho;
    public pr hw;
    public w.hw nt;
    public com.byazt.son.x pr;
    public boolean uc;
    public g vk;
    public zo x;
    public Looper yb;
    public boolean zo;
    public String hn = "IESJSBridge";
    public String w = "host";
    public final Set<String> k = new LinkedHashSet();
    public final Set<String> m = new LinkedHashSet();

    public vk(com.byazt.son.x xVar) {
        this.pr = xVar;
    }

    public vk() {
    }

    public vk pr(pr prVar) {
        this.hw = prVar;
        return this;
    }

    public vk pr(String str) {
        this.hn = str;
        return this;
    }

    public vk pr(k kVar) {
        this.x = zo.pr(kVar);
        return this;
    }

    public vk pr(boolean z) {
        this.uc = z;
        return this;
    }

    public vk hw(boolean z) {
        this.fw = z;
        return this;
    }

    public vk pr() {
        this.ho = true;
        return this;
    }

    public yb hw() {
        x();
        return new yb(this);
    }

    public Context getContext() {
        return this.c;
    }

    private void x() {
        if ((this.pr == null && !this.g && this.hw == null) || ((TextUtils.isEmpty(this.hn) && this.pr != null) || this.x == null)) {
            throw new IllegalArgumentException("Requested arguments aren't set properly when building JsBridge.");
        }
    }

    public Looper hn() {
        return this.yb;
    }
}
