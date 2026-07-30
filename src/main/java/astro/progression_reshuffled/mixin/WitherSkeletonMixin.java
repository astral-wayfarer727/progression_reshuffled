package astro.progression_reshuffled.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.WitherSkeletonEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.LocalDifficulty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WitherSkeletonEntity.class)
public class WitherSkeletonMixin {
    //Adds a low chance for the Wither Skeletons to spawn with a bow, regular Skeletons of course removed by the fortress.json
    //So apparently that didn't work so for now Regular Skeletons are stickin' around
    @Inject(
            method = "initEquipment",
            at = @At("TAIL")
    )
    private void bowWitherSkeleton(net.minecraft.util.math.random.Random random, LocalDifficulty localDifficulty, CallbackInfo ci) {
        WitherSkeletonEntity witherSkeleton = (WitherSkeletonEntity) (Object) this;
        if (random.nextFloat() < 0.1f) {
            witherSkeleton.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
        }
    }
}
