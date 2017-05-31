// Generated code from Butter Knife. Do not modify!
package com.aliter.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.zxly.o2o.shop.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AliterHomeActivity_ViewBinding<T extends AliterHomeActivity> implements Unbinder {
  protected T target;

  @UiThread
  public AliterHomeActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.vpHome = Utils.findRequiredViewAsType(source, R.id.vp_home, "field 'vpHome'", ViewPager.class);
    target.tvToolbar = Utils.findRequiredViewAsType(source, R.id.tv_toolbar, "field 'tvToolbar'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.tabGank = Utils.findRequiredViewAsType(source, R.id.tab_gank, "field 'tabGank'", TabLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.vpHome = null;
    target.tvToolbar = null;
    target.toolbar = null;
    target.tabGank = null;

    this.target = null;
  }
}
