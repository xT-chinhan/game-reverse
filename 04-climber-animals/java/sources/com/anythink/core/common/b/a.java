package com.anythink.core.common.b;

import android.os.Handler;
import android.text.TextUtils;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.AdError;
import com.anythink.core.common.d.m;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.s;
import com.anythink.core.common.i;
import com.anythink.core.common.m.q;
import com.anythink.core.common.u.e;
import com.anythink.core.d.d;
import com.baidu.mobads.sdk.internal.bn;
import com.taptap.sdk.db.constant.Common;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String a = "a";
    private static final long b = 1800000;
    private static volatile a c;
    private volatile Handler f;
    private C0078a h;
    private final Object e = new Object();
    private final AtomicLong g = new AtomicLong(0);
    private final c d = new b();

    private a() {
    }

    public static a a() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
            }
        }
        return c;
    }

    public final void a(com.anythink.core.d.b bVar) {
        boolean z;
        if (bVar == null || bVar.R()) {
            return;
        }
        if (!bVar.aP()) {
            this.g.set(0L);
            if (this.f != null) {
                this.f.removeCallbacksAndMessages(null);
                return;
            }
            return;
        }
        if (this.f == null) {
            synchronized (this.e) {
                if (this.f == null) {
                    this.f = com.anythink.core.common.v.b.b.a().a(18);
                }
            }
        }
        int iAQ = bVar.aQ();
        synchronized (this.e) {
            long j = this.g.get();
            this.g.set(iAQ);
            z = j == 0;
            Object[] objArr = new Object[2];
            Long.valueOf(j);
            Boolean.valueOf(z);
        }
        if (!z || this.f == null) {
            return;
        }
        this.f.removeCallbacksAndMessages(null);
        this.f.post(new Runnable() { // from class: com.anythink.core.common.b.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.a(a.this, t.b().x());
            }
        });
    }

    private void a(boolean z) {
        Object[] objArr = new Object[1];
        Boolean.valueOf(z);
        synchronized (this.e) {
            byte b2 = 0;
            try {
                if (!z) {
                    if (this.h != null) {
                        t.b().b(this.h);
                    }
                    this.h = new C0078a(this, b2);
                    t.b().a(this.h);
                    i.a();
                    e.a(com.anythink.core.d.b.a.A, com.anythink.core.common.res.image.c.a, "The application is in the background and cannot be obtained", i.q(), "", "", "", (ATAdRequest) null);
                    return;
                }
                if (this.h != null) {
                    t.b().b(this.h);
                    this.h = null;
                }
                byte[] bArrA = this.d.a(t.b().g());
                if (bArrA == null || bArrA.length == 0) {
                    return;
                }
                Object[] objArr2 = new Object[2];
                Integer.valueOf(bArrA.length);
                Long.valueOf(this.g.get());
                new com.anythink.core.common.m.c(new com.anythink.core.common.h.t(bArrA)).a(0, (q) new AnonymousClass2());
                if (this.f != null) {
                    long j = this.g.get();
                    if (j <= 0) {
                        j = b;
                    }
                    Object[] objArr3 = new Object[1];
                    Long.valueOf(j);
                    this.f.removeCallbacksAndMessages(null);
                    this.f.postDelayed(new AnonymousClass3(), j);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.b.a$2, reason: invalid class name */
    final class AnonymousClass2 extends com.anythink.core.common.m.b {
        @Override // com.anythink.core.common.m.q
        public final void onLoadError(int i, String str, AdError adError) {
        }

        AnonymousClass2() {
        }

        @Override // com.anythink.core.common.m.q
        public final void onLoadFinish(int i, Object obj) {
            if (obj instanceof JSONObject) {
                a.a((JSONObject) obj);
            }
        }
    }

    private static void b(JSONObject jSONObject) {
        try {
            com.anythink.core.d.b bVarA = d.a();
            if (bVarA != null && !bVarA.R() && jSONObject != null) {
                String strF = bVarA.f();
                Object[] objArr = new Object[2];
                jSONObject.toString();
                if (TextUtils.isEmpty(strF)) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject(strF);
                JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray(bn.l);
                ArrayList arrayList = new ArrayList();
                if (jSONArrayOptJSONArray != null) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        arrayList.add(jSONArrayOptJSONArray.optJSONObject(i).optString(Common.System.NAME));
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                List<s.a> listA = s.a(jSONObject).a();
                if (listA != null && !listA.isEmpty()) {
                    for (s.a aVar : listA) {
                        if (!arrayList.contains(aVar.a())) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put(Common.System.NAME, aVar.a());
                            arrayList2.add(jSONObject3);
                        }
                    }
                }
                if (!arrayList2.isEmpty()) {
                    if (jSONArrayOptJSONArray == null) {
                        jSONArrayOptJSONArray = new JSONArray();
                    }
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        jSONArrayOptJSONArray.put((JSONObject) it.next());
                    }
                    jSONObject2.put(bn.l, jSONArrayOptJSONArray);
                    bVarA.a(jSONObject2.toString());
                    t.b().a(bVarA);
                }
                Object[] objArr2 = new Object[1];
            }
        } catch (Throwable th) {
            Object[] objArr3 = new Object[1];
            th.getMessage();
        }
    }

    private void c() {
        if (this.f != null) {
            long j = this.g.get();
            if (j <= 0) {
                j = b;
            }
            Object[] objArr = new Object[1];
            Long.valueOf(j);
            this.f.removeCallbacksAndMessages(null);
            this.f.postDelayed(new AnonymousClass3(), j);
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.b.a$3, reason: invalid class name */
    final class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.a(a.this, t.b().x());
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.b.a$a, reason: collision with other inner class name */
    private class C0078a implements m {
        private C0078a() {
        }

        /* synthetic */ C0078a(a aVar, byte b) {
            this();
        }

        @Override // com.anythink.core.common.d.m
        public final void a(boolean z) {
            String unused = a.a;
            Object[] objArr = new Object[1];
            Boolean.valueOf(z);
            if (z) {
                a.a(a.this, true);
            }
        }
    }

    static /* synthetic */ void a(a aVar, boolean z) {
        Object[] objArr = new Object[1];
        Boolean.valueOf(z);
        synchronized (aVar.e) {
            byte b2 = 0;
            try {
                if (!z) {
                    if (aVar.h != null) {
                        t.b().b(aVar.h);
                    }
                    aVar.h = new C0078a(aVar, b2);
                    t.b().a(aVar.h);
                    i.a();
                    e.a(com.anythink.core.d.b.a.A, com.anythink.core.common.res.image.c.a, "The application is in the background and cannot be obtained", i.q(), "", "", "", (ATAdRequest) null);
                    return;
                }
                if (aVar.h != null) {
                    t.b().b(aVar.h);
                    aVar.h = null;
                }
                byte[] bArrA = aVar.d.a(t.b().g());
                if (bArrA == null || bArrA.length == 0) {
                    return;
                }
                Object[] objArr2 = new Object[2];
                Integer.valueOf(bArrA.length);
                Long.valueOf(aVar.g.get());
                new com.anythink.core.common.m.c(new com.anythink.core.common.h.t(bArrA)).a(0, (q) aVar.new AnonymousClass2());
                if (aVar.f != null) {
                    long j = aVar.g.get();
                    if (j <= 0) {
                        j = b;
                    }
                    Object[] objArr3 = new Object[1];
                    Long.valueOf(j);
                    aVar.f.removeCallbacksAndMessages(null);
                    aVar.f.postDelayed(aVar.new AnonymousClass3(), j);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static /* synthetic */ void a(JSONObject jSONObject) {
        try {
            com.anythink.core.d.b bVarA = d.a();
            if (bVarA != null && !bVarA.R() && jSONObject != null) {
                String strF = bVarA.f();
                Object[] objArr = new Object[2];
                jSONObject.toString();
                if (TextUtils.isEmpty(strF)) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject(strF);
                JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray(bn.l);
                ArrayList arrayList = new ArrayList();
                if (jSONArrayOptJSONArray != null) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        arrayList.add(jSONArrayOptJSONArray.optJSONObject(i).optString(Common.System.NAME));
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                List<s.a> listA = s.a(jSONObject).a();
                if (listA != null && !listA.isEmpty()) {
                    for (s.a aVar : listA) {
                        if (!arrayList.contains(aVar.a())) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put(Common.System.NAME, aVar.a());
                            arrayList2.add(jSONObject3);
                        }
                    }
                }
                if (!arrayList2.isEmpty()) {
                    if (jSONArrayOptJSONArray == null) {
                        jSONArrayOptJSONArray = new JSONArray();
                    }
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        jSONArrayOptJSONArray.put((JSONObject) it.next());
                    }
                    jSONObject2.put(bn.l, jSONArrayOptJSONArray);
                    bVarA.a(jSONObject2.toString());
                    t.b().a(bVarA);
                }
                Object[] objArr2 = new Object[1];
            }
        } catch (Throwable th) {
            Object[] objArr3 = new Object[1];
            th.getMessage();
        }
    }
}
