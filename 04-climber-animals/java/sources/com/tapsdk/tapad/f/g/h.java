package com.tapsdk.tapad.f.g;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface h extends g {

    public static abstract class a extends g.b {
        private static final String c = "com.oplus.stdid.IStdID";
        static final int d = 1;

        /* JADX INFO: renamed from: com.tapsdk.tapad.f.g.h$a$a, reason: collision with other inner class name */
        private static class C0595a implements h {
            public static g b;
            private IBinder a;

            C0595a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.tapsdk.tapad.f.g.g
            public String a(String str, String str2, String str3) throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.c);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    if (this.a.transact(1, parcelObtain, parcelObtain2, 0) || a.p() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = a.p().a(str, str2, str3);
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            public String p() {
                return a.c;
            }
        }

        public a() {
            attachInterface(this, c);
        }

        public static boolean a(g gVar) {
            if (C0595a.b != null || gVar == null) {
                return false;
            }
            C0595a.b = gVar;
            return true;
        }

        public static h b(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(c);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof h)) ? new C0595a(iBinder) : (h) iInterfaceQueryLocalInterface;
        }

        public static g p() {
            return C0595a.b;
        }
    }
}
