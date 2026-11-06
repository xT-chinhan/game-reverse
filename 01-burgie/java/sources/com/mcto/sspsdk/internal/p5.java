package com.mcto.sspsdk.internal;

import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.component.button.DownloadButtonView;
import com.mcto.sspsdk.component.imageview.QYNiceImageView;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class p5 {
    public final View a;
    public final ConstraintLayout b;
    public final DownloadButtonView c;
    public final p d;
    public final l5 e = new l5(this);

    public p5(View view, p pVar) {
        TextView textView;
        this.a = view;
        this.d = pVar;
        StringBuilder sb = new StringBuilder(pVar.i().optString(BundleKey.TITLE) + " >");
        String strOptString = pVar.i().optString("apkName");
        HashMap map = new HashMap(8);
        JSONObject jSONObject = pVar.H0;
        int i = 0;
        if (jSONObject != null) {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if ("ext".equals(next)) {
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ext");
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                        if (jSONObjectOptJSONObject.has(BreakpointSQLiteKey.URL)) {
                            map.put(jSONObjectOptJSONObject.optString(BundleKey.TITLE), jSONObjectOptJSONObject.optString(BreakpointSQLiteKey.URL));
                        } else {
                            sb.append("\n").append(jSONObjectOptJSONObject.optString(BundleKey.TITLE));
                        }
                    }
                } else if (!TextUtils.equals("appName", next)) {
                    JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(next);
                    if (jSONObjectOptJSONObject2.has(BreakpointSQLiteKey.URL)) {
                        map.put(jSONObjectOptJSONObject2.optString(BundleKey.TITLE), jSONObjectOptJSONObject2.optString(BreakpointSQLiteKey.URL));
                    } else {
                        sb.append("\n").append(jSONObjectOptJSONObject2.optString(BundleKey.TITLE));
                    }
                }
            }
        }
        float fNextInt = (new Random((!TextUtils.isEmpty(pVar.P) ? pVar.P : pVar.v).hashCode()).nextInt(5) / 10.0f) + 4.5f;
        ConstraintLayout constraintLayout = (ConstraintLayout) LayoutInflater.from(view.getContext()).inflate(R.layout.qy_layout_download_confirm_dialog, (ViewGroup) null);
        this.b = constraintLayout;
        ((TextView) constraintLayout.findViewById(R.id.qy_download_confirm_title)).setText(sb);
        ((TextView) constraintLayout.findViewById(R.id.qy_download_confirm_app_name)).setText(pVar.P);
        ((TextView) constraintLayout.findViewById(R.id.qy_download_confirm_app_score_star)).setText("" + fNextInt);
        ((TextView) constraintLayout.findViewById(R.id.qy_download_confirm_app_score)).setText(gj.a((new Random((!TextUtils.isEmpty(pVar.P) ? pVar.P : pVar.v).hashCode()).nextInt(14) + 5) * (((new Random((!TextUtils.isEmpty(pVar.P) ? pVar.P : pVar.v).hashCode()).nextInt(999) * 10000) + 10) / 100)) + "人评分");
        ((TextView) constraintLayout.findViewById(R.id.qy_download_confirm_app_download_count)).setText(gj.a((new Random((!TextUtils.isEmpty(pVar.P) ? pVar.P : pVar.v).hashCode()).nextInt(999) * 10000) + 10) + "+");
        if (fNextInt >= 4.8f && (textView = (TextView) constraintLayout.findViewById(R.id.qy_download_confirm_app_label)) != null) {
            textView.setText("高分精选应用");
        }
        constraintLayout.findViewById(R.id.qy_download_confirm_app_btn_detail_page).setOnClickListener(this.e);
        QYNiceImageView qYNiceImageView = (QYNiceImageView) constraintLayout.findViewById(R.id.qy_download_confirm_app_icon);
        qYNiceImageView.a(pVar.Q);
        qYNiceImageView.a(5, 0, 0);
        qYNiceImageView.setOnClickListener(new m5());
        QYNiceImageView qYNiceImageView2 = (QYNiceImageView) constraintLayout.findViewById(R.id.qy_download_confirm_cover_image);
        if (qYNiceImageView2 != null) {
            qYNiceImageView2.a(pVar.h());
            qYNiceImageView2.a(10, 0, 0);
        }
        DownloadButtonView downloadButtonView = (DownloadButtonView) constraintLayout.findViewById(R.id.qy_download_confirm_app_btn_download);
        this.c = downloadButtonView;
        downloadButtonView.b(hk.a(view.getContext(), 10.0f));
        h hVar = new h(downloadButtonView);
        hVar.a(pVar.E, strOptString);
        downloadButtonView.a(hVar);
        downloadButtonView.setOnClickListener(this.e);
        LinearLayout linearLayout = (LinearLayout) constraintLayout.findViewById(R.id.qy_download_confirm_app_detail_link);
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            TextView textView2 = new TextView(this.a.getContext());
            textView2.setText(str);
            textView2.setTextColor(1291845632);
            textView2.setPaintFlags(textView2.getPaintFlags() | 8);
            textView2.setTextSize(10.0f);
            textView2.setOnClickListener(new o5(str2));
            textView2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            int i3 = i + 1;
            if (i != 0) {
                layoutParams.leftMargin = hk.a(view.getContext(), 10.0f);
            }
            linearLayout.addView(textView2, layoutParams);
            i = i3;
        }
    }
}
