package com.byazt.yyh;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.byazt.zv.aj;
import com.byazt.zv.cz;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1562, 13})
public class hw implements aj {
    public cz pr;

    @Override // com.byazt.zv.aj
    public void pr(Activity activity, String[] strArr, cz czVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.pr = czVar;
            activity.requestPermissions(strArr, 1);
        } else if (czVar != null) {
            czVar.pr();
        }
    }

    @Override // com.byazt.zv.aj
    public boolean pr(Context context, String str) {
        return (context == null || str == null || context.checkPermission(str, Process.myPid(), Process.myUid()) != 0) ? false : true;
    }

    @Override // com.byazt.zv.aj
    public void pr(Activity activity, int i, String[] strArr, int[] iArr) {
        cz czVar;
        if (iArr.length > 0 && (czVar = this.pr) != null) {
            int i2 = iArr[0];
            if (i2 == -1) {
                czVar.pr(strArr[0]);
            } else if (i2 == 0) {
                czVar.pr();
            }
        }
    }
}
