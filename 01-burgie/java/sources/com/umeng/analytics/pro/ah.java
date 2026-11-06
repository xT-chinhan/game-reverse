package com.umeng.analytics.pro;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: compiled from: NubiaDeviceIdSupplier.java */
/* JADX INFO: loaded from: classes3.dex */
class ah implements aa {
    private static final String a = "content://cn.nubia.provider.deviceid.dataid/oaid";

    ah() {
    }

    @Override // com.umeng.analytics.pro.aa
    public String a(Context context) {
        String string = null;
        if (context == null) {
            return null;
        }
        Cursor cursorQuery = context.getContentResolver().query(Uri.parse(a), null, null, null, null);
        if (cursorQuery != null) {
            if (cursorQuery.moveToNext()) {
                string = cursorQuery.getString(cursorQuery.getColumnIndex("device_ids_grndid"));
            }
            cursorQuery.close();
        }
        return string;
    }
}
