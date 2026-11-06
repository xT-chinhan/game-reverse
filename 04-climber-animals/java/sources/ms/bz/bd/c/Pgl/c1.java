package ms.bz.bd.c.Pgl;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes4.dex */
public final class c1 implements IInterface {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public IBinder f4831ms;

    public c1(IBinder iBinder) {
        this.f4831ms = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f4831ms;
    }
}
