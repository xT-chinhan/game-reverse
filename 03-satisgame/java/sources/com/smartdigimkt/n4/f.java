package com.smartdigimkt.n4;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements com.smartdigimkt.k4.a {
    public final Context a;
    public final String b;
    public final int c;

    public f(com.smartdigimkt.k4.d dVar) {
        this.a = dVar.a;
        this.b = dVar.b;
        this.c = dVar.d;
    }

    @Override // com.smartdigimkt.k4.a
    public final void a(Object obj, String str) {
        a(str, obj, this.c);
    }

    @Override // com.smartdigimkt.k4.a
    public final Object b(Object obj, String str) {
        if (this.a != null && !TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(str)) {
            try {
                SharedPreferences sharedPreferences = this.a.getSharedPreferences(this.b, 0);
                if (obj instanceof String) {
                    obj = sharedPreferences.getString(str, (String) obj);
                } else if (obj instanceof Integer) {
                    obj = Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
                } else if (obj instanceof Long) {
                    obj = Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
                } else if (obj instanceof Double) {
                    obj = Double.valueOf(sharedPreferences.getFloat(str, Float.parseFloat(obj.toString())));
                } else if (obj instanceof Float) {
                    obj = Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
                } else if (obj instanceof Boolean) {
                    obj = Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
                }
            } catch (Throwable th) {
                th.getMessage();
            }
        }
        return obj;
    }

    @Override // com.smartdigimkt.k4.a
    public final void clear() {
        if (this.a == null || TextUtils.isEmpty(this.b)) {
            return;
        }
        try {
            SharedPreferences.Editor editorEdit = this.a.getSharedPreferences(this.b, 0).edit();
            editorEdit.clear();
            editorEdit.apply();
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.smartdigimkt.k4.a
    public final Map getAll() {
        if (this.a != null && !TextUtils.isEmpty(this.b)) {
            try {
                return this.a.getSharedPreferences(this.b, 0).getAll();
            } catch (Throwable th) {
                th.getMessage();
            }
        }
        return null;
    }

    @Override // com.smartdigimkt.k4.a
    public final void remove(String str) {
        if (this.a == null || TextUtils.isEmpty(this.b)) {
            return;
        }
        try {
            SharedPreferences.Editor editorEdit = this.a.getSharedPreferences(this.b, 0).edit();
            editorEdit.remove(str);
            editorEdit.apply();
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.smartdigimkt.k4.a
    public final void a(String str, Object obj, int i) {
        if (this.a == null || TextUtils.isEmpty(this.b) || TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        try {
            SharedPreferences.Editor editorEdit = this.a.getSharedPreferences(this.b, 0).edit();
            a(editorEdit, str, obj);
            if (i != 2) {
                editorEdit.apply();
            } else {
                editorEdit.commit();
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.smartdigimkt.k4.a
    public final void a(HashMap map) {
        a(this.c, map);
    }

    public final void a(int i, HashMap map) {
        if (this.a == null || map.isEmpty()) {
            return;
        }
        try {
            SharedPreferences.Editor editorEdit = this.a.getSharedPreferences(this.b, 0).edit();
            for (Map.Entry entry : map.entrySet()) {
                a(editorEdit, (String) entry.getKey(), entry.getValue());
            }
            if (i != 2) {
                editorEdit.apply();
            } else {
                editorEdit.commit();
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, Object obj) {
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
}
