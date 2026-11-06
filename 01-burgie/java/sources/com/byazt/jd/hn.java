package com.byazt.jd;

import android.content.Context;
import com.byazt.id.UGTextView;
import com.tapsdk.tapad.group.constants.Constants;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 93, 20})
public class hn extends com.byazt.id.hw {
    public String ks;
    public String p;
    public String sr;
    public String wz;
    public String xb;

    public hn(Context context) {
        super(context);
    }

    @Override // com.byazt.id.hw, com.byazt.ik.hn
    public void hw() {
        super.hw();
        w(this.pr);
        ((UGTextView) this.c).setGravity(17);
    }

    public void pr(int i, int i2, int i3, boolean z, boolean z2) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("remain", i);
            jSONObject.put(Constants.INDEX_FIELD, i2);
            jSONObject.put("count", i3);
            boolean z3 = i2 == 1;
            if (z) {
                if (z3) {
                    str = this.wz;
                } else {
                    str = this.xb;
                }
            } else if (z2) {
                str = this.sr;
            } else {
                str = this.ks;
            }
            Matcher matcher = Pattern.compile("\\$\\{([^}]+)\\}").matcher(str);
            StringBuffer stringBuffer = new StringBuffer();
            while (matcher.find()) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(jSONObject.optString(matcher.group(1), "")));
            }
            matcher.appendTail(stringBuffer);
            String string = stringBuffer.toString();
            this.p = string;
            w(string);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void w(String str) {
        ((UGTextView) this.c).setText(str);
        try {
            float fMeasureText = ((UGTextView) this.c).getPaint().measureText(str);
            if (fMeasureText >= 0.0f) {
                x((int) fMeasureText);
            }
        } catch (Throwable th) {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x0033  */
    @Override // com.byazt.id.hw, com.byazt.ik.hn
    public void pr(String str, String str2) {
        super.pr(str, str2);
        switch (str) {
            case "text1":
                this.ks = str2;
                break;
            case "text2":
                this.sr = str2;
                break;
            case "text3":
                this.wz = str2;
                break;
            case "text4":
                this.xb = str2;
                break;
        }
    }
}
