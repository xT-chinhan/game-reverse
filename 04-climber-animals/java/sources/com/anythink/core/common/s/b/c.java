package com.anythink.core.common.s.b;

import android.text.TextUtils;
import com.anythink.core.common.d.u;
import com.anythink.core.common.s.a.g;
import com.anythink.core.common.s.a.j;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c implements com.anythink.core.common.s.a {
    private static final String a = "c";
    private final String b;
    private boolean c;
    private final com.anythink.core.common.s.a.a d;
    private final int e;

    public c(com.anythink.core.common.s.c cVar) {
        j.a aVar = new j.a(cVar.a(), cVar.b());
        aVar.a();
        j jVarB = aVar.b();
        this.d = jVarB;
        this.e = cVar.d();
        String strB = cVar.b();
        this.b = strB;
        if (strB.endsWith(u.a)) {
            this.c = true;
        } else {
            this.c = jVarB.getBoolean(u.a.a, false);
        }
    }

    private static com.anythink.core.common.s.a.a a(com.anythink.core.common.s.c cVar) {
        j.a aVar = new j.a(cVar.a(), cVar.b());
        aVar.a();
        return aVar.b();
    }

    @Override // com.anythink.core.common.s.a
    public final <V> void a(String str, V v) {
        a(str, v, this.e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.anythink.core.common.s.a
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
            } else {
                Object[] objArr = new Object[2];
            }
            a(i);
            Object[] objArr2 = new Object[2];
        } catch (Throwable th) {
            Object[] objArr3 = new Object[1];
            th.getMessage();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [V] */
    /* JADX WARN: Type inference failed for: r5v1, types: [V] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // com.anythink.core.common.s.a
    public final <V> V b(String str, V v) {
        com.anythink.core.common.s.a.a aVar;
        Object objD;
        ?? r5 = v;
        r5 = v;
        if (!TextUtils.isEmpty(str) && v != 0 && (aVar = this.d) != null) {
            try {
                r5 = v;
                if (v instanceof String) {
                    objD = aVar.getString(str, (String) v);
                } else if (v instanceof Integer) {
                    objD = Integer.valueOf(aVar.getInt(str, ((Integer) v).intValue()));
                } else if (v instanceof Long) {
                    objD = Long.valueOf(aVar.getLong(str, ((Long) v).longValue()));
                } else if (v instanceof Double) {
                    objD = Double.valueOf(aVar.a(str, ((Double) v).doubleValue()));
                } else if (v instanceof Float) {
                    objD = Float.valueOf(aVar.getFloat(str, ((Float) v).floatValue()));
                } else if (v instanceof Boolean) {
                    objD = Boolean.valueOf(aVar.getBoolean(str, ((Boolean) v).booleanValue()));
                } else {
                    if (v instanceof Object) {
                        v = v;
                        Object[] objArr = new Object[2];
                        objD = aVar.d(str);
                    }
                    v = v;
                    Object[] objArr2 = new Object[3];
                    r5 = v;
                }
                v = (V) objD;
                v = v;
                Object[] objArr3 = new Object[3];
                r5 = v;
            } catch (Throwable th) {
                Object[] objArr4 = new Object[1];
                th.getMessage();
                r5 = v;
            }
        }
        r5 = v;
        return (V) r5;
    }

    @Override // com.anythink.core.common.s.a
    public final void b(String str) {
        com.anythink.core.common.s.a.a aVar = this.d;
        if (aVar != null) {
            aVar.remove(str);
            a(this.e);
        }
    }

    @Override // com.anythink.core.common.s.a
    public final void b() {
        com.anythink.core.common.s.a.a aVar = this.d;
        if (aVar != null) {
            aVar.clear();
        }
    }

    @Override // com.anythink.core.common.s.a
    public final Map<String, Object> a() {
        com.anythink.core.common.s.a.a aVar = this.d;
        if (aVar != null) {
            return aVar.getAll();
        }
        return null;
    }

    @Override // com.anythink.core.common.s.a
    public final boolean a(String str) {
        com.anythink.core.common.s.a.a aVar = this.d;
        return aVar != null && aVar.contains(str);
    }

    public final boolean c() {
        Object[] objArr = new Object[2];
        Boolean.valueOf(this.c);
        return this.c;
    }

    public final void d() {
        this.c = true;
        a(u.a.a, Boolean.TRUE);
        Object[] objArr = new Object[1];
        Boolean bool = Boolean.TRUE;
    }

    private void a(int i) {
        com.anythink.core.common.s.a.a aVar = this.d;
        if (aVar == null) {
            return;
        }
        if (aVar instanceof g) {
            i = ((g) aVar).j();
        } else if ((aVar instanceof j) && i == 0) {
            i = 1;
        }
        Object[] objArr = new Object[2];
        Integer.valueOf(i);
        this.d.getClass().getSimpleName();
        if (i == 1) {
            this.d.apply();
        } else if (i == 2) {
            this.d.commit();
        }
    }
}
