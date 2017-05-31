package com.aliter.injector.component.activity;

import com.aliter.injector.component.LoginHttpModule;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class DaggerLoginComponent implements LoginComponent {
  private DaggerLoginComponent(Builder builder) {  
    assert builder != null;
  }

  public static Builder builder() {  
    return new Builder();
  }

  public static LoginComponent create() {  
    return builder().build();
  }

  public static final class Builder {
    private LoginHttpModule loginHttpModule;
  
    private Builder() {  
    }
  
    public LoginComponent build() {  
      if (loginHttpModule == null) {
        this.loginHttpModule = new LoginHttpModule();
      }
      return new DaggerLoginComponent(this);
    }
  
    public Builder loginHttpModule(LoginHttpModule loginHttpModule) {  
      if (loginHttpModule == null) {
        throw new NullPointerException("loginHttpModule");
      }
      this.loginHttpModule = loginHttpModule;
      return this;
    }
  }
}

