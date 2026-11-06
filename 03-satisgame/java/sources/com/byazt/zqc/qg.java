package com.byazt.zqc;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.byakv.z.SoftDecTool;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_START_TIME, 26})
public class qg {
    public static volatile qg n;
    public LinkedList<JSONObject> l;
    public LinkedList<JSONObject> q;
    public SharedPreferences qg;
    public LinkedList<JSONObject> s;
    public long w;

    public qg() {
        this.qg = null;
        this.s = null;
        this.q = null;
        this.l = null;
        this.w = 0L;
        this.qg = SoftDecTool.getSharedPreferences("pithar");
        this.s = s("sp_angle");
        this.q = s("sp_screen");
        this.l = s("sp_net");
        this.w = l.n().s() / l.n().q();
    }

    public static qg n() {
        if (n == null) {
            synchronized (qg.class) {
                if (n == null) {
                    n = new qg();
                }
            }
        }
        return n;
    }

    public LinkedList<JSONObject> n(String str) {
        if ("sp_angle".equals(str)) {
            return this.s;
        }
        if ("sp_screen".equals(str)) {
            return this.q;
        }
        if ("sp_net".equals(str)) {
            return this.l;
        }
        return null;
    }

    public void n(JSONObject jSONObject, String str) {
        LinkedList<JSONObject> linkedListN = n(str);
        if (linkedListN == null) {
            return;
        }
        linkedListN.add(jSONObject);
        if (linkedListN.size() > this.w) {
            linkedListN.remove(0);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jS = jCurrentTimeMillis - l.n().s();
        Iterator<JSONObject> it = linkedListN.iterator();
        JSONObject jSONObject2 = null;
        while (it.hasNext()) {
            JSONObject next = it.next();
            long jOptLong = next.optLong("t", 0L);
            if (jOptLong < jS) {
                it.remove();
                jSONObject2 = next;
            } else if (jOptLong > jCurrentTimeMillis) {
                it.remove();
            }
        }
        if (jSONObject2 != null && linkedListN.size() < 2) {
            linkedListN.add(0, jSONObject2);
        }
        n(str, linkedListN);
    }

    public synchronized void qg(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if ("android.intent.action.SCREEN_OFF".equals(str)) {
            LinkedList<JSONObject> linkedListN = n("sp_screen");
            int i = 1;
            if (linkedListN != null && !linkedListN.isEmpty()) {
                JSONObject jSONObject = linkedListN.get(linkedListN.size() - 1);
                if (jSONObject.optLong("t", 0L) / 3600000 == jCurrentTimeMillis / 3600000) {
                    int iOptInt = jSONObject.optInt("val", 0) + 1;
                    linkedListN.remove(linkedListN.size() - 1);
                    i = iOptInt;
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("t", jCurrentTimeMillis);
                jSONObject2.put("val", i);
                n(jSONObject2, "sp_screen");
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void n(int i) {
        int iOptInt;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (i == 4) {
            iOptInt = 1;
        } else {
            iOptInt = i > 0 ? 2 : 0;
        }
        LinkedList<JSONObject> linkedListN = n("sp_net");
        if (linkedListN != null && !linkedListN.isEmpty()) {
            JSONObject jSONObject = linkedListN.get(linkedListN.size() - 1);
            if (jSONObject.optLong("t", 0L) / 3600000 == jCurrentTimeMillis / 3600000) {
                iOptInt |= jSONObject.optInt("val", 0);
                linkedListN.remove(linkedListN.size() - 1);
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("t", jCurrentTimeMillis);
            jSONObject2.put("val", iOptInt);
            n(jSONObject2, "sp_net");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private LinkedList<JSONObject> s(String str) {
        LinkedList<JSONObject> linkedList = new LinkedList<>();
        SharedPreferences sharedPreferences = this.qg;
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

    public void n(String str, LinkedList<JSONObject> linkedList) {
        if (linkedList == null || this.qg == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<JSONObject> it = linkedList.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            sb.append("\\|");
        }
        SharedPreferences.Editor editorEdit = this.qg.edit();
        editorEdit.putString(str, sb.toString());
        editorEdit.apply();
    }

    public LinkedList<JSONObject> n(long j) {
        if (j == 0) {
            return this.s;
        }
        LinkedList<JSONObject> linkedList = new LinkedList<>();
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = null;
        for (JSONObject jSONObject2 : this.s) {
            if (jCurrentTimeMillis - jSONObject2.optLong("t", 0L) < j) {
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
