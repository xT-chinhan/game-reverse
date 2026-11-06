package com.ss.android.downloadlib.ms.ms;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.hi;
import com.umeng.analytics.pro.bv;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface d extends IInterface {
    void ms(xr xrVar) throws RemoteException;

    public static abstract class ms extends Binder implements d {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static String f4511ms = "";

        public static d ms(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f4511ms);
            if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof d)) {
                return new C0540ms(iBinder);
            }
            return (d) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(f4511ms);
                ms(parcel.readInt() != 0 ? xr.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString(f4511ms);
            return true;
        }

        /* JADX INFO: renamed from: com.ss.android.downloadlib.ms.ms.d$ms$ms, reason: collision with other inner class name */
        private static class C0540ms implements d {

            /* JADX INFO: renamed from: ms, reason: collision with root package name */
            private IBinder f4512ms;

            C0540ms(IBinder iBinder) {
                if (TextUtils.isEmpty(ms.f4511ms)) {
                    JSONObject jSONObjectNy = hi.ny();
                    String unused = ms.f4511ms = com.ss.android.socialbase.appdownloader.c.ah.ms(jSONObjectNy.optString(bv.aI), jSONObjectNy.optString("s"));
                }
                this.f4512ms = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f4512ms;
            }

            @Override // com.ss.android.downloadlib.ms.ms.d
            public void ms(xr xrVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ms.f4511ms);
                    if (xrVar != null) {
                        parcelObtain.writeInt(1);
                        xrVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f4512ms.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
