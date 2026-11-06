package ms.bz.bd.c.Pgl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.umeng.analytics.pro.ek;

/* JADX INFO: loaded from: classes4.dex */
public final class pblb implements IInterface {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final IBinder f4844ms;

    public pblb(IBinder iBinder) {
        this.f4844ms = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f4844ms;
    }

    public final String ms() {
        String string;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "969450", new byte[]{43, 59, 71, ek.l, 11, 52, 47, 4, 38, 105, 59, 53, 4, 115, 31, 55, 42, 27, 109, 105, 45, 58, 94, 65, 24, 62, 30, 62, 76, 42, 1, ek.n, 67, 68, 43, 46, 62, 27, 65, 106, 60, 49, 88, 70, 11, 36, com.anythink.core.common.s.a.c.c}));
            try {
                this.f4844ms.transact(3, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                string = parcelObtain2.readString();
            } catch (Throwable unused) {
                parcelObtain.recycle();
                parcelObtain2.recycle();
                string = null;
            }
        } catch (Throwable unused2) {
        }
        parcelObtain.recycle();
        parcelObtain2.recycle();
        return string;
    }
}
