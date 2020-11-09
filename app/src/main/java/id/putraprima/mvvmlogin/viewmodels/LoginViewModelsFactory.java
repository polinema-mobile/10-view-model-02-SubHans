package id.putraprima.mvvmlogin.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import id.putraprima.mvvmlogin.models.User;

public class LoginViewModelsFactory implements ViewModelProvider.Factory {

    private User user;
    public LoginViewModelsFactory(User user) {
        this.user = user;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(LoginViewModels.class)){
            return (T) new LoginViewModels(user);
        }
        throw new IllegalArgumentException("Viewmodel Yang Diminta LoginViewModel");
    }
}
