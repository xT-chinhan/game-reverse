package com.anythink.basead.b.b;

import android.net.Uri;
import android.text.TextUtils;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    w a;
    x b;
    String c;
    com.anythink.basead.d.a d;
    private List<Boolean> e = new ArrayList();

    public f(w wVar, x xVar, String str, com.anythink.basead.d.a aVar) {
        this.a = wVar;
        this.b = xVar;
        this.c = str;
        this.d = aVar;
    }

    public final void a() {
        com.anythink.core.common.v.b.b.a().c(new Runnable() { // from class: com.anythink.basead.b.b.f.1
            @Override // java.lang.Runnable
            public final void run() {
                f.this.e.add(Boolean.valueOf(com.anythink.basead.c.a().e()));
                if (f.this.e.size() < 5) {
                    f.this.a();
                } else {
                    f.b(f.this);
                }
            }
        });
    }

    private void b() {
        String scheme;
        if (TextUtils.isEmpty(this.c)) {
            scheme = "";
        } else {
            try {
                scheme = Uri.parse(this.c).getScheme();
            } catch (Throwable unused) {
                scheme = "";
            }
        }
        String str = scheme;
        com.anythink.basead.d.a aVar = this.d;
        com.anythink.core.common.u.e.a(this.a, this.b, this.c, str, this.e, aVar != null ? aVar.n : -1, com.anythink.basead.c.a().h());
    }

    static /* synthetic */ void b(f fVar) {
        String scheme;
        if (TextUtils.isEmpty(fVar.c)) {
            scheme = "";
        } else {
            try {
                scheme = Uri.parse(fVar.c).getScheme();
            } catch (Throwable unused) {
                scheme = "";
            }
        }
        String str = scheme;
        com.anythink.basead.d.a aVar = fVar.d;
        com.anythink.core.common.u.e.a(fVar.a, fVar.b, fVar.c, str, fVar.e, aVar != null ? aVar.n : -1, com.anythink.basead.c.a().h());
    }
}
