package zo.den.myapplication.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zo.den.myapplication.R;

public class DialogFragment1 extends DialogFragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().setTitle("Выбери действие:");
        View v = inflater.inflate(R.layout.dialog1, null);
       // v.findViewById(R.id.btnDelete).setOnClickListener(this);
        v.findViewById(R.id.btnCancel).setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCancel: {
                this.dismiss();
            }
            break;

            case R.id.btnDelete: {
                //TODO
            }
            break;
        }
    }
}
