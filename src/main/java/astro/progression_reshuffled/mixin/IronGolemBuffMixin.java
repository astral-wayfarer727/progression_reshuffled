package astro.progression_reshuffled.mixin;

import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.IronGolemEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(IronGolemEntity.class)
public class IronGolemBuffMixin {
    // To compensate for more dangerous mobs, Iron Golems have more Health, Speed and the adjusted Step Height found elsewhere
    @Inject(
            method = "createIronGolemAttributes",
            at = @At("TAIL")
    )
    private static void ironGolemAttributeBuff(CallbackInfoReturnable<DefaultAttributeContainer.Builder> cir) {
        cir.getReturnValue()
                .add(EntityAttributes.MAX_HEALTH, 150F)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.3F)
                .add(EntityAttributes.STEP_HEIGHT, 1.1F)
        ;
    }
}
