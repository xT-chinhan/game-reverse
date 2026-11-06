package com.bytedance.sdk.openadsdk.core.dislike.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.widget.TTDislikeCommentLayout;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends Dialog {
    private com.bytedance.sdk.openadsdk.core.dislike.ah.xr ah;
    private com.bytedance.sdk.openadsdk.core.dislike.xr.xr d;
    private EditText ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private TTDislikeCommentLayout f2491ms;
    private com.bytedance.sdk.openadsdk.core.dislike.xr.ms xr;

    public xr(Context context, com.bytedance.sdk.openadsdk.core.dislike.ah.xr xrVar) {
        super(context);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.ah = xrVar;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.bytedance.sdk.openadsdk.res.d.ah(getContext()));
        TTDislikeCommentLayout tTDislikeCommentLayout = (TTDislikeCommentLayout) findViewById(2047279092);
        this.f2491ms = tTDislikeCommentLayout;
        ms(tTDislikeCommentLayout);
        ka();
    }

    private void ms(View view) {
        EditText editText = (EditText) view.findViewById(2047279087);
        this.ka = editText;
        ms(editText);
        final TextView textView = (TextView) view.findViewById(2047279088);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.xr.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String string = xr.this.ka.getText().toString();
                if (string.length() <= 0 || string.isEmpty()) {
                    return;
                }
                if (xr.this.xr == null || !xr.this.xr.ms(string, xr.this)) {
                    com.bytedance.sdk.openadsdk.core.dislike.ah.ah ahVar = new com.bytedance.sdk.openadsdk.core.dislike.ah.ah("0:00", string);
                    com.bytedance.sdk.openadsdk.core.dislike.ms.ms.ms().ms(xr.this.ah, ahVar);
                    xr.this.d.ms(0, ahVar);
                    xr.this.dismiss();
                }
            }
        });
        ((ImageView) view.findViewById(2047279090)).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.xr.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                xr.this.dismiss();
            }
        });
        final TextView textView2 = (TextView) findViewById(2047279086);
        this.ka.addTextChangedListener(new TextWatcher() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.xr.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                int iRound = Math.round(charSequence.length());
                textView2.setText(String.valueOf(iRound));
                if (iRound > 0) {
                    textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                    textView.setClickable(true);
                } else {
                    textView.setTextColor(-7829368);
                    textView.setClickable(false);
                }
            }
        });
    }

    public static void ms(EditText editText) {
        editText.setFilters(new InputFilter[]{new InputFilter() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.xr.4
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                while (i < i2) {
                    int type = Character.getType(charSequence.charAt(i));
                    if (type == 19 || type == 28) {
                        return "";
                    }
                    i++;
                }
                return null;
            }
        }, new InputFilter.LengthFilter(500)});
    }

    private void ka() {
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        Window window = getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        xr();
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        ah();
        super.dismiss();
        com.bytedance.sdk.openadsdk.core.dislike.xr.xr xrVar = this.d;
        if (xrVar != null) {
            xrVar.ms();
        }
    }

    public void ms(com.bytedance.sdk.openadsdk.core.dislike.xr.ms msVar) {
        this.xr = msVar;
    }

    public void ms(com.bytedance.sdk.openadsdk.core.dislike.ah.xr xrVar) {
        if (xrVar == null) {
            return;
        }
        this.ah = xrVar;
    }

    public void ms() {
        EditText editText;
        TTDislikeCommentLayout tTDislikeCommentLayout = this.f2491ms;
        if (tTDislikeCommentLayout == null || (editText = (EditText) tTDislikeCommentLayout.findViewById(2047279087)) == null) {
            return;
        }
        editText.setText((CharSequence) null);
    }

    public void ms(com.bytedance.sdk.openadsdk.core.dislike.xr.xr xrVar) {
        this.d = xrVar;
    }

    public void xr() {
        EditText editText;
        TTDislikeCommentLayout tTDislikeCommentLayout = this.f2491ms;
        if (tTDislikeCommentLayout == null || (editText = (EditText) tTDislikeCommentLayout.findViewById(2047279087)) == null) {
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) editText.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.f2491ms.getWindowToken(), 0);
        }
        editText.clearFocus();
    }

    public void ah() {
        EditText editText;
        InputMethodManager inputMethodManager;
        TTDislikeCommentLayout tTDislikeCommentLayout = this.f2491ms;
        if (tTDislikeCommentLayout == null || (editText = (EditText) tTDislikeCommentLayout.findViewById(2047279087)) == null || (inputMethodManager = (InputMethodManager) editText.getContext().getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(this.f2491ms.getWindowToken(), 0);
    }

    public String d() {
        EditText editText = this.ka;
        return editText != null ? editText.getText().toString() : "";
    }
}
