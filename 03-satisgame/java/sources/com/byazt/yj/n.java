package com.byazt.yj;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;
import com.byazt.ih.s;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 505, 19})
public class n extends s<EditText> {
    public String bz;
    public String dm;
    public float ei;
    public int n;
    public String nk;
    public int o;
    public String qn;
    public int sq;
    public int vo;
    public int ze;

    public n(Context context) {
        super(context);
        this.n = 1;
        this.vo = Integer.MAX_VALUE;
        this.ze = 2;
    }

    @Override // com.byazt.ih.s
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public EditText n() {
        UGEditText uGEditText = new UGEditText(this.qg);
        uGEditText.n(this);
        return uGEditText;
    }

    @Override // com.byazt.ih.s
    public void qg() {
        super.qg();
        ((EditText) this.l).setInputType(this.n);
        ((EditText) this.l).setText(this.qn);
        ((EditText) this.l).setTextSize(1, this.ei);
        ((EditText) this.l).setTextColor(this.sq);
        ((EditText) this.l).setLines(this.o);
        ((EditText) this.l).setMaxLines(this.vo);
        ((EditText) this.l).setGravity(this.ze);
        ((EditText) this.l).setHint(this.bz);
    }

    @Override // com.byazt.ih.s
    public void n(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.n(str, str2);
        str.hashCode();
        switch (str) {
            case "textAlign":
                this.ze = oa(str2);
                break;
            case "textColor":
                this.sq = com.byazt.hb.n.n(str2);
                break;
            case "textStyle":
                this.dm = str2;
                break;
            case "textSize":
                this.ei = Float.parseFloat(str2);
                break;
            case "hint":
                this.bz = str2;
                break;
            case "text":
                this.qn = str2;
                break;
            case "lines":
                this.o = Integer.parseInt(str2);
                break;
            case "maxLines":
                this.vo = Integer.parseInt(str2);
                break;
            case "ellipsize":
                this.nk = str2;
                break;
            case "inputType":
                this.n = d(str2);
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x003d  */
    private int d(String str) {
        byte b;
        switch (str) {
            case "number":
                b = 2;
                break;
            case "text":
                b = 4;
                break;
            case "email":
                b = 3;
                break;
            case "phone":
                b = 1;
                break;
            case "password":
                b = 0;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            return 128;
        }
        if (b == 1) {
            return 3;
        }
        if (b != 2) {
            return b != 3 ? 1 : 32;
        }
        return 2;
    }

    private int oa(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                return 17;
            case "left":
                return 3;
            case "right":
                return 5;
            default:
                return 2;
        }
    }
}
