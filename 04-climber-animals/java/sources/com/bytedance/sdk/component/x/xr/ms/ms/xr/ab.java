package com.bytedance.sdk.component.x.xr.ms.ms.xr;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.anythink.core.common.e.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ab extends xr {
    protected List<String> ah;
    private com.bytedance.sdk.component.x.xr.d.xr.ms d;
    protected com.bytedance.sdk.component.x.ms.ka xr;

    public byte ah() {
        return (byte) 2;
    }

    public byte xr() {
        return (byte) 1;
    }

    public ab(Context context, com.bytedance.sdk.component.x.xr.d.xr.ms msVar, com.bytedance.sdk.component.x.ms.ka kaVar) {
        super(context, kaVar, msVar == null ? com.bytedance.sdk.component.x.xr.d.xr.ms.ah() : msVar);
        this.ah = new ArrayList();
        this.d = msVar;
        this.xr = kaVar;
        if (msVar == null) {
            this.d = com.bytedance.sdk.component.x.xr.d.xr.ms.ah();
        }
    }

    @Override // com.bytedance.sdk.component.x.xr.ms.ms
    public boolean ms(com.bytedance.sdk.component.x.ms.xr xrVar) {
        return com.bytedance.sdk.component.x.xr.ah.ms.d(xrVar);
    }

    @Override // com.bytedance.sdk.component.x.xr.ms.ms.xr.xr
    com.bytedance.sdk.component.x.ms.ka d() {
        return this.xr;
    }

    @Override // com.bytedance.sdk.component.x.xr.ms.ms.xr.xr
    public String ms() {
        return this.xr.xr().d();
    }

    @Override // com.bytedance.sdk.component.x.xr.ms.ms.xr.ah
    public List<com.bytedance.sdk.component.x.ms.xr> ms(int i, String str, int i2, boolean z) {
        long jMs = com.bytedance.sdk.component.x.xr.xr.ms.ms(i, getContext(), this.xr);
        if (jMs <= 0) {
            jMs = 1;
        } else if (jMs > 100) {
            jMs = 100;
        }
        ArrayList arrayList = new ArrayList();
        this.ah.clear();
        Cursor cursorQuery = com.bytedance.sdk.component.x.xr.ms.ms.xr.query(getContext(), ms(), new String[]{"id", f.a.d, "encrypt"}, null, null, null, null, str + " DESC limit " + jMs, this.xr);
        if (cursorQuery != null) {
            while (true) {
                try {
                    if (!cursorQuery.moveToNext()) {
                        break;
                    }
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex(f.a.d));
                    if (cursorQuery.getInt(cursorQuery.getColumnIndex("encrypt")) == 1) {
                        string2 = this.xr.d().ms(string2);
                    }
                    if (TextUtils.isEmpty(string2)) {
                        this.ah.add(string);
                    } else {
                        if (arrayList.size() > 100) {
                            break;
                        }
                        com.bytedance.sdk.component.x.xr.d.ms.ms msVar = new com.bytedance.sdk.component.x.xr.d.ms.ms(string, new JSONObject(string2));
                        msVar.xr(ah());
                        msVar.ms(xr());
                        arrayList.add(msVar);
                    }
                } finally {
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
                }
            }
        }
        return arrayList;
    }

    protected void ah(List<String> list) {
        ms();
        list.size();
        com.bytedance.sdk.component.x.xr.ms.ms.xr.ms(getContext(), "DELETE FROM " + ms() + " WHERE " + ms("id", (List<?>) list, 1000, true), this.xr);
        com.bytedance.sdk.component.x.xr.ah.xr.ms(com.bytedance.sdk.component.x.xr.xr.xr.f1585ms.ub(), list.size(), this.xr);
        ms(list);
    }

    @Override // com.bytedance.sdk.component.x.xr.ms.ms.xr.ah
    public List<com.bytedance.sdk.component.x.ms.xr> ms(String str, int i, boolean z) {
        com.bytedance.sdk.component.x.xr.d.xr.ms msVar = this.d;
        if (msVar == null) {
            return new ArrayList();
        }
        return ms(msVar.xr(), str, i, z);
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
