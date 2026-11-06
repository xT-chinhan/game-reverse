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
public interface q extends IInterface {
    void n(qg qgVar) throws RemoteException;

    @com.byazt.cp.n(n = {0, 1, 577, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    public static abstract class n extends Binder implements q {
        public static String n = "";

        public static q n(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(n);
            if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof q)) {
                return new C0400n(iBinder);
            }
            return (q) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(n);
                n(parcel.readInt() != 0 ? qg.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString(n);
            return true;
        }

        /* JADX INFO: renamed from: com.byazt.xy.q$n$n, reason: collision with other inner class name */
        @com.byazt.cp.n(n = {0, 1, 577, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FRAMES_DROP})
        private static class C0400n implements q {
            public IBinder n;

            public C0400n(IBinder iBinder) {
                if (TextUtils.isEmpty(n.n)) {
                    JSONObject jSONObjectRv = d.rv();
                    String unused = n.n = com.byazt.bk.s.n(jSONObjectRv.optString("t"), jSONObjectRv.optString(com.anythink.core.common.s.a));
                }
                this.n = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.n;
            }

            @Override // com.byazt.xy.q
            public void n(qg qgVar) throws RemoteException {
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
