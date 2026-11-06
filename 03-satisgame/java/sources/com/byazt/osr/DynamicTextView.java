package com.byazt.osr;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.byazt.hkc.cp;
import com.byazt.lh.fs;
import com.byazt.stl.AnimationText;
import com.byazt.tk.k;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 38, 1229})
public class DynamicTextView extends DynamicBaseWidgetImp {
    public DynamicTextView(Context context, DynamicRootView dynamicRootView, fs fsVar) {
        super(context, dynamicRootView, fsVar);
        this.fs += 6;
        if (this.d.fi()) {
            this.k = new AnimationText(context, this.d.x(), this.d.l(), 1, this.d.fs());
            ((AnimationText) this.k).setMaxLines(1);
        } else {
            this.k = new TextView(context);
            ((TextView) this.k).setIncludeFontPadding(false);
        }
        this.k.setTag(Integer.valueOf(getClickArea()));
        addView(this.k, getWidgetLayoutParams());
    }

    @Override // com.byazt.osr.DynamicBaseWidgetImp, com.byazt.osr.q
    public boolean fs() {
        int i;
        double d;
        super.fs();
        if (TextUtils.isEmpty(getText())) {
            this.k.setVisibility(4);
            return true;
        }
        if (this.d.fi()) {
            cp();
            return true;
        }
        ((TextView) this.k).setText(this.d.w());
        ((TextView) this.k).setTextDirection(5);
        this.k.setTextAlignment(this.d.fs());
        ((TextView) this.k).setTextColor(this.d.x());
        ((TextView) this.k).setTextSize(this.d.l());
        if (!this.d.ou()) {
            ((TextView) this.k).setMaxLines(1);
            ((TextView) this.k).setGravity(17);
            ((TextView) this.k).setEllipsize(TextUtils.TruncateAt.END);
        } else {
            int iWm = this.d.wm();
            if (iWm > 0) {
                ((TextView) this.k).setLines(iWm);
                ((TextView) this.k).setEllipsize(TextUtils.TruncateAt.END);
            }
        }
        if (this.oa != null && this.oa.tj() != null) {
            if (com.byazt.twc.q.n() && rv() && (TextUtils.equals(this.oa.tj().getType(), "text_star") || TextUtils.equals(this.oa.tj().getType(), "score-count") || TextUtils.equals(this.oa.tj().getType(), "score-count-type-1") || TextUtils.equals(this.oa.tj().getType(), "score-count-type-2"))) {
                setVisibility(8);
                return true;
            }
            if (TextUtils.equals(this.oa.tj().getType(), "score-count") || TextUtils.equals(this.oa.tj().getType(), "score-count-type-2")) {
                try {
                    try {
                        i = Integer.parseInt(getText());
                    } catch (Exception unused) {
                    }
                } catch (NumberFormatException unused2) {
                    i = -1;
                }
                if (i < 0) {
                    if (com.byazt.twc.q.n()) {
                        setVisibility(8);
                        return true;
                    }
                    this.k.setVisibility(0);
                }
                if (TextUtils.equals(this.oa.tj().getType(), "score-count-type-2")) {
                    ((TextView) this.k).setText(String.format(new DecimalFormat("(###,###,###)").format(i), Integer.valueOf(i)));
                    ((TextView) this.k).setGravity(17);
                    return true;
                }
                n((TextView) this.k, i);
            } else if (TextUtils.equals(this.oa.tj().getType(), "text_star")) {
                try {
                    d = Double.parseDouble(getText());
                } catch (Exception e) {
                    k.qg("DynamicStarView applyNativeStyle", e.toString());
                    d = -1.0d;
                }
                if (d < 0.0d || d > 5.0d) {
                    if (com.byazt.twc.q.n()) {
                        setVisibility(8);
                        return true;
                    }
                    this.k.setVisibility(0);
                }
                ((TextView) this.k).setIncludeFontPadding(false);
                ((TextView) this.k).setText(String.format("%.1f", Double.valueOf(d)));
            } else if (TextUtils.equals("privacy-detail", this.oa.tj().getType())) {
                ((TextView) this.k).setText("功能 | 权限 | 隐私");
            } else if (TextUtils.equals(this.oa.tj().getType(), "development-name")) {
                ((TextView) this.k).setText("开发者：" + getText());
            } else if (TextUtils.equals(this.oa.tj().getType(), "app-version")) {
                ((TextView) this.k).setText("版本号：V" + getText());
            } else {
                ((TextView) this.k).setText(getText());
            }
            this.k.setTextAlignment(this.d.fs());
            ((TextView) this.k).setGravity(this.d.rv());
            if (com.byazt.twc.q.n()) {
                tj();
            }
        }
        return true;
    }

    private boolean rv() {
        return (this.sz == null || this.sz.getRenderRequest() == null || this.sz.getRenderRequest().d() == 4) ? false : true;
    }

    private void tj() {
        int iN;
        if (TextUtils.equals(this.oa.tj().getType(), "source") || TextUtils.equals(this.oa.tj().getType(), "title") || TextUtils.equals(this.oa.tj().getType(), "text_star")) {
            int[] iArrQg = cp.qg(this.d.w(), this.d.l(), true);
            int iN2 = (int) com.byazt.cq.fs.n(getContext(), this.d.qg());
            int iN3 = (int) com.byazt.cq.fs.n(getContext(), this.d.s());
            int iN4 = (int) com.byazt.cq.fs.n(getContext(), this.d.q());
            int iN5 = (int) com.byazt.cq.fs.n(getContext(), this.d.n());
            int iMin = Math.min(iN2, iN5);
            if (TextUtils.equals(this.oa.tj().getType(), "source") && (iN = ((this.fs - ((int) com.byazt.cq.fs.n(getContext(), this.d.l()))) - iN2) - iN5) > 1 && iN <= iMin * 2) {
                int i = iN / 2;
                this.k.setPadding(iN3, iN2 - i, iN4, iN5 - (iN - i));
                return;
            }
            int i2 = (((iArrQg[1] + iN2) + iN5) - this.fs) - 2;
            if (i2 <= 1) {
                return;
            }
            if (i2 <= iMin * 2) {
                int i3 = i2 / 2;
                this.k.setPadding(iN3, iN2 - i3, iN4, iN5 - (i2 - i3));
            } else if (i2 > iN2 + iN5) {
                final int i4 = (i2 - iN2) - iN5;
                this.k.setPadding(iN3, 0, iN4, 0);
                if (i4 <= ((int) com.byazt.cq.fs.n(getContext(), 1.0f)) + 1) {
                    ((TextView) this.k).setTextSize(this.d.l() - 1.0f);
                } else if (i4 <= (((int) com.byazt.cq.fs.n(getContext(), 1.0f)) + 1) * 2) {
                    ((TextView) this.k).setTextSize(this.d.l() - 2.0f);
                } else {
                    post(new Runnable() { // from class: com.byazt.osr.DynamicTextView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                ViewGroup.LayoutParams layoutParams = DynamicTextView.this.k.getLayoutParams();
                                layoutParams.height = DynamicTextView.this.fs + i4;
                                DynamicTextView.this.k.setLayoutParams(layoutParams);
                                DynamicTextView.this.k.setTranslationY(-i4);
                                ViewGroup viewGroup = (ViewGroup) DynamicTextView.this.k.getParent();
                                viewGroup.setClipChildren(false);
                                ViewGroup viewGroup2 = (ViewGroup) DynamicTextView.this.k.getParent().getParent();
                                viewGroup2.setClipChildren(false);
                            } catch (Throwable unused) {
                            }
                        }
                    });
                }
            } else if (iN2 > iN5) {
                this.k.setPadding(iN3, iN2 - (i2 - iMin), iN4, iN5 - iMin);
            } else {
                this.k.setPadding(iN3, iN2 - iMin, iN4, iN5 - (i2 - iMin));
            }
        }
        if (TextUtils.equals(this.oa.tj().getType(), "fillButton")) {
            this.k.setTextAlignment(2);
            ((TextView) this.k).setGravity(17);
        }
    }

    public String getText() {
        String strW = this.d.w();
        if (TextUtils.isEmpty(strW)) {
            if (!com.byazt.twc.q.n() && TextUtils.equals(this.oa.tj().getType(), "text_star")) {
                strW = "5";
            }
            if (!com.byazt.twc.q.n() && TextUtils.equals(this.oa.tj().getType(), "score-count")) {
                strW = "6870";
            }
        }
        return (TextUtils.equals(this.oa.tj().getType(), "title") || TextUtils.equals(this.oa.tj().getType(), MediaFormat.KEY_SUBTITLE)) ? strW.replace("\n", "") : strW;
    }

    public void n(TextView textView, int i) {
        textView.setText("(" + String.format("%1$s个评分", Integer.valueOf(i)) + ")");
        if (i == -1) {
            textView.setVisibility(8);
        }
    }

    private void cp() {
        if (this.k instanceof AnimationText) {
            String text = getText();
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(text);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.optString(i));
                }
            } catch (JSONException unused) {
                arrayList.add(text);
            }
            ((AnimationText) this.k).setMaxLines(1);
            ((AnimationText) this.k).setTextColor(this.d.x());
            ((AnimationText) this.k).setTextSize(this.d.l());
            ((AnimationText) this.k).setAnimationText(arrayList);
            ((AnimationText) this.k).setAnimationType(this.d.oj());
            ((AnimationText) this.k).setAnimationDuration(this.d.df() * 1000);
            ((AnimationText) this.k).n();
        }
    }
}
