package me.joy.jsontonative.jsontonative.extensionplugin;

/**
 * Created by Joy on 2019/6/6
 */

public class PluginInjector {

  private IPlugin mPlugin;

  private static final class PluginInjectorHolder {
    public static final PluginInjector INSTANCE = new PluginInjector();
  }

  public static PluginInjector getInstance() {
    return PluginInjectorHolder.INSTANCE;
  }


  public IPlugin getPlugin() {
    return mPlugin;
  }

  public void register(IPlugin mPlugin) {
    this.mPlugin = mPlugin;
  }
}
