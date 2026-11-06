package com.byazt.kg;

import android.content.ContentValues;
import android.database.Cursor;
import com.byazt.ec.w;
import com.taptap.sdk.db.constant.Common;
import com.umeng.analytics.pro.ar;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 421, 37})
public abstract class pr implements Cloneable {
    public static final SimpleDateFormat k = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    public int aj;
    public long c;
    public String fw;
    public long hn;
    public long hw;
    public long pr;
    public String uc;
    public int vk;
    public String w;
    public String x;
    public String zo;

    public abstract JSONObject hw() throws JSONException;

    public abstract String x();

    public pr() {
        pr(0L);
    }

    public void pr(long j) {
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        this.hw = j;
    }

    public List<String> pr() {
        return Arrays.asList(ar.d, "integer primary key autoincrement", "local_time_ms", "integer", "tea_event_index", "integer", "nt", "integer", Common.System.USER_ID, "integer", "session_id", "varchar", "user_unique_id", "varchar", "ssid", "varchar", "ab_sdk_version", "varchar", "event_type", "integer");
    }

    public int pr(Cursor cursor) {
        this.pr = cursor.getLong(0);
        this.hw = cursor.getLong(1);
        this.hn = cursor.getLong(2);
        this.aj = cursor.getInt(3);
        this.c = cursor.getLong(4);
        this.x = cursor.getString(5);
        this.uc = cursor.getString(6);
        this.fw = cursor.getString(7);
        this.zo = cursor.getString(8);
        this.vk = cursor.getInt(9);
        return 10;
    }

    public void pr(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.hw));
        contentValues.put("tea_event_index", Long.valueOf(this.hn));
        contentValues.put("nt", Integer.valueOf(this.aj));
        contentValues.put(Common.System.USER_ID, Long.valueOf(this.c));
        contentValues.put("session_id", this.x);
        contentValues.put("user_unique_id", this.uc);
        contentValues.put("ssid", this.fw);
        contentValues.put("ab_sdk_version", this.zo);
        contentValues.put("event_type", Integer.valueOf(this.vk));
    }

    public static String hw(long j) {
        return k.format(new Date(j));
    }

    public void pr(JSONObject jSONObject) throws JSONException {
        jSONObject.put("local_time_ms", this.hw);
    }

    public pr hw(JSONObject jSONObject) {
        this.hw = jSONObject.optLong("local_time_ms", 0L);
        this.pr = 0L;
        this.hn = 0L;
        this.aj = 0;
        this.c = 0L;
        this.x = null;
        this.uc = null;
        this.fw = null;
        this.zo = null;
        return this;
    }

    public final ContentValues hw(ContentValues contentValues) {
        if (contentValues == null) {
            contentValues = new ContentValues();
        } else {
            contentValues.clear();
        }
        pr(contentValues);
        return contentValues;
    }

    public final String hn() {
        List<String> listPr = pr();
        if (listPr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append("create table if not exists ").append(x()).append("(");
        for (int i = 0; i < listPr.size(); i += 2) {
            sb.append(listPr.get(i)).append(" ").append(listPr.get(i + 1)).append(",");
        }
        sb.delete(sb.length() - 1, sb.length());
        sb.append(")");
        return sb.toString();
    }

    public final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("k_cls", x());
            pr(jSONObject);
        } catch (JSONException e) {
            w.hw(e);
        }
        return jSONObject;
    }

    public final JSONObject uc() {
        try {
            this.w = hw(this.hw);
            return hw();
        } catch (JSONException e) {
            w.hw(e);
            return null;
        }
    }

    public static pr pr(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return hw.hw.get(jSONObject.optString("k_cls", "")).clone().hw(jSONObject);
        } catch (Throwable th) {
            w.hw(th);
            return null;
        }
    }

    /* JADX INFO: renamed from: fw, reason: merged with bridge method [inline-methods] */
    public pr clone() {
        try {
            return (pr) super.clone();
        } catch (CloneNotSupportedException e) {
            w.hw(e);
            return null;
        }
    }

    public String toString() {
        String strX = x();
        if (!getClass().getSimpleName().equalsIgnoreCase(strX)) {
            strX = strX + ", " + getClass().getSimpleName();
        }
        String strSubstring = this.x;
        String str = "-";
        if (strSubstring != null) {
            int iIndexOf = strSubstring.indexOf("-");
            if (iIndexOf >= 0) {
                strSubstring = strSubstring.substring(0, iIndexOf);
            }
            str = strSubstring;
        }
        return "{" + strX + ", " + zo() + ", " + str + ", " + this.hw + "}";
    }

    public String zo() {
        return "sid:" + this.x;
    }

    public String aj() {
        return null;
    }
}
