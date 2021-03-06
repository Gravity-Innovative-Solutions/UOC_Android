package in.gravitykerala.universityofcalicut;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

import in.gravitykerala.universityofcalicut.Fragment.AdmissionPortal;
import in.gravitykerala.universityofcalicut.Fragment.Contact;
import in.gravitykerala.universityofcalicut.Fragment.DemoFragment;
import in.gravitykerala.universityofcalicut.Fragment.DistanceEducation;
import in.gravitykerala.universityofcalicut.Fragment.HomeFragment;
import in.gravitykerala.universityofcalicut.Fragment.OnlineApplication;
import in.gravitykerala.universityofcalicut.Fragment.OnlineRegistration;
import in.gravitykerala.universityofcalicut.Fragment.PareekshaBhavanFragment;
import in.gravitykerala.universityofcalicut.Fragment.PlacementPortal;


public class HomeDrawer extends AppCompatActivity {

    //save our header or result
    private AccountHeader headerResult = null;
    private Drawer result = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_drawer);
        NotificationActivity.initializeMobileService(this);
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
                        new PrimaryDrawerItem().withName(R.string.home).withIcon(GoogleMaterial.Icon.gmd_home).withIdentifier(1).withCheckable(true),
                        new PrimaryDrawerItem().withName(R.string.about_fragment_title).withIcon(GoogleMaterial.Icon.gmd_contacts).withIdentifier(2).withCheckable(true),
                        new PrimaryDrawerItem().withName(R.string.title_fragment_pareekshabavan).withIcon(GoogleMaterial.Icon.gmd_event).withIdentifier(3).withCheckable(true),
                        new PrimaryDrawerItem().withName(R.string.title_fragment_admission_portal).withIcon(GoogleMaterial.Icon.gmd_card_giftcard).withIdentifier(4).withCheckable(true),
                        new PrimaryDrawerItem().withName(R.string.demo_two).withIcon(GoogleMaterial.Icon.gmd_notifications_active).withIdentifier(9).withCheckable(true),
                        new PrimaryDrawerItem().withName(R.string.title_activity_diedu).withIcon(GoogleMaterial.Icon.gmd_people).withIdentifier(6).withCheckable(true),
                        new PrimaryDrawerItem().withName(R.string.title_activity_online_reg).withIcon(GoogleMaterial.Icon.gmd_adb).withIdentifier(5).withCheckable(true),
                        new PrimaryDrawerItem().withName(R.string.title_activity_plcmnt).withIcon(GoogleMaterial.Icon.gmd_business).withIdentifier(7).withCheckable(true),
                        new PrimaryDrawerItem().withName(R.string.online_payment).withIcon(GoogleMaterial.Icon.gmd_perm_identity).withIdentifier(8).withCheckable(true),
                        new PrimaryDrawerItem().withName(R.string.title_activity_feedback).withIcon(GoogleMaterial.Icon.gmd_feedback).withIdentifier(10).withCheckable(true),
                        new PrimaryDrawerItem().withName(R.string.title_activity_contact).withIcon(GoogleMaterial.Icon.gmd_contact_phone).withIdentifier(11).withCheckable(true)





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
                            if (drawerItem.getIdentifier() == 1) {
                                getSupportActionBar().setTitle(((Nameable) drawerItem).getNameRes());
                                //ignore the DemoFragment and it's layout it's just to showcase the handle with an keyboard
                                Fragment f = new HomeFragment();
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).commit();

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

                            } else if (drawerItem.getIdentifier() == 4) {


//                                intent = new Intent(HomeDrawer.this, AboutActivity.class);

                                getSupportActionBar().setTitle(((Nameable) drawerItem).getNameRes());
                                //ignore the DemoFragment and it's layout it's just to showcase the handle with an keyboard
                                Fragment f = new AdmissionPortal();
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).commit();
                            } else if (drawerItem.getIdentifier() == 5) {
                                getSupportActionBar().setTitle(((Nameable) drawerItem).getNameRes());
                                //ignore the DemoFragment and it's layout it's just to showcase the handle with an keyboard
                                Fragment f = new OnlineRegistration();
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).commit();


                            } else if (drawerItem.getIdentifier() == 6) {
                                getSupportActionBar().setTitle(((Nameable) drawerItem).getNameRes());
                                //ignore the DemoFragment and it's layout it's just to showcase the handle with an keyboard
                                Fragment f = new DistanceEducation();
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).commit();



                            } else if (drawerItem.getIdentifier() == 7) {
                                getSupportActionBar().setTitle(((Nameable) drawerItem).getNameRes());
                                //ignore the DemoFragment and it's layout it's just to showcase the handle with an keyboard
                                Fragment f = new PlacementPortal();
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).commit();

                            } else if (drawerItem.getIdentifier() == 8) {
                                getSupportActionBar().setTitle(((Nameable) drawerItem).getNameRes());
                                //ignore the DemoFragment and it's layout it's just to showcase the handle with an keyboard
                                Fragment f = new OnlineApplication();
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).commit();
                            } else if (drawerItem.getIdentifier() == 9) {
                                intent = new Intent(HomeDrawer.this, NewCommonNotificationActivity.class);
                            } else if (drawerItem.getIdentifier() == 11) {
                                getSupportActionBar().setTitle(((Nameable) drawerItem).getNameRes());
                                //ignore the DemoFragment and it's layout it's just to showcase the handle with an keyboard
                                Fragment f = new Contact();
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).commit();


                            } else if (drawerItem.getIdentifier() == 10) {
                                intent = new Intent(HomeDrawer.this, TalktoVC.class);

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
        if (id == R.id.action_course_preference) {
            Intent i = new Intent(HomeDrawer.this, CourseSelectActivity.class);
            startActivity(i);
            finish();
            return false;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("mUniversity")
                .setMessage("Are you sure you want to Exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }

}
