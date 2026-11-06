package com.mcto.sspsdk.feedback;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import com.mcto.sspsdk.QyCustomMade;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.internal.aa;
import com.mcto.sspsdk.internal.ba;
import com.mcto.sspsdk.internal.c7;
import com.mcto.sspsdk.internal.fc;
import com.mcto.sspsdk.internal.gj;
import com.mcto.sspsdk.internal.ha;
import com.mcto.sspsdk.internal.i9;
import com.mcto.sspsdk.internal.j9;
import com.mcto.sspsdk.internal.jd;
import com.mcto.sspsdk.internal.mj;
import com.mcto.sspsdk.internal.nh;
import com.mcto.sspsdk.internal.p9;
import com.mcto.sspsdk.internal.rd;
import com.mcto.sspsdk.internal.x5;
import com.mcto.sspsdk.internal.y4;
import com.mcto.sspsdk.internal.y5;
import com.mcto.sspsdk.internal.z6;
import com.mcto.sspsdk.internal.zg;
import com.mcto.sspsdk.jni.SimulatorDetectorJni;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class FeedBackActivity extends AppCompatActivity implements View.OnClickListener {
    private final AtomicBoolean a = new AtomicBoolean(false);
    private Button b;

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.getId() == R.id.qy_feedback_ticket_btn) {
            String string = ((EditText) findViewById(R.id.qy_feedback_ticket)).getText().toString();
            if (string.contains("#")) {
                string = string.substring(1);
                findViewById(R.id.qy_switchExample_group).setVisibility(0);
            }
            if (!TextUtils.equals("" + SimulatorDetectorJni.ticket(), string)) {
                finish();
                return;
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(findViewById(R.id.qy_feedback_main_layout), "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat.setDuration(500L);
            objectAnimatorOfFloat.addListener(new y5(this));
            objectAnimatorOfFloat.start();
            if (findViewById(R.id.qy_switchExample_group).getVisibility() == 0) {
                Switch r11 = (Switch) findViewById(R.id.qy_switchExample);
                Switch r0 = (Switch) findViewById(R.id.qy_switchExample2);
                r11.setChecked(rd.a);
                r0.setChecked(rd.b);
                x5 x5Var = new x5();
                r11.setOnCheckedChangeListener(x5Var);
                r0.setOnCheckedChangeListener(x5Var);
            }
            Button button = (Button) findViewById(R.id.qy_feedback_btn);
            this.b = button;
            button.setOnClickListener(this);
            return;
        }
        if (this.a.compareAndSet(true, true)) {
            return;
        }
        this.b.setText("提交中");
        EditText editText = (EditText) findViewById(R.id.qy_feedback_detail_advice);
        EditText editText2 = (EditText) findViewById(R.id.qy_feedback_contact);
        if (editText2.getText() == null || editText.getText() == null) {
            fc.a(this, "Feedback information cannot be empty.");
            return;
        }
        String string2 = editText2.getText().toString();
        String string3 = editText.getText().toString();
        a aVar = new a(this);
        if (TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3)) {
            aVar.a("Feedback information cannot be empty.");
            return;
        }
        p9.a.getClass();
        j9 j9Var = i9.a;
        j9Var.getClass();
        ArrayList<File> arrayList = new ArrayList(2);
        File file = j9Var.a;
        if (file != null && file.exists() && j9Var.a.length() > 0) {
            arrayList.add(j9Var.a);
        }
        File file2 = j9Var.b;
        if (file2 != null && file2.exists() && j9Var.b.length() > 0) {
            arrayList.add(j9Var.b);
        }
        if (arrayList.size() <= 0) {
            aVar.a("Please watch the ad first.");
            return;
        }
        ba baVar = new ba();
        StringBuilder sb = new StringBuilder();
        for (File file3 : arrayList) {
            sb.append("nodecode,");
            String name = file3.getName();
            if (baVar.a == null) {
                baVar.a = new ArrayList();
            }
            baVar.a.add(new aa(file3, name));
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
            baVar.a("decodeTypes", sb.toString());
        }
        ba baVarA = baVar.a("entranceId", "8BLSWebs").a("problems", "[{\"type\":\"广告报障\"}]");
        StringBuilder sb2 = new StringBuilder();
        y4 y4Var = y4.r;
        baVarA.a("productVersion", sb2.append(jd.a.getPackageName()).append(":").append(y4Var.c()).toString()).a("email", string2).a("qyid", y4Var.i()).a("content", string3).a("feedbackLog", gj.a()).a("deviceInfo", y4Var.f()).a("netState", ha.a());
        c7 c7VarA = c7.a();
        mj mjVar = new mj(aVar);
        c7VarA.getClass();
        zg.a.a(new z6(baVar, mjVar));
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected final void onCreate(Bundle bundle) {
        String qyid;
        QyCustomMade qyCustomMade;
        try {
            super.onCreate(bundle);
            setContentView(R.layout.qy_activity_feedback_log);
            StringBuilder sb = new StringBuilder("sdk_version:2.3.102\nuid:");
            if (!rd.a() || (qyCustomMade = rd.d) == null) {
                if (rd.g == null) {
                    rd.g = nh.a(jd.a).a("dqyid");
                }
                qyid = rd.g;
            } else {
                qyid = qyCustomMade.getQyid();
            }
            StringBuilder sbAppend = sb.append(qyid).append("\npackage:").append(jd.a.getPackageName()).append("\noid:");
            QyCustomMade qyCustomMade2 = rd.d;
            ((TextView) findViewById(R.id.qy_feedback_sdk_info)).setText(sbAppend.append(qyCustomMade2 != null ? qyCustomMade2.getOaid() : null).toString());
            findViewById(R.id.qy_feedback_ticket_btn).setOnClickListener(this);
        } catch (Exception e) {
            if (jd.a == null) {
                ((TextView) findViewById(R.id.qy_feedback_sdk_info)).setText("SDK没有被初始化,功能不可用!");
            }
        }
    }
}
