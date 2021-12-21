package supercoder79.farlands.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.border.WorldBorder.StaticArea;

@Mixin(WorldBorder.class)
public class MixinWorldBorder {
	@Shadow private int maxRadius;

	@Shadow private WorldBorder.Area area;

	@Inject(method = "<init>", at = @At("RETURN"))
	private void handleConstructor(CallbackInfo ci) {
		this.maxRadius = Integer.MAX_VALUE;
		this.area = ((WorldBorder)(Object)this).new StaticArea(4294967294D);
	}
}
