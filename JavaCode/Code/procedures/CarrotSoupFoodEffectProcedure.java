package net.mcreator.mymodpack.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.mymodpack.MyModpackElements;

@MyModpackElements.ModElement.Tag
public class CarrotSoupFoodEffectProcedure extends MyModpackElements.ModElement {
	public CarrotSoupFoodEffectProcedure(MyModpackElements instance) {
		super(instance, 36);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure CarrotSoupFoodEffect!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 120, (int) 2, (false), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HASTE, (int) 120, (int) 2, (false), (false)));
	}
}
