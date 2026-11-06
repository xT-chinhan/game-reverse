package com.anythink.basead.f.f;

import android.content.Context;
import com.anythink.core.common.d.u;
import com.anythink.core.common.h.bk;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.y;
import com.anythink.core.common.v.af;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private static volatile c b;
    private Object c = new Object();
    ConcurrentHashMap<String, ArrayList<String>> a = new ConcurrentHashMap<>();

    private c() {
    }

    public static c a() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    public final void a(final Context context, final String str, final w wVar, final y yVar) {
        if (wVar.b() == 3 && (yVar instanceof bk) && ((bk) yVar).a() > 0) {
            com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.basead.f.f.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (c.this.c) {
                        bk bkVar = (bk) yVar;
                        ArrayList<String> arrayList = c.this.a.get(str);
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                            try {
                                JSONArray jSONArray = new JSONArray(af.c(context, u.b.i, str, ""));
                                if (jSONArray.length() > 0) {
                                    for (int i = 0; i < jSONArray.length(); i++) {
                                        arrayList.add(jSONArray.optString(i));
                                    }
                                }
                            } catch (Exception unused) {
                            }
                            c.this.a.put(str, arrayList);
                        }
                        if (arrayList.size() >= bkVar.a()) {
                            arrayList.remove(arrayList.size() - 1);
                        }
                        arrayList.add(0, wVar.v());
                        af.b(context, u.b.i, str, new JSONArray((Collection) arrayList).toString());
                    }
                }
            }, 2);
        }
    }

    public final String[] a(Context context, String str) {
        ArrayList<String> arrayList = this.a.get(str);
        if (arrayList == null) {
            try {
                JSONArray jSONArray = new JSONArray(af.c(context, u.b.i, str, ""));
                if (jSONArray.length() > 0) {
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            arrayList2.add(jSONArray.optString(i));
                        } catch (Exception unused) {
                        }
                    }
                    arrayList = arrayList2;
                }
            } catch (Exception unused2) {
            }
        }
        if (arrayList == null) {
            return null;
        }
        this.a.put(str, arrayList);
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        return strArr;
    }

    public static String a(String str, String str2) {
        return str + str2;
    }
}
