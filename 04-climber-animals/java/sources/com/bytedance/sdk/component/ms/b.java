package com.bytedance.sdk.component.ms;

import android.text.TextUtils;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class b {
    private final hi ah;
    private final Set<ms> d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Collection<String> f1253ms;
    private final Map<String, nw> xr;

    interface ms {
    }

    nw ms(String str) {
        if (!this.f1253ms.contains(str) && !TextUtils.equals(str, "host")) {
            throw new IllegalArgumentException("Namespace: " + str + " not registered.");
        }
        return ms(str, null);
    }

    void ms(ms msVar) {
        this.d.add(msVar);
    }

    void xr(ms msVar) {
        this.d.remove(msVar);
    }

    private nw ms(String str, JSONObject jSONObject) {
        nw nwVar = this.xr.get(str);
        if (nwVar == null) {
            nw nwVar2 = new nw(str, this.ah.ah(), this.ah.ms(), this.ah.xr(), jSONObject);
            this.xr.put(str, nwVar2);
            return nwVar2;
        }
        if (jSONObject == null) {
            return nwVar;
        }
        nwVar.update(jSONObject);
        return nwVar;
    }
}
