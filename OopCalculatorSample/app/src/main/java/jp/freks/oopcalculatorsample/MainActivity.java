package jp.freks.oopcalculatorsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Calc calc = new Calc();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtDisp = (TextView) findViewById(R.id.display);
        calc.setDisp(txtDisp, this);
    }

    public void onClickButton(View view) {

        switch (view.getId()) {
            case R.id.zero:
                calc.onButtonNumber(Number.ZERO);
                break;
            case R.id.doublezero:
                calc.onButtonNumber(Number.DOUBLE_ZERO);
                break;
            case R.id.one:
                calc.onButtonNumber(Number.ONE);
                break;
            case R.id.two:
                calc.onButtonNumber(Number.TWO);
                break;
            case R.id.three:
                calc.onButtonNumber(Number.THREE);
                break;
            case R.id.four:
                calc.onButtonNumber(Number.FOUR);
                break;
            case R.id.five:
                calc.onButtonNumber(Number.FIVE);
                break;
            case R.id.six:
                calc.onButtonNumber(Number.SIX);
                break;
            case R.id.seven:
                calc.onButtonNumber(Number.SEVEN);
                break;
            case R.id.eight:
                calc.onButtonNumber(Number.EIGHT);
                break;
            case R.id.nine:
                calc.onButtonNumber(Number.NINE);
                break;

            case R.id.plus:
                calc.onButtonOp(Operation.PLUS);
                break;
            case R.id.minus:
                calc.onButtonOp(Operation.MINUS);
                break;
            case R.id.times:
                calc.onButtonOp(Operation.TIMES);
                break;
            case R.id.divide:
                calc.onButtonOp(Operation.DIVIDE);
                break;

            case R.id.comma:
                calc.onButtonNumber(Number.COMMA);
                break;
            case R.id.allclear:
                calc.onButtonAllClear();
                break;

            case R.id.clear:
                calc.onButtonClear();
                break;

            case R.id.equal:
                calc.onButtonEquale();
                break;

            case R.id.sign:
                calc.changeSign();
                break;

            default:
                break;
        }
    }

}
