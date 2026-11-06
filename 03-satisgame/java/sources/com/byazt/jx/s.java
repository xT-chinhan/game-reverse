package com.byazt.jx;

import android.content.Context;
import com.byazt.ud.UGTextView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 508, 8})
public class s extends com.byazt.ud.qg {
    public String dm;
    public String nk;
    public String o;
    public String vo;
    public String ze;

    public s(Context context) {
        super(context);
    }

    @Override // com.byazt.ud.qg, com.byazt.ih.s
    public void qg() {
        super.qg();
        d(this.n);
        ((UGTextView) this.l).setGravity(17);
    }

    public void n(int i, int i2, int i3, boolean z, boolean z2) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("remain", i);
            jSONObject.put("index", i2);
            jSONObject.put("count", i3);
            boolean z3 = i2 == 1;
            if (z) {
                if (z3) {
                    str = this.o;
                } else {
                    str = this.nk;
                }
            } else if (z2) {
                str = this.vo;
            } else {
                str = this.dm;
            }
            Matcher matcher = Pattern.compile("\\$\\{([^}]+)\\}").matcher(str);
            StringBuffer stringBuffer = new StringBuffer();
            while (matcher.find()) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(jSONObject.optString(matcher.group(1), "")));
            }
            matcher.appendTail(stringBuffer);
            String string = stringBuffer.toString();
            this.ze = string;
            d(string);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void d(String str) {
        ((UGTextView) this.l).setText(str);
        try {
            float fMeasureText = ((UGTextView) this.l).getPaint().measureText(str);
            if (fMeasureText >= 0.0f) {
                q((int) fMeasureText);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.ud.qg, com.byazt.ih.s
    public void n(String str, String str2) {
        super.n(str, str2);
        str.hashCode();
        switch (str) {
            case "text1":
                this.dm = str2;
                break;
            case "text2":
                this.vo = str2;
                break;
            case "text3":
                this.o = str2;
                break;
            case "text4":
                this.nk = str2;
                break;
        }
    }
}
