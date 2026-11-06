package com.smartdigimkt.r;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class w {
    public final Context a;

    public w(Context context) {
        this.a = context;
    }

    public final void a(com.smartdigimkt.q.b bVar) {
        String message;
        String string = null;
        try {
            Cursor cursorQuery = this.a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.moveToFirst();
                int columnIndex = cursorQuery.getColumnIndex(com.anythink.core.common.f.e.a.d);
                if (columnIndex > 0) {
                    string = cursorQuery.getString(columnIndex);
                }
            }
            bVar.a(string, false);
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Exception unused) {
                }
            }
            message = "Empty";
        } catch (Throwable th) {
            message = th.getMessage();
        }
        if (TextUtils.isEmpty(string)) {
            bVar.a(message);
        }
    }
}
