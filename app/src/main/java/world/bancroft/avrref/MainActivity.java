package world.bancroft.avrref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import world.bancroft.avrref.ui.login.LoginActivity;
import world.bancroft.avrref.ui.login.LoginActivityKt;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "Who Dat";
    private String name = "unknown";
    private Button who = null;
    private Button done = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra(EXTRA_MESSAGE, name);

        who = (Button) findViewById(R.id.button_who);
        who.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                setContentView(R.layout.activity_login);
                startActivity(intent);
            }
        });

        done = (Button) findViewById(R.id.button_done);
        done.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);

            }
        });
    }
}