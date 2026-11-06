package com.byazt.zs;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 14, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF})
public class g {
    public final boolean aj;
    public final boolean c;
    public final boolean fw;
    public volatile Object g;
    public final int hn;
    public volatile int ho;
    public final Class<Object> hw;
    public volatile Function k;
    public volatile Map<com.byazt.vkw.pr, Object> m;
    public final Class<Object> pr;
    public final String uc;
    public final int vk;
    public volatile int w;
    public final int x;
    public final int[] zo;

    public g(Class cls, Class cls2, boolean z, int i, int i2, String str, boolean z2, int[] iArr, boolean z3, int i3) {
        this.vk = i3;
        this.pr = cls;
        this.hw = cls2;
        this.hn = i;
        this.c = z;
        this.x = i2;
        this.uc = str;
        this.fw = z2;
        if (i < 0) {
            this.ho = i;
        }
        if (z2) {
            this.m = new ConcurrentHashMap();
        }
        this.zo = iArr;
        this.aj = z3;
    }

    public int pr() {
        return this.w;
    }

    public void pr(int i) {
        this.w = i;
    }

    public Function hw() {
        return this.k;
    }

    public void pr(Function function) {
        this.k = function;
    }

    public synchronized Object pr(com.byazt.vkw.pr prVar) {
        if (this.fw && prVar != null && this.m != null) {
            return this.m.get(prVar);
        }
        return this.g;
    }

    public Map<com.byazt.vkw.pr, Object> hn() {
        return this.m;
    }

    public Object x() {
        return this.g;
    }

    public synchronized void pr(Object obj, com.byazt.vkw.pr prVar) {
        if (this.fw && prVar != null && this.m != null) {
            this.m.put(prVar, obj);
            return;
        }
        this.g = obj;
    }

    public int c() {
        return this.ho;
    }

    public void hw(int i) {
        this.ho = i;
    }

    public boolean hn(int i) {
        int i2 = this.x;
        return i2 <= 0 || i >= i2;
    }

    public boolean uc() {
        return this.ho > this.w && this.ho > this.hn;
    }
}
