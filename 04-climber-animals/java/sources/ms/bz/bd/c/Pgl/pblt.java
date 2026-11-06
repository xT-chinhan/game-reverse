package ms.bz.bd.c.Pgl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.bytedance.sdk.component.utils.sl;

/* JADX INFO: loaded from: classes4.dex */
public final class pblt implements IInterface {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final IBinder f4860ms;

    public pblt(IBinder iBinder) {
        this.f4860ms = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return null;
    }

    public final String ms() throws Throwable {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "966fbb", new byte[]{43, 59, 72, 92, 71, 96, 51, 89, 99, 51, 62, 61, 70, 23, 84, 113, 41, 18, 117, 32, 33, 55, com.anythink.core.common.s.a.c.b, 92, 116, 81, com.anythink.core.common.s.a.c.c, 1, 110, 53, 45, 61, 65, 59, 83, 97, com.anythink.core.common.s.a.c.c, 5, 97, 55, 43, 49}));
            try {
                try {
                    this.f4860ms.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    String string = parcelObtain2.readString();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return string;
                } catch (Exception e) {
                    e = e;
                    sl.ms(e);
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                parcelObtain2.recycle();
                parcelObtain.recycle();
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
        } catch (Throwable th2) {
            th = th2;
            parcelObtain2.recycle();
            parcelObtain.recycle();
            throw th;
        }
    }
}
