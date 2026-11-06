package com.byazt.lm;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.byazt.sd.a;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 572, 250})
public class k {
    public static void pr(Activity activity, final String[] strArr, final uc ucVar) {
        boolean z;
        com.byazt.qe.x xVarA;
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    if (!"android.permission.WRITE_EXTERNAL_STORAGE".equalsIgnoreCase(strArr[i])) {
                        i++;
                    } else {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (z && (xVarA = com.byazt.sd.zo.nt().a()) != null && ucVar != null && !xVarA.c()) {
                ucVar.pr("android.permission.WRITE_EXTERNAL_STORAGE");
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 23 && com.byazt.hb.pr.pr(activity) < 23) {
            if (ucVar != null) {
                ucVar.pr();
                return;
            }
            return;
        }
        if (strArr == null || strArr.length <= 0) {
            if (ucVar != null) {
                ucVar.pr();
                return;
            }
            return;
        }
        long jHashCode = activity.hashCode();
        for (String str : strArr) {
            jHashCode += (long) str.hashCode();
        }
        if (activity.getApplicationInfo().targetSdkVersion >= 33 && Build.VERSION.SDK_INT >= 33 && strArr.length == 1) {
            String str2 = strArr[0];
            if (TextUtils.equals(str2, "android.permission.READ_EXTERNAL_STORAGE") || TextUtils.equals(str2, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                if (ucVar != null) {
                    ucVar.pr(str2);
                }
                com.byazt.xk.hw.pr().pr(false, new String[]{str2});
                return;
            }
        }
        com.byazt.wt.uc.pr(String.valueOf(jHashCode), strArr, new com.byazt.wt.uc.pr() { // from class: com.byazt.lm.k.1
            @Override // com.byazt.wt.uc.pr
            public void pr() {
                uc ucVar2 = ucVar;
                if (ucVar2 != null) {
                    ucVar2.pr();
                }
                com.byazt.xk.hw.pr().pr(true, strArr);
            }

            @Override // com.byazt.wt.uc.pr
            public void pr(String str3) {
                uc ucVar2 = ucVar;
                if (ucVar2 != null) {
                    ucVar2.pr(str3);
                }
                com.byazt.xk.hw.pr().pr(false, new String[]{str3});
            }
        });
    }

    public static boolean pr(Context context, String str) {
        com.byazt.qam.fw fwVarYb;
        if ("android.permission.WRITE_EXTERNAL_STORAGE".equalsIgnoreCase(str) && (fwVarYb = com.byazt.sd.zo.nt().yb()) != null && !fwVarYb.c()) {
            return false;
        }
        if (context == null) {
            context = a.getContext();
        }
        return com.byazt.qam.c.pr().pr(context, str);
    }
}
