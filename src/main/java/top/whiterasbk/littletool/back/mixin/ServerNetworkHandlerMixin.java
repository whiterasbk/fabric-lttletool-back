package top.whiterasbk.littletool.back.mixin;

//import net.minecraft.network.listener.ServerPlayPacketListener;
//import net.minecraft.network.listener.TickablePacketListener;
//import net.minecraft.network.packet.s2c.play.PositionFlag;
//import net.minecraft.server.network.PlayerAssociatedNetworkHandler;
//import net.minecraft.server.network.ServerPlayNetworkHandler;
//import net.minecraft.server.network.ServerPlayerEntity;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
//import top.whiterasbk.chimfrp.back.Back;
//
//import java.util.Map;
//import java.util.Set;
//
//@Mixin(ServerPlayNetworkHandler.class)
//public abstract class ServerNetworkHandlerMixin implements PlayerAssociatedNetworkHandler, TickablePacketListener, ServerPlayPacketListener {
//
//    @Shadow
//    public ServerPlayerEntity player;
//
//    @Inject(at = @At("HEAD"), method = "requestTeleport(DDDFFLjava/util/Set;)V", locals = LocalCapture.CAPTURE_FAILHARD)
//    public void requestTeleport(double x, double y, double z, float yaw, float pitch, Set<PositionFlag> flags, CallbackInfo ci) {
//        Back.currentPoints.put(player.getUuid(), Map.entry(player.getPos(), player.getServerWorld()));
//    }
//}
