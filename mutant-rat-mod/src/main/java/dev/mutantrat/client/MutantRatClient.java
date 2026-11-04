package dev.mutantrat.client;

import dev.mutantrat.MutantRatMod;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class MutantRatClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(MutantRatMod.MUTANT_RAT, MutantRatRenderer::new);
	}
}
