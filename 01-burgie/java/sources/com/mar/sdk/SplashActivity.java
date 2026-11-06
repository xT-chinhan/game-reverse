package com.mar.sdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.mar.sdk.log.Log;

/* JADX INFO: loaded from: classes2.dex */
public class SplashActivity extends Activity {
    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if ((getIntent().getFlags() & 4194304) != 0) {
            Log.d("MARSDK", "SplashActivity finished from game.");
            finish();
        } else {
            int layoutID = getResources().getIdentifier("mar_splash", "layout", getPackageName());
            setContentView(layoutID);
            appendAnimation();
        }
    }

    private void appendAnimation() {
        AlphaAnimation ani = new AlphaAnimation(0.0f, 1.0f);
        ani.setRepeatMode(2);
        ani.setRepeatCount(0);
        ani.setDuration(2000L);
        ImageView image = (ImageView) findViewById(getResources().getIdentifier("mar_splash_img", "id", getPackageName()));
        if (image == null) {
            int defaultID = getResources().getIdentifier("mar_splash_layout", "id", getPackageName());
            RelativeLayout layout = (RelativeLayout) LayoutInflater.from(this).inflate(defaultID, (ViewGroup) null);
            image = (ImageView) layout.getChildAt(0);
        }
        image.setAnimation(ani);
        ani.setAnimationListener(new Animation.AnimationListener() { // from class: com.mar.sdk.SplashActivity.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                try {
                    int img2 = SplashActivity.this.getResources().getIdentifier("mar_splash2", "drawable", SplashActivity.this.getPackageName());
                    if (img2 == 0) {
                        SplashActivity.this.startGameActivity();
                    } else {
                        SplashActivity.this.setCustemSplash();
                    }
                } catch (Exception e) {
                    SplashActivity.this.startGameActivity();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCustemSplash() {
        AlphaAnimation ani = new AlphaAnimation(0.0f, 1.0f);
        ani.setRepeatMode(2);
        ani.setRepeatCount(0);
        ani.setDuration(2000L);
        ImageView image = (ImageView) findViewById(getResources().getIdentifier("mar_splash_img", "id", getPackageName()));
        if (image == null) {
            int defaultID = getResources().getIdentifier("mar_splash_layout", "id", getPackageName());
            RelativeLayout layout = (RelativeLayout) LayoutInflater.from(this).inflate(defaultID, (ViewGroup) null);
            image = (ImageView) layout.getChildAt(0);
        }
        image.setBackgroundResource(getResources().getIdentifier("mar_splash2", "drawable", getPackageName()));
        image.setAnimation(ani);
        ani.setAnimationListener(new Animation.AnimationListener() { // from class: com.mar.sdk.SplashActivity.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                SplashActivity.this.startGameActivity();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startGameActivity() {
        try {
            Class<?> mainClass = Class.forName("{MARSDK_Game_Activity}");
            Intent intent = new Intent(this, mainClass);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
