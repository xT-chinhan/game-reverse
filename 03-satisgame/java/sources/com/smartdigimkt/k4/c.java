package com.smartdigimkt.k4;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.d.t;
import com.smartdigimkt.n4.e;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static volatile c b;
    public final ConcurrentHashMap a = new ConcurrentHashMap();

    public static c a() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    public final a a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (context instanceof Activity) {
                context = context.getApplicationContext();
            }
            a aVar = (a) this.a.get(str);
            if (aVar != null) {
                return aVar;
            }
            e eVar = new e(new d(context, str, (TextUtils.isEmpty(str) || !str.equalsIgnoreCase(t.b.f)) ? 1 : 0, 1));
            this.a.put(str, eVar);
            return eVar;
        }
        return new com.smartdigimkt.n4.a();
    }
}
