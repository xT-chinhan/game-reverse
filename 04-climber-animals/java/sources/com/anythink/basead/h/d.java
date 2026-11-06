package com.anythink.basead.h;

import android.app.Activity;
import android.content.Context;
import com.anythink.basead.g.j;
import com.anythink.basead.g.k;
import com.anythink.basead.ui.BaseATActivity;
import com.anythink.core.common.h.x;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d extends c {
    public static final String a = "d";
    private k k;

    public d(Context context, x xVar, String str, boolean z) {
        super(context, xVar, str, z);
    }

    public final void a(k kVar) {
        this.k = kVar;
    }

    @Override // com.anythink.basead.h.a
    public final void a(Activity activity, Map<String, Object> map) {
        try {
            if (this.c == null) {
                k kVar = this.k;
                if (kVar != null) {
                    kVar.onShowFailed(com.anythink.basead.d.g.a(com.anythink.basead.d.g.i, com.anythink.basead.d.g.H));
                    return;
                }
                return;
            }
            String string = "";
            try {
                Object obj = map.get("extra_scenario");
                if (obj != null) {
                    string = obj.toString();
                }
            } catch (Throwable unused) {
            }
            map.get(c.h);
            int iIntValue = ((Integer) map.get(c.j)).intValue();
            final String str = this.d.b + this.e + System.currentTimeMillis();
            com.anythink.basead.g.b.a().a(str, new com.anythink.basead.g.b.AbstractC0044b() { // from class: com.anythink.basead.h.d.1
                @Override // com.anythink.basead.g.b.AbstractC0044b
                public final void c() {
                }

                @Override // com.anythink.basead.g.b.AbstractC0044b
                public final void a(j jVar) {
                    String str2 = d.a;
                    if (d.this.k != null) {
                        d.this.k.onAdShow(jVar);
                    }
                }

                @Override // com.anythink.basead.g.b.AbstractC0044b
                public final void a(com.anythink.basead.d.f fVar) {
                    String str2 = d.a;
                    fVar.c();
                    if (d.this.k != null) {
                        d.this.k.onShowFailed(fVar);
                    }
                }

                @Override // com.anythink.basead.g.b.AbstractC0044b
                public final void a() {
                    String str2 = d.a;
                    if (d.this.k != null) {
                        d.this.k.onVideoAdPlayStart();
                    }
                }

                @Override // com.anythink.basead.g.b.AbstractC0044b
                public final void b() {
                    String str2 = d.a;
                    if (d.this.k != null) {
                        d.this.k.onVideoAdPlayEnd();
                    }
                }

                @Override // com.anythink.basead.g.b.AbstractC0044b
                public final void d() {
                    String str2 = d.a;
                    if (d.this.k != null) {
                        d.this.k.onAdClosed();
                    }
                    com.anythink.basead.g.b.a().b(str);
                }

                @Override // com.anythink.basead.g.b.AbstractC0044b
                public final void b(j jVar) {
                    String str2 = d.a;
                    if (d.this.k != null) {
                        d.this.k.onAdClick(jVar);
                    }
                }

                @Override // com.anythink.basead.g.b.AbstractC0044b
                public final void a(boolean z) {
                    String str2 = d.a;
                    if (d.this.k != null) {
                        d.this.k.onDeeplinkCallback(z);
                    }
                }
            });
            com.anythink.core.basead.b.c cVar = new com.anythink.core.basead.b.c();
            cVar.c = this.g;
            cVar.d = str;
            cVar.a = 3;
            cVar.h = this.d;
            cVar.e = iIntValue;
            cVar.b = string;
            BaseATActivity.a(activity, cVar);
        } catch (Exception e) {
            e.printStackTrace();
            k kVar2 = this.k;
            if (kVar2 != null) {
                kVar2.onShowFailed(com.anythink.basead.d.g.a("-9999", e.getMessage()));
            }
        }
    }
}
