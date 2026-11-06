package com.bytedance.sdk.openadsdk.core.t;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.sdk.openadsdk.core.re;

/* JADX INFO: loaded from: classes2.dex */
public class x implements com.bytedance.sdk.component.x.ms.c {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final x f3362ms = new x();
    private volatile SQLiteDatabase xr;

    @Override // com.bytedance.sdk.component.x.ms.c
    public String ah() {
        return null;
    }

    @Override // com.bytedance.sdk.component.x.ms.c
    public String c() {
        return null;
    }

    @Override // com.bytedance.sdk.component.x.ms.c
    public String d() {
        return "logstats";
    }

    @Override // com.bytedance.sdk.component.x.ms.c
    public String ka() {
        return "logstatsbatch";
    }

    @Override // com.bytedance.sdk.component.x.ms.c
    public String ms() {
        return "loghighpriority";
    }

    @Override // com.bytedance.sdk.component.x.ms.c
    public String xr() {
        return "adevent";
    }

    @Override // com.bytedance.sdk.component.x.ms.c
    public SQLiteDatabase ms(Context context) {
        if (this.xr == null) {
            synchronized (x.class) {
                if (this.xr == null) {
                    com.bytedance.sdk.openadsdk.core.x.ah ahVarMs = com.bytedance.sdk.openadsdk.core.ab.ms(re.getContext()).ms();
                    ahVarMs.ms();
                    this.xr = ahVarMs.xr();
                }
            }
        }
        return this.xr;
    }
}
