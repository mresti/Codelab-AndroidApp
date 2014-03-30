package es.gdggranada.choosecolours.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Color;
import android.content.Context;


public class MainActivity extends Activity {

    SeekBar seekBarRed, seekBarBlue, seekBarGreen;
    TextView textViewTagRed, textViewTagBlue, textViewTagGreen;
    TextView textViewValueRed, textViewValueBlue, textViewValueGreen;
    LinearLayout layoutBg;
    Button buttonSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewTagRed = (TextView) this.findViewById(R.id.textViewTagRed);
        textViewValueRed = (TextView) this.findViewById(R.id.textViewValueRed);
        seekBarRed = (SeekBar) this.findViewById(R.id.seekBarRed);

        textViewTagGreen = (TextView) this.findViewById(R.id.textViewTagGreen);
        textViewValueGreen = (TextView) this.findViewById(R.id.textViewValueGreen);
        seekBarGreen = (SeekBar) this.findViewById(R.id.seekBarGreen);

        textViewTagBlue = (TextView) this.findViewById(R.id.textViewTagBlue);
        textViewValueBlue = (TextView) this.findViewById(R.id.textViewValueBlue);
        seekBarBlue = (SeekBar) this.findViewById(R.id.seekBarBlue);

        buttonSwitch = (Button) this.findViewById(R.id.ButtonSwitch);

        layoutBg = (LinearLayout) this.findViewById(R.id.LinearLayoutBg);

        // Call method onClick
        onClickChoice(this.findViewById(R.id.ButtonSwitch));
    }


    public void onClickChoice(View view){
        // Retrieve value each colors
        int valueRed = seekBarRed.getProgress();
        int valueGreen = seekBarGreen.getProgress();
        int valueBlue = seekBarBlue.getProgress();

        // Select each color
        textViewValueRed.setText(String.valueOf(valueRed));
        textViewValueGreen.setText(String.valueOf(valueGreen));
        textViewValueBlue.setText(String.valueOf(valueBlue));

        // Change the bgcolor
        layoutBg.setBackgroundColor(Color.rgb(valueRed, valueGreen, valueBlue));

        // Switch White/Black color
        if((valueRed + valueGreen + valueBlue) > ((255 * 3) / 2)){
            int colorBlack = this.getResources().getColor(R.color.color_black);
            textViewTagRed.setTextColor(colorBlack);
            textViewTagGreen.setTextColor(colorBlack);
            textViewTagBlue.setTextColor(colorBlack);
            textViewValueRed.setTextColor(colorBlack);
            textViewValueGreen.setTextColor(colorBlack);
            textViewValueBlue.setTextColor(colorBlack);
            buttonSwitch.setTextColor(colorBlack);
        } else {
            int colorWhite = this.getResources().getColor(R.color.color_white);
            textViewTagRed.setTextColor(colorWhite);
            textViewTagGreen.setTextColor(colorWhite);
            textViewTagBlue.setTextColor(colorWhite);
            textViewValueRed.setTextColor(colorWhite);
            textViewValueGreen.setTextColor(colorWhite);
            textViewValueBlue.setTextColor(colorWhite);
            buttonSwitch.setTextColor(colorWhite);
        }

        //Notification Toast
        Toast toast;
        Context context = getApplicationContext();
        CharSequence text = "Your color!!!";
        int duration = Toast.LENGTH_SHORT;
        toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}
