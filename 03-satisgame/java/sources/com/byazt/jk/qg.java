package com.byazt.jk;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import com.byazt.ky.py;
import com.byazt.ky.rv;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1563, 26})
public class qg implements rv {
    public py n;

    @Override // com.byazt.ky.rv
    public void n(Activity activity, String[] strArr, py pyVar) {
        this.n = pyVar;
        activity.requestPermissions(strArr, 1);
    }

    @Override // com.byazt.ky.rv
    public boolean n(Context context, String str) {
        return (context == null || str == null || context.checkPermission(str, Process.myPid(), Process.myUid()) != 0) ? false : true;
    }

    @Override // com.byazt.ky.rv
    public void n(Activity activity, int i, String[] strArr, int[] iArr) {
        py pyVar;
        if (iArr.length <= 0 || (pyVar = this.n) == null) {
            return;
        }
        int i2 = iArr[0];
        if (i2 == -1) {
            pyVar.n(strArr[0]);
        } else if (i2 == 0) {
            pyVar.n();
        }
    }
}
