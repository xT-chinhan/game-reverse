package com.byazt.jx;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.byazt.fi.BaseConstants;
import com.byazt.ld.nt;
import com.byazt.ld.rc;
import com.byazt.sd.a;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_NO_AV_SYNC, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c implements x {
    public hn pr;

    public c(hn hnVar) {
        this.pr = hnVar;
    }

    private String hn(com.byazt.vo.pr prVar) {
        ApplicationInfo applicationInfo;
        if (!this.pr.pr()) {
            return "enable_install_notification";
        }
        com.byazt.qam.fw fwVarYb = com.byazt.sd.zo.nt().yb();
        if (fwVarYb != null && !fwVarYb.zo()) {
            return "isCanUseMessage";
        }
        if (prVar.uc() == 0) {
            return "enable_notification=0";
        }
        Context context = a.getContext();
        if (context != null && (applicationInfo = context.getApplicationInfo()) != null && applicationInfo.targetSdkVersion >= 33 && Build.VERSION.SDK_INT >= 33 && !com.byazt.qam.c.pr().hw(a.getContext(), "android.permission.POST_NOTIFICATIONS")) {
            return "post_notifications_deny";
        }
        if (!pr(1440L, this.pr.uc(), 1000 * this.pr.c())) {
            return "max_times_limit";
        }
        return null;
    }

    @Override // com.byazt.jx.x
    public boolean pr(final com.byazt.vo.pr prVar) {
        String strHn = hn(prVar);
        if (TextUtils.isEmpty(strHn)) {
            com.byazt.ca.aj.pr().postDelayed(new Runnable() { // from class: com.byazt.jx.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.pr(prVar, "startUnInstallNotification");
                }
            }, this.pr.x() * 1000);
            return true;
        }
        pr("notification", prVar, "install", "othershow", strHn, "failure");
        return false;
    }

    private String x(com.byazt.vo.pr prVar) {
        ApplicationInfo applicationInfo;
        if (!this.pr.hw()) {
            return "enable_action_notification=0";
        }
        if (prVar.uc() == 0) {
            return "enable_notification=0";
        }
        Context context = a.getContext();
        if (context != null && (applicationInfo = context.getApplicationInfo()) != null && applicationInfo.targetSdkVersion >= 33 && Build.VERSION.SDK_INT >= 33 && !com.byazt.qam.c.pr().hw(a.getContext(), "android.permission.POST_NOTIFICATIONS")) {
            return "post_notifications_deny";
        }
        if (!pr(1440L, this.pr.uc(), 1000 * this.pr.c())) {
            return "max_times_limit";
        }
        return null;
    }

    @Override // com.byazt.jx.x
    public boolean hw(com.byazt.vo.pr prVar) {
        String strX = x(prVar);
        if (TextUtils.isEmpty(strX)) {
            pr(prVar, "pushUnActiveFromMarketMessage");
            return true;
        }
        pr("notification", prVar, "open", "othershow", strX, "failure");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(final com.byazt.vo.pr prVar, final String str) {
        if (prVar == null) {
            return;
        }
        com.byazt.ub.hw.pr(prVar.hw()).pr(Bitmap.Config.ARGB_4444).hn(2).pr(new rc<Bitmap>() { // from class: com.byazt.jx.c.2
            @Override // com.byazt.ld.rc
            public void pr(nt<Bitmap> ntVar) {
                if (ntVar != null) {
                    Bitmap bitmapHn = ntVar.hn();
                    final Bitmap bitmapPr = c.pr(bitmapHn, 10.0f);
                    if (bitmapHn != null) {
                        final boolean zHw = ls.hw(prVar.hn());
                        c.pr("notification", prVar, zHw ? "open" : "install", "othershow", str + "_" + prVar.hn(), TrackAction.SUCCESS);
                        com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.jx.c.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.byazt.vo.hn.pr(prVar, "com.csj.install", zHw ? 1 : 2, bitmapPr);
                            }
                        });
                    }
                }
            }

            @Override // com.byazt.ld.rc
            public void pr(int i, String str2, Throwable th) {
            }
        }, 4);
    }

    public static void pr(String str, final com.byazt.vo.pr prVar, final String str2, String str3, final String str4, final String str5) {
        com.byazt.pj.pr.pr(str, str3, prVar.zo(), prVar.c(), new com.byazt.ttf.pr() { // from class: com.byazt.jx.c.3
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("type", str2);
                jSONObject2.put("installer_package_name", prVar.hn());
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject2.put("error_message", str4);
                }
                if (!TextUtils.isEmpty(str5)) {
                    jSONObject2.put(NotificationCompat.CATEGORY_STATUS, str5);
                }
                if (jSONObject != null) {
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
                }
                return jSONObject2;
            }
        });
    }

    public static Bitmap pr(Bitmap bitmap, float f) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return bitmapCreateBitmap;
    }

    public boolean pr(long j, int i, long j2) {
        try {
            Long lValueOf = -1L;
            try {
                lValueOf = Long.valueOf(j * 60 * 1000);
            } catch (Exception e) {
                Object[] objArr = {"error", e.getMessage()};
                i = -1;
            }
            if (lValueOf.longValue() >= 0 && i >= 0 && lValueOf.longValue() != 0 && i != 0) {
                String strPr = pr();
                StringBuilder sb = new StringBuilder();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (TextUtils.isEmpty(strPr)) {
                    sb.append(jCurrentTimeMillis);
                    pr(sb.toString());
                    return true;
                }
                String[] strArrSplit = strPr.split("_");
                int length = strArrSplit.length;
                if (length < i) {
                    if (jCurrentTimeMillis - Long.parseLong(strArrSplit[length - 1]) <= j2) {
                        return false;
                    }
                    for (String str : strArrSplit) {
                        sb.append(str).append("_");
                    }
                    sb.append(jCurrentTimeMillis);
                    pr(sb.toString());
                    return true;
                }
                int i2 = length - i;
                if (!(jCurrentTimeMillis - Long.valueOf(Long.parseLong(strArrSplit[length + (-1)])).longValue() > j2 && jCurrentTimeMillis - Long.valueOf(Long.parseLong(strArrSplit[i2])).longValue() > lValueOf.longValue())) {
                    return false;
                }
                for (int i3 = i2; i3 < length; i3++) {
                    String str2 = strArrSplit[i3];
                    if (i3 != i2 && !TextUtils.isEmpty(str2)) {
                        sb.append(str2).append("_");
                    }
                }
                sb.append(jCurrentTimeMillis);
                pr(sb.toString());
                return true;
            }
            return false;
        } catch (Exception e2) {
            e2.getMessage();
            return false;
        }
    }

    public static String pr() {
        return com.byazt.sd.hw.pr().hw("notification_a", "");
    }

    public static void pr(String str) {
        com.byazt.sd.hw.pr().pr("notification_a", str);
    }
}
