package c1m.m2a.m1g;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class d implements c1m.m2a.m1g.a {
    private static int a = 1000;
    private static int b;

    class a implements c {
        final /* synthetic */ String a;

        a(d dVar, String str) {
            this.a = str;
        }

        @Override // c1m.m2a.m1g.d.c
        public void a(String str) {
            Log.d(this.a, str);
        }
    }

    class b implements c {
        final /* synthetic */ String a;

        b(d dVar, String str) {
            this.a = str;
        }

        @Override // c1m.m2a.m1g.d.c
        public void a(String str) {
            Log.i(this.a, str);
        }
    }

    interface c {
        void a(String str);
    }

    /* JADX INFO: renamed from: c1m.m2a.m1g.d$d, reason: collision with other inner class name */
    private static class C0005d {
        private static final d a = new d(null);
    }

    private d() {
        setLogLevel(0);
    }

    /* synthetic */ d(c1m.m2a.m1g.c cVar) {
        this();
    }

    public static c1m.m2a.m1g.a a() {
        return C0005d.a;
    }

    private static String a(Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        int length = objArr.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            Object obj = objArr[i];
            if (obj == null) {
                strArr[i] = "nullptr";
            } else if (obj instanceof Throwable) {
                strArr[i] = "已捕获异常：" + Log.getStackTraceString((Throwable) obj);
            } else {
                strArr[i] = obj.toString();
            }
        }
        return TextUtils.join("; ", strArr);
    }

    private static void a(String str, c cVar) {
        if (cVar == null) {
            return;
        }
        if (str == null || str.length() <= a) {
            cVar.a(str);
            return;
        }
        int i = 0;
        while (true) {
            int length = str.length();
            int i2 = a;
            if (i > length / i2) {
                return;
            }
            int i3 = i * i2;
            i++;
            cVar.a(str.substring(i3, Math.min(i2 * i, str.length())));
        }
    }

    @Override // c1m.m2a.m1g.a
    public void a(String str, Object... objArr) {
        if (b > 3) {
            a(a(objArr), new a(this, str));
        }
    }

    @Override // c1m.m2a.m1g.a
    public void b(String str, Object... objArr) {
        if (b > 2) {
            a(a(objArr), new b(this, str));
        }
    }

    @Override // c1m.m2a.m1g.a
    public void setLogLevel(int i) {
        b = i;
    }
}
