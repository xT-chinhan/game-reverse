package com.smartdigimkt.s;

import android.os.IBinder;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements e {
    public final IBinder a;

    public c(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }
}
