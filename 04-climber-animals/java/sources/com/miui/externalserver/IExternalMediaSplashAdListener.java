package com.miui.externalserver;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IExternalMediaSplashAdListener extends IInterface {

    public static class Default implements IExternalMediaSplashAdListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.miui.externalserver.IExternalMediaSplashAdListener
        public void onAdDismissed() throws RemoteException {
        }

        @Override // com.miui.externalserver.IExternalMediaSplashAdListener
        public void onAdError(int i) throws RemoteException {
        }

        @Override // com.miui.externalserver.IExternalMediaSplashAdListener
        public void onAdLoaded() throws RemoteException {
        }
    }

    void onAdDismissed() throws RemoteException;

    void onAdError(int i) throws RemoteException;

    void onAdLoaded() throws RemoteException;

    public static abstract class Stub extends Binder implements IExternalMediaSplashAdListener {
        private static final String DESCRIPTOR = "com.miui.externalserver.IExternalMediaSplashAdListener";
        static final int TRANSACTION_onAdDismissed = 3;
        static final int TRANSACTION_onAdError = 1;
        static final int TRANSACTION_onAdLoaded = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IExternalMediaSplashAdListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IExternalMediaSplashAdListener)) {
                return (IExternalMediaSplashAdListener) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onAdError(parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onAdLoaded();
                parcel2.writeNoException();
                return true;
            }
            if (i != 3) {
                if (i == 1598968902) {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(DESCRIPTOR);
            onAdDismissed();
            parcel2.writeNoException();
            return true;
        }

        private static class Proxy implements IExternalMediaSplashAdListener {
            public static IExternalMediaSplashAdListener sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.miui.externalserver.IExternalMediaSplashAdListener
            public void onAdError(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onAdError(i);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.externalserver.IExternalMediaSplashAdListener
            public void onAdLoaded() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onAdLoaded();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.externalserver.IExternalMediaSplashAdListener
            public void onAdDismissed() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onAdDismissed();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IExternalMediaSplashAdListener iExternalMediaSplashAdListener) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iExternalMediaSplashAdListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iExternalMediaSplashAdListener;
            return true;
        }

        public static IExternalMediaSplashAdListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
