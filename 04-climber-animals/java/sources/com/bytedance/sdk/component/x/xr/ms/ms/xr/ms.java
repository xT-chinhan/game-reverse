package com.bytedance.sdk.component.x.xr.ms.ms.xr;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends ab {
    @Override // com.bytedance.sdk.component.x.xr.ms.ms.xr.ab
    public byte ah() {
        return (byte) 3;
    }

    @Override // com.bytedance.sdk.component.x.xr.ms.ms.xr.ab
    public byte xr() {
        return (byte) 1;
    }

    public ms(Context context, com.bytedance.sdk.component.x.xr.d.xr.ms msVar, com.bytedance.sdk.component.x.ms.ka kaVar) {
        super(context, msVar, kaVar);
    }

    @Override // com.bytedance.sdk.component.x.xr.ms.ms.xr.ab, com.bytedance.sdk.component.x.xr.ms.ms.xr.xr
    public String ms() {
        return this.xr.xr().ka();
    }

    @Override // com.bytedance.sdk.component.x.xr.ms.ms.xr.ab, com.bytedance.sdk.component.x.xr.ms.ms
    public boolean ms(com.bytedance.sdk.component.x.ms.xr xrVar) {
        return com.bytedance.sdk.component.x.xr.ah.ms.ka(xrVar);
    }

    public static String xr(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }

    public static String ah(String str) {
        return "ALTER TABLE " + str + " ADD COLUMN encrypt INTEGER default 0";
    }
}
