package id.putraprima.mvvmlogin.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import id.putraprima.mvvmlogin.R;
import id.putraprima.mvvmlogin.databinding.FragmentLoginBinding;
import id.putraprima.mvvmlogin.viewmodels.LoginViewModels;

public class LoginFragment extends Fragment {
    public LoginViewModels loginViewModels;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentLoginBinding fragmentLoginBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false);
        loginViewModels = new ViewModelProvider(this).get(LoginViewModels.class);
        fragmentLoginBinding.setUserLogin(loginViewModels);
        fragmentLoginBinding.setLifecycleOwner(this);
        return fragmentLoginBinding.getRoot();
    }

    public static void run (View view, String message){
        if (message!=null){
            Toast.makeText(view.getContext(),message,Toast.LENGTH_SHORT).show();
        }
    }
}