package com.byazt.wg;

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
import com.byazt.ndr.TTDislikeCommentLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 204, 8})
public class s extends Dialog {
    public EditText l;
    public TTDislikeCommentLayout n;
    public com.byazt.ae.qg q;
    public final List<com.byazt.ae.n> qg;
    public com.byazt.oj.qg s;

    public s(Context context, com.byazt.oj.qg qgVar) {
        super(context);
        this.qg = new ArrayList();
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.s = qgVar;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.byazt.xn.s.n(getContext()));
        TTDislikeCommentLayout tTDislikeCommentLayout = (TTDislikeCommentLayout) findViewById(2047279090);
        this.n = tTDislikeCommentLayout;
        n(tTDislikeCommentLayout);
        l();
    }

    private void n(View view) {
        EditText editText = (EditText) view.findViewById(2047279085);
        this.l = editText;
        n(editText);
        final TextView textView = (TextView) view.findViewById(2047279086);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.wg.s.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String string = s.this.l.getText().toString();
                if (string.length() <= 0 || string.isEmpty()) {
                    return;
                }
                Iterator it = s.this.qg.iterator();
                while (it.hasNext()) {
                    if (((com.byazt.ae.n) it.next()).n(string, s.this)) {
                        return;
                    }
                }
                com.byazt.oj.s sVar = new com.byazt.oj.s("0:00", string);
                com.byazt.nnl.n.n().n(s.this.s, sVar);
                s.this.q.n(0, sVar);
                s.this.dismiss();
            }
        });
        ((ImageView) view.findViewById(2047279088)).setOnClickListener(new View.OnClickListener() { // from class: com.byazt.wg.s.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                s.this.dismiss();
            }
        });
        final TextView textView2 = (TextView) findViewById(2047279084);
        this.l.addTextChangedListener(new TextWatcher() { // from class: com.byazt.wg.s.3
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

    public static void n(EditText editText) {
        editText.setFilters(new InputFilter[]{new InputFilter() { // from class: com.byazt.wg.s.4
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

    private void l() {
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
        qg();
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        s();
        super.dismiss();
        com.byazt.ae.qg qgVar = this.q;
        if (qgVar != null) {
            qgVar.n();
        }
    }

    public void n(com.byazt.ae.n nVar) {
        this.qg.add(nVar);
    }

    public void n(com.byazt.oj.qg qgVar) {
        if (qgVar == null) {
            return;
        }
        this.s = qgVar;
    }

    public void n() {
        EditText editText;
        TTDislikeCommentLayout tTDislikeCommentLayout = this.n;
        if (tTDislikeCommentLayout == null || (editText = (EditText) tTDislikeCommentLayout.findViewById(2047279085)) == null) {
            return;
        }
        editText.setText((CharSequence) null);
    }

    public void n(com.byazt.ae.qg qgVar) {
        this.q = qgVar;
    }

    public void qg() {
        EditText editText;
        TTDislikeCommentLayout tTDislikeCommentLayout = this.n;
        if (tTDislikeCommentLayout == null || (editText = (EditText) tTDislikeCommentLayout.findViewById(2047279085)) == null) {
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) editText.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.n.getWindowToken(), 0);
        }
        editText.clearFocus();
    }

    public void s() {
        EditText editText;
        InputMethodManager inputMethodManager;
        TTDislikeCommentLayout tTDislikeCommentLayout = this.n;
        if (tTDislikeCommentLayout == null || (editText = (EditText) tTDislikeCommentLayout.findViewById(2047279085)) == null || (inputMethodManager = (InputMethodManager) editText.getContext().getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(this.n.getWindowToken(), 0);
    }

    public String q() {
        EditText editText = this.l;
        return editText != null ? editText.getText().toString() : "";
    }
}
