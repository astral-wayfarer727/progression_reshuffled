package astro.progression_reshuffled.mixin;

import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.WolfEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WolfEntity.class)
public class WolfBuffMixin {
    // To compensate for more dangerous mobs, Wolves have more Speed, Damage, Safe Fall Distance and the adjusted Step Height found elsewhere
    @Inject(
            method = "createWolfAttributes",
            at = @At("TAIL")
    )
    private static void wolfAttributeBuff(CallbackInfoReturnable<DefaultAttributeContainer.Builder> cir) {
        cir.getReturnValue()
                .add(EntityAttributes.MOVEMENT_SPEED, 0.335F)
                .add(EntityAttributes.ATTACK_DAMAGE, 5.0F)
                .add(EntityAttributes.STEP_HEIGHT, 1.1F)
                .add(EntityAttributes.SAFE_FALL_DISTANCE, 6.0F)
        ;
    }
}
