package com.anythink.core.common.u;

import com.anythink.core.common.d.j;
import com.anythink.core.common.v.q;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class g {
    public static final int a = 10001;

    private static void a(int i, int i2, Map<String, Object> map) {
        if (i == 2 && i2 == 10001 && map != null) {
            try {
                long jB = q.b(map, "init_st");
                long jB2 = q.b(map, "init_et");
                long jB3 = q.b(map, "token_st");
                long jB4 = q.b(map, "token_et");
                e.a(q.a(map, "ad_format", "-1"), q.a(map, "admob_init_adsource_id", ""), q.a(map, "admob_token_adsource_id", ""), q.a(map, j.w.G, 0), jB, jB2, jB3, jB4, (jB <= 0 || jB2 <= 0 || jB3 <= 0 || jB4 <= 0 || jB <= jB3) ? -1L : jB2 - jB3);
            } catch (Throwable unused) {
            }
        }
    }
}
