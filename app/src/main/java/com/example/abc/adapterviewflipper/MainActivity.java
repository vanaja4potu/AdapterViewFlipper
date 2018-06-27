package com.example.abc.adapterviewflipper;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String[] Text = {"NetAucs Product Page", "NetAucs coverpage", "NetAucs HomePage", "NetAucs Product image", "NetAucs navigator", "can msg in NetAucs", "option topick images in NetAucs"};
    private static final int[] Images = {R.drawable.screenshot_addproduct, R.drawable.screenshot_coverpages, R.drawable.screenshot_homepage, R.drawable.screenshot_images, R.drawable.screenshot_navigator, R.drawable.screenshot_messages, R.drawable.screenshot_optionsforimage, R.drawable.screenshot_photopick,};
    private AdapterViewFlipper adapterViewFlipper;
    private Button btnPrevious, btnNext;
    private int mPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapterViewFlipper = (AdapterViewFlipper) findViewById(R.id.idadapter);
        FlipperAdapter adapter = new FlipperAdapter(this, Text, Images);
        adapterViewFlipper.setAdapter(adapter);
        adapterViewFlipper.setAutoStart(true);

    }

    class FlipperAdapter extends BaseAdapter {
        Context ctx;
        int[] images;
        String[] text;
        LayoutInflater inflater;

        public FlipperAdapter(Context context, String[] myText, int[] myImages) {
            this.ctx = context;
            this.images = myImages;
            this.text = myText;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return text.length;
        }

        @Override
        public Object getItem(int i) {
            return null;

        }

        @Override
        public long getItemId(int i) {
            return 0;

        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = inflater.inflate(R.layout.flipper_item, null);
            TextView txtName = view.findViewById(R.id.idtextview);
            ImageView txtImage = view.findViewById(R.id.imageview);
            txtName.setText(text[i]);
            txtImage.setImageResource(images[i]);
            return view;
        }
    }
}
