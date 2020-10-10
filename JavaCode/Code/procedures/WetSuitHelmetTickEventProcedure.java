package net.mcreator.mymodpack.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.mymodpack.MyModpackElements;

@MyModpackElements.ModElement.Tag
public class WetSuitHelmetTickEventProcedure extends MyModpackElements.ModElement {
	public WetSuitHelmetTickEventProcedure(MyModpackElements instance) {
		super(instance, 37);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure WetSuitHelmetTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, (int) 1, (int) 3, (false), (false)));
	}
}
