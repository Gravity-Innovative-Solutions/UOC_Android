//package in.gravitykerala.universityofcalicut;
//
//import android.content.Intent;
//import android.graphics.Bitmap;
//import android.graphics.drawable.BitmapDrawable;
//import android.os.Build;
//import android.os.Bundle;
//import android.support.design.widget.CollapsingToolbarLayout;
//import android.support.v4.app.ActivityCompat;
//import android.support.v4.app.ActivityOptionsCompat;
//import android.support.v4.view.ViewCompat;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.graphics.Palette;
//
//import android.support.v7.widget.Toolbar;
//import android.transition.Slide;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.support.v4.view.ViewCompat;
//
//
//
//
//
//import com.squareup.picasso.Picasso;
//
//import javax.security.auth.callback.Callback;
//
//
//public class DetailActivity extends AppCompatActivity {
//    private static final String EXTRA_IMAGE = "com.antonioleiva.materializeyourapp.extraImage";
//    private static final String EXTRA_TITLE = "com.antonioleiva.materializeyourapp.extraTitle";
//    private CollapsingToolbarLayout collapsingToolbarLayout;
//
//    public static void navigate(AppCompatActivity activity, View transitionImage, ViewModel viewModel) {
//        Intent intent = new Intent(activity, DetailActivity.class);
//        intent.putExtra(EXTRA_IMAGE, viewModel.getImage());
//        intent.putExtra(EXTRA_TITLE, viewModel.getText());
//
//        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, transitionImage, EXTRA_IMAGE);
//        ActivityCompat.startActivity(activity, intent, options.toBundle());
//    }
//    @SuppressWarnings("ConstantConditions")
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        initActivityTransitions();
//
//        setContentView(R.layout.activity_detail);
//        ViewCompat.setTransitionName(findViewById(R.id.app_bar_layout), EXTRA_IMAGE);
//        supportPostponeEnterTransition();
//
//        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        String itemTitle = getIntent().getStringExtra(EXTRA_TITLE);
//        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
//        collapsingToolbarLayout.setTitle(itemTitle);
//        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
//
//        final ImageView image = (ImageView) findViewById(R.id.image);
//        Picasso.with(this).load(getIntent().getStringExtra(EXTRA_IMAGE)).into(image, new Callback() {
//            @Override
//            public void onSuccess() {
//                Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
//                Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
//                    public void onGenerated(Palette palette) {
//                        applyPalette(palette);
//                    }
//                });
//            }
//
//            @Override
//            public void onError() {
//
//            }
//        });
//
//        TextView title = (TextView) findViewById(R.id.title);
//        title.setText(itemTitle);
//    }
//    private void initActivityTransitions() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Slide transition = new Slide();
//            transition.excludeTarget(android.R.id.statusBarBackground, true);
//            getWindow().setEnterTransition(transition);
//            getWindow().setReturnTransition(transition);
//        }
//    }
////    private void applyPalette(Palette palette) {
////        int primaryDark = getResources().getColor(R.color.primary_dark);
////        int primary = getResources().getColor(R.color.primary);
////        collapsingToolbarLayout.setContentScrimColor(palette.getMutedColor(primary));
////        collapsingToolbarLayout.setStatusBarScrimColor(palette.getDarkMutedColor(primaryDark));
////        updateBackground((FloatingActionButton) findViewById(R.id.fab), palette);
////        supportStartPostponedEnterTransition();
////    }
//
////    private void updateBackground(FloatingActionButton fab, Palette palette) {
////        int lightVibrantColor = palette.getLightVibrantColor(getResources().getColor(android.R.color.white));
////        int vibrantColor = palette.getVibrantColor(getResources().getColor(R.color.accent));
////
////        fab.setRippleColor(lightVibrantColor);
////        fab.setBackgroundTintList(ColorStateList.valueOf(vibrantColor));
////    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_detail, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//}
