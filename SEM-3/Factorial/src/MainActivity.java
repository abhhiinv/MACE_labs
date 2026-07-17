    package com.example.factorial;

    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.TextView;

    import androidx.activity.EdgeToEdge;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.core.graphics.Insets;
    import androidx.core.view.ViewCompat;
    import androidx.core.view.WindowInsetsCompat;

    import org.w3c.dom.Text;

    public class MainActivity extends AppCompatActivity implements View.OnClickListener{
        EditText input;
        TextView res;
        Button find;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            input=findViewById(R.id.input);
            res=findViewById(R.id.result);
            find = (Button) findViewById(R.id.button);
            find.setOnClickListener(this);
        }
        @Override
        public void onClick(View v){
            if(v.getId()==R.id.button){
                String text=input.getText().toString();
                if(text.isEmpty()){
                    res.setText("Please enter a number");
                    return;
                }
                int n = Integer.parseInt(text);
                long fact =1;
                for(int i=2;i<=n;i++){
                    fact*=i;
                }
                res.setText("Factorial of "+n+" = "+fact);
            }
        }
    }