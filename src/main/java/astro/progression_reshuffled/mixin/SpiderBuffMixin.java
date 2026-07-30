package astro.progression_reshuffled.mixin;

import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.SpiderEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SpiderEntity.class)
public class SpiderBuffMixin {
    // Spiders have been changed a lot. They're now faster, can see the Player from further away, take no fall damage and can step up full blocks (the .1 is in case of path
    // blocks), but to compensate they've had their health lowered a bit as well
    @Inject(
            method = "createSpiderAttributes",
            at = @At("TAIL")
    )
    private static void spiderAttributeBuff(CallbackInfoReturnable<DefaultAttributeContainer.Builder> cir) {
        cir.getReturnValue()
                .add(EntityAttributes.MAX_HEALTH, 14F)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.35F)
                .add(EntityAttributes.FALL_DAMAGE_MULTIPLIER, 0.0F)
                .add(EntityAttributes.FOLLOW_RANGE, 25.0F)
                .add(EntityAttributes.STEP_HEIGHT, 1.1F)
        ;
    }
}
