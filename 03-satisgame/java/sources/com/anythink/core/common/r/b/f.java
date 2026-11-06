package com.anythink.core.common.r.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class f implements com.anythink.core.common.r.a {
    private static final String a = "f";
    private final Context b;
    private final String c;
    private final int d;

    private static boolean a(int i) {
        return i != 2;
    }

    @Override // com.anythink.core.common.r.a
    public final int c() {
        return 0;
    }

    public f(com.anythink.core.common.r.c cVar) {
        this.b = cVar.a();
        this.c = cVar.b();
        this.d = cVar.d();
    }

    @Override // com.anythink.core.common.r.a
    public final <V> void a(String str, V v) {
        a(str, v, this.d);
    }

    @Override // com.anythink.core.common.r.a
    public final <V> void a(String str, V v, int i) {
        if (this.b == null || TextUtils.isEmpty(this.c) || TextUtils.isEmpty(str) || v == null) {
            return;
        }
        try {
            SharedPreferences.Editor editorEdit = this.b.getSharedPreferences(this.c, 0).edit();
            a(editorEdit, str, v);
            if (a(i)) {
                editorEdit.apply();
            } else {
                editorEdit.commit();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.anythink.core.common.r.a
    public final void a(Map<String, Object> map) {
        a(map, this.d);
    }

    @Override // com.anythink.core.common.r.a
    public final void a(Map<String, Object> map, int i) {
        if (this.b == null || map == null || map.isEmpty()) {
            return;
        }
        try {
            SharedPreferences.Editor editorEdit = this.b.getSharedPreferences(this.c, 0).edit();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                a(editorEdit, entry.getKey(), entry.getValue());
            }
            if (a(i)) {
                editorEdit.apply();
            } else {
                editorEdit.commit();
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(SharedPreferences.Editor editor, String str, Object obj) {
        String string = obj.toString();
        if (obj instanceof String) {
            editor.putString(str, (String) obj);
            return;
        }
        if (obj instanceof Integer) {
            editor.putInt(str, Integer.parseInt(string));
            return;
        }
        if (obj instanceof Long) {
            editor.putLong(str, Long.parseLong(string));
            return;
        }
        if (obj instanceof Double) {
            editor.putFloat(str, Float.parseFloat(string));
        } else if (obj instanceof Float) {
            editor.putFloat(str, Float.parseFloat(string));
        } else if (obj instanceof Boolean) {
            editor.putBoolean(str, Boolean.parseBoolean(string));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [V, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v1, types: [V] */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v8 */
    @Override // com.anythink.core.common.r.a
    public final <V> V b(String str, V v) {
        if (this.b != null && !TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(str) && v != 0) {
            try {
                SharedPreferences sharedPreferences = this.b.getSharedPreferences(this.c, 0);
                if (v instanceof String) {
                    v = (V) sharedPreferences.getString(str, (String) v);
                } else if (v instanceof Integer) {
                    v = (V) Integer.valueOf(sharedPreferences.getInt(str, ((Integer) v).intValue()));
                } else if (v instanceof Long) {
                    v = (V) Long.valueOf(sharedPreferences.getLong(str, ((Long) v).longValue()));
                } else if (v instanceof Double) {
                    v = (V) Double.valueOf(sharedPreferences.getFloat(str, Float.parseFloat(v.toString())));
                } else if (v instanceof Float) {
                    v = (V) Float.valueOf(sharedPreferences.getFloat(str, ((Float) v).floatValue()));
                } else if (v instanceof Boolean) {
                    v = v;
                    v = (V) Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) v).booleanValue()));
                }
                v = v;
            } catch (Throwable unused) {
            }
        }
        return (V) v;
    }

    @Override // com.anythink.core.common.r.a
    public final void b(String str) {
        if (this.b == null || TextUtils.isEmpty(this.c)) {
            return;
        }
        try {
            SharedPreferences.Editor editorEdit = this.b.getSharedPreferences(this.c, 0).edit();
            editorEdit.remove(str);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.anythink.core.common.r.a
    public final void b() {
        if (this.b == null || TextUtils.isEmpty(this.c)) {
            return;
        }
        try {
            SharedPreferences.Editor editorEdit = this.b.getSharedPreferences(this.c, 0).edit();
            editorEdit.clear();
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.anythink.core.common.r.a
    public final Map<String, Object> a() {
        if (this.b != null && !TextUtils.isEmpty(this.c)) {
            try {
                return this.b.getSharedPreferences(this.c, 0).getAll();
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    @Override // com.anythink.core.common.r.a
    public final boolean a(String str) {
        if (this.b != null && !TextUtils.isEmpty(this.c)) {
            try {
                return this.b.getSharedPreferences(this.c, 0).contains(str);
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private String d() {
        return this.c;
    }
}
