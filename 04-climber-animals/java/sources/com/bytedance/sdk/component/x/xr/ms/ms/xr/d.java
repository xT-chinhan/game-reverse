package com.bytedance.sdk.component.x.xr.ms.ms.xr;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class d extends c {
    @Override // com.bytedance.sdk.component.x.xr.ms.ms.xr.c
    public byte ah() {
        return (byte) 0;
    }

    @Override // com.bytedance.sdk.component.x.xr.ms.ms.xr.c
    public byte xr() {
        return (byte) 1;
    }

    public d(Context context, com.bytedance.sdk.component.x.xr.d.xr.ms msVar, com.bytedance.sdk.component.x.ms.ka kaVar) {
        super(context, msVar, kaVar);
    }

    @Override // com.bytedance.sdk.component.x.xr.ms.ms.xr.c, com.bytedance.sdk.component.x.xr.ms.ms.xr.xr
    public String ms() {
        com.bytedance.sdk.component.x.ms.c cVarXr = this.xr.xr();
        if (cVarXr != null) {
            return cVarXr.ms();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.x.xr.ms.ms.xr.c, com.bytedance.sdk.component.x.xr.ms.ms
    public boolean ms(com.bytedance.sdk.component.x.ms.xr xrVar) {
        return com.bytedance.sdk.component.x.xr.ah.ms.ms(xrVar);
    }

    public static String xr(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }

    public static String ah(String str) {
        return "ALTER TABLE " + str + " ADD COLUMN encrypt INTEGER default 0";
    }
}
