package com.anythink.dlopt.common.c;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.anythink.core.common.d.t;
import com.anythink.core.common.e.g;
import com.anythink.core.common.h.ag;
import com.anythink.core.common.h.r;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.p;
import com.anythink.core.common.v.q;
import com.anythink.dlopt.common.a.c;
import com.anythink.dlopt.common.a.j;
import com.bykv.vk.component.ttvideo.player.C;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static String a = "a";

    public static String a(Context context, File file) {
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 1).packageName;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static boolean a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                if (context.getPackageManager().getPackageInfo(str, 256) != null) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static String b(Context context, String str) {
        if (t.b().c("it_src")) {
            return "";
        }
        if (context == null) {
            context = t.b().g();
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                return context.getPackageManager().getInstallerPackageName(str);
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String strB = b.b(str);
        if (TextUtils.isEmpty(strB)) {
            return false;
        }
        return new File(strB).exists();
    }

    public static void c(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                launchIntentForPackage.setFlags(C.ENCODING_PCM_MU_LAW);
                context.startActivity(launchIntentForPackage);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(final Context context, final w wVar, x xVar) {
        if (TextUtils.equals(String.valueOf(xVar.j), "0") && !xVar.p) {
            if (!(wVar instanceof r) || TextUtils.isEmpty(((r) wVar).d())) {
                final String strA = p.a(wVar);
                String strI = wVar.I();
                if (!TextUtils.isEmpty(strI) && a(context, strI)) {
                    wVar.v();
                    wVar.m(2);
                } else if (new File(b.b(strA)).exists()) {
                    wVar.v();
                    wVar.m(5);
                } else {
                    com.anythink.core.common.v.b.b.a().c(new Runnable() { // from class: com.anythink.dlopt.common.c.a.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            ag agVarA = g.a(context).a(strA);
                            String str = a.a;
                            Object[] objArr = new Object[1];
                            if (agVarA != null) {
                                wVar.m(agVarA.D());
                            } else {
                                wVar.m(0);
                            }
                        }
                    }, 13);
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.dlopt.common.c.a$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.e.values().length];
            a = iArr;
            try {
                iArr[c.e.LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[c.e.PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[c.e.STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[c.e.FAIL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[c.e.FINISH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[c.e.INSTALLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static String a(Context context, c.e eVar) {
        if (context == null || eVar == null) {
            return "";
        }
        switch (AnonymousClass2.a[eVar.ordinal()]) {
            case 1:
                return context.getResources().getString(q.a(context, "cta_downloading", "string"));
            case 2:
            case 3:
            case 4:
                return context.getResources().getString(q.a(context, "cta_download_paused", "string"));
            case 5:
                return context.getResources().getString(q.a(context, "cta_download_finished", "string"));
            case 6:
                return context.getResources().getString(q.a(context, "cta_download_installed", "string"));
            default:
                return "";
        }
    }

    public static boolean a(j jVar) {
        if (jVar != null && jVar.j != null && jVar.j.r() != null) {
            long jT = jVar.t();
            long jK = jVar.j.r().K();
            if (jK > 0 && jT + jK < System.currentTimeMillis()) {
                return true;
            }
        }
        return false;
    }
}
