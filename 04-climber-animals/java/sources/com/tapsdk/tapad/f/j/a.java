package com.tapsdk.tapad.f.j;

import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    static final String b = "QikuIdmanager";
    public static int c = 2;
    public static int d = 3;
    public static int e = 4;
    public static int f = 5;
    public static int g = 6;
    public static int h = 7;
    public static final int i = 8;
    public static final int j = 9;
    private IBinder a;

    public a() {
        Class<?> cls;
        Method declaredMethod;
        this.a = null;
        try {
            Class<?> cls2 = Class.forName("android.os.SystemProperties");
            if (!((String) cls2.getMethod("get", String.class, String.class).invoke(cls2, "ro.build.uiversion", "")).contains("360UI") || (cls = Class.forName("android.os.ServiceManager")) == null || (declaredMethod = cls.getDeclaredMethod("getService", String.class)) == null) {
                return;
            }
            this.a = (IBinder) declaredMethod.invoke(null, "qikuid");
        } catch (Exception e2) {
            Log.e(b, "Failure get qikuid service", e2);
        }
    }

    public String a() {
        if (this.a == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            this.a.transact(g, parcelObtain, parcelObtain2, 0);
            return parcelObtain2.readString();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    public String b() {
        if (this.a == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            this.a.transact(e, parcelObtain, parcelObtain2, 0);
            return parcelObtain2.readString();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    public String c() {
        if (this.a == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            this.a.transact(d, parcelObtain, parcelObtain2, 0);
            return parcelObtain2.readString();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    public String d() {
        if (this.a == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            this.a.transact(f, parcelObtain, parcelObtain2, 0);
            return parcelObtain2.readString();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    public boolean e() {
        if (this.a != null) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                this.a.transact(9, parcelObtain, parcelObtain2, 0);
                return Build.VERSION.SDK_INT >= 29 ? parcelObtain2.readBoolean() : false;
            } catch (RemoteException e2) {
                e2.printStackTrace();
            } finally {
                parcelObtain.recycle();
                parcelObtain2.recycle();
            }
        }
        return false;
    }

    public boolean f() {
        if (this.a != null) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                this.a.transact(c, parcelObtain, parcelObtain2, 0);
                return parcelObtain2.readInt() == 1;
            } catch (RemoteException e2) {
                e2.printStackTrace();
            } finally {
                parcelObtain.recycle();
                parcelObtain2.recycle();
            }
        }
        return false;
    }

    public void g() {
        if (this.a != null) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                try {
                    this.a.transact(h, parcelObtain, parcelObtain2, 0);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            } finally {
                parcelObtain.recycle();
                parcelObtain2.recycle();
            }
        }
    }
}
