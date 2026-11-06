package com.bytedance.sdk.openadsdk.core.video.ah;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.android.metrics.ActionType;
import com.bytedance.android.metrics.EnterFromMerge;
import com.bytedance.android.metrics.EnterMethod;
import com.bytedance.android.metrics.LiveMetrics;
import com.bytedance.android.metrics.LiveMetricsBuilder;
import com.bytedance.sdk.component.c.ao;
import com.bytedance.sdk.component.c.hi;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.utils.ah;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.u;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.jw.b;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.jw.w;
import com.bytedance.sdk.openadsdk.core.nw.f;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.t;
import com.bytedance.sdk.openadsdk.op.ab;
import com.bytedance.sdk.openadsdk.x.xr;
import com.umeng.analytics.pro.bv;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private static String ah(int i) {
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

    public static void ms(final String str, final lm lmVar, final long j) {
        ab.xr(new ny("csj_live_log_event") { // from class: com.bytedance.sdk.openadsdk.core.video.ah.ms.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    f fVarDm = lmVar.dm();
                    String strEo = lmVar.eo();
                    if (TextUtils.isEmpty(strEo) && fVarDm != null) {
                        strEo = fVarDm.xr();
                    }
                    if (TextUtils.isEmpty(strEo)) {
                        return;
                    }
                    String strC = fVarDm != null ? fVarDm.c() : null;
                    if (TextUtils.isEmpty(strC)) {
                        strC = lmVar.eu();
                    }
                    JSONObject jSONObjectFilterParam = LiveMetrics.filterParam(new LiveMetricsBuilder().roomId(Long.parseLong(strEo)).anchorId(fVarDm != null ? fVarDm.ms() : "").requestId(strC).enterFromMerge(ms.xr(com.bytedance.sdk.openadsdk.core.jw.f.x(lmVar))).enterMethod(ms.ms(com.bytedance.sdk.openadsdk.core.jw.f.x(lmVar))).actionType(ActionType.CLICK).duration(j).build(), ms.ms(re.getContext()));
                    jSONObjectFilterParam.put("tob_extra", lmVar.lx());
                    c.xr(str, jSONObjectFilterParam);
                } catch (Throwable th) {
                    sl.ah("TTLiveVideoUtil", "Throwable : ", th);
                }
            }
        });
    }

    public static Map<String, String> ms(Context context) {
        HashMap map = new HashMap();
        map.put("device_id", t.ah());
        map.put("sdk_version", g.ah);
        map.put("os", "Android");
        map.put(bv.y, Build.VERSION.RELEASE);
        map.put("device_model", t.re());
        map.put(bv.z, ul.ka(context) + "x" + ul.d(context));
        map.put("language", Locale.getDefault().getLanguage());
        map.put("timezone", String.valueOf(xr()));
        map.put(bv.Q, u.ab(context));
        map.put("openudid", t.c());
        map.put("aid", "1371");
        map.put(bv.s, com.bytedance.sdk.openadsdk.core.x.ms.ka());
        map.put("app_version", com.bytedance.sdk.openadsdk.core.x.ms.d());
        map.put("package", com.bytedance.sdk.openadsdk.core.jw.f.ch());
        map.put("region", Locale.getDefault().getCountry());
        map.put("tz_name", Calendar.getInstance().getTimeZone().getID());
        map.put("tz_offset", String.valueOf(Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000));
        map.put("rom", ms());
        map.put(bv.H, Build.MANUFACTURER);
        ArrayList<String> arrayListMs = ah.ms(context, "MD5");
        if (arrayListMs != null && !arrayListMs.isEmpty()) {
            map.put("sig_hash", Build.MANUFACTURER);
        }
        map.put("display_density", ah(ul.x(context)));
        map.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
        map.put("density_dpi", String.valueOf(ul.x(context)));
        map.put(bv.F, Build.BRAND);
        map.put("build_serial", t.sl());
        map.put("version_code", com.bytedance.sdk.openadsdk.core.jw.f.hi());
        map.put("udid", t.ab());
        map.put("cpu_abi", Build.CPU_ABI);
        map.put("oaid", b.ms(false));
        return map;
    }

    public static EnterMethod ms(int i) {
        if (i == 5) {
            return EnterMethod.LIVE_CARD;
        }
        if (i == 7 || i == 8 || i == 9) {
            return EnterMethod.LIVE_CELL;
        }
        return EnterMethod.NO_VALUE;
    }

    public static EnterFromMerge xr(int i) {
        if (i == 7) {
            return EnterFromMerge.AD_UNION_EXCITATION;
        }
        if (i == 8) {
            return EnterFromMerge.AD_UNION_INSERT;
        }
        if (i == 5) {
            return EnterFromMerge.AD_UNION_FEED;
        }
        if (i == 9) {
            return EnterFromMerge.AD_UNION_DRAW;
        }
        return EnterFromMerge.NO_VALUE;
    }

    public static boolean ms(lm lmVar) {
        return g.d() && com.bytedance.sdk.openadsdk.core.nw.ul.ms(lmVar);
    }

    public static void xr(lm lmVar) {
        if (lmVar != null && ms(lmVar)) {
            String strX = com.bytedance.sdk.openadsdk.core.nw.ul.x(lmVar);
            String strNy = com.bytedance.sdk.openadsdk.core.nw.ul.ny(lmVar);
            if (!TextUtils.isEmpty(strX)) {
                xr.ms(strX).ms(new ao() { // from class: com.bytedance.sdk.openadsdk.core.video.ah.ms.2
                    @Override // com.bytedance.sdk.component.c.ao
                    @ATSMethod(2)
                    public void ms(int i, String str, Throwable th) {
                    }

                    @Override // com.bytedance.sdk.component.c.ao
                    @ATSMethod(1)
                    public void ms(hi hiVar) {
                    }
                });
            }
            if (TextUtils.isEmpty(strNy)) {
                return;
            }
            xr.ms(strNy).ms(new ao() { // from class: com.bytedance.sdk.openadsdk.core.video.ah.ms.3
                @Override // com.bytedance.sdk.component.c.ao
                @ATSMethod(2)
                public void ms(int i, String str, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.c.ao
                @ATSMethod(1)
                public void ms(hi hiVar) {
                }
            });
        }
    }

    private static String ms() {
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

    private static int xr() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }
}
