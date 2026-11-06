package com.miui.externalserver;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IExternalMediaSplashAdService extends IInterface {

    public static class Default implements IExternalMediaSplashAdService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.miui.externalserver.IExternalMediaSplashAdService
        public void cancelSplashAd(String str) throws RemoteException {
        }

        @Override // com.miui.externalserver.IExternalMediaSplashAdService
        public void requestSplashAd(String str, IExternalMediaSplashAdListener iExternalMediaSplashAdListener, Bundle bundle) throws RemoteException {
        }
    }

    void cancelSplashAd(String str) throws RemoteException;

    void requestSplashAd(String str, IExternalMediaSplashAdListener iExternalMediaSplashAdListener, Bundle bundle) throws RemoteException;

    public static abstract class Stub extends Binder implements IExternalMediaSplashAdService {
        private static final String DESCRIPTOR = "com.miui.externalserver.IExternalMediaSplashAdService";
        static final int TRANSACTION_cancelSplashAd = 2;
        static final int TRANSACTION_requestSplashAd = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IExternalMediaSplashAdService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IExternalMediaSplashAdService)) {
                return (IExternalMediaSplashAdService) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                requestSplashAd(parcel.readString(), IExternalMediaSplashAdListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i != 2) {
                if (i == 1598968902) {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(DESCRIPTOR);
            cancelSplashAd(parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        private static class Proxy implements IExternalMediaSplashAdService {
            public static IExternalMediaSplashAdService sDefaultImpl;
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

            @Override // com.miui.externalserver.IExternalMediaSplashAdService
            public void requestSplashAd(String str, IExternalMediaSplashAdListener iExternalMediaSplashAdListener, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iExternalMediaSplashAdListener != null ? iExternalMediaSplashAdListener.asBinder() : null);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().requestSplashAd(str, iExternalMediaSplashAdListener, bundle);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.miui.externalserver.IExternalMediaSplashAdService
            public void cancelSplashAd(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().cancelSplashAd(str);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IExternalMediaSplashAdService iExternalMediaSplashAdService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iExternalMediaSplashAdService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iExternalMediaSplashAdService;
            return true;
        }

        public static IExternalMediaSplashAdService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
