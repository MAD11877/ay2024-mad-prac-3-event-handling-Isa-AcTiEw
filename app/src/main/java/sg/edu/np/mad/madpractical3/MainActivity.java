package sg.edu.np.mad.madpractical3;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import java.lang.String;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Intent recieveIntent = getIntent();
        String passwd = recieveIntent.getStringExtra("1");
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.parent), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;




        });
        User user = new User("John Doe", "MAD Developer", 1, false);

        String name = user.name + " " + passwd;
        TextView tvName = findViewById(R.id.tvName);

        TextView tvDescription = findViewById(R.id.tvDescription);

        Button buttonFollow = findViewById(R.id.btnFollow);

        tvName.setText(name);

        tvDescription.setText(user.description);

        buttonFollow.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // get the text from button
                // logic to handle different text (follow/unfollow), follow -> unfollow vice versa
                String text = buttonFollow.getText().toString();
                if(text.equals("Follow")){
                    buttonFollow.setText("Unfollow");
                    Toast.makeText(getApplicationContext(),"Unfollowed",Toast.LENGTH_SHORT).show();
                }
                else if (text.equals("Unfollow")){
                    buttonFollow.setText("Follow");
                    Toast.makeText(getApplicationContext(),"Followed",Toast.LENGTH_SHORT).show();
                }

            }
        });

    /*Toast is a widget that display a message for a fixed duration
      subclass of the java.lang.Object class, Takes a context class as its parameter,
      it has two constants "LENGTH_LONG" (Show for a long duration) and "LENGTH_SHORT" (show for a short duration).

      Public method make Text makes a standard text toast, .show() displays the toast widget
    * */



    }


}