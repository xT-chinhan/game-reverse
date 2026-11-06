package com.smartdigimkt.c0;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.smartdigimkt.r4.a0;
import java.lang.reflect.Field;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e {
    public static final String a = a0.a("dqgurlg=txhu|0duj0vto0vhohfwlrq");

    public static com.smartdigimkt.z.j a(Context context, Intent intent, ResolveInfo resolveInfo, String str, com.smartdigimkt.z.h hVar) {
        int i;
        int i2 = 1;
        try {
            String str2 = hVar.a;
            intent.setFlags((str2 == null || !str2.startsWith("tbopen://")) ? 268468224 : 805339136);
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            if (d.a("oppo") || d.a("oneplus") || d.a("realme")) {
                intent = c.a(intent);
                if (resolveInfo != null) {
                    if (!b.a(context, intent)) {
                        context.startActivity(intent);
                    }
                    com.smartdigimkt.z.i iVar = new com.smartdigimkt.z.i();
                    iVar.a = 0;
                    iVar.b = str;
                    return new com.smartdigimkt.z.j(iVar);
                }
                i = 1;
            } else {
                i = 0;
            }
            if (d.a("honor")) {
                String strA = hVar.c;
                if (TextUtils.isEmpty(strA)) {
                    strA = h.a(context, intent);
                }
                if (TextUtils.isEmpty(strA)) {
                    strA = resolveInfo != null ? resolveInfo.resolvePackageName : "";
                }
                if (!TextUtils.isEmpty(strA)) {
                    Uri uri = Uri.parse(c.d);
                    Bundle bundle = new Bundle();
                    bundle.putString(a, "{\"deepLink\":\"" + a(str2) + "\",\"pkgName\":\"" + a(strA) + "\"}");
                    boolean zA = b.a(context, uri, bundle);
                    if (!zA) {
                        zA = c.a(context, str2, strA);
                    }
                    if (zA) {
                        com.smartdigimkt.z.i iVar2 = new com.smartdigimkt.z.i();
                        iVar2.a = 0;
                        iVar2.b = str;
                        return new com.smartdigimkt.z.j(iVar2);
                    }
                }
            }
            if (d.a(MediationConstant.ADN_XIAOMI) || d.a("redmi")) {
                if (resolveInfo != null) {
                    a(context, intent);
                    com.smartdigimkt.z.i iVar3 = new com.smartdigimkt.z.i();
                    iVar3.a = i;
                    iVar3.b = str;
                    return new com.smartdigimkt.z.j(iVar3);
                }
                i = 1;
            }
            if (resolveInfo != null) {
                Intent intentCreateChooser = Intent.createChooser(intent, "title");
                intentCreateChooser.addFlags(C.ENCODING_PCM_MU_LAW);
                if (!b.a(context, intentCreateChooser)) {
                    context.startActivity(intentCreateChooser);
                }
                com.smartdigimkt.z.i iVar4 = new com.smartdigimkt.z.i();
                iVar4.a = i;
                iVar4.b = str;
                return new com.smartdigimkt.z.j(iVar4);
            }
        } catch (Throwable unused) {
            if (resolveInfo != null) {
                i2 = 3;
            }
        }
        com.smartdigimkt.z.i iVar5 = new com.smartdigimkt.z.i();
        iVar5.a = i2;
        iVar5.b = str;
        return new com.smartdigimkt.z.j(iVar5);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00c8 A[RETURN] */
    public static void a(Context context, Intent intent) {
        int i;
        Intent intent2;
        IBinder iBinderAsBinder;
        boolean z = true;
        Intent[] intentArr = {intent};
        String str = b.a;
        if (context != null && (i = Build.VERSION.SDK_INT) >= 26 && (intent2 = intentArr[0]) != null) {
            String[] strArr = {intent2.resolveTypeIfNeeded(context.getContentResolver())};
            intentArr[0].addFlags(C.ENCODING_PCM_MU_LAW);
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                a aVarA = b.a();
                Class<?> cls = Class.forName(b.l);
                Object objInvoke = cls.getMethod(b.n, null).invoke(cls.getMethod(b.m, null).invoke(null, null), null);
                if (!(objInvoke instanceof IInterface)) {
                    Objects.toString(objInvoke != null ? objInvoke.getClass() : null);
                    iBinderAsBinder = null;
                } else {
                    iBinderAsBinder = ((IInterface) objInvoke).asBinder();
                }
                if (aVarA != null && iBinderAsBinder != null) {
                    Objects.toString(intentArr[0]);
                    parcelObtain.writeInterfaceToken(aVarA.b);
                    parcelObtain.writeStrongBinder(iBinderAsBinder);
                    parcelObtain.writeString(context.getPackageName());
                    if (i >= 30) {
                        parcelObtain.writeString(null);
                    }
                    parcelObtain.writeTypedArray(intentArr, 0);
                    parcelObtain.writeStringArray(strArr);
                    parcelObtain.writeStrongBinder(null);
                    parcelObtain.writeBundle(null);
                    Field declaredField = Class.forName(aVarA.c).getDeclaredField(b.i);
                    declaredField.setAccessible(true);
                    if (aVarA.a.transact(declaredField.getInt(null), parcelObtain, parcelObtain2, 0)) {
                        parcelObtain2.readException();
                        int i2 = parcelObtain2.readInt();
                        if (i2 < 0 || i2 > 99) {
                        }
                        parcelObtain.recycle();
                        parcelObtain2.recycle();
                        if (z) {
                            return;
                        }
                    }
                    z = false;
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                    if (z) {
                        return;
                    }
                } else {
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                }
            } catch (Throwable unused) {
            }
        }
        context.startActivities(intentArr);
    }

    public static String a(String str) {
        if (str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str.length() + 8);
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\f') {
                sb.append("\\f");
            } else if (cCharAt == '\r') {
                sb.append("\\r");
            } else if (cCharAt == '\"') {
                sb.append("\\\"");
            } else if (cCharAt != '\\') {
                switch (cCharAt) {
                    case '\b':
                        sb.append("\\b");
                        break;
                    case '\t':
                        sb.append("\\t");
                        break;
                    case '\n':
                        sb.append("\\n");
                        break;
                    default:
                        if (cCharAt < ' ') {
                            sb.append(String.format(Locale.US, "\\u%04x", Integer.valueOf(cCharAt)));
                        } else {
                            sb.append(cCharAt);
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
