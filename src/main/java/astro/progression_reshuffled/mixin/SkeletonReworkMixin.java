package astro.progression_reshuffled.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.LocalDifficulty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(AbstractSkeletonEntity.class)
public class SkeletonReworkMixin {
    //Adds a high chance for a Skeleton of all types other than Wither to spawn with a Sword of increasing tier + rarity
    @Inject(
            method = "initEquipment",
            at = @At("TAIL")
    )
    private void swordSkeleton(net.minecraft.util.math.random.Random random, LocalDifficulty localDifficulty, CallbackInfo ci) {
        AbstractSkeletonEntity skeleton = (AbstractSkeletonEntity) (Object) this;
        if (random.nextFloat() < 0.35f) {
            skeleton.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.WOODEN_SWORD));
        }
        if (random.nextFloat() < 0.15f) {
            skeleton.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SWORD));
        }
        if (random.nextFloat() < 0.075f) {
            skeleton.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.COPPER_SWORD));
        }
        if (random.nextFloat() < 0.025f) {
            skeleton.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
        }
    }
    //Nerfs all Skeleton Health to counterbalance their new fighting style
    @Inject(
            method = "createAbstractSkeletonAttributes",
            at = @At("RETURN")
    )
    private static void healthNerf(CallbackInfoReturnable<DefaultAttributeContainer.Builder> cir) {
        cir.getReturnValue()
                .add(EntityAttributes.MAX_HEALTH, 14.0)
        ;
    }
}