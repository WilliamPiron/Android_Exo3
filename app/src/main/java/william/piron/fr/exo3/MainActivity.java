package william.piron.fr.exo3;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity{
    int i;
    Fragment[] fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        i=0;
        fragments = new Fragment[3];

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_next = (Button) findViewById(R.id.layout_buttonnext);
        Button button_previous = (Button) findViewById(R.id.layout_buttonprevious);

        fragments[0] = new Fragment_1();
        fragments[1] = new Fragment_2();
        fragments[2] = new Fragment_3();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.framelayout,fragments[i]).commit();


        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = (i+1)%3;
                FragmentTransaction fragmentTransaction2 = getFragmentManager().beginTransaction();
                fragmentTransaction2.replace(R.id.framelayout, fragments[i]).addToBackStack(null);
                fragmentTransaction2.commit();
            }
        });

        button_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //On ajoute 2 au lieu de retirer 1, les négatifs font planter
                i = (i+2)%3;
                FragmentTransaction fragmentTransaction2 = getFragmentManager().beginTransaction();
                fragmentTransaction2.replace(R.id.framelayout, fragments[i]).addToBackStack(null);
                fragmentTransaction2.commit();
            }
        });
    }
}
