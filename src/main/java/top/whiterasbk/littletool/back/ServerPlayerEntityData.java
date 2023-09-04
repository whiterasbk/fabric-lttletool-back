package top.whiterasbk.littletool.back;

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public class ServerPlayerEntityData {
    final Vec3d pos;
    final float yaw;
    final float pitch;
    final ServerWorld world;

    ServerPlayerEntityData(ServerPlayerEntity entity) {
        pos = entity.getPos();
        yaw = entity.getYaw();
        pitch = entity.getPitch();
        world = entity.getServerWorld();
    }
}
