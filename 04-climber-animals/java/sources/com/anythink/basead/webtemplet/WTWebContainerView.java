package com.anythink.basead.webtemplet;

import android.content.Context;
import android.widget.FrameLayout;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.h.y;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class WTWebContainerView extends FrameLayout {
    protected w a;
    protected y b;
    protected x c;
    a d;
    private final String e;
    private WTWebView f;
    private final List<i> g;
    private volatile boolean h;

    public interface a {
        void a();

        void a(com.anythink.basead.d.f fVar);

        void b();
    }

    public WTWebContainerView(Context context) {
        super(context);
        this.e = "WTWebContainerView";
        this.g = Collections.synchronizedList(new ArrayList());
        this.h = false;
    }

    public WTWebContainerView(Context context, w wVar, x xVar, a aVar) {
        super(context);
        this.e = "WTWebContainerView";
        this.g = Collections.synchronizedList(new ArrayList());
        this.h = false;
        this.a = wVar;
        this.b = xVar.o;
        this.c = xVar;
        this.d = aVar;
    }

    public void init(Object obj) {
        if (com.anythink.basead.b.c.d.a(this.a)) {
            a();
            return;
        }
        String strA = com.anythink.core.common.res.d.a(t.b().g()).a(this.a.an());
        String strA2 = com.anythink.basead.b.c.d.a((x) null, this.a, 3);
        try {
            this.f = new WTWebView(t.b().g());
            l.a(strA2, new File(strA).toURI().toString(), this.f, new l.a() { // from class: com.anythink.basead.webtemplet.WTWebContainerView.1
                @Override // com.anythink.basead.webtemplet.l.a
                public final void a() {
                    WTWebContainerView.this.a();
                }

                @Override // com.anythink.basead.webtemplet.l.a
                public final void a(com.anythink.basead.d.f fVar) {
                    if (WTWebContainerView.this.d != null) {
                        WTWebContainerView.this.d.a(fVar);
                    }
                }
            }, this.a, this.c, 2, obj);
        } catch (Throwable th) {
            a aVar = this.d;
            if (aVar != null) {
                aVar.a(com.anythink.basead.d.g.a("10000", "wtWebView create fail with " + th.getMessage()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.f == null) {
            this.f = com.anythink.basead.b.c.d.c(com.anythink.basead.b.c.d.a((x) null, this.a, 3));
        }
        if (this.f != null) {
            this.h = true;
            synchronized (this.g) {
                if (!this.g.isEmpty()) {
                    for (i iVar : this.g) {
                        notifyInnerAdEvent(iVar.a, iVar.b);
                    }
                    this.g.clear();
                }
            }
            this.f.prepare(new WTWebView.a() { // from class: com.anythink.basead.webtemplet.WTWebContainerView.2
                @Override // com.anythink.basead.webtemplet.WTWebView.a
                public final void a() {
                    if (WTWebContainerView.this.d != null) {
                        WTWebContainerView.this.d.b();
                    }
                }
            });
            this.f.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.f);
        }
    }

    public Object getJsCommunicationObject() {
        WTWebView wTWebView = this.f;
        if (wTWebView != null) {
            return wTWebView.getJsCommunicationObject();
        }
        return null;
    }

    public void release() {
        WTWebView wTWebView = this.f;
        if (wTWebView != null) {
            wTWebView.release();
        }
    }

    public void notifyInnerAdEvent(int i, Map<String, Object> map) {
        if (!this.h) {
            synchronized (this.g) {
                this.g.add(new i(i, map));
            }
        } else {
            WTWebView wTWebView = this.f;
            if (wTWebView != null) {
                wTWebView.notifyInnerAdEvent(i, map);
            }
        }
    }
}
