package com.byazt.nf;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
public interface l extends IInterface {
    void n(String str, int i) throws RemoteException;

    void n(String str, fs fsVar) throws RemoteException;

    void n(String str, q qVar) throws RemoteException;

    void n(String str, qg qgVar) throws RemoteException;

    void n(String str, s sVar) throws RemoteException;

    void n(String str, w wVar) throws RemoteException;

    void n(String str, x xVar) throws RemoteException;

    void n(String str, String str2) throws RemoteException;

    void n(String str, String str2, long j, long j2, String str3, String str4) throws RemoteException;

    void n(String str, String str2, Bundle bundle) throws RemoteException;

    void qg(String str, fs fsVar) throws RemoteException;

    void qg(String str, String str2, Bundle bundle) throws RemoteException;

    Bundle s(String str, String str2, Bundle bundle) throws RemoteException;

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_CODEC_NAME, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    public static abstract class n extends Binder implements l {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public n() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.core.IListenerManager");
        }

        public static l n(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof l)) {
                return (l) iInterfaceQueryLocalInterface;
            }
            return new C0258n(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.bytedance.sdk.openadsdk.core.IListenerManager");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    n(parcel.readString(), x.n.n(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    n(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    n(parcel.readString(), q.n.n(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    qg(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    n(parcel.readString(), fs.n.n(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    qg(parcel.readString(), fs.n.n(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    n(parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    n(parcel.readString(), qg.n.n(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    n(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    n(parcel.readString(), s.n.n(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    n(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    n(parcel.readString(), w.n.n(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    Bundle bundleS = s(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (bundleS != null) {
                        parcel2.writeInt(1);
                        bundleS.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: renamed from: com.byazt.nf.l$n$n, reason: collision with other inner class name */
        @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_CODEC_NAME, MediaPlayer.MEDIA_PLAYER_OPTION_SUB_FIRST_LOAD_TIME})
        private static class C0258n implements l {
            public static l n;
            public IBinder qg;

            public C0258n(IBinder iBinder) {
                this.qg = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.qg;
            }

            @Override // com.byazt.nf.l
            public void n(String str, x xVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(xVar != null ? xVar.asBinder() : null);
                    if (!this.qg.transact(1, parcelObtain, parcelObtain2, 0) && n.n() != null) {
                        n.n().n(str, xVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.nf.l
            public void n(String str, String str2, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.qg.transact(2, parcelObtain, parcelObtain2, 0) && n.n() != null) {
                        n.n().n(str, str2, bundle);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.nf.l
            public void n(String str, q qVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(qVar != null ? qVar.asBinder() : null);
                    if (!this.qg.transact(3, parcelObtain, parcelObtain2, 0) && n.n() != null) {
                        n.n().n(str, qVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.nf.l
            public void qg(String str, String str2, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.qg.transact(4, parcelObtain, parcelObtain2, 0) && n.n() != null) {
                        n.n().qg(str, str2, bundle);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.nf.l
            public void n(String str, fs fsVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(fsVar != null ? fsVar.asBinder() : null);
                    if (!this.qg.transact(5, parcelObtain, parcelObtain2, 0) && n.n() != null) {
                        n.n().n(str, fsVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.nf.l
            public void qg(String str, fs fsVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(fsVar != null ? fsVar.asBinder() : null);
                    if (!this.qg.transact(6, parcelObtain, parcelObtain2, 0) && n.n() != null) {
                        n.n().qg(str, fsVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.nf.l
            public void n(String str, String str2, long j, long j2, String str3, String str4) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeLong(j2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    try {
                        if (!this.qg.transact(7, parcelObtain, parcelObtain2, 0) && n.n() != null) {
                            n.n().n(str, str2, j, j2, str3, str4);
                        } else {
                            parcelObtain2.readException();
                        }
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
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

            @Override // com.byazt.nf.l
            public void n(String str, qg qgVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(qgVar != null ? qgVar.asBinder() : null);
                    if (!this.qg.transact(8, parcelObtain, parcelObtain2, 0) && n.n() != null) {
                        n.n().n(str, qgVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.nf.l
            public void n(String str, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    if (!this.qg.transact(9, parcelObtain, parcelObtain2, 0) && n.n() != null) {
                        n.n().n(str, i);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.nf.l
            public void n(String str, s sVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(sVar != null ? sVar.asBinder() : null);
                    if (!this.qg.transact(10, parcelObtain, parcelObtain2, 0) && n.n() != null) {
                        n.n().n(str, sVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.nf.l
            public void n(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.qg.transact(11, parcelObtain, parcelObtain2, 0) && n.n() != null) {
                        n.n().n(str, str2);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.nf.l
            public void n(String str, w wVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(wVar != null ? wVar.asBinder() : null);
                    if (!this.qg.transact(12, parcelObtain, parcelObtain2, 0) && n.n() != null) {
                        n.n().n(str, wVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.nf.l
            public Bundle s(String str, String str2, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.qg.transact(13, parcelObtain, parcelObtain2, 0) && n.n() != null) {
                        return n.n().s(str, str2, bundle);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static l n() {
            return C0258n.n;
        }
    }
}
