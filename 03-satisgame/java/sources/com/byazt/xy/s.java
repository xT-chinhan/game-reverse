package com.byazt.xy;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.byazt.ug.d;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface s extends IInterface {
    void n(qg qgVar, q qVar) throws RemoteException;

    @com.byazt.cp.n(n = {0, 1, 577, 546})
    public static abstract class n extends Binder implements s {
        public static String n = "";

        public static s n(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(n);
            if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof s)) {
                return new C0401n(iBinder);
            }
            return (s) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(n);
                return true;
            }
            if (i == 1) {
                parcel.enforceInterface(n);
                n(parcel.readInt() != 0 ? qg.CREATOR.createFromParcel(parcel) : null, q.n.n(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        /* JADX INFO: renamed from: com.byazt.xy.s$n$n, reason: collision with other inner class name */
        @com.byazt.cp.n(n = {0, 1, 577, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_RETRY_COUNT})
        private static class C0401n implements s {
            public IBinder n;

            public C0401n(IBinder iBinder) {
                if (TextUtils.isEmpty(n.n)) {
                    JSONObject jSONObjectRv = d.rv();
                    String unused = n.n = com.byazt.bk.s.n(jSONObjectRv.optString("r"), jSONObjectRv.optString(com.anythink.core.common.s.a));
                }
                this.n = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.n;
            }

            @Override // com.byazt.xy.s
            public void n(qg qgVar, q qVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(n.n);
                    if (qgVar != null) {
                        parcelObtain.writeInt(1);
                        qgVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(qVar != null ? qVar.asBinder() : null);
                    this.n.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
