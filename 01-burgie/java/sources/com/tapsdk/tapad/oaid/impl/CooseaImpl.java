package com.tapsdk.tapad.oaid.impl;

import android.app.KeyguardManager;
import android.content.Context;
import com.tapsdk.tapad.oaid.IGetter;
import com.tapsdk.tapad.oaid.IOAID;
import com.tapsdk.tapad.oaid.OAIDException;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
class CooseaImpl implements IOAID {
    private final Context context;
    private KeyguardManager keyguardManager;

    public CooseaImpl(Context context) {
        this.context = context;
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public void doGet(IGetter iGetter) {
        KeyguardManager keyguardManager = this.keyguardManager;
        if (keyguardManager == null) {
            iGetter.onOAIDGetError(new OAIDException("KeyguardManager not found"));
            return;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", null).invoke(this.keyguardManager, null);
            if (objInvoke == null) {
                throw new OAIDException("OAID obtain failed");
            }
            iGetter.onOAIDGetComplete(objInvoke.toString());
        } catch (Throwable th) {
            iGetter.onOAIDGetError(new OAIDException(th));
        }
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public String getName() {
        return "Coosea";
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public void supported() {
        try {
            KeyguardManager keyguardManager = (KeyguardManager) this.context.getSystemService("keyguard");
            this.keyguardManager = keyguardManager;
            if (((Boolean) Objects.requireNonNull(keyguardManager.getClass().getDeclaredMethod("isSupported", null).invoke(this.keyguardManager, null))).booleanValue()) {
            } else {
                throw new OAIDException("keyguard service is not supported");
            }
        } catch (Throwable th) {
            throw new OAIDException(th);
        }
    }
}
