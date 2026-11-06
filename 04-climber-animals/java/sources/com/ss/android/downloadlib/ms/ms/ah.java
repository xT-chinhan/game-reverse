package com.ss.android.downloadlib.ms.ms;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.t;
import com.ss.android.downloadlib.addownload.hi;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface ah extends IInterface {
    void ms(xr xrVar, d dVar) throws RemoteException;

    public static abstract class ms extends Binder implements ah {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static String f4509ms = "";

        public static ah ms(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f4509ms);
            if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ah)) {
                return new C0539ms(iBinder);
            }
            return (ah) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(f4509ms);
                return true;
            }
            if (i == 1) {
                parcel.enforceInterface(f4509ms);
                ms(parcel.readInt() != 0 ? xr.CREATOR.createFromParcel(parcel) : null, d.ms.ms(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        /* JADX INFO: renamed from: com.ss.android.downloadlib.ms.ms.ah$ms$ms, reason: collision with other inner class name */
        private static class C0539ms implements ah {

            /* JADX INFO: renamed from: ms, reason: collision with root package name */
            private IBinder f4510ms;

            C0539ms(IBinder iBinder) {
                if (TextUtils.isEmpty(ms.f4509ms)) {
                    JSONObject jSONObjectNy = hi.ny();
                    String unused = ms.f4509ms = com.ss.android.socialbase.appdownloader.c.ah.ms(jSONObjectNy.optString(t.k), jSONObjectNy.optString("s"));
                }
                this.f4510ms = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f4510ms;
            }

            @Override // com.ss.android.downloadlib.ms.ms.ah
            public void ms(xr xrVar, d dVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ms.f4509ms);
                    if (xrVar != null) {
                        parcelObtain.writeInt(1);
                        xrVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.f4510ms.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
