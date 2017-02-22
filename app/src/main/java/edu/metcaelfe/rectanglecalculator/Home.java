package edu.metcaelfe.rectanglecalculator;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.math.BigDecimal;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    public void calculatePropertiesOfRectangle(View view) {
        BigDecimal width, height, perimeter, area;

        TextView txtWidth = (TextView) findViewById(R.id.txtWidth);
        TextView txtHeight = (TextView) findViewById(R.id.txtHeight);
        TextView txtArea = (TextView) findViewById(R.id.txtArea);
        TextView txtPerimeter = (TextView) findViewById(R.id.txtPerimeter);
        TextView txtX = (TextView) findViewById(R.id.txtRectangleShortSide);
        TextView txtY = (TextView) findViewById(R.id.txtRectangleLongSide);
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayoutImgViewContainer);

        try {
            if (txtWidth.getText().toString().length() == 0) {
                width = roundBigDecimal(new BigDecimal("15.00"));
                txtWidth.setText(width.toString());
            } else {
                width = roundBigDecimal(new BigDecimal(txtWidth.getText().toString()));
            }
            if (txtHeight.getText().toString().length() == 0) {
                height = roundBigDecimal(new BigDecimal("25.00"));
                txtHeight.setText(height.toString());
            } else {
                height = roundBigDecimal(new BigDecimal(txtHeight.getText().toString()));
            }
            area = roundBigDecimal(width.multiply(height));
            perimeter = roundBigDecimal(width.multiply(height).multiply(new BigDecimal("2.00")));
            txtArea.setText(area.toString());
            txtPerimeter.setText(perimeter.toString());

            txtX.setText(height.toString());
            txtY.setText(width.toString());
            constraintLayout.setVisibility(View.VISIBLE);

        } catch (Exception exc) {
            System.out.println(exc.toString());
        }

    }

    public BigDecimal roundBigDecimal(BigDecimal bd) {
        BigDecimal roundedBigDecimal = null;
        try {
            roundedBigDecimal = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        } catch (Exception exc) {
            System.out.println(exc.toString());
        }
        return roundedBigDecimal == null ? bd : roundedBigDecimal;
    }
}
