package com.byazt.fhc;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.byazt.mg.PluginConstants;
import com.byazt.nn.fw;
import com.byazt.nn.zo;
import com.byazt.vkw.k;
import com.byazt.vkw.nt;
import com.tapsdk.tapad.group.constants.Constants;
import com.umeng.analytics.pro.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 496, 13})
public abstract class hw extends com.byazt.ie.pr {
    public final Context c;
    public com.byazt.hh.uc fw;
    public k hw;
    public com.byazt.hh.hw uc;
    public List<String> hn = new ArrayList();
    public final List<com.byazt.hh.pr> x = new ArrayList();
    public boolean zo = false;
    public final Runnable aj = new Runnable() { // from class: com.byazt.fhc.hw.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (hw.this) {
                if (hw.this.x.isEmpty()) {
                    hw.this.zo = false;
                    return;
                }
                ArrayList arrayList = new ArrayList(hw.this.x);
                hw.this.x.clear();
                hw.this.zo = false;
                hw hwVar = hw.this;
                hwVar.pr(arrayList, hwVar.pr);
            }
        }
    };
    public nt pr = (nt) com.byazt.zs.uc.pr("encrypt_service");

    public abstract com.byazt.yt.x pr(JSONObject jSONObject, String str, int i) throws JSONException;

    public abstract String pr();

    public hw(Context context, com.byazt.hh.hw hwVar, com.byazt.hh.uc ucVar, k kVar) {
        this.c = context;
        this.uc = hwVar;
        this.fw = ucVar;
        this.hw = kVar;
    }

    public List<com.byazt.hh.pr> pr(String str, int i, boolean z) {
        com.byazt.hh.uc ucVar = this.fw;
        if (ucVar == null) {
            return new ArrayList();
        }
        return pr(ucVar.pr(), str, i, z);
    }

    public List<com.byazt.hh.pr> pr(int i, String str, int i2, boolean z) throws Throwable {
        Throwable th;
        String str2;
        String str3;
        long jPr = com.byazt.nn.hw.pr(i, getContext(), hw());
        fw.hn(pr() + " query db max :" + jPr + " limit:" + i);
        if (jPr <= 0) {
            jPr = 1;
        } else if (jPr > 100) {
            jPr = 100;
        }
        nt ntVar = (nt) com.byazt.zs.uc.pr("encrypt_service");
        String str4 = str + " DESC limit " + jPr;
        List<com.byazt.hh.pr> arrayList = new ArrayList<>();
        this.hn.clear();
        String str5 = "retry";
        String str6 = "encrypt";
        Cursor cursorQuery = com.byazt.ya.hw.query(getContext(), pr(), new String[]{"id", Constants.VALUE_FIELD, "encrypt", "retry"}, null, null, null, null, str4, hw());
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                try {
                    try {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex(Constants.VALUE_FIELD));
                        str3 = str6;
                        try {
                            int i3 = cursorQuery.getInt(cursorQuery.getColumnIndex(str3));
                            str2 = str5;
                            try {
                                int i4 = cursorQuery.getInt(cursorQuery.getColumnIndex(str2));
                                if (i3 == 1) {
                                    string2 = ntVar.x(string2);
                                }
                                if (TextUtils.isEmpty(string2)) {
                                    fw.pr("log_show_query : value is null");
                                    this.hn.add(string);
                                    str6 = str3;
                                    str5 = str2;
                                } else {
                                    if (arrayList.size() > 100) {
                                        break;
                                    }
                                    JSONObject jSONObject = new JSONObject(string2);
                                    com.byazt.yt.x xVarPr = pr(jSONObject, string, i4);
                                    xVarPr.hw(i4 + 1);
                                    com.byazt.nn.x.pr(jSONObject, xVarPr, hw(), i4, xVarPr instanceof com.byazt.yt.fw);
                                    arrayList.add(xVarPr);
                                    str6 = str3;
                                    str5 = str2;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    fw.x("query error " + pr() + " " + th.getMessage());
                                } catch (Throwable th3) {
                                    th = th3;
                                    if (cursorQuery != null) {
                                        try {
                                            cursorQuery.close();
                                            if (!this.hn.isEmpty()) {
                                                hw(this.hn);
                                                this.hn.clear();
                                            }
                                            if (!com.byazt.nn.x.pr(i2)) {
                                                throw th;
                                            }
                                            if (!z || !com.byazt.nn.x.hn(pr())) {
                                                pr(arrayList, 10, 604800000L);
                                                throw th;
                                            }
                                            throw th;
                                        } catch (Exception e) {
                                            fw.x("delete error " + pr() + " " + e.getMessage());
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
                } catch (Throwable th6) {
                    th = th6;
                }
            }
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                    if (!this.hn.isEmpty()) {
                        hw(this.hn);
                        this.hn.clear();
                    }
                    if (com.byazt.nn.x.pr(i2) && (!z || !com.byazt.nn.x.hn(pr()))) {
                        pr(arrayList, 10, 604800000L);
                    }
                } catch (Exception e2) {
                    fw.x("delete error " + pr() + " " + e2.getMessage());
                }
            }
        }
        fw.hn(pr() + " query db actually size :" + arrayList.size());
        return arrayList;
    }

    private void x() {
        if (!this.zo) {
            zo zoVarPr = zo.pr();
            zoVarPr.hw().postDelayed(this.aj, zoVarPr.pr(this.hw));
            this.zo = true;
        }
    }

    public com.byazt.hh.hw hw() {
        return this.uc;
    }

    public List<com.byazt.hh.pr> pr(int i, int i2, com.byazt.hh.pr prVar, boolean z) {
        int iPr;
        if (this.fw == null || prVar == null || !com.byazt.nn.x.pr(i) || !pr(prVar) || (iPr = this.fw.pr()) <= i2) {
            return null;
        }
        return pr(iPr - i2, ar.d, i, z);
    }

    public com.byazt.ie.hw pr(int i, List<com.byazt.hh.pr> list) {
        com.byazt.ie.hw hwVar = new com.byazt.ie.hw();
        if (list != null && list.size() != 0 && list.get(0) != null && pr(list.get(0))) {
            if (i == 200 || i == -1 || i == -3) {
                hwVar.pr(hn(list));
                if (i != 200) {
                    hw(i, list);
                }
            } else {
                hwVar.pr("code:" + i);
            }
            hwVar.pr(true);
            return hwVar;
        }
        hwVar.pr(false);
        return hwVar;
    }

    private JSONArray x(List<com.byazt.hh.pr> list) {
        JSONArray jSONArray = new JSONArray();
        for (com.byazt.hh.pr prVar : list) {
            JSONObject jSONObjectPr = prVar.pr();
            try {
                jSONObjectPr.put("retry_count", prVar.aj());
            } catch (JSONException e) {
            }
            jSONArray.put(jSONObjectPr);
        }
        return jSONArray;
    }

    public void hw(int i, List<com.byazt.hh.pr> list) {
        com.byazt.hh.hw hwVar = this.uc;
        if (hwVar != null && hwVar.pr() != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "delete_event");
                jSONObject.put("event_array", x(list));
                jSONObject.put(PluginConstants.KEY_ERROR_CODE, i);
                if (com.byazt.nn.x.hw(list)) {
                    jSONObject.put("csj_ad", 0);
                } else if (com.byazt.nn.x.pr(list)) {
                    jSONObject.put("csj_ad", 3);
                } else {
                    jSONObject.put("csj_ad", 1);
                }
                this.uc.pr().pr(jSONObject);
            } catch (Exception e) {
            }
        }
    }

    public int hn() {
        int i = 0;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = com.byazt.ya.hw.query(getContext(), pr(), new String[]{"count(1)"}, null, null, null, null, null, this.uc);
                if (cursorQuery != null) {
                    cursorQuery.moveToFirst();
                    i = cursorQuery.getInt(0);
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Exception e3) {
                }
            }
            throw th;
        }
        return i;
    }

    public synchronized void pr(List<String> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                try {
                    Iterator<com.byazt.hh.pr> it = this.x.iterator();
                    while (it.hasNext()) {
                        com.byazt.hh.pr next = it.next();
                        if (next != null) {
                            String strUc = next.uc();
                            if (!TextUtils.isEmpty(strUc) && list.contains(strUc)) {
                                it.remove();
                            }
                        }
                    }
                } catch (Throwable th) {
                    fw.pr(pr() + "deleteMemList", th);
                }
            }
        }
    }

    public synchronized void hw(com.byazt.hh.pr prVar) {
        if (pr(prVar) && prVar.pr() != null && !TextUtils.isEmpty(prVar.uc())) {
            this.x.add(prVar);
            x();
        }
    }

    public Context getContext() {
        return this.c;
    }

    public void pr(List<com.byazt.hh.pr> list, nt ntVar) {
        com.byazt.ya.hw.insert(getContext(), ntVar, pr(), list, this.uc);
    }

    @Override // com.byazt.ie.pr
    public List<com.byazt.hh.pr> hw(int i, com.byazt.hh.pr prVar, boolean z, List<String> list, String str) {
        List<com.byazt.hh.pr> listPr = pr(ar.d, i, z);
        if (pr(listPr, list)) {
            fw.pr("db " + str + " " + pr() + " get size:" + listPr.size());
            return listPr;
        }
        return null;
    }

    @Override // com.byazt.ie.pr
    public boolean pr(String str) {
        if (this.fw == null) {
            return false;
        }
        int iHn = hn();
        fw.hw("check flush db " + pr() + " count:" + iHn);
        return iHn > 0;
    }

    @Override // com.byazt.ie.pr
    public boolean hw(int i, String str, com.byazt.hh.pr prVar) {
        if (this.fw == null) {
            return false;
        }
        int iHn = hn();
        int iHw = this.fw.hw();
        fw.hw("check db " + pr() + " count:" + iHn + " MaxCacheCount:" + iHw + " message:" + com.byazt.nn.x.hw(i));
        return iHn >= iHw;
    }

    private boolean pr(List<com.byazt.hh.pr> list, List<String> list2) {
        if (list != null && !list.isEmpty() && list2 != null && !list2.isEmpty()) {
            try {
                Iterator<com.byazt.hh.pr> it = list.iterator();
                while (it.hasNext()) {
                    com.byazt.hh.pr next = it.next();
                    if (next != null) {
                        String strUc = next.uc();
                        if (!TextUtils.isEmpty(strUc) && list2.contains(strUc)) {
                            it.remove();
                        }
                    }
                }
            } catch (Throwable th) {
                fw.pr(pr() + " canSendLogList", th);
            }
        }
        return (list == null || list.isEmpty()) ? false : true;
    }

    public String hw(List<String> list) {
        fw.pr("_delete", pr() + " repo delete: " + list.size());
        String strPr = com.byazt.ya.hw.pr(getContext(), "DELETE FROM " + pr() + " WHERE " + pr("id", (List<?>) list, 1000, true), this.uc, pr());
        com.byazt.nn.c.pr(com.byazt.kbl.hn.pr.ho(), list.size(), this.hw);
        return strPr;
    }

    public static String hw(String str) {
        return "ALTER TABLE " + str + " ADD COLUMN encrypt INTEGER default 0";
    }

    public static String hn(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }

    public String pr(String str, List<?> list, int i, boolean z) {
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
            String strPr = pr(TextUtils.join("','", list.subList(i4, Math.min(i4 + iMin, size))), "");
            if (i3 != 0) {
                sb.append(str3);
            }
            sb.append(str).append(str2).append("('").append(strPr).append("')");
        }
        return pr(sb.toString(), str + str2 + "('')");
    }

    private String pr(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }

    public void pr(List<com.byazt.hh.pr> list, int i, long j) {
        if (list == null || list.size() == 0) {
            return;
        }
        try {
            c(list);
            pr(i, j);
        } catch (Exception e) {
        }
    }

    private void c(List<com.byazt.hh.pr> list) {
        LinkedList linkedList = new LinkedList();
        Iterator<com.byazt.hh.pr> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().uc());
        }
        com.byazt.ya.hw.pr(getContext(), "UPDATE " + pr() + " SET retry = retry+1 WHERE " + pr("id", (List<?>) linkedList, 1000, true), this.uc, pr());
    }

    private List<com.byazt.hh.pr> pr(String str, String[] strArr) {
        nt ntVar;
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor cursorQuery = com.byazt.ya.hw.query(getContext(), pr(), new String[]{"id", Constants.VALUE_FIELD, "encrypt", "retry"}, str, strArr, null, null, null, hw());
            if (cursorQuery != null) {
                while (cursorQuery.moveToNext()) {
                    try {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex(Constants.VALUE_FIELD));
                        int i = cursorQuery.getInt(cursorQuery.getColumnIndex("encrypt"));
                        int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("retry"));
                        if (i == 1 && (ntVar = this.pr) != null) {
                            string2 = ntVar.x(string2);
                        }
                        if (!TextUtils.isEmpty(string2)) {
                            com.byazt.yt.x xVarPr = pr(new JSONObject(string2), string, i2);
                            xVarPr.hw(i2 + 1);
                            arrayList.add(xVarPr);
                        }
                    } catch (Throwable th) {
                        fw.x("query event list error " + pr() + " " + th.getMessage());
                    }
                }
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Exception e) {
                    }
                }
                return arrayList;
            }
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Exception e2) {
                }
            }
            return arrayList;
        } catch (Throwable th2) {
            if (0 != 0) {
                try {
                    cursor.close();
                    throw th2;
                } catch (Exception e3) {
                    throw th2;
                }
            }
            throw th2;
        }
    }

    public String hn(List<com.byazt.hh.pr> list) {
        if (list == null || list.size() == 0) {
            return "list is empty";
        }
        LinkedList linkedList = new LinkedList();
        Iterator<com.byazt.hh.pr> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().uc());
        }
        com.byazt.nn.x.hw(list, pr());
        String strPr = com.byazt.ya.hw.pr(getContext(), "DELETE FROM " + pr() + " WHERE " + pr("id", (List<?>) linkedList, 1000, true), this.uc, pr());
        pr(linkedList);
        return strPr;
    }

    private void pr(int i, long j) {
        String[] strArr = {new StringBuilder().append(System.currentTimeMillis() - j).toString(), new StringBuilder().append(i).toString()};
        List<com.byazt.hh.pr> listPr = pr("gen_time <? OR retry >?", strArr);
        if (com.byazt.ya.hw.delete(getContext(), pr(), "gen_time <? OR retry >?", strArr, this.uc) > 0 && !listPr.isEmpty()) {
            hw(-4, listPr);
        }
    }
}
