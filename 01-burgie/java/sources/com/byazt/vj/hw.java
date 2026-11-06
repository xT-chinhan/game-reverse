package com.byazt.vj;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
public interface hw extends IInterface {
    void hw(com.byazt.vj.pr prVar) throws RemoteException;

    void pr(int i, long j, boolean z, float f, double d, String str) throws RemoteException;

    void pr(com.byazt.vj.pr prVar) throws RemoteException;

    @com.byazt.vzx.pr(pr = {0, 1, 322, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    public static abstract class pr extends Binder implements hw {
        public static hw pr(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.hihonor.cloudservice.oaid.IOAIDService");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof hw)) {
                return (hw) iInterfaceQueryLocalInterface;
            }
            return new C0213pr(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDService");
                    pr(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDService");
                    pr(com.byazt.vj.pr.AbstractBinderC0214pr.pr(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDService");
                    hw(com.byazt.vj.pr.AbstractBinderC0214pr.pr(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.hihonor.cloudservice.oaid.IOAIDService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: com.byazt.vj.hw$pr$pr, reason: collision with other inner class name */
        @com.byazt.vzx.pr(pr = {0, 1, 322, 799})
        private static class C0213pr implements hw {
            public static hw pr;
            public IBinder hw;

            public C0213pr(IBinder iBinder) {
                this.hw = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.hw;
            }

            @Override // com.byazt.vj.hw
            public void pr(int i, long j, boolean z, float f, double d, String str) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeFloat(f);
                    parcelObtain.writeDouble(d);
                    parcelObtain.writeString(str);
                    try {
                        if (!this.hw.transact(1, parcelObtain, parcelObtain2, 0) && pr.pr() != null) {
                            pr.pr().pr(i, j, z, f, d, str);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        } else {
                            parcelObtain2.readException();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        }
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // com.byazt.vj.hw
            public void pr(com.byazt.vj.pr prVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    parcelObtain.writeStrongBinder(prVar != null ? prVar.asBinder() : null);
                    if (!this.hw.transact(2, parcelObtain, parcelObtain2, 0) && pr.pr() != null) {
                        pr.pr().pr(prVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.vj.hw
            public void hw(com.byazt.vj.pr prVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    parcelObtain.writeStrongBinder(prVar != null ? prVar.asBinder() : null);
                    if (!this.hw.transact(3, parcelObtain, parcelObtain2, 0) && pr.pr() != null) {
                        pr.pr().hw(prVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static hw pr() {
            return C0213pr.pr;
        }
    }
}
