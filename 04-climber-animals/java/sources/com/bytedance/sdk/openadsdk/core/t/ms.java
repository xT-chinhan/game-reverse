package com.bytedance.sdk.openadsdk.core.t;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.cv;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.jw.b;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.jw.w;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.t;
import com.umeng.analytics.pro.bv;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements com.bytedance.sdk.component.x.ms.x {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final ms f3314ms = new ms();
    private int ah;
    private String d;
    private long xr;

    public static String ms(int i) {
        if (i == 120) {
            return "ldpi";
        }
        if (i == 160) {
            return "mdpi";
        }
        if (i == 240) {
            return "hdpi";
        }
        if (i == 320) {
            return "xhdpi";
        }
        if (i != 480) {
            return i != 640 ? "mdpi" : "xxxhdpi";
        }
        return "xxhdpi";
    }

    private ms() {
    }

    public String ms(Context context) {
        try {
            if (com.bytedance.sdk.openadsdk.core.jw.ch.ah(context)) {
                return "tv";
            }
            return com.bytedance.sdk.openadsdk.core.jw.ch.xr(context) ? "android_pad" : "android";
        } catch (Throwable unused) {
            return "android";
        }
    }

    private JSONObject ms(List<com.bytedance.sdk.component.x.ms.xr> list, boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        Context context = re.getContext();
        int i = 0;
        if (z) {
            try {
                jSONObject.put("sdk_version", g.ah);
                jSONObject.put(bv.s, com.bytedance.sdk.openadsdk.core.x.ms.ka());
                jSONObject.put("app_version", com.bytedance.sdk.openadsdk.core.x.ms.d());
                jSONObject.put("package", f.ch());
                jSONObject.put("region", Locale.getDefault().getCountry());
                jSONObject.put("tz_name", Calendar.getInstance().getTimeZone().getID());
                jSONObject.put("tz_offset", Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000);
                ArrayList<String> arrayListMs = com.bytedance.sdk.component.utils.ah.ms(context, "MD5");
                if (arrayListMs != null && !arrayListMs.isEmpty()) {
                    jSONObject.put("sig_hash", arrayListMs.get(0));
                }
                jSONObject.put("version_code", f.hi());
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.sl.d("log_net", th.getMessage());
            }
        }
        jSONObject.put("ua", f.ab());
        com.bytedance.sdk.openadsdk.ub.xr.ah(context, jSONObject);
        jSONObject.put("openudid", t.c());
        jSONObject.put("oaid", b.ms(false));
        jSONObject.put("ad_sdk_version", g.ah);
        jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "6.9.2.3");
        jSONObject.put("is_plugin", g.ms());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("client_ipv4", com.bytedance.sdk.openadsdk.core.jw.ch.ms((String) null));
        jSONObject2.put("client_ipv6", com.bytedance.sdk.openadsdk.core.jw.ch.ab());
        jSONObject.put("custom", jSONObject2);
        jSONObject.put("sim_op", t.ub());
        jSONObject.put("root", z2 ? 1 : 0);
        jSONObject.put("timezone", sl());
        jSONObject.put(bv.Q, com.bytedance.sdk.component.utils.u.ab(context));
        jSONObject.put("os", "Android");
        jSONObject.put(bv.y, Build.VERSION.RELEASE);
        jSONObject.put("os_api", Build.VERSION.SDK_INT);
        if (TextUtils.isEmpty(this.d)) {
            this.d = ms(context);
        }
        jSONObject.put(bv.ac, this.d);
        jSONObject.put("device_model", t.re());
        jSONObject.put(bv.F, Build.BRAND);
        jSONObject.put(bv.H, Build.MANUFACTURER);
        jSONObject.put("language", Locale.getDefault().getLanguage());
        jSONObject.put(bv.z, ul.ka(context) + "x" + ul.d(context));
        jSONObject.put("display_density", ms(ul.x(context)));
        jSONObject.put("density_dpi", ul.x(context));
        jSONObject.put("device_id", t.ah());
        int iAh = com.bytedance.sdk.component.x.xr.ah.ms.ah(list, com.bytedance.sdk.component.x.xr.ms.ka("csj"));
        if (iAh != 0) {
            jSONObject.put("aid", String.valueOf(iAh));
        } else {
            jSONObject.put("aid", "1371");
        }
        jSONObject.put("rom", hi());
        jSONObject.put("cpu_abi", Build.CPU_ABI);
        jSONObject.put("build_serial", t.sl());
        jSONObject.put("ut", this.ah);
        jSONObject.put("uid", this.xr);
        jSONObject.put("locale_language", com.bytedance.sdk.openadsdk.core.jw.ch.hi());
        jSONObject.put("screen_bright", Math.ceil(com.bytedance.sdk.openadsdk.core.jw.ch.sl() * 10.0f) / 10.0d);
        if (!com.bytedance.sdk.openadsdk.core.jw.ch.ms()) {
            i = 1;
        }
        jSONObject.put("is_screen_off", i);
        if (context != null) {
            jSONObject.put("download_channel", com.bytedance.sdk.openadsdk.core.x.ms.ms(context));
        }
        if (cv.ah() > 0) {
            jSONObject.put("screenshot_time", String.valueOf(cv.ah()));
        }
        jSONObject.put("mnc", t.y());
        jSONObject.put("mcc", t.h());
        jSONObject.put("pan_code_serial", "1000");
        return jSONObject;
    }

    public static String hi() {
        StringBuilder sb = new StringBuilder();
        try {
            if (w.ao()) {
                sb.append("MIUI-");
            } else if (w.t()) {
                sb.append("FLYME-");
            } else {
                String strNw = w.nw();
                if (w.ms(strNw)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(strNw)) {
                    sb.append(strNw).append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    @Override // com.bytedance.sdk.component.x.ms.x
    public JSONObject ms(List<com.bytedance.sdk.component.x.ms.xr> list, boolean z) {
        if (list != null && !list.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            boolean z2 = false;
            try {
                ms(list.get(0));
                JSONArray jSONArray = new JSONArray();
                Iterator<com.bytedance.sdk.component.x.ms.xr> it = list.iterator();
                while (it.hasNext()) {
                    JSONObject jSONObjectAb = it.next().ab();
                    if (TextUtils.equals("pangle_live_sdk_monitor", jSONObjectAb.optString(NotificationCompat.CATEGORY_EVENT))) {
                        if (!z2) {
                            z2 = true;
                        }
                        jSONObjectAb.putOpt("nt", Integer.valueOf(com.bytedance.sdk.component.utils.u.ah(re.getContext())));
                    }
                    jSONArray.put(jSONObjectAb);
                }
                jSONObject.put("header", ms(list, z2, z));
                jSONObject.put("event_v3", jSONArray);
                jSONObject.put("magic_tag", "ss_app_log");
                jSONObject.put("_gen_time", System.currentTimeMillis());
                return jSONObject;
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.sl.xr(e.getMessage());
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.x.ms.x
    public byte[] ms(JSONObject jSONObject, int i) throws Throwable {
        byte[] bArrXr = xr(jSONObject);
        if (bArrXr == null) {
            return null;
        }
        if (i > 3) {
            byte[] bArrMs = com.bytedance.sdk.component.panglearmor.ny.ms().ms(bArrXr);
            if (bArrMs != null) {
                return bArrMs;
            }
            u.ms().ms(3, -1L, "applog");
            return bArrMs;
        }
        return TTEncryptUtils.a(bArrXr, bArrXr.length);
    }

    @Override // com.bytedance.sdk.component.x.ms.x
    public byte[] xr(JSONObject jSONObject, int i) throws Throwable {
        byte[] bArrXr = xr(jSONObject);
        if (bArrXr == null || !com.bytedance.sdk.component.panglearmor.ny.xr() || i <= 3) {
            return null;
        }
        byte[] bArrMs = com.bytedance.sdk.component.panglearmor.ny.ms().ms(bArrXr);
        if (bArrMs != null) {
            return bArrMs;
        }
        u.ms().ms(3, -1L, "stats");
        return bArrMs;
    }

    private byte[] xr(JSONObject jSONObject) throws Throwable {
        GZIPOutputStream gZIPOutputStream = null;
        if (jSONObject == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        try {
            try {
                try {
                    GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream2.write(jSONObject.toString().getBytes());
                        gZIPOutputStream2.close();
                    } catch (Exception e) {
                        e = e;
                        gZIPOutputStream = gZIPOutputStream2;
                        com.bytedance.sdk.component.utils.sl.ms(e);
                        if (gZIPOutputStream != null) {
                            gZIPOutputStream.close();
                        }
                        return byteArrayOutputStream.toByteArray();
                    } catch (Throwable th) {
                        th = th;
                        gZIPOutputStream = gZIPOutputStream2;
                        if (gZIPOutputStream != null) {
                            try {
                                gZIPOutputStream.close();
                            } catch (IOException e2) {
                                com.bytedance.sdk.component.utils.sl.ms(e2);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (IOException e4) {
            com.bytedance.sdk.component.utils.sl.ms(e4);
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.bytedance.sdk.component.x.ms.x
    public boolean ms() {
        return com.bytedance.sdk.openadsdk.core.ch.ub().xn();
    }

    @Override // com.bytedance.sdk.component.x.ms.x
    public String xr() {
        return f.yu();
    }

    @Override // com.bytedance.sdk.component.x.ms.x
    public long ah() {
        long jRe = re.xr().re();
        if (jRe < 0 || jRe == 2147483647L) {
            return 5000L;
        }
        return jRe;
    }

    @Override // com.bytedance.sdk.component.x.ms.x
    public int d() {
        int i = re.xr().i();
        if (i < 0 || i == Integer.MAX_VALUE) {
            return 10;
        }
        return i;
    }

    @Override // com.bytedance.sdk.component.x.ms.x
    public com.bytedance.sdk.component.x.ms.ms.c ka() {
        return new sl(com.bytedance.sdk.openadsdk.core.re.ka.ms().xr().xr());
    }

    @Override // com.bytedance.sdk.component.x.ms.x
    public String c() {
        return f.w();
    }

    @Override // com.bytedance.sdk.component.x.ms.x
    public String ab() {
        return f.ch("/api/ad/union/sdk/stats/batch/");
    }

    @Override // com.bytedance.sdk.component.x.ms.x
    public boolean x() {
        return g.ms();
    }

    @Override // com.bytedance.sdk.component.x.ms.x
    public JSONObject ms(JSONObject jSONObject) {
        return com.bytedance.sdk.component.utils.ms.ms(jSONObject);
    }

    @Override // com.bytedance.sdk.component.x.ms.x
    public JSONObject ny() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_id", t.ah());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private void ms(com.bytedance.sdk.component.x.ms.xr xrVar) {
        String strOptString;
        if (xrVar == null) {
            return;
        }
        JSONObject jSONObjectAb = xrVar.ab();
        JSONObject jSONObjectOptJSONObject = jSONObjectAb.optJSONObject("params");
        if (jSONObjectOptJSONObject != null) {
            strOptString = jSONObjectOptJSONObject.optString("log_extra", "");
        } else {
            strOptString = jSONObjectAb.optString("log_extra", "");
        }
        long jD = f.d(strOptString);
        int iKa = f.ka(strOptString);
        if (jD == 0) {
            jD = this.xr;
        }
        this.xr = jD;
        if (iKa == 0) {
            iKa = this.ah;
        }
        this.ah = iKa;
    }

    public static int sl() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    @Override // com.bytedance.sdk.component.x.ms.x
    public int ch() {
        return re.xr().nn() ? 4 : 3;
    }
}
