package zo.den.myapplication.fragments;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zo.den.myapplication.R;

public class DialogFragment1 extends DialogFragment implements View.OnClickListener {
    private String idNews;

    public DialogFragment1() {
    }

    @SuppressLint("ValidFragment")
    public DialogFragment1(String idNews) {
        this.idNews = idNews;
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().setTitle("Выбери действие:");
        View v = inflater.inflate(R.layout.dialog1, null);
        return v;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCancel: {
                this.dismiss();
            }
            break;

            case R.id.btnInfo: {
                FragmentManager fragmentManager = getFragmentManager();
                if (fragmentManager.getBackStackEntryCount()==0){
                    fragmentManager.beginTransaction()
                            .add(R.id.infoContainer, new Fragment2(idNews), Integer.toString(getFragmentCount()))
                            .addToBackStack(Integer.toString(getFragmentCount()))
                            .commit();
                }
                else{
                    fragmentManager.beginTransaction()
                            .replace(R.id.infoContainer, new Fragment2(idNews), Integer.toString(getFragmentCount()))
                            .addToBackStack(Integer.toString(getFragmentCount()))
                            .commit();
                }
                this.dismiss();
            }
            break;
        }
    }
    protected int getFragmentCount() {
        return getFragmentManager().getBackStackEntryCount();
    }
    private Fragment getFragmentAt(int index) {
        return getFragmentCount() > 0 ? getFragmentManager().findFragmentByTag(Integer.toString(index)) : null;
    }
    protected Fragment getCurrentFragment() {
        return getFragmentAt(getFragmentCount() - 1);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getView().findViewById(R.id.btnInfo).setOnClickListener(this);
        getView().findViewById(R.id.btnCancel).setOnClickListener(this);
    }
}
