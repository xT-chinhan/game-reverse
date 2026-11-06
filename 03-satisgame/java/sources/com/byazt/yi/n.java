package com.byazt.yi;

import android.content.ContentValues;
import android.database.Cursor;
import com.anythink.core.common.l.f;
import com.byazt.km.cp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 200, 19})
public abstract class n implements Cloneable {
    public static final SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    public String cp;
    public String fs;
    public long l;
    public long n;
    public String q;
    public long qg;
    public int rv;
    public long s;
    public int tj;
    public String w;
    public String x;

    public abstract String q();

    public abstract JSONObject qg() throws JSONException;

    public String rv() {
        return null;
    }

    public n() {
        n(0L);
    }

    public void n(long j) {
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        this.qg = j;
    }

    public List<String> n() {
        return Arrays.asList("_id", "integer primary key autoincrement", "local_time_ms", "integer", "tea_event_index", "integer", "nt", "integer", "user_id", "integer", f.bo, "varchar", "user_unique_id", "varchar", "ssid", "varchar", "ab_sdk_version", "varchar", "event_type", "integer");
    }

    public int n(Cursor cursor) {
        this.n = cursor.getLong(0);
        this.qg = cursor.getLong(1);
        this.s = cursor.getLong(2);
        this.rv = cursor.getInt(3);
        this.l = cursor.getLong(4);
        this.q = cursor.getString(5);
        this.w = cursor.getString(6);
        this.x = cursor.getString(7);
        this.fs = cursor.getString(8);
        this.tj = cursor.getInt(9);
        return 10;
    }

    public void n(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.qg));
        contentValues.put("tea_event_index", Long.valueOf(this.s));
        contentValues.put("nt", Integer.valueOf(this.rv));
        contentValues.put("user_id", Long.valueOf(this.l));
        contentValues.put(f.bo, this.q);
        contentValues.put("user_unique_id", this.w);
        contentValues.put("ssid", this.x);
        contentValues.put("ab_sdk_version", this.fs);
        contentValues.put("event_type", Integer.valueOf(this.tj));
    }

    public static String qg(long j) {
        return d.format(new Date(j));
    }

    public void n(JSONObject jSONObject) throws JSONException {
        jSONObject.put("local_time_ms", this.qg);
    }

    public n qg(JSONObject jSONObject) {
        this.qg = jSONObject.optLong("local_time_ms", 0L);
        this.n = 0L;
        this.s = 0L;
        this.rv = 0;
        this.l = 0L;
        this.q = null;
        this.w = null;
        this.x = null;
        this.fs = null;
        return this;
    }

    public final ContentValues qg(ContentValues contentValues) {
        if (contentValues == null) {
            contentValues = new ContentValues();
        } else {
            contentValues.clear();
        }
        n(contentValues);
        return contentValues;
    }

    public final String s() {
        List<String> listN = n();
        if (listN == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append("create table if not exists ").append(q()).append("(");
        for (int i = 0; i < listN.size(); i += 2) {
            sb.append(listN.get(i)).append(" ").append(listN.get(i + 1)).append(",");
        }
        sb.delete(sb.length() - 1, sb.length());
        sb.append(")");
        return sb.toString();
    }

    public final JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("k_cls", q());
            n(jSONObject);
        } catch (JSONException e) {
            cp.qg(e);
        }
        return jSONObject;
    }

    public final JSONObject w() {
        try {
            this.cp = qg(this.qg);
            return qg();
        } catch (JSONException e) {
            cp.qg(e);
            return null;
        }
    }

    public static n n(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return qg.qg.get(jSONObject.optString("k_cls", "")).clone().qg(jSONObject);
        } catch (Throwable th) {
            cp.qg(th);
            return null;
        }
    }

    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public n clone() {
        try {
            return (n) super.clone();
        } catch (CloneNotSupportedException e) {
            cp.qg(e);
            return null;
        }
    }

    public String toString() {
        String strQ = q();
        if (!getClass().getSimpleName().equalsIgnoreCase(strQ)) {
            strQ = strQ + ", " + getClass().getSimpleName();
        }
        String strSubstring = this.q;
        String str = "-";
        if (strSubstring != null) {
            int iIndexOf = strSubstring.indexOf("-");
            if (iIndexOf >= 0) {
                strSubstring = strSubstring.substring(0, iIndexOf);
            }
            str = strSubstring;
        }
        return "{" + strQ + ", " + fs() + ", " + str + ", " + this.qg + "}";
    }

    public String fs() {
        return "sid:" + this.q;
    }
}
