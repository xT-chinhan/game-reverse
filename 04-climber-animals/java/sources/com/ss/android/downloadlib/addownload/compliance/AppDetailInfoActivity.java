package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.openadsdk.R;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AppDetailInfoActivity extends Activity {
    private List<Pair<String, String>> ab;
    private LinearLayout ah;
    private long c;
    private RecyclerView d;
    private long ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ImageView f4363ms;
    private TextView xr;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ttdownloader_activity_app_detail_info);
        if (ms()) {
            xr();
        } else {
            com.ss.android.socialbase.appdownloader.ah.ms((Activity) this);
        }
    }

    public static void ms(Activity activity, long j) {
        Intent intent = new Intent(activity, (Class<?>) AppDetailInfoActivity.class);
        intent.putExtra("app_info_id", j);
        activity.startActivity(intent);
    }

    private boolean ms() {
        this.ka = getIntent().getLongExtra("app_info_id", 0L);
        com.ss.android.downloadlib.addownload.xr.xr xrVarMs = ah.ms().ms(this.ka);
        if (xrVarMs == null) {
            return false;
        }
        this.c = xrVarMs.xr;
        this.ab = xrVarMs.x;
        return true;
    }

    private void xr() {
        this.f4363ms = (ImageView) findViewById(R.id.iv_detail_back);
        this.xr = (TextView) findViewById(R.id.tv_empty);
        this.d = (RecyclerView) findViewById(R.id.permission_list);
        this.ah = (LinearLayout) findViewById(R.id.ll_download);
        if (this.ab.isEmpty()) {
            this.d.setVisibility(8);
            this.xr.setVisibility(0);
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(1);
            this.d.setLayoutManager(linearLayoutManager);
            this.d.setAdapter(new ms());
        }
        this.f4363ms.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab.ms("lp_app_detail_click_close", AppDetailInfoActivity.this.c);
                AppDetailInfoActivity.this.finish();
            }
        });
        this.ah.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab.ms("lp_app_detail_click_download", AppDetailInfoActivity.this.c);
                xr.ms().xr(AppDetailInfoActivity.this.c);
                com.ss.android.socialbase.appdownloader.ah.ms((Activity) AppDetailInfoActivity.this);
                com.ss.android.socialbase.appdownloader.ah.ms(xr.ms().xr());
            }
        });
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        ab.ms("lp_app_detail_click_close", this.c);
        super.onBackPressed();
    }

    private class ms extends RecyclerView.Adapter<Object> {
        private ms() {
        }
    }
}
