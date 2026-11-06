package com.anythink.core.common.s.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class f implements com.anythink.core.common.s.a {
    private static final String a = "f";
    private final Context b;
    private final String c;
    private final int d;

    private static boolean a(int i) {
        return i != 2;
    }

    public f(com.anythink.core.common.s.c cVar) {
        this.b = cVar.a();
        this.c = cVar.b();
        this.d = cVar.d();
    }

    @Override // com.anythink.core.common.s.a
    public final <V> void a(String str, V v) {
        a(str, v, this.d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.anythink.core.common.s.a
    public final <V> void a(String str, V v, int i) {
        if (this.b == null || TextUtils.isEmpty(this.c) || TextUtils.isEmpty(str) || v == 0) {
            return;
        }
        try {
            SharedPreferences.Editor editorEdit = this.b.getSharedPreferences(this.c, 0).edit();
            String string = v.toString();
            if (v instanceof String) {
                editorEdit.putString(str, (String) v);
            } else if (v instanceof Integer) {
                editorEdit.putInt(str, Integer.parseInt(string));
            } else if (v instanceof Long) {
                editorEdit.putLong(str, Long.parseLong(string));
            } else if ((v instanceof Double) || (v instanceof Float)) {
                editorEdit.putFloat(str, Float.parseFloat(string));
            } else if (v instanceof Boolean) {
                editorEdit.putBoolean(str, Boolean.parseBoolean(string));
            } else {
                Object[] objArr = new Object[2];
            }
            if (a(i)) {
                editorEdit.apply();
            } else {
                editorEdit.commit();
            }
            Object[] objArr2 = new Object[3];
            Integer.valueOf(i);
        } catch (Throwable th) {
            Object[] objArr3 = new Object[1];
            th.getMessage();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [V, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v1, types: [V] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // com.anythink.core.common.s.a
    public final <V> V b(String str, V v) {
        Object objValueOf;
        ?? r5 = v;
        if (this.b != null && !TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(str) && v != 0) {
            try {
                SharedPreferences sharedPreferences = this.b.getSharedPreferences(this.c, 0);
                if (v instanceof String) {
                    objValueOf = sharedPreferences.getString(str, (String) v);
                } else if (v instanceof Integer) {
                    objValueOf = Integer.valueOf(sharedPreferences.getInt(str, ((Integer) v).intValue()));
                } else if (v instanceof Long) {
                    objValueOf = Long.valueOf(sharedPreferences.getLong(str, ((Long) v).longValue()));
                } else if (v instanceof Double) {
                    objValueOf = Double.valueOf(sharedPreferences.getFloat(str, Float.parseFloat(v.toString())));
                } else if (v instanceof Float) {
                    objValueOf = Float.valueOf(sharedPreferences.getFloat(str, ((Float) v).floatValue()));
                } else {
                    if (v instanceof Boolean) {
                        objValueOf = Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) v).booleanValue()));
                    } else if (v instanceof Object) {
                        v = v;
                        Object[] objArr = new Object[2];
                        v = v;
                    }
                    v = v;
                    Object[] objArr2 = new Object[3];
                    r5 = v;
                }
                v = (V) objValueOf;
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
        r5 = v;
        r5 = v;
        r5 = v;
        return (V) r5;
    }

    @Override // com.anythink.core.common.s.a
    public final void b(String str) {
        if (this.b == null || TextUtils.isEmpty(this.c)) {
            return;
        }
        try {
            SharedPreferences.Editor editorEdit = this.b.getSharedPreferences(this.c, 0).edit();
            editorEdit.remove(str);
            editorEdit.apply();
        } catch (Throwable th) {
            Object[] objArr = new Object[1];
            th.getMessage();
        }
    }

    @Override // com.anythink.core.common.s.a
    public final void b() {
        if (this.b == null || TextUtils.isEmpty(this.c)) {
            return;
        }
        try {
            SharedPreferences.Editor editorEdit = this.b.getSharedPreferences(this.c, 0).edit();
            editorEdit.clear();
            editorEdit.apply();
        } catch (Throwable th) {
            Object[] objArr = new Object[1];
            th.getMessage();
        }
    }

    @Override // com.anythink.core.common.s.a
    public final Map<String, Object> a() {
        if (this.b != null && !TextUtils.isEmpty(this.c)) {
            try {
                return this.b.getSharedPreferences(this.c, 0).getAll();
            } catch (Throwable th) {
                Object[] objArr = new Object[1];
                th.getMessage();
            }
        }
        return null;
    }

    @Override // com.anythink.core.common.s.a
    public final boolean a(String str) {
        if (this.b != null && !TextUtils.isEmpty(this.c)) {
            try {
                return this.b.getSharedPreferences(this.c, 0).contains(str);
            } catch (Throwable th) {
                Object[] objArr = new Object[1];
                th.getMessage();
            }
        }
        return false;
    }

    public final String c() {
        return this.c;
    }
}
