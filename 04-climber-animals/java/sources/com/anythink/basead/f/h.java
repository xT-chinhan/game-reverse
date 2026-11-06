package com.anythink.basead.f;

import android.content.Context;
import android.view.ViewGroup;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.am;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class h extends c {
    private static final String j = "h";
    boolean i;
    private final Map<String, Object> k;

    public h(Context context, c.b bVar, x xVar) {
        super(context, bVar, xVar);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.k = concurrentHashMap;
        a(concurrentHashMap);
    }

    public final void a() {
        this.i = true;
    }

    public final void a(final ViewGroup viewGroup) {
        if (c()) {
            am.a(false);
            t.b().b(new Runnable() { // from class: com.anythink.basead.f.h.1
                @Override // java.lang.Runnable
                public final void run() {
                    h.this.h.a(viewGroup, h.this.k, h.this.i);
                }
            });
        } else if (this.e != null) {
            this.e.onShowFailed(com.anythink.basead.d.g.a(com.anythink.basead.d.g.i, com.anythink.basead.d.g.D));
        }
    }

    public final boolean h() {
        return (this.g != null || com.anythink.basead.b.e.b(this.d, this.b) || com.anythink.basead.b.e.a(this.d, this.b)) ? false : true;
    }

    @Override // com.anythink.basead.f.c
    public final void b() {
        super.b();
    }
}
