package com.bytedance.sdk.component.panglearmor.xr;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.component.panglearmor.SoftDecTool;
import com.umeng.analytics.pro.bv;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile xr f1323ms;
    private LinkedList<JSONObject> ah;
    private long c;
    private LinkedList<JSONObject> d;
    private LinkedList<JSONObject> ka;
    private SharedPreferences xr;

    public xr() {
        this.xr = null;
        this.ah = null;
        this.d = null;
        this.ka = null;
        this.c = 0L;
        this.xr = SoftDecTool.getSharedPreferences("pithar");
        this.ah = ah("sp_angle");
        this.d = ah("sp_screen");
        this.ka = ah("sp_net");
        this.c = ka.ms().ah() / ka.ms().d();
    }

    public static xr ms() {
        if (f1323ms == null) {
            synchronized (xr.class) {
                if (f1323ms == null) {
                    f1323ms = new xr();
                }
            }
        }
        return f1323ms;
    }

    public LinkedList<JSONObject> ms(String str) {
        if ("sp_angle".equals(str)) {
            return this.ah;
        }
        if ("sp_screen".equals(str)) {
            return this.d;
        }
        if ("sp_net".equals(str)) {
            return this.ka;
        }
        return null;
    }

    public void ms(JSONObject jSONObject, String str) {
        LinkedList<JSONObject> linkedListMs = ms(str);
        if (linkedListMs == null) {
            return;
        }
        linkedListMs.add(jSONObject);
        if (linkedListMs.size() > this.c) {
            linkedListMs.removeFirst();
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jAh = jCurrentTimeMillis - ka.ms().ah();
        Iterator<JSONObject> it = linkedListMs.iterator();
        JSONObject jSONObject2 = null;
        while (it.hasNext()) {
            JSONObject next = it.next();
            long jOptLong = next.optLong(bv.aI, 0L);
            if (jOptLong < jAh) {
                it.remove();
                jSONObject2 = next;
            } else if (jOptLong > jCurrentTimeMillis) {
                it.remove();
            }
        }
        if (jSONObject2 != null && linkedListMs.size() < 2) {
            linkedListMs.addFirst(jSONObject2);
        }
        ms(str, linkedListMs);
    }

    public synchronized void xr(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if ("android.intent.action.SCREEN_OFF".equals(str)) {
            LinkedList<JSONObject> linkedListMs = ms("sp_screen");
            int iOptInt = 1;
            if (linkedListMs != null && linkedListMs.size() > 0) {
                JSONObject last = linkedListMs.getLast();
                if (last.optLong(bv.aI, 0L) / 3600000 == jCurrentTimeMillis / 3600000) {
                    iOptInt = 1 + last.optInt("val", 0);
                    linkedListMs.removeLast();
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(bv.aI, jCurrentTimeMillis);
                jSONObject.put("val", iOptInt);
                ms(jSONObject, "sp_screen");
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void ms(int i) {
        int iOptInt;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (i == 4) {
            iOptInt = 1;
        } else {
            iOptInt = i > 0 ? 2 : 0;
        }
        LinkedList<JSONObject> linkedListMs = ms("sp_net");
        if (linkedListMs != null && linkedListMs.size() > 0) {
            JSONObject last = linkedListMs.getLast();
            if (last.optLong(bv.aI, 0L) / 3600000 == jCurrentTimeMillis / 3600000) {
                iOptInt |= last.optInt("val", 0);
                linkedListMs.removeLast();
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(bv.aI, jCurrentTimeMillis);
            jSONObject.put("val", iOptInt);
            ms(jSONObject, "sp_net");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private LinkedList<JSONObject> ah(String str) {
        LinkedList<JSONObject> linkedList = new LinkedList<>();
        SharedPreferences sharedPreferences = this.xr;
        if (sharedPreferences == null) {
            return linkedList;
        }
        String string = sharedPreferences.getString(str, "");
        if (!TextUtils.isEmpty(string)) {
            for (String str2 : string.split("\\|")) {
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        linkedList.add(new JSONObject(str2));
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return linkedList;
    }

    public void ms(String str, LinkedList<JSONObject> linkedList) {
        if (linkedList == null || this.xr == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<JSONObject> it = linkedList.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            sb.append("\\|");
        }
        SharedPreferences.Editor editorEdit = this.xr.edit();
        editorEdit.putString(str, sb.toString());
        editorEdit.apply();
    }

    public LinkedList<JSONObject> ms(long j) {
        if (j == 0) {
            return this.ah;
        }
        LinkedList<JSONObject> linkedList = new LinkedList<>();
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = null;
        for (JSONObject jSONObject2 : this.ah) {
            if (jCurrentTimeMillis - jSONObject2.optLong(bv.aI, 0L) < j) {
                linkedList.add(jSONObject2);
            } else {
                jSONObject = jSONObject2;
            }
        }
        if (jSONObject != null && linkedList.size() < 2) {
            linkedList.addFirst(jSONObject);
        }
        return linkedList;
    }
}
