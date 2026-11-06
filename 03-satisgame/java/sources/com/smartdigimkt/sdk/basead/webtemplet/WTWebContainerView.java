package com.smartdigimkt.sdk.basead.webtemplet;

import android.content.Context;
import android.widget.FrameLayout;
import com.anythink.core.common.inner.b.b;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.b3.e;
import com.smartdigimkt.d0.s;
import com.smartdigimkt.h0.g;
import com.smartdigimkt.k2.i;
import com.smartdigimkt.k2.j;
import com.smartdigimkt.k2.k;
import com.smartdigimkt.k2.l;
import com.smartdigimkt.k2.y;
import com.smartdigimkt.sdk.core.SDKContext;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class WTWebContainerView extends FrameLayout {
    public static final /* synthetic */ int g = 0;
    public final c a;
    public final a b;
    public final k c;
    public WTWebView d;
    public final List e;
    public volatile boolean f;

    public WTWebContainerView(Context context) {
        super(context);
        this.e = Collections.synchronizedList(new ArrayList());
        this.f = false;
    }

    public final void a(WTWebView wTWebView) {
        if (this.d == null) {
            if (wTWebView != null) {
                this.d = wTWebView;
            } else {
                this.d = (WTWebView) s.b.remove(s.c(this.a));
            }
        }
        if (this.d != null) {
            this.f = true;
            synchronized (this.e) {
                if (!this.e.isEmpty()) {
                    for (l lVar : this.e) {
                        notifyInnerAdEvent(lVar.a, lVar.b);
                    }
                    this.e.clear();
                }
            }
            this.d.prepare(new j(this));
            this.d.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.d);
        }
    }

    public Object getJsCommunicationObject() {
        WTWebView wTWebView = this.d;
        if (wTWebView != null) {
            return wTWebView.getJsCommunicationObject();
        }
        return null;
    }

    public void init(Object obj) {
        WTWebView wTWebView = (WTWebView) s.b.remove(s.c(this.a));
        if (wTWebView != null) {
            a(wTWebView);
            return;
        }
        String strD = s.d(this.a);
        String strC = s.c(this.a);
        try {
            this.d = new WTWebView(SDKContext.getInstance().d());
            String string = new File(strD).toURI().toString();
            WTWebView wTWebView2 = this.d;
            y.a(2, this.b, this.a, new i(this), wTWebView2, obj, strC, string);
        } catch (Throwable th) {
            k kVar = this.c;
            if (kVar != null) {
                kVar.a(new g(b.b, "wtWebView create fail with " + th.getMessage()));
            }
        }
    }

    public void notifyInnerAdEvent(int i, Map<String, Object> map) {
        if (!this.f) {
            synchronized (this.e) {
                this.e.add(new l(i, map));
            }
        } else {
            WTWebView wTWebView = this.d;
            if (wTWebView != null) {
                wTWebView.notifyInnerAdEvent(i, map);
            }
        }
    }

    public void release() {
        WTWebView wTWebView = this.d;
        if (wTWebView != null) {
            wTWebView.release();
        }
    }

    public WTWebContainerView(Context context, c cVar, a aVar, k kVar) {
        super(context);
        this.e = Collections.synchronizedList(new ArrayList());
        this.f = false;
        this.a = cVar;
        e eVar = aVar.s;
        this.b = aVar;
        this.c = kVar;
    }
}
