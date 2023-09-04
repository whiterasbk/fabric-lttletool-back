package top.whiterasbk.littletool.back.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.s2c.play.PositionFlag;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.whiterasbk.littletool.back.Back;

import java.util.Set;

@Mixin(ServerPlayerEntity.class)
public abstract class PlayerMixins extends PlayerEntity {

    public PlayerMixins(World world, BlockPos pos, float yaw, GameProfile gameProfile) {
        super(world, pos, yaw, gameProfile);
    }

    @Inject(at = @At("HEAD"), method = "onDeath(Lnet/minecraft/entity/damage/DamageSource;)V")
    public void onDeath(CallbackInfo ci) {
        Back.addRecord((ServerPlayerEntity) (Object) this);
    }

    @Inject(at = @At("HEAD"), method = "teleport(Lnet/minecraft/server/world/ServerWorld;DDDLjava/util/Set;FF)Z")
    public void teleport(ServerWorld world, double destX, double destY, double destZ, Set<PositionFlag> flags, float yaw, float pitch, CallbackInfoReturnable<Boolean> cir) {
        Back.addRecord((ServerPlayerEntity) (Object) this);
    }

    @Inject(at = @At("HEAD"), method = "teleport(Lnet/minecraft/server/world/ServerWorld;DDDFF)V")
    public void teleport(ServerWorld targetWorld, double x, double y, double z, float yaw, float pitch, CallbackInfo ci) {
        Back.addRecord((ServerPlayerEntity) (Object) this);
    }
}