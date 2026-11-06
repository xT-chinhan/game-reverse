package com.byazt.wqv;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.byakv.z.SoftDecTool;
import com.umeng.analytics.pro.an;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 399, 13})
public class hw {
    public static volatile hw pr;
    public LinkedList<JSONObject> c;
    public LinkedList<JSONObject> hn;
    public SharedPreferences hw;
    public long uc;
    public LinkedList<JSONObject> x;

    public hw() {
        this.hw = null;
        this.hn = null;
        this.x = null;
        this.c = null;
        this.uc = 0L;
        this.hw = SoftDecTool.getSharedPreferences("pithar");
        this.hn = hn("sp_angle");
        this.x = hn("sp_screen");
        this.c = hn("sp_net");
        this.uc = c.pr().hn() / c.pr().x();
    }

    public static hw pr() {
        if (pr == null) {
            synchronized (hw.class) {
                if (pr == null) {
                    pr = new hw();
                }
            }
        }
        return pr;
    }

    public LinkedList<JSONObject> pr(String str) {
        if ("sp_angle".equals(str)) {
            return this.hn;
        }
        if ("sp_screen".equals(str)) {
            return this.x;
        }
        if ("sp_net".equals(str)) {
            return this.c;
        }
        return null;
    }

    public void pr(JSONObject jSONObject, String str) {
        LinkedList<JSONObject> linkedListPr = pr(str);
        if (linkedListPr == null) {
            return;
        }
        linkedListPr.add(jSONObject);
        if (linkedListPr.size() > this.uc) {
            linkedListPr.remove(0);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jHn = jCurrentTimeMillis - c.pr().hn();
        JSONObject jSONObject2 = null;
        Iterator<JSONObject> it = linkedListPr.iterator();
        while (it.hasNext()) {
            JSONObject next = it.next();
            long jOptLong = next.optLong(an.aI, 0L);
            if (jOptLong < jHn) {
                it.remove();
                jSONObject2 = next;
            } else if (jOptLong > jCurrentTimeMillis) {
                it.remove();
            }
        }
        if (jSONObject2 != null && linkedListPr.size() < 2) {
            linkedListPr.add(0, jSONObject2);
        }
        pr(str, linkedListPr);
    }

    public synchronized void hw(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if ("android.intent.action.SCREEN_OFF".equals(str)) {
            LinkedList<JSONObject> linkedListPr = pr("sp_screen");
            int i = 1;
            if (linkedListPr != null && !linkedListPr.isEmpty()) {
                JSONObject jSONObject = linkedListPr.get(linkedListPr.size() - 1);
                if (jSONObject.optLong(an.aI, 0L) / 3600000 == jCurrentTimeMillis / 3600000) {
                    int iOptInt = jSONObject.optInt("val", 0) + 1;
                    linkedListPr.remove(linkedListPr.size() - 1);
                    i = iOptInt;
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(an.aI, jCurrentTimeMillis);
                jSONObject2.put("val", i);
                pr(jSONObject2, "sp_screen");
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void pr(int i) {
        int iOptInt;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (i == 4) {
            iOptInt = 1;
        } else if (i <= 0) {
            iOptInt = 0;
        } else {
            iOptInt = 2;
        }
        LinkedList<JSONObject> linkedListPr = pr("sp_net");
        if (linkedListPr != null && !linkedListPr.isEmpty()) {
            JSONObject jSONObject = linkedListPr.get(linkedListPr.size() - 1);
            if (jSONObject.optLong(an.aI, 0L) / 3600000 == jCurrentTimeMillis / 3600000) {
                iOptInt |= jSONObject.optInt("val", 0);
                linkedListPr.remove(linkedListPr.size() - 1);
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(an.aI, jCurrentTimeMillis);
            jSONObject2.put("val", iOptInt);
            pr(jSONObject2, "sp_net");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private LinkedList<JSONObject> hn(String str) {
        LinkedList<JSONObject> linkedList = new LinkedList<>();
        SharedPreferences sharedPreferences = this.hw;
        if (sharedPreferences == null) {
            return linkedList;
        }
        String string = sharedPreferences.getString(str, "");
        if (!TextUtils.isEmpty(string)) {
            for (String str2 : string.split("\\|")) {
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        linkedList.add(new JSONObject(str2));
                    } catch (Exception e) {
                    }
                }
            }
        }
        return linkedList;
    }

    public void pr(String str, LinkedList<JSONObject> linkedList) {
        if (linkedList == null || this.hw == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<JSONObject> it = linkedList.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            sb.append("\\|");
        }
        SharedPreferences.Editor editorEdit = this.hw.edit();
        editorEdit.putString(str, sb.toString());
        editorEdit.apply();
    }

    public LinkedList<JSONObject> pr(long j) {
        if (j == 0) {
            return this.hn;
        }
        LinkedList<JSONObject> linkedList = new LinkedList<>();
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = null;
        for (JSONObject jSONObject2 : this.hn) {
            if (jCurrentTimeMillis - jSONObject2.optLong(an.aI, 0L) < j) {
                linkedList.add(jSONObject2);
            } else {
                jSONObject = jSONObject2;
            }
        }
        if (jSONObject != null && linkedList.size() < 2) {
            linkedList.add(0, jSONObject);
        }
        return linkedList;
    }
}
