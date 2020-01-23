package com.example.testapp2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.stephentuso.welcome.WelcomeActivity;
import com.stephentuso.welcome.WelcomeConfiguration;
import com.stephentuso.welcome.TitlePage;
import com.stephentuso.welcome.BasicPage;

public class TutorialActivity extends WelcomeActivity {

    @Override
    protected WelcomeConfiguration configuration() {

        return new WelcomeConfiguration.Builder(this)
                .defaultBackgroundColor(R.color.defaultBackGround)
                .page(new TitlePage(R.drawable.my_logo,
                        "Title")
                )
                .page(new BasicPage(
                        R.drawable.my_logo,
                        "Header",
                        "More text.")
                        .background(R.color.Red)
                )
                .page(new BasicPage(
                        R.drawable.my_logo,
                        "hoge",
                        "dolor sit amet.")
                )
                .swipeToDismiss(true)
                .build();
    }

}
