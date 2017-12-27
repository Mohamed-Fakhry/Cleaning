package alif.hamza.moquette.ui.map;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.example.computec.eltadreb.ui.base.BaseActivity;
import com.google.android.gms.maps.model.LatLng;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import alif.hamza.moquette.R;
import alif.hamza.moquette.model.Location;
import alif.hamza.moquette.model.Order;
import alif.hamza.moquette.model.Price;
import alif.hamza.moquette.service.LoginPref;
import alif.hamza.moquette.ui.cart.CartFragment;
import alif.hamza.moquette.ui.notification.NotificationFragment;
import alif.hamza.moquette.ui.order.OrderFragment;
import alif.hamza.moquette.ui.order.OrderPaymentFragment;
import alif.hamza.moquette.ui.profile.ProfileFragment;

public class MapsActivity extends BaseActivity implements OrderPaymentFragment.OnFinishOrder,
        MapContract.View, NavigationView.OnNavigationItemSelectedListener,
        MapFragment.OnFragmentInteractionListener {

    @BindView(R.id.orderL)
    LinearLayout orderL;

    Order order = new Order();
    private  MapContract.Presenter<MapsActivity> mapPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setUp();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else if (orderL.getVisibility() != View.GONE) {
            orderL.setVisibility(View.GONE);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onFinishOrder(Order order) {
        orderL.setVisibility(View.GONE);
        mapPresenter.makeOrder(order);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_map) {
            openMap();
        } else if (id == R.id.nav_cart) {
            openCart();
        } else if (id == R.id.nav_contact) {
            openAbout();
        } else if (id == R.id.nav_profile) {
            openProfile();
        } else if(id == R.id.nav_sign_out) {
            exitApp();
        } else if (id == R.id.nav_notification) {
            openNotification();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void openNotification() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.nav_container, NotificationFragment.Companion.newInstance())
                .commit();
    }

    private void exitApp() {
        LoginPref loginPref = new LoginPref(this);
        loginPref.removeAccessToken(this);
        finish();
    }

    private void openProfile() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.nav_container, ProfileFragment.Companion.newInstance())
                .commit();
    }

    private void openAbout() {}

    private void openCart() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.nav_container, CartFragment.Companion.newInstance())
                .commit();
    }

    private void openMap() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.nav_container, MapFragment.newInstance())
                .commit();
    }

    @Override
    public void onAddOrderClick(LatLng userPosition) {
        if (userPosition != null) {
            order.setLocation(new Location(userPosition));

            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, OrderFragment.Companion.newInstance(order));
            transaction.commit();

            orderL.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void setUp() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_container, MapFragment.newInstance());
        transaction.commit();
        mapPresenter = new MapPresenter<>();
        mapPresenter.onAttach(this);
        mapPresenter.getPrices();
    }

    @Override
    public void confirmOrder() {

    }

    @Override
    public void getPrices(@NotNull List<Price> prices) {
        order.setPrices(prices);
    }
}
