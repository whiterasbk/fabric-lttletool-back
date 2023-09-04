package top.whiterasbk.littletool.back.mixin;
//
//import net.minecraft.entity.Entity;
//import net.minecraft.network.packet.s2c.play.PositionFlag;
//import net.minecraft.server.command.ServerCommandSource;
//import net.minecraft.server.command.TeleportCommand;
//import net.minecraft.server.network.ServerPlayerEntity;
//import net.minecraft.server.world.ServerWorld;
//import org.jetbrains.annotations.Nullable;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//import top.whiterasbk.chimfrp.back.Back;
//
//import java.util.Map;
//import java.util.Set;
//
//@Mixin(net.minecraft.server.command.TeleportCommand.class)
//public abstract class TeleportCommandMixin {
//
//    @Inject(at = @At("HEAD"), method = "teleport")
//    private static void injectTeleport(ServerCommandSource source, Entity target, ServerWorld world, double x, double y, double z, Set<PositionFlag> movementFlags, float yaw, float pitch, TeleportCommand.@Nullable LookTarget facingLocation, CallbackInfo ci) {
//        if (target instanceof ServerPlayerEntity) {
//            Back.addRecord((ServerPlayerEntity) target);
//        }
//    }
//}
