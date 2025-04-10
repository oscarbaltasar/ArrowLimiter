package com.oscarbaltasar.arrowdmglimit;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.loading.FMLPaths;

public class ModConfig {

    public static ForgeConfigSpec CONFIG;
    public static ForgeConfigSpec.DoubleValue MAX_ARROW_DAMAGE;
    static {
      final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
      BUILDER.comment("Mod Config").push(ModMain.MODID);
      MAX_ARROW_DAMAGE = BUILDER.comment("Maximum damage an arrow can deal").defineInRange("maxArrowDamage", 30.0, 0.0, 1000.0);
      BUILDER.pop();
      CONFIG = BUILDER.build();
    }
  
    public ModConfig() {
      final CommentedFileConfig configData = CommentedFileConfig.builder(FMLPaths.CONFIGDIR.get().resolve(ModMain.MODID + ".toml"))
        .sync()
        .autosave()
        .writingMode(WritingMode.REPLACE)
        .build();
      configData.load();
      CONFIG.setConfig(configData);
    }
}
