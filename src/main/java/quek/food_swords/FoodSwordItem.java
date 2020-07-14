package quek.food_swords;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class FoodSwordItem extends SwordItem {

    public FoodSwordItem(IItemTier tier, Properties properties) {
        super(tier, 3, -2.4F, properties);
    }

    @Override
    public boolean isFood() {
        return true;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        if (playerIn.canEat(this.getFood().canEatWhenFull())) {
            playerIn.setActiveHand(handIn);
            return ActionResult.resultConsume(itemstack);
        } else {
            return ActionResult.resultFail(itemstack);
        }
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        worldIn.playSound((PlayerEntity) entityLiving, entityLiving.getPosX(), entityLiving.getPosY(), entityLiving.getPosZ(), entityLiving.getEatSound(stack), SoundCategory.NEUTRAL, 1.0F, 1.0F + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.4F);
        onFoodEaten(worldIn, stack, (PlayerEntity)entityLiving);

        return stack;
    }

    public ItemStack onFoodEaten(World world, ItemStack stack, PlayerEntity entityLiving) {
        world.playSound(null, entityLiving.getPosX(), entityLiving.getPosY(), entityLiving.getPosZ(), this.getEatSound(), SoundCategory.NEUTRAL, 1.0F, 1.0F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.4F);
        entityLiving.applyFoodEffects(stack, world, entityLiving);
        entityLiving.getFoodStats().consume(stack.getItem(), stack);
        if (!(entityLiving instanceof PlayerEntity) || !((PlayerEntity)entityLiving).abilities.isCreativeMode) {
            stack.damageItem(1, entityLiving, (entity) -> entity.sendBreakAnimation(entity.getActiveHand()));
        }

        return stack;
    }

}
