package com.anythink.core.common.m.b;

import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public enum ab {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC(LiveConfigKey.QUIC);

    private final String g;

    private static /* synthetic */ ab[] a() {
        return new ab[]{HTTP_1_0, HTTP_1_1, SPDY_3, HTTP_2, H2_PRIOR_KNOWLEDGE, QUIC};
    }

    ab(String str) {
        this.g = str;
    }

    public static ab a(String str) throws IOException {
        ab abVar = HTTP_1_0;
        if (str.equals(abVar.g)) {
            return abVar;
        }
        ab abVar2 = HTTP_1_1;
        if (str.equals(abVar2.g)) {
            return abVar2;
        }
        ab abVar3 = H2_PRIOR_KNOWLEDGE;
        if (str.equals(abVar3.g)) {
            return abVar3;
        }
        ab abVar4 = HTTP_2;
        if (str.equals(abVar4.g)) {
            return abVar4;
        }
        ab abVar5 = SPDY_3;
        if (str.equals(abVar5.g)) {
            return abVar5;
        }
        ab abVar6 = QUIC;
        if (str.equals(abVar6.g)) {
            return abVar6;
        }
        throw new IOException("Unexpected protocol: ".concat(String.valueOf(str)));
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.g;
    }
}
