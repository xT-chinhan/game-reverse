package com.smartdigimkt.g4;

import android.text.TextUtils;
import com.kwad.sdk.api.core.RequestParamsUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends d {
    public final String c;
    public final boolean d;

    public i(String str, String str2, boolean z) {
        this.d = z;
        this.c = str.replaceAll("\\{req_id\\}", str2 == null ? "" : str2);
    }

    @Override // com.smartdigimkt.g4.d
    public final Map e() {
        if (!this.d) {
            return null;
        }
        HashMap map = new HashMap();
        String strN = com.smartdigimkt.r4.h.n();
        if (!TextUtils.isEmpty(strN)) {
            map.put(RequestParamsUtils.USER_AGENT_KEY, strN);
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
        return this.c;
    }
}
