package com.bytedance.adsdk.ugeno.widget.input;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;
import com.bytedance.adsdk.ugeno.xr.ah;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends ah<EditText> {
    private int cc;
    private String cj;
    private String gs;
    private float kl;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f419ms;
    private int nl;
    private String qo;
    private int r;
    private int vf;
    private String wq;

    public ms(Context context) {
        super(context);
        this.f419ms = 1;
        this.r = Integer.MAX_VALUE;
        this.cc = 2;
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    /* JADX INFO: renamed from: ab, reason: merged with bridge method [inline-methods] */
    public EditText ms() {
        UGEditText uGEditText = new UGEditText(this.xr);
        uGEditText.ms(this);
        return uGEditText;
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void xr() {
        super.xr();
        ((EditText) this.ka).setInputType(this.f419ms);
        ((EditText) this.ka).setText(this.cj);
        ((EditText) this.ka).setTextSize(1, this.kl);
        ((EditText) this.ka).setTextColor(this.vf);
        ((EditText) this.ka).setLines(this.nl);
        ((EditText) this.ka).setMaxLines(this.r);
        ((EditText) this.ka).setGravity(this.cc);
        ((EditText) this.ka).setHint(this.wq);
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void ms(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.ms(str, str2);
        str.hashCode();
        switch (str) {
            case "textAlign":
                this.cc = ny(str2);
                break;
            case "textColor":
                this.vf = com.bytedance.adsdk.ugeno.c.ms.ms(str2);
                break;
            case "textStyle":
                this.gs = str2;
                break;
            case "textSize":
                this.kl = Float.parseFloat(str2);
                break;
            case "hint":
                this.wq = str2;
                break;
            case "text":
                this.cj = str2;
                break;
            case "lines":
                this.nl = Integer.parseInt(str2);
                break;
            case "maxLines":
                this.r = Integer.parseInt(str2);
                break;
            case "ellipsize":
                this.qo = str2;
                break;
            case "inputType":
                this.f419ms = x(str2);
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x003d  */
    private int x(String str) {
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

    private int ny(String str) {
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
