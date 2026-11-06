package com.anythink.core.common.u;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class m {
    public static boolean a = false;
    public static boolean b = false;
    private static boolean c = false;
    private static boolean d = false;
    private static boolean e = false;
    private static boolean f = false;
    private static boolean g = false;
    private static boolean h = false;

    private m() {
    }

    private static void a(String str, String str2) {
        if (c) {
            Log.v(str, str2);
        }
    }

    private static void a(String str, String str2, Throwable th) {
        if (c) {
            Log.v(str, str2, th);
        }
    }

    private static void b(String str, String str2) {
        if (d) {
            Log.d(str, str2);
        }
    }

    private static void b(String str, String str2, Throwable th) {
        if (d) {
            Log.d(str, str2, th);
        }
    }

    private static void c(String str, String str2) {
        if (e) {
            Log.i(str, str2);
        }
    }

    private static void c(String str, String str2, Throwable th) {
        if (e) {
            Log.i(str, str2, th);
        }
    }

    private static void d(String str, String str2) {
        if (f) {
            Log.w(str, str2);
        }
    }

    private static void d(String str, String str2, Throwable th) {
        if (f) {
            Log.w(str, str2, th);
        }
    }

    private static void a(String str, Throwable th) {
        if (f) {
            Log.w(str, th);
        }
    }

    private static void e(String str, String str2) {
        if (g) {
            Log.e(str, str2);
        }
    }

    private static void e(String str, String str2, Throwable th) {
        if (g) {
            Log.e(str, str2, th);
        }
    }

    private static void f(String str, String str2) {
        if (e) {
            int length = 2001 - str.length();
            while (str2.length() > length) {
                Log.d(str, str2.substring(0, length));
                str2 = str2.substring(length);
            }
            Log.d(str, str2);
        }
    }

    private static void a(String str, String str2, Object... objArr) {
        if (d) {
            try {
                Log.d(str, a() + String.format(str2, objArr));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private static void b(String str, String str2, Object... objArr) {
        if (d) {
            try {
                Log.i(str, a() + String.format(str2, objArr));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private static void c(String str, String str2, Object... objArr) {
        if (d) {
            try {
                Log.w(str, a() + String.format(str2, objArr));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private static void d(String str, String str2, Object... objArr) {
        if (g) {
            try {
                Log.e(str, a() + String.format(str2, objArr));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private static String a() {
        return "<" + Thread.currentThread().getName() + ", " + Thread.currentThread().getId() + "> ";
    }
}
