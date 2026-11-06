package com.anythink.core.common.inner.ui;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.inner.e.e;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseATView extends RelativeLayout {
    String e;
    protected x f;
    protected w g;
    volatile boolean h;
    String i;
    protected List<View> j;
    protected ScanningAnimButton k;

    protected abstract void a();

    protected abstract void a(e eVar);

    protected abstract void a(boolean z);

    protected void d() {
    }

    public void destroy() {
    }

    protected abstract void e();

    public BaseATView(Context context, x xVar, w wVar, String str) {
        super(context);
        this.e = "BaseATView";
        this.h = false;
        this.f = xVar;
        this.g = wVar;
        this.i = str;
        this.j = new ArrayList();
        d();
        a();
    }

    public BaseATView(Context context, x xVar, w wVar) {
        this(context, xVar, wVar, "");
    }

    public BaseATView(Context context) {
        super(context);
        this.e = "BaseATView";
        this.h = false;
    }

    private synchronized void b() {
        if (this.h) {
            return;
        }
        this.h = true;
        e();
    }
}
