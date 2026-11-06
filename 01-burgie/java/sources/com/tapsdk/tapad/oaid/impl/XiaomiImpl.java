package com.tapsdk.tapad.oaid.impl;

import android.content.Context;
import android.text.TextUtils;
import com.tapsdk.tapad.oaid.IGetter;
import com.tapsdk.tapad.oaid.IOAID;
import com.tapsdk.tapad.oaid.OAIDException;

/* JADX INFO: loaded from: classes3.dex */
class XiaomiImpl implements IOAID {
    private final Context context;
    private Class<?> idProviderClass;
    private Object idProviderImpl;

    public XiaomiImpl(Context context) {
        this.context = context;
    }

    private String getOAID() {
        String str = (String) this.idProviderClass.getMethod("getOAID", Context.class).invoke(this.idProviderImpl, this.context);
        return TextUtils.isEmpty(str) ? (String) this.idProviderClass.getMethod("getAAID", Context.class).invoke(this.idProviderImpl, this.context) : str;
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.idProviderClass == null || this.idProviderImpl == null) {
            iGetter.onOAIDGetError(new OAIDException("Xiaomi IdProvider not exists"));
            return;
        }
        try {
            String oaid = getOAID();
            if (oaid == null || oaid.length() == 0) {
                throw new OAIDException("OAID query failed");
            }
            iGetter.onOAIDGetComplete(oaid);
        } catch (Exception e) {
            iGetter.onOAIDGetError(e);
        }
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public String getName() {
        return "Xiaomi";
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public void supported() {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.idProviderClass = cls;
            this.idProviderImpl = cls.newInstance();
        } catch (Throwable th) {
            throw new OAIDException(th);
        }
    }
}
