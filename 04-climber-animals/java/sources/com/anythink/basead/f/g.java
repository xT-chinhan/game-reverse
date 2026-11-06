package com.anythink.basead.f;

import android.app.Activity;
import android.content.Context;
import com.anythink.core.common.h.x;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class g extends c {
    public static final String i = "g";

    public g(Context context, c.b bVar, x xVar) {
        super(context, bVar, xVar);
    }

    public final void a(Activity activity, Map<String, Object> map) {
        String string;
        try {
            if (!c()) {
                if (this.e != null) {
                    this.e.onShowFailed(com.anythink.basead.d.g.a(com.anythink.basead.d.g.i, com.anythink.basead.d.g.D));
                }
                this.d = null;
                return;
            }
            try {
                Object obj = map.get("extra_scenario");
                string = obj != null ? obj.toString() : "";
            } catch (Throwable unused) {
                string = "";
            }
            int iIntValue = ((Integer) map.get(com.anythink.basead.h.c.j)).intValue();
            String strA = a(this.d);
            HashMap map2 = new HashMap(2);
            a(map2);
            this.h.a(activity, map2, iIntValue, strA, string, this.b != null ? this.b.d + this.b.c : "");
        } catch (Exception e) {
            e.printStackTrace();
            if (this.e != null) {
                this.e.onShowFailed(com.anythink.basead.d.g.a("-9999", e.getMessage()));
            }
            this.d = null;
        }
    }

    @Override // com.anythink.basead.f.c
    public final void b() {
        super.b();
        this.e = null;
    }
}
