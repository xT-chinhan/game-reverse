package com.anythink.odopt.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.anythink.core.common.u.b.c;
import com.anythink.core.common.u.b.d;
import com.anythink.core.common.u.b.e;
import com.anythink.odopt.a.a.f;
import com.anythink.odopt.a.a.h;
import com.anythink.odopt.a.a.k;
import com.anythink.odopt.a.a.m;
import com.anythink.odopt.a.a.n;
import com.anythink.odopt.a.a.o;
import com.anythink.odopt.a.a.q;
import com.anythink.odopt.a.a.t;
import com.anythink.odopt.a.a.u;
import com.anythink.odopt.a.a.w;
import com.anythink.odopt.api.ATOaidBindHandler;
import com.bun.miitmdid.interfaces.IdSupplier;
import com.byazt.ho.BaseConstants;
import java.lang.reflect.Method;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static void a(Context context, com.anythink.odopt.a.a aVar) {
        String strB;
        try {
            strB = b(context);
            try {
                if (!TextUtils.isEmpty(strB)) {
                    aVar.a(strB, false);
                    return;
                }
                String str = Build.MANUFACTURER;
                String strA = a("ro.build.freeme.label");
                boolean z = true;
                if (!TextUtils.isEmpty(strA) && strA.equalsIgnoreCase("FREEMEOS")) {
                    str = "FERRMEOS";
                } else {
                    String strA2 = a("ro.ssui.product");
                    if ((TextUtils.isEmpty(strA2) || strA2.equalsIgnoreCase("unknown")) ? false : true) {
                        str = "SSUI";
                    } else {
                        String strA3 = a("ro.build.freeme.label");
                        if (TextUtils.isEmpty(strA3) || strA3.equalsIgnoreCase("unknown")) {
                            z = false;
                        }
                        if (z) {
                            str = "FREEME";
                        } else if (a(context)) {
                            str = "COOLPAD";
                        } else if (a("ro.odm.manufacturer").equalsIgnoreCase("PRIZE")) {
                            str = "COOLSEA";
                        }
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    String upperCase = str.toUpperCase();
                    if (!Arrays.asList("ASUS", "HUAWEI", BaseConstants.ROM_OPPO_UPPER_CONSTANT, "ONEPLUS", "SAMSUNG", "MEIZU", "MOTOLORA", "LENOVO", "FREEME", "COOLPAD", "COOLSEA", "HONOR", "REALME").contains(upperCase)) {
                        if ("VIVO".equals(upperCase)) {
                            strB = new u(context).a();
                        } else if ("NUBIA".equals(upperCase)) {
                            strB = new n(context).a();
                        } else {
                            ATOaidBindHandler.handleInitOaidBind(context, aVar);
                        }
                    } else {
                        c.a().a(new d(e.bV, new AnonymousClass1(aVar, context, upperCase)));
                    }
                }
                if (TextUtils.isEmpty(strB)) {
                    return;
                }
                aVar.a(strB, false);
            } catch (Throwable th) {
                th = th;
                if (TextUtils.isEmpty(strB)) {
                    com.anythink.odopt.b.a.a(5, th.getMessage());
                }
            }
        } catch (Throwable th2) {
            th = th2;
            strB = "";
        }
    }

    private static boolean a() {
        String strA = a("ro.build.freeme.label");
        return !TextUtils.isEmpty(strA) && strA.equalsIgnoreCase("FREEMEOS");
    }

    private static boolean b() {
        String strA = a("ro.ssui.product");
        return (TextUtils.isEmpty(strA) || strA.equalsIgnoreCase("unknown")) ? false : true;
    }

    private static boolean c() {
        String strA = a("ro.build.freeme.label");
        return (TextUtils.isEmpty(strA) || strA.equalsIgnoreCase("unknown")) ? false : true;
    }

    private static boolean a(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean d() {
        return a("ro.odm.manufacturer").equalsIgnoreCase("PRIZE");
    }

    private static String a(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: com.anythink.odopt.a.b$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ com.anythink.odopt.a.a a;
        final /* synthetic */ Context b;
        final /* synthetic */ String c;

        AnonymousClass1(com.anythink.odopt.a.a aVar, Context context, String str) {
            this.a = aVar;
            this.b = context;
            this.c = str;
        }

        /* JADX WARN: Code duplicated, block: B:45:0x009b  */
        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.odopt.a.a aVar = new com.anythink.odopt.a.a() { // from class: com.anythink.odopt.a.b.1.1
                @Override // com.anythink.odopt.a.a
                public final void a(String str, boolean z) {
                    if (AnonymousClass1.this.a != null) {
                        AnonymousClass1.this.a.a(str, z);
                    }
                }

                @Override // com.anythink.odopt.a.a
                public final void a(String str) {
                    com.anythink.odopt.b.a.a(5, str);
                    ATOaidBindHandler.handleInitOaidBind(AnonymousClass1.this.b, AnonymousClass1.this.a);
                }
            };
            try {
                switch (this.c) {
                    case "ASUS":
                        new com.anythink.odopt.a.a.b(this.b).a(aVar);
                        break;
                    case "OPPO":
                    case "ONEPLUS":
                    case "REALME":
                        if (!new o(this.b).a(aVar)) {
                            new q(this.b).a(aVar);
                            break;
                        }
                        break;
                    case "HUAWEI":
                        new h(this.b).a(aVar);
                        break;
                    case "SAMSUNG":
                        new t(this.b).a(aVar);
                        break;
                    case "LENOVO":
                    case "MOTOLORA":
                        new w(this.b).a(aVar);
                        break;
                    case "MEIZU":
                        new m(this.b).a(aVar);
                        break;
                    case "FREEME":
                        new f(this.b).a(aVar);
                        break;
                    case "COOLPAD":
                        new com.anythink.odopt.a.a.c(this.b).a(aVar);
                        break;
                    case "COOLSEA":
                        new com.anythink.odopt.a.a.d(this.b).a(aVar);
                        break;
                    case "HONOR":
                        new k(this.b).a(aVar);
                        break;
                    default:
                        ATOaidBindHandler.handleInitOaidBind(this.b, this.a);
                        break;
                }
            } catch (Throwable th) {
                com.anythink.odopt.b.a.a(5, th.getMessage());
                com.anythink.odopt.a.a aVar2 = this.a;
                if (aVar2 != null) {
                    aVar2.a(th.getMessage());
                }
            }
        }
    }

    private static void a(Context context, String str, com.anythink.odopt.a.a aVar) {
        c.a().a(new d(e.bV, new AnonymousClass1(aVar, context, str)));
    }

    private static void b(Context context, com.anythink.odopt.a.a aVar) {
        ATOaidBindHandler.handleInitOaidBind(context, aVar);
    }

    private static void a(IdSupplier idSupplier, com.anythink.odopt.a.a aVar) {
        String oaid = idSupplier != null ? idSupplier.getOAID() : "";
        if (TextUtils.isEmpty(oaid)) {
            if (aVar != null) {
                aVar.a("No Support Oaid.");
            }
        } else if (aVar != null) {
            aVar.a(oaid, false);
        }
    }

    private static String b(Context context) {
        try {
            return new a(context).a;
        } catch (Throwable unused) {
            return "";
        }
    }

    static final class a {
        private static Object b;
        private static Class<?> c;
        private static Method d;
        final String a;

        static {
            try {
                Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
                c = cls;
                b = cls.newInstance();
                d = c.getMethod("getOAID", Context.class);
            } catch (Throwable unused) {
            }
        }

        a(Context context) {
            this.a = a(context, d);
        }

        private static boolean a() {
            return (c == null || b == null) ? false : true;
        }

        private static String a(Context context, Method method) {
            Object obj = b;
            if (obj == null || method == null) {
                return null;
            }
            try {
                Object objInvoke = method.invoke(obj, context);
                if (objInvoke != null) {
                    return (String) objInvoke;
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
    }
}
