package com.tapsdk.tapad.oaid.impl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tapsdk.tapad.group.constants.Constants;
import com.tapsdk.tapad.oaid.IGetter;
import com.tapsdk.tapad.oaid.IOAID;
import com.tapsdk.tapad.oaid.OAIDException;

/* JADX INFO: loaded from: classes3.dex */
class MeizuImpl implements IOAID {
    private final Context context;

    public MeizuImpl(Context context) {
        this.context = context;
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public void doGet(IGetter iGetter) {
        try {
            Cursor cursorQuery = this.context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        int columnIndex = cursorQuery.getColumnIndex(Constants.VALUE_FIELD);
                        if (columnIndex < 0) {
                            throw new OAIDException("OAID query missing value column");
                        }
                        String string = cursorQuery.getString(columnIndex);
                        if (string == null || string.length() == 0) {
                            throw new OAIDException("OAID query failed");
                        }
                        iGetter.onOAIDGetComplete(string);
                        cursorQuery.close();
                        return;
                    }
                } catch (Throwable th) {
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            throw new OAIDException("OAID query returned no rows");
        } catch (Throwable th3) {
            iGetter.onOAIDGetError(new OAIDException(th3));
        }
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public String getName() {
        return "Meizu";
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public void supported() {
        try {
            if (this.context.getPackageManager().resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null) {
            } else {
                throw new OAIDException("com.meizu.flyme.openidsdk provider not provided");
            }
        } catch (Throwable th) {
            throw new OAIDException(th);
        }
    }
}
