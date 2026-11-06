package com.bytedance.sdk.component.x.xr.ms.ms.ms;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.sdk.component.x.ms.c;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements c {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final xr f1567ms = new xr();
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
            synchronized (this) {
                if (this.xr == null) {
                    this.xr = new ms(context, this).getWritableDatabase();
                }
            }
        }
        return this.xr;
    }
}
