package com.bytedance.sdk.openadsdk.core.ab;

import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.tools.LogAdapter;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    private static d ka = new d();
    private int ah;
    private volatile com.bytedance.sdk.component.ms d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private lm f1890ms;
    private int xr;

    public static d ms() {
        return ka;
    }

    private boolean xr() {
        this.d = LogAdapter.f4121ms;
        return this.d != null;
    }

    public d ms(lm lmVar) {
        if (xr()) {
            this.f1890ms = lmVar;
        }
        return this;
    }

    public d ms(int i) {
        if (xr()) {
            this.xr = i;
        }
        return this;
    }

    public d xr(int i) {
        if (xr()) {
            this.ah = i;
        }
        return this;
    }

    public void ms(Thread thread, Throwable th) {
        if (xr()) {
            String str = thread != null ? thread.getName() + "-" + thread.getId() : "";
            this.d.ms(str, "-------fatal----------");
            this.d.ms(str, "last show rit:" + this.ah);
            this.d.ms(str, "last show adtype:" + this.xr);
            this.d.ms(str, ah());
            this.d.ms(str, th);
            this.d.ms(str, "-------finish----------");
            LogAdapter.f4121ms.ms().flush();
        }
    }

    private String ah() {
        lm lmVar = this.f1890ms;
        return lmVar != null ? com.bytedance.sdk.component.utils.ms.ms(lmVar.rm()).toString() : "";
    }
}
