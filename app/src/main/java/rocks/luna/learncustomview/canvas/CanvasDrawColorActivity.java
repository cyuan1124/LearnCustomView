package rocks.luna.learncustomview.canvas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.colorpicker.ColorPickerDialog;
import com.android.colorpicker.ColorPickerPalette;
import com.android.colorpicker.ColorPickerSwatch;

import rocks.luna.learncustomview.R;

public class CanvasDrawColorActivity extends AppCompatActivity
        implements ColorPickerSwatch.OnColorSelectedListener {

    ColorPickerPalette colorPickerPalette;
    DrawColorView drawColorView;

    int[] colorResIds = {R.color.amber, R.color.blue, R.color.blue_grey, R.color.brown,
            R.color.cyan, R.color.deep_orange, R.color.deep_purple, R.color.green,
            R.color.grey, R.color.indigo, R.color.light_blue, R.color.light_green,};
    int[] colors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas_draw_color);
        drawColorView = (DrawColorView) findViewById(R.id.draw_color_view);

        colorPickerPalette = (ColorPickerPalette) findViewById(R.id.palette);
        colorPickerPalette.init(ColorPickerDialog.SIZE_SMALL, 6, this);
        colors = new int[colorResIds.length];
        for (int i = 0; i < colorResIds.length; i++) {
            colors[i] = getResources().getColor(colorResIds[i]);
        }
        colorPickerPalette.drawPalette(colors, colors[0]);
        drawColorView.drawColor(colors[0]);
    }

    @Override
    public void onColorSelected(int color) {
        colorPickerPalette.drawPalette(colors, color);
        drawColorView.drawColor(color);
    }
}
