package com.smartdigimkt.v2;

import android.content.ContentValues;
import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends d {
    public final boolean e;
    public final boolean f;
    public boolean g;

    public c(Context context, String str, String str2, long j, boolean z, boolean z2) {
        super(context, str, str2, j);
        this.e = z;
        this.f = z2;
    }

    @Override // com.smartdigimkt.v2.d
    public final b a() {
        boolean z;
        boolean z2;
        boolean z3 = this.e;
        if (System.currentTimeMillis() - this.d > p.c().r) {
            this.g = true;
            boolean zB = com.smartdigimkt.r4.k.b(this.b, this.a);
            if (!this.f) {
                com.smartdigimkt.z2.k kVarA = com.smartdigimkt.z2.k.a(com.smartdigimkt.z2.d.a(this.b));
                String str = this.c;
                String str2 = this.a;
                synchronized (kVarA) {
                    if (kVarA.b() != null) {
                        try {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("inspect_id", str);
                            contentValues.put("inspect_name", com.smartdigimkt.r4.e.b(str2));
                            contentValues.put("inspect_result", Integer.valueOf(zB ? 1 : 2));
                            contentValues.put(com.anythink.core.common.f.k.a.g, Long.valueOf(System.currentTimeMillis()));
                            if (kVarA.a(str)) {
                                kVarA.b().update("inspect_info", contentValues, "inspect_id = ? ", new String[]{str});
                            } else {
                                kVarA.b().insert("inspect_info", null, contentValues);
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            }
            z2 = true;
            z = zB;
        } else {
            z = z3;
            z2 = false;
        }
        return new b(this.a, this.c, z2, z2 ? System.currentTimeMillis() : this.d, z, null);
    }

    @Override // com.smartdigimkt.v2.d
    public final int b() {
        return 2;
    }
}
