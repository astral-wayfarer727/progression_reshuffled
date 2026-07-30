package astro.progression_reshuffled.mixin;

import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.BlazeEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlazeEntity.class)
public class BlazeNerfMixin {
    //Ok honestly this is less about balance and more about the fact that the Blazes absolutely absurd range drives me crazy any time I visit a Nether Fortress, still kept it
    // higher than standard Hostile Mobs but not the insane value of 48 it used to be
    @Inject(
            method = "createBlazeAttributes",
            at = @At("TAIL")
    )
    private static void blazeRangeNerf(CallbackInfoReturnable<DefaultAttributeContainer.Builder> cir) {
        cir.getReturnValue()
                .add(EntityAttributes.FOLLOW_RANGE, 25.0)
        ;
    }
}
