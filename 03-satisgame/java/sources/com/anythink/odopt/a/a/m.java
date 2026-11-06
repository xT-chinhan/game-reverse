package com.anythink.odopt.a.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class m {
    private Context a;

    public m(Context context) {
        this.a = context;
    }

    public final void a(com.anythink.odopt.a.a aVar) {
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
            aVar.a(string, false);
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
            aVar.a(message);
        }
    }
}
