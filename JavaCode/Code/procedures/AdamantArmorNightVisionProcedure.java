package net.mcreator.mymodpack.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.mymodpack.MyModpackElements;

@MyModpackElements.ModElement.Tag
public class AdamantArmorNightVisionProcedure extends MyModpackElements.ModElement {
	public AdamantArmorNightVisionProcedure(MyModpackElements instance) {
		super(instance, 34);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AdamantArmorNightVision!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, (int) 1, (int) 2, (false), (false)));
	}
}
