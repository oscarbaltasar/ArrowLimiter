package com.oscarbaltasar.arrowdmglimit;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ModMain.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ArrowDamageCapHandler {
    
    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        // Check if the damage source is an arrow
        if (event.getSource().getDirectEntity() instanceof AbstractArrow) {
            float maxDamage = ModConfig.MAX_ARROW_DAMAGE.get().floatValue();
            float originalDamage = event.getAmount();

            // Cap the damage if it exceeds the max
            if (originalDamage > maxDamage) {
                event.setAmount(maxDamage);
            }
        }
    }
}