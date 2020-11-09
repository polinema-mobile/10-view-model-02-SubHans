package id.putraprima.mvvmlogin.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import id.putraprima.mvvmlogin.R;
import id.putraprima.mvvmlogin.databinding.FragmentLoginBinding;
import id.putraprima.mvvmlogin.models.User;
import id.putraprima.mvvmlogin.viewmodels.LoginViewModels;
import id.putraprima.mvvmlogin.viewmodels.LoginViewModelsFactory;

public class LoginFragment extends Fragment {
    public LoginViewModels loginViewModels;
    Bundle bundle = new Bundle();

    public LoginFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LoginViewModelsFactory loginViewModelsFactory = new LoginViewModelsFactory(new User("indra@gmail.com","123456"));
        loginViewModels = new ViewModelProvider(this, loginViewModelsFactory).get(LoginViewModels.class);
        FragmentLoginBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login, container, false);
        binding.setUserLogin(loginViewModels);
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loginViewModels.loggedLiveData().observe(this.getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (loginViewModels.loggedLiveData().getValue()==true){
                    bundle.putString("data", loginViewModels.getLogin().getValue().email);
                    Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment,bundle);
                }
            }
        });
    }
}