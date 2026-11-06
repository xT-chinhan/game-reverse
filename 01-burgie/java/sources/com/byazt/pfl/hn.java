package com.byazt.pfl;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
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
import com.byazt.pi.TTDislikeCommentLayout;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVPH_DNS_PARSE_TIMEOUT, 20})
public class hn extends Dialog {
    public EditText c;
    public com.byazt.dw.hw hn;
    public final List<com.byazt.vg.pr> hw;
    public TTDislikeCommentLayout pr;
    public com.byazt.vg.hw x;

    public hn(Context context, com.byazt.dw.hw hwVar) {
        super(context);
        this.hw = new ArrayList();
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.hn = hwVar;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.byazt.sdv.hn.pr(getContext()));
        TTDislikeCommentLayout tTDislikeCommentLayout = (TTDislikeCommentLayout) findViewById(2047279090);
        this.pr = tTDislikeCommentLayout;
        pr(tTDislikeCommentLayout);
        c();
    }

    private void pr(View view) {
        EditText editText = (EditText) view.findViewById(2047279085);
        this.c = editText;
        pr(editText);
        final TextView textView = (TextView) view.findViewById(2047279086);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.pfl.hn.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String string = hn.this.c.getText().toString();
                if (string.length() > 0 && !string.isEmpty()) {
                    Iterator it = hn.this.hw.iterator();
                    while (it.hasNext()) {
                        if (((com.byazt.vg.pr) it.next()).pr(string, hn.this)) {
                            return;
                        }
                    }
                    com.byazt.dw.hn hnVar = new com.byazt.dw.hn("0:00", string);
                    com.byazt.rc.pr.pr().pr(hn.this.hn, hnVar);
                    hn.this.x.pr(0, hnVar);
                    hn.this.dismiss();
                }
            }
        });
        ((ImageView) view.findViewById(2047279088)).setOnClickListener(new View.OnClickListener() { // from class: com.byazt.pfl.hn.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                hn.this.dismiss();
            }
        });
        final TextView textView2 = (TextView) findViewById(2047279084);
        this.c.addTextChangedListener(new TextWatcher() { // from class: com.byazt.pfl.hn.3
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

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    public static void pr(EditText editText) {
        editText.setFilters(new InputFilter[]{new InputFilter() { // from class: com.byazt.pfl.hn.4
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                while (i < i2) {
                    int type = Character.getType(charSequence.charAt(i));
                    if (type != 19 && type != 28) {
                        i++;
                    } else {
                        return "";
                    }
                }
                return null;
            }
        }, new InputFilter.LengthFilter(500)});
    }

    private void c() {
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
        hw();
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        hn();
        super.dismiss();
        com.byazt.vg.hw hwVar = this.x;
        if (hwVar != null) {
            hwVar.pr();
        }
    }

    public void pr(com.byazt.vg.pr prVar) {
        this.hw.add(prVar);
    }

    public void pr(com.byazt.dw.hw hwVar) {
        if (hwVar == null) {
            return;
        }
        this.hn = hwVar;
    }

    public void pr() {
        EditText editText;
        TTDislikeCommentLayout tTDislikeCommentLayout = this.pr;
        if (tTDislikeCommentLayout != null && (editText = (EditText) tTDislikeCommentLayout.findViewById(2047279085)) != null) {
            editText.setText((CharSequence) null);
        }
    }

    public void pr(com.byazt.vg.hw hwVar) {
        this.x = hwVar;
    }

    public void hw() {
        EditText editText;
        TTDislikeCommentLayout tTDislikeCommentLayout = this.pr;
        if (tTDislikeCommentLayout == null || (editText = (EditText) tTDislikeCommentLayout.findViewById(2047279085)) == null) {
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) editText.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.pr.getWindowToken(), 0);
        }
        editText.clearFocus();
    }

    public void hn() {
        EditText editText;
        InputMethodManager inputMethodManager;
        TTDislikeCommentLayout tTDislikeCommentLayout = this.pr;
        if (tTDislikeCommentLayout != null && (editText = (EditText) tTDislikeCommentLayout.findViewById(2047279085)) != null && (inputMethodManager = (InputMethodManager) editText.getContext().getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(this.pr.getWindowToken(), 0);
        }
    }

    public String x() {
        EditText editText = this.c;
        if (editText != null) {
            return editText.getText().toString();
        }
        return "";
    }
}
