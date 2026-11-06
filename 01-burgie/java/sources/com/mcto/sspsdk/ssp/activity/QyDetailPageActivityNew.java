package com.mcto.sspsdk.ssp.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.player.C;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.component.webview.QyWebViewDataBean;
import com.mcto.sspsdk.component.webview.QyWebViewPanel;
import com.mcto.sspsdk.feedback.FeedBackActivity;
import com.mcto.sspsdk.internal.gj;
import com.mcto.sspsdk.internal.hk;
import com.mcto.sspsdk.internal.md;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class QyDetailPageActivityNew extends AppCompatActivity implements View.OnClickListener {
    private QyWebViewPanel a;
    private QyWebViewDataBean b;
    private int c = 0;

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.getId() == R.id.qy_detail_page_close) {
            finish();
            return;
        }
        if (view.getId() == R.id.qy_detail_page_back) {
            QyWebViewPanel qyWebViewPanel = this.a;
            if (qyWebViewPanel == null || !qyWebViewPanel.b()) {
                finish();
                return;
            } else {
                this.a.e();
                return;
            }
        }
        if (view.getId() == R.id.qy_detail_page_share) {
            new AlertDialog.Builder(this).setTitle("使用浏览器打开？").setNegativeButton("取消", (DialogInterface.OnClickListener) null).setPositiveButton("确定", new a(this)).create().show();
            return;
        }
        if (view.getId() == R.id.qy_webview_top) {
            int i = this.c;
            this.c = i + 1;
            if (i > 10) {
                this.c = 0;
                try {
                    Intent intent = new Intent();
                    intent.setFlags(C.ENCODING_PCM_MU_LAW);
                    intent.setClass(this, FeedBackActivity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.qy_activity_detail_page);
        hk.a((AppCompatActivity) this, true);
        findViewById(R.id.qy_detail_page_close).setOnClickListener(this);
        findViewById(R.id.qy_detail_page_back).setOnClickListener(this);
        findViewById(R.id.qy_detail_page_share).setOnClickListener(this);
        findViewById(R.id.qy_webview_top).setOnClickListener(this);
        findViewById(R.id.qy_webview_top).setOnApplyWindowInsetsListener(new md(this));
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        QyWebViewDataBean qyWebViewDataBean = (QyWebViewDataBean) intent.getParcelableExtra("dataBean");
        this.b = qyWebViewDataBean;
        if (qyWebViewDataBean == null || TextUtils.isEmpty(qyWebViewDataBean.h())) {
            return;
        }
        QyWebViewPanel qyWebViewPanel = (QyWebViewPanel) findViewById(R.id.qy_webview_panel);
        this.a = qyWebViewPanel;
        qyWebViewPanel.a(this.b);
        System.currentTimeMillis();
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected final void onDestroy() {
        QyWebViewPanel qyWebViewPanel = this.a;
        if (qyWebViewPanel != null) {
            ((ViewGroup) qyWebViewPanel.getParent()).removeView(this.a);
            this.a.c();
            this.a = null;
        }
        AtomicInteger atomicInteger = gj.a;
        System.currentTimeMillis();
        super.onDestroy();
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        QyWebViewPanel qyWebViewPanel;
        if (i != 4 || (qyWebViewPanel = this.a) == null || !qyWebViewPanel.b()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.a.e();
        return true;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected final void onResume() {
        super.onResume();
        QyWebViewPanel qyWebViewPanel = this.a;
        if (qyWebViewPanel != null) {
            qyWebViewPanel.f();
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected final void onStop() {
        super.onStop();
        QyWebViewPanel qyWebViewPanel = this.a;
        if (qyWebViewPanel != null) {
            qyWebViewPanel.g();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            hk.a((AppCompatActivity) this, true);
        }
    }
}
