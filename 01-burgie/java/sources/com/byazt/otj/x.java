package com.byazt.otj;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
public interface x extends IInterface {
    String c() throws RemoteException;

    String hn() throws RemoteException;

    String hw() throws RemoteException;

    boolean pr() throws RemoteException;

    String x() throws RemoteException;

    @com.byazt.vzx.pr(pr = {0, 1, 833, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
    public static abstract class pr extends Binder implements x {
        public static x pr(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof x)) {
                return (x) iInterfaceQueryLocalInterface;
            }
            return new C0158pr(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    boolean zPr = pr();
                    parcel2.writeNoException();
                    parcel2.writeInt(zPr ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    String strHw = hw();
                    parcel2.writeNoException();
                    parcel2.writeString(strHw);
                    return true;
                case 3:
                    parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    String strHn = hn();
                    parcel2.writeNoException();
                    parcel2.writeString(strHn);
                    return true;
                case 4:
                    parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    String strX = x();
                    parcel2.writeNoException();
                    parcel2.writeString(strX);
                    return true;
                case 5:
                    parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    String strC = c();
                    parcel2.writeNoException();
                    parcel2.writeString(strC);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: com.byazt.otj.x$pr$pr, reason: collision with other inner class name */
        @com.byazt.vzx.pr(pr = {0, 1, 833, 1355})
        private static class C0158pr implements x {
            public final IBinder pr;

            public C0158pr(IBinder iBinder) {
                this.pr = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.pr;
            }

            @Override // com.byazt.otj.x
            public boolean pr() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    this.pr.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.otj.x
            public String hw() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    this.pr.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.otj.x
            public String hn() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    this.pr.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.otj.x
            public String x() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    this.pr.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.otj.x
            public String c() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    this.pr.transact(5, parcelObtain, parcelObtain2, 0);
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
