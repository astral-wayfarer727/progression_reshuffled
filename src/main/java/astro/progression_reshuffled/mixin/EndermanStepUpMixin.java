package astro.progression_reshuffled.mixin;

import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.EndermanEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EndermanEntity.class)
public class EndermanStepUpMixin {
    // Just changes Enderman Step Up height to 1.1 blocks so they can step up from paths
    @Inject(
            method = "createEndermanAttributes",
            at = @At("TAIL")
    )
    private static void endermanStepUpBuff(CallbackInfoReturnable<DefaultAttributeContainer.Builder> cir) {
        cir.getReturnValue()
                .add(EntityAttributes.STEP_HEIGHT, 1.1F)
        ;
    }
}
