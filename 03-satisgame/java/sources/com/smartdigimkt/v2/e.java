package com.smartdigimkt.v2;

import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.r4.y;
import com.smartdigimkt.sdk.core.SDKContext;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends d {
    public e(Context context, String str, String str2, long j) {
        super(context, str, str2, j);
    }

    @Override // com.smartdigimkt.v2.d
    public final b a() {
        String strC;
        boolean z;
        if (System.currentTimeMillis() - this.d > p.c().r) {
            Context contextD = this.b;
            String str = this.a;
            String str2 = com.smartdigimkt.r4.h.a;
            if (contextD == null) {
                contextD = SDKContext.getInstance().d();
            }
            strC = "";
            if (contextD != null) {
                try {
                    strC = contextD.getPackageManager().getPackageInfo(str, 0).versionCode + "";
                } catch (Throwable unused) {
                }
            }
            y.a(this.b, "sdm_adx_rp_sdk", "det" + this.c, strC);
            y.a(this.b, "sdm_adx_rp_sdk", "det_time_" + this.c, System.currentTimeMillis());
            z = true;
        } else {
            strC = y.c(this.b, "sdm_adx_rp_sdk", "det" + this.c);
            z = false;
        }
        String str3 = strC;
        return new b(this.a, this.c, z, z ? System.currentTimeMillis() : this.d, !TextUtils.isEmpty(str3), str3);
    }

    @Override // com.smartdigimkt.v2.d
    public final int b() {
        return 1;
    }
}
