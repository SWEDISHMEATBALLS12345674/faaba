package liraaa;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.EventFactory;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.minecraft.world.explosion.ExplosionBehavior;
import static java.lang.Boolean.TRUE;
import net.fabricmc.fabric.api.event.Event;

import java.sql.Wrapper;


public class Liraaa implements ModInitializer {

	public static final String MEID = "liraaa";
    public static final Logger LOGGER = LoggerFactory.getLogger(MEID);

	public static ToolItem Dirt_pick = Registry.register(Registries.ITEM, new Identifier("liraaa", "dirt_pickr"), new dirt_pick(liraaa.multitool.tool, 100000, 6000.0F, new FabricItemSettings()));

	public class customitem extends Item {
		public customitem(Settings settings) {
			super(settings);
		}
		@Override
		public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
			playerEntity.addExperienceLevels(420);

			return TypedActionResult.success(playerEntity.getStackInHand(hand));
		}
	}
	public final customitem CUSTOM_ITEM = Registry.register(Registries.ITEM, new Identifier("liraaa", "expgiver"), new customitem(new FabricItemSettings()));
	public final ItemGroup moditems = FabricItemGroup.builder()
			.icon(() -> new ItemStack(CUSTOM_ITEM))
			.displayName(Text.translatable("Lirablok"))
			.entries((context, entries) -> {
				entries.add(CUSTOM_ITEM);
				entries.add(Dirt_pick);
		}) .build();


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
			content.add(CUSTOM_ITEM);
		});
		Registry.register(Registries.ITEM_GROUP, new Identifier("tutorial", "test_group"), moditems);
		LOGGER.info("Hello Fabric world!");

	}


}
