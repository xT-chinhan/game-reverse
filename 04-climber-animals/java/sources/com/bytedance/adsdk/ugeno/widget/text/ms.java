package com.bytedance.adsdk.ugeno.widget.text;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.xr.ah;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends ah<RichTextView> {
    private int cc;
    private String gs;
    private float kl;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f429ms;
    private int nl;
    private String qo;
    private int r;
    private int vf;

    public ms(Context context) {
        super(context);
        this.r = Integer.MAX_VALUE;
        this.cc = 2;
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    /* JADX INFO: renamed from: ab, reason: merged with bridge method [inline-methods] */
    public RichTextView ms() {
        RichTextView richTextView = new RichTextView(this.xr);
        richTextView.ms(this);
        return richTextView;
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void xr() {
        super.xr();
        ((RichTextView) this.ka).setRichText(this.f429ms);
        ((RichTextView) this.ka).setTextSize(1, this.kl);
        ((RichTextView) this.ka).setTextColor(this.vf);
        ((RichTextView) this.ka).setLines(this.nl);
        ((RichTextView) this.ka).setMaxLines(this.r);
        ((RichTextView) this.ka).setGravity(this.cc);
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void ms(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.ms(str, str2);
        str.hashCode();
        switch (str) {
            case "textAlign":
                this.cc = x(str2);
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
            case "text":
                this.f429ms = str2;
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
        }
    }

    private int x(String str) {
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
