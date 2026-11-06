package com.byazt.iz;

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
import android.text.TextUtils;
import com.byazt.ho.BaseConstants;
import com.byazt.si.cy;
import com.byazt.si.m;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 861, 18})
public class l implements q {
    public s n;

    public l(s sVar) {
        this.n = sVar;
    }

    private String s(com.byazt.esa.n nVar) {
        ApplicationInfo applicationInfo;
        if (!this.n.n()) {
            return "enable_install_notification";
        }
        com.byazt.af.rv rvVarHd = com.byazt.vyf.s.cy().hd();
        if (rvVarHd != null && !rvVarHd.oa()) {
            return "isCanUseMessage";
        }
        if (nVar.w() == 0) {
            return "enable_notification=0";
        }
        Context context = com.byazt.nf.rv.getContext();
        if (context != null && (applicationInfo = context.getApplicationInfo()) != null && applicationInfo.targetSdkVersion >= 33 && Build.VERSION.SDK_INT >= 33 && !com.byazt.af.x.n().qg(com.byazt.nf.rv.getContext(), "android.permission.POST_NOTIFICATIONS")) {
            return "post_notifications_deny";
        }
        if (n(1440L, this.n.w(), 1000 * this.n.l())) {
            return null;
        }
        return "max_times_limit";
    }

    @Override // com.byazt.iz.q
    public boolean n(final com.byazt.esa.n nVar) {
        String strS = s(nVar);
        if (TextUtils.isEmpty(strS)) {
            com.byazt.tk.rv.n().postDelayed(new Runnable() { // from class: com.byazt.iz.l.1
                @Override // java.lang.Runnable
                public void run() {
                    l.this.n(nVar, "startUnInstallNotification");
                }
            }, this.n.q() * 1000);
            return true;
        }
        n("notification", nVar, "install", "othershow", strS, "failure");
        return false;
    }

    private String q(com.byazt.esa.n nVar) {
        ApplicationInfo applicationInfo;
        if (!this.n.qg()) {
            return "enable_action_notification=0";
        }
        if (nVar.w() == 0) {
            return "enable_notification=0";
        }
        Context context = com.byazt.nf.rv.getContext();
        if (context != null && (applicationInfo = context.getApplicationInfo()) != null && applicationInfo.targetSdkVersion >= 33 && Build.VERSION.SDK_INT >= 33 && !com.byazt.af.x.n().qg(com.byazt.nf.rv.getContext(), "android.permission.POST_NOTIFICATIONS")) {
            return "post_notifications_deny";
        }
        if (n(1440L, this.n.w(), 1000 * this.n.l())) {
            return null;
        }
        return "max_times_limit";
    }

    @Override // com.byazt.iz.q
    public boolean qg(com.byazt.esa.n nVar) {
        String strQ = q(nVar);
        if (TextUtils.isEmpty(strQ)) {
            n(nVar, "pushUnActiveFromMarketMessage");
            return true;
        }
        n("notification", nVar, "open", "othershow", strQ, "failure");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final com.byazt.esa.n nVar, final String str) {
        if (nVar == null) {
            return;
        }
        com.byazt.imu.s.n(nVar.qg()).n(Bitmap.Config.ARGB_4444).s(2).n(new m<Bitmap>() { // from class: com.byazt.iz.l.2
            @Override // com.byazt.si.m
            public void n(int i, String str2, Throwable th) {
            }

            @Override // com.byazt.si.m
            public void n(cy<Bitmap> cyVar) {
                if (cyVar != null) {
                    Bitmap bitmapS = cyVar.s();
                    final Bitmap bitmapN = l.n(bitmapS, 10.0f);
                    if (bitmapS != null) {
                        final boolean zQg = com.byazt.vgx.w.qg(nVar.s());
                        l.n("notification", nVar, zQg ? "open" : "install", "othershow", str + "_" + nVar.s(), "success");
                        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.iz.l.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.byazt.esa.s.n(nVar, "com.csj.install", zQg ? 1 : 2, bitmapN);
                            }
                        });
                    }
                }
            }
        }, 4);
    }

    public static void n(String str, final com.byazt.esa.n nVar, final String str2, String str3, final String str4, final String str5) {
        com.byazt.hm.n.n(str, str3, nVar.fs(), nVar.l(), new com.byazt.rs.n() { // from class: com.byazt.iz.l.3
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("type", str2);
                jSONObject2.put("installer_package_name", nVar.s());
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject2.put("error_message", str4);
                }
                if (!TextUtils.isEmpty(str5)) {
                    jSONObject2.put("status", str5);
                }
                if (jSONObject != null) {
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
                }
                return jSONObject2;
            }
        });
    }

    public static Bitmap n(Bitmap bitmap, float f) {
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

    public boolean n(long j, int i, long j2) {
        try {
            Long lValueOf = -1L;
            try {
                lValueOf = Long.valueOf(j * 60 * 1000);
            } catch (Exception e) {
                Object[] objArr = new Object[2];
                e.getMessage();
                i = -1;
            }
            if (lValueOf.longValue() >= 0 && i >= 0 && lValueOf.longValue() != 0 && i != 0) {
                String strN = n();
                StringBuilder sb = new StringBuilder();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (TextUtils.isEmpty(strN)) {
                    sb.append(jCurrentTimeMillis);
                    n(sb.toString());
                    return true;
                }
                String[] strArrSplit = strN.split("_");
                int length = strArrSplit.length;
                if (length < i) {
                    if (jCurrentTimeMillis - Long.parseLong(strArrSplit[length - 1]) <= j2) {
                        return false;
                    }
                    for (String str : strArrSplit) {
                        sb.append(str).append("_");
                    }
                    sb.append(jCurrentTimeMillis);
                    n(sb.toString());
                    return true;
                }
                int i2 = length - i;
                if (jCurrentTimeMillis - Long.valueOf(Long.parseLong(strArrSplit[length + (-1)])).longValue() > j2 && jCurrentTimeMillis - Long.valueOf(Long.parseLong(strArrSplit[i2])).longValue() > lValueOf.longValue()) {
                    for (int i3 = i2; i3 < length; i3++) {
                        String str2 = strArrSplit[i3];
                        if (i3 != i2 && !TextUtils.isEmpty(str2)) {
                            sb.append(str2).append("_");
                        }
                    }
                    sb.append(jCurrentTimeMillis);
                    n(sb.toString());
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            e2.getMessage();
            return false;
        }
    }

    public static String n() {
        return com.byazt.ikv.n.n().qg("notification_a", "");
    }

    public static void n(String str) {
        com.byazt.ikv.n.n().n("notification_a", str);
    }
}
