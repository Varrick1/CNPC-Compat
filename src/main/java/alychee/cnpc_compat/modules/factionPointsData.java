package alychee.cnpc_compat.modules;

import folk.sisby.switchy.api.SwitchySerializable;
import alychee.cnpc_compat;
import
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;

public class HealthModuleData implements SwitchySerializable {
    public static final String KEY_HEALTH_VALUE = "factionPoints";

    protected static final Identifier ID = new Identifier(CNPCCompat.ID, "FactionPoints");
    protected float factionPoints;

    @Override
    public NbtCompound toNbt() {
        NbtCompound outNbt = new NbtCompound();
        outNbt.putFloat(KEY_HEALTH_VALUE, factionPoints);
        return outNbt;
    }

    @Override
    public void fillFromNbt(NbtCompound nbt) {
        healthValue = nbt.getInt(KEY_HEALTH_VALUE);
    }