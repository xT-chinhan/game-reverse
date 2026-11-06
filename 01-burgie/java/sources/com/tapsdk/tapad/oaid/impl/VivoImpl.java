package com.tapsdk.tapad.oaid.impl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.tapsdk.tapad.group.constants.Constants;
import com.tapsdk.tapad.oaid.IGetter;
import com.tapsdk.tapad.oaid.IOAID;
import com.tapsdk.tapad.oaid.OAIDException;
import com.tapsdk.tapad.oaid.OAIDRom;

/* JADX INFO: loaded from: classes3.dex */
class VivoImpl implements IOAID {
    private final Context context;

    public VivoImpl(Context context) {
        this.context = context;
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public void doGet(IGetter iGetter) {
        try {
            Cursor cursorQuery = this.context.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        int columnIndex = cursorQuery.getColumnIndex(Constants.VALUE_FIELD);
                        if (columnIndex < 0) {
                            throw new OAIDException("OAID query missing value column");
                        }
                        String string = cursorQuery.getString(columnIndex);
                        if (string == null || string.isEmpty()) {
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
        } catch (Exception e) {
            iGetter.onOAIDGetError(e);
        }
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public String getName() {
        return "Vivo";
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public void supported() {
        if (Build.VERSION.SDK_INT < 28) {
            throw new OAIDException("Only supports above Android 9.0");
        }
        if (!OAIDRom.sysProperty("persist.sys.identifierid.supported", "0").equals("1") && !OAIDRom.sysProperty("persist.sys.identifierid", "0").equals("1")) {
            throw new OAIDException("persist.sys.identifierid.supported sysProperty is not found or invalid");
        }
    }
}
