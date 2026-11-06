package com.smartdigimkt.n4;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.d.t;
import com.smartdigimkt.l4.b0;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements com.smartdigimkt.k4.a {
    public final b a;
    public final f b;
    public final com.smartdigimkt.k4.d c;
    public final String d;
    public final int e;

    public e(com.smartdigimkt.k4.d dVar) {
        this.c = dVar;
        this.d = dVar.b;
        this.e = dVar.c;
        this.a = d.a(dVar);
        this.b = new f(dVar);
    }

    @Override // com.smartdigimkt.k4.a
    public final void a(Object obj, String str) {
        com.smartdigimkt.k4.d dVar = this.c;
        if (dVar != null) {
            a(str, obj, dVar.d);
        } else {
            a(str, obj, 1);
        }
    }

    @Override // com.smartdigimkt.k4.a
    public final Object b(Object obj, String str) {
        f fVar;
        b bVarA = null;
        if (a(str)) {
            com.smartdigimkt.k4.d dVar = this.c;
            if (dVar != null) {
                int i = dVar.d;
                Context context = dVar.a;
                int i2 = dVar.c;
                TextUtils.isEmpty("sdm_adx_rp_place_data_tkv");
                bVarA = d.a(new com.smartdigimkt.k4.d(context, "sdm_adx_rp_place_data_tkv", i2, i));
            }
            return bVarA != null ? bVarA.b(obj, str) : obj;
        }
        if (this.e == 0 && (fVar = this.b) != null) {
            return fVar.b(obj, str);
        }
        b bVar = this.a;
        if (bVar == null) {
            return obj;
        }
        Object objB = bVar.b(obj, str);
        if (objB != null && objB != obj) {
            return objB;
        }
        f fVar2 = this.b;
        if (fVar2 != null) {
            return fVar2.b(obj, str);
        }
        return null;
    }

    @Override // com.smartdigimkt.k4.a
    public final void clear() {
        b bVar;
        if (this.e == 1 && (bVar = this.a) != null) {
            bVar.clear();
            return;
        }
        f fVar = this.b;
        if (fVar != null) {
            fVar.clear();
        }
    }

    @Override // com.smartdigimkt.k4.a
    public final Map getAll() {
        b bVar;
        if (this.e == 1 && (bVar = this.a) != null) {
            return bVar.getAll();
        }
        f fVar = this.b;
        if (fVar != null) {
            return fVar.getAll();
        }
        return null;
    }

    @Override // com.smartdigimkt.k4.a
    public final void remove(String str) {
        b bVar;
        b bVarA;
        if (!a(str)) {
            if (this.e == 1 && (bVar = this.a) != null) {
                bVar.remove(str);
                return;
            }
            f fVar = this.b;
            if (fVar != null) {
                fVar.remove(str);
                return;
            }
            return;
        }
        com.smartdigimkt.k4.d dVar = this.c;
        if (dVar != null) {
            int i = dVar.d;
            Context context = dVar.a;
            int i2 = dVar.c;
            TextUtils.isEmpty("sdm_adx_rp_place_data_tkv");
            bVarA = d.a(new com.smartdigimkt.k4.d(context, "sdm_adx_rp_place_data_tkv", i2, i));
        } else {
            bVarA = null;
        }
        if (bVarA != null) {
            bVarA.remove(str);
        }
    }

    @Override // com.smartdigimkt.k4.a
    public final void a(String str, Object obj, int i) {
        b bVar;
        b bVarA;
        if (a(str)) {
            com.smartdigimkt.k4.d dVar = this.c;
            if (dVar == null) {
                bVarA = null;
            } else {
                Context context = dVar.a;
                int i2 = dVar.c;
                TextUtils.isEmpty("sdm_adx_rp_place_data_tkv");
                bVarA = d.a(new com.smartdigimkt.k4.d(context, "sdm_adx_rp_place_data_tkv", i2, i));
            }
            if (bVarA != null) {
                bVarA.a(str, obj, bVarA.b);
                return;
            }
            return;
        }
        if (this.e == 1 && (bVar = this.a) != null) {
            bVar.a(str, obj, i);
            return;
        }
        f fVar = this.b;
        if (fVar != null) {
            fVar.a(str, obj, i);
        }
    }

    @Override // com.smartdigimkt.k4.a
    public final void a(HashMap map) {
        b bVar;
        b0 b0Var;
        b bVar2;
        b0 b0Var2;
        com.smartdigimkt.k4.d dVar = this.c;
        if (dVar != null) {
            int i = dVar.d;
            if (this.e == 1 && (bVar2 = this.a) != null) {
                if (map.isEmpty() || (b0Var2 = bVar2.a) == null) {
                    return;
                }
                try {
                    b0Var2.a(map);
                    bVar2.a(i);
                    return;
                } catch (Throwable th) {
                    th.getMessage();
                    return;
                }
            }
            f fVar = this.b;
            if (fVar != null) {
                fVar.a(i, map);
                return;
            }
            return;
        }
        if (this.e == 1 && (bVar = this.a) != null) {
            if (map.isEmpty() || (b0Var = bVar.a) == null) {
                return;
            }
            try {
                b0Var.a(map);
                bVar.a(1);
                return;
            } catch (Throwable th2) {
                th2.getMessage();
                return;
            }
        }
        f fVar2 = this.b;
        if (fVar2 != null) {
            fVar2.a(1, map);
        }
    }

    public final boolean a(String str) {
        com.smartdigimkt.k4.c.a().getClass();
        return !TextUtils.isEmpty(str) && (str.endsWith(t.a.n) || str.endsWith(t.a.m)) && "sdm_adx_rp_sdk".equals(this.d);
    }
}
