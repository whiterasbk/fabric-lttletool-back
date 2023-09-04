package top.whiterasbk.littletool.back;

import com.mojang.logging.LogUtils;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.entity.Entity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static net.minecraft.server.command.CommandManager.literal;

public class Back implements ModInitializer {

    private static final Map<UUID, ServerPlayerEntityData> savedPoints = new HashMap<>();
    private static final Logger logger = LogUtils.getLogger();

    /**
     * Runs the mod initializer.
     */
    @Override
    public void onInitialize() {

        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) ->
            dispatcher.register(literal("back")
                .executes(context -> {
                    try {
                        Entity entity = context.getSource().getEntity();
                        if (entity instanceof ServerPlayerEntity) {
                            if (!savedPoints.isEmpty() && savedPoints.get(entity.getUuid()) != null) {
                                var des = savedPoints.get(entity.getUuid());
                                ((ServerPlayerEntity) entity).teleport(des.world, des.pos.x, des.pos.y, des.pos.z, des.yaw, des.pitch);
                            } else context.getSource().sendError(Text.literal(entity.getEntityName() + " haven't stored points yet."));
                        } else context.getSource().sendError(Text.literal("only player may execute."));
                    } catch (Exception e) {
                        context.getSource().sendError(Text.literal("sth went wrong."));
                        logger.error(e.getLocalizedMessage());
                    }

                    return 1;
                })
            )
        );
    }

    public static void addRecord(ServerPlayerEntity target) {
        savedPoints.put(target.getUuid(), new ServerPlayerEntityData(target));
        // logger.info(savedPoints.toString());
    }
}

