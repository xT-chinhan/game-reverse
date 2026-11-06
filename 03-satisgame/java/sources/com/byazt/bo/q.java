package com.byazt.bo;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
public interface q extends IInterface {
    String l() throws RemoteException;

    boolean n() throws RemoteException;

    String q() throws RemoteException;

    String qg() throws RemoteException;

    String s() throws RemoteException;

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_SKIP_INIT_SECTION, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    public static abstract class n extends Binder implements q {
        public static q n(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof q)) {
                return (q) iInterfaceQueryLocalInterface;
            }
            return new C0142n(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                boolean zN = n();
                parcel2.writeNoException();
                parcel2.writeInt(zN ? 1 : 0);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                String strQg = qg();
                parcel2.writeNoException();
                parcel2.writeString(strQg);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                String strS = s();
                parcel2.writeNoException();
                parcel2.writeString(strS);
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                String strQ = q();
                parcel2.writeNoException();
                parcel2.writeString(strQ);
                return true;
            }
            if (i != 5) {
                if (i == 1598968902) {
                    parcel2.writeString("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            String strL = l();
            parcel2.writeNoException();
            parcel2.writeString(strL);
            return true;
        }

        /* JADX INFO: renamed from: com.byazt.bo.q$n$n, reason: collision with other inner class name */
        @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_SKIP_INIT_SECTION, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FRAMES_DROP})
        private static class C0142n implements q {
            public final IBinder n;

            public C0142n(IBinder iBinder) {
                this.n = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.n;
            }

            @Override // com.byazt.bo.q
            public boolean n() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    this.n.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.bo.q
            public String qg() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    this.n.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.bo.q
            public String s() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    this.n.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.bo.q
            public String q() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    this.n.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.bo.q
            public String l() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    this.n.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
