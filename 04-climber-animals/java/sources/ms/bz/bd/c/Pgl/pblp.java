package ms.bz.bd.c.Pgl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.bytedance.sdk.component.utils.sl;

/* JADX INFO: loaded from: classes4.dex */
public final class pblp implements IInterface {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final IBinder f4856ms;

    public pblp(IBinder iBinder) {
        this.f4856ms = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f4856ms;
    }

    public final String ms() {
        String string;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1a4fb5", new byte[]{35, 108, 74, 92, 72, 45, 54, 73, 118, 120, 47, 115, 66, 28, 89, 39, 36, 73, 102, 51, 110, 98, 78, 22, 81, 108, 29, 80, 96, 56, 4, 102, 81, 27, 94, 39, 27, 68, 96, 56, 52, 106, 65, 27, 88, 48, 1, 69, 119, 32, 41, 96, 66}));
            try {
                this.f4856ms.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                string = parcelObtain2.readString();
            } catch (Throwable th) {
                th = th;
                parcelObtain.recycle();
                parcelObtain2.recycle();
                sl.ms(th);
                string = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        parcelObtain.recycle();
        parcelObtain2.recycle();
        return string;
    }
}
