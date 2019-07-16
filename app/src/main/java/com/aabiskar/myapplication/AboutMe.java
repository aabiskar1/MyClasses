package com.aabiskar.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.vansuita.materialabout.builder.AboutBuilder;
import com.vansuita.materialabout.views.AboutView;

public class AboutMe extends AppCompatActivity {
private RelativeLayout aboutmeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
        
        aboutmeLayout = findViewById(R.id.aboutmeLayout);
        AboutView view = AboutBuilder.with(this)
                .setPhoto(R.mipmap.profile_picture)  //R.mipmap.profile_picture
                .setCover(R.mipmap.profile_cover)
                .setName("Aabiskar Aryal")
                .setSubTitle("Mobile Developer")
                .setBrief("Tech Enthusiastic and Developer")
                .setAppIcon(R.mipmap.ic_launcher)   //R.mipmap.ic_launcher
                .setAppName(R.string.app_name)
                .addFacebookLink("https://www.facebook.com/aabiskar1")
                .setVersionNameAsAppSubTitle()
                .addAction(R.drawable.down_arrow_icon,"Download Link(download new update from here)","http://www.mediafire.com/folder/qr2ta92axn7zz/MyClasses\"")
                .addEmailLink("aabiskar1@live.com","MyClasses:","Message from MyClasses")
                .setWrapScrollView(true)
                .setLinksAnimated(true)
                .setShowAsCard(true)
                .build();


        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);

        addContentView(view, layoutParams);
        
    }
}
