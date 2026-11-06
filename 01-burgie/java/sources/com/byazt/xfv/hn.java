package com.byazt.xfv;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.byazt.eld.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.an;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface hn extends IInterface {
    void pr(hw hwVar, x xVar) throws RemoteException;

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_IGNORE_BACKGROUND_RENDERSTALL, 116})
    public static abstract class pr extends Binder implements hn {
        public static String pr = "";

        public static hn pr(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(pr);
            if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof hn)) {
                return new C0231pr(iBinder);
            }
            return (hn) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                hw hwVarCreateFromParcel = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface(pr);
                        if (parcel.readInt() != 0) {
                            hwVarCreateFromParcel = hw.CREATOR.createFromParcel(parcel);
                        }
                        pr(hwVarCreateFromParcel, x.pr.pr(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString(pr);
            return true;
        }

        /* JADX INFO: renamed from: com.byazt.xfv.hn$pr$pr, reason: collision with other inner class name */
        @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_IGNORE_BACKGROUND_RENDERSTALL, 1248})
        private static class C0231pr implements hn {
            public IBinder pr;

            public C0231pr(IBinder iBinder) {
                if (TextUtils.isEmpty(pr.pr)) {
                    JSONObject jSONObjectAj = k.aj();
                    String unused = pr.pr = com.byazt.now.hn.pr(jSONObjectAj.optString("r"), jSONObjectAj.optString(an.aB));
                }
                this.pr = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.pr;
            }

            @Override // com.byazt.xfv.hn
            public void pr(hw hwVar, x xVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(pr.pr);
                    if (hwVar != null) {
                        parcelObtain.writeInt(1);
                        hwVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(xVar != null ? xVar.asBinder() : null);
                    this.pr.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
