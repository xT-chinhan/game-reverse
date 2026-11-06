package com.anythink.core.common.r.b;

import android.text.TextUtils;
import com.anythink.core.common.d.t;
import com.anythink.core.common.r.a.g;
import com.anythink.core.common.r.a.j;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c implements com.anythink.core.common.r.a {
    private static final String a = "c";
    private final String b;
    private boolean c;
    private final com.anythink.core.common.r.a.a d;
    private final int e;

    public c(com.anythink.core.common.r.c cVar) {
        j.a aVar = new j.a(cVar.a(), cVar.b());
        aVar.a();
        j jVarB = aVar.b();
        this.d = jVarB;
        this.e = cVar.d();
        String strB = cVar.b();
        this.b = strB;
        if (strB.endsWith(t.a)) {
            this.c = true;
        } else {
            this.c = jVarB.getBoolean(t.a.a, false);
        }
    }

    private static com.anythink.core.common.r.a.a a(com.anythink.core.common.r.c cVar) {
        j.a aVar = new j.a(cVar.a(), cVar.b());
        aVar.a();
        return aVar.b();
    }

    @Override // com.anythink.core.common.r.a
    public final <V> void a(String str, V v) {
        a(str, v, this.e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.anythink.core.common.r.a
    public final <V> void a(String str, V v, int i) {
        if (TextUtils.isEmpty(str) || v == 0 || this.d == null) {
            return;
        }
        try {
            String string = v.toString();
            if (v instanceof String) {
                this.d.putString(str, (String) v);
            } else if (v instanceof Integer) {
                this.d.putInt(str, Integer.parseInt(string));
            } else if (v instanceof Long) {
                this.d.putLong(str, Long.parseLong(string));
            } else if (v instanceof Double) {
                this.d.b(str, Double.parseDouble(string));
            } else if (v instanceof Float) {
                this.d.putFloat(str, Float.parseFloat(string));
            } else if (v instanceof Boolean) {
                this.d.putBoolean(str, Boolean.parseBoolean(string));
            }
            a(i);
        } catch (Throwable unused) {
        }
    }

    @Override // com.anythink.core.common.r.a
    public final void a(Map<String, Object> map) {
        a(map, this.e);
    }

    @Override // com.anythink.core.common.r.a
    public final void a(Map<String, Object> map, int i) {
        com.anythink.core.common.r.a.a aVar;
        if (map == null || map.isEmpty() || (aVar = this.d) == null) {
            return;
        }
        try {
            aVar.a(map, (Map<Class, com.anythink.core.common.r.a.a.b>) null);
            a(i);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [V] */
    /* JADX WARN: Type inference failed for: r5v1, types: [V] */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // com.anythink.core.common.r.a
    public final <V> V b(String str, V v) {
        com.anythink.core.common.r.a.a aVar;
        if (!TextUtils.isEmpty(str) && v != 0 && (aVar = this.d) != null) {
            try {
                if (v instanceof String) {
                    v = (V) aVar.getString(str, (String) v);
                } else if (v instanceof Integer) {
                    v = (V) Integer.valueOf(aVar.getInt(str, ((Integer) v).intValue()));
                } else if (v instanceof Long) {
                    v = (V) Long.valueOf(aVar.getLong(str, ((Long) v).longValue()));
                } else if (v instanceof Double) {
                    v = (V) Double.valueOf(aVar.a(str, ((Double) v).doubleValue()));
                } else if (v instanceof Float) {
                    v = (V) Float.valueOf(aVar.getFloat(str, ((Float) v).floatValue()));
                } else if (v instanceof Boolean) {
                    v = (V) Boolean.valueOf(aVar.getBoolean(str, ((Boolean) v).booleanValue()));
                } else if (v instanceof Object) {
                    v = v;
                    v = (V) aVar.d(str);
                }
                v = v;
            } catch (Throwable unused) {
            }
        }
        return (V) v;
    }

    @Override // com.anythink.core.common.r.a
    public final void b(String str) {
        com.anythink.core.common.r.a.a aVar = this.d;
        if (aVar != null) {
            aVar.remove(str);
            a(this.e);
        }
    }

    @Override // com.anythink.core.common.r.a
    public final void b() {
        com.anythink.core.common.r.a.a aVar = this.d;
        if (aVar != null) {
            aVar.clear();
        }
    }

    @Override // com.anythink.core.common.r.a
    public final Map<String, Object> a() {
        com.anythink.core.common.r.a.a aVar = this.d;
        if (aVar != null) {
            return aVar.getAll();
        }
        return null;
    }

    @Override // com.anythink.core.common.r.a
    public final boolean a(String str) {
        com.anythink.core.common.r.a.a aVar = this.d;
        return aVar != null && aVar.contains(str);
    }

    public final boolean d() {
        return this.c;
    }

    public final void e() {
        this.c = true;
        a(t.a.a, Boolean.TRUE);
    }

    private void a(int i) {
        com.anythink.core.common.r.a.a aVar = this.d;
        if (aVar == null) {
            return;
        }
        if (aVar instanceof g) {
            i = ((g) aVar).j();
        } else if ((aVar instanceof j) && i == 0) {
            i = 1;
        }
        if (i == 1) {
            this.d.apply();
        } else if (i == 2) {
            this.d.commit();
        }
    }

    @Override // com.anythink.core.common.r.a
    public final int c() {
        com.anythink.core.common.r.a.a aVar = this.d;
        if (aVar instanceof j) {
            return ((j) aVar).j();
        }
        return 0;
    }
}
