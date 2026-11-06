package com.byazt.cf;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.anythink.core.common.l.f;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 93, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj {
    public cp.qg cy;
    public boolean fs;
    public Looper hd;
    public boolean k;
    public Context l;
    public com.byazt.uad.q n;
    public fs q;
    public n qg;
    public oa rv;
    public boolean sz;
    public sz tj;
    public boolean w;
    public boolean x;
    public String s = "IESJSBridge";
    public String cp = f.bU;
    public final Set<String> d = new LinkedHashSet();
    public final Set<String> oa = new LinkedHashSet();

    public tj(com.byazt.uad.q qVar) {
        this.n = qVar;
    }

    public tj() {
    }

    public tj n(n nVar) {
        this.qg = nVar;
        return this;
    }

    public tj n(String str) {
        this.s = str;
        return this;
    }

    public tj n(d dVar) {
        this.q = fs.n(dVar);
        return this;
    }

    public tj n(boolean z) {
        this.w = z;
        return this;
    }

    public tj qg(boolean z) {
        this.x = z;
        return this;
    }

    public tj n() {
        this.k = true;
        return this;
    }

    public cy qg() {
        q();
        return new cy(this);
    }

    public Context getContext() {
        return this.l;
    }

    private void q() {
        if ((this.n == null && !this.sz && this.qg == null) || ((TextUtils.isEmpty(this.s) && this.n != null) || this.q == null)) {
            throw new IllegalArgumentException("Requested arguments aren't set properly when building JsBridge.");
        }
    }

    public Looper s() {
        return this.hd;
    }
}
