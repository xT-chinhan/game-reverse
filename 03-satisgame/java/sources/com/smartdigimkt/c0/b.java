package com.smartdigimkt.c0;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.bykv.vk.component.ttvideo.player.C;
import com.smartdigimkt.r4.a0;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public static final String a = a0.a("dfwlylw|");
    public static final String b = a0.a("dfwlylw|bwdvn");
    public static final String c = a0.a("dqgurlg1dss1LDfwlylw|Pdqdjhu");
    public static final String d = a0.a("dqgurlg1dss1LDfwlylw|WdvnPdqdjhu");
    public static final String e = a0.a("dqgurlg1dss1LDfwlylw|Pdqdjhu'Vwxe");
    public static final String f = a0.a("dqgurlg1dss1LDfwlylw|WdvnPdqdjhu'Vwxe");
    public static final String g = a0.a("dqgurlg1frqwhqw1LFrqwhqwSurylghu");
    public static final String h = a0.a("WUDQVDFWLRQbvwduwDfwlylw|");
    public static final String i = a0.a("WUDQVDFWLRQbvwduwDfwlylwlhv");
    public static final String j = a0.a("dqgurlg1rv1VhuylfhPdqdjhu");
    public static final String k = a0.a("jhwVhuylfh");
    public static final String l = a0.a("dqgurlg1dss1Dfwlylw|Wkuhdg");
    public static final String m = a0.a("fxuuhqwDfwlylw|Wkuhdg");
    public static final String n = a0.a("jhwDssolfdwlrqWkuhdg");
    public static final String o = a0.a("pFrqwhqwSurylghu");
    public static final String p = a0.a("dqgurlg1frqwhqw1DwwulexwlrqVrxufh'Exloghu");
    public static final String q = a0.a("vhwSdfndjhQdph");
    public static final String r = a0.a("exlog");

    public static boolean a(Context context, Intent intent) {
        int i2;
        IBinder iBinderAsBinder;
        boolean z = false;
        if (context == null || intent == null || (i2 = Build.VERSION.SDK_INT) < 26) {
            return false;
        }
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            a aVarA = a();
            Class<?> cls = Class.forName(l);
            Object objInvoke = cls.getMethod(n, null).invoke(cls.getMethod(m, null).invoke(null, null), null);
            if (objInvoke instanceof IInterface) {
                iBinderAsBinder = ((IInterface) objInvoke).asBinder();
            } else {
                Objects.toString(objInvoke != null ? objInvoke.getClass() : null);
                iBinderAsBinder = null;
            }
            if (aVarA != null && iBinderAsBinder != null) {
                intent.toString();
                parcelObtain.writeInterfaceToken(aVarA.b);
                parcelObtain.writeStrongBinder(iBinderAsBinder);
                parcelObtain.writeString(context.getPackageName());
                if (i2 >= 30) {
                    parcelObtain.writeString(null);
                }
                parcelObtain.writeInt(1);
                intent.writeToParcel(parcelObtain, 0);
                parcelObtain.writeString(intent.resolveTypeIfNeeded(context.getContentResolver()));
                parcelObtain.writeStrongBinder(null);
                parcelObtain.writeString(null);
                parcelObtain.writeInt(-1);
                parcelObtain.writeInt(0);
                parcelObtain.writeInt(0);
                parcelObtain.writeBundle(null);
                Field declaredField = Class.forName(aVarA.c).getDeclaredField(h);
                declaredField.setAccessible(true);
                if (aVarA.a.transact(declaredField.getInt(null), parcelObtain, parcelObtain2, 0)) {
                    parcelObtain2.readException();
                    int i3 = parcelObtain2.readInt();
                    if (i3 >= 0 && i3 <= 99) {
                        z = true;
                    }
                }
                parcelObtain.recycle();
                parcelObtain2.recycle();
                return z;
            }
            parcelObtain.recycle();
            parcelObtain2.recycle();
            return false;
        } catch (Throwable unused) {
            parcelObtain.recycle();
            parcelObtain2.recycle();
            return false;
        }
    }

    public static boolean a(Context context, Uri uri, Bundle bundle) {
        int i2;
        if (context == null || uri == null || (i2 = Build.VERSION.SDK_INT) < 26) {
            return false;
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        ContentProviderClient contentProviderClient = null;
        try {
            String authority = uri.getAuthority();
            if (authority == null) {
                uri.toString();
                parcelObtain.recycle();
                parcelObtain2.recycle();
                return false;
            }
            ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(authority);
            if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                parcelObtain.recycle();
                parcelObtain2.recycle();
                if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                    try {
                        contentProviderClientAcquireUnstableContentProviderClient.close();
                    } catch (Throwable unused) {
                    }
                }
                return false;
            }
            try {
                Field declaredField = ContentProviderClient.class.getDeclaredField(o);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(contentProviderClientAcquireUnstableContentProviderClient);
                if (!(obj instanceof IInterface)) {
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                    try {
                        contentProviderClientAcquireUnstableContentProviderClient.close();
                    } catch (Throwable unused2) {
                    }
                    return false;
                }
                IBinder iBinderAsBinder = ((IInterface) obj).asBinder();
                if (iBinderAsBinder == null) {
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                    try {
                        contentProviderClientAcquireUnstableContentProviderClient.close();
                    } catch (Throwable unused3) {
                    }
                    return false;
                }
                parcelObtain.writeInterfaceToken(g);
                if (i2 >= 31) {
                    ((Parcelable) a(context)).writeToParcel(parcelObtain, 0);
                } else if (i2 == 30) {
                    parcelObtain.writeString(context.getPackageName());
                    parcelObtain.writeString(null);
                } else {
                    parcelObtain.writeString(context.getPackageName());
                }
                uri.writeToParcel(parcelObtain, 0);
                parcelObtain.writeInt(0);
                parcelObtain.writeBundle(bundle);
                parcelObtain.writeStrongBinder(null);
                parcelObtain.writeStrongBinder(null);
                if (!iBinderAsBinder.transact(1, parcelObtain, parcelObtain2, 0)) {
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                    try {
                        contentProviderClientAcquireUnstableContentProviderClient.close();
                    } catch (Throwable unused4) {
                    }
                    return false;
                }
                parcelObtain2.readException();
                boolean z = parcelObtain2.readInt() != 0;
                parcelObtain.recycle();
                parcelObtain2.recycle();
                try {
                    contentProviderClientAcquireUnstableContentProviderClient.close();
                } catch (Throwable unused5) {
                }
                return z;
            } catch (Throwable unused6) {
                contentProviderClient = contentProviderClientAcquireUnstableContentProviderClient;
                parcelObtain.recycle();
                parcelObtain2.recycle();
                if (contentProviderClient != null) {
                    try {
                        contentProviderClient.close();
                    } catch (Throwable unused7) {
                    }
                }
                return false;
            }
        } catch (Throwable unused8) {
        }
    }

    public static Object a(Context context) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        int iMyUid = Process.myUid();
        Class<?> cls = Class.forName(p);
        return cls.getMethod(r, null).invoke(cls.getMethod(q, String.class).invoke(cls.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(iMyUid)), context.getPackageName()), null);
    }

    public static a a() throws NoSuchMethodException {
        IBinder iBinder;
        Method declaredMethod = Class.forName(j).getDeclaredMethod(k, String.class);
        declaredMethod.setAccessible(true);
        if (Build.VERSION.SDK_INT >= 29 && (iBinder = (IBinder) declaredMethod.invoke(null, b)) != null) {
            return new a(iBinder, d, f);
        }
        IBinder iBinder2 = (IBinder) declaredMethod.invoke(null, a);
        if (iBinder2 == null) {
            return null;
        }
        return new a(iBinder2, c, e);
    }
}
