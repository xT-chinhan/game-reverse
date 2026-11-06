package com.ss.android.download.api.ms;

import android.app.Activity;
import android.content.Context;
import androidx.core.content.ContextCompat;
import com.ss.android.download.api.config.ny;
import com.ss.android.download.api.config.t;

/* JADX INFO: loaded from: classes3.dex */
public class xr implements ny {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private t f4334ms;

    @Override // com.ss.android.download.api.config.ny
    public void ms(Activity activity, String[] strArr, t tVar) {
        this.f4334ms = tVar;
        activity.requestPermissions(strArr, 1);
    }

    @Override // com.ss.android.download.api.config.ny
    public boolean ms(Context context, String str) {
        return context != null && ContextCompat.checkSelfPermission(context, str) == 0;
    }

    @Override // com.ss.android.download.api.config.ny
    public void ms(Activity activity, int i, String[] strArr, int[] iArr) {
        t tVar;
        if (iArr.length <= 0 || (tVar = this.f4334ms) == null) {
            return;
        }
        int i2 = iArr[0];
        if (i2 == -1) {
            tVar.ms(strArr[0]);
        } else if (i2 == 0) {
            tVar.ms();
        }
    }
}
