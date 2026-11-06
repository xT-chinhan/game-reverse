package com.byazt.vga;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.anythink.core.common.f.e;
import com.anythink.core.common.f.h;
import com.anythink.core.e.i;
import com.byazt.hls.fs;
import com.byazt.hls.x;
import com.byazt.vf.cp;
import com.byazt.vf.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 978, 26})
public abstract class qg extends com.byazt.fa.n {
    public final Context l;
    public cp qg;
    public com.byazt.vr.qg w;
    public com.byazt.vr.w x;
    public List<String> s = new ArrayList();
    public final List<com.byazt.vr.n> q = new ArrayList();
    public boolean fs = false;
    public final Runnable rv = new Runnable() { // from class: com.byazt.vga.qg.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (qg.this) {
                if (qg.this.q.isEmpty()) {
                    qg.this.fs = false;
                    return;
                }
                ArrayList arrayList = new ArrayList(qg.this.q);
                qg.this.q.clear();
                qg.this.fs = false;
                qg qgVar = qg.this;
                qgVar.n(arrayList, qgVar.n);
            }
        }
    };
    public k n = (k) com.byazt.qp.q.n("encrypt_service");

    public abstract com.byazt.asa.q n(JSONObject jSONObject, String str, int i) throws JSONException;

    public abstract String n();

    public qg(Context context, com.byazt.vr.qg qgVar, com.byazt.vr.w wVar, cp cpVar) {
        this.l = context;
        this.w = qgVar;
        this.x = wVar;
        this.qg = cpVar;
    }

    public List<com.byazt.vr.n> n(String str, int i, boolean z) {
        com.byazt.vr.w wVar = this.x;
        if (wVar == null) {
            return new ArrayList();
        }
        return n(wVar.n(), str, i, z);
    }

    public List<com.byazt.vr.n> n(int i, String str, int i2, boolean z) throws Throwable {
        Throwable th;
        String str2;
        String str3;
        long jN = com.byazt.hls.qg.n(i, getContext(), qg());
        x.s(n() + " query db max :" + jN + " limit:" + i);
        if (jN <= 0) {
            jN = 1;
        } else if (jN > 100) {
            jN = 100;
        }
        k kVar = (k) com.byazt.qp.q.n("encrypt_service");
        String str4 = str + " DESC limit " + jN;
        List<com.byazt.vr.n> arrayList = new ArrayList<>();
        this.s.clear();
        String str5 = "retry";
        String str6 = "encrypt";
        Cursor cursorQuery = com.byazt.er.qg.query(getContext(), n(), new String[]{"id", e.a.d, "encrypt", "retry"}, null, null, null, null, str4, qg());
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                try {
                    try {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex(e.a.d));
                        str3 = str6;
                        try {
                            int i3 = cursorQuery.getInt(cursorQuery.getColumnIndex(str3));
                            str2 = str5;
                            try {
                                int i4 = cursorQuery.getInt(cursorQuery.getColumnIndex(str2));
                                if (i3 == 1) {
                                    string2 = kVar.q(string2);
                                }
                                if (TextUtils.isEmpty(string2)) {
                                    x.n("log_show_query : value is null");
                                    this.s.add(string);
                                } else {
                                    if (arrayList.size() > 100) {
                                        break;
                                    }
                                    JSONObject jSONObject = new JSONObject(string2);
                                    com.byazt.asa.q qVarN = n(jSONObject, string, i4);
                                    qVarN.qg(i4 + 1);
                                    com.byazt.hls.q.n(jSONObject, qVarN, qg(), i4, qVarN instanceof com.byazt.asa.x);
                                    arrayList.add(qVarN);
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    x.q("query error " + n() + " " + th.getMessage());
                                } catch (Throwable th3) {
                                    th = th3;
                                    if (cursorQuery != null) {
                                        try {
                                            cursorQuery.close();
                                            if (!this.s.isEmpty()) {
                                                qg(this.s);
                                                this.s.clear();
                                            }
                                            if (!com.byazt.hls.q.n(i2)) {
                                                throw th;
                                            }
                                            if (!z || !com.byazt.hls.q.s(n())) {
                                                n(arrayList, 10, i.f);
                                                throw th;
                                            }
                                            throw th;
                                        } catch (Exception e) {
                                            x.q("delete error " + n() + " " + e.getMessage());
                                            throw th;
                                        }
                                    }
                                    throw th;
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            str2 = str5;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        str2 = str5;
                        str3 = str6;
                    }
                    str6 = str3;
                    str5 = str2;
                } catch (Throwable th6) {
                    th = th6;
                }
            }
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                    if (!this.s.isEmpty()) {
                        qg(this.s);
                        this.s.clear();
                    }
                    if (com.byazt.hls.q.n(i2) && (!z || !com.byazt.hls.q.s(n()))) {
                        n(arrayList, 10, i.f);
                    }
                } catch (Exception e2) {
                    x.q("delete error " + n() + " " + e2.getMessage());
                }
            }
        }
        x.s(n() + " query db actually size :" + arrayList.size());
        return arrayList;
    }

    private void q() {
        if (this.fs) {
            return;
        }
        fs fsVarN = fs.n();
        fsVarN.qg().postDelayed(this.rv, fsVarN.n(this.qg));
        this.fs = true;
    }

    public com.byazt.vr.qg qg() {
        return this.w;
    }

    public List<com.byazt.vr.n> n(int i, int i2, com.byazt.vr.n nVar, boolean z) {
        int iN;
        if (this.x == null || nVar == null || !com.byazt.hls.q.n(i) || !n(nVar) || (iN = this.x.n()) <= i2) {
            return null;
        }
        return n(iN - i2, "_id", i, z);
    }

    public com.byazt.fa.qg n(int i, List<com.byazt.vr.n> list) {
        com.byazt.fa.qg qgVar = new com.byazt.fa.qg();
        if (list != null && list.size() != 0 && list.get(0) != null && n(list.get(0))) {
            if (i == 200 || i == -1 || i == -3) {
                qgVar.n(s(list));
                if (i != 200) {
                    qg(i, list);
                }
            } else {
                qgVar.n("code:" + i);
            }
            qgVar.n(true);
            return qgVar;
        }
        qgVar.n(false);
        return qgVar;
    }

    private JSONArray q(List<com.byazt.vr.n> list) {
        JSONArray jSONArray = new JSONArray();
        for (com.byazt.vr.n nVar : list) {
            JSONObject jSONObjectN = nVar.n();
            try {
                jSONObjectN.put(h.b.h, nVar.rv());
            } catch (JSONException unused) {
            }
            jSONArray.put(jSONObjectN);
        }
        return jSONArray;
    }

    public void qg(int i, List<com.byazt.vr.n> list) {
        com.byazt.vr.qg qgVar = this.w;
        if (qgVar == null || qgVar.n() == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "delete_event");
            jSONObject.put("event_array", q(list));
            jSONObject.put("code", i);
            if (com.byazt.hls.q.qg(list)) {
                jSONObject.put("csj_ad", 0);
            } else if (com.byazt.hls.q.n(list)) {
                jSONObject.put("csj_ad", 3);
            } else {
                jSONObject.put("csj_ad", 1);
            }
            this.w.n().n(jSONObject);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0026 A[DONT_GENERATE, EXC_TOP_SPLITTER, PHI: r0 r1
      0x0026: PHI (r0v3 android.database.Cursor) = (r0v2 android.database.Cursor), (r0v4 android.database.Cursor) binds: [B:13:0x0031, B:6:0x0024] A[DONT_GENERATE, DONT_INLINE]
      0x0026: PHI (r1v3 int) = (r1v0 int), (r1v5 int) binds: [B:13:0x0031, B:6:0x0024] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public int s() {
        Cursor cursorQuery = null;
        int i = 0;
        try {
            cursorQuery = com.byazt.er.qg.query(getContext(), n(), new String[]{"count(1)"}, null, null, null, null, null, this.w);
            if (cursorQuery != null) {
                cursorQuery.moveToFirst();
                i = cursorQuery.getInt(0);
            }
        } catch (Exception unused) {
        } finally {
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Exception unused2) {
                }
            }
        }
        return i;
    }

    public synchronized void n(List<String> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                try {
                    Iterator<com.byazt.vr.n> it = this.q.iterator();
                    while (it.hasNext()) {
                        com.byazt.vr.n next = it.next();
                        if (next != null) {
                            String strW = next.w();
                            if (!TextUtils.isEmpty(strW) && list.contains(strW)) {
                                it.remove();
                            }
                        }
                    }
                } catch (Throwable th) {
                    x.n(n() + "deleteMemList", th);
                }
            }
        }
    }

    public synchronized void qg(com.byazt.vr.n nVar) {
        if (n(nVar) && nVar.n() != null && !TextUtils.isEmpty(nVar.w())) {
            this.q.add(nVar);
            q();
        }
    }

    public Context getContext() {
        return this.l;
    }

    public void n(List<com.byazt.vr.n> list, k kVar) {
        com.byazt.er.qg.insert(getContext(), kVar, n(), list, this.w);
    }

    @Override // com.byazt.fa.n
    public List<com.byazt.vr.n> qg(int i, com.byazt.vr.n nVar, boolean z, List<String> list, String str) {
        List<com.byazt.vr.n> listN = n("_id", i, z);
        if (!n(listN, list)) {
            return null;
        }
        x.n("db " + str + " " + n() + " get size:" + listN.size());
        return listN;
    }

    @Override // com.byazt.fa.n
    public boolean n(String str) {
        if (this.x == null) {
            return false;
        }
        int iS = s();
        x.qg("check flush db " + n() + " count:" + iS);
        return iS > 0;
    }

    @Override // com.byazt.fa.n
    public boolean qg(int i, String str, com.byazt.vr.n nVar) {
        if (this.x == null) {
            return false;
        }
        int iS = s();
        int iQg = this.x.qg();
        x.qg("check db " + n() + " count:" + iS + " MaxCacheCount:" + iQg + " message:" + com.byazt.hls.q.qg(i));
        return iS >= iQg;
    }

    private boolean n(List<com.byazt.vr.n> list, List<String> list2) {
        if (list != null && !list.isEmpty() && list2 != null && !list2.isEmpty()) {
            try {
                Iterator<com.byazt.vr.n> it = list.iterator();
                while (it.hasNext()) {
                    com.byazt.vr.n next = it.next();
                    if (next != null) {
                        String strW = next.w();
                        if (!TextUtils.isEmpty(strW) && list2.contains(strW)) {
                            it.remove();
                        }
                    }
                }
            } catch (Throwable th) {
                x.n(n() + " canSendLogList", th);
            }
        }
        return (list == null || list.isEmpty()) ? false : true;
    }

    public String qg(List<String> list) {
        x.n("_delete", n() + " repo delete: " + list.size());
        String strN = com.byazt.er.qg.n(getContext(), "DELETE FROM " + n() + " WHERE " + n("id", (List<?>) list, 1000, true), this.w, n());
        com.byazt.hls.l.n(com.byazt.kp.s.n.k(), list.size(), this.qg);
        return strN;
    }

    public static String qg(String str) {
        return "ALTER TABLE " + str + " ADD COLUMN encrypt INTEGER default 0";
    }

    public static String s(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }

    public String n(String str, List<?> list, int i, boolean z) {
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
            String strN = n(TextUtils.join("','", list.subList(i4, Math.min(i4 + iMin, size))), "");
            if (i3 != 0) {
                sb.append(str3);
            }
            sb.append(str).append(str2).append("('").append(strN).append("')");
        }
        return n(sb.toString(), str + str2 + "('')");
    }

    private String n(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }

    public void n(List<com.byazt.vr.n> list, int i, long j) {
        if (list == null || list.size() == 0) {
            return;
        }
        try {
            l(list);
            n(i, j);
        } catch (Exception unused) {
        }
    }

    private void l(List<com.byazt.vr.n> list) {
        LinkedList linkedList = new LinkedList();
        Iterator<com.byazt.vr.n> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().w());
        }
        com.byazt.er.qg.n(getContext(), "UPDATE " + n() + " SET retry = retry+1 WHERE " + n("id", (List<?>) linkedList, 1000, true), this.w, n());
    }

    private List<com.byazt.vr.n> n(String str, String[] strArr) {
        k kVar;
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor cursorQuery = com.byazt.er.qg.query(getContext(), n(), new String[]{"id", e.a.d, "encrypt", "retry"}, str, strArr, null, null, null, qg());
            if (cursorQuery == null) {
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Exception unused) {
                    }
                }
                return arrayList;
            }
            while (cursorQuery.moveToNext()) {
                try {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex(e.a.d));
                    int i = cursorQuery.getInt(cursorQuery.getColumnIndex("encrypt"));
                    int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("retry"));
                    if (i == 1 && (kVar = this.n) != null) {
                        string2 = kVar.q(string2);
                    }
                    if (!TextUtils.isEmpty(string2)) {
                        com.byazt.asa.q qVarN = n(new JSONObject(string2), string, i2);
                        qVarN.qg(i2 + 1);
                        arrayList.add(qVarN);
                    }
                } catch (Throwable th) {
                    x.q("query event list error " + n() + " " + th.getMessage());
                }
            }
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Exception unused2) {
                }
            }
            return arrayList;
        } catch (Throwable th2) {
            if (0 != 0) {
                try {
                    cursor.close();
                } catch (Exception unused3) {
                }
            }
            throw th2;
        }
    }

    public String s(List<com.byazt.vr.n> list) {
        if (list == null || list.size() == 0) {
            return "list is empty";
        }
        LinkedList linkedList = new LinkedList();
        Iterator<com.byazt.vr.n> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().w());
        }
        com.byazt.hls.q.qg(list, n());
        String strN = com.byazt.er.qg.n(getContext(), "DELETE FROM " + n() + " WHERE " + n("id", (List<?>) linkedList, 1000, true), this.w, n());
        n(linkedList);
        return strN;
    }

    private void n(int i, long j) {
        String[] strArr = {new StringBuilder().append(System.currentTimeMillis() - j).toString(), new StringBuilder().append(i).toString()};
        List<com.byazt.vr.n> listN = n("gen_time <? OR retry >?", strArr);
        if (com.byazt.er.qg.delete(getContext(), n(), "gen_time <? OR retry >?", strArr, this.w) <= 0 || listN.isEmpty()) {
            return;
        }
        qg(-4, listN);
    }
}
