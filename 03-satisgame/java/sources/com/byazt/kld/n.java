package com.byazt.kld;

import android.content.Context;
import android.os.Build;
import com.byazt.af.x;
import com.byazt.ehw.DeviceUtils;
import com.byazt.gct.pk;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.byazt.qp.q;
import com.byazt.vf.oa;
import com.byazt.vf.s;
import com.byazt.vgx.w;
import com.byazt.wb.fs;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1772, 19})
public class n {
    public static Object n(int i, int i2) {
        s sVar = (s) q.n("embed_applog");
        if (i != 1) {
            return null;
        }
        if (i2 == 1001) {
            return sVar.n();
        }
        if (i2 != 1002) {
            return null;
        }
        return sVar.n(false);
    }

    public static JSONObject n(int... iArr) {
        if (iArr != null) {
            try {
                if (iArr.length != 0) {
                    JSONObject jSONObject = new JSONObject();
                    for (int i : iArr) {
                        Object objN = n(1, i);
                        if (i == 1001) {
                            jSONObject.putOpt("did", objN);
                        } else if (i == 1002) {
                            jSONObject.putOpt("oaid", objN);
                        }
                    }
                    return jSONObject;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static JSONObject n() {
        JSONObject jSONObject = new JSONObject();
        try {
            Context context = rv.getContext();
            oa oaVar = (oa) q.n("device_info_new");
            s sVar = (s) q.n("embed_applog");
            try {
                jSONObject.put("device_score", Double.parseDouble(com.byazt.gh.n.n().n("DeviceRate", "bytebench_value", com.byazt.vgx.s.q())));
            } catch (Exception unused) {
                jSONObject.put("device_score", -1.0d);
            }
            try {
                jSONObject.put("bottom_device_level", Integer.parseInt(com.byazt.gh.n.n().n("DeviceRate", "device_level", com.byazt.vgx.s.q())));
            } catch (Exception unused2) {
                jSONObject.put("bottom_device_level", -1);
            }
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("model", oaVar.qg());
            jSONObject.put("language", Locale.getDefault().getLanguage());
            jSONObject.put("conn_type", DeviceUtils.q());
            jSONObject.put("applog_did", sVar.n());
            int i = 0;
            jSONObject.put("oaid", sVar.n(false));
            int[] iArrQ = com.byazt.okk.s.q(context);
            jSONObject.put("screen_width", iArrQ[0]);
            int i2 = 1;
            jSONObject.put("screen_height", iArrQ[1]);
            jSONObject.put("cpu_num", w.sz());
            jSONObject.put("cpu_max_freq", w.k());
            jSONObject.put("cpu_min_freq", w.cy());
            jSONObject.put("is_charging", DeviceUtils.n.n(context));
            jSONObject.put("total_mem", w.d());
            jSONObject.put("total_space", String.valueOf(w.hd()));
            jSONObject.put("free_space", com.byazt.ehw.s.n);
            jSONObject.put("free_space_in", String.valueOf(w.um()));
            jSONObject.put("sdcard_size", String.valueOf(w.a()));
            jSONObject.put("rooted", w.ou());
            if (context != null) {
                jSONObject.put("orientation", context.getResources().getConfiguration().orientation);
            }
            jSONObject.put("screen_bright", Math.ceil(DeviceUtils.l() * 10.0f) / 10.0d);
            if (!DeviceUtils.n()) {
                i = 1;
            }
            jSONObject.put("is_screen_off", i);
            jSONObject.put("battery_remaining_pct", (int) DeviceUtils.n.qg(context));
            jSONObject.put("cpu_ratio", com.byazt.yq.n.n().s());
            jSONObject.put("jank_rate", com.byazt.yq.n.n().qg());
            jSONObject.put("men_ratio", com.byazt.yq.n.n().q());
            jSONObject.putOpt("live_auth_status", Integer.valueOf(com.byazt.wq.qg.n().l()));
            jSONObject.putOpt("gpu_model", fs.n());
            jSONObject.putOpt("font_size", Float.valueOf(com.byazt.wb.s.x().sz()));
            if (!tj.l()) {
                i2 = 2;
            }
            jSONObject.putOpt("is_use_tt_video", Integer.valueOf(i2));
        } catch (Throwable unused3) {
        }
        return jSONObject;
    }

    public static void n(int i, int i2, String str, pk pkVar) {
        if (i != 2 || pkVar == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            new JSONObject().putOpt("union_key", pkVar.ih());
            if (i2 == 2001) {
                new com.byazt.vhv.q.l.n().n(jSONObject.optDouble(x.n, 0.0d)).qg(jSONObject.optDouble("y", 0.0d)).s(jSONObject.optDouble("z", 0.0d)).n(pkVar.ih()).n(jSONObject.optLong("ts", 0L)).n();
            } else if (i2 == 2002) {
                new com.byazt.vhv.q.C0372q.n().n(jSONObject.optDouble(x.n, 0.0d)).qg(jSONObject.optDouble("y", 0.0d)).s(jSONObject.optDouble("z", 0.0d)).n(pkVar.ih()).n(jSONObject.optLong("ts", 0L)).n();
            } else if (i2 == 2003) {
                new com.byazt.vhv.q.s.n().n(jSONObject.optDouble("yaw", 0.0d)).qg(jSONObject.optDouble("pitch", 0.0d)).s(jSONObject.optDouble("roll", 0.0d)).n(pkVar.ih()).n(jSONObject.optLong("ts", 0L)).n();
            }
        } catch (Throwable unused) {
        }
    }
}
