package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.re;

/* JADX INFO: loaded from: classes2.dex */
public class ao extends AlertDialog {
    private boolean ah;
    private ms d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Context f3703ms;
    private String xr;

    public interface ms {
        void ms(String str);

        void xr(String str);
    }

    public ao(Context context, String str) {
        super(context, t.ab(context, "tt_dialog_full"));
        this.f3703ms = context;
        this.xr = str;
        this.ah = TextUtils.isEmpty(str);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCanceledOnTouchOutside(false);
        if (this.f3703ms == null) {
            this.f3703ms = re.getContext();
        }
        ms();
    }

    private void ms() {
        setContentView(xr());
    }

    private View xr() {
        LinearLayout linearLayout = new LinearLayout(this.f3703ms);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        linearLayout.setGravity(17);
        TextView textView = new TextView(this.f3703ms);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        textView.setLayoutParams(layoutParams2);
        textView.setText("您要访问的网站存在风险");
        textView.setTextColor(-1);
        textView.setTextSize(20.0f);
        linearLayout.addView(textView);
        int iAh = ul.ah(this.f3703ms, 10.0f) * 2;
        TextView textView2 = new TextView(this.f3703ms);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = iAh;
        layoutParams3.gravity = 17;
        textView2.setLayoutParams(layoutParams3);
        textView2.setText("继续访问可能导致个人隐私泄漏、账号被盗用等危害");
        textView2.setTextColor(-1);
        textView2.setTextSize(15.0f);
        linearLayout.addView(textView2);
        int iAh2 = ul.ah(this.f3703ms, 25.0f);
        int iAh3 = ul.ah(this.f3703ms, 8.0f);
        if (!this.ah) {
            Button button = new Button(this.f3703ms);
            button.setBackgroundColor(-7829368);
            button.setText("继续访问");
            button.setTextColor(-1);
            button.setPadding(iAh2, iAh3, iAh2, iAh3);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(ul.ah(this.f3703ms, 230.0f), -2);
            layoutParams4.topMargin = iAh;
            layoutParams4.gravity = 17;
            button.setLayoutParams(layoutParams4);
            button.setTextSize(25.0f);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.ao.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ao.this.dismiss();
                    if (ao.this.d == null) {
                        return;
                    }
                    ao.this.d.ms(ao.this.xr);
                }
            });
            linearLayout.addView(button);
        }
        Button button2 = new Button(this.f3703ms);
        button2.setBackgroundColor(SupportMenu.CATEGORY_MASK);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(ul.ah(this.f3703ms, 230.0f), -2);
        layoutParams5.topMargin = iAh;
        layoutParams5.gravity = 17;
        button2.setLayoutParams(layoutParams5);
        button2.setText("返回安全链接");
        button2.setTextColor(-1);
        button2.setTextSize(25.0f);
        button2.setTypeface(null, 1);
        button2.setPadding(iAh2, iAh3, iAh2, iAh3);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.ao.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ao.this.dismiss();
                if (ao.this.d == null) {
                    return;
                }
                ao.this.d.xr(ao.this.xr);
            }
        });
        linearLayout.addView(button2);
        linearLayout.setLayoutParams(layoutParams);
        return linearLayout;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        ms msVar = this.d;
        if (msVar == null) {
            return;
        }
        msVar.xr(this.xr);
    }

    public void ms(ms msVar) {
        this.d = msVar;
    }
}
