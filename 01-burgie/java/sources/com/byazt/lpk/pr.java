package com.byazt.lpk;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.ca.ho;
import com.byazt.ca.yb;
import com.byazt.eg.hw;
import com.byazt.ewn.AbsServerManager;
import com.byazt.fi.BaseConstants;
import com.byazt.hg.er;
import com.byazt.hg.of;
import com.byazt.hg.v;
import com.byazt.ld.rc;
import com.byazt.sd.a;
import com.byazt.sd.iu;
import com.byazt.sd.uc;
import com.byazt.vkw.g;
import com.byazt.vkw.hn;
import com.byazt.wt.DeviceUtils;
import com.byazt.wt.ls;
import com.byazt.wt.nt;
import com.byazt.zp.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.android.metrics.ActionType;
import com.bytedance.android.metrics.EnterFromMerge;
import com.bytedance.android.metrics.EnterMethod;
import com.bytedance.android.metrics.LiveMetrics;
import com.bytedance.android.metrics.LiveMetricsBuilder;
import com.taptap.sdk.db.constant.Common;
import com.umeng.analytics.pro.an;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 571, 37})
public class pr {
    public static void pr(final String str, final of ofVar, final long j) {
        zo.hw(new Runnable() { // from class: com.byazt.lpk.pr.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    er erVarA = ofVar.a();
                    String strVk = ofVar.vk();
                    if (TextUtils.isEmpty(strVk) && erVarA != null) {
                        strVk = erVarA.hw();
                    }
                    if (TextUtils.isEmpty(strVk)) {
                        return;
                    }
                    String strNy = null;
                    if (erVarA != null) {
                        strNy = erVarA.uc();
                    }
                    if (TextUtils.isEmpty(strNy)) {
                        strNy = ofVar.ny();
                    }
                    JSONObject jSONObjectFilterParam = LiveMetrics.filterParam(new LiveMetricsBuilder().roomId(Long.parseLong(strVk)).anchorId(erVarA != null ? erVarA.pr() : "").requestId(strNy).enterFromMerge(pr.hw(ls.k(ofVar))).enterMethod(pr.pr(ls.k(ofVar))).actionType(ActionType.CLICK).duration(j).build(), pr.pr(a.getContext()));
                    jSONObjectFilterParam.put("tob_extra", ofVar.B_());
                    jSONObjectFilterParam.put("live_sdk_status", hw.pr().hn());
                    jSONObjectFilterParam.put("live_auth_status", hw.pr().c());
                    jSONObjectFilterParam.put("app_start_time", SystemClock.elapsedRealtime() - Process.getStartElapsedRealtime());
                    jSONObjectFilterParam.put("is_web", ofVar.x_());
                    uc.pr(str, jSONObjectFilterParam);
                } catch (Throwable th) {
                    ho.pr("TTLiveVideoUtil", "Throwable : ", th);
                }
            }
        });
    }

    public static Map<String, String> pr(Context context) {
        g gVar = (g) com.byazt.zs.uc.pr("device_info_new");
        com.byazt.zb.pr.c();
        HashMap map = new HashMap();
        map.put("device_id", nt.pr());
        map.put("sdk_version", iu.c);
        map.put("os", "Android");
        map.put(an.y, Build.VERSION.RELEASE);
        map.put("device_model", gVar.hw());
        map.put(an.z, com.byazt.wt.er.uc(context) + "x" + com.byazt.wt.er.c(context));
        map.put("language", Locale.getDefault().getLanguage());
        map.put(an.M, String.valueOf(pr()));
        map.put(an.Q, yb.fw(context));
        map.put("openudid", DeviceUtils.hw());
        map.put("aid", "1371");
        map.put(an.s, com.byazt.hb.pr.uc());
        map.put("app_version", com.byazt.hb.pr.c());
        map.put(AbsServerManager.PACKAGE_QUERY_BINDER, ls.zo());
        map.put("region", Locale.getDefault().getCountry());
        map.put("tz_name", Calendar.getInstance().getTimeZone().getID());
        map.put("tz_offset", String.valueOf(Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000));
        map.put(Common.Predefined.SUB_ROM, ((g) com.byazt.zs.uc.pr("device_info_new")).yb());
        map.put(an.H, Build.MANUFACTURER);
        ArrayList<String> arrayListPr = com.byazt.ca.hw.pr(context, "MD5");
        if (arrayListPr != null && !arrayListPr.isEmpty()) {
            map.put("sig_hash", Build.MANUFACTURER);
        }
        map.put("display_density", hn(gVar.a()));
        map.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
        map.put("density_dpi", String.valueOf(gVar.a()));
        map.put(an.F, Build.BRAND);
        map.put("build_serial", gVar.ho());
        map.put("version_code", ls.aj());
        map.put("udid", DeviceUtils.pr((Boolean) null));
        map.put("cpu_abi", Build.CPU_ABI);
        map.put("oaid", ((hn) com.byazt.zs.uc.pr("embed_applog")).pr(false));
        return map;
    }

    public static EnterMethod pr(int i) {
        switch (i) {
            case 5:
                return EnterMethod.LIVE_CARD;
            case 6:
            default:
                return EnterMethod.NO_VALUE;
            case 7:
            case 8:
            case 9:
                return EnterMethod.LIVE_CELL;
        }
    }

    public static EnterFromMerge hw(int i) {
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

    public static boolean pr(of ofVar) {
        return v.pr(ofVar) && iu.x();
    }

    public static void hw(of ofVar) {
        if (ofVar == null || !pr(ofVar)) {
            return;
        }
        String strZo = v.zo(ofVar);
        String strAj = v.aj(ofVar);
        if (!TextUtils.isEmpty(strZo)) {
            com.byazt.ub.hw.pr(strZo).pr(new rc() { // from class: com.byazt.lpk.pr.2
                @Override // com.byazt.ld.rc
                public void pr(com.byazt.ld.nt ntVar) {
                }

                @Override // com.byazt.ld.rc
                public void pr(int i, String str, Throwable th) {
                }
            });
        }
        if (!TextUtils.isEmpty(strAj)) {
            com.byazt.ub.hw.pr(strAj).pr(new rc() { // from class: com.byazt.lpk.pr.3
                @Override // com.byazt.ld.rc
                public void pr(com.byazt.ld.nt ntVar) {
                }

                @Override // com.byazt.ld.rc
                public void pr(int i, String str, Throwable th) {
                }
            });
        }
    }

    private static String hn(int i) {
        switch (i) {
            case 120:
                return "ldpi";
            case 160:
            default:
                return "mdpi";
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA /* 240 */:
                return "hdpi";
            case MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME /* 320 */:
                return "xhdpi";
            case 480:
                return "xxhdpi";
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK /* 640 */:
                return "xxxhdpi";
        }
    }

    private static int pr() {
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
