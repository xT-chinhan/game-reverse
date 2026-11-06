package com.byazt.gks;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.af.x;
import com.byazt.ehw.DeviceUtils;
import com.byazt.ehw.l;
import com.byazt.gc.AbsServerManager;
import com.byazt.gct.df;
import com.byazt.gct.oj;
import com.byazt.gct.pk;
import com.byazt.ho.BaseConstants;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.byazt.qp.q;
import com.byazt.si.cy;
import com.byazt.si.m;
import com.byazt.tk.hd;
import com.byazt.tk.k;
import com.byazt.vf.oa;
import com.byazt.vgx.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.android.metrics.ActionType;
import com.bytedance.android.metrics.EnterFromMerge;
import com.bytedance.android.metrics.EnterMethod;
import com.bytedance.android.metrics.LiveMetrics;
import com.bytedance.android.metrics.LiveMetricsBuilder;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DNS_START_TIME, 19})
public class n {
    private static String s(int i) {
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

    public static void n(final String str, final pk pkVar, final long j) {
        com.byazt.ag.qg.qg(new Runnable() { // from class: com.byazt.gks.n.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    df dfVarA = pkVar.a();
                    String strTj = pkVar.tj();
                    if (TextUtils.isEmpty(strTj) && dfVarA != null) {
                        strTj = dfVarA.qg();
                    }
                    if (TextUtils.isEmpty(strTj)) {
                        return;
                    }
                    String strW = dfVarA != null ? dfVarA.w() : null;
                    if (TextUtils.isEmpty(strW)) {
                        strW = pkVar.ou();
                    }
                    JSONObject jSONObjectFilterParam = LiveMetrics.filterParam(new LiveMetricsBuilder().roomId(Long.parseLong(strTj)).anchorId(dfVarA != null ? dfVarA.n() : "").requestId(strW).enterFromMerge(n.qg(w.d(pkVar))).enterMethod(n.n(w.d(pkVar))).actionType(ActionType.CLICK).duration(j).build(), n.n(rv.getContext()));
                    jSONObjectFilterParam.put("tob_extra", pkVar.F_());
                    jSONObjectFilterParam.put("live_sdk_status", com.byazt.wq.qg.n().s());
                    jSONObjectFilterParam.put("live_auth_status", com.byazt.wq.qg.n().l());
                    jSONObjectFilterParam.put("app_start_time", SystemClock.elapsedRealtime() - Process.getStartElapsedRealtime());
                    jSONObjectFilterParam.put("is_web", pkVar.B_());
                    com.byazt.yu.n.n(str, jSONObjectFilterParam);
                } catch (Throwable th) {
                    k.n("TTLiveVideoUtil", "Throwable : ", th);
                }
            }
        });
    }

    public static Map<String, String> n(Context context) {
        oa oaVar = (oa) q.n("device_info_new");
        com.byazt.vgx.s.l();
        HashMap map = new HashMap();
        map.put(TapEventParamConstants.PARAM_DEVICE_ID, l.n());
        map.put("sdk_version", tj.w);
        map.put(TapEventParamConstants.PARAM_SUB_OS, "Android");
        map.put("os_version", Build.VERSION.RELEASE);
        map.put(TapEventParamConstants.PARAM_SUB_DEVICE_MODEL, oaVar.qg());
        map.put("resolution", com.byazt.okk.s.w(context) + x.n + com.byazt.okk.s.l(context));
        map.put("language", Locale.getDefault().getLanguage());
        map.put("timezone", String.valueOf(n()));
        map.put("access", hd.x(context));
        map.put("openudid", DeviceUtils.qg());
        map.put("aid", "1371");
        map.put("display_name", com.byazt.ges.qg.w());
        map.put("app_version", com.byazt.ges.qg.l());
        map.put(AbsServerManager.PACKAGE_QUERY_BINDER, w.fs());
        map.put("region", Locale.getDefault().getCountry());
        map.put("tz_name", Calendar.getInstance().getTimeZone().getID());
        map.put("tz_offset", String.valueOf(Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000));
        map.put(TapEventParamConstants.PARAM_SUB_ROM, ((oa) q.n("device_info_new")).hd());
        map.put("device_manufacturer", Build.MANUFACTURER);
        ArrayList<String> arrayListN = com.byazt.tk.qg.n(context, com.anythink.core.common.u.n.a);
        if (arrayListN != null && !arrayListN.isEmpty()) {
            map.put("sig_hash", Build.MANUFACTURER);
        }
        map.put("display_density", s(oaVar.a()));
        map.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
        map.put("density_dpi", String.valueOf(oaVar.a()));
        map.put("device_brand", Build.BRAND);
        map.put("build_serial", oaVar.k());
        map.put("version_code", w.rv());
        map.put("udid", DeviceUtils.n((Boolean) null));
        map.put("cpu_abi", Build.CPU_ABI);
        map.put("oaid", ((com.byazt.vf.s) q.n("embed_applog")).n(false));
        return map;
    }

    public static EnterMethod n(int i) {
        if (i == 5) {
            return EnterMethod.LIVE_CARD;
        }
        if (i == 7 || i == 8 || i == 9) {
            return EnterMethod.LIVE_CELL;
        }
        return EnterMethod.NO_VALUE;
    }

    public static EnterFromMerge qg(int i) {
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

    public static boolean n(pk pkVar) {
        return oj.n(pkVar) && tj.l();
    }

    public static void qg(pk pkVar) {
        if (pkVar != null && n(pkVar)) {
            String strFs = oj.fs(pkVar);
            String strRv = oj.rv(pkVar);
            if (!TextUtils.isEmpty(strFs)) {
                com.byazt.imu.s.n(strFs).n(new m() { // from class: com.byazt.gks.n.2
                    @Override // com.byazt.si.m
                    public void n(int i, String str, Throwable th) {
                    }

                    @Override // com.byazt.si.m
                    public void n(cy cyVar) {
                    }
                });
            }
            if (TextUtils.isEmpty(strRv)) {
                return;
            }
            com.byazt.imu.s.n(strRv).n(new m() { // from class: com.byazt.gks.n.3
                @Override // com.byazt.si.m
                public void n(int i, String str, Throwable th) {
                }

                @Override // com.byazt.si.m
                public void n(cy cyVar) {
                }
            });
        }
    }

    private static int n() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / BaseConstants.Time.HOUR;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }
}
