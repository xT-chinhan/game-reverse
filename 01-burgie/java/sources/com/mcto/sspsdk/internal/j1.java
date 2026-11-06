package com.mcto.sspsdk.internal;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.UnderlineSpan;
import android.widget.TextView;
import com.mcto.sspsdk.R;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j1 {
    public static boolean a(Context context, JSONObject jSONObject, TextView textView) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return false;
        }
        Iterator<String> itKeys = jSONObject.keys();
        HashMap map = new HashMap(4);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if ("ext".equals(next)) {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ext");
                if (jSONArrayOptJSONArray != null) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject.has(BreakpointSQLiteKey.URL)) {
                            map.put(jSONObjectOptJSONObject.optString(BundleKey.TITLE), jSONObjectOptJSONObject.optString(BreakpointSQLiteKey.URL));
                        } else {
                            if (spannableStringBuilder.length() > 0) {
                                spannableStringBuilder.append((CharSequence) " | ");
                            }
                            spannableStringBuilder.append((CharSequence) jSONObjectOptJSONObject.optString(BundleKey.TITLE));
                        }
                    }
                }
            } else {
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(next);
                if (jSONObjectOptJSONObject2 != null) {
                    if (jSONObjectOptJSONObject2.has(BreakpointSQLiteKey.URL)) {
                        map.put(jSONObjectOptJSONObject2.optString(BundleKey.TITLE), jSONObjectOptJSONObject2.optString(BreakpointSQLiteKey.URL));
                    } else {
                        if (spannableStringBuilder.length() > 0) {
                            spannableStringBuilder.append((CharSequence) " | ");
                        }
                        spannableStringBuilder.append((CharSequence) jSONObjectOptJSONObject2.optString(BundleKey.TITLE));
                    }
                }
            }
        }
        if (spannableStringBuilder.length() == 0) {
            return false;
        }
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            spannableStringBuilder.append((CharSequence) " | ");
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) str);
            spannableStringBuilder.setSpan(new i1(textView, str, str2), length, spannableStringBuilder.length(), 33);
            spannableStringBuilder.setSpan(new UnderlineSpan(), length, spannableStringBuilder.length(), 33);
        }
        textView.setText(spannableStringBuilder);
        textView.setTextColor(context.getResources().getColor(R.color.qy_text_color_black_30alpha));
        textView.setTextSize(1, 10.0f);
        textView.setGravity(16);
        textView.setPadding((int) ((context.getResources().getDisplayMetrics().density * 5.0f) + 0.5f), 0, (int) ((context.getResources().getDisplayMetrics().density * 5.0f) + 0.5f), 0);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        return true;
    }

    public static TextView a(Context context, JSONObject jSONObject) {
        Iterator<String> itKeys = jSONObject.keys();
        HashMap map = new HashMap(4);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        while (true) {
            if (!itKeys.hasNext()) {
                break;
            }
            String next = itKeys.next();
            if ("ext".equals(next)) {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ext");
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject.has(BreakpointSQLiteKey.URL)) {
                        map.put(jSONObjectOptJSONObject.optString(BundleKey.TITLE), jSONObjectOptJSONObject.optString(BreakpointSQLiteKey.URL));
                    } else {
                        if (spannableStringBuilder.length() > 0) {
                            spannableStringBuilder.append((CharSequence) " | ");
                        }
                        spannableStringBuilder.append((CharSequence) jSONObjectOptJSONObject.optString(BundleKey.TITLE));
                    }
                }
            } else {
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(next);
                if (jSONObjectOptJSONObject2.has(BreakpointSQLiteKey.URL)) {
                    map.put(jSONObjectOptJSONObject2.optString(BundleKey.TITLE), jSONObjectOptJSONObject2.optString(BreakpointSQLiteKey.URL));
                } else {
                    if (spannableStringBuilder.length() > 0) {
                        spannableStringBuilder.append((CharSequence) " | ");
                    }
                    spannableStringBuilder.append((CharSequence) jSONObjectOptJSONObject2.optString(BundleKey.TITLE));
                }
            }
        }
        TextView textView = new TextView(context);
        textView.setId(R.id.qy_card_app_developer_info);
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            spannableStringBuilder.append((CharSequence) " | ");
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) str);
            spannableStringBuilder.setSpan(new i1(textView, str, str2), length, spannableStringBuilder.length(), 33);
            spannableStringBuilder.setSpan(new UnderlineSpan(), length, spannableStringBuilder.length(), 33);
        }
        textView.setText(spannableStringBuilder);
        textView.setTextColor(context.getResources().getColor(R.color.qy_text_color_black_30alpha));
        textView.setTextSize(1, 9.0f);
        textView.setGravity(16);
        textView.setPadding((int) ((context.getResources().getDisplayMetrics().density * 5.0f) + 0.5f), 0, (int) ((context.getResources().getDisplayMetrics().density * 5.0f) + 0.5f), 0);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        return textView;
    }
}
