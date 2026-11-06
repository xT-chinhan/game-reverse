package com.byazt.ko;

import android.content.Context;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2319, 29})
public class cp extends s {
    public final Context l;

    public cp(Context context) {
        super(true, true);
        this.l = context;
    }

    @Override // com.byazt.ko.s
    public boolean n(JSONObject jSONObject) throws JSONException {
        rv.n(jSONObject, "language", this.l.getResources().getConfiguration().locale.getLanguage());
        jSONObject.put("timezone", com.byazt.km.n.s());
        rv.n(jSONObject, "region", Locale.getDefault().getCountry());
        TimeZone timeZone = Calendar.getInstance().getTimeZone();
        rv.n(jSONObject, "tz_name", timeZone.getID());
        jSONObject.put("tz_offset", timeZone.getOffset(System.currentTimeMillis() / 1000));
        return true;
    }
}
