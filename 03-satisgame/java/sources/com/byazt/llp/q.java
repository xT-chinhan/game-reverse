package com.byazt.llp;

import android.content.Context;
import com.byazt.gct.wv;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.phr.qg
@com.byazt.cp.n(n = {0, 1, 2088, 5})
public class q implements d, n {

    @com.byazt.phr.n(n = "convert_from_landing_page", qg = "CONTEXT")
    public boolean fs;

    @com.byazt.phr.n(n = "target_url", qg = "DATA_SOURCE")
    public String l;

    @com.byazt.phr.n(n = "path", qg = "DSL")
    public String n;

    @com.byazt.phr.n(n = "wc_miniapp_info", qg = "DATA_SOURCE")
    public JSONObject q;

    @com.byazt.phr.n(n = TapEventParamConstants.PARAM_NAME, qg = "DSL")
    public String qg;

    @com.byazt.phr.n(n = "event_tag", qg = "CONTEXT")
    public String rv;

    @com.byazt.phr.n(n = "type", qg = "DSL")
    public int s;

    @com.byazt.phr.n(n = "landing_page_source", qg = "CONTEXT")
    public int tj;

    @com.byazt.phr.n(n = "ext", qg = "DATA_SOURCE")
    public String w;

    @com.byazt.phr.n(n = "context", qg = "CONTEXT")
    public Context x;

    public Context getContext() {
        return this.x;
    }

    public boolean qg() {
        return this.fs;
    }

    public String s() {
        return this.rv;
    }

    public int q() {
        return this.tj;
    }

    @Override // com.byazt.llp.d
    public wv J_() {
        return wv.n(this.q);
    }

    public String x() {
        return this.n;
    }

    public String rv() {
        return this.qg;
    }

    @Override // com.byazt.llp.d, com.byazt.llp.tj
    public String fs() {
        return this.l;
    }

    @Override // com.byazt.llp.d, com.byazt.llp.tj
    public String F_() {
        return this.w;
    }

    public int tj() {
        return this.s;
    }

    @Override // com.byazt.llp.n
    public Map<String, String> n() {
        return new HashMap();
    }
}
