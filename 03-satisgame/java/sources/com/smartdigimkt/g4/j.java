package com.smartdigimkt.g4;

import android.text.TextUtils;
import com.kwad.sdk.api.core.RequestParamsUtils;
import com.smartdigimkt.z.s;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends d {
    public final int c;
    public String d;
    public final com.smartdigimkt.b3.l e;
    public final Map f;

    public j(int i, String str, com.smartdigimkt.b3.l lVar, HashMap map) {
        this.c = i;
        this.d = str;
        this.e = lVar;
        this.f = map;
    }

    @Override // com.smartdigimkt.g4.d
    public final Map e() {
        if (this.e == null) {
            return null;
        }
        HashMap map = new HashMap();
        com.smartdigimkt.b3.e eVar = this.e.w;
        if (eVar != null && s.a(eVar, this.c)) {
            String strN = com.smartdigimkt.r4.h.n();
            if (!TextUtils.isEmpty(strN)) {
                map.put(RequestParamsUtils.USER_AGENT_KEY, strN);
            }
        }
        return map;
    }

    @Override // com.smartdigimkt.g4.d
    public final byte[] h() {
        return new byte[0];
    }

    @Override // com.smartdigimkt.g4.d
    public final int j() {
        return 2;
    }

    @Override // com.smartdigimkt.g4.d
    public final String k() {
        if (this.f != null && !TextUtils.isEmpty(this.d)) {
            try {
                for (Map.Entry entry : this.f.entrySet()) {
                    this.d = this.d.replaceAll("\\{" + ((String) entry.getKey()) + "\\}", (String) entry.getValue());
                }
            } catch (Throwable unused) {
            }
        }
        return this.d;
    }

    public final boolean m() {
        com.smartdigimkt.b3.e eVar;
        int i;
        boolean z = true;
        try {
            com.smartdigimkt.b3.l lVar = this.e;
            if (lVar == null || (eVar = lVar.w) == null) {
                return true;
            }
            int i2 = this.c;
            if (i2 == 8) {
                int i3 = eVar.X;
                if (i3 != 1 && i3 == 2) {
                    z = false;
                }
            } else if (i2 == 9 && (i = eVar.W) != 1 && i == 2) {
                z = false;
            }
        } catch (Throwable unused) {
        }
        return z;
    }
}
