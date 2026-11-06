package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class tz implements Cloneable {
    private static final SimpleDateFormat sl = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    public String ab;
    public long ah;
    public String c;
    public int ch;
    public String d;
    String hi;
    public long ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    long f529ms;
    public int ny;
    public String x;
    public long xr;

    abstract String d();

    protected String ny() {
        return null;
    }

    protected abstract JSONObject xr();

    public tz() {
        ms(0L);
    }

    public void ms(long j) {
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        this.xr = j;
    }

    protected List<String> ms() {
        return Arrays.asList(com.umeng.analytics.pro.bz.d, "integer primary key autoincrement", "local_time_ms", "integer", "tea_event_index", "integer", "nt", "integer", "user_id", "integer", "session_id", "varchar", "user_unique_id", "varchar", "ssid", "varchar", "ab_sdk_version", "varchar", com.anythink.core.common.e.a.C0080a.b, "integer");
    }

    public int ms(Cursor cursor) {
        this.f529ms = cursor.getLong(0);
        this.xr = cursor.getLong(1);
        this.ah = cursor.getLong(2);
        this.ny = cursor.getInt(3);
        this.ka = cursor.getLong(4);
        this.d = cursor.getString(5);
        this.c = cursor.getString(6);
        this.ab = cursor.getString(7);
        this.x = cursor.getString(8);
        this.ch = cursor.getInt(9);
        return 10;
    }

    protected void ms(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.xr));
        contentValues.put("tea_event_index", Long.valueOf(this.ah));
        contentValues.put("nt", Integer.valueOf(this.ny));
        contentValues.put("user_id", Long.valueOf(this.ka));
        contentValues.put("session_id", this.d);
        contentValues.put("user_unique_id", this.c);
        contentValues.put("ssid", this.ab);
        contentValues.put("ab_sdk_version", this.x);
        contentValues.put(com.anythink.core.common.e.a.C0080a.b, Integer.valueOf(this.ch));
    }

    public static String xr(long j) {
        return sl.format(new Date(j));
    }

    protected void ms(JSONObject jSONObject) throws JSONException {
        jSONObject.put("local_time_ms", this.xr);
    }

    protected tz xr(JSONObject jSONObject) {
        this.xr = jSONObject.optLong("local_time_ms", 0L);
        this.f529ms = 0L;
        this.ah = 0L;
        this.ny = 0;
        this.ka = 0L;
        this.d = null;
        this.c = null;
        this.ab = null;
        this.x = null;
        return this;
    }

    final ContentValues xr(ContentValues contentValues) {
        if (contentValues == null) {
            contentValues = new ContentValues();
        } else {
            contentValues.clear();
        }
        ms(contentValues);
        return contentValues;
    }

    final String ah() {
        List<String> listMs = ms();
        if (listMs == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append("create table if not exists ").append(d()).append("(");
        for (int i = 0; i < listMs.size(); i += 2) {
            sb.append(listMs.get(i)).append(" ").append(listMs.get(i + 1)).append(",");
        }
        sb.delete(sb.length() - 1, sb.length());
        sb.append(")");
        return sb.toString();
    }

    public final JSONObject ka() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("k_cls", d());
            ms(jSONObject);
        } catch (JSONException e) {
            oh.xr(e);
        }
        return jSONObject;
    }

    public final JSONObject c() {
        try {
            this.hi = xr(this.xr);
            return xr();
        } catch (JSONException e) {
            oh.xr(e);
            return null;
        }
    }

    public static tz ms(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return ti.xr.get(jSONObject.optString("k_cls", "")).clone().xr(jSONObject);
        } catch (Throwable th) {
            oh.xr(th);
            return null;
        }
    }

    /* JADX INFO: renamed from: ab, reason: merged with bridge method [inline-methods] */
    public tz clone() {
        try {
            return (tz) super.clone();
        } catch (CloneNotSupportedException e) {
            oh.xr(e);
            return null;
        }
    }

    public String toString() {
        String strD = d();
        if (!getClass().getSimpleName().equalsIgnoreCase(strD)) {
            strD = strD + ", " + getClass().getSimpleName();
        }
        String strSubstring = this.d;
        String str = "-";
        if (strSubstring != null) {
            int iIndexOf = strSubstring.indexOf("-");
            if (iIndexOf >= 0) {
                strSubstring = strSubstring.substring(0, iIndexOf);
            }
            str = strSubstring;
        }
        return "{" + strD + ", " + x() + ", " + str + ", " + this.xr + "}";
    }

    protected String x() {
        return "sid:" + this.d;
    }
}
