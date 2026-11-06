package com.byazt.hj;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;
import com.byazt.ik.hn;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 598, 37})
public class pr extends hn<EditText> {
    public float fe;
    public String ks;
    public String ku;
    public int p;
    public int pr;
    public int qx;
    public int sr;
    public int wz;
    public String xb;
    public String xg;

    public pr(Context context) {
        super(context);
        this.pr = 1;
        this.sr = Integer.MAX_VALUE;
        this.p = 2;
    }

    @Override // com.byazt.ik.hn
    /* JADX INFO: renamed from: fw, reason: merged with bridge method [inline-methods] */
    public EditText pr() {
        UGEditText uGEditText = new UGEditText(this.hw);
        uGEditText.pr(this);
        return uGEditText;
    }

    @Override // com.byazt.ik.hn
    public void hw() {
        super.hw();
        ((EditText) this.c).setInputType(this.pr);
        ((EditText) this.c).setText(this.ku);
        ((EditText) this.c).setTextSize(1, this.fe);
        ((EditText) this.c).setTextColor(this.qx);
        ((EditText) this.c).setLines(this.wz);
        ((EditText) this.c).setMaxLines(this.sr);
        ((EditText) this.c).setGravity(this.p);
        ((EditText) this.c).setHint(this.xg);
    }

    @Override // com.byazt.ik.hn
    public void pr(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.pr(str, str2);
        switch (str) {
            case "text":
                this.ku = str2;
                break;
            case "textColor":
                this.qx = com.byazt.aa.pr.pr(str2);
                break;
            case "textSize":
                this.fe = Float.parseFloat(str2);
                break;
            case "textStyle":
                this.ks = str2;
                break;
            case "lines":
                this.wz = Integer.parseInt(str2);
                break;
            case "maxLines":
                this.sr = Integer.parseInt(str2);
                break;
            case "ellipsize":
                this.xb = str2;
                break;
            case "textAlign":
                this.p = k(str2);
                break;
            case "inputType":
                this.pr = w(str2);
                break;
            case "hint":
                this.xg = str2;
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x003d  */
    private int w(String str) {
        switch (str) {
            case "password":
                return 128;
            case "phone":
                return 3;
            case "number":
                return 2;
            case "email":
                return 32;
            case "text":
            default:
                return 1;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:14:0x0028  */
    private int k(String str) {
        switch (str) {
            case "left":
                return 3;
            case "right":
                return 5;
            case "center":
                return 17;
            default:
                return 2;
        }
    }
}
