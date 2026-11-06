package com.smartdigimkt.o4;

import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.r4.y;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public final class l {
    public static l m;
    public j a;
    public final HashMap b = new HashMap();
    public long c;
    public int d;
    public long e;
    public int f;
    public long g;
    public int h;
    public long i;
    public int j;
    public boolean k;
    public String l;

    public l() {
        try {
            Context contextD = SDKContext.getInstance().d();
            if (contextD != null) {
                String strC = y.c(contextD, "interaction_control", "last_save_date");
                String strA = a(System.currentTimeMillis());
                if (TextUtils.equals(strC, strA)) {
                    String strC2 = y.c(contextD, "interaction_control", "daily_count_day");
                    if (!TextUtils.isEmpty(strC2)) {
                        strC = strC2;
                    }
                    if (TextUtils.equals(strC, strA)) {
                        this.c = y.b(contextD, "interaction_control", "sp_cross_last_time");
                        this.d = y.a(contextD, "interaction_control", "sp_cross_daily_count");
                        this.e = y.b(contextD, "interaction_control", "sp_shake_last_time");
                        this.f = y.a(contextD, "interaction_control", "sp_shake_daily_count");
                        this.g = y.b(contextD, "interaction_control", "sp_swipe_last_time");
                        this.h = y.a(contextD, "interaction_control", "sp_swipe_daily_count");
                        this.i = y.b(contextD, "interaction_control", "sp_twist_last_time");
                        this.j = y.a(contextD, "interaction_control", "sp_twist_daily_count");
                        this.l = strA;
                    } else {
                        c();
                    }
                } else {
                    c();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized l b() {
        if (m == null) {
            synchronized (l.class) {
                if (m == null) {
                    m = new l();
                }
            }
        }
        return m;
    }

    public final void a(m mVar) {
        Object objValueOf;
        try {
            Objects.toString(mVar.a);
            j jVar = mVar.a;
            this.a = jVar;
            Objects.toString(jVar);
            ArrayList arrayList = mVar.b;
            if (arrayList != null) {
                arrayList.size();
            }
            ArrayList<i> arrayList2 = mVar.b;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                this.b.clear();
                for (i iVar : arrayList2) {
                    this.b.put(Integer.valueOf(iVar.a), iVar);
                    iVar.toString();
                }
            }
            j jVar2 = this.a;
            if (jVar2 != null) {
                boolean z = true;
                if (jVar2.a != 1) {
                    z = false;
                }
                objValueOf = Boolean.valueOf(z);
            } else {
                objValueOf = AbstractJsonLexerKt.NULL;
            }
            objValueOf.toString();
            this.b.size();
        } catch (Throwable unused) {
        }
    }

    public final void c() {
        try {
            this.c = 0L;
            this.d = 0;
            this.e = 0L;
            this.f = 0;
            this.g = 0L;
            this.h = 0;
            this.i = 0L;
            this.j = 0;
            this.l = a(System.currentTimeMillis());
            com.smartdigimkt.q3.f.a().a(new k(this), 1);
        } catch (Throwable unused) {
        }
    }

    public final boolean a() {
        try {
            j jVar = this.a;
            if (jVar != null && jVar.a == 1) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                j jVar2 = this.a;
                if (jCurrentTimeMillis - this.c < jVar2.b * 1000 || this.d >= jVar2.c) {
                    return false;
                }
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    public final int a(int i) {
        int i2;
        int i3 = 0;
        try {
            if (i == 1) {
                i2 = this.f;
            } else if (i == 2) {
                i2 = this.h;
            } else {
                if (i != 3) {
                    return 0;
                }
                i2 = this.j;
            }
            i3 = i2;
            return i3;
        } catch (Throwable unused) {
            return i3;
        }
    }

    public static String a(long j) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j);
            return String.format("%04d%02d%02d", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)));
        } catch (Throwable unused) {
            return "19700101";
        }
    }
}
