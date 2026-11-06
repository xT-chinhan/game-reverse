package com.tapsdk.tapad.f.i;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
class i implements com.tapsdk.tapad.f.b {
    private final Context a;

    public i(Context context) {
        this.a = context;
    }

    @Override // com.tapsdk.tapad.f.b
    public void a() {
        try {
            if (this.a.getPackageManager().resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null) {
            } else {
                throw new com.tapsdk.tapad.f.c("com.meizu.flyme.openidsdk provider not provided");
            }
        } catch (Throwable th) {
            throw new com.tapsdk.tapad.f.c(th);
        }
    }

    @Override // com.tapsdk.tapad.f.b
    public void a(com.tapsdk.tapad.f.a aVar) {
        try {
            Cursor cursorQuery = this.a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            try {
                ((Cursor) Objects.requireNonNull(cursorQuery)).moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex(com.anythink.core.common.e.f.a.d));
                if (string == null || string.length() == 0) {
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
        } catch (Throwable th4) {
            aVar.a(new com.tapsdk.tapad.f.c(th4));
        }
    }

    @Override // com.tapsdk.tapad.f.b
    public String l() {
        return "Meizu";
    }
}
