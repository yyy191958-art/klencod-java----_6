package com.az4oi.tools;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView scrollView = new ScrollView(this);
        scrollView.setBackgroundColor(Color.parseColor("#050505"));

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(40, 60, 40, 60);
        layout.setGravity(Gravity.CENTER_HORIZONTAL);

        TextView titleText = new TextView(this);
        titleText.setText("Z-04I PYTHON TOOLS");
        titleText.setTextColor(Color.parseColor("#00FF66"));
        titleText.setTextSize(24);
        titleText.setGravity(Gravity.CENTER);
        titleText.setPadding(0, 0, 0, 20);
        layout.addView(titleText);

        TextView channelText = new TextView(this);
        channelText.setText("📢 Channel: t.me/az_4oi");
        channelText.setTextColor(Color.parseColor("#00CC55"));
        channelText.setTextSize(14);
        channelText.setGravity(Gravity.CENTER);
        channelText.setPadding(0, 0, 0, 40);
        layout.addView(channelText);

        Button btnTelegram = createGreenButton("📢 زيارة قناة التليجرام");
        btnTelegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/az_4oi"));
                startActivity(intent);
            }
        });
        layout.addView(btnTelegram);

        addSeparator(layout);

        addButton(layout, "1. أداة تيك توك", "TikTok.py");
        addButton(layout, "2. جلب معلومات انستغرام", "lnstagram-login.py");
        addButton(layout, "3. يوزرات انستغرام مميزة", "يوزرات انستا مميزه (1).py");
        addButton(layout, "4. أداة التحميل والملفات", "10 اسيا حك ثكيل .py");
        addButton(layout, "5. فيس بوك ربط ألعاب", "فيس.py");

        scrollView.addView(layout);
        setContentView(scrollView);
    }

    private Button createGreenButton(String text) {
        Button button = new Button(this);
        button.setText(text);
        button.setTextColor(Color.parseColor("#00FF66"));
        button.setBackgroundColor(Color.parseColor("#111111"));
        button.setTextSize(16);
        
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 15, 0, 15);
        button.setLayoutParams(params);
        return button;
    }

    private void addButton(LinearLayout parent, String title, final String scriptName) {
        Button btn = createGreenButton(title);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runTool(scriptName);
            }
        });
        parent.addView(btn);
    }

    private void runTool(String fileName) {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), fileName);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.fromFile(file), "text/plain");
            intent.setPackage("ru.iiec.pydroid3");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "تأكد من تثبيت Pydroid 3 ووجود الملف في الذاكرة!", Toast.LENGTH_LONG).show();
        }
    }

    private void addSeparator(LinearLayout layout) {
        View line = new View(this);
        line.setBackgroundColor(Color.parseColor("#00FF66"));
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, 2
        );
        params.setMargins(0, 30, 0, 30);
        layout.addView(line, params);
    }
}
