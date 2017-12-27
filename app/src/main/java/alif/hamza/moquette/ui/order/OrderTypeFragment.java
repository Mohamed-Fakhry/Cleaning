package alif.hamza.moquette.ui.order;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import alif.hamza.moquette.R;
import alif.hamza.moquette.model.Order;


public class OrderTypeFragment extends Fragment {

    @BindView(R.id.firstTypeTV)
    TextView firstTypeTV;
    @BindView(R.id.secondTypeTV)
    TextView secondTypeTV;
    @BindView(R.id.priceTV)
    TextView priceTV;

    private static final String ORDER_KEY = "order";
    private Order order;

    public OrderTypeFragment() {
    }

    public static OrderTypeFragment newInstance(Order order) {
        OrderTypeFragment fragment = new OrderTypeFragment();
        Bundle args = new Bundle();
        args.putSerializable(ORDER_KEY, order);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            order = (Order) getArguments().getSerializable(ORDER_KEY);
            Log.d("s1", "sucess" + order.toString());
        } else {
            order = new Order();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order_type, container, false);
        ButterKnife.bind(this, view);
        selectNormalService();
        firstTypeTV.setText(order.getPrices().get(0).getTypeOfService());
        if (order.getPrices().size() > 1) {
            secondTypeTV.setText(order.getPrices().get(1).getTypeOfService());
        } else {
            secondTypeTV.setVisibility(View.GONE);
        }
        return view;
    }

    @OnClick(R.id.nextL)
    void nextStep() {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, OrderPaymentFragment.newInstance(order));
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @OnClick(R.id.secondTypeTV)
    void selectFastService() {
        order.getPrices().get(1).setSelected(true);
        order.setTypeOfService(order.getPrices().get(1).getId());
        order.getPrices().get(0).setSelected(false);
        secondTypeTV.setBackgroundResource(R.color.colorAccent);
        firstTypeTV.setBackgroundResource(R.color.whiteColor);
        secondTypeTV.setTextColor(ContextCompat.getColor(getContext(), R.color.whiteColor));
        firstTypeTV.setTextColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
        priceTV.setText(String.valueOf(order.getPrices().get(1).getPriceOfMeter()));
    }

    @OnClick(R.id.firstTypeTV)
    void selectNormalService() {
        order.getPrices().get(0).setSelected(true);
        order.setTypeOfService(order.getPrices().get(0).getId());
        if (order.getPrices().size() > 1)
            order.getPrices().get(1).setSelected(false);
        firstTypeTV.setBackgroundResource(R.color.colorAccent);
        secondTypeTV.setBackgroundResource(R.color.whiteColor);
        firstTypeTV.setTextColor(ContextCompat.getColor(getContext(), R.color.whiteColor));
        secondTypeTV.setTextColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
        priceTV.setText(String.valueOf(order.getPrices().get(0).getPriceOfMeter()));
    }
}
