package com.byazt.uq;

import android.os.SystemClock;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_CHECK_SILENCE_INTERVAL, 8})
public final class s {
    private static JSONObject fs() {
        try {
            return com.byazt.nf.rv.qg().tk();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean n() {
        JSONObject jSONObjectFs = fs();
        if (jSONObjectFs != null && jSONObjectFs.has("enable")) {
            Object objOpt = jSONObjectFs.opt("enable");
            if (objOpt instanceof Boolean) {
                return ((Boolean) objOpt).booleanValue();
            }
        }
        return false;
    }

    public static float qg() {
        JSONObject jSONObjectFs;
        if (n() && (jSONObjectFs = fs()) != null && jSONObjectFs.has("rate")) {
            double dOptDouble = jSONObjectFs.optDouble("rate", -1.0d);
            if (dOptDouble >= 0.0d && dOptDouble <= 1.0d) {
                return (float) dOptDouble;
            }
        }
        return 0.0f;
    }

    public static int s() {
        int iOptInt;
        JSONObject jSONObjectFs = fs();
        if (jSONObjectFs == null || !jSONObjectFs.has("view_depth") || (iOptInt = jSONObjectFs.optInt("view_depth", 20)) <= 0) {
            return 20;
        }
        return iOptInt;
    }

    public static boolean q() {
        JSONObject jSONObjectFs;
        if (n() && (jSONObjectFs = fs()) != null && jSONObjectFs.has("req_switch")) {
            Object objOpt = jSONObjectFs.opt("req_switch");
            if (objOpt instanceof Boolean) {
                return ((Boolean) objOpt).booleanValue();
            }
        }
        return false;
    }

    public static int l() {
        JSONObject jSONObjectFs = fs();
        int iOptInt = jSONObjectFs != null ? jSONObjectFs.optInt("win_days", 7) : 7;
        if (iOptInt > 0) {
            return iOptInt;
        }
        return 7;
    }

    public static int w() {
        JSONObject jSONObjectFs = fs();
        int iOptInt = jSONObjectFs != null ? jSONObjectFs.optInt("cold_sec", 3000) : 3000;
        if (iOptInt < 0) {
            return 3000;
        }
        return iOptInt;
    }

    public static boolean x() {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - com.byazt.vyf.l.l;
        int iW = w();
        return iW > 0 && jElapsedRealtime < ((long) iW);
    }
}
