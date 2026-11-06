package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
final class cj implements pl {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ce<Boolean> f483ms = new ce<Boolean>() { // from class: com.bytedance.embedapplog.cj.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.embedapplog.ce
        /* JADX INFO: renamed from: ah, reason: merged with bridge method [inline-methods] */
        public Boolean ms(Object... objArr) {
            try {
                PackageManager packageManager = ((Context) objArr[0]).getPackageManager();
                if (packageManager != null) {
                    return Boolean.valueOf(packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null);
                }
            } catch (Exception unused) {
            }
            return Boolean.FALSE;
        }
    };

    cj() {
    }

    @Override // com.bytedance.embedapplog.pl
    public boolean ms(Context context) {
        if (context == null) {
            return false;
        }
        return this.f483ms.xr(context).booleanValue();
    }

    @Override // com.bytedance.embedapplog.pl
    public pl.ms xr(Context context) {
        Cursor cursorQuery;
        try {
            cursorQuery = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            if (cursorQuery != null) {
                try {
                    pl.ms msVar = new pl.ms();
                    msVar.xr = ms(cursorQuery);
                    zd.ms(cursorQuery);
                    return msVar;
                } catch (Throwable th) {
                    th = th;
                    try {
                        oh.ms(th);
                        return null;
                    } finally {
                        zd.ms(cursorQuery);
                    }
                }
            }
            zd.ms(cursorQuery);
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    private String ms(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(com.anythink.core.common.e.f.a.d);
        if (columnIndex >= 0) {
            return cursor.getString(columnIndex);
        }
        return null;
    }
}
