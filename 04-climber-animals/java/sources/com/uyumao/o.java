package com.uyumao;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: SharedPrefs.java */
/* JADX INFO: loaded from: classes4.dex */
public class o {
    public static volatile o a;
    public final Context b;
    public final a c = new a(this, "AZX");

    public o(Context context) {
        this.b = context.getApplicationContext();
    }

    public void a(long j) {
        this.c.b("smart_interval", j);
        this.c.b("smart_ts", System.currentTimeMillis());
    }

    public final boolean a(String str) {
        long jA = this.c.a(str + "interval", 0L);
        if (jA > 0) {
            return Math.abs(System.currentTimeMillis() - this.c.a(new StringBuilder().append(str).append("ts").toString(), 0L)) / 1000 >= jA;
        }
        return true;
    }

    public long a() {
        return this.c.a("smart_lc", 0L);
    }

    /* JADX INFO: compiled from: SharedPrefs.java */
    public class a {
        public final String a;

        public a(o oVar, String str) {
            this.a = TextUtils.isEmpty(str) ? str : str + "_";
        }

        public final void a(String str, String str2) {
            try {
                if (n.c(e.a)) {
                    m mVarA = m.a();
                    mVarA.getClass();
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    mVarA.b.edit().putString(str, str2).apply();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void b(String str, long j) {
            a(this.a + str, String.valueOf(j));
        }

        public long a(String str, long j) {
            String str2 = this.a + str;
            String strValueOf = String.valueOf(j);
            try {
                if (n.c(e.a)) {
                    strValueOf = m.a().b.getString(str2, strValueOf);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                return Long.parseLong(strValueOf);
            } catch (Exception unused) {
                return j;
            }
        }
    }
}
