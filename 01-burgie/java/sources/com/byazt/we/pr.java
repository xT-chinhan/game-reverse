package com.byazt.we;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.byazt.rk.fw;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderInteractionViews;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUTO_REOPEN, 37})
public class pr {
    public static int pr(fw fwVar) {
        if (fwVar == null) {
            return 0;
        }
        String strLs = fwVar.ls();
        String strRc = fwVar.rc();
        if (TextUtils.isEmpty(strRc) || TextUtils.isEmpty(strLs) || !strRc.equals(ProviderInteractionViews.ROLE_CREATIVE)) {
            return 0;
        }
        if (strLs.equals("shake")) {
            return 2;
        }
        if (strLs.equals("twist")) {
            return 3;
        }
        if (!strLs.equals("slide")) {
            return 0;
        }
        return 1;
    }

    public static boolean pr(View view) {
        if (view == null) {
            return false;
        }
        try {
            Object tag = view.getTag(2097610708);
            if (tag == null || ((Integer) tag).intValue() != 1) {
                return false;
            }
            return true;
        } catch (Exception e) {
        }
    }

    public static boolean hw(View view) {
        if (view == null) {
            return false;
        }
        try {
            Pair pair = (Pair) view.getTag(2097610707);
            if (pair == null) {
                return false;
            }
            return (TextUtils.isEmpty((CharSequence) pair.first) || TextUtils.equals("0", (CharSequence) pair.first)) && ((((Long) pair.second).longValue() > 0L ? 1 : (((Long) pair.second).longValue() == 0L ? 0 : -1)) <= 0);
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    public static boolean pr(View view, float f, float f2, float f3, float f4) {
        if (view == null) {
            return false;
        }
        try {
            Pair pair = (Pair) view.getTag(2097610707);
            if (pair != null && !TextUtils.isEmpty((CharSequence) pair.first) && ((Long) pair.second).longValue() > 0) {
                String str = (String) pair.first;
                long jLongValue = ((Long) pair.second).longValue();
                if (str.equals("0")) {
                    return ((float) Math.sqrt(Math.pow((double) (f - f3), 2.0d) + Math.pow((double) (f2 - f4), 2.0d))) >= ((float) jLongValue);
                }
                if (str.equals("1")) {
                    float f5 = f2 - f4;
                    return f5 < 0.0f && Math.abs(f5) >= ((float) jLongValue);
                }
                if (str.equals("2")) {
                    float f6 = f - f3;
                    return f6 > 0.0f && Math.abs(f6) >= ((float) jLongValue);
                }
                if (str.equals(GlobalSetting.SPLASH_AD)) {
                    float f7 = f - f3;
                    return f7 < 0.0f && Math.abs(f7) >= ((float) jLongValue);
                }
                if (str.equals(GlobalSetting.NATIVE_EXPRESS_AD)) {
                    float f8 = f2 - f4;
                    return f8 > 0.0f && Math.abs(f8) >= ((float) jLongValue);
                }
                return false;
            }
            return false;
        } catch (Exception e) {
        }
    }
}
