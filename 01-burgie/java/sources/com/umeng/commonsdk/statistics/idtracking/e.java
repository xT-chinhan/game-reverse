package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.taptap.sdk.db.constant.Common;
import com.umeng.analytics.pro.az;
import com.umeng.analytics.pro.bf;
import com.umeng.analytics.pro.z;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: IdTracker.java */
/* JADX INFO: loaded from: classes3.dex */
public class e {
    public static final long a = 86400000;
    public static e b;
    private static final String c = z.b().b("id");
    private static Object j = new Object();
    private File d;
    private long f;
    private a i;
    private com.umeng.commonsdk.statistics.proto.c e = null;
    private Set<com.umeng.commonsdk.statistics.idtracking.a> h = new HashSet();
    private long g = 86400000;

    public static synchronized void a() {
        if (b != null) {
            b.e();
            b = null;
        }
    }

    e(Context context) {
        this.i = null;
        this.d = new File(context.getFilesDir(), c);
        this.i = new a(context);
        this.i.b();
    }

    public static synchronized e a(Context context) {
        if (b == null) {
            b = new e(context);
            b.a(new f(context));
            b.a(new b(context));
            b.a(new j(context));
            b.a(new d(context));
            b.a(new c(context));
            b.a(new g(context));
            b.a(new i());
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
                b.a(new h(context));
            }
            b.f();
        }
        return b;
    }

    private boolean a(com.umeng.commonsdk.statistics.idtracking.a aVar) throws Throwable {
        if (this.i.a(aVar.b())) {
            return this.h.add(aVar);
        }
        if (AnalyticsConstants.UM_DEBUG) {
            MLog.w("invalid domain: " + aVar.b());
            return false;
        }
        return false;
    }

    public void a(long j2) {
        this.g = j2;
    }

    public synchronized void b() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f >= this.g) {
            boolean z = false;
            for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.h) {
                if (aVar.c()) {
                    if (aVar.a()) {
                        z = true;
                        if (!aVar.c()) {
                            this.i.b(aVar.b());
                        }
                    }
                }
            }
            if (z) {
                h();
                this.i.a();
                g();
            }
            this.f = jCurrentTimeMillis;
        }
    }

    public synchronized com.umeng.commonsdk.statistics.proto.c c() {
        return this.e;
    }

    private synchronized void h() {
        com.umeng.commonsdk.statistics.proto.c cVar = new com.umeng.commonsdk.statistics.proto.c();
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.h) {
            if (aVar.c()) {
                if (aVar.d() != null) {
                    map.put(aVar.b(), aVar.d());
                }
                if (aVar.e() != null && !aVar.e().isEmpty()) {
                    arrayList.addAll(aVar.e());
                }
            }
        }
        cVar.a(arrayList);
        cVar.a(map);
        synchronized (this) {
            this.e = cVar;
        }
    }

    public String d() {
        return null;
    }

    public synchronized void e() {
        if (b == null) {
            return;
        }
        boolean z = false;
        for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.h) {
            if (aVar.c()) {
                if (aVar.e() != null && !aVar.e().isEmpty()) {
                    aVar.a((List<com.umeng.commonsdk.statistics.proto.a>) null);
                    z = true;
                }
            }
        }
        if (z) {
            this.e.b(false);
            g();
        }
    }

    public synchronized void f() {
        com.umeng.commonsdk.statistics.proto.c cVarI = i();
        if (cVarI == null) {
            return;
        }
        a(cVarI);
        ArrayList arrayList = new ArrayList(this.h.size());
        synchronized (this) {
            this.e = cVarI;
            for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.h) {
                aVar.a(this.e);
                if (!aVar.c()) {
                    arrayList.add(aVar);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.h.remove((com.umeng.commonsdk.statistics.idtracking.a) it.next());
            }
            h();
        }
    }

    public synchronized void g() {
        if (this.e != null) {
            b(this.e);
        }
    }

    private com.umeng.commonsdk.statistics.proto.c i() {
        Throwable th;
        FileInputStream fileInputStream;
        synchronized (j) {
            if (!this.d.exists()) {
                return null;
            }
            try {
                fileInputStream = new FileInputStream(this.d);
                try {
                    try {
                        byte[] streamToByteArray = HelperUtils.readStreamToByteArray(fileInputStream);
                        com.umeng.commonsdk.statistics.proto.c cVar = new com.umeng.commonsdk.statistics.proto.c();
                        new az().a(cVar, streamToByteArray);
                        HelperUtils.safeClose(fileInputStream);
                        return cVar;
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        HelperUtils.safeClose(fileInputStream);
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    HelperUtils.safeClose(fileInputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                HelperUtils.safeClose(fileInputStream);
                throw th;
            }
        }
    }

    private void a(com.umeng.commonsdk.statistics.proto.c cVar) {
        if (cVar != null && cVar.a != null) {
            if (cVar.a.containsKey("mac") && !FieldManager.allow(com.umeng.commonsdk.utils.d.h)) {
                cVar.a.remove("mac");
            }
            if (cVar.a.containsKey("imei") && !FieldManager.allow(com.umeng.commonsdk.utils.d.g)) {
                cVar.a.remove("imei");
            }
            if (cVar.a.containsKey(Common.Predefined.SUB_ANDROID_ID) && !FieldManager.allow(com.umeng.commonsdk.utils.d.i)) {
                cVar.a.remove(Common.Predefined.SUB_ANDROID_ID);
            }
            if (cVar.a.containsKey("serial") && !FieldManager.allow(com.umeng.commonsdk.utils.d.j)) {
                cVar.a.remove("serial");
            }
            if (cVar.a.containsKey("idfa") && !FieldManager.allow(com.umeng.commonsdk.utils.d.w)) {
                cVar.a.remove("idfa");
            }
            if (cVar.a.containsKey("oaid") && !FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
                cVar.a.remove("oaid");
            }
        }
    }

    private void b(com.umeng.commonsdk.statistics.proto.c cVar) {
        byte[] bArrA;
        synchronized (j) {
            if (cVar != null) {
                try {
                    synchronized (this) {
                        a(cVar);
                        bArrA = new bf().a(cVar);
                    }
                    if (bArrA != null) {
                        HelperUtils.writeFile(this.d, bArrA);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: compiled from: IdTracker.java */
    public static class a {
        private Context a;
        private Set<String> b = new HashSet();

        public a(Context context) {
            this.a = context;
        }

        public synchronized boolean a(String str) {
            return !this.b.contains(str);
        }

        public synchronized void b(String str) {
            this.b.add(str);
        }

        public void c(String str) {
            this.b.remove(str);
        }

        public synchronized void a() {
            if (!this.b.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<String> it = this.b.iterator();
                while (it.hasNext()) {
                    sb.append(it.next());
                    sb.append(AbstractJsonLexerKt.COMMA);
                }
                sb.deleteCharAt(sb.length() - 1);
                PreferenceWrapper.getDefault(this.a).edit().putString("invld_id", sb.toString()).commit();
            }
        }

        public synchronized void b() {
            String[] strArrSplit;
            String string = PreferenceWrapper.getDefault(this.a).getString("invld_id", null);
            if (!TextUtils.isEmpty(string) && (strArrSplit = string.split(",")) != null) {
                for (String str : strArrSplit) {
                    if (!TextUtils.isEmpty(str)) {
                        this.b.add(str);
                    }
                }
            }
        }
    }
}
