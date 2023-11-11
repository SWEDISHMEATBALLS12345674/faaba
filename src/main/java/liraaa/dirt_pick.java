package liraaa;
import net.fabricmc.fabric.mixin.registry.sync.RegistriesAccessor;
import net.minecraft.block.Block;
import net.minecraft.block.FallingBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagBuilder;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import javax.tools.Tool;
import java.util.Vector;



public class dirt_pick extends MiningToolItem {


    public dirt_pick(ToolMaterial material, int attackDamage, float attackSpeed, Item.Settings settings) {
        super((float)attackDamage, attackSpeed, material, dirtpickable, settings);
    }
    private static final TagKey<Block> dirtpickable = TagKey.of(RegistryKeys.BLOCK, new Identifier("liraaa:axe"));
    public boolean ground = false;
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        final DamageSource damage;

        Vec3d p = playerEntity.getRotationVector().multiply(3);
        Boolean l = playerEntity.isOnGround();
        playerEntity.addVelocity(p);
        playerEntity.limitFallDistance();
        world.createExplosion(playerEntity, playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(), 10, World.ExplosionSourceType.BLOCK);
        ground = true;
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }


}
