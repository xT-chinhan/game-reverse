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
public interface x extends IInterface {
    void pr(hw hwVar) throws RemoteException;

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_IGNORE_BACKGROUND_RENDERSTALL, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
    public static abstract class pr extends Binder implements x {
        public static String pr = "";

        public static x pr(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(pr);
            if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof x)) {
                return new C0232pr(iBinder);
            }
            return (x) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(pr);
                pr(parcel.readInt() != 0 ? hw.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString(pr);
            return true;
        }

        /* JADX INFO: renamed from: com.byazt.xfv.x$pr$pr, reason: collision with other inner class name */
        @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_IGNORE_BACKGROUND_RENDERSTALL, 1355})
        private static class C0232pr implements x {
            public IBinder pr;

            public C0232pr(IBinder iBinder) {
                if (TextUtils.isEmpty(pr.pr)) {
                    JSONObject jSONObjectAj = k.aj();
                    String unused = pr.pr = com.byazt.now.hn.pr(jSONObjectAj.optString(an.aI), jSONObjectAj.optString(an.aB));
                }
                this.pr = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.pr;
            }

            @Override // com.byazt.xfv.x
            public void pr(hw hwVar) throws RemoteException {
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
