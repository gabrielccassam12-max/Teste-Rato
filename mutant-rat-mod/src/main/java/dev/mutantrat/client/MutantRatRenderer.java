package dev.mutantrat.client;

import dev.mutantrat.MutantRatMod;
import dev.mutantrat.entity.MutantRatEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

/**
 * Lê automaticamente:
 *  assets/mutantrat/geo/entity/mutant_rat.geo.json
 *  assets/mutantrat/animations/entity/mutant_rat.animation.json
 *  assets/mutantrat/textures/entity/mutant_rat.png (+ mutant_rat_glowmask.png)
 */
public class MutantRatRenderer extends GeoEntityRenderer<MutantRatEntity> {
	public MutantRatRenderer(EntityRendererProvider.Context context) {
		// "head" = osso que vira pra olhar o jogador
		super(context, new DefaultedEntityGeoModel<>(MutantRatMod.id("mutant_rat"), "head"));
		this.addRenderLayer(new AutoGlowingGeoLayer<>(this)); // cristais e rachaduras brilham no escuro
		this.shadowRadius = 0.7f;
	}
}
