package com.anythink.core.api.bridge;

import com.anythink.core.api.ATAdConst;
import com.anythink.core.common.t.f;
import com.anythink.core.common.u.e;
import com.anythink.core.common.u.p;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class NetworkAgentEventManager {
    public static final int NETWORK_AGENT_EVENT_TYPE_ADMOB_INIT = 10001;
    public static final int NETWORK_AGENT_EVENT_TYPE_GM_INIT = 10002;
    public static final int NETWORK_AGENT_EVENT_TYPE_PG_INIT = 10003;

    public static void handNetworkAgentEvent(int i, int i2, Map<String, Object> map) {
        try {
            if (i != 2) {
                if (i == 15 || i == 46 || i == 92) {
                    if (i2 == 10002 || i2 == 10003) {
                        e.a().a(i, map);
                        return;
                    }
                    return;
                }
                return;
            }
            if (i2 != 10001 || map == null) {
                return;
            }
            long jB = p.b(map, "init_st");
            long jB2 = p.b(map, "init_et");
            long jB3 = p.b(map, "token_st");
            long jB4 = p.b(map, "token_et");
            f.a(p.a(map, ATAdConst.NETWORK_REQUEST_PARAMS_KEY.FORMAT, "-1"), p.a(map, "admob_init_adsource_id", ""), p.a(map, "admob_token_adsource_id", ""), p.a(map, "admob_init_mode", 0), jB, jB2, jB3, jB4, (jB <= 0 || jB2 <= 0 || jB3 <= 0 || jB4 <= 0 || jB <= jB3) ? -1L : jB2 - jB3);
        } catch (Throwable unused) {
        }
    }
}
