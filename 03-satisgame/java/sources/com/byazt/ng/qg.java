package com.byazt.ng;

import android.text.TextUtils;
import com.byazt.ho.BaseConstants;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import java.net.URI;
import java.net.URISyntaxException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 548, 26})
public final class qg {
    public static volatile String n = "";
    public static volatile n qg = n.n();

    public static void n(JSONObject jSONObject) {
        if (jSONObject == null) {
            n = "";
            qg = n.n();
            return;
        }
        double dMin = 5.0d;
        double dOptDouble = jSONObject.optDouble("d_c_m_size", 5.0d);
        if (!Double.isNaN(dOptDouble) && dOptDouble > 0.0d) {
            dMin = Math.min(dOptDouble, 5.0d);
        }
        int iMax = Math.max(1, (int) Math.floor(dMin * 1048576.0d));
        int iOptInt = jSONObject.optInt("pic_tatch", 10);
        int iMin = iOptInt <= 0 ? 10 : Math.min(iOptInt, 100);
        int iOptInt2 = jSONObject.optInt("pic_size", 30);
        int iMin2 = iOptInt2 > 0 ? Math.min(iOptInt2, 2097151) : 30;
        boolean z = jSONObject.optInt("pic_only_wifi", 1) != 0;
        String strQg = qg(jSONObject.optString("d_c_url", ""));
        n = jSONObject.toString();
        qg = new n(strQg, iMax, z, iMin, iMin2 * 1024);
    }

    public static n n() {
        return qg;
    }

    public static String qg() {
        return n;
    }

    public static void n(String str) {
        if (TextUtils.isEmpty(str)) {
            n((JSONObject) null);
            return;
        }
        try {
            n(new JSONObject(str));
        } catch (JSONException unused) {
            n((JSONObject) null);
        }
    }

    private static String qg(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String strTrim = str.trim();
        try {
            URI uri = new URI(strTrim);
            return (!BaseConstants.SCHEME_HTTPS.equalsIgnoreCase(uri.getScheme()) || TextUtils.isEmpty(uri.getHost())) ? "" : strTrim;
        } catch (URISyntaxException unused) {
        }
    }

    @com.byazt.cp.n(n = {0, 1, 548, 48})
    public static final class n {
        public final int l;
        public final String n;
        public final int q;
        public final int qg;
        public final boolean s;

        public n(String str, int i, boolean z, int i2, int i3) {
            this.n = str;
            this.qg = i;
            this.s = z;
            this.q = i2;
            this.l = i3;
        }

        public static n n() {
            return new n("", AVMDLDataLoaderConfigure.DEFAULT_MAX_FACTORY_MEMORY_SIZE, true, 10, 30720);
        }
    }
}
