package com.bytedance.sdk.component.x.xr.ms.ms.xr;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.anythink.core.common.e.f;
import com.anythink.core.common.e.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c extends xr {
    protected List<String> ah;
    private final Context d;
    private com.bytedance.sdk.component.x.xr.d.xr.ms ka;
    protected com.bytedance.sdk.component.x.ms.ka xr;

    public byte ah() {
        return (byte) 0;
    }

    public byte xr() {
        return (byte) 2;
    }

    public c(Context context, com.bytedance.sdk.component.x.xr.d.xr.ms msVar, com.bytedance.sdk.component.x.ms.ka kaVar) {
        super(context, kaVar, msVar == null ? com.bytedance.sdk.component.x.xr.d.xr.ms.ah() : msVar);
        this.ah = new ArrayList();
        this.d = context;
        this.ka = msVar;
        this.xr = kaVar;
        if (msVar == null) {
            this.ka = com.bytedance.sdk.component.x.xr.d.xr.ms.ah();
        }
    }

    @Override // com.bytedance.sdk.component.x.xr.ms.ms
    public boolean ms(com.bytedance.sdk.component.x.ms.xr xrVar) {
        return com.bytedance.sdk.component.x.xr.ah.ms.ah(xrVar);
    }

    @Override // com.bytedance.sdk.component.x.xr.ms.ms.xr.xr
    com.bytedance.sdk.component.x.ms.ka d() {
        return this.xr;
    }

    @Override // com.bytedance.sdk.component.x.xr.ms.ms.xr.xr
    public String ms() {
        com.bytedance.sdk.component.x.ms.c cVarXr = this.xr.xr();
        if (cVarXr != null) {
            return cVarXr.xr();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.x.xr.ms.ms.xr.ah
    public List<com.bytedance.sdk.component.x.ms.xr> ms(int i, String str, int i2, boolean z) {
        String str2;
        com.bytedance.sdk.component.x.ms.d dVar;
        long jMs = com.bytedance.sdk.component.x.xr.xr.ms.ms(i, getContext(), this.xr);
        com.bytedance.sdk.component.x.xr.ah.ah.xr(ms() + " query db max :" + jMs + " limit:" + i, this.xr);
        if (jMs <= 0) {
            jMs = 1;
        } else if (jMs > 100) {
            jMs = 100;
        }
        List<com.bytedance.sdk.component.x.ms.xr> arrayList = new ArrayList<>();
        this.ah.clear();
        String str3 = "ad_extra_data";
        Cursor cursorQuery = com.bytedance.sdk.component.x.xr.ms.ms.xr.query(getContext(), ms(), new String[]{"id", f.a.d, "encrypt", "retry"}, null, null, null, null, str + " DESC limit " + jMs, this.xr);
        if (cursorQuery != null) {
            try {
                com.bytedance.sdk.component.x.ms.d dVarD = this.xr.d();
                while (cursorQuery.moveToNext()) {
                    try {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex(f.a.d));
                        int i3 = cursorQuery.getInt(cursorQuery.getColumnIndex("encrypt"));
                        int i4 = cursorQuery.getInt(cursorQuery.getColumnIndex("retry"));
                        if (i3 == 1) {
                            string2 = dVarD.ms(string2);
                        }
                        if (TextUtils.isEmpty(string2)) {
                            this.ah.add(string);
                        } else {
                            if (arrayList.size() > 100) {
                                break;
                            }
                            JSONObject jSONObject = new JSONObject(string2);
                            str2 = str3;
                            try {
                                String strOptString = jSONObject.optString(str2);
                                if (TextUtils.isEmpty(strOptString)) {
                                    dVar = dVarD;
                                } else {
                                    JSONObject jSONObject2 = new JSONObject(strOptString);
                                    jSONObject2.put(m.b.h, i4);
                                    dVar = dVarD;
                                    try {
                                        jSONObject2.put("db_rd", System.currentTimeMillis());
                                        jSONObject.put(str2, jSONObject2.toString());
                                    } catch (Throwable th) {
                                        th = th;
                                        com.bytedance.sdk.component.x.xr.ah.ah.ah(th.getMessage(), this.xr);
                                    }
                                }
                                com.bytedance.sdk.component.x.xr.d.ms.ms msVar = new com.bytedance.sdk.component.x.xr.d.ms.ms(string, jSONObject);
                                msVar.ms(ah());
                                msVar.xr(xr());
                                com.bytedance.sdk.component.x.xr.ah.ms.ms(jSONObject, msVar, this.xr, i4);
                                arrayList.add(msVar);
                            } catch (Throwable th2) {
                                th = th2;
                                dVar = dVarD;
                                com.bytedance.sdk.component.x.xr.ah.ah.ah(th.getMessage(), this.xr);
                                dVarD = dVar;
                                str3 = str2;
                            }
                            dVarD = dVar;
                            str3 = str2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        str2 = str3;
                    }
                }
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                        if (!this.ah.isEmpty()) {
                            ah(this.ah);
                            this.ah.clear();
                        }
                        if (com.bytedance.sdk.component.x.xr.ah.ms.ms(i2) && !z) {
                            ms(arrayList, 5, 604800000L);
                        }
                    } catch (Exception unused) {
                    }
                }
            } catch (Throwable th4) {
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                        if (!this.ah.isEmpty()) {
                            ah(this.ah);
                            this.ah.clear();
                        }
                        if (com.bytedance.sdk.component.x.xr.ah.ms.ms(i2) && !z) {
                            ms(arrayList, 5, 604800000L);
                        }
                    } catch (Exception unused2) {
                    }
                }
                throw th4;
            }
        }
        com.bytedance.sdk.component.x.xr.ah.ah.xr(ms() + " query db actually size :" + arrayList.size(), this.xr);
        return arrayList;
    }

    @Override // com.bytedance.sdk.component.x.xr.ms.ms.xr.ah
    public List<com.bytedance.sdk.component.x.ms.xr> ms(String str, int i, boolean z) {
        com.bytedance.sdk.component.x.xr.d.xr.ms msVar = this.ka;
        if (msVar == null) {
            return new ArrayList();
        }
        return ms(msVar.xr(), str, i, z);
    }

    protected String ah(List<String> list) {
        ms();
        list.size();
        String strMs = com.bytedance.sdk.component.x.xr.ms.ms.xr.ms(getContext(), "DELETE FROM " + ms() + " WHERE " + ms("id", (List<?>) list, 1000, true), this.xr);
        com.bytedance.sdk.component.x.xr.ah.xr.ms(com.bytedance.sdk.component.x.xr.xr.xr.f1585ms.ub(), list.size(), this.xr);
        ms(list);
        return strMs;
    }

    @Override // com.bytedance.sdk.component.x.xr.ms.ms.xr.ah
    public String delete(List<com.bytedance.sdk.component.x.ms.xr> list) {
        if (list == null || list.size() == 0) {
            return "list is empty";
        }
        LinkedList linkedList = new LinkedList();
        Iterator<com.bytedance.sdk.component.x.ms.xr> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().ah());
        }
        com.bytedance.sdk.component.x.xr.ah.ms.ms(list, this.xr, ms());
        String strMs = com.bytedance.sdk.component.x.xr.ms.ms.xr.ms(getContext(), "DELETE FROM " + ms() + " WHERE " + ms("id", (List<?>) linkedList, 1000, true), this.xr);
        ms(linkedList);
        return strMs;
    }

    private void ms(int i, long j) {
        com.bytedance.sdk.component.x.xr.ms.ms.xr.delete(getContext(), ms(), "gen_time <? OR retry >?", new String[]{new StringBuilder().append(System.currentTimeMillis() - j).toString(), new StringBuilder().append(i).toString()}, this.xr);
    }

    public void ms(List<com.bytedance.sdk.component.x.ms.xr> list, int i, long j) {
        if (list == null || list.size() == 0) {
            return;
        }
        try {
            d(list);
            ms(i, j);
        } catch (Exception unused) {
        }
    }

    private void d(List<com.bytedance.sdk.component.x.ms.xr> list) {
        LinkedList linkedList = new LinkedList();
        Iterator<com.bytedance.sdk.component.x.ms.xr> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().ah());
        }
        com.bytedance.sdk.component.x.xr.ms.ms.xr.ms(getContext(), "UPDATE " + ms() + " SET retry = retry+1 WHERE " + ms("id", (List<?>) linkedList, 1000, true), this.xr);
    }

    public static String d(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }

    public static String ka(String str) {
        return "ALTER TABLE " + str + " ADD COLUMN encrypt INTEGER default 0";
    }

    private static String ms(String str, List<?> list, int i, boolean z) {
        int i2;
        String str2 = z ? " IN " : " NOT IN ";
        String str3 = z ? " OR " : " AND ";
        int iMin = Math.min(i, 1000);
        int size = list.size();
        if (size % iMin == 0) {
            i2 = size / iMin;
        } else {
            i2 = (size / iMin) + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 * iMin;
            String strMs = ms(TextUtils.join("','", list.subList(i4, Math.min(i4 + iMin, size))), "");
            if (i3 != 0) {
                sb.append(str3);
            }
            sb.append(str).append(str2).append("('").append(strMs).append("')");
        }
        return ms(sb.toString(), str + str2 + "('')");
    }

    private static String ms(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }
}
