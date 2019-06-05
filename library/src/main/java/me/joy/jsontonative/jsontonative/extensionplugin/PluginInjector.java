package me.joy.jsontonative.jsontonative.extensionplugin;

/**
 * @author Joy
 * @description
 * @date 2019/6/4
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
