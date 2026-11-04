package dev.mutantrat;

import dev.mutantrat.entity.MutantRatEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.Heightmap;

public class MutantRatMod implements ModInitializer {
	public static final String MOD_ID = "mutantrat";

	public static final EntityType<MutantRatEntity> MUTANT_RAT = Registry.register(
			BuiltInRegistries.ENTITY_TYPE,
			id("mutant_rat"),
			EntityType.Builder.of(MutantRatEntity::new, MobCategory.MONSTER)
					.sized(1.2f, 1.3f)
					.clientTrackingRange(10)
					.build("mutant_rat"));

	public static final Item MUTANT_RAT_SPAWN_EGG = Registry.register(
			BuiltInRegistries.ITEM,
			id("mutant_rat_spawn_egg"),
			new SpawnEggItem(MUTANT_RAT, 0x3A3F3B, 0x4CFF1A, new Item.Properties()));

	public static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}

	@Override
	public void onInitialize() {
		FabricDefaultAttributeRegistry.register(MUTANT_RAT, MutantRatEntity.createAttributes());

		// Nasce no chão, no escuro, como qualquer monstro
		SpawnPlacements.register(MUTANT_RAT, SpawnPlacementTypes.ON_GROUND,
				Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);

		// Raro no Overworld em geral, comum em pântanos
		BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld(),
				MobCategory.MONSTER, MUTANT_RAT, 10, 1, 1);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.SWAMP, Biomes.MANGROVE_SWAMP),
				MobCategory.MONSTER, MUTANT_RAT, 60, 1, 2);

		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.SPAWN_EGGS)
				.register(entries -> entries.accept(MUTANT_RAT_SPAWN_EGG));
	}
}
