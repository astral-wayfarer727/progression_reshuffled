package astro.progression_reshuffled.mixin;

import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.ZombieEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ZombieEntity.class)
public class ZombieBuffMixin {
    // Zombies simply have a bit more health, and a bit more speed
    @Inject(
            method = "createZombieAttributes",
            at = @At("TAIL")
    )
    private static void zombieAttributeBuff(CallbackInfoReturnable<DefaultAttributeContainer.Builder> cir) {
        cir.getReturnValue()
                .add(EntityAttributes.MOVEMENT_SPEED, 0.24F)
                .add(EntityAttributes.MAX_HEALTH, 24F)
        ;
    }
}
