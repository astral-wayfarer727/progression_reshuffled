package astro.progression_reshuffled.mixin;

import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.CaveSpiderEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CaveSpiderEntity.class)
public class CaveSpiderBuffMixin {
    // Cave Spiders have had the same adjustments as regular Spiders, but they run even faster in exchange for having even less health
    @Inject(
            method = "createCaveSpiderAttributes",
            at = @At("TAIL")
    )
    private static void caveSpiderAttributeBuff(CallbackInfoReturnable<DefaultAttributeContainer.Builder> cir) {
        cir.getReturnValue()
                .add(EntityAttributes.MAX_HEALTH, 8F)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.4F)
                .add(EntityAttributes.FALL_DAMAGE_MULTIPLIER, 0.0F)
                .add(EntityAttributes.FOLLOW_RANGE, 25.0F)
                .add(EntityAttributes.STEP_HEIGHT, 1.1F)
        ;
    }
}
