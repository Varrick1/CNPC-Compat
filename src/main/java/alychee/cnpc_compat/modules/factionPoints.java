package alychee.cnpc_compat.modules;

import folk.sisby.switchy.api.SwitchyEvents;
import folk.sisby.switchy.api.module.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

public class factionPoints extends factionPointsData implements SwitchyModule, SwitchyModuleTransferable, SwitchyEvents.Init {
    @Override
    public void updateFromPlayer(ServerPlayerEntity player, @Nullable String nextPreset) {
        factionPoints = player.getHealth();
    }

    @Override
    public void applyToPlayer(ServerPlayerEntity player) {
        player.setHealth(factionPoints);
    }

    @Override
    public void onInitialize() {
        SwitchyModuleRegistry.registerModule(ID, HealthModule::new, new SwitchyModuleInfo(
                false,
                SwitchyModuleEditable.OPERATOR,
                Text.translatable("switchy.status.module.health.description"))
                .withDescriptionWhenEnabled(Text.translatable("switchy.status.module.health.enabled"))
                .withDescriptionWhenDisabled(Text.translatable("switchy.status.module.health.disabled"))
                .withDeletionWarning(Text.translatable("switchy.status.module.health.warning"))
        );
    }
}