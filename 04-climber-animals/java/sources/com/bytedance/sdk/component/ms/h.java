package com.bytedance.sdk.component.ms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static b f1257ms;
    private final com.bytedance.sdk.component.zb.ah ah;
    private volatile boolean c;
    private final ch d;
    private final List<u> ka;
    private final ms xr;

    public static ch ms(com.bytedance.sdk.component.zb.ah ahVar) {
        return new ch(ahVar);
    }

    public <T> void ms(String str, T t) {
        xr();
        this.xr.ms(str, t);
    }

    public h ms(String str, ka<?, ?> kaVar) {
        return ms(str, (String) null, kaVar);
    }

    public h ms(String str, String str2, ka<?, ?> kaVar) {
        xr();
        this.xr.ab.ms(str, kaVar);
        return this;
    }

    public h ms(String str, d.xr xrVar) {
        return ms(str, (String) null, xrVar);
    }

    public h ms(String str, String str2, d.xr xrVar) {
        xr();
        this.xr.ab.ms(str, xrVar);
        return this;
    }

    public void ms() {
        if (this.c) {
            return;
        }
        this.xr.xr();
        this.c = true;
        Iterator<u> it = this.ka.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    h(ch chVar) {
        b bVar;
        ArrayList arrayList = new ArrayList();
        this.ka = arrayList;
        this.c = false;
        this.d = chVar;
        nw nwVarMs = (!chVar.x || (bVar = f1257ms) == null) ? null : bVar.ms(chVar.hi);
        if (chVar.f1255ms != null && chVar.xr == null) {
            this.xr = new w();
        } else {
            this.xr = chVar.xr;
        }
        this.xr.ms(chVar, nwVarMs);
        this.ah = chVar.f1255ms;
        arrayList.add(chVar.ch);
        ny.ms(chVar.c);
        i.ms(chVar.ab);
    }

    private void xr() {
        if (this.c) {
            ny.ms(new IllegalStateException("JsBridge2 is already released!!!"));
        }
    }
}
