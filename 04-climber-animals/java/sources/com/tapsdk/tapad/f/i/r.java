package com.tapsdk.tapad.f.i;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
class r implements com.tapsdk.tapad.f.b {
    private final Context a;

    public r(Context context) {
        this.a = context;
    }

    @Override // com.tapsdk.tapad.f.b
    public void a() {
        if (Build.VERSION.SDK_INT < 28) {
            throw new com.tapsdk.tapad.f.c("Only supports above Android 9.0");
        }
        if (!com.tapsdk.tapad.f.e.a("persist.sys.identifierid.supported", "0").equals("1")) {
            throw new com.tapsdk.tapad.f.c("persist.sys.identifierid.supported sysProperty is not found or invalid");
        }
    }

    @Override // com.tapsdk.tapad.f.b
    public void a(com.tapsdk.tapad.f.a aVar) {
        try {
            Cursor cursorQuery = this.a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            try {
                ((Cursor) Objects.requireNonNull(cursorQuery)).moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex(com.anythink.core.common.e.f.a.d));
                if (string == null || string.isEmpty()) {
                    throw new com.tapsdk.tapad.f.c("OAID query failed");
                }
                aVar.a(string);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (Exception e) {
            aVar.a(e);
        }
    }

    @Override // com.tapsdk.tapad.f.b
    public String l() {
        return "Vivo";
    }
}
