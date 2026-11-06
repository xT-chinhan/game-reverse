package com.bytedance.sdk.component.ms;

import android.net.Uri;
import com.anythink.core.common.d.j;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class t {
    private final b ah = h.f1257ms;
    private final nw d;
    private hi.xr ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Set<String> f1268ms;
    private final Set<String> xr;

    t(nw nwVar, Set<String> set, Set<String> set2) {
        this.d = nwVar;
        if (set == null || set.isEmpty()) {
            this.f1268ms = new LinkedHashSet();
        } else {
            this.f1268ms = new LinkedHashSet(set);
        }
        if (set2 == null || set2.isEmpty()) {
            this.xr = new LinkedHashSet();
        } else {
            this.xr = new LinkedHashSet(set2);
        }
    }

    final synchronized re ms(boolean z, String str, xr xrVar) throws nw.ms {
        re reVarXr;
        hi.xr xrVar2;
        Uri uri = Uri.parse(str);
        String host = uri.getHost();
        if (host == null) {
            return null;
        }
        re reVar = this.xr.contains(xrVar.ms()) ? re.PUBLIC : null;
        for (String str2 : this.f1268ms) {
            if (uri.getHost().equals(str2) || host.endsWith(j.z.concat(String.valueOf(str2)))) {
                reVar = re.PRIVATE;
                break;
            }
        }
        if (reVar == null && (xrVar2 = this.ka) != null && xrVar2.ms(str)) {
            if (this.ka.ms(str, xrVar.ms())) {
                return null;
            }
            reVar = re.PRIVATE;
        }
        if (z) {
            reVarXr = ms(str, xrVar);
        } else {
            reVarXr = xr(str, xrVar);
        }
        return reVarXr != null ? reVarXr : reVar;
    }

    final synchronized re ms(String str, xr xrVar) throws nw.ms {
        return ms(str, xrVar, true);
    }

    final synchronized re xr(String str, xr xrVar) {
        return ms(str, xrVar, false);
    }

    void ms(hi.xr xrVar) {
        this.ka = xrVar;
    }

    void ms(b.ms msVar) {
        b bVar = this.ah;
        if (bVar != null) {
            bVar.ms(msVar);
        }
    }

    void xr(b.ms msVar) {
        b bVar = this.ah;
        if (bVar != null) {
            bVar.xr(msVar);
        }
    }

    private re ms(String str, xr xrVar, boolean z) {
        nw nwVar;
        if (!z || (nwVar = this.d) == null) {
            return null;
        }
        nw.ah ahVarMs = nwVar.ms(str, this.f1268ms);
        if (ahVarMs.ah.contains(xrVar.ms())) {
            return null;
        }
        if (ahVarMs.xr.contains(xrVar.ms())) {
            return re.PRIVATE;
        }
        if (ahVarMs.f1263ms.compareTo(xrVar.xr()) < 0) {
            return null;
        }
        return ahVarMs.f1263ms;
    }
}
