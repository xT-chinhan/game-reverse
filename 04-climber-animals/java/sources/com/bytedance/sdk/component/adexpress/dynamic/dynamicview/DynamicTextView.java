package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.component.adexpress.dynamic.ah.x;
import com.bytedance.sdk.component.adexpress.dynamic.d.hi;
import com.bytedance.sdk.component.adexpress.widget.AnimationText;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.t;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicTextView extends DynamicBaseWidgetImp {
    public DynamicTextView(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        this.x += 6;
        if (this.sl.az()) {
            this.ub = new AnimationText(context, this.sl.ab(), this.sl.ka(), 1, this.sl.x());
            ((AnimationText) this.ub).setMaxLines(1);
        } else {
            this.ub = new TextView(context);
            ((TextView) this.ub).setIncludeFontPadding(false);
        }
        this.ub.setTag(Integer.valueOf(getClickArea()));
        addView(this.ub, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean x() {
        int i;
        double d;
        super.x();
        if (TextUtils.isEmpty(getText())) {
            this.ub.setVisibility(4);
            return true;
        }
        if (this.sl.az()) {
            hi();
            return true;
        }
        ((TextView) this.ub).setText(this.sl.c());
        ((TextView) this.ub).setTextDirection(5);
        this.ub.setTextAlignment(this.sl.x());
        ((TextView) this.ub).setTextColor(this.sl.ab());
        ((TextView) this.ub).setTextSize(this.sl.ka());
        if (!this.sl.b()) {
            ((TextView) this.ub).setMaxLines(1);
            ((TextView) this.ub).setGravity(17);
            ((TextView) this.ub).setEllipsize(TextUtils.TruncateAt.END);
        } else {
            int iRe = this.sl.re();
            if (iRe > 0) {
                ((TextView) this.ub).setLines(iRe);
                ((TextView) this.ub).setEllipsize(TextUtils.TruncateAt.END);
            }
        }
        if (this.zb != null && this.zb.ch() != null) {
            if (com.bytedance.sdk.component.adexpress.d.ms() && ny() && (TextUtils.equals(this.zb.ch().getType(), "text_star") || TextUtils.equals(this.zb.ch().getType(), "score-count") || TextUtils.equals(this.zb.ch().getType(), "score-count-type-1") || TextUtils.equals(this.zb.ch().getType(), "score-count-type-2"))) {
                setVisibility(8);
                return true;
            }
            if (TextUtils.equals(this.zb.ch().getType(), "score-count") || TextUtils.equals(this.zb.ch().getType(), "score-count-type-2")) {
                try {
                    try {
                        i = Integer.parseInt(getText());
                    } catch (NumberFormatException unused) {
                        i = -1;
                    }
                    if (i < 0) {
                        if (com.bytedance.sdk.component.adexpress.d.ms()) {
                            setVisibility(8);
                            return true;
                        }
                        this.ub.setVisibility(0);
                    }
                    if (TextUtils.equals(this.zb.ch().getType(), "score-count-type-2")) {
                        ((TextView) this.ub).setText(String.format(new DecimalFormat("(###,###,###)").format(i), Integer.valueOf(i)));
                        ((TextView) this.ub).setGravity(17);
                        return true;
                    }
                    ms((TextView) this.ub, i, getContext(), "tt_comment_num");
                } catch (Exception unused2) {
                }
            } else if (TextUtils.equals(this.zb.ch().getType(), "text_star")) {
                try {
                    d = Double.parseDouble(getText());
                } catch (Exception e) {
                    sl.d("DynamicStarView applyNativeStyle", e.toString());
                    d = -1.0d;
                }
                if (d < 0.0d || d > 5.0d) {
                    if (com.bytedance.sdk.component.adexpress.d.ms()) {
                        setVisibility(8);
                        return true;
                    }
                    this.ub.setVisibility(0);
                }
                ((TextView) this.ub).setIncludeFontPadding(false);
                ((TextView) this.ub).setText(String.format("%.1f", Double.valueOf(d)));
            } else if (TextUtils.equals("privacy-detail", this.zb.ch().getType())) {
                ((TextView) this.ub).setText("功能 | 权限 | 隐私");
            } else if (TextUtils.equals(this.zb.ch().getType(), "development-name")) {
                ((TextView) this.ub).setText(t.ms(com.bytedance.sdk.component.adexpress.d.getContext(), "tt_text_privacy_development") + getText());
            } else if (TextUtils.equals(this.zb.ch().getType(), "app-version")) {
                ((TextView) this.ub).setText(t.ms(com.bytedance.sdk.component.adexpress.d.getContext(), "tt_text_privacy_app_version") + getText());
            } else {
                ((TextView) this.ub).setText(getText());
            }
            this.ub.setTextAlignment(this.sl.x());
            ((TextView) this.ub).setGravity(this.sl.ny());
            if (com.bytedance.sdk.component.adexpress.d.ms()) {
                ch();
            }
        }
        return true;
    }

    private boolean ny() {
        return (this.u == null || this.u.getRenderRequest() == null || this.u.getRenderRequest().zb() == 4) ? false : true;
    }

    private void ch() {
        int iMs;
        if (TextUtils.equals(this.zb.ch().getType(), "source") || TextUtils.equals(this.zb.ch().getType(), "title") || TextUtils.equals(this.zb.ch().getType(), "text_star")) {
            int[] iArrXr = hi.xr(this.sl.c(), this.sl.ka(), true);
            int iMs2 = (int) com.bytedance.sdk.component.adexpress.d.x.ms(getContext(), this.sl.xr());
            int iMs3 = (int) com.bytedance.sdk.component.adexpress.d.x.ms(getContext(), this.sl.ah());
            int iMs4 = (int) com.bytedance.sdk.component.adexpress.d.x.ms(getContext(), this.sl.d());
            int iMs5 = (int) com.bytedance.sdk.component.adexpress.d.x.ms(getContext(), this.sl.ms());
            int iMin = Math.min(iMs2, iMs5);
            if (TextUtils.equals(this.zb.ch().getType(), "source") && (iMs = ((this.x - ((int) com.bytedance.sdk.component.adexpress.d.x.ms(getContext(), this.sl.ka()))) - iMs2) - iMs5) > 1 && iMs <= iMin * 2) {
                int i = iMs / 2;
                this.ub.setPadding(iMs3, iMs2 - i, iMs4, iMs5 - (iMs - i));
                return;
            }
            int i2 = (((iArrXr[1] + iMs2) + iMs5) - this.x) - 2;
            if (i2 <= 1) {
                return;
            }
            if (i2 <= iMin * 2) {
                int i3 = i2 / 2;
                this.ub.setPadding(iMs3, iMs2 - i3, iMs4, iMs5 - (i2 - i3));
            } else if (i2 > iMs2 + iMs5) {
                final int i4 = (i2 - iMs2) - iMs5;
                this.ub.setPadding(iMs3, 0, iMs4, 0);
                if (i4 <= ((int) com.bytedance.sdk.component.adexpress.d.x.ms(getContext(), 1.0f)) + 1) {
                    ((TextView) this.ub).setTextSize(this.sl.ka() - 1.0f);
                } else if (i4 <= (((int) com.bytedance.sdk.component.adexpress.d.x.ms(getContext(), 1.0f)) + 1) * 2) {
                    ((TextView) this.ub).setTextSize(this.sl.ka() - 2.0f);
                } else {
                    post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicTextView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                ViewGroup.LayoutParams layoutParams = DynamicTextView.this.ub.getLayoutParams();
                                layoutParams.height = DynamicTextView.this.x + i4;
                                DynamicTextView.this.ub.setLayoutParams(layoutParams);
                                DynamicTextView.this.ub.setTranslationY(-i4);
                                ViewGroup viewGroup = (ViewGroup) DynamicTextView.this.ub.getParent();
                                viewGroup.setClipChildren(false);
                                ViewGroup viewGroup2 = (ViewGroup) DynamicTextView.this.ub.getParent().getParent();
                                viewGroup2.setClipChildren(false);
                            } catch (Throwable unused) {
                            }
                        }
                    });
                }
            } else if (iMs2 > iMs5) {
                this.ub.setPadding(iMs3, iMs2 - (i2 - iMin), iMs4, iMs5 - iMin);
            } else {
                this.ub.setPadding(iMs3, iMs2 - iMin, iMs4, iMs5 - (i2 - iMin));
            }
        }
        if (TextUtils.equals(this.zb.ch().getType(), "fillButton")) {
            this.ub.setTextAlignment(2);
            ((TextView) this.ub).setGravity(17);
        }
    }

    public String getText() {
        String strC = this.sl.c();
        if (TextUtils.isEmpty(strC)) {
            if (!com.bytedance.sdk.component.adexpress.d.ms() && TextUtils.equals(this.zb.ch().getType(), "text_star")) {
                strC = "5";
            }
            if (!com.bytedance.sdk.component.adexpress.d.ms() && TextUtils.equals(this.zb.ch().getType(), "score-count")) {
                strC = "6870";
            }
        }
        return (TextUtils.equals(this.zb.ch().getType(), "title") || TextUtils.equals(this.zb.ch().getType(), MediaFormat.KEY_SUBTITLE)) ? strC.replace("\n", "") : strC;
    }

    public void ms(TextView textView, int i, Context context, String str) {
        textView.setText("(" + String.format(t.ms(context, str), Integer.valueOf(i)) + ")");
        if (i == -1) {
            textView.setVisibility(8);
        }
    }

    private void hi() {
        if (this.ub instanceof AnimationText) {
            String text = getText();
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(text);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.optString(i));
                }
            } catch (JSONException e) {
                sl.ms(e);
                arrayList.add(text);
            }
            ((AnimationText) this.ub).setMaxLines(1);
            ((AnimationText) this.ub).setTextColor(this.sl.ab());
            ((AnimationText) this.ub).setTextSize(this.sl.ka());
            ((AnimationText) this.ub).setAnimationText(arrayList);
            ((AnimationText) this.ub).setAnimationType(this.sl.lm());
            ((AnimationText) this.ub).setAnimationDuration(this.sl.m() * 1000);
            ((AnimationText) this.ub).ms();
        }
    }
}
