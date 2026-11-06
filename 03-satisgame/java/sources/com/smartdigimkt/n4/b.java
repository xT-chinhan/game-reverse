package com.smartdigimkt.n4;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.smartdigimkt.l4.b0;
import com.smartdigimkt.l4.g;
import com.smartdigimkt.l4.t;
import com.smartdigimkt.l4.w;
import com.smartdigimkt.l4.z;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.smartdigimkt.k4.a {
    public final b0 a;
    public final int b;

    public b(com.smartdigimkt.k4.d dVar) {
        b0 b0Var;
        z zVar = new z(dVar.a, dVar.b);
        zVar.c = false;
        if (TextUtils.isEmpty(zVar.a) || TextUtils.isEmpty(zVar.b)) {
            b0Var = null;
        } else {
            String str = zVar.a + zVar.b;
            ConcurrentHashMap concurrentHashMap = z.d;
            b0Var = (b0) concurrentHashMap.get(str);
            if (b0Var == null) {
                synchronized (z.class) {
                    b0Var = (b0) concurrentHashMap.get(str);
                    if (b0Var == null) {
                        b0Var = new b0(zVar.a, zVar.b, zVar.c);
                        concurrentHashMap.put(str, b0Var);
                    }
                }
            }
        }
        this.a = b0Var;
        this.b = dVar.d;
    }

    @Override // com.smartdigimkt.k4.a
    public final void a(Object obj, String str) {
        a(str, obj, this.b);
    }

    @Override // com.smartdigimkt.k4.a
    public final Object b(Object obj, String str) {
        b0 b0Var;
        if (TextUtils.isEmpty(str) || (b0Var = this.a) == null) {
            return obj;
        }
        try {
            if (obj instanceof String) {
                return b0Var.getString(str, (String) obj);
            }
            if (obj instanceof Integer) {
                return Integer.valueOf(b0Var.getInt(str, ((Integer) obj).intValue()));
            }
            if (obj instanceof Long) {
                return Long.valueOf(b0Var.getLong(str, ((Long) obj).longValue()));
            }
            if (!(obj instanceof Double)) {
                if (obj instanceof Float) {
                    return Float.valueOf(b0Var.getFloat(str, ((Float) obj).floatValue()));
                }
                return obj instanceof Boolean ? Boolean.valueOf(b0Var.getBoolean(str, ((Boolean) obj).booleanValue())) : b0Var.d(str);
            }
            double dDoubleValue = ((Double) obj).doubleValue();
            synchronized (b0Var) {
                com.smartdigimkt.l4.e eVar = (com.smartdigimkt.l4.e) b0Var.g.get(str);
                if (eVar != null && eVar.a() == 5) {
                    dDoubleValue = ((g) eVar).b;
                }
            }
            return Double.valueOf(dDoubleValue);
        } catch (Throwable th) {
            th.getMessage();
            return obj;
        }
    }

    @Override // com.smartdigimkt.k4.a
    public final void clear() {
        b0 b0Var = this.a;
        if (b0Var != null) {
            synchronized (b0Var) {
                b0Var.c();
                b0Var.i();
                b0Var.m();
            }
        }
    }

    @Override // com.smartdigimkt.k4.a
    public final Map getAll() {
        b0 b0Var = this.a;
        if (b0Var != null) {
            return b0Var.getAll();
        }
        return null;
    }

    @Override // com.smartdigimkt.k4.a
    public final void remove(String str) {
        b0 b0Var = this.a;
        if (b0Var != null) {
            b0Var.remove(str);
            a(this.b);
        }
    }

    @Override // com.smartdigimkt.k4.a
    public final void a(String str, Object obj, int i) {
        if (TextUtils.isEmpty(str) || obj == null || this.a == null) {
            return;
        }
        try {
            String string = obj.toString();
            if (obj instanceof String) {
                this.a.putString(str, (String) obj);
            } else if (obj instanceof Integer) {
                this.a.putInt(str, Integer.parseInt(string));
            } else if (obj instanceof Long) {
                this.a.putLong(str, Long.parseLong(string));
            } else if (obj instanceof Double) {
                this.a.a(str, Double.parseDouble(string));
            } else if (obj instanceof Float) {
                this.a.putFloat(str, Float.parseFloat(string));
            } else if (obj instanceof Boolean) {
                this.a.putBoolean(str, Boolean.parseBoolean(string));
            }
            a(i);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.smartdigimkt.k4.a
    public final void a(HashMap map) {
        b0 b0Var;
        int i = this.b;
        if (map.isEmpty() || (b0Var = this.a) == null) {
            return;
        }
        try {
            b0Var.a(map);
            a(i);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public final void a(int i) {
        SharedPreferences.Editor editor = this.a;
        if (editor == null) {
            return;
        }
        if (editor instanceof t) {
            ((t) editor).getClass();
            i = 0;
        } else if (i == 0) {
            i = 1;
        }
        editor.getClass();
        if (i == 1) {
            b0 b0Var = this.a;
            b0Var.p.execute(new w(b0Var));
        } else if (i == 2) {
            this.a.r();
        }
    }
}
