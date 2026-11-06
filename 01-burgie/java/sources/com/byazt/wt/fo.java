package com.byazt.wt;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS})
public class fo {
    public static void pr(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (str == null) {
                    str = "";
                }
                com.byazt.hs.hn.hw(7, str);
            }
        } catch (Throwable th) {
        }
    }

    public static void pr(com.byazt.igw.x xVar) {
        com.byazt.qv.pr.pr(xVar);
        com.byazt.eg.hw.pr().pr(xVar);
    }

    public static String hw(com.byazt.igw.x xVar) {
        JSONObject jSONObjectPr;
        if (xVar == null) {
            return "error";
        }
        String type = xVar.getType();
        if (TextUtils.equals(type, "error")) {
            return "error";
        }
        if (TextUtils.equals(type, "timeout")) {
            return "timeout";
        }
        com.byazt.lq.hw hwVarPr = xVar.pr();
        if (hwVarPr == null || TextUtils.isEmpty(hwVarPr.pr()) || (jSONObjectPr = pr(hwVarPr)) == null) {
            return "error";
        }
        return jSONObjectPr.toString();
    }

    public static String hn(com.byazt.igw.x xVar) {
        if (xVar != null) {
            String type = xVar.getType();
            if (TextUtils.equals(type, "error")) {
                return "error";
            }
            if (TextUtils.equals(type, "timeout")) {
                return "timeout";
            }
            com.byazt.lq.hw hwVarPr = xVar.pr();
            if (hwVarPr == null || TextUtils.isEmpty(hwVarPr.pr())) {
                return "error";
            }
            return hwVarPr.pr();
        }
        return null;
    }

    private static JSONObject pr(com.byazt.lq.hw hwVar) {
        if (hwVar == null) {
            return null;
        }
        String strPr = hwVar.pr();
        long jHn = hwVar.hn();
        boolean zHw = hwVar.hw();
        if (TextUtils.isEmpty(strPr)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("oaid", strPr);
            jSONObject.putOpt("isTrackLimited", Boolean.valueOf(zHw));
            jSONObject.putOpt("hWIdVersionCode", Long.valueOf(jHn));
            return jSONObject;
        } catch (Exception e) {
            return null;
        }
    }

    public static String hw(String str) {
        if (TextUtils.isEmpty(str)) {
            return "error";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("oaid", str);
            jSONObject.putOpt("isTrackLimited", Boolean.FALSE);
            jSONObject.putOpt("hWIdVersionCode", Integer.valueOf(pr(com.byazt.sd.a.getContext())));
            return jSONObject.toString();
        } catch (Exception e) {
            return "error";
        }
    }

    public static com.byazt.lq.hw hn(final String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        final int iPr = pr(com.byazt.sd.a.getContext());
        return new com.byazt.lq.hw() { // from class: com.byazt.wt.fo.1
            @Override // com.byazt.lq.hw
            public String pr() {
                return str;
            }

            @Override // com.byazt.lq.hw
            public boolean hw() {
                return false;
            }

            @Override // com.byazt.lq.hw
            public long hn() {
                return iPr;
            }
        };
    }

    private static int pr(Context context) {
        String str = "com.huawei.hwid";
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) == null) {
                if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                    str = "com.huawei.hwid.tv";
                } else {
                    str = "com.huawei.hms";
                }
            }
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo == null) {
                return 0;
            }
            return packageInfo.versionCode;
        } catch (Exception e) {
            return 0;
        }
    }

    public static int pr() {
        return ((com.byazt.vkw.hn) com.byazt.zs.uc.pr("embed_applog")).c() ? 1 : 0;
    }
}
