package com.anythink.basead.ui.guidetoclickv2;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.anythink.basead.b.e;
import com.anythink.basead.g.f;
import com.anythink.basead.ui.improveclick.g;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.h.y;
import com.anythink.core.common.v.m;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    Queue<b> a;
    Map<String, Object> b;
    BaseG2CV2View.b c = new BaseG2CV2View.b() { // from class: com.anythink.basead.ui.guidetoclickv2.a.1
        @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View.b
        public final void a() {
            a.this.f();
        }

        @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View.b
        public final void b() {
            Object obj;
            if (a.this.b != null && (obj = a.this.b.get(g.a.c)) != null && (obj instanceof f)) {
                ((f) obj).onATImproveClickViewRenderFail(2);
            }
            a.this.c();
        }
    };
    private Context d;
    private w e;
    private x f;
    private RelativeLayout g;
    private int h;
    private View i;
    private b j;
    private com.anythink.basead.ui.improveclick.c.a k;

    /* JADX INFO: renamed from: com.anythink.basead.ui.guidetoclickv2.a$a, reason: collision with other inner class name */
    public static class C0062a {
        public static int a = 180;
        public static int b = 50;
    }

    public a(Context context, w wVar, x xVar, int i, RelativeLayout relativeLayout, View view, com.anythink.basead.ui.improveclick.c.a aVar) {
        this.d = context;
        this.e = wVar;
        this.f = xVar;
        this.h = i;
        this.g = relativeLayout;
        this.i = view;
        this.k = aVar;
        d();
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00b4 A[PHI: r7
      0x00b4: PHI (r7v13 boolean) = (r7v12 boolean), (r7v17 boolean), (r7v17 boolean) binds: [B:27:0x006e, B:43:0x00a5, B:45:0x00b1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:71:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:79:0x014b  */
    private void d() {
        int iF;
        int i;
        this.a = new ConcurrentLinkedQueue();
        y yVar = this.f.o;
        int i2 = 3;
        if (this.h == 3) {
            iF = yVar.A();
        } else {
            iF = m.f(this.d);
        }
        long jAt = yVar.at();
        String strAu = yVar.au();
        if (TextUtils.isEmpty(strAu)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(strAu);
            if (jSONArray.length() > 0) {
                int i3 = 0;
                while (i3 < jSONArray.length()) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i3);
                    int iOptInt = jSONObjectOptJSONObject.optInt("cgf_type", -1);
                    boolean z = true;
                    switch (iOptInt) {
                        case 1:
                        case 6:
                        case 7:
                        case 11:
                        case 12:
                            if (iOptInt != 6 || com.anythink.core.common.v.g.a().b(com.anythink.core.common.a.b.d.i)) {
                                z = false;
                            }
                            break;
                        case 2:
                            if (!e.a(this.e, this.f) && ((i = this.h) == 1 || i == i2)) {
                                z = false;
                            }
                            break;
                        case 3:
                            int i4 = this.h;
                            if (i4 == 1 || i4 == i2) {
                                z = false;
                            }
                            break;
                        case 4:
                        case 5:
                            int i5 = this.h;
                            if ((i5 == 1 || i5 == 2 || i5 == i2) && this.i != null) {
                                z = false;
                            }
                            break;
                        case 8:
                        case 9:
                        case 10:
                            boolean z2 = (this.f.j == 1 && iF == 1) ? false : true;
                            if (!z2) {
                                if (iOptInt == 9 && !com.anythink.core.common.v.g.a().b(com.anythink.core.common.a.b.d.f)) {
                                    z2 = true;
                                }
                                if ((iOptInt == 8 || iOptInt == 10) && !com.anythink.core.common.v.g.a().b(com.anythink.core.common.a.b.d.k)) {
                                    z2 = true;
                                }
                                if (iOptInt == 10 && !com.anythink.core.common.v.g.a().b(com.anythink.core.common.a.b.d.l)) {
                                    z2 = true;
                                }
                                if (iOptInt != 8 || com.anythink.core.common.v.g.a().b(com.anythink.core.common.a.b.d.m)) {
                                    z = z2;
                                }
                            } else {
                                z = z2;
                            }
                            break;
                        case 13:
                            if ((this.f.j == 4 || this.f.j == i2) && iF == 1) {
                                z = false;
                            }
                            break;
                    }
                    if (!z) {
                        long jOptLong = jSONObjectOptJSONObject.optLong("cgf_st", -1L);
                        if (iOptInt > 0 && jOptLong >= 0) {
                            this.a.add(new b(this.d, this.e, this.f, this.h, new b.a(i3 + 1, iOptInt, jAt, jOptLong, yVar.av(), iF), this.g, this.i, this.k, this.c));
                        }
                    }
                    i3++;
                    yVar = yVar;
                    i2 = 3;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void a() {
        e();
    }

    public final void b() {
        b bVar = this.j;
        if (bVar != null) {
            bVar.b();
        }
    }

    private void e() {
        b bVar = this.j;
        if (bVar != null) {
            bVar.a();
        } else {
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        g();
        if (this.a.size() > 0) {
            this.j = this.a.poll();
            e();
        }
    }

    private void g() {
        b bVar = this.j;
        if (bVar != null) {
            bVar.c();
            this.j = null;
        }
    }

    public final void c() {
        b bVar = this.j;
        if (bVar != null) {
            bVar.b();
        }
        g();
        Queue<b> queue = this.a;
        if (queue != null) {
            queue.clear();
        }
    }

    private boolean a(int i, int i2) {
        switch (i) {
            case 1:
            case 6:
            case 7:
            case 11:
            case 12:
                return i == 6 && !com.anythink.core.common.v.g.a().b(com.anythink.core.common.a.b.d.i);
            case 2:
                if (e.a(this.e, this.f)) {
                    return true;
                }
                int i3 = this.h;
                return (i3 == 1 || i3 == 3) ? false : true;
            case 3:
                int i4 = this.h;
                return (i4 == 1 || i4 == 3) ? false : true;
            case 4:
            case 5:
                int i5 = this.h;
                return !(i5 == 1 || i5 == 2 || i5 == 3) || this.i == null;
            case 8:
            case 9:
            case 10:
                boolean z = (this.f.j == 1 && i2 == 1) ? false : true;
                if (z) {
                    return z;
                }
                if (i == 9 && !com.anythink.core.common.v.g.a().b(com.anythink.core.common.a.b.d.f)) {
                    z = true;
                }
                if ((i == 8 || i == 10) && !com.anythink.core.common.v.g.a().b(com.anythink.core.common.a.b.d.k)) {
                    z = true;
                }
                if (i == 10 && !com.anythink.core.common.v.g.a().b(com.anythink.core.common.a.b.d.l)) {
                    z = true;
                }
                if (i != 8 || com.anythink.core.common.v.g.a().b(com.anythink.core.common.a.b.d.m)) {
                    return z;
                }
                return true;
            case 13:
                return ((this.f.j == 4 || this.f.j == 3) && i2 == 1) ? false : true;
            default:
                return true;
        }
    }

    public final void a(Map<String, Object> map) {
        this.b = map;
    }
}
