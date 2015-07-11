package in.gravitykerala.universityofcalicut;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;

import in.gravitykerala.universityofcalicut.Fragment.DemoFragment;
import in.gravitykerala.universityofcalicut.Fragment.PareekshaBhavanFragment;
import in.gravitykerala.universityofcalicut.Fragment.HomeFragment;


public class HomeDrawer extends AppCompatActivity {

    //save our header or result
    private AccountHeader headerResult = null;
    private Drawer result = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_drawer);

        // Handle Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Fragment f = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).commit();

        headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .withSavedInstance(savedInstanceState)
                .build();

        //Create the drawer
        result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(headerResult) //set the AccountHeader we created earlier for the header
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.home).withIcon(GoogleMaterial.Icon.gmd_home).withIdentifier(1).withCheckable(false),
                        new PrimaryDrawerItem().withName(R.string.title_activity_pareeksha_bhavan).withIcon(GoogleMaterial.Icon.gmd_notifications).withIdentifier(4).withCheckable(false),
                        new PrimaryDrawerItem().withName(R.string.about_fragment_title).withIcon(GoogleMaterial.Icon.gmd_contacts).withIdentifier(2).withCheckable(true),
                        new PrimaryDrawerItem().withName(R.string.demo_two).withIcon(GoogleMaterial.Icon.gmd_event).withIdentifier(3).withCheckable(true)

                ) // add the items we want to use with our Drawer
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {
                        //check if the drawerItem is set.
                        //there are different reasons for the drawerItem to be null
                        //--> click on the header
                        //--> click on the footer
                        //those items don't contain a drawerItem

                        if (drawerItem != null) {
                            Intent intent = null;
                            if (drawerItem.getIdentifier() == 4) {
                                intent = new Intent(HomeDrawer.this, PareekshaBhavanActivity.class);
                            } else if (drawerItem.getIdentifier() == 2) {
                                getSupportActionBar().setTitle(((Nameable) drawerItem).getNameRes());
                                //ignore the DemoFragment and it's layout it's just to showcase the handle with an keyboard
                                Fragment f = DemoFragment.newInstance(getResources().getString(((Nameable) drawerItem).getNameRes()));
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).commit();
                            } else if (drawerItem.getIdentifier() == 3) {
                                getSupportActionBar().setTitle(((Nameable) drawerItem).getNameRes());
                                //ignore the DemoFragment and it's layout it's just to showcase the handle with an keyboard
                                Fragment f = new PareekshaBhavanFragment();
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).commit();

                            } else if (drawerItem.getIdentifier() == 1) {
                                getSupportActionBar().setTitle(((Nameable) drawerItem).getNameRes());
                                //ignore the DemoFragment and it's layout it's just to showcase the handle with an keyboard
                                Fragment f = new HomeFragment();
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).commit();

                            }


                            if (intent != null) {
                                HomeDrawer.this.startActivity(intent);
                            }
                        }

                        return false;
                    }
                })
                .withSavedInstance(savedInstanceState)
                .withShowDrawerOnFirstLaunch(true)
                .build();

        if (savedInstanceState == null) {
            // set the selection to the item with the identifier 10
            result.setSelectionByIdentifier(1, false);

            //set the active profile
            //headerResult.setActiveProfile(profile3);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
